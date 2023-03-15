package stepdefinitions.ui_stepdef;

import com.github.javafaker.Faker;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.AdminUserManagementPage;
import pages.US016Page;
import pages.US016_NewPatient;
import pages.US021PageKU;
import utilities.Driver;
import utilities.JsUtils;
import utilities.ReusableMethods;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertTrue;
import static utilities.ReusableMethods.waitFor;

public class US016_PatientInfoStepDefs {
    Actions actions = new Actions(Driver.getDriver());
    AdminUserManagementPage adminUserManagementPage = new AdminUserManagementPage();
    US016Page us016Page=new US016Page();
    US016_NewPatient us016_newPatient=new US016_NewPatient();
    Faker faker=new Faker();
    String firstname=faker.name().firstName();
    Random rand = new Random();
//TC02
    @When("user goes to last page")
    public void user_goes_to_last_page() {
        ReusableMethods.waitFor(1);
        JsUtils.clickElementByJS(adminUserManagementPage.LastPageButton);
    }

    @Then("users chose patient last patient and  see the all information")
    public void users_chose_patient_last_patient_and_see_the_all_information() {

            WebElement spView = null;
            while (spView == null) {

                try {
                    waitFor(1);
                    spView = Driver.getDriver().findElement(By.xpath("//tbody/tr[1]/td[3]](//a[@class='btn btn-danger btn-sm'])[1]"));

                } catch (NoSuchElementException e) {
                    waitFor(1);
                    ReusableMethods.clickWithTimeOut(us016Page.NextPage, 1);
                }
            }
            ReusableMethods.clickWithTimeOut(spView, 2);

        Assert.assertTrue(us016Page.SeeUserName.isDisplayed());
        Assert.assertTrue(us016Page.SeeFirstName.isDisplayed());
        Assert.assertTrue(us016Page.SeeLastName.isDisplayed());
        Assert.assertTrue(us016Page.SeeLanguage.isDisplayed());
        Assert.assertTrue(us016Page.CreatedDate.isDisplayed());

    }
    //TC03

    @When("user click on Items&Titles button")
    public void user_click_on_items_titles_button() {
        adminUserManagementPage.ItemsTitles.click();
        ReusableMethods.waitFor(1);
    }
    @When("user click on patient from dropdown menu")
    public void user_click_on_patient_from_dropdown_menu() {
       adminUserManagementPage.PatientDropdown.click();
        ReusableMethods.waitFor(1);
    }
    @Then("user click on Create A New User button")
    public void userClickOnCreateANewUserButton() {
        adminUserManagementPage.CreateANewPatient.click();
    }
    @Then("verify id  always comes after patient creating")
    public void verify_id_always_comes_after_patient_creating() {
        List<WebElement> labels=Driver.getDriver().findElements(By.xpath("//label"));
        List<String> stringLabels=new ArrayList<>();
        for (WebElement w:labels){
            stringLabels.add(w.getText());
        }

        Assert.assertFalse(stringLabels.contains("id"));
    }

//TC04
    @Then("assert that State should be provided as US state and cannot be blank")
    public void assertThatStateShouldBeProvidedAsUSStateAndCannotBeBlank() {
        ReusableMethods.waitFor(1);
        us016_newPatient.patientFirstName.sendKeys(firstname);
        ReusableMethods.waitFor(1);
        us016_newPatient.patientLastName.sendKeys(faker.name().lastName());
        ReusableMethods.waitFor(1);

        SimpleDateFormat dtf =new SimpleDateFormat("YYYY-MM-DD, HH:mm");
        String dob=dtf.format(faker.date().birthday(0,99));
        System.out.println(dob+"  BirthDate");
        us016_newPatient.patientBirthDate.sendKeys(dob);
        ReusableMethods.waitFor(1);
        us016_newPatient.Email.sendKeys(faker.internet().emailAddress());
        ReusableMethods.waitFor(1);
        us016_newPatient.patientPhone.sendKeys(faker.number().digits(10));
        us016_newPatient.patientAdress.sendKeys(faker.address().fullAddress());
        ReusableMethods.waitFor(1);
        us016_newPatient.patientDescription.sendKeys("Any info");
        ReusableMethods.waitFor(1);
        us016_newPatient.patientCountry.click();
        ReusableMethods.waitFor(1);
        us016_newPatient.USA.click();


//        List<WebElement> countryList=Driver.getDriver().findElements(By.xpath("//*[@id=\"patient-country\"]/option"));
//        List<String> countryStringList=new ArrayList<>();
//        for (WebElement w:countryList) {
//            countryStringList.add(w.getText());
//        }
//        int index = rand.nextInt(countryStringList.size());
//        String randomElement = countryStringList.get(index);
//        us016_newPatient.patientCountry.sendKeys(randomElement);

        JsUtils.clickElementByJS(us016_newPatient.saveButton);
        String str=us016_newPatient.creatingAlert.getText();
        System.out.println(str);
       Assert.assertTrue(us016_newPatient.creatingAlert.getText().contains("A new Patient is created with identifier"));


    }
//TC05
    @When("user chooses a patient to delete")
    public void user_chooses_a_patient_to_delete() {
        ReusableMethods.waitFor(2);
       WebElement deletePatient= Driver.getDriver().findElement(By.xpath("//td[contains(text(),'"+firstname+"')]//*[contains(text(),'Delete')]"));
        JsUtils.clickElementByJS(adminUserManagementPage.LastPageButton);
//        WebElement deletePatient = null;
//        while (deletePatient == null) {
//
//            try {
//                waitFor(1);
//                deletePatient = Driver.getDriver().findElement(By.xpath("//*[@id='\"+firstname+\"']//*[contains(text(),'Delete')]"));
//                //
//                JSUtils.clickElementByJS(deletePatient);
//            } catch (NoSuchElementException e) {
//                waitFor(1);
//                ReusableMethods.clickWithTimeOut(us016_newPatient.nextPage, 1);
//            }
//        }
//        JSUtils.clickElementByJS(deletePatient);
    }
    @Then("user click on delete button and confirm to delete")
    public void user_click_on_delete_button_and_confirm_to_delete() {
//        List<WebElement> deleteList=Driver.getDriver().findElements(By.xpath("//a[@class='btn btn-danger btn-sm']"));
//        WebElement lastElement=deleteList.get(deleteList.size()-1);
//        JSUtils.clickElementByJS(lastElement);
//    }

    }
    @Then("verify the patient is not on the list")
    public void verify_the_patient_is_not_on_the_list() {

    }


}
