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

    /**
     * Calculates the final price including subtotal, discounts, and tax.
     *
     * @param prices       the item prices
     * @param quantities   the item quantities
     * @param discountCode the discount code to apply (can be null)
     * @param customerType the customer type for additional discounts
     * @param taxRate      the tax rate as a decimal (e.g., 0.08 for 8%)
     * @return the final price after all calculations
     */
    public static double calculateFinalPrice(double[] prices, int[] quantities, String discountCode, CustomerType customerType, double taxRate) {
        double subtotal = calculateSubtotal(prices, quantities);
        double discounted = DiscountService.applyDiscount(subtotal, discountCode, customerType);
        double tax = TaxService.calculateTax(discounted, taxRate);
        return discounted + tax;
    }
