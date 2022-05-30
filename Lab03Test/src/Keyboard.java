import java.util.Scanner;

public class Keyboard {
    private Scanner s;


    public Keyboard() {
        this.s = new Scanner(System.in);
    }

    public int getAcct() {
        int acc = s.nextInt();
        return acc;
    }

    public String getPassword() {
        String pw = s.next();
        return pw;
    }

    public int getData() {
        int data = s.nextInt();
        return data;
    }
}
