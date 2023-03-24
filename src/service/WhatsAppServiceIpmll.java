package service;
import classes.Profile;
import dao.WhatsAppDaoImpl;
import enums.Status;
import java.util.List;
public class WhatsAppServiceIpmll implements WhatsAppServicee {
    WhatsAppDaoImpl whatsAppDaoIpml = new WhatsAppDaoImpl();
    @Override
    public void GoToProfile() {
        whatsAppDaoIpml.GoToProfile();
    }

    @Override
    public Profile Images(List<Profile> profileList) {
        return whatsAppDaoIpml.Images(profileList);
    }

    @Override
    public List<Status> getWhatsAppStatus() {
        return whatsAppDaoIpml.getWhatsAppStatus();
    }

    @Override
    public Profile installWhatsApp() {
        return whatsAppDaoIpml.installWhatsApp();
    }

    @Override
    public String changeStatus() {
        return whatsAppDaoIpml.changeStatus();
    }


    @Override
    public String addContact() {
       return whatsAppDaoIpml.addContact();
    }

    @Override
    public String sendMessage(List<Profile>profileList,Profile profiless) {
        return whatsAppDaoIpml.sendMessage(profileList, profiless);
    }
    @Override
    public void DeleteWhatsApp() {
        whatsAppDaoIpml.DeleteWhatsApp();
    }
}
