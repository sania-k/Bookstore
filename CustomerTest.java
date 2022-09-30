public class CustomerTest {
    private static String mockName;
    private static Customer mockCustomer;

    private static void setUp(){
        mockName = "Name";

        mockCustomer = new Customer(mockName);
    }

    // Testing if the rounding works in the setMoneySpent method
    public static void setMoneySpentWithThreeDecimals(){
        setUp();
        
        double moneySpent = 0.12;
        mockCustomer.setMoneySpent(0.123);

        boolean result = moneySpent == mockCustomer.getMoneySpent();

        System.out.println("moneySpent should truncate to [" + moneySpent + "]: " + result);

    }

    // Testing if the rounding works in the setMoneySpent method
    public static void setMoneySpentWithOneDecimal(){
        setUp();
        
        double moneySpent = 0.10;
        mockCustomer.setMoneySpent(0.1);

        boolean result = moneySpent == mockCustomer.getMoneySpent();

        System.out.println("moneySpent should be [" + moneySpent + "]: " + result);

    }
}
