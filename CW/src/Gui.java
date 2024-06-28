import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Gui extends WestminsterShoppingManager implements ActionListener {

    JComboBox comboBox; // to select the category of products
    JButton button1; // to view the shopping cart
    DefaultTableModel table1; // to display the product list in a table

    ArrayList<Product> products; // to store the product list from the WestminsterShoppingManager class


    // Constructor to initialize the productListForUser, shoppingCart, and user
    public Gui(ArrayList<Product> products) {
        this.products = products;
        ShoppingCart shoppingCart = new ShoppingCart();
        User user = new User();
    }

    // Method to create the GUI for the user
    public void gui() {
        JFrame gui = new JFrame();                              // creating the JFrame for the GUI
        gui.setTitle("Westminster Shopping Center");            // setting the title of the JFrame
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     // setting the default close operation of the JFrame
        gui.setSize(1000, 800);                    // setting the size of the JFrame to 1000 x 800
        gui.setVisible(true);                                  // setting the visibility of the JFrame to true
        gui.setLayout(new BorderLayout());                     // setting the layout of the JFrame to BorderLayout
        gui.setResizable(true);                                // setting the resizable of the JFrame to true




        Demo_handler handler = new Demo_handler();            // creating an object of the Demo_handler class to handle the events

        JPanel p1 = new JPanel();                                                   // creating a JPanel to add the components to the JFrame
        p1.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20));         // setting the layout of the JPanel to FlowLayout
        p1.add(new JLabel("Select Product Category:"));                        // adding a JLabel to the JPanel

        String[] category = { "All", "Electronics", "Clothing" };                   // creating a String array to store the categories of products in the JComboBox
        comboBox = new JComboBox(category);                                         // creating a JComboBox to store the categories of products and adding the String array to it
        comboBox.setBounds(270, 20, 90, 40);                      // setting the bounds of the JComboBox to (270, 20, 90, 40)
        comboBox.addActionListener(this);                                         // adding an ActionListener to the JComboBox to handle the events
        p1.add(comboBox);                                                           // adding the JComboBox to the JPanel to display it on the JFrame

        button1 = new JButton("View the Shopping Cart");                     // creating a JButton to view the shopping cart and adding an ActionListener to it to handle the events
        button1.addActionListener(handler);                                      // adding an ActionListener to the JButton to handle the events and passing the object of the Demo_handler class to it
        p1.add(button1);                                                        // adding the JButton to the JPanel to display it on the JFrame and passing the object of the Demo_handler class to it

        JPanel p2 = new JPanel();                                           // creating a JPanel to add the components to the JFrame
        p2.setLayout(new FlowLayout(FlowLayout.CENTER));                    // setting the layout of the JPanel to FlowLayout
        table1 = new DefaultTableModel();                                   // creating a DefaultTableModel to display the product list in a table

        JTable info = new JTable(table1);                                   // creating a JTable to display the product list in a table and passing the DefaultTableModel to it
        table1.addColumn("<html><b>Product ID<b><html>");            // adding the column names to the table
        table1.addColumn("<html><b>Name<b><html>");
        table1.addColumn("<html><b>Category<b><html>");
        table1.addColumn("<html><b>Price<b><html>");
        table1.addColumn("<html><b>Available Items<b><html>");





        // Displaying the product list in the table
        for (Product p : products) {                    // iterating through the product list
            if (p.getCategory().equals("Electronics")) {        // checking if the category of the product is electronics
                Object[] rowData = {p.getProductID(), p.getProductName(), "Electronics", p.getProductPrice(),p.getNumberOfAvailableItems()}; // creating an object array to store the product details
                table1.addRow(rowData);                         // adding the product details to the table
            } else if (p.getCategory().equals("Clothing")) {   // checking if the category of the product is clothing
                Object[] rowData = {p.getProductID(), p.getProductName(), "Clothing", p.getProductPrice(), p.getNumberOfAvailableItems() };   // creating an object array to store the product details
                table1.addRow(rowData);                     // adding the product details to the table
            }
        }
        p2.add(new JScrollPane(info));                      // adding the JTable to the JPanel to display it on the JFrame

        JPanel p3 = new JPanel(new GridLayout(1, 1, 10, 10));   // creating a JPanel to add the components to the JFrame and setting the layout of the JPanel to GridLayout
        JTextArea tf1 = new JTextArea();                                             // creating a JTextArea to display the product details
        p3.add(tf1);                                                                 // adding the JTextArea to the JPanel to display it on the JFrame
        tf1.setFont(new Font("Arial", Font.BOLD, 15));                   // setting the font of the JTextArea to Arial, bold, and 15

        info.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);             // setting the selection mode of the JTable to single selection mode to select only one row at a time
        info.getSelectionModel().addListSelectionListener(new ListSelectionListener() {   // adding a ListSelectionListener to the JTable to handle the events
            @Override
            public void valueChanged(ListSelectionEvent e) {                         // overriding the valueChanged method of the ListSelectionListener interface to handle the events
                int row = info.getSelectedRow();                                    // getting the selected row from the JTable
                if (row != -1) {                                                        // checking if the selected row is not -1
                    String productID = info.getValueAt(row, 0).toString();          // getting the product ID from the JTable
                    String productName = info.getValueAt(row, 1).toString();        // getting the product name from the JTable
                    String category = info.getValueAt(row, 2).toString();           // getting the category of the product from the JTable
                    String price = info.getValueAt(row, 3).toString();              // getting the price of the product from the JTable
                   // String info1 = info.getValueAt(row, 4).toString();
                    tf1.setText("Selected Product Details: \n" + "\n"+                  // displaying the product details in the JTextArea
                            "Product ID: " + productID + "\n" +
                            "Product Name: " + productName + "\n" +
                            "Category: " + category + "\n" +
                            "Price: " + price + "\n" /*+
                            "Info: " + info1*/);
                }
            }
        });


        JPanel p4 = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 20));   // creating a JPanel to add the components to the JFrame and setting the layout of the JPanel to FlowLayout
        JButton button2 = new JButton("Add to the Shopping Cart");              // creating a JButton to add the product to the shopping cart and adding an ActionListener to it to handle the events
        p4.add(button2);                                                        // adding the JButton to the JPanel to display it on the JFrame

        JPanel p5 = new JPanel(new BorderLayout());                     // creating a JPanel to add the components to the JFrame and setting the layout of the JPanel to BorderLayout
        p5.add(p2, BorderLayout.NORTH);
        p5.add(p3, BorderLayout.CENTER);



        gui.add(p1, BorderLayout.NORTH);
        gui.add(p5, BorderLayout.CENTER);
        gui.add(p4, BorderLayout.SOUTH);


    }

    @Override
    public void actionPerformed(ActionEvent e) {                // overriding the actionPerformed method of the ActionListener interface to handle the events
        if (e.getSource() == comboBox) {                // checking if the event is caused by the JComboBox
            table1.setRowCount(0);                      // clearing the table

            String selectedCategory = comboBox.getSelectedItem().toString();        // getting the selected category from the JComboBox
            for (Product p : products) {                                            // iterating through the product list
                String type;                                                        // creating a String variable to store the category of the product
                if (selectedCategory.equals("All")) {
                    // Display all products
                    if (p instanceof Electronics) {
                        type = "Electronics";                           // checking if the product is an instance of the Electronics class
                    } else if (p instanceof Clothing) {
                        type = "Clothing";                              // checking if the product is an instance of the Clothing class
                    } else {
                        type = "unknown";
                    }
                } else if (selectedCategory.equals("Electronics") && p instanceof Electronics) {        // checking if the selected category is electronics and the product is an instance of the Electronics class
                    type = "Electronics";
                } else if (selectedCategory.equals("Clothing") && p instanceof Clothing) {          // checking if the selected category is clothing and the product is an instance of the Clothing class
                    type = "Clothing";
                } else {
                    type = "unknown";// Skip this product if it doesn't match the selected category
                    continue;
                }
                Object[] rowData = {p.getProductID(), p.getProductName(), type, p.getProductPrice(), p.getNumberOfAvailableItems()};    // creating an object array to store the product details
                table1.addRow(rowData);                // adding the product details to the table
            }
        }
    }

    class Demo_handler implements ActionListener {                      // creating a class to handle the events
        public void actionPerformed(ActionEvent evt) {                  // overriding the actionPerformed method of the ActionListener interface to handle the events
            if (evt.getSource() == button1) {                           // checking if the event is caused by the JButton
                JFrame frame1 = new JFrame("Shopping Cart");        // creating a JFrame to display the shopping cart
                frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   // setting the default close operation of the JFrame
                frame1.setSize(500, 500);                   // setting the size of the JFrame to 500 x 500
                frame1.setLayout(new BorderLayout());                   // setting the layout of the JFrame to BorderLayout
                frame1.setResizable(true);                             // setting the resizable of the JFrame to true
                frame1.setVisible(true);                               // setting the visibility of the JFrame to true

                JPanel c1 = new JPanel();                               // creating a JPanel to add the components to the JFrame
                c1.setLayout(new FlowLayout(FlowLayout.CENTER));        // setting the layout of the JPanel to FlowLayout
                Product[][] data = {};                                  // creating a 2D array to store the product details
                String[] Column = {"Product", "Quantity", "Price"};         // creating a String array to store the column names
                JTable jt = new JTable(data, Column);                   // creating a JTable to display the product details in a table and passing the 2D array and the String array to it
                c1.add(new JScrollPane(jt));                            // adding the JTable to the JPanel to display it on the JFrame

                ShoppingCart sc = new ShoppingCart();                   // creating an object of the ShoppingCart class to get the shopping cart

                JPanel c2 = new JPanel(new GridLayout(1, 2, 5, 5));     // creating a JPanel to add the components to the JFrame and setting the layout of the JPanel to GridLayout
                JTextField tf2 = new JTextField();                          // creating a JTextField to display the total price of the products in the shopping cart
                c2.add(tf2);                                                // adding the JTextField to the JPanel to display it on the JFrame

                frame1.add(c1, BorderLayout.NORTH);                     // adding the JPanel to the JFrame to display it on the JFrame
                frame1.add(c2, BorderLayout.CENTER);
            }
        }
    }

}
