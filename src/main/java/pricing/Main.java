package main.java.pricing;

public class Main {

    public static void main(String[] args) {
        // Sample data
        double[] prices = {10.0, 20.0, 15.0};
        int[] quantities = {2, 1, 3};
        String discountCode = "SAVE10";
        CustomerType customerType = CustomerType.VIP;
        double taxRate = 0.08; // 8%

        // Calculate final price
        double finalPrice = PricingEngine.calculateFinalPrice(prices, quantities, discountCode, customerType, taxRate);

        // Display results
        double subtotal = PricingEngine.calculateSubtotal(prices, quantities);
        double discounted = DiscountService.applyDiscount(subtotal, discountCode, customerType);
        double tax = TaxService.calculateTax(discounted, taxRate);

        System.out.println("Subtotal: $" + subtotal);
        System.out.println("After discount: $" + discounted);
        System.out.println("Tax: $" + tax);
        System.out.println("Final Price: $" + finalPrice);
    }
}
