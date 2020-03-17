package RateLimiter;

import java.time.Instant;

public class SimpleThread extends Thread {

    private RedisService redisService;

    public SimpleThread(String str, int rateLimitPerMinute) {
        super(str);
        redisService = new RedisService(rateLimitPerMinute);
    }

    public void run() {
        for (int i = 1; i <= 70; i++) {
            System.out.println(i + " " + hit("user 1", Instant.now()));
            try {
                sleep(1000);
            } catch (InterruptedException e) {
            }
        }
        System.out.println("DONE! " + getName());
    }


    private boolean hit(String userName, Instant ts) {
        return redisService.requestHit(userName, ts);
    }
}
