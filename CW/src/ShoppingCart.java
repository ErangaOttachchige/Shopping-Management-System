import java.util.ArrayList;

public class ShoppingCart {

    private static ArrayList<Product> productListForUser = new ArrayList<Product>();;

    public ShoppingCart(){
         ShoppingCart.productListForUser = productListForUser;
    }


    public void addProduct(Product product){
        productListForUser.add(product);                   // This is the addProduct method
    }

    public void removeProduct(Product product){
        productListForUser.remove(product);                // This is the removeProduct method
    }

    public void calculateCost(){
        System.out.println("checkout method");          // This is the calculateCost method
    }

    public Product[] getProductList() {
        return productListForUser.toArray(new Product[0]);      // This is the getProductList method
    }
}
