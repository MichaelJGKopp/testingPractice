public class EmailService {

  public boolean sendEmail(String to, String subject, String body) {

    System.out.println("method sendEmail is called");

    if (to == null) {
      return false;
    }

    String emailRegex = "^[\\w+.-]+@[\\w+.-]+$";
    return to.matches(emailRegex);
  }
}
