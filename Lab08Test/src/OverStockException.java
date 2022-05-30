public class OverStockException extends Exception{

    private static final long serialVersionUID = 1L;
    private Product product;
    private int needed;

    public OverStockException() {
    }

    public OverStockException(String message) {
        super(message);
    }

    public OverStockException(String message, Throwable cause) {
        super(message, cause);
    }

    public OverStockException(Throwable cause) {
        super(cause);
    }

    public OverStockException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public OverStockException(Product product, int needed) {
        this.product = product;
        this.needed = needed;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getNeeded() {
        return needed;
    }

    public void setNeeded(int needed) {
        this.needed = needed;
    }



    @Override
    public String toString() {
        return "OverStockException{" +
                "product=" + product +
                ", needed=" + needed +
                '}';
    }
}
