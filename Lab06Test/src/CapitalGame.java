import java.io.FileNotFoundException;
import java.util.Objects;
import java.util.Scanner;

public class CapitalGame {

    Scanner s;
    Capitals capitals;

    public CapitalGame() throws FileNotFoundException {
        this.capitals = new Capitals();
        this.s = new Scanner(System.in);
    }

    public void play() {
        while (true) {
            System.out.print("Enter a country name (\"end\" to exit): \n");
            String guess = s.next();
            if (!Objects.equals(guess, "end")) {
                if (capitals.exactMatch(guess) == null) {
                    String[] countries = capitals.prefixMatch(guess);
                    for (String country : countries) {
                        System.out.printf("The capital of %s is %s\n", country, capitals.exactMatch(country.toLowerCase()));
                    }
                } else {
                    guess = guess.substring(0, 1).toUpperCase() + guess.substring(1).toLowerCase();
                    System.out.printf("The capital of %s is %s\n\n", guess, capitals.exactMatch(guess.toLowerCase()));
                }
            } else {
                break;
            }
        }
        System.out.println("Good bye!");
        s.close();
        System.exit(0);
    }


}
