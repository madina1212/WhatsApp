package service;
import enums.Status;
import java.util.List;
import classes.Profile;
public interface WhatsAppServicee {
    List<Status> getWhatsAppStatus();
    Profile installWhatsApp();
    String changeStatus();
    String addContact();
    String sendMessage(List<Profile>profileList,Profile profiless);
    void DeleteWhatsApp();
    void GoToProfile();
    Profile Images(List<Profile>profileList);
}
