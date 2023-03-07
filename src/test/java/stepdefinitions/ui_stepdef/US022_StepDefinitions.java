package stepdefinitions.ui_stepdef;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.eo.Se;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.StaffPageMD;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class US022_StepDefinitions {
StaffPageMD staffPageMD=new StaffPageMD();
Map<String ,String> patientInfo=new HashMap<>();
    String ssn;
    Faker faker=new Faker();
    @Then("click My Pages")
    public void click_my_pages() {
staffPageMD.myPages.click();
        ReusableMethods.waitFor(1);
    }
    @Then("click search patient")
    public void click_search_patient() {
staffPageMD.searchPatient.click();
        ReusableMethods.waitFor(1);
    }
    @Then("enter patient {string}")
    public void enter_patient(String ssn) {
        patientInfo.put("SSN",ssn);
staffPageMD.ssnTextBox.sendKeys(ssn);

        ReusableMethods.waitFor(1);
    }
    @Then("click edit button")
    public void click_edit_button() {

staffPageMD.edit.click();
        ReusableMethods.waitForVisibility(staffPageMD.firstName,5);
    }
    @When("change name")
    public void change_name() {
   patientInfo.put("First Name", staffPageMD.firstName.getAttribute("value"))  ;


String name=faker.name().firstName();
staffPageMD.firstName.sendKeys(Keys.CONTROL, "a"+Keys.BACK_SPACE);
        ReusableMethods.waitFor(1);
staffPageMD.firstName.sendKeys(name);
        ReusableMethods.waitFor(1);

    }
    @Then("change lastname")
    public void change_surname() {
        patientInfo.put("Last Name", staffPageMD.lastName.getAttribute("value"));

        String surname=faker.name().lastName();
        ReusableMethods.waitForVisibility(staffPageMD.lastName,3);
        staffPageMD.lastName.sendKeys(Keys.CONTROL, "a"+Keys.BACK_SPACE);

staffPageMD.lastName.sendKeys(surname);
        ReusableMethods.waitFor(1);
    }
  /*  @Then("change SSN")
    public void change_ssn_and_click_save_and_verify() {

String ssn=faker.regexify("[1-8]{3}-[2-9]{2}-[1-9]{4}");
        System.out.println(ssn);

    }*/

    @Then("change birthdate")
    public void change_birthdate() {
patientInfo.put("Birthdate",staffPageMD.birthDate.getAttribute("value"));
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
      String birthdate = sdf.format(faker.date().birthday());
        System.out.println(birthdate+"  BirthDate");

staffPageMD.birthDate.sendKeys(birthdate);
        ReusableMethods.waitFor(3);
 staffPageMD.birthDate.sendKeys(Keys.TAB);
        ReusableMethods.waitFor(1);
String time=faker.regexify("[00-23]{2}[00-59]{2}");
        ReusableMethods.waitFor(1);
       staffPageMD.birthDate.sendKeys(time);
    }
    @Then("change email")
    public void change_email() {
patientInfo.put("Email",staffPageMD.email.getAttribute("value"));
String email=Faker.instance().internet().emailAddress();
        staffPageMD.email.sendKeys(Keys.CONTROL, "a"+Keys.BACK_SPACE);
staffPageMD.email.sendKeys(email);
        ReusableMethods.waitFor(1);
    }

    @Then("close the page")
    public void close_the_page() {
        Driver.getDriver().close();
    }


    @Then("change phone")
    public void change_phone() {
    patientInfo.put("Phone",staffPageMD.phone.getAttribute("value")) ;
    String phone=faker.regexify("[0-9]{3}-[0-9]{3}-[0-9]{4}");
        staffPageMD.phone.sendKeys(Keys.CONTROL, "a"+Keys.BACK_SPACE);
staffPageMD.phone.sendKeys(phone);
        ReusableMethods.waitFor(1);
    }
    @Then("change gender")
    public void change_gender() {

Select select=new Select(staffPageMD.gender);
patientInfo.put("Gender",select.getFirstSelectedOption().getText());
        ReusableMethods.waitFor(1);
ReusableMethods.selectRandomTextFromDropdown(select);
        ReusableMethods.waitFor(1);

    }
    @Then("change the blood group")
    public void change_the_blood_group() {

        Select select1=new Select(staffPageMD.bloodGroup);
        patientInfo.put("Blood Type",select1.getFirstSelectedOption().getText());
        ReusableMethods.waitFor(1);
ReusableMethods.selectRandomTextFromDropdown(select1);
        ReusableMethods.waitFor(1);
    }
    @Then("change address")
    public void change_address() {

patientInfo.put("Address",staffPageMD.address.getAttribute("value"));
String address=Faker.instance().address().fullAddress();
        ReusableMethods.waitFor(1);
        staffPageMD.address.sendKeys(Keys.CONTROL, "a"+Keys.BACK_SPACE);
staffPageMD.address.sendKeys(address);
        ReusableMethods.waitFor(1);
    }
    @Then("add description")
    public void add_description() {
patientInfo.put("Description",staffPageMD.description.getText());
String description=Faker.instance().lorem().characters(5,15);
        staffPageMD.description.sendKeys(Keys.CONTROL, "a"+Keys.BACK_SPACE);
staffPageMD.description.sendKeys(description);
        ReusableMethods.waitFor(1);
    }
    @Then("change country")
    public void change_country() {

Select select2=new Select(staffPageMD.patientCountry);
        patientInfo.put("Country",select2.getFirstSelectedOption().getText());
ReusableMethods.waitFor(1);
ReusableMethods.selectRandomTextFromDropdown(select2);

        ReusableMethods.waitFor(1);
        System.out.println("patientInfo   "+patientInfo);
    }

    @Then("click save and")
    public void click_save_and() throws IOException {
        Actions action= new Actions(Driver.getDriver());
        action.moveToElement(staffPageMD.save).click().perform();
        ReusableMethods.waitFor(3);
        ReusableMethods.getScreenshot("StaffUpdates");
        Assert.assertTrue(staffPageMD.saveAlert.getText().contains("A Patient is updated with identifier"));


    }
    @Then("verify the saved items")
    public void verify_the_saved_items() {
        Assert.assertNotEquals(patientInfo.get("Email"), staffPageMD.emailUpdated.getText());
      Assert.assertNotEquals(patientInfo.get("Description"),staffPageMD.descriptionUpdated.getText());
      Assert.assertNotEquals(patientInfo.get("Address"),staffPageMD.addressUpdated.getText());
      Assert.assertNotEquals(patientInfo.get("First Name"),staffPageMD.firstNameUpdated.getText());
      Assert.assertNotEquals(patientInfo.get("Last Name"),staffPageMD.lastNameUpdated.getText());

    }

}
