public class Lab10Test {
    public static void main(String[] args) {
        Clock clock = new Clock(300);
        ClockRunner runner = new ClockRunner(clock);
        FileCopier fileCopier = new FileCopier("C:\\Users\\baloo\\IdeaProjects\\Labs\\Lab10Test\\many_words.txt");

        Thread thread1 = new Thread(fileCopier);
        Thread thread2 = new Thread(runner);
        thread1.start();
        thread2.start();
    }
}