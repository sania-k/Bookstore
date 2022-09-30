public class PremiumCustomer extends Customer implements PremiumMembership,Discount{
    private boolean isMonthlyFeePaid; // Keeps track of if the premium customer has paid their monthly fee
    
    // Construtor 
    public PremiumCustomer(String name, double moneySpent){
        super(name);
        super.setMoneySpent(moneySpent); // So that a member's moneySpent can carry over
        isMonthlyFeePaid = false; // Defaults to false (the fee must be paid seperately)
    }

    // Getter for isMonthlyFeePaid
    public boolean isMonthlyFeePaid(){
        return this.isMonthlyFeePaid;
    }

    // From the PremiumMembership interface
    // Pays the customer's monthly fee
    @Override
    public void payMonthlyFee(){
        isMonthlyFeePaid = true;
        double newMoneySpent = super.getMoneySpent() + MONTHLY_FEE;
        super.setMoneySpent(newMoneySpent); // Adds the monthly fee to the moneySpent field
    }
    
    // From the Discount interface
    // Calculates the customer's discount on a product
    @Override
    public double calculateDiscount(double originalCost){
        return originalCost * DISCOUNT;
    }

    // toString method
    @Override
    public String toString(){
        String returnString = this.isMonthlyFeePaid? "": "(unpaid)";
        return returnString + "Premium " + super.toString();
    }
}
