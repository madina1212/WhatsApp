package dao;
import classes.Profile;
import enums.Status;

import java.util.List;

public interface WhatsAppDao {
    List<Status> getWhatsAppStatus();
    Profile installWhatsApp();
    String changeStatus();
    String addContact();
    String sendMessage(List<Profile>profileList,Profile profiless);
    void DeleteWhatsApp();
    void GoToProfile();
    Profile Images(List<Profile>profileList);
}
