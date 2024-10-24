import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class UserServiceTest {

  @Test
  void deleteUser_whileNotificationSuppressed_verifyBehavior() {

    UserService realUserService = new UserService();
    UserService spyUserService = spy(realUserService);

    // Suppress method sendDeletionNotification that sends a notification
    doNothing().when(spyUserService).sendDeletionNotification(anyString());

    spyUserService.deleteUser("abc");

    verify(spyUserService).deleteUser(anyString());
    verify(spyUserService).sendDeletionNotification(anyString());
  }
}