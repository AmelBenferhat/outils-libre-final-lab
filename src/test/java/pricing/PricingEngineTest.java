package test.java.pricing;

import main.java.pricing.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PricingEngineTest {

    @Test
    public void testCalculateSubtotal() {
        double[] prices = {10.0, 20.0, 15.0};
        int[] quantities = {2, 1, 3};
        double expected = 10*2 + 20*1 + 15*3; // 20 + 20 + 45 = 85
        assertEquals(expected, PricingEngine.calculateSubtotal(prices, quantities));
    }

    @Test
    public void testCalculateSubtotalNullPrices() {
        int[] quantities = {1, 2};
        assertThrows(IllegalArgumentException.class, () -> PricingEngine.calculateSubtotal(null, quantities));
    }

    @Test
    public void testCalculateSubtotalNullQuantities() {
        double[] prices = {10.0};
        assertThrows(IllegalArgumentException.class, () -> PricingEngine.calculateSubtotal(prices, null));
    }

    @Test
    public void testCalculateSubtotalMismatchedLengths() {
        double[] prices = {10.0, 20.0};
        int[] quantities = {1};
        assertThrows(IllegalArgumentException.class, () -> PricingEngine.calculateSubtotal(prices, quantities));
    }

    @Test
    public void testApplyDiscountSave10() {
        double subtotal = 100.0;
        String code = "SAVE10";
        double expected = 90.0;
        assertEquals(expected, DiscountService.applyDiscount(subtotal, code));
    }

    @Test
    public void testApplyDiscountSave20() {
        double subtotal = 100.0;
        String code = "SAVE20";
        double expected = 80.0;
        assertEquals(expected, DiscountService.applyDiscount(subtotal, code));
    }

    @Test
    public void testApplyDiscountInvalidCode() {
        double subtotal = 100.0;
        String code = "INVALID";
        double expected = 100.0;
        assertEquals(expected, DiscountService.applyDiscount(subtotal, code));
    }

    @Test
    public void testApplyDiscountVipExtra() {
        double subtotal = 100.0;
        String code = "SAVE10";
        CustomerType type = CustomerType.VIP;
        double discounted = DiscountService.applyDiscount(subtotal, code, type);
        double expected = 90.0 * 0.95; // 10% off then 5% VIP
        assertEquals(expected, discounted);
    }

    @Test
    public void testCalculateFinalPrice() {
        double[] prices = {10.0, 20.0};
        int[] quantities = {1, 1};
        String code = "SAVE10";
        CustomerType type = CustomerType.REGULAR;
        double taxRate = 0.08;
        double subtotal = 30.0;
        double discounted = 27.0; // 10% off
        double tax = 27.0 * 0.08;
        double expected = discounted + tax;
        assertEquals(expected, PricingEngine.calculateFinalPrice(prices, quantities, code, type, taxRate));
    }

    @Test
    public void testCalculateFinalPriceVip() {
        double[] prices = {100.0};
        int[] quantities = {1};
        String code = null;
        CustomerType type = CustomerType.VIP;
        double taxRate = 0.08;
        double subtotal = 100.0;
        double discounted = 95.0; // VIP 5% off
        double tax = 95.0 * 0.08;
        double expected = discounted + tax;
        assertEquals(expected, PricingEngine.calculateFinalPrice(prices, quantities, code, type, taxRate));
    }
}
