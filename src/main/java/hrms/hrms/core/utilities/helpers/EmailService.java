package hrms.hrms.core.utilities.helpers;

public interface EmailService {
    void send(String email,String name,String link);
    String buildEmail(String name, String link);
}
