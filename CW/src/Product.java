import java.io.Serializable;  // Importing the Serializable class from the java.io package to allow for the serialization of objects

public abstract class Product implements Serializable {
    private String productID;   //(mix of characters and numbers)
    private String productName;
    private int numberOfAvailableItems;
    private double productPrice;

    // Constructor for the Product class
    public Product(String productID, String productName, int numberOfAvailableItems, double productPrice){
        this.productID = productID;
        this.productName = productName;
        this.numberOfAvailableItems = numberOfAvailableItems;
        this.productPrice = productPrice;
    }

    public String getProductID() {
        return productID;                               // This is a getter
    }
    public void setProductID(String productID) {
        this.productID = productID;                     // This is a setter
    }
    public String getProductName() {
        return productName;                             // This is a getter
    }
    public void setProductName(String productName) {
        this.productName = productName;                 // This is a setter
    }
    public int getNumberOfAvailableItems() {
        return numberOfAvailableItems;                  // This is a getter
    }
    public void setNumberOfAvailableItems(int numberOfAvailableItems){
        this.numberOfAvailableItems =   numberOfAvailableItems;         // This is a setter
    }
    public double getProductPrice() {
        return productPrice;                                   // This is a getter
    }
    public void setProductPrice(double productPrice){
        this.productPrice = productPrice;                             // This is a setter
    }

    public String getCategory() {                                       // This is a method that returns the category of the product
        if (this instanceof Electronics) {
            return "Electronics";
        } else if (this instanceof Clothing) {
            return "Clothing";
        } else {
            return "Product";
        }
    }

}
