public interface Discount {
    public static final double DISCOUNT = 0.05; // Premium members get a 5% discount
    public abstract double calculateDiscount(double originalCost); // Will calculate a discount
}
