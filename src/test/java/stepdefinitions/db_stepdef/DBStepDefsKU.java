package stepdefinitions.db_stepdef;

import io.cucumber.java.en.*;
import utilities.DBUtils;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class DBStepDefsKU {

    List<Object> columnList;
    @Given("user connects to database")
    public void user_connects_to_database() {

        DBUtils.createConnection();

    }
    @When("get all {string} as a list from {string}")
    public void get_all_as_a_list_from(String columnName, String tableName) {
        String query= "SELECT * FROM "+tableName;
        columnList=DBUtils.getColumnData(query,columnName);
        System.out.println("columnList = " + columnList);

    }
    @Then("verify list contains {string}")
    public void verify_list_contains(String messageText) {

        assertTrue(columnList.contains(messageText));

  //     System.out.println("columnList.size() = " + columnList.size());


    }
    @Then("close the connection")
    public void close_the_connection() {
        DBUtils.closeConnection();

    }

}

/*
public class DBDummy {
    public static void main(String[] args) {

        DBUtils.createConnection();
        String query = "SELECT login FROM jhi_user WHERE id = 15434";
        System.out.println(DBUtils.getCellValue(query));

        List<Object> objectList = DBUtils.getRowList("SELECT * FROM jhi_user WHERE id = 1121");
        System.out.println("objectList = " + objectList);
        List<Object> loginList = DBUtils.getColumnData("SELECT * FROM jhi_user","login");
        System.out.println("loginList = " + loginList);


        DBUtils.closeConnection();

    }

}


 */