import org.example.PaymentProcessor;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PaymentProcessorTest {

    @Test
    public void testProcessPaymentAlwaysReturnsTrue() {
        PaymentProcessor processor = new PaymentProcessor();
        boolean result = processor.processPayment("user1", 15.0);
        assertTrue(result);
    }
}
