import java.util.ArrayList;

public class Bookstore{
    private ArrayList<Product> inventory;    // Will contain all the products in the store
    private ArrayList<Customer> customers;  // Will track all the customers at the store
    private ArrayList<PremiumCustomer> premiumCustomers; // Will track the premium customers

    // Constructor
    public Bookstore(){
        this.inventory = new ArrayList<Product>();
        this.customers = new ArrayList<Customer>();
        this.premiumCustomers = new ArrayList<PremiumCustomer>();
    }
    // Adds a product (book, cd, or dvd) to the products ArrayList
    public void addProduct(Product newProduct){
        inventory.add(newProduct);
    }

    // Removes a product (book, cd, or dvd) to the products ArrayList
    public void removeProduct(String ID){
        int productIndex = findProduct(ID); // Finds the product's location on its Arraylist

        // Gives a warning if the product couldn't be found
        if (productIndex == -1){ 
            System.out.println("That product does not exist");
            return;
        }

        inventory.remove(productIndex);
    }

    // Finds the product's location on its Arraylist (returns its index)
    public int findProduct(String ID){
        // Loops through the entire products ArrayList
        for (int i = 0; i < inventory.size();i++){
            if (inventory.get(i).getID().equals(ID)) // Looks for a matching ID
                return i;
        }
        return -1; // If the product isn't found, returns -1
    }

    // Finds the customer's location on its Arraylist (returns its index)
    public int findCustomer(String name){
        // Loops through the entire customers ArrayList
        for (int i = 0; i < customers.size();i++){
            if (customers.get(i).getName().equals(name)) // Looks for a matching name
                return i;
        }
        return -1; // If the customer isn't found, returns -1
    }

    // Finds the customer's location on its Arraylist (returns its index)
    public int findPremiumCustomer(String name){
        // Loops through the entire premiumCustomers ArrayList
        for (int i = 0; i < premiumCustomers.size();i++){
            if (premiumCustomers.get(i).getName().equals(name)) // Looks for a matching name
                return i;
        }
        return -1; // If the customer isn't found, returns -1
    }

    // Conducts the purchase of a single product (book, cd, or dvd)
    public void purchase(String name, String ID){
        // if the customer is a premium member, run the premiumPurchase method instead
        if (findPremiumCustomer(name) != -1){
            premiumPurchase(name, ID);
            return;
        }
        
        int productIndex = findProduct(ID); // Finds the product's location on its ArrayList

        // If the product being purchased doesn't exist, cancels the purchase
        if (productIndex == -1){
            System.out.println("That product doesn't exist");
            return;
        }

        int customerIndex = findCustomer(name); // Finds the customer's location on their ArrayList

        // Adds the customer to the customers ArrayList if they aren't on it already
        if (customerIndex == -1){
            customers.add(new Customer(name));
            customerIndex = customers.size()-1; // Updated customerIndex to the new location
        }

        // Gets the cost of the product being bought
        double productCost = inventory.get(productIndex).getCost();

        // Adds the cost of the product to the customer's moneySpent field
        customers.get(customerIndex).setMoneySpent(customers.get(customerIndex).getMoneySpent() + productCost);

        // Removes 1 from the quantity of the product sold from the inventory
        inventory.get(productIndex).setQuantity(inventory.get(productIndex).getQuantity() - 1);

        // Removes product from inventory if there is none of that product left
        if (inventory.get(productIndex).getQuantity() == 0)
            removeProduct(ID);

        System.out.println(name + " has purchased " + inventory.get(productIndex).getName() + " for $" + productCost);
    }

    public void premiumPurchase(String name, String ID){ 
        int productIndex = findProduct(ID); // Finds the product's location on its ArrayList

        // If the product being purchased doesn't exist, cancels the purchase
        if (productIndex == -1){
            System.out.println("That product doesn't exist");
            return;
        }

        int customerIndex = findCustomer(name); // Finds the customer's location on their ArrayList

        // Adds the customer to the customers ArrayList if they aren't on it already
        if (customerIndex == -1){
            customers.add(new Customer(name));
            customerIndex = customers.size()-1; // Updated customerIndex to the new location
        }

        // Gets the cost of the product being bought
        double productCost = inventory.get(productIndex).getCost();

        // Applies the discount
        productCost -= premiumCustomers.get(customerIndex).calculateDiscount(productCost);

        // Makes sure the cost stays at two decimal points ($##.##)
        productCost = ((int) (productCost * 100)) / 100.00;

        // Adds the cost of the product to the customer's moneySpent field
        customers.get(customerIndex).setMoneySpent(customers.get(customerIndex).getMoneySpent() + productCost);

        // Removes 1 from the quantity of the product sold from the inventory
        inventory.get(productIndex).setQuantity(inventory.get(productIndex).getQuantity() - 1);

        // Removes product from inventory if there is none of that product left
        if (inventory.get(productIndex).getQuantity() == 0)
            removeProduct(ID);

        System.out.println(name + " has purchased " + inventory.get(productIndex).getName() + " for $" + productCost);
    }

    // Upgrades a customer from regular to premium
    public void upgrade(String name){
        int customerIndex = findCustomer(name); // Finds the customer's location on their ArrayList

        // If the customer doesn't exist, cancels the upgrade
        if (customerIndex == -1){
            System.out.println("That customer doesn't exist");
            return;
        }

        // If the customer is already a premium member, cancels the upgrade
        if (findPremiumCustomer(name) != -1){
            System.out.println("This customer is already a premium member");
        }

        // Adds a new PremiumCustomer with the same name and moneySpent fields
        premiumCustomers.add(new PremiumCustomer(name, customers.get(customerIndex).getMoneySpent()));

        // Removes the old Customer
        customers.remove(customerIndex);

        System.out.println(name + " has been upgraded to premium!");

    }

    // Pays premium fee
    public void payMonthlyFee(String name){
        int customerIndex = findPremiumCustomer(name); // Finds the customer's location on their ArrayList

        // If the customer isn't a premium member, cancels the payment
        if (customerIndex == -1){
            System.out.println("This customer isn't a premium member!");
            return;
        }

        premiumCustomers.get(customerIndex).payMonthlyFee();

        System.out.println(name + " has paid their premium fee!");
    }

    // Adds to a product's quantity
    public void updateProductQuantity(String ID,int amount){
        int productIndex = findProduct(ID); // Finds the product's location on its ArrayList

        // If the product doesn't exist, cancels the update
        if (productIndex == -1){
            System.out.println("That product doesn't exist");
        }

        // Adds the amount specified to the product's quantity
        inventory.get(productIndex).setQuantity(inventory.get(productIndex).getQuantity() + amount);
    }

    // Prints out the inventory
    public void printInventory(){
        for (int i = 0;i < inventory.size();i++){
            System.out.println("\t" + inventory.get(i));
        }
    }

    // Prints out the customers 
    public void printCustomers(){
        for (int i = 0;i < premiumCustomers.size();i++){
            System.out.println("\t" + premiumCustomers.get(i));
        }
        for (int i = 0;i < customers.size();i++){
            System.out.println("\t" + customers.get(i));
        }
    }

}
