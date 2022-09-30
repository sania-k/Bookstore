import java.util.Scanner;

public class TestHarness {
    public static void main(String[] args) throws InterruptedException {
        Scanner input = new Scanner(System.in);
        Bookstore store = new Bookstore();

        store.addProduct(new Book("Percy Jackson Book 1", 9.99, 15));
        store.addProduct(new Book("Illuminae Book 1", 14.99, 10));
        store.addProduct(new DVD("Tron Legacy", 8.99, 3));
        store.addProduct(new DVD("Anastasia", 9.99, 7));
        store.addProduct(new CD("Far From the Madding City", 10.99, 10));
        store.addProduct(new CD("LOVE, MUSIC AND DANCE", 13.99, 6));

        // Counter allows the loop to keep running until the user choses to exit out
        int counter = 1;
        while (counter == 1){

            // Makes the output more readable
            Thread.sleep(750);

            // Menu for the user to chose from to complete a functionality
            System.out.println("Please choose from the menu by selecting a number:");
            System.out.println("\t1) View Inventory");
            System.out.println("\t2) Complete a Purchase");
            System.out.println("\t3) Upgrade a Member to Premium");
            System.out.println("\t4) Pay Premium Fee");
            System.out.println("\t5) Update Inventory");
            System.out.println("\t6) View All Customers");
            System.out.println("\t7) Exit");

            // Scans the user's input and, based on the menu, carries out a functionality
            int num = input.nextInt();
            switch(num){
                // Viewing the inventory
                case 1:
                    System.out.println("///////////////////");
                    System.out.println("View Inventory");
                    System.out.println("///////////////////");

                    store.printInventory();

                    break;
                // Completing a purchase
                case 2:
                    System.out.println("///////////////////");
                    System.out.println("Complete a Purchase");
                    System.out.println("///////////////////");

                    // Getting the customer's name for the purchase
                    System.out.println("What is the customer's name?");
                    String customer = input.next();
                    
                    // Allows for the purchase to loop until all the products are sold
                    boolean runningPurchase = true;

                    while (runningPurchase){

                        // the ID is needed for each individual product being bought
                        System.out.println("What is the product's ID?");
                        String ID = input.next();

                        // Runs the purchase method
                        store.purchase(customer, ID);

                        // Asks the user if the customer is purchasing anything else
                        System.out.println("Is there anything else " + customer + " would like to purchase? (y/n)");

                        // If the customer has bought all the products they wanted to, the loop stops running
                        if (input.next().equalsIgnoreCase("n"))
                            runningPurchase = false;

                    }

                    break;
                // Upgrade a Member to Premium
                case 3:
                    System.out.println("///////////////////");
                    System.out.println("Upgrade a Member to Premium");
                    System.out.println("///////////////////");

                    // Getting the parameters needed to use the method (name of the member)
                    System.out.println("What is the name of the member?");
                    String member = input.next();

                    // Runs the upgrading method
                    store.upgrade(member);;

                    break;
                // Pay Premium Fee
                case 4:
                    System.out.println("///////////////////");
                    System.out.println("Pay Premium Fee");
                    System.out.println("///////////////////");

                    // Getting the parameter needed to use the method (name of the member)
                    System.out.println("What is the name of the member?");

                    // Runs the upgrading method
                    store.payMonthlyFee(input.next());

                    break;
                // Updating the Inventory
                case 5:
                    System.out.println("///////////////////");
                    System.out.println("Update Inventory");
                    System.out.println("///////////////////");

                    // Checking whether to update an existing product or add another
                    System.out.println("Is the product being updated new?(y/n)");

                    if (input.next().equalsIgnoreCase("n")){ // If the update is to a pre-existing product

                        // Getting the parameter needed to use the method
                        System.out.println("What is the product's ID?");
                        String productID = input.next();

                        System.out.println("What is the quantity of the product being added?");
                        int productQuantity = input.nextInt();

                        store.updateProductQuantity(productID, productQuantity);

                    } else { // If the update is to a new product
                        System.out.println("What is the type of product(book, cd, or dvd)?");
                        String productType = input.next();
                        if (productType.equalsIgnoreCase("book")){ // if a book is being added to the inventory

                            // Getting the parameters needed to add a new product (name, cost, and quantity)
                            System.out.println("What is the book's name?");
                            String bookName = input.next();
                            System.out.println("How much does the book cost?");
                            double bookCost = input.nextDouble();
                            System.out.println("How many copies of the book are in stock?");
                            int bookQuantity = input.nextInt();

                            store.addProduct(new Book(bookName, bookCost, bookQuantity));

                        } else if (productType.equalsIgnoreCase("cd")){ // if a cd is being added to the inventory

                            // Getting the parameters needed to add a new product (name, cost, and quantity)
                            System.out.println("What is the CD's name?");
                            String cdName = input.next();
                            System.out.println("How much does the CD cost?");
                            double cdCost = input.nextDouble();
                            System.out.println("How many copies of the CD are in stock?");
                            int cdQuantity = input.nextInt();

                            store.addProduct(new Book(cdName, cdCost, cdQuantity));

                        } else if (productType.equalsIgnoreCase("dvd")){ // if a dvd is being added to the inventory

                            // Getting the parameters needed to add a new product (name, cost, and quantity)
                            System.out.println("What is the DVD's name?");
                            String dvdName = input.next();
                            System.out.println("How much does the DVD cost?");
                            double dvdCost = input.nextDouble();
                            System.out.println("How many copies of the DVD are in stock?");
                            int dvdQuantity = input.nextInt();

                            store.addProduct(new Book(dvdName, dvdCost, dvdQuantity));

                        } else { // If one of the three types isn't inputted, the update won't run
                            System.out.println("That is not a book, CD, or DVD");
                        }
                    }
                    break;
                // View all customers
                case 6:
                    System.out.println("///////////////////");
                    System.out.println("View All Customers");
                    System.out.println("///////////////////");

                    store.printCustomers();

                    break;
                // Exit
                case 7:
                    System.out.println("///////////////////");
                    System.out.println("Exit");
                    System.out.println("///////////////////"); 

                    // Changes the value of the counter keeping the menu loop running, breaking the loop
                    counter = 0;
                    break;
                // Default in case the user inputs a number not listed
                default:
                    System.out.println("Please enter in a number from 1 - 4");
                    break;                                
            }
        }
        
        System.out.println("Goodbye!");

        input.close();

    }
        
}