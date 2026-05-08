package main.java.pricing;

public class PricingRequest {

    private final double[] prices;
    private final int[] quantities;
    private final String discountCode;
    private final CustomerType customerType;
    private final double taxRate;

    public PricingRequest(double[] prices, int[] quantities, String discountCode, CustomerType customerType, double taxRate) {
        this.prices = prices;
        this.quantities = quantities;
        this.discountCode = discountCode;
        this.customerType = customerType;
        this.taxRate = taxRate;
    }

    public double[] getPrices() {
        return prices;
    }

    public int[] getQuantities() {
        return quantities;
    }

    public String getDiscountCode() {
        return discountCode;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public double getTaxRate() {
        return taxRate;
    }
}
