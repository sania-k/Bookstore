public class Driver {
    public static void main(String[] args) {
        System.out.println("Book Tests:");
        BookTest.IDOfTheFirstBook();
        BookTest.IDOfTheSecondBook();

        System.out.println("\nDVD Tests:");
        DVDTest.IDOfTheFirstDVD();
        DVDTest.IDOfTheSecondDVD();

        System.out.println("\nCD Tests:");
        CDTest.IDOfTheFirstCD();
        CDTest.IDOfTheSecondCD();

        System.out.println("\nCustomer Tests:");
        CustomerTest.setMoneySpentWithThreeDecimals();
        CustomerTest.setMoneySpentWithOneDecimal();

        System.out.println("\nPremium Customer Tests");
        PremiumCustomerTest.payMonthlyFeeWorks();
        PremiumCustomerTest.calculateDiscountWorks();
        PremiumCustomerTest.toStringWithoutPaidFee();
        PremiumCustomerTest.toStringWithPaidFee();
    }
}
