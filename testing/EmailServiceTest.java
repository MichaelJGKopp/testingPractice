import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class EmailServiceTest {

  private EmailService emailServiceSpy;

  @BeforeEach
  public void setup() {

    emailServiceSpy = spy(new EmailService());
  }

  @Test
  void sendEmail_withSpyService_verifiesMethodCalls() {

    // invokes original method
    when(emailServiceSpy.sendEmail(eq("validEmail"), anyString(), anyString()))
      .thenReturn(true);
    when(emailServiceSpy.sendEmail(eq("invalidEmail"), anyString(), anyString()))
      .thenReturn(false);

   /* // does not invoke original method
    doReturn(true)
      .when(emailServiceSpy).sendEmail(eq("validEmail"), anyString(), anyString());
    doReturn(false)
      .when(emailServiceSpy).sendEmail(eq("invalidEmail"), anyString(), anyString());*/

    boolean validEmail = emailServiceSpy.sendEmail("validEmail", "abc", "abc");
    boolean invalidEmail = emailServiceSpy.sendEmail("invalidEmail", "abc", "abc");

    assertTrue(validEmail);
    assertFalse(invalidEmail);

    verify(emailServiceSpy).sendEmail(eq("validEmail"), anyString(), anyString());
    verify(emailServiceSpy).sendEmail(eq("invalidEmail"), anyString(), anyString());
  }
}