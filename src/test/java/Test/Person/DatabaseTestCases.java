package Test.Person;

import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;
import Base.BaseClass;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DatabaseTestCases extends BaseClass {

    @Test
    @Description("Test for database testing")
    public void databaseTesting() throws InterruptedException {
        login.loginToSandBox(prop.getProperty("AdminUsername"), prop.getProperty("AdminPassword"));
        database.salesForceInspector();
        String jsonFile1 = loadJsonFile("C:\\Aldar\\NewA\\Aldar\\output.json");
        String jsonFile2 = loadJsonFile("C:\\Aldar\\NewA\\Aldar\\op2.json");

        // Parse JSON strings into JSON arrays
        JSONArray jsonArray1 = new JSONArray(jsonFile1);
        JSONArray jsonArray2 = new JSONArray(jsonFile2);

        // Compare and print changes in "attributes" data with their corresponding file
        List<JSONObject> changes1 = compareAttributes(jsonArray1, jsonArray2, "jsonFile1.json");
        List<JSONObject> changes2 = compareAttributes(jsonArray2, jsonArray1, "jsonFile2.json");

        // Print changes in file 1
        printChanges("jsonFile1.json", changes1);

        // Print changes in file 2
        printChanges("jsonFile2.json", changes2);
    }

    // Function to read JSON files and return content as a string
    private static String loadJsonFile(String filePath) {
        try {
            return new String(Files.readAllBytes(Paths.get(filePath)));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Function to compare "attributes" data between two JSON arrays and return changed objects
    private static List<JSONObject> compareAttributes(JSONArray jsonArray1, JSONArray jsonArray2, String filename) {
        List<JSONObject> changes = new ArrayList<>();

        // Loop through the JSON arrays and compare "attributes" data
        for (int i = 0; i < jsonArray1.length(); i++) {
            JSONObject obj1 = jsonArray1.getJSONObject(i);
            JSONObject obj2 = jsonArray2.getJSONObject(i);

            JSONObject attributes1 = obj1.getJSONObject("attributes");
            JSONObject attributes2 = obj2.getJSONObject("attributes");

            // Compare the "attributes" data separately
            if (!attributes1.similar(attributes2)) {
                // Add the complete object (including "attributes") to the changes list
                changes.add(obj2);
            }
        }

        return changes;
    }

    // Function to print the changes along with the corresponding file
    @Step("Print changes in {0}")
    private void printChanges(String filename, List<JSONObject> changes) {
        System.out.println("Changes in " + filename + ":");
        for (int i = 0; i < changes.size(); i++) {
            JSONObject change = changes.get(i);
            int index = i + 1;
            String logMessage = "Change at location " + index + ": " + change.toString();
            
            System.out.println(logMessage);
            allureLog(logMessage);
        }
    }

    // Helper method to log the information using Allure
    private void allureLog(String logMessage) {
        Allure.addAttachment("Log Message", logMessage);
    }
}
