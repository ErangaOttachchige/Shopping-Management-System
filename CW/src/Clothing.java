
// This is a subclass of Product and it has two additional attributes: size and color.
public class Clothing extends Product{

    private String size;
    private String color;
        public Clothing(String productID, String productName, int numberOfAvailableItems, double productPrice, String size, String color){
            super(productID, productName, numberOfAvailableItems, productPrice);                  // This is the constructor
            this.size = size;
            this.color = color;
        }

        public String getSize() {
            return size;                               // This is a getter
        }
        public String getColor() {
            return color;                               // This is a getter
        }

    public void setSize(String size) {
        this.size = size;                        // This is a setter
    }
    public void setColor(String color) {
        this.color = color;                        // This is a setter
    }

    @Override
    public String toString() {                                      // This is a toString method
        return "Product ID: " + getProductID() + "\n" +
                "product type: Clothing" + "\n" +
                "Product Name: " + getProductName() + "\n" +
                "Number of Available Items: " + getNumberOfAvailableItems() + "\n" +
                "Product Price: " + getProductPrice() + "\n" +
                "Size: " + getSize() + "\n" +
                "Color: " + getColor() + "\n";
    }

}
