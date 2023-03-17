package stepdefinitions.ui_stepdef;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.US023Page;
import utilities.Driver;
import utilities.JsUtils;
import utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.List;

public class US023_StepDefs {

    US023Page us023Page=new US023Page();
    @When("click on any patient's Show Appointments")
    public void click_on_any_patient_s_show_appointments() {

        JsUtils.clickElementByJS(us023Page.showAppButton);
        ReusableMethods.waitFor(1);
    }
    @When("edit patient tests clicking on Show test")
    public void edit_patient_tests_clicking_on_show_test() {
        JsUtils.clickElementByJS(us023Page.ShowTests);
        ReusableMethods.waitFor(1);

    }
    @When("click on view results")
    public void click_on_view_results() {
        JsUtils.clickElementByJS(us023Page.ViewResult);
        ReusableMethods.waitFor(1);
    }
    @When("edit results where they will see selected tests by Doctor")
    public void edit_results_where_they_will_see_selected_tests_by_doctor() {
        JsUtils.clickElementByJS(us023Page.EditButton);
        ReusableMethods.waitFor(1);

            JsUtils.clickElementByJS(us023Page.Result);

            us023Page.Result.clear();
            us023Page.Result.sendKeys("75");

        ReusableMethods.waitFor(1);

        JsUtils.clickElementByJS(us023Page.Save);
    }
    @When("verify updating test resut")
    public void verify_updating_test_resut() {
        System.out.println("identifier = " + us023Page.identifier);
        ReusableMethods.waitFor(1);

    }

    @And("Staff will view or update the result info")
    public void staffWillViewOrUpdateTheResultInfo() {
        List<WebElement> list=Driver.getDriver().findElements(By.xpath("//thead/tr/th"));
        List<String> stringlist=new ArrayList<>();
        for (WebElement w:list){
            stringlist.add(w.getText());
        }

        Assert.assertTrue(stringlist.contains("Result"));
        Assert.assertTrue(stringlist.contains("Date"));
        Assert.assertTrue(stringlist.contains("Description"));
    }
}
