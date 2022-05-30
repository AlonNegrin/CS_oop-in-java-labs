public class Screen {
    public Screen() {
    }

    public void displayGreeting() {
        System.out.println("Welcome!");
    }

    public void displayAcctPrompt() {
        System.out.println("Please enter your account number:");
    }

    public void displayPwPrompt() {
        System.out.println("Enter your PIN:");
    }

    public void displayMainMenu() {
        System.out.println("Main menu");
        System.out.println("\t1 - View my balance");
        System.out.println("\t2 - Withdraw cash");
        System.out.println("\t3 - Deposit funds");
        System.out.println("\t4 - Exit");
        System.out.println("Enter a choice:");
    }

    public void displayWithdrawalMenu() {
        System.out.println("Withdrawl menu");
        System.out.println("\t1 - $20\t\t4 - $100");
        System.out.println("\t2 - $40\t\t5 - $200");
        System.out.println("\t3 - $60\t\t6 - Cancel transaction");
        System.out.println("Choose a withdrawl amount:");
    }

    public void displayDepositMenu() {
        System.out.println("How much would you like to deposit?");

    }

    public void displayDeposit(double depo) {
        System.out.printf("Deposit %.1f\n", depo);
    }

    public void displayBalance(Db db) {
        System.out.printf("Your balance is: %.1f\n", db.getBalance());

    }

    public void displayGoodbye() {
        System.out.println("Good bye!");
    }

    public void error(String s) {
        System.err.println(s);
    }
}
