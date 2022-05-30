import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class StoreHouse {

    Map<Product,Integer> map;

    public StoreHouse() {
        this.map = new HashMap<>();
    }

    public void updateStorage(Product product, int amount){
        this.map.put(product, amount);
    }

    public int getStock(Product product){
        return this.map.get(product);
    }

    public void defineProduct(Product product){
        this.map.put(product ,0);
        System.out.println("Defined product " + product.toString());
    }

    public void order(Product product, int amount) throws OverStockException{
        if (map.containsKey(product)) {
            if (this.getStock(product) + amount > product.getMaxStock()) {
                throw new OverStockException();
            } else {
                updateStorage(product, this.map.get(product) + amount);
                System.out.println("Ordered " + amount + " " + product.toString());
            }
        }
        else{
            System.out.println("Unknown product " + product.toString());
        }
    }

    public void supply(Product product, int amount) throws OutOfStockException{
        if (map.containsKey(product)) {
            if (this.getStock(product) - amount < 0) {
                throw new OutOfStockException();
            } else {
                updateStorage(product, this.map.get(product) - amount);
                System.out.println("Supplied " + amount + " " + product.toString());
            }
        }
        else{
            System.out.println("Unknown product " + product.toString());
        }
    }



    @Override
    public String toString() {
        String result = "StoreHouse:\n";
        Set<Product> keySet = map.keySet();
        int i = 1;
        for (Product k : keySet){
            if (map.get(k) == 0){
                continue;
            }
            result = result + "\t" + i +". " + k.toString() + " - " + map.get(k) + "\n";
            i++;
        }
        result = result + "end of list\n";
        return result;
    }
}
