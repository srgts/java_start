package ru.addressbook.tests;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import ru.addressbook.appmanager.ApplicationManager;
import ru.addressbook.appmanager.BrowserType;
import ru.addressbook.model.GroupData;
import ru.addressbook.model.Groups;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Админ on 18.03.2017.
 */
public class TestBase {
    Logger logger = LoggerFactory.getLogger(TestBase.class);


    protected static final ApplicationManager app = new ApplicationManager(System.getProperty("browser", BrowserType.FIREFOX));

    @BeforeSuite
    public void setUp() throws Exception {
        app.init();
    }

    @AfterSuite (alwaysRun = true)
    public void tearDown() {
        app.stop();
    }

    @BeforeMethod
    public void logTestStart (Method m, Object[] p){
        logger.info("Start" + m.getName() + " with parameters" + Arrays.asList(p));
    }

    @AfterMethod (alwaysRun = true)
    public void logTestStop (Method m){
        logger.info("Stop" + m.getName());
    }

    public void verifyGroupListInUI() {
        if (Boolean.getBoolean("verifyUI")){
            Groups dbGroups = app.db().groups();
            Groups uiGroups = app.group().all();
            assertThat(uiGroups, equalTo(dbGroups.stream()
                    .map((g)-> new GroupData().withId(g.getId()).withName(g.getName()))
                    .collect(Collectors.toSet())));

        }

    }

}
