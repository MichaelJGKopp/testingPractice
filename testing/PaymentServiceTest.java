import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

class PaymentServiceTest {

  @Test
  void testProcessPaymentWithDummyLogger() {
    // Create an instance of the PaymentService
    PaymentService paymentService = new PaymentService();

    // Create a dummy Logger object using Mockito
    Logger dummyLogger = mock(Logger.class);

    // Call processPayment with valid payment details
    boolean result =
      paymentService.processPayment(100.0, "1234-5678-9012-3456", dummyLogger);

    // Verify that the payment was processed successfully
    assertTrue(result, "Payment should be processed successfully for valid details");

    // You can verify that the logger was used without caring about its actual behavior
    verify(dummyLogger).info(anyString());
  }

  @Test
  void testProcessPaymentWithInvalidDetails() {
    // Create an instance of the PaymentService
    PaymentService paymentService = new PaymentService();

    // Create a dummy Logger object using Mockito
    Logger dummyLogger = mock(Logger.class);

    // Call processPayment with invalid amount
    boolean result =
      paymentService.processPayment(0, "1234-5678-9012-3456", dummyLogger);

    // Verify that the payment was not processed due to invalid details
    assertFalse(result, "Payment should fail for invalid amount");

    // Verify that the logger was called to log the warning
    verify(dummyLogger).warning(anyString());
  }
}