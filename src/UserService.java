public class UserService {

  public void deleteUser(String userId) {

    sendDeletionNotification(userId);
  }

  void sendDeletionNotification(String userId) {

    System.out.println("Notification is sent");
  }
}
