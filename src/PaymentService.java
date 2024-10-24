import java.util.logging.Logger;

public class PaymentService {

  // Method to process the payment
  public boolean processPayment(double amount, String cardNumber, Logger logger) {
    if (amount <= 0 || cardNumber == null || cardNumber.isEmpty()) {
      logger.warning("Invalid payment details");
      return false;
    }

    // Simulate processing the payment
    logger.info("Processing payment of $" + amount + " for card: " + cardNumber);

    return true; // Payment processed successfully
  }
}
