package stepdefinitions.ui_stepdef;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.AppointmentPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.*;

public class US006_AppointmentVerificationStepDefs {

    ////////////////VERIFICATION\\\\\\\\\\\\\\\\
    AppointmentPage appointmentPage = new AppointmentPage();

    @Given("user admin clicks account menu button")
    public void user_admin_clicks_account_menu_button() {
        appointmentPage.accountMenu.click();
    }

    @When("user admin clicks sign in button")
    public void user_admin_clicks_sign_in_button() {
        appointmentPage.signIn.click();
    }

    @Then("user admin enters credentials")
    public void user_admin_enters_credentials(DataTable adminCredentials) {
        List<Map<String, String>> adminUserPass = adminCredentials.asMaps(String.class, String.class);

        for (Map<String, String> each : adminUserPass) {
            appointmentPage.userName.sendKeys(each.get("username"));
            ReusableMethods.waitFor(2);
            appointmentPage.password.sendKeys(each.get("password"));
            ReusableMethods.waitFor(2);
        }
        appointmentPage.submitAdmin.click();
    }

    @Then("user admin clicks itemTitles")
    public void user_admin_clicks_item_titles() {
        ReusableMethods.waitFor(1);
        appointmentPage.itemTitles.click();
    }

    @Then("user admin clicks patient")
    public void user_admin_clicks_patient() {
        ReusableMethods.waitFor(2);
        appointmentPage.patient.click();

    }

    @Then("user admin checks appointment of patient and verify the credentials")
    public void user_admin_checks_appointment_of_patient(DataTable patientInfo) {


        ReusableMethods.waitFor(3);
        List<Map<String, String>> patientDetails = patientInfo.asMaps(String.class, String.class);
        System.out.println("Patient Details" + patientDetails);

        List<String> allHeaderNames = new ArrayList<String>();
        for (int i = 0; i < appointmentPage.tableHeader.size() - 1; i++) {
            String headerName = appointmentPage.tableHeader.get(i).getText();
            allHeaderNames.add(headerName);
        }
//ALL TABLE DATA
        List<LinkedHashMap<String, String>> allTableData = new ArrayList<LinkedHashMap<String, String>>();
        int rowCount = appointmentPage.allRowElements.size();
        int pageItemSize = appointmentPage.pageItems.size();
        System.out.println(pageItemSize+ "Page Item SIze ........................>>>>>>>>");
        for (int i = 1; i <= pageItemSize+4; i++) {
            ReusableMethods.waitFor(3);
            List<WebElement> row = Driver.getDriver().findElements(By.xpath("//*[@id='app-view-container']//table/tbody/tr"));
            for (int j = 1; j <= row.size(); j++) {
                List<WebElement> allColumnsElements = Driver.getDriver().findElements(By.xpath("//*[@id='app-view-container']//table/tbody/tr[" + j + "]//td"));
                LinkedHashMap<String, String> eachRowData = new LinkedHashMap<>();
                for (int k = 0; k < allHeaderNames.size(); k++) {

                    String cellValue = allColumnsElements.get(k).getText();
                    eachRowData.put(allHeaderNames.get(k), cellValue);
                }
                allTableData.add(eachRowData);
            }
            Actions actions = new Actions(Driver.getDriver());
            actions.moveToElement(appointmentPage.next).click().perform();
            ReusableMethods.waitFor(1);
        }
        System.out.println(allTableData.size());
        System.out.println("AllDataTable  "+allTableData);
        Map<String, String> userInfo = new HashMap<>();

     int count=0;
   for(LinkedHashMap<String,String> each:allTableData ){
     boolean ssn= each.containsValue(patientDetails.get(0).get("ssn"));
     if(ssn){
      count++;
     }
   }
  // Assert.assertEquals(1,count);

        for (LinkedHashMap<String, String> allTableDatum : allTableData) {
            if (allTableDatum.get("Last Name").equals("Drky")) {
                userInfo.put("SSN", allTableDatum.get("SSN"));
                System.out.println(userInfo.get("SSN"));
                userInfo.put("FirstName", allTableDatum.get("First Name"));
                System.out.println(userInfo.get("FirstName"));
                userInfo.put("LastName", allTableDatum.get("Last Name"));
                System.out.println(userInfo.get("LastName"));
                userInfo.put("Email", allTableDatum.get("Email"));
                userInfo.put("Phone", allTableDatum.get("Phone"));
                userInfo.put("ID", allTableDatum.get("ID"));
            }
        }

        System.out.println("userInfo   "+userInfo);
        String HastaAdi=patientDetails.get(0).get("firstname");
        String HastaSoyadi=patientDetails.get(0).get("lastname");
        String Hasta_SSN=patientDetails.get(0).get("ssn");
        String Hasta_email=patientDetails.get(0).get("email");
        String Hasta_Phone=patientDetails.get(0).get("phone");
Assert.assertEquals(HastaAdi,userInfo.get("FirstName"));
Assert.assertEquals(Hasta_email,userInfo.get("Email"));
Assert.assertEquals(HastaSoyadi,userInfo.get("LastName"));
    }
}

















