package JsonComp;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonFileCamp {
	public static void main(String[] args) {
		// Load JSON files into strings
		
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

	// Function to compare "attributes" data between two JSON arrays and return
	// changed objects
	private static List<JSONObject> compareAttributes(JSONArray jsonArray1, JSONArray jsonArray2, String filename) {
		List<JSONObject> changes = new ArrayList<>();

		// Loop through the JSON arrays and compare "attributes" data
		for (int i = 0; i < jsonArray1.length(); i++) {
			JSONObject obj1 = jsonArray1.getJSONObject(i);
			JSONObject obj2 = jsonArray2.getJSONObject(i);

//            JSONObject attributes1 = obj1.getJSONObject("attributes");
//            JSONObject attributes2 = obj2.getJSONObject("attributes");
			if (!obj1.similar(obj2)) {
				changes.add(obj2);
			}
//            if (!attributes1.similar(attributes2)) {
//                changes.add(attributes2);
//            }

		}

		return changes;
	}

	// Function to print the changes along with the corresponding file
	private static void printChanges(String filename, List<JSONObject> changes) {
		System.out.println("Changes in " + filename + ":");
		for (int i = 0; i < changes.size(); i++) {
			JSONObject change = changes.get(i);
			int index = i + 1;
			System.out.println("  Change at location " + index + ": " + change.toString());
		}
	}
}
