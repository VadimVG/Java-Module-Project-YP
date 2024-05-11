import java.util.ArrayList;

public class CalculateProducts {
    private final ArrayList<Product> products= new ArrayList<>();
    private double fullPrice;
    public ArrayList<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product){
        products.add(product);
    }
    public void setFullPrice(double price){
        fullPrice+=price;
    }

    public double getFullPrice() {
        return fullPrice;
    }
}
