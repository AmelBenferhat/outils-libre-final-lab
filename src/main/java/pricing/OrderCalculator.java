package main.java.pricing;

public class OrderCalculator {

    public static double calculateSubtotal(double[] prices, int[] quantities) {
        validatePriceAndQuantityArrays(prices, quantities);

        double subtotal = 0.0;
        for (int i = 0; i < prices.length; i++) {
            subtotal += prices[i] * quantities[i];
        }
        return subtotal;
    }

    private static void validatePriceAndQuantityArrays(double[] prices, int[] quantities) {
        if (prices == null || quantities == null) {
            throw new IllegalArgumentException("Prices and quantities must not be null.");
        }
        if (prices.length != quantities.length) {
            throw new IllegalArgumentException("Prices and quantities must have the same length.");
        }
    }
}
