package classes;
import enums.ProfilePhoto;
import enums.Status;
import java.util.ArrayList;
import java.util.List;
public class Profile {
    private long ID;
    private String userName;
    private String password;
    private String phoneNumber;

    private List<String> message = new ArrayList<>();
    private Status status;
    private List<Contact> contacts;

    public Profile(int id, String phoneNumber, String userName, String password) {
    }

    public void addContact(Contact contact){
        if (contacts==null){
            contacts=new ArrayList<>();
        }
        contacts.add(contact);
    }
    public Profile(long id) {

    }

    public long getID() {
        return ID;
    }

    public Profile() {
        this.ID = ID;
        this.userName = userName;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.message = message;
        this.status = status;
        this.contacts = contacts;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<String> getMessage() {
        return message;
    }

    public void setMessage(List<String> message) {
        this.message = message;
    }

    public Status getStatus(Status status) {
        return this.status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "ID=" + ID +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", message=" + message +
                ", status=" + status +
                ", contacts=" + contacts +
                '}';
    }


    public Status getStatus() {
        return Status.I_LOVE;
    }

    public void setMessage(ProfilePhoto myPhoto) {
    }

    public void setContacts(List<Profile> contact) {
    }
}
