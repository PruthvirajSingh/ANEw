package Utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcleReader {
	public static String excleReader(String sheet, int row, int cell) throws EncryptedDocumentException, IOException {
		String path = System.getProperty("user.dir") + "\\DataFile.xlsx";
		FileInputStream file = new FileInputStream(path);
		Sheet sheetValue = WorkbookFactory.create(file).getSheet(sheet);
		Row rowValue = sheetValue.getRow(row);
		
		Cell cellValue = rowValue.getCell(cell);

		if (cellValue.getCellType() == CellType.STRING) {
			String valuesString = cellValue.getStringCellValue();
			return valuesString;
		} else if (cellValue.getCellType() == CellType.NUMERIC) {
			double intValue = cellValue.getNumericCellValue();
			return String.valueOf(intValue);
		}
		return path;

	}
}
