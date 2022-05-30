public class ClockRunner implements Runnable {

    private final Clock clock;

    public ClockRunner(Clock clock) {
        this.clock = clock;
    }

    @Override
    public void run() {
        while (true) {
            clock.setTime(System.currentTimeMillis());
        }
    }

    public Clock getClock() {
        return clock;
    }
}



