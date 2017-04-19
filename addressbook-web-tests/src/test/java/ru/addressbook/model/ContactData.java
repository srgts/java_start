package ru.addressbook.model;

/**
 * Created by Админ on 09.04.2017.
 */
public class ContactData {

    private int id;
    private String firstname;
    private String lastname;
    private String group;
    private String homePhone;
    private String mobilePhone;
    private String workPhone;
    private String allPhones;

    public String getAllPhones() {
        return allPhones;
    }

    public ContactData withAllPhones(String allPhones) {
        this.allPhones = allPhones;
        return this;
    }


    public int getId() {
        return id;
    }

    public String getWorkPhone() {
        return workPhone;
    }
    public ContactData withWorkPhone(String workPhone){
        this.workPhone =workPhone;
        return this;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }
    public ContactData withMobilePhone(String mobilePhone){
        this.mobilePhone = mobilePhone;
        return this;
    }

    public String getHomePhone() {
        return homePhone;
    }
    public ContactData withHomePhone(String homePhone){
        this.homePhone = homePhone;
        return this;
    }

    public String getFirstname() {
        return firstname;
    }
    public ContactData withFirstname (String firstname){
        this.firstname = firstname;
        return this;
    }
    public String getLastname() {
        return lastname;
    }
    public ContactData withLastname (String lastname){
        this.lastname = lastname;
        return this;
    }

    public ContactData withId(int id) {
        this.id = id;
        return this;
    }
}
