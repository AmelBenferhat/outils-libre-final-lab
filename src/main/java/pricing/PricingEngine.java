package main.java.pricing;

public class PricingEngine {

    public static double calculateSubtotal(double[] prices, int[] quantities) {
        return OrderCalculator.calculateSubtotal(prices, quantities);
    }

    public static PricingResult calculatePricing(PricingRequest request) {
        double subtotal = OrderCalculator.calculateSubtotal(request.getPrices(), request.getQuantities());
        double discountedTotal = DiscountService.applyDiscount(subtotal, request.getDiscountCode(), request.getCustomerType());
        double taxAmount = TaxService.calculateTax(discountedTotal, request.getTaxRate());
        double finalTotal = discountedTotal + taxAmount;
        return new PricingResult(subtotal, discountedTotal, taxAmount, finalTotal);
    }

    public static double calculateFinalPrice(double[] prices, int[] quantities, String discountCode, CustomerType customerType, double taxRate) {
        PricingRequest request = new PricingRequest(prices, quantities, discountCode, customerType, taxRate);
        return calculatePricing(request).getFinalTotal();
    }
}
