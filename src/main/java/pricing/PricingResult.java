package main.java.pricing;

public class PricingResult {

    private final double subtotal;
    private final double discountedTotal;
    private final double taxAmount;
    private final double finalTotal;

    public PricingResult(double subtotal, double discountedTotal, double taxAmount, double finalTotal) {
        this.subtotal = subtotal;
        this.discountedTotal = discountedTotal;
        this.taxAmount = taxAmount;
        this.finalTotal = finalTotal;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public double getDiscountedTotal() {
        return discountedTotal;
    }

    public double getTaxAmount() {
        return taxAmount;
    }

    public double getFinalTotal() {
        return finalTotal;
    }
}
