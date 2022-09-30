public class DVDTest {
    private static String mockName;
    private static double mockCost;
    private static int mockQuantity;
    private static DVD mockDVD;

    private static void setUp(){
        mockName = "Name";
        mockCost = 10.00;
        mockQuantity = 10;

        mockDVD = new DVD(mockName, mockCost, mockQuantity);
    }

    public static void breakdown(){
        mockDVD = null;
    }

    // Testing if the ID increments

    public static void IDOfTheFirstDVD(){
        setUp();
        
        String ID = "D0";

        boolean result = mockDVD.getID().equals(ID);
        
        System.out.println("The ID of the first DVD should be [" + ID + "]: " + result);
    }
    public static void IDOfTheSecondDVD(){
        setUp();

        String ID = "D1";

        boolean result = mockDVD.getID().equals(ID);
        
        System.out.println("The ID of the second DVD should be [" + ID + "]: " + result);
    }
}
