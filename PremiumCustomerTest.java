public class PremiumCustomerTest {
    private static String mockName;
    private static double mockMoneySpent;
    private static PremiumCustomer mockPremiumCustomer;

    private static void setUp(){
        mockName = "Name";
        mockMoneySpent = 5.0;

        mockPremiumCustomer = new PremiumCustomer(mockName,mockMoneySpent);
    }

    // Tests if the payMonthlyFee works
    public static void payMonthlyFeeWorks(){
        setUp();

        mockPremiumCustomer.payMonthlyFee();

        System.out.println("isMonthlyFeePaid should be true: " + mockPremiumCustomer.isMonthlyFeePaid());
        System.out.println("MoneySpent should be 14.99: " + (14.99 == mockPremiumCustomer.getMoneySpent()));
    }

    // Tests if the calculateDiscount works
    public static void calculateDiscountWorks(){
        setUp();

        double result = mockPremiumCustomer.calculateDiscount(10);

        System.out.println("There should be a discount of 0.5: " + (result == 0.5));
    }

    // Tests if the toString method varies depending on if the monthly fee is paid:
    public static void toStringWithoutPaidFee() {
        setUp();

        boolean result = mockPremiumCustomer.toString().equals("(unpaid)Premium Customer Name has spent $5.0");

        System.out.println("Without paying the fee, the toString should be preceeded with (unpaid): " + result);
    }
    public static void toStringWithPaidFee() {
        setUp();

        mockPremiumCustomer.payMonthlyFee();
        boolean result = mockPremiumCustomer.toString().equals("Premium Customer Name has spent $14.99");

        System.out.println("Without paying the fee, the toString shouldn't be preceeded with (unpaid): " + result);
    }

}
