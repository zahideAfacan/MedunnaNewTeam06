package stepdefinitions.db_stepdef;

import io.cucumber.java.en.*;
import org.junit.Assert;
import utilities.DBUtils;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class DBStepDefsZA {

    List<Object> columnList;
    @Then("hen get all {string} as a list from {string}")
    public void hen_get_all_as_a_list_from(String columnName, String tableName) {

        String query= "SELECT * FROM "+tableName;
        columnList=DBUtils.getColumnData(query,columnName);
        System.out.println("columnList = " + columnList);


    }
    @Then("Then verify list contains id {string}")
    public void then_verify_list_contains_id(String id) {
       Assert.assertTrue(columnList.contains(Integer.valueOf(id)));
    }


}
