public class BookTest {
    private static String mockName;
    private static double mockCost;
    private static int mockQuantity;
    private static Book mockBook;

    private static void setUp(){
        mockName = "Name";
        mockCost = 10.00;
        mockQuantity = 10;

        mockBook = new Book(mockName, mockCost, mockQuantity);
    }

    public static void breakdown(){
        mockBook = null;
    }

    // Testing to see if the ID increments properly:

    public static void IDOfTheFirstBook(){
        setUp();
        
        String ID = "B0";

        boolean result = mockBook.getID().equals(ID);
        
        System.out.println("The ID of the first book should be [" + ID + "]: " + result);
    }
    public static void IDOfTheSecondBook(){
        setUp();

        String ID = "B1";

        boolean result = mockBook.getID().equals(ID);
        
        System.out.println("The ID of the second book should be [" + ID + "]: " + result);
    }
}
