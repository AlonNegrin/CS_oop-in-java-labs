import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Lab08Test {

    public static void main(String[] args) throws FileNotFoundException {

        StoreHouse storeHouse = new StoreHouse();
        Map<String, Product> products = new HashMap<>();
        FileReader file = new FileReader(args[0]);
        Scanner s = new Scanner(file);

        String line;
        String action;
        String item;
        int number;

        while (s.hasNext()) {
            line = s.nextLine();
            if(Objects.equals(line, "")){
                System.out.println("Unrecognized operation return\n");
                continue;
            }
            line = line.replaceAll("\\s+", " ");
            String[] lines = line.split(" ");

            action = lines[0];
            item = lines[1];
            number = Integer.parseInt(lines[2]);

            try {
                switch (action) {

                    case "define":
                        Product temProduct = new Product(item, number);
                        storeHouse.defineProduct(temProduct);
                        products.put(item, temProduct);
                        System.out.println(storeHouse.toString());
                        continue;

                    case "order":
                        storeHouse.order(products.get(item), number);
                        break;

                    case "supply":
                        try {
                            storeHouse.supply(products.get(item), number);
                        }
                        catch (NullPointerException e){
                            System.out.println("Unknown product " + item);
                        }
                        break;

                    default:

                }
            } catch (OutOfStockException e) {
                System.out.printf("Product <%s> is out of stock: %d are needed but only %d are in stock.\n",
                        item,number,storeHouse.getStock(products.get(item)));
            }
            catch (OverStockException e){
                System.out.printf("Product <%s> is overstocked:" +
                                "there are %d in stock already, and additional %d are supplied, but there is room for only %d\n",
                        item,storeHouse.getStock(products.get(item)),number,products.get(item).getMaxStock());
            }

            System.out.println(storeHouse.toString());
        }
    }
}
