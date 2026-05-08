package main.java.pricing;

public class Main {

    public static void main(String[] args) {
        // Sample data
        double[] prices = {10.0, 20.0, 15.0};
        int[] quantities = {2, 1, 3};
        String discountCode = "SAVE10";
        CustomerType customerType = CustomerType.VIP;
        double taxRate = 0.08; // 8%

        PricingRequest request = new PricingRequest(prices, quantities, discountCode, customerType, taxRate);
        PricingResult result = PricingEngine.calculatePricing(request);

        System.out.println("Subtotal: $" + result.getSubtotal());
        System.out.println("After discount: $" + result.getDiscountedTotal());
        System.out.println("Tax: $" + result.getTaxAmount());
        System.out.println("Final Price: $" + result.getFinalTotal());
    }
}
