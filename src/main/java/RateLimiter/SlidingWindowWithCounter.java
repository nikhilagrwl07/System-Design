package RateLimiter;

import java.time.Instant;

public class SlidingWindowWithCounter {


    public static void main(String[] args) {
        SlidingWindowWithCounter ob = new SlidingWindowWithCounter();
        int rateLimitPerMinute = 5; // hits allowed in 60 secs
        new SimpleThread("Main Thread", rateLimitPerMinute).start();
    }


}


