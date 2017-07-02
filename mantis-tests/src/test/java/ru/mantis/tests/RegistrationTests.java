package ru.mantis.tests;

import org.testng.annotations.Test;

/**
 * Created by Админ on 02.07.2017.
 */
public class RegistrationTests extends TestBase {

    @Test
    public void testRegistration(){
        app.registration().start("user1", "user1@localhost.localdomain");
    }
}
