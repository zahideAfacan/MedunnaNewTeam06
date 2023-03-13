package stepdefinitions.ui_stepdef;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.US10_HomePage;
import pages.US10_LoginPage;
import pages.US10_PatientUpdatePage;
import pages.US10_SearchPatientPage;
import pages.US10_StaffHomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.JsUtils;
import utilities.ReusableMethods;

public class US10_StepDef_Staff {
    US10_HomePage homePage = new US10_HomePage();
    US10_LoginPage loginPage = new US10_LoginPage();
    US10_StaffHomePage staffHomePage = new US10_StaffHomePage();
    US10_SearchPatientPage searchPatientPage = new US10_SearchPatientPage();
    US10_PatientUpdatePage patientUpdatePage = new US10_PatientUpdatePage();


    @Given("Launch browser and navigate to medunna.com")
    public void user_navigates_to_medunna_url() {
        Driver.getDriver().get(ConfigReader.getProperty("medunna_url"));
    }

    @Then("Staff navigates to the sign in page")
    public void staff_navigates_to_the_sign_in_page() {
        homePage.signInClickIcon.click();
        homePage.signInLink.click();


    }
    @Then("Staff signs in")
    public void staff_signs_in() {
        loginPage.usernameInput.sendKeys("99");
        loginPage.passwordInput.sendKeys("0000");
        loginPage.signInButton.click();
    }
    @Then("Staff clicks on My Pages link")
    public void staff_clicks_on_my_pages_link() {
        Driver.wait(2);
        staffHomePage.myPagesLink.click();
    }

    @Then("Staff clicks on Search Patient link")
    public void staff_clicks_on_search_patient_link() {
        staffHomePage.searchPatientLink.click();
    }

    @Then("Staff enters the patient SSN number")
    public void staff_enters_the_patient_ssn_number() {
        ReusableMethods.waitFor(1);
        searchPatientPage.ssnBox.sendKeys("500-03-03");
    }
    @Then("Staff clicks on Edit Button")
    public void staff_clicks_on_edit_button() {
        ReusableMethods.waitFor(3);
        JsUtils.clickElementByJS(searchPatientPage.editButton);
    }

    @Then("Staff edits firstname")
    public void staff_edits_firstname() {
        ReusableMethods.waitFor(1);
        patientUpdatePage.firstName.sendKeys(Keys.chord(Keys.CONTROL, "a"), Faker.instance().name().firstName());
    }

    @Then("Staff edits lastname")
    public void staff_edits_lastname() {
        Driver.wait2(1);
        patientUpdatePage.lastName.sendKeys(Keys.chord(Keys.CONTROL, "a"), Faker.instance().name().lastName());
    }

    @Then("Staff edits birthdate")
    public void staff_edits_birthdate() {
        ReusableMethods.waitFor(1);
        WebElement webElement = patientUpdatePage.birthDate;
        patientUpdatePage.birthDate.sendKeys("1998");
        webElement.sendKeys(Keys.TAB);
        ReusableMethods.waitFor(1);
        patientUpdatePage.birthDate.sendKeys("12");
        ReusableMethods.waitFor(1);
        patientUpdatePage.birthDate.sendKeys("01");
        ReusableMethods.waitFor(1);
        patientUpdatePage.birthDate.sendKeys("09");
        ReusableMethods.waitFor(1);
        patientUpdatePage.birthDate.sendKeys("00");
        patientUpdatePage.birthDate.sendKeys("AM");
    }

    @Then("Staff edits email")
    public void staff_edits_email() {
        Driver.wait2(1);
        patientUpdatePage.email.sendKeys(Keys.chord(Keys.CONTROL, "a"), Faker.instance().internet().emailAddress());

    }

    @Then("Staff edits phone")
    public void staff_edits_phone() {
        ReusableMethods.waitFor(1);
        patientUpdatePage.phone.sendKeys(Keys.chord(Keys.CONTROL, "a"), "123-456-7000");

    }

    @Then("Staff edits gender")
    public void staff_edits_gender() {
        ReusableMethods.waitFor(1);
        WebElement dropdown = patientUpdatePage.gender;
        Select select = new Select(dropdown);
        select.selectByValue("OTHER");
    }

    @Then("Staff edits blood group")
    public void staff_edits_blood_group() {
        ReusableMethods.waitFor(1);
        WebElement dropdown = patientUpdatePage.bloodGroup;
        Select select = new Select(dropdown);
        select.selectByValue("ABnegative");
    }

    @Then("Staff edits address")
    public void staff_edits_address() {
        Driver.wait2(1);
        patientUpdatePage.adress.sendKeys(Keys.chord(Keys.CONTROL, "a"), Faker.instance().address().streetAddress());
    }

    @Then("Staff edits description")
    public void staff_edits_description() {
        Driver.wait2(1);
        patientUpdatePage.description.sendKeys(Keys.chord(Keys.CONTROL, "a"), Faker.instance().medical().diseaseName());

    }

    @Then("Staff edits user")
    public void staff_edits_user() {
        ReusableMethods.waitFor(1);
        WebElement dropdown = patientUpdatePage.user;
        Select select = new Select(dropdown);
        select.selectByValue("4");
    }

    @Then("Staff edits country")
    public void staff_edits_country() {
        ReusableMethods.waitFor(1);
        WebElement dropdown = patientUpdatePage.country;
        Select select = new Select(dropdown);
        select.selectByVisibleText("France");
    }

    @Then("Staff edits state-city")
    public void staff_edits_state_city() {
        WebElement dropdown = patientUpdatePage.cstate;
        Select select = new Select(dropdown);
        select.selectByIndex(1);
    }
    @Then("Staff clicks on Save Button")
    public void staff_clicks_on_save_button() {
        ReusableMethods.waitFor(2);
        JsUtils.clickElementByJS(patientUpdatePage.saveButton);
    }
    @Then("Staff verifies A Patient is updated with identifier <patient Id> message")
    public void staff_verifies_a_patient_is_updated_with_identifier_patient_id_message() {
        ReusableMethods.waitForVisibility(patientUpdatePage.alertText, 1);
        String actualText = patientUpdatePage.alertText.getText();
        String expectedText = "A Patient is updated with identifier ";
        Assert.assertTrue(actualText.contains(expectedText));
        Assert.assertTrue(patientUpdatePage.alertText.isDisplayed());
        Driver.closeDriver();
    }

//    @Then("Staff verifies that all the registration info populated")
//    public void staff_verifies_that_all_the_registration_info_populated() {
//
//    }


}