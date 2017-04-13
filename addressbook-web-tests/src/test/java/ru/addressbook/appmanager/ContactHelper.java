package ru.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.addressbook.model.ContactData;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Админ on 09.04.2017.
 */
public class ContactHelper extends HelperBase {
    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public Set<ContactData> all() {
        Set<ContactData> contacts = new HashSet<>();
        List<WebElement> rows = wd.findElements(By.name("entry"));
        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
            String lastname = cells.get(1).getText();
            String firstname = cells.get(2).getText();
            contacts.add(new ContactData().withFirstname(firstname).withLastname(lastname).withId(id));
        }
        return contacts;
    }
    public ContactData infoFromEditForm (ContactData contact){
        initContactModificationById(contact.getId());
        String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
        String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
        String home = wd.findElement(By.name("home")).getAttribute("value");
        String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
        String work = wd.findElement(By.name("work")).getAttribute("value");
        wd.navigate().back();

        return new ContactData().withId(contact.getId()).withFirstname(firstname).withLastname(lastname)
                .withHomePhone(home).withMobilePhone(mobile).withWorkPhone(work);

    }

    private void initContactModificationById (int id){
        WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[value = '%s']", id)));
        WebElement row = checkbox.findElement(By.xpath("./../.."));
        List<WebElement> cells = row.findElements(By.tagName("td"));
        cells.get(7).findElement(By.tagName("a")).click();

        //wd.findElement(By.xpath(String.format("//input[@value='%s']/../../td[8]/a",id))).click();
        //wd.findElement(By.xpath(String.format("tr[.//input[value='%s']]/td[8]/a",id))).click();
        //wd.findElement(By.cssSelector(String.format("a[href='edit.php?id=$s'",id))).click();

    }

}
