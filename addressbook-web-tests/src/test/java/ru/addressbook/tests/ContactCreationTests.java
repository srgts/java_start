package ru.addressbook.tests;

import org.testng.annotations.Test;
import ru.addressbook.model.ContactData;

import java.io.File;

/**
 * Created by Админ on 29.04.2017.
 */
public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation(){
        app.goTo().homePage();
        app.contact().initContactCreation();
        File photo = new File("src/test/resources/Рекорд.png");
        app.contact().fillContactForm(new ContactData().withFirstname("test_name")
                .withLastname("test_surname").withGroup("test2").withPhoto(photo), true);
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
