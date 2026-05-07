package main.java.pricing;

public class PricingEngine {

    /**
     * Calculates the subtotal from parallel arrays of prices and quantities.
     *
     * @param prices     the item prices
     * @param quantities the item quantities
     * @return the subtotal as the sum of price * quantity for each item
     * @throws IllegalArgumentException if either array is null or lengths differ
     */
    public static double calculateSubtotal(double[] prices, int[] quantities) {
        if (prices == null || quantities == null) {
            throw new IllegalArgumentException("Prices and quantities must not be null.");
        }
        if (prices.length != quantities.length) {
            throw new IllegalArgumentException("Prices and quantities must have the same length.");
        }

        double subtotal = 0.0;
        for (int i = 0; i < prices.length; i++) {
            subtotal += prices[i] * quantities[i];
        }
        return subtotal;
    }
}
