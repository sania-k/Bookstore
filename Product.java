public abstract class Product {
    private String name;
    private double cost;
    private String ID; // An ID makes it easier to search for a product (typically easier to type)
    private int quantity;

    // Constructor
    public Product(String name,double cost,int quantity){
        this.name = name;
        this.cost = cost;
        this.quantity = quantity;
        this.ID = setID();
    }  

    // Getter for the product's name
    public String getName(){
        return this.name;
    }

    // Getter for the product's cost
    public double getCost(){
        return this.cost;
    }
    
    // Getter for the product's ID
    public String getID(){
        return this.ID;
    }

    // Setter for the product's ID
    public abstract String setID(); // The ID will be different depending on the type of product
    
    // Getter for the product's quantity
    public int getQuantity(){
        return this.quantity;
    }

    // Setter for the product's quantity
    public void setQuantity(int newQuantity){
        this.quantity = newQuantity;
    }

    // toString method
    @Override
    public String toString(){
        return getID() + "| Name: " + getName() + ", Cost: $" + getCost() + ", Quantity: " + getQuantity();
    }
}
