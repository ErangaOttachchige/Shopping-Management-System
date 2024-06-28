# Shopping-Management-System
Overview
This project is developed to demonstrate the understanding and application of object-oriented programming principles. The program manages an online shopping system where a manager can add, delete, print, and save products using a console-based interface, and users can interact with the system through a Graphical User Interface (GUI) to select products, add them to a shopping cart, and view the final price.

Objectives
Assess the knowledge and skills in object-oriented programming.
Implement a program with interacting objects to fulfill specified functional requirements.
Problem Analysis
The program is divided into three phases:

Design and Class Implementation
Console Menu Implementation
Graphical User Interface (GUI) Implementation
Phase 1: Design and Class Implementation
UML Diagrams:

UML use case diagram for the system.
UML class diagram.
Class Implementation:

Product (abstract class):
Attributes: product ID, product name, number of available items, price.
Methods: appropriate get/set methods, constructors.
Electronics (subclass):
Attributes: brand, warranty period.
Methods: get/set methods, constructors.
Clothing (subclass):
Attributes: size, color.
Methods: get/set methods, constructors.
User:
Attributes: username, password.
Methods: get/set methods, constructors.
ShoppingCart:
Attributes: list of products.
Methods: add, remove, and calculate total cost.
WestminsterShoppingManager (implements ShoppingManager interface):
Maintains a list of products.
Provides methods for console menu management actions.
Phase 2: Console Menu Implementation
The WestminsterShoppingManager class displays a menu in the console for the manager to:

Add a new product (maximum 50 products).
Delete a product by ID and display details of the deleted product.
Print a list of products sorted alphabetically by product ID.
Save the list of products to a file and read back the information on next start.
Phase 3: Graphical User Interface (GUI) Implementation
The GUI allows the user to:

Select product type from a drop-down menu (all, Electronics, Clothes).
Visualize and sort the list of products.
Select and add products to the shopping cart.
Display product details in a panel below the table.
View the shopping cart and final price, with applicable discounts.
Features
Console-based management interface for adding, deleting, printing, and saving products.
GUI for user interaction, including viewing products, adding to cart and finalizing purchases.
Discounts are applied for specific purchase conditions.
Persistent storage of product information.
Getting Started
Prerequisites
Java Development Kit (JDK) 8 or higher
Integrated Development Environment (IDE) such as IntelliJ IDEA or Eclipse
Installation
Clone the repository:
bash
Copy code
git clone https://github.com/yourusername/online-shopping-system.git
Open the project in your IDE.
Running the Application
Compile and run the WestminsterShoppingManager class for console menu interaction.
From the console menu, select the option to open the GUI for user interaction.
Usage
Use the console menu to manage products (add, delete, print, save).
Use the GUI to select products, add them to the shopping cart, and view the final price.
