public class CDTest {
    private static String mockName;
    private static double mockCost;
    private static int mockQuantity;
    private static CD mockCD;

    private static void setUp(){
        mockName = "Name";
        mockCost = 10.00;
        mockQuantity = 10;

        mockCD = new CD(mockName, mockCost, mockQuantity);
    }

    public static void breakdown(){
        mockCD = null;
    }

    //Testing to see if the ID increments:

    public static void IDOfTheFirstCD(){
        setUp();
        
        String ID = "C0";

        boolean result = mockCD.getID().equals(ID);
        
        System.out.println("The ID of the first DVD should be [" + ID + "]: " + result);
    }
    public static void IDOfTheSecondCD(){
        setUp();

        String ID = "C1";

        boolean result = mockCD.getID().equals(ID);
        
        System.out.println("The ID of the second DVD should be [" + ID + "]: " + result);
    }
}
