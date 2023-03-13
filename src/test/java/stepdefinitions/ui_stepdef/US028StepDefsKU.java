package stepdefinitions.ui_stepdef;

import com.github.javafaker.Faker;
import io.cucumber.java.en.When;
import org.openqa.selenium.interactions.Actions;
import pages.LoginPageKU;
import pages.US021PageKU;
import pages.US028PageKU;
import utilities.Driver;
import static org.junit.Assert.assertTrue;
import static utilities.Driver.waitForVisibility;
import static utilities.ReusableMethods.clickWithTimeOut;
import static utilities.ReusableMethods.waitFor;

public class US028StepDefsKU {

    LoginPageKU loginPageKU=new LoginPageKU();
    US021PageKU us021PageKU=new US021PageKU();
    US028PageKU us028PageKU=new US028PageKU();

    Actions actions=new Actions(Driver.getDriver());

    Faker faker=new Faker();

    @When("click on ItemsTitles icon and Messages button")
    public void click_on_items_titles_icon_and_messages_button() {

       waitForVisibility(us028PageKU.itemsTitlesIcon,3).click();
       waitForVisibility(us028PageKU.messagesButton, 3).click();


    }


    @When("verify can be on message portal and can view messages authors emails")
    public void verify_can_be_on_message_portal_and_can_view_messages_authors_emails() {

        waitForVisibility(us028PageKU.messagesPortal,5);

        assertTrue(us028PageKU.messagesPortal.isDisplayed());
        assertTrue(us028PageKU.authors.isDisplayed());
        assertTrue(us028PageKU.emails.isDisplayed());
        assertTrue(us028PageKU.messages.isDisplayed());
    }

    @When("create a message and verify")
    public void create_a_message_and_verify() {
    us028PageKU.createmessage.click();

    us028PageKU.mname.sendKeys(faker.name().fullName());
    us028PageKU.memail.sendKeys(faker.internet().emailAddress());
    us028PageKU.msubject.sendKeys("Very important!");
    us028PageKU.mmessage.sendKeys("Sonbahar sanattir digerleri mevsim!");
    clickWithTimeOut(us028PageKU.msaveButton,3);

    waitForVisibility(us028PageKU.malertPath,5);
    // verify 1.method
    assertTrue( Driver.getDriver().getPageSource().contains("A new Message is created"));

    // verify 2.method
    us028PageKU.malertPath.getText().contains("A new Message is created");
    waitFor(6);

    }

    @When("update a message and verify")
    public void updateAMessageAndVerify() {

        clickWithTimeOut(us028PageKU.mID,3);
        waitFor(2);

       clickWithTimeOut(us028PageKU.medit,3);
       waitFor(1);
       us028PageKU.mmessage.clear();
       waitFor(1);
       us028PageKU.mmessage.sendKeys("Yaniliyorsun her mevsim sanat sen goremiyorsun!");

       waitFor(2);
        clickWithTimeOut(us028PageKU.msaveButton,3);

       waitForVisibility(us028PageKU.malertPath,2);
       waitFor(2);

       // verify 1.method
        assertTrue( Driver.getDriver().getPageSource().contains("A Message is updated"));

        // verify 2.method
        us028PageKU.malertPath.getText().contains("A Message is updated");
        waitFor(6);
    }

    @When("delete a message and verify")
    public void deleteAMessageAndVerify() {
        clickWithTimeOut(us028PageKU.mID,3);
        waitFor(2);

        clickWithTimeOut(us028PageKU.mdelete,3);
        waitFor(1);

        clickWithTimeOut(us028PageKU.mconfirmDelete,3);

        waitForVisibility(us028PageKU.malertPath,2);
        waitFor(2);

        // verify 1.method
        assertTrue( Driver.getDriver().getPageSource().contains("A Message is deleted"));

        // verify 2.method
        us028PageKU.malertPath.getText().contains("A Message is deleted");
        waitFor(6);

    }
}
