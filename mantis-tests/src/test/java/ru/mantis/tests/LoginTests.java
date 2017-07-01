package ru.mantis.tests;

import org.testng.annotations.Test;
import ru.mantis.appmanager.HttpSession;

import java.io.IOException;

import static org.testng.Assert.assertTrue;

/**
 * Created by Админ on 01.07.2017.
 */
public class LoginTests extends TestBase {

    @Test
    public void testLogin() throws IOException {
        HttpSession session = app.newSession();
        assertTrue(session.login("administrator", "administrator"));
        assertTrue(session.isLoggedInAs("administrator"));
    }
}
