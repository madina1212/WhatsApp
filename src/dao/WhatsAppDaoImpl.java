package dao;
import classes.Contact;
import classes.Profile;
import enums.ProfilePhoto;
import enums.Status;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static java.lang.System.out;
public class WhatsAppDaoImpl implements WhatsAppDao {
    static long counter;
    List<Profile> profiles = new ArrayList<>();
    @Override
    public void GoToProfile() {
        Scanner scanner = new Scanner(System.in);
        out.println("Enter your userName:");
        String name = scanner.nextLine();
        boolean isFalse = false;
        for (Profile g : profiles) {
            if (g.getUserName().equalsIgnoreCase(name)) {
                System.out.println(g);
                isFalse = false;
                break;
            } else {
                isFalse = true;
            }
        }
        if (isFalse) {
            System.out.println("Мындай группа табылган жок!!!");
        }
    }

    @Override
    public Profile Images(List<Profile>profileList) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter user name:");
            String name = scanner.nextLine();
            System.out.println("Enter password:");
            String password = scanner.nextLine();
            for (Profile p : profiles) {
                if (name.equals(p.getUserName()) && (password.equals(p.getPassword()))) {
                    profiles.add(p);
                }
            }
            if (!profiles.isEmpty()) {
                for (Profile p : profiles) {
                    System.out.println("Current image:" + p.getMessage());
                    System.out.println("~~Images~~");
                    System.out.println("1->MY_PHOTO\n" +
                            "2->DEFAULT_IMAGE\n" +
                            "3->PHOTO_OF_FLOWERS\n"+
                            "4->PHOTO_OF_PARENTS");
                    switch (new Scanner(System.in).nextInt()) {
                        case 1 -> p.setMessage(ProfilePhoto.MY_PHOTO);
                        case 2 -> p.setMessage(ProfilePhoto.DEFAULT_IMAGE);
                        case 3 -> p.setMessage(ProfilePhoto.PHOTO_OF_FLOWERS);
                        case 4 -> p.setMessage(ProfilePhoto.PHOTO_OF_PARENTS);
                    }
                    out.println(p);
                }
            } else {
                throw new MyException("no such profile");
            }

        } catch (MyException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    @Override
    public List<Status> getWhatsAppStatus() {
        out.println("~~~~~~~~~       Whatsapp status      ~~~~~~~~~~~~");
        return List.of(Status.values());

    }

    @Override
    public Profile installWhatsApp() {
        Profile profile = new Profile();
        Scanner scanner = new Scanner(System.in);
        profile.setID(++counter);
        System.out.println("Атынызды жазыныз: ");
        String name = scanner.nextLine();
        profile.setUserName(name);
        System.out.println("Сыр созунузду жазыныз: ");
        String password = scanner.nextLine();
        profile.setPassword(password);
        System.out.println("Телефон номеринизди жазыныз: ");
        int nomeer = scanner.nextInt();
        profile.setPhoneNumber(String.valueOf(nomeer));
        profile.setStatus(Status.I_LOVE);
        return profile;
}


    @Override
    public String changeStatus() {
        try {
            for (Profile s:profiles) {
                out.println("Sizdin uchurdagy statusunuz: " +  s.getStatus());
                out.println("Izmenit da ili net");
                String otvet2 = new  Scanner(System.in).nextLine();
                if (otvet2.equalsIgnoreCase("da")){
                    out.println("Vybraite:");
                    for (Status wh:Status.values()) {
                        out.println(wh);
                    }
                    String tandoo = new  Scanner(System.in).nextLine();
                    for (Profile p:profiles) {
                        p.getStatus(Status.valueOf(tandoo));
                    }
                    out.println("Uspesho!");
                }else break;

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Your status has been set!";
    }


    public String addContact() {
        System.out.println("Enter your userName: ");
        String userName = new Scanner(System.in).nextLine();
        System.out.println("Enter your password: ");
        String password = new Scanner(System.in).nextLine();

        for (Profile profile1 : profiles) {
            if(profile1.getUserName().equals(userName) && profile1.getPassword().equals(password)){
                System.out.println("Enter a phoneNumber: ");
                String phoneNumber = new Scanner(System.in).nextLine();
                System.out.println("Enter a contact userName: ");
                String contactUserName = new Scanner(System.in).nextLine();

                for (Profile profile : profiles) {
                    if(profile.getUserName().equals(contactUserName) && profile.getPhoneNumber().equals(phoneNumber)){
                        List<Profile> contact = new ArrayList<>();
                        contact.add(profile1);
                        profile.setContacts(contact);
                    }
                }
            }
        }
        return "contact added!";
    }
    @Override
    public String sendMessage(List<Profile>profileList,Profile profiless) {
        Scanner scanner = new Scanner(System.in);
        String message = "";
        out.println("Кимге кат жонотосуз? ");
        String userName = scanner.nextLine();
        for (Contact c : profiless.getContacts()) {
            if (userName.equals(c.getFullname())) {
                out.println("Контакт " + c.getFullname() + " табылды");
                while (true) {
                    Scanner scanner1 = new Scanner(System.in);
                    Scanner scanner2 = new Scanner(System.in);
                    out.print("Sms жазын:");
                    message = profiless.getUserName() + ": " + scanner1.nextLine();
                    out.println("Жонотуу (yes/no)?");
                    String otvet = scanner2.nextLine();
                    if (otvet.equalsIgnoreCase("yes")) {
                        out.println(profiless.getUserName() + ":" + message);
                        c.getMeseg().add(message);
                        for (Profile w : profiles) {
                            if (w.getContacts() != null) {
                                for (Contact contact : w.getContacts()) {
                                    if (contact.getPhoneNumber().trim().equals(profiless.getPhoneNumber())) {
                                        for (Contact myContacty : profiless.getContacts()) {
                                            if (w.getPhoneNumber().trim().equals(myContacty.getPhoneNumber())) {
                                                contact.getMeseg().add(message);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    } else {
                        break;
                    }
                }
            } else {
                out.println("Myndai kontakt jok!");
                break;
            }
        }
        return message;
    }



    @Override
    public void DeleteWhatsApp() {
        Scanner scanner = new Scanner(System.in);
        out.println("Enter your userName: ");
        for (Profile profile : profiles) {
            String name = scanner.nextLine();
            if (profile.getUserName().equalsIgnoreCase(name)) {
                this.profiles.remove(profile);
                out.println("WhatsApp ийгиликтуу очурулду!");
                break;
            } else {
                out.println("Мындай адам  жок!!!");
            }
        }
    }
}
