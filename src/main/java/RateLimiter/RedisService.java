package RateLimiter;

import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class RedisService {

    private int rateLimitPerMinute;

    public RedisService(int rpm) {
        rateLimitPerMinute = rpm;
    }

    // User name to request count mapping for lazy loading
    private Map<String, Integer> userIdToRequestCount = new HashMap<>();

    // User name to request mapping for storing requests for each user
    private Map<String, LinkedList<Request>> userIdToRequest = new HashMap<>();

    public boolean addNewUser(String userName, Instant requestedTs) {
        LinkedList<Request> requests = new LinkedList<>();
        requests.add(new Request(requestedTs, 1));
        userIdToRequest.put(userName, requests);
        userIdToRequestCount.put(userName, 1);
        return true;
    }

    public boolean requestHit(String userName, Instant ts) {
        if (!userIdToRequest.containsKey(userName)) {
            return addNewUser(userName, ts);
        } else {
            if (userIdToRequestCount.get(userName) < rateLimitPerMinute) {
                LinkedList<Request> tmp = userIdToRequest.get(userName);
                tmp.add(new Request(ts, 1));
                userIdToRequest.put(userName, tmp);

                userIdToRequestCount.put(userName, userIdToRequestCount.get(userName) + 1);
                return true;
            } else {
                boolean actionTaken = false;
                for (int i = 0; i < userIdToRequest.get(userName).size(); i++) {
                    Duration duration = Duration.between(userIdToRequest.get(userName).get(i).getTs(), ts);
                    if (duration.getSeconds() >= 60) {
                        userIdToRequest.get(userName).remove(i);
                        userIdToRequestCount.put(userName, userIdToRequestCount.get(userName) - 1);
                        actionTaken = true;
                    } else {
                        break;
                    }
                }

                // case 1 - if some entries are older than 1 minute evict those and insert new entry
                if (actionTaken) {
                    LinkedList<Request> tmp = userIdToRequest.get(userName);
                    tmp.add(new Request(ts, 1));
                    userIdToRequest.put(userName, tmp);

                    userIdToRequestCount.put(userName, userIdToRequestCount.get(userName) + 1);
                    return true;
                }

                // case 2 - if all entries are within 1 minute,
                // then rate has been breached and then return false
                return false;
            }
        }
    }
}

class Request {
    private Instant ts;
    private int count;

    public Request(Instant ts, int count) {
        this.ts = ts;
        this.count = count;
    }

    public Instant getTs() {
        return ts;
    }

    public int getCount() {
        return count;
    }
}