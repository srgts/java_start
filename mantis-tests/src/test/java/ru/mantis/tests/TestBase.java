package ru.mantis.tests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.mantis.appmanager.ApplicationManager;
import ru.mantis.appmanager.BrowserType;

import java.io.File;
import java.io.IOException;

/**
 * Created by Админ on 18.03.2017.
 */
public class TestBase {


    protected static final ApplicationManager app = new ApplicationManager(System.getProperty("browser", BrowserType.FIREFOX));

    @BeforeSuite
    public void setUp() throws Exception {
        app.init();
        //app.ftp().upload(new File("src/test/resources/config_inc.php"), "config_inc.php", "config_inc.php.back");
    }

    @AfterSuite (alwaysRun = true)
    public void tearDown() throws IOException {
        //app.ftp().restore("config_inc.php.back", "config_inc.php");
        app.stop();
    }

}
