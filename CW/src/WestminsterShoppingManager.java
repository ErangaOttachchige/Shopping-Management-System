import java.io.*;
import java.util.*;

public class WestminsterShoppingManager implements ShoppingManager {

    private static ArrayList<Product> productListForManager;        //    maintains the list of the products in the system

    // Getter method for productListForManager
    public static ArrayList<Product> getProductListForManager() {
        return productListForManager;
    }

    //Constructor for WestminsterShoppingManager
    public WestminsterShoppingManager(){
        productListForManager = new ArrayList<Product>();
    }

    //Main method
    public static void main(String[] args) {
        WestminsterShoppingManager westminsterShoppingManager = new WestminsterShoppingManager(); //create an object of WestminsterShoppingManager
        westminsterShoppingManager.consoleMenu(); //call the consoleMenu method
    }
    //console menu method
    public void consoleMenu() {
        Scanner scanner = new Scanner(System.in); //create a scanner object

        while (true) {
            try {
                System.out.println("Welcome to Westminster Shopping Manager");
                System.out.println("Please select an option from the menu below");
                System.out.println(" 1. Add a product\n 2. Delete a product\n 3. Print the list of products\n 4. Save the list of products\n 5. Load the list of products\n 6. Open GUI for the user\n 7. Exit");
                System.out.println("--------------------------------------------------");
                System.out.println("Please enter your choice: ");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        addProduct();   //call the addProduct method
                        break;

                    case 2:
                        deleteProduct();   //call the deleteProduct method
                        break;

                    case 3:
                        printListOfProducts();  //call the printListOfProducts method
                        break;

                    case 4:
                        saveListOfProducts();  //call the saveListOfProducts method
                        break;

                    case 5:
                        loadListOfProducts(); //call the loadListOfProducts method
                        break;

                    case 6:
                        Gui gui = new Gui(productListForManager); //create an object of Gui class
                        gui.gui(); //call the gui method
                        break;
                    case 7:
                        System.out.println("Thank you for using Westminster Shopping Manager");
                        System.exit(0); //exit the program
                        break;

                    default:
                        System.out.println("Invalid choice");  //if the user enters an invalid choice
                        System.out.println("Please enter a number between 1 and 6"); //display this message
                        System.out.println();
                        break;
                }
            }
            catch (InputMismatchException e) {  //if the user enters an invalid input
                System.out.println("Invalid input");  //display this message
                System.out.println("Please enter an Integer value between 1 and 6");
                System.out.println("--------------------------------------------------");
                System.out.println();
                consoleMenu();
            }
        }
    }

    //methods from the ShoppingManager interface
    @Override
    public void addProduct() {                      //addProduct method
        int maximumNumberOfProducts = 50;           //maximum number of products that can be added to the system
        if (productListForManager.size() < maximumNumberOfProducts) {
            System.out.println(50-productListForManager.size()+" Product entries are left in the system."+"\n");
                while (true) {
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Please select the type of the product to be added");
                    System.out.println("1. Clothing");
                    System.out.println("2. Electronics");
                    System.out.println("--------------------------------------------------");
                    System.out.println("Please enter your choice: ");
                    //try catch block to handle exceptions
                    try {
                        int choice = scanner.nextInt();
                        if (choice == 1) {
                            // Add a new clothing product
                            System.out.println("Please enter the product ID: ");
                            String productID = scanner.next();
                            System.out.println("Please enter the product name: ");
                            String productName = scanner.next();
                            System.out.println("Please enter the number of available items: ");
                            int numberOfAvailableItems = scanner.nextInt();
                            System.out.println("Please enter the product price: ");
                            double productPrice = scanner.nextDouble();
                            System.out.println("Please enter the size: ");
                            String size = scanner.next();
                            System.out.println("Please enter the color: ");
                            String color = scanner.next();
                            Clothing clothing = new Clothing(productID, productName, numberOfAvailableItems, productPrice, size, color); //create an object of Clothing class
                            productListForManager.add(clothing); //add the clothing object to the productListForManager
                            System.out.println("Clothing product added successfully"+ "\n");
                            break;
                        }
                        else if (choice == 2) {
                            // Add a new electronics product
                            System.out.println("Please enter the product ID: ");
                            String productID = scanner.next();
                            System.out.println("Please enter the product name: ");
                            String productName = scanner.next();
                            System.out.println("Please enter the number of available items: ");
                            int numberOfAvailableItems = scanner.nextInt();
                            System.out.println("Please enter the product price: ");
                            double productPrice = scanner.nextDouble();
                            System.out.println("Please enter the brand: ");
                            String brand = scanner.next();
                            System.out.println("Please enter the warranty period in months: ");
                            int warrantyPeriod = scanner.nextInt();
                            Electronics electronics = new Electronics(productID, productName, numberOfAvailableItems, productPrice, brand, warrantyPeriod); //create an object of Electronics class
                            productListForManager.add(electronics);  //add the electronics object to the productListForManager
                            System.out.println("Electronics product added successfully" + "\n");
                            break;
                        }
                        else {
                            System.out.println("Invalid choice");  //if the user enters an invalid choice
                            System.out.println("Please enter a number between 1 and 2"+ "\n"); //display this message
                            continue;
                        }
                    }
                    catch (InputMismatchException e) {        //if the user enters an invalid input
                        System.out.println("Invalid input");  //display this message
                        System.out.println("Please enter an Integer value between 1 and 2"+ "\n");
                        addProduct();
                    }
                    break;
                }
        }
        else {    //if the maximum number of products is reached
            System.out.println("Maximum number of products reached");
            System.out.println("Please delete a product to add a new product" + "\n");
        }
    }
    @Override
    public void deleteProduct() {                 //deleteProduct method
        if(productListForManager.isEmpty()){       //if the productListForManager is empty display this message
            System.out.println("Currently there are no available products in the system.");
            System.out.println("Please add a product to delete a product." + "\n");
            return;
        }
        while (true){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please select the type of the product to be deleted");
            System.out.println("1. Clothing");
            System.out.println("2. Electronics");
            System.out.println("--------------------------------------------------");
            System.out.println("Please enter your choice: ");
            try {
                int choice = scanner.nextInt();
                if (choice == 1) {
                    // Delete a clothing product
                    System.out.println("Please enter the product ID of the clothing product: ");
                    String productID = scanner.next();
                    if (!productListForManager.isEmpty()) {                         //if the productListForManager is not empty
                        for (Product product : productListForManager) {             //iterate through the productListForManager
                            if (product.getProductID().equals(productID)) {         //if the productID entered by the user matches with the productID of a product in the productListForManager
                                productListForManager.remove(product);              //remove the product from the productListForManager
                                System.out.println(productID + " product ID Clothing product deleted successfully");
                                System.out.println();
                                System.out.println("Deleted product details :-" +"\n" + product.toString());
                                System.out.println("Total number of products left in the system is: " + productListForManager.size() + "\n");
                                return;
                            }
                        }
                    }
                    System.out.println("Product with ID: " + productID + " does not exist in the system");  //if the productID entered by the user does not match with the productID of a product in the productListForManager
                    System.out.println();                                                                    //display this message
                    continue;

                }
                else if (choice == 2) {
                    // Delete an electronics product
                    System.out.println("Please enter the product ID: ");
                    String productID = scanner.next();
                    if (!productListForManager.isEmpty()) {                            //if the productListForManager is not empty
                        for (Product product : productListForManager) {                //iterate through the productListForManager
                            if (product.getProductID().equals(productID)) {            //if the productID entered by the user matches with the productID of a product in the productListForManager
                                productListForManager.remove(product);                 //remove the product from the productListForManager
                                System.out.println( productID + " product ID Electronic product deleted successfully");
                                System.out.println();
                                System.out.println("Deleted product details :-" +"\n"+product.toString());
                                System.out.println("Total number of products left in the system is: " + productListForManager.size() + "\n");
                                return;
                            }
                        }
                    }
                    System.out.println("Product with ID: " + productID + " does not exist in the system");
                    System.out.println();
                    continue;
                }
                else {
                    System.out.println("Invalid choice");
                    System.out.println("Please enter a number between 1 and 2" + "\n");
                    continue;
                }
            }
            catch (InputMismatchException e) {
                System.out.println("Invalid input");
                System.out.println("Please enter an Integer value between 1 and 2" + "\n");
                deleteProduct();
            }
            break;
        }
    }

    @Override
    public void printListOfProducts() {      //printListOfProducts method
        System.out.println("List of products in the system");
        System.out.println("--------------------------------------------------");
        System.out.println();
        Collections.sort(productListForManager, Comparator.comparing(Product::getProductID));   //sort the productListForManager according to the productID
        for(Product product : productListForManager){                                           //iterate through the productListForManager
            System.out.println(product.toString());                                             //print the details of each product
        }
    }
    @Override
    public void saveListOfProducts() {                          //saveListOfProducts method
        try{
            FileOutputStream fileOutputStream = new FileOutputStream("products.ser");     //create a fileOutputStream object
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);   //create an objectOutputStream object
            objectOutputStream.writeObject(productListForManager);                              //write the productListForManager to the file
            objectOutputStream.close();                                                         //close the objectOutputStream
            fileOutputStream.close();                                                           //close the fileOutputStream
            System.out.println("All the products saved successfully" + "\n");
        }
        catch (Exception e){                                                            //if an exception occurs
            System.out.println("Error occurred while saving the products");
            e.printStackTrace();                                                //print the stack trace
        }
    }
    @Override
    public void loadListOfProducts() {
        try{
            FileInputStream fileInputStream = new FileInputStream("products.ser");        //create a fileInputStream object
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);       //create an objectInputStream object
            productListForManager = (ArrayList<Product>) objectInputStream.readObject();        //read the productListForManager from the file
            objectInputStream.close();                                                          //close the objectInputStream
            fileInputStream.close();                                                            //close the fileInputStream
            System.out.println("Products loaded successfully" + "\n");
        }
        catch (Exception e){                                                                    //if an exception occurs
            System.out.println("Error occurred while loading the products");                    //print this message
            e.printStackTrace();                                                                //print the stack trace
        }
    }
}

