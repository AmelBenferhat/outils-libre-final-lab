package main.java.pricing;

public class TaxService {

    private static final double DEFAULT_TAX_RATE = 0.08; // 8% tax rate

    /**
     * Calculates tax on a subtotal using the default tax rate.
     *
     * @param subtotal the subtotal amount before tax
     * @return the tax amount
     */
    public static double calculateTax(double subtotal) {
        return calculateTax(subtotal, DEFAULT_TAX_RATE);
    }

    /**
     * Calculates tax on a subtotal using a specified tax rate.
     *
     * @param subtotal the subtotal amount before tax
     * @param taxRate the tax rate as a decimal (e.g., 0.08 for 8%)
     * @return the tax amount
     * @throws IllegalArgumentException if taxRate is negative
     */
    public static double calculateTax(double subtotal, double taxRate) {
        if (taxRate < 0) {
            throw new IllegalArgumentException("Tax rate cannot be negative.");
        }
        return subtotal * taxRate;
    }
}
