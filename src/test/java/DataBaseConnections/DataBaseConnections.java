package DataBaseConnections;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class DataBaseConnections {

    // Custom class to represent each entry with BallotTypeId and VoteOptionId
    public static class BallotEntry {
        private String ballotTypeId;
        private String voteOptionId;
		private String value3;

        public BallotEntry(String ballotTypeId, String voteOptionId, String value3) {
            this.ballotTypeId = ballotTypeId;
            this.voteOptionId = voteOptionId;
            this.value3=value3;
        }
    }

    public static void main(String[] args) {
        String jdbcUrl = "jdbc:sqlserver://IB-PUNE-LAP-356:1433";
        String user = "sa";
        String password = "server.123";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, user, password);
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery("use [Balloted-Dev-Product]\r\n" + 
             		"select * From [SDP-API].[Ballots]")) {

            List<BallotEntry> jsonObjectsList = new ArrayList<>();

            while (rs.next()) {
            	
                String value1 = rs.getString("Explanation");
                String value2 = rs.getString("StartDate");
                String value3=rs.getString("VoteOptionId");
                BallotEntry entry = new BallotEntry(value1, value2,value3);
                jsonObjectsList.add(entry);
            }

            // Store the jsonObjectsList into the JSON file
            String jsonFileName = "output.json"; // Replace with the desired file name
            String jsonFilePath = System.getProperty("user.dir") + "\\" + jsonFileName;

            try (FileWriter fileWriter = new FileWriter(jsonFilePath)) {
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                String convertedJsonString = gson.toJson(jsonObjectsList);
                fileWriter.write(convertedJsonString);
                System.out.println("JSON data has been successfully written to the file: " + jsonFilePath);
            } catch (IOException e) {
                e.printStackTrace();
                System.err.println("Error writing JSON data to the file.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error executing the SQL query.");
        }
    }
}