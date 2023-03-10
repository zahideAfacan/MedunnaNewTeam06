package stepdefinitions.ui_stepdef;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.AdminUserManagementPage;
import utilities.Driver;
import utilities.JSUtils;
import utilities.ReusableMethods;

import javax.swing.*;
import java.util.List;

public class US016_PatientInfoStepDefs {
        Actions actions=new Actions(Driver.getDriver());
        AdminUserManagementPage adminUserManagementPage=new AdminUserManagementPage();
    @When("user goes to last page")
    public void user_goes_to_last_page() {
        ReusableMethods.waitFor(1);
        JSUtils.clickElementByJS(adminUserManagementPage.LastPageButton);
    }
    @Then("users chose patient last patient and  see the all information")
    public void users_chose_patient_last_patient_and_see_the_all_information() {
        ReusableMethods.waitFor(1);
        List<WebElement> patientIDs= (List<WebElement>) adminUserManagementPage.ListOfPatientID;
        for (WebElement w:patientIDs) {
            System.out.println("w = " + w.toString());
        }
    }


}
