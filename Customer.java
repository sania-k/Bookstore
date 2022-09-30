public class Customer{
    private String name;    // Name of the customer
    private double moneySpent;  // Keeps track of the money the customer spends

    // Contructor
    public Customer(String name){
        this.name = name;
        moneySpent = 0; // A customer's moneySpent starts at 0
    }

    // Getter for the customer's name
    public String getName(){
        return this.name;
    }

    // Getter for the moneySpent by the customer
    public double getMoneySpent(){
        return this.moneySpent;
    }

    // Setter for the moneySpent by the customer
    public void setMoneySpent(double newMoneySpent){
        this.moneySpent = newMoneySpent;

        // Makes sure that the moneySpent stays at two decimal points ($##.##)
        this.moneySpent = ((int) (moneySpent * 100)) / 100.00;
    }

    // toString method
    @Override
    public String toString(){
        return "Customer " + this.name + " has spent $" + this.moneySpent;
    }
}