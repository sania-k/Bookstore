public class CD extends Product{
    private static int IDNum = 0;// Keeps track of the ID

    // Constructer
    public CD(String name,double cost,int quantity){
        super(name, cost, quantity);
    }

    // From the product parent class
    // Creates an ID for the new CD
    @Override
    public String setID(){
        String newID = "C" + IDNum;
        IDNum++; // Increments ID so no two CDs have the same ID
        return newID;
    } 
}
