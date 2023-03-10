package stepdefinitions.ui_stepdef;

import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.LoginPageKU;
import pages.MedunnaHomePage;
import pages.US021PageKU;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.Objects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static utilities.ReusableMethods.waitFor;

public class US021StepDefsKU {

    MedunnaHomePage medunnaHomePage = new MedunnaHomePage();
    LoginPageKU loginPageKU=new LoginPageKU();
    US021PageKU us021PageKU=new US021PageKU();

    Actions actions=new Actions(Driver.getDriver());



    @When("enter admin username")
    public void enter_admin_username() {
        loginPageKU.username.sendKeys("AdminTeam06");
        waitFor(1);

    }
    @When("enter admin password")
    public void enter_admin_password() {
        loginPageKU.password.sendKeys("Team06+");
    }
    @When("click on Administration icon and User management button")
    public void click_on_administration_icon_and_user_management_button() {
        us021PageKU.administrationIcon.click();
        waitFor(1);
        us021PageKU.userManagement.click();
        waitFor(1);
        us021PageKU.createdDate.click();
        waitFor(2);



    }
    @When("find user and click on View button and verify can view people info")
    public void findUserAndClickOnViewButtonAndVerifyCanViewPeopleInfo() {

        WebElement spView = null;
        while (spView == null) {

            try {
                waitFor(1);
                spView = Driver.getDriver().findElement(By.xpath("//*[@id='hastabey']//*[contains(text(),'View')]"));

            } catch (NoSuchElementException e) {
                waitFor(1);
                ReusableMethods.clickWithTimeOut(us021PageKU.nextPage,1);
            }
        }

        ReusableMethods.clickWithTimeOut(spView,2);

        //verify
        assertTrue(us021PageKU.seeUserName.isDisplayed());
        assertTrue(us021PageKU.seeFirstName.isDisplayed());
        assertTrue(us021PageKU.seeLastName.isDisplayed());
        assertTrue(us021PageKU.seeEmail.isDisplayed());
        assertTrue(us021PageKU.seeLanguage.isDisplayed());

    }
    @When("find user and click on Edit button and activate or deactivate user and verify")
    public void findUserAndClickOnEditButtonAndActivateOrDeactivateUserAndVerify() {
        WebElement spEdit = null;
        while (spEdit == null) {

            try {
                waitFor(1);
                spEdit = Driver.getDriver().findElement(By.xpath("//*[@id='hastabey']//*[contains(text(),'Edit')]"));

            } catch (NoSuchElementException e) {
                waitFor(1);
                ReusableMethods.clickWithTimeOut(us021PageKU.nextPage,1);
            }
        }

        ReusableMethods.clickWithTimeOut(spEdit,2);

        actions.sendKeys(Keys.PAGE_DOWN).perform();



        waitFor(1);

        String a= us021PageKU.activated.getAttribute("value");
        System.out.println("a = " + a);

        if (Objects.equals(a, "false")){
            ReusableMethods.waitForClickablility( us021PageKU.activated,5);
            us021PageKU.activated.click();
            waitFor(2);
            String active= us021PageKU.activated.getAttribute("value");
            assertEquals(active,"true");

        }
        else {
            ReusableMethods.waitForClickablility( us021PageKU.activated,5);
            us021PageKU.activated.click();
            waitFor(2);
            String active= us021PageKU.activated.getAttribute("value");
            assertEquals(active,"false");

        }
    }

    @When("give a role user and verify")
    public void giveARoleUserAndVerify() {

        waitFor(1);
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        Select roles = new Select(us021PageKU.roles);
        roles.deselectAll();
        waitFor(2);
        roles.selectByVisibleText("ROLE_PATIENT");

        waitFor(1);
        ReusableMethods.clickWithTimeOut(us021PageKU.saveButton,2);

        waitFor(5);

        //Verify ROLE_PATIENT;
        us021PageKU.modifiedDate.click();
        waitFor(1);

        String userRole= us021PageKU.userVerified.getText();

        assertEquals(userRole, "ROLE_PATIENT");

        //Give ROLE_PHYSICIAN;
        waitFor(1);

        WebElement edit=  Driver.getDriver().findElement(By.xpath("//*[@id='hastabey']//*[contains(text(),'Edit')]"));

        edit.click();

        waitFor(2);

        actions.sendKeys(Keys.PAGE_DOWN).perform();

        roles.deselectAll();
        waitFor(2);
        roles.selectByVisibleText("ROLE_PHYSICIAN");

        waitFor(1);
        ReusableMethods.clickWithTimeOut(us021PageKU.saveButton,2);
        waitFor(5);

        //Verify ROLE_PHYSICIAN;
        us021PageKU.modifiedDate.click();
        waitFor(1);

        userRole= us021PageKU.userVerified.getText();

        assertEquals(userRole, "ROLE_PHYSICIAN");

        //Give ROLE_ADMIN;
        waitFor(1);

        edit=  Driver.getDriver().findElement(By.xpath("//*[@id='hastabey']//*[contains(text(),'Edit')]"));

        edit.click();

        waitFor(2);

        actions.sendKeys(Keys.PAGE_DOWN).perform();

        roles.deselectAll();
        waitFor(2);
        roles.selectByVisibleText("ROLE_ADMIN");

        waitFor(1);
        ReusableMethods.clickWithTimeOut(us021PageKU.saveButton,2);
        waitFor(5);

        //Verify ROLE_ADMIN;
        us021PageKU.modifiedDate.click();
        waitFor(1);

        userRole= us021PageKU.userVerified.getText();

        assertEquals(userRole, "ROLE_ADMIN");

        //Give ROLE_USER;
        waitFor(1);

        edit=  Driver.getDriver().findElement(By.xpath("//*[@id='hastabey']//*[contains(text(),'Edit')]"));

        edit.click();

        waitFor(2);

        actions.sendKeys(Keys.PAGE_DOWN).perform();

        roles.deselectAll();
        waitFor(2);
        roles.selectByVisibleText("ROLE_USER");

        waitFor(1);
        ReusableMethods.clickWithTimeOut(us021PageKU.saveButton,2);
        waitFor(5);

        //Verify ROLE_ADMIN;
        us021PageKU.modifiedDate.click();
        waitFor(1);

        userRole= us021PageKU.userVerified.getText();

        assertEquals(userRole, "ROLE_USER");

        //Give ROLE_STAFF;
        waitFor(1);

        edit=  Driver.getDriver().findElement(By.xpath("//*[@id='hastabey']//*[contains(text(),'Edit')]"));

        edit.click();

        waitFor(2);

        actions.sendKeys(Keys.PAGE_DOWN).perform();

        roles.deselectAll();
        waitFor(2);
        roles.selectByVisibleText("ROLE_STAFF");

        waitFor(1);
        ReusableMethods.clickWithTimeOut(us021PageKU.saveButton,2);
        waitFor(5);

        //Verify ROLE_STAFF;
        us021PageKU.modifiedDate.click();
        waitFor(1);

        userRole= us021PageKU.userVerified.getText();

        assertEquals(userRole, "ROLE_STAFF");


    }

    @When("create a user")
    public void createAUser() {
        us021PageKU.dregisterIcon.click();
        waitFor(1);
        us021PageKU.dregisterButton.click();
        waitFor(1);
        us021PageKU.dssnBox.sendKeys("222-12-3456");
        waitFor(1);
        us021PageKU.dfirstNameBox.sendKeys("Kobay");
        waitFor(1);
        us021PageKU.dlastNameBox.sendKeys("Kullanici");
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        waitFor(1);
        us021PageKU.dusername.sendKeys("kobaykullanici");
        waitFor(1);
        us021PageKU.demail.sendKeys("kobaykullanici@tr.ca");
        waitFor(1);
        us021PageKU.dpassword.sendKeys("Kobaykullanici123");
        waitFor(1);
        us021PageKU.dconfirmPassword.sendKeys("Kobaykullanici123");
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        waitFor(2);
        us021PageKU.dregister.click();


    }

    @When("delete user and verify")
    public void deleteUserAndVerify() {

      waitFor(2);
      us021PageKU.userDelete.click();
      waitFor(2);
      us021PageKU.userConfirmDelete.click();

      waitFor(3);


      // verify 1.method
      assertTrue( Driver.getDriver().getPageSource().contains("A user is deleted"));


      // verify 2.method

      us021PageKU.alertPath.getText().contains("A user is deleted");

    }
}
