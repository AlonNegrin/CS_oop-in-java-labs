import java.util.List;
import java.util.concurrent.locks.Lock;

public class Philosopher implements IPhilosopher {

    private boolean eating;
    private final int place;
    private int count;
    private final int meals;
    private final RandomSleep rs;
    private final Fork leftFork;
    private final Fork rightFork;
    private final Lock lock;

    public Philosopher(int place, List<Fork> forks, int meals, Lock lock) {
        this.eating = false;
        this.place = place;
        this.meals = meals;
        this.rs = new RandomSleep(place * meals);
        this.leftFork = forks.get(place - 1);
        this.rightFork = forks.get(place % IPhilosopher.PHIL_CNT);
        this.lock = lock;
        this.count = 0;
    }

    @Override
    public boolean isEating() {
        return eating;
    }

    @Override
    public int getPlace() {
        return place;
    }

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public void run() {
        while (count < meals) {
            rs.sleep();
            lock.lock();
            synchronized (rightFork) {
                rightFork.setOwner(place);
                synchronized (leftFork) {
                    lock.unlock();
                    leftFork.setOwner(place);
                    eating = true;
                    rs.sleep();
                    count++;
                    eating = false;
                }
                leftFork.setOwner(0);
            }
            rightFork.setOwner(0);
        }
    }
}

