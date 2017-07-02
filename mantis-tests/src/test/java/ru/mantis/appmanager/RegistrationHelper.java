package ru.mantis.appmanager;

import org.openqa.selenium.WebDriver;

/**
 * Created by Админ on 02.07.2017.
 */
public class RegistrationHelper {
    private final ApplicationManager app;
    private WebDriver wd;

    public RegistrationHelper(ApplicationManager app) {
        this.app = app;
        wd = app.getDriver();
    }

    public void start(String username, String mail) {
        wd.get(app.getProperty("web.baseUrl")+ "/signup_page.php");
    }
}
