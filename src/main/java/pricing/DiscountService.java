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
     * Applies a discount code and extra VIP discount to a subtotal.
     *
     * @param subtotal the subtotal amount before discount
     * @param code the discount code to apply
     * @param customerType the customer type for additional discounts
     * @return the discounted total
     */
    public static double applyDiscount(double subtotal, String code, CustomerType customerType) {
        double discounted = applyDiscount(subtotal, code);
        if (customerType == CustomerType.VIP) {
            discounted *= 0.95; // Extra 5% discount for VIP
        }
        return discounted;
    }
