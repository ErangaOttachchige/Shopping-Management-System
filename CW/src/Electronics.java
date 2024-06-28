
// This class is a subclass of the Product class and it has two additional attributes: brand and warrantyPeriod.
public class Electronics extends Product{

    private String brand;
    private int warrantyPeriod;

    // Constructor
    public Electronics(String productID, String productName, int numberOfAvailableItems, double productPrice, String brand, int warrantyPeriod){
        super(productID, productName, numberOfAvailableItems, productPrice);
        this.brand = brand;
        this.warrantyPeriod = warrantyPeriod;
    }

    public String getBrand() {
        return brand;                               // This is a getter
    }

    public int getWarrantyPeriod() {
        return warrantyPeriod;                      // This is a getter
    }

    public void setBrand(String brand){
        this.brand = brand;                         // This is a setter
    }

    public void setWarrantyPeriod(int warrantyPeriod){
        this.warrantyPeriod = warrantyPeriod;       // This is a setter
    }

    @Override                                    // This is a toString method
    public String toString() {
        return "Product ID: " + getProductID() + "\n" +
                "product type: Electronics" + "\n" +
                "Product Name: " + getProductName() + "\n" +
                "Number of Available Items: " + getNumberOfAvailableItems() + "\n" +
                "Product Price: " + getProductPrice() + "\n" +
                "Brand: " + getBrand() + "\n" +
                "Warranty Period: " + getWarrantyPeriod() + "\n";
    }
}
