package ru.addressbook.tests;

import org.testng.annotations.Test;
import ru.addressbook.model.ContactData;
import ru.addressbook.model.GroupData;
import ru.addressbook.model.Groups;

import java.io.File;

/**
 * Created by Админ on 29.04.2017.
 */
public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation(){
        Groups groups = app.db().groups();
        File photo = new File("src/test/resources/Record.png");
        ContactData newContact =new ContactData().withFirstname("test_name").withLastname("test_surname").withPhoto(photo)
                .inGroup(groups.iterator().next());
        app.goTo().homePage();
        app.contact().initContactCreation();
        app.contact().fillContactForm(newContact, true);
        app.contact().submitContactCreation();
        app.contact().returnToHomePage();

    }


    @Test (enabled = false)
    public void testCurrentDir(){
        File currentDir = new File(".");
        System.out.println(currentDir.getAbsolutePath());
        File photo = new File("src/test/resources/Рекорд.png");
        System.out.println(photo.getAbsolutePath());
        System.out.println(photo.exists());


    }

}
