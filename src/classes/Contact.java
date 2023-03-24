package classes;

import java.util.ArrayList;
import java.util.List;

public class Contact extends Profile{
    private String phoneNumber;
    private String fullname;
    private List<String > meseg = new ArrayList<>();

    public Contact(String phoneNumber, String fullname) {
        this.phoneNumber = phoneNumber;
        this.fullname = fullname;
    }

    public Contact(String phoneNumber, String fullname, List<String> meseg) {
        this.phoneNumber = phoneNumber;
        this.fullname = fullname;
        this.meseg = meseg;
    }

    @Override
    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public List<String> getMeseg() {
        return meseg;
    }

    public void setMeseg(List<String> meseg) {
        this.meseg = meseg;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", fullname='" + fullname + '\'' +
                ", meseg=" + meseg +
                '}';
    }

}
