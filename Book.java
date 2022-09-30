public class Book extends Product {
    private static int IDNum = 0; // Keeps track of the ID

    // Constructer
    public Book(String name,double cost,int quantity){
        super(name, cost, quantity);
    }

    // From the product parent class
    // Creates an ID for the new book
    @Override
    public String setID(){
        String newID = "B" + IDNum;
        IDNum++; // Increments ID so no two books have the same ID
        return newID;
    }
    
}
