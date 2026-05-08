package main.java.pricing;

public class DiscountService {

    public static final String SAVE10 = "SAVE10";
    public static final String SAVE20 = "SAVE20";

    /**
     * Applies a discount code to a subtotal.
     *
     * @param subtotal the subtotal amount before discount
     * @param code the discount code to apply
     * @return the discounted total, or the original subtotal if code is invalid or null
     */
    public static double applyDiscount(double subtotal, String code) {
        if (code == null || subtotal <= 0) {
            return subtotal;
        }

        switch (code.trim().toUpperCase()) {
            case SAVE10:
                return subtotal * 0.90;
            case SAVE20:
                return subtotal * 0.80;
            default:
                return subtotal;
        }
    }

    /**
     * Returns the discount percentage for a supported code.
     *
     * @param code the discount code
     * @return 0.0 for unsupported codes, 0.10 for SAVE10, 0.20 for SAVE20
     */
    public static double getDiscountRate(String code) {
        if (code == null) {
            return 0.0;
        }

        switch (code.trim().toUpperCase()) {
            case SAVE10:
                return 0.10;
            case SAVE20:
                return 0.20;
            default:
                return 0.0;
        }
    }
}
