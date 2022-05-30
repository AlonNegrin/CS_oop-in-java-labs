
public class Atm {
    private Screen scr;
    private Keyboard kbd;
    private Db db;

    public Atm(String dbName) {
        this.db = new Db(dbName);
        this.scr = new Screen();
        this.kbd = new Keyboard();
    }

    public void go() {
        int acc;
        String pw;
        do {
            scr.displayGreeting();
            scr.displayAcctPrompt();
            acc = kbd.getAcct();
            scr.displayPwPrompt();
            pw = kbd.getPassword();
        }
        while (!db.verify(acc, pw));

        int data = 4;
        do {
            scr.displayMainMenu();
            data = kbd.getData();
            switch (data) {
                case 1:
                    scr.displayBalance(this.db);
                    break;

                case 2:
                    scr.displayWithdrawalMenu();
                    int with = kbd.getData();
                    switch (with) {
                        case 1:
                            this.db.setBalance(-20.0);
                            System.out.println("Withdrew 20.0");
                            break;
                        case 2:
                            this.db.setBalance(-40.0);
                            System.out.println("Withdrew 40.0");
                            break;
                        case 3:
                            this.db.setBalance(-60.0);
                            System.out.println("Withdrew 60.0");
                            break;
                        case 4:
                            this.db.setBalance(-100.0);
                            System.out.println("Withdrew 100.0");
                            break;
                        case 5:
                            this.db.setBalance(-200.0);
                            System.out.println("Withdrew 200.0");
                            break;
                        default:
                            System.exit(0);
                            break;
                    }
                    break;

                case 3:
                    scr.displayDepositMenu();
                    double depo = kbd.getData();
                    if (depo > 0) {
                        this.db.setBalance(depo);
                        scr.displayDeposit(depo);
                    }
                    break;

                case 4:
                    break;

                default:
                    scr.error("Invalid option " + data);
            }
        } while (data != 4);
        scr.displayGoodbye();
    }

}




