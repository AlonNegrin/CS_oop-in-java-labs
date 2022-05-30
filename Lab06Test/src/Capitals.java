import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Capitals {

    private final HashMap<String, String> map;
    private int records;


    public Capitals() throws FileNotFoundException {
        File file = new File("capitals.txt");
        Scanner s = new Scanner(file);
        this.map = new HashMap<>();
        s.useDelimiter("[;\n]");
        while (s.hasNext()) {
            this.records++;
            map.put(s.next(), s.next());
        }
        System.out.printf("%d records read.\n", records);
        s.close();
    }


    private String fixText(String text) {
        text = text.toLowerCase();
        // stores each characters to a char array
        char[] charArray = text.toCharArray();
        boolean foundSpace = true;
        for (int i = 0; i < charArray.length; i++) {

            // if the array element is a letter
            if (Character.isLetter(charArray[i])) {

                // check space is present before the letter
                if (foundSpace) {

                    // change the letter into uppercase
                    charArray[i] = Character.toUpperCase(charArray[i]);
                    foundSpace = false;
                }
            } else {
                // if the new character is not character
                foundSpace = true;
            }
        }

        // convert the char array to the string
        text = String.valueOf(charArray);
        return text;
    }


    public String exactMatch(String country) {
        country = this.fixText(country);
        Set<String> keys = this.map.keySet();
        if (keys.contains(country)) {
            return this.map.get(country);
        }
        return null;
    }

    public String[] prefixMatch(String prefix) {
        prefix = this.fixText(prefix);
        ArrayList<String> results = new ArrayList<>();
        Set<String> keys = this.map.keySet();
        for (String k : keys) {
            if (k.startsWith(prefix)) {
                results.add(k);
            }
        }
        return results.toArray(new String[results.size()]);
    }


}


