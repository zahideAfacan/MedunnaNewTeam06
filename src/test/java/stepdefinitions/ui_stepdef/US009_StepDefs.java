package stepdefinitions.ui_stepdef;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.HomePageZA;
import pages.LoginPageZA;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US009_StepDefs {
        LoginPageZA loginPageZA=new LoginPageZA();
        HomePageZA homePageZA=new HomePageZA();
        Faker faker=new Faker();
        String strengthBar1;
        String strengthBar2;
        String strengthBar3;
        String strengthBar4;
        String strengthBar5;
         String strengthBar;

    String newPass=faker.regexify("[a-z][A-Z][0-9]{7}");

    @Given("users on medunna_url page")
    public void user_on_page_medunna_url() {
        Driver.getDriver().get(ConfigReader.getProperty("medunna_url"));
    }
    @When("click on users icon")
    public void click_on_user_icon() {
        ReusableMethods.waitFor(1);
        loginPageZA.userIcon.click();
    }
    @When("clicks on Sign In option")
    public void click_on_sign_in_option() {
        ReusableMethods.waitFor(1);
        loginPageZA.SigIn.click();
    }
    @When("enters username in username input")
    public void enter_in_username_input() {
        ReusableMethods.waitFor(1);
        loginPageZA.username.sendKeys(ConfigReader.getProperty("Patient_username"));
    }
    @When("enters password in password input")
    public void enter_in_password_input() {
        ReusableMethods.waitFor(1);
        loginPageZA.password.sendKeys(ConfigReader.getProperty("Patient_password"));
    }
    @When("clicks on Remember Me checkbox")
    public void click_on_remember_me_checkbox() {
        loginPageZA.rememberMe.click();
    }
    @When("clicks on Sign In submit button")
    public void click_on_sign_in_submit_button() {
        loginPageZA.submit.click();
    }

    @When("clicks on account menu")
    public void click_on_account_menu() {
        ReusableMethods.waitFor(1);
        homePageZA.accountMenu.click();
    }
    @Then("clicks on password from dropdown menu")
    public void click_on_password_from_dropdown_menu() {
        ReusableMethods.waitFor(1);
      homePageZA.dropdownPassword.click();
    }

    @Then("enter at least one lowercase char")
    public void enter_at_least_one_lowercase_char() {
        strengthBar= String.valueOf(homePageZA.strengthBar2.getCssValue("background-color"));
        ReusableMethods.waitFor(1);
        homePageZA.currentPassword.sendKeys(ConfigReader.getProperty("Patient_password"));
        ReusableMethods.waitFor(1);
        homePageZA.newPassword.sendKeys(faker.regexify("[a-z]{6}"));
        ReusableMethods.waitFor(1);
        strengthBar1 = String.valueOf(homePageZA.strengthBar1.getCssValue("background-color"));
        strengthBar2 = String.valueOf(homePageZA.strengthBar2.getCssValue("background-color"));
        strengthBar3 = String.valueOf(homePageZA.strengthBar3.getCssValue("background-color"));
        strengthBar4 = String.valueOf(homePageZA.strengthBar4.getCssValue("background-color"));
        strengthBar5 = String.valueOf(homePageZA.strengthBar5.getCssValue("background-color"));
        System.out.println("strengthBar1"+strengthBar1);
        ReusableMethods.waitFor(1);
        Assert.assertNotEquals(strengthBar,strengthBar1);


    }
    @Then("verify the level chart change")
    public void verify_the_level_chart_change() {

    }
    @Then("enter at least one uppercase char")
    public void enter_at_least_one_uppercase_char() {
        homePageZA.newPassword.clear();
        ReusableMethods.waitFor(1);
        homePageZA.newPassword.sendKeys(faker.regexify("[a-z][A-Z]{6}"));
        ReusableMethods.waitFor(1);
        strengthBar2 = String.valueOf(homePageZA.strengthBar2.getCssValue("background-color"));
        System.out.println("strengthBar2"+strengthBar2);
        ReusableMethods.waitFor(1);


    }
    @Then("enter at least one digit")
    public void enter_at_least_one_digit() {
        homePageZA.newPassword.clear();
        ReusableMethods.waitFor(1);
        homePageZA.newPassword.sendKeys(faker.regexify("[a-z][A-Z][0-9]{6}"));
        ReusableMethods.waitFor(1);
        strengthBar3 = String.valueOf(homePageZA.strengthBar3.getCssValue("background-color"));
        System.out.println("strengthBar2"+strengthBar3);
        ReusableMethods.waitFor(1);
    }
    @Then("enter at least one special char")
    public void enter_at_least_one_special_char() {
        homePageZA.newPassword.clear();
        ReusableMethods.waitFor(1);
        homePageZA.newPassword.sendKeys(faker.regexify("[a-z][A-Z][0-9][!-+]{6}"));
        ReusableMethods.waitFor(1);
        strengthBar4 = String.valueOf(homePageZA.strengthBar4.getCssValue("background-color"));
        System.out.println("strengthBar2"+strengthBar4);
        ReusableMethods.waitFor(1);
    }
    @Then("enter at least seven char")
    public void enter_at_least_seven_char() {
        homePageZA.newPassword.clear();
        ReusableMethods.waitFor(1);
        homePageZA.newPassword.sendKeys("Patient_password");
        ReusableMethods.waitFor(1);
        homePageZA.confirmPassword.sendKeys("Patient_password");
        System.out.println("newPass"+newPass);




    }
    @Then("enter old password in new password input")
    public void enter_old_password_in_new_password_input() {
        homePageZA.newPassword.clear();
        ReusableMethods.waitFor(1);
        homePageZA.newPassword.sendKeys("Patient_password");
        ReusableMethods.waitFor(1);
        homePageZA.confirmPassword.clear();
        ReusableMethods.waitFor(1);
        homePageZA.confirmPassword.sendKeys("Patient_password");
      //  homePageZA.submit.click();
      //  String conformation= Driver.getDriver().switchTo().alert().getText();
      //  System.out.println("conformation = " + conformation);
    }

}
