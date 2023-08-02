package Utility;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;




public class DateClass {
public static String dateMethod() {
	String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
	return dateName;
}
public static String outPut() throws EncryptedDocumentException, IOException {
	String  oUTPUT_FOLDER ="\\test-output\\ExtendReport\\";
	return oUTPUT_FOLDER;
}
public static String file_name() throws EncryptedDocumentException, IOException {
	String  fILE_NAME ="Extent.html";
	return fILE_NAME;
}

}

