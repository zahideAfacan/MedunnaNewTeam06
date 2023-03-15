package stepdefinitions.ui_stepdef;

import io.cucumber.java.en.*;
import pages.AdminUserManagementPage;


import utilities.JsUtils;
import utilities.ReusableMethods;

public class US016_Stepdefinitions {

    //Background
    AdminUserManagementPage adminUserManagementPage=new AdminUserManagementPage();
    @When("user click on Administration button")
    public void user_click_on_administration_button() {
       adminUserManagementPage.Administration.click();
        ReusableMethods.waitFor(1);
    }
    //TC01
    @When("user click on user management button")
    public void user_click_on_user_management_button() {
       adminUserManagementPage.UserManagement.click();
    }
    @Then("user click on Create a new user")
    public void user_click_on_create_a_new_user() {
        ReusableMethods.waitFor(1);
        adminUserManagementPage.CreateANewUser.click();
    }
    @Then("user enters the login {string}")
    public void user_enters_the_login(String string) {
        adminUserManagementPage.Login.sendKeys(string);
        ReusableMethods.waitFor(1);
    }
    @Then("user enters the first name {string}")
    public void user_enters_the_first_name(String string) {
        adminUserManagementPage.FirstName.sendKeys(string);
        ReusableMethods.waitFor(1);
    }
    @Then("user enters the last name {string}")
    public void user_enters_the_last_name(String string) {
        adminUserManagementPage.LastName.sendKeys(string);
        ReusableMethods.waitFor(1);
    }
    @Then("user enters the Email {string}")
    public void user_enters_the_email(String string) {
        adminUserManagementPage.Email.sendKeys(string);
        ReusableMethods.waitFor(1);
    }
    @Then("user enters the SSN {string}")
    public void user_enters_the_ssn(String string) {
        adminUserManagementPage.SSN.sendKeys(string);
        ReusableMethods.waitFor(1);
    }
    @Then("user click on Activated button")
    public void user_click_on_activated_button() {
        adminUserManagementPage.ActivatedCheckbox.click();
        ReusableMethods.waitFor(1);
    }
    @Then("user enters the Language {string}")
    public void user_enters_the_language(String string) {
        adminUserManagementPage.Language.sendKeys(string);
        ReusableMethods.waitFor(1);
    }
    @Then("user click on patient role")
    public void user_click_on_patient_role() {
        JsUtils.clickElementByJS(adminUserManagementPage.Profiles);
        ReusableMethods.waitFor(1);
    }
    @Then("user click on save button")
    public void user_click_on_save_button() {
        JsUtils.clickElementByJS(adminUserManagementPage.Save);
        ReusableMethods.waitFor(1);
    }
    @Then("verify patient on the users list")
    public void verify_patient_on_the_users_list() {

    }



}
