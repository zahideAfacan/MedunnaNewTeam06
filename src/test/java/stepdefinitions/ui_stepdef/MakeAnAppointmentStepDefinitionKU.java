package stepdefinitions.ui_stepdef;

import com.github.javafaker.Faker;
import io.cucumber.java.en.When;
import org.openqa.selenium.interactions.Actions;
import pages.LoginPageKU;

import pages.MakeAnAppointmentPageKU;
import utilities.Driver;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;
import static utilities.ReusableMethods.waitFor;

public class MakeAnAppointmentStepDefinitionKU {
    LoginPageKU loginPageKU = new LoginPageKU();
    MakeAnAppointmentPageKU makeAnAppointmentPageKU = new MakeAnAppointmentPageKU();


    Actions actions = new Actions(Driver.getDriver());
    Faker faker = new Faker();

    @When("click on MY PAGE icon and Make an Appointment button")
    public void click_on_my_page_icon_and_make_an_appointment_button() {
        loginPageKU.myPages.click();
        waitFor(2);
        loginPageKU.makeAnAppointment.click();
        waitFor(2);
        makeAnAppointmentPageKU.phone.sendKeys("4443332211");
        waitFor(2);


    }

    @When("enter a valid and unvalid appointment date time and verify")
    public void enter_a_valid_and_unvalid_appointment_date_time_and_verify() {



        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");

        //For Today
        LocalDateTime now = LocalDateTime.now();
        String today= dtf.format(now);
        makeAnAppointmentPageKU.appoDate.sendKeys(today);
        makeAnAppointmentPageKU.sendAnAppointmentRequest.click();
        waitFor(2);
        //Verify that registration message
        assertTrue(Driver.getDriver().getPageSource().contains("Appointment registration saved!"));
        assertFalse(Driver.getDriver().getPageSource().contains("Appointment date can not be past date!"));
        makeAnAppointmentPageKU.appoDate.clear();
        waitFor(2);


        //For Yesterday
        LocalDateTime yest = LocalDateTime.now().minusDays(1);
        String yesterday= dtf.format(yest);
        makeAnAppointmentPageKU.appoDate.sendKeys(yesterday);
        makeAnAppointmentPageKU.sendAnAppointmentRequest.click();
        waitFor(2);
        //Verify that registration message
        assertFalse(Driver.getDriver().getPageSource().contains("Appointment registration saved!"));
        assertTrue(Driver.getDriver().getPageSource().contains("Appointment date can not be past date!"));
        makeAnAppointmentPageKU.appoDate.clear();
        waitFor(2);

        //For Tomorrow
        LocalDateTime tom = LocalDateTime.now().plusDays(1);
        String tomorrow= dtf.format(tom);
        makeAnAppointmentPageKU.appoDate.sendKeys(tomorrow);
        makeAnAppointmentPageKU.sendAnAppointmentRequest.click();
        waitFor(2);
        //Verify that registration message
        assertTrue(Driver.getDriver().getPageSource().contains("Appointment registration saved!"));
        assertFalse(Driver.getDriver().getPageSource().contains("Appointment date can not be past date!"));



    }

}
