public class DVD extends Product { 
    private static int IDNum = 0;// Keeps track of the ID

    // Constructer
    public DVD(String name,double cost,int quantity){
        super(name, cost, quantity);
    }

    // From the product parent class
    // Creates an ID for the new DVD
    @Override
    public String setID(){
        String newID = "D" + IDNum;
        IDNum++; // Increments ID so no two DVDs have the same ID
        return newID;
    }
}