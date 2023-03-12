package stepdefinitions.ui_stepdef;

import com.beust.ah.A;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_old.Ac;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SourceType;
import pages.*;
import utilities.Driver;
import utilities.ReusableMethods;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.*;
import java.util.List;

import static java.awt.SystemColor.window;

public class US027_SendContactMessage {
    MD_AdminPage md_adminPage = new MD_AdminPage();
    MessagePageMD messagePageMD = new MessagePageMD();
    Faker faker = new Faker();
    Map<String, String> contactMessageDetails = new HashMap<>();
    Actions actions = new Actions(Driver.getDriver());
    AppointmentPage appointmentPage = new AppointmentPage();

    @When("user clicks contact link")
    public void user_clicks_contact_link() {

        WebElement contact = Driver.getDriver().findElement(By.xpath("//*[@id=\"header-tabs\"]/li[6]/a/span"));
        contact.click();
    }


    @When("user sends name and surname")
    public void user_sends_name_and_surname() {
        String fullName = faker.name().fullName();
        contactMessageDetails.put("fullName", fullName);
        ReusableMethods.waitFor(2);
        messagePageMD.contactNameSurname.sendKeys(fullName);
    }

    @When("user sends email")
    public void user_sends_email() {
        String email = faker.internet().emailAddress();
        contactMessageDetails.put("Email", email);
        ReusableMethods.waitFor(2);
        messagePageMD.contactEmail.sendKeys(email);
    }

    @When("user sends subject")
    public void user_sends_subject() {
        String subject = "User Login and Appointment Status";
        contactMessageDetails.put("Subject", subject);
        ReusableMethods.waitFor(2);
        messagePageMD.contactSubject.sendKeys(subject);

    }

    @When("user sends a message")
    public void user_sends_a_message() {
        String message = faker.lorem().sentence(10);
        contactMessageDetails.put("Message", message);
        ReusableMethods.waitFor(2);
        messagePageMD.contactMessage.sendKeys(message);
    }

    @Then("user patient click send  button")
    public void user_patient_click_send_button() {
        messagePageMD.mesageSubmit.click();
        ReusableMethods.waitFor(3);
    }

    @Then("user checks the message success")
    public void user_checks_the_message_success() throws InterruptedException {
        String successMessage = messagePageMD.successMessage.getText();
        System.out.println("Message " + successMessage);
        Assert.assertTrue(successMessage.contains("Your message has been received"));
        System.out.println(contactMessageDetails);
        Thread.sleep(5);

    }

    @Then("user admin clicks Messages")
    public void user_admin_clicks_messages() {

        md_adminPage.Messages.click();
        ReusableMethods.waitFor(2);
        //WebElement tableIDHeader = Driver.getDriver().findElement(By.xpath("//table[@class='table']//thead//tr//th[1]"));

    }

    @Then("user admin verifies created message")
    public void user_admin_verifies_created_message() throws InterruptedException {

        List<LinkedHashMap<String, String>> allTableData = new ArrayList<LinkedHashMap<String, String>>();
        LinkedHashMap<String, String> eachRowData = new LinkedHashMap<>();
        List<String> allHeaderNames = new ArrayList<String>();
        for (int i = 0; i < appointmentPage.tableHeader.size() - 1; i++) {
            String headerName = appointmentPage.tableHeader.get(i).getText();
            allHeaderNames.add(headerName);
            System.out.println("Header Size " + allHeaderNames.size() + "All Header Names   " + allHeaderNames);
        }


    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        while (true) {
            // Scroll down to the bottom
            js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

            // Wait for the page to load
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // Check if we have reached the bottom of the page
            boolean isBottomReached = (boolean) js.executeScript(
                    "return (window.innerHeight + window.scrollY) >= document.body.offsetHeight;");
            if (isBottomReached) {
                break;
            }
        }
Thread.sleep(3);
        List<WebElement> row = Driver.getDriver().findElements(By.xpath("//*[@id='app-view-container']//table/tbody/tr"));

        for (int j = 1; j <= row.size(); j++) {
            List<WebElement> allColumnsElements = Driver.getDriver().findElements(By.xpath("//*[@id='app-view-container']//table/tbody/tr[" + j + "]//td"));

            for (int k = 0; k < allHeaderNames.size(); k++) {
                String cellValue = allColumnsElements.get(k).getText();
                // System.out.println("allColumnsElements   ...... " + allColumnsElements.get(k).getText());
                eachRowData.put(allHeaderNames.get(k), cellValue);
            }
            allTableData.add(eachRowData);
        }
        System.out.println("allTableData  "+allTableData.get(0).get("Name"));
            Map<String, String> messageInfo = new HashMap<>();
         System.out.println("allTableData    "+allTableData.size());
        System.out.println("Email   "+ contactMessageDetails.get("Email"));
            for (int i=0;i<allTableData.size();i++) {

               if(allTableData.get(i).get("Email").equals(contactMessageDetails.get("Email"))) {
                   messageInfo.put("Email",contactMessageDetails.get("Email"));
                   messageInfo.put("fullName",contactMessageDetails.get("fullName"));
                   messageInfo.put("Subject",contactMessageDetails.get("Subject"));

               }

                }
            Assert.assertEquals(contactMessageDetails.get("Email"),messageInfo.get("Email"));
        System.out.println(messageInfo.get("Email"));
            Assert.assertEquals(contactMessageDetails.get("fullName"),messageInfo.get("fullName"));
        System.out.println(messageInfo.get("fullName"));
            Assert.assertEquals(contactMessageDetails.get("Subject"),messageInfo.get("Subject"));
        System.out.println(messageInfo.get("Subject"));
            }

        }







