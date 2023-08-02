package pdfToExmlFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.apache.commons.text.StringEscapeUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.json.JSONObject;
import org.json.XML;
import org.junit.Assert;

public class PdfToXmlConverter{
    public static void main(String[] args) {
        try {
            File pdfFile = new File("C:\\Users\\Pruthvirajsing\\Desktop\\statement_sample1.pdf");
            PDDocument document = PDDocument.load(pdfFile);
            PDFTextStripper pdfTextStripper = new PDFTextStripper();
            String pdfText = pdfTextStripper.getText(document);
            document.close();

            // Convert the extracted text into XML format
            StringBuilder xmlContent = new StringBuilder("<pdfContent>");
            String[] lines = pdfText.split("\\r?\\n");
            for (String line : lines) {
                // Escape special characters before adding to the XML content
                xmlContent.append("<line>").append(StringEscapeUtils.escapeXml10(line)).append("</line>");
            }
            xmlContent.append("</pdfContent>");

            // Save the XML content to a file in the current working directory
            String xmlFileName = "output.xml";
            Files.write(Paths.get(xmlFileName), xmlContent.toString().getBytes());

            // Convert XML to JSON
            JSONObject jsonObject = XML.toJSONObject(xmlContent.toString());

            // Save the prettified JSON content to a file in the current working directory
            String jsonFileName = "output.json";
            Files.write(Paths.get(jsonFileName), jsonObject.toString(4).getBytes());

            System.out.println("XML content saved to: " + xmlFileName);
            System.out.println("JSON content saved to: " + jsonFileName);

            // Read the JSON content from the two files
            String jsonContent1 = new String(Files.readAllBytes(Paths.get(jsonFileName)));
            String jsonContent2 = new String(Files.readAllBytes(Paths.get("C:\\Aldar\\Aldar\\output.json"))); // Replace with the second JSON file path

            // Parse JSON content into JSONObject
            JSONObject jsonObj1 = new JSONObject(jsonContent1);
            JSONObject jsonObj2 = new JSONObject(jsonContent2);

            // Compare the two JSONObjects for equality using assertion
            Assert.assertEquals("JSON data does not match.", jsonObj1.toString(), jsonObj2.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}





