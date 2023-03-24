
import classes.Contact;
import classes.Profile;
import service.WhatsAppServiceIpmll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        WhatsAppServiceIpmll whatsAppServiceIpmll = new WhatsAppServiceIpmll();
        List<Profile> profiles = new ArrayList<>();
        Profile profile = new Profile();
        List<Profile> profileList = new ArrayList<>();
        while (true){
            System.out.println("<<<<which methods you choose>>>>");
            System.out.println("""
                1 -> installWhatsApp
                2 -> goToProfile
                3 -> getWhatsAppStatus
                4 -> Images
                5 -> changeStatus
                6 -> addContact,
                7 -> sendMessage,
                8 -> DeleteWhatsApp
                """);
            Scanner scanner = new Scanner(System.in);
            int number = scanner.nextInt();
            switch (number) {
                case 1 -> System.out.println(whatsAppServiceIpmll.installWhatsApp());
                case 2 -> whatsAppServiceIpmll.GoToProfile();
                case 3 -> System.out.println(whatsAppServiceIpmll.getWhatsAppStatus());
                case 4 -> System.out.println(whatsAppServiceIpmll.Images(profileList));
                case 5 -> System.out.println(whatsAppServiceIpmll.changeStatus());
                case 6 -> System.out.println(whatsAppServiceIpmll.addContact());
                case 7 -> System.out.println(whatsAppServiceIpmll.sendMessage(profiles,profile));
                case 8 -> whatsAppServiceIpmll.DeleteWhatsApp();
            }
        }

    }
}