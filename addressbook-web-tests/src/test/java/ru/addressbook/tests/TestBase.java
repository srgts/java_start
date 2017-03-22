package ru.addressbook.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.addressbook.appmanager.ApplicationManager;
import ru.addressbook.appmanager.BrowserType;

/**
 * Created by Админ on 18.03.2017.
 */
public class TestBase {

    protected final ApplicationManager app = new ApplicationManager(BrowserType.IE);

    @BeforeMethod
    public void setUp() throws Exception {
        app.init();
    }

    @AfterMethod
    public void tearDown() {
        app.stop();
    }

}
