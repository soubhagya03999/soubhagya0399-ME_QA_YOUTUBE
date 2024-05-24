package demo;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;
import org.testng.annotations.DataProvider;

public class ExcelUtils {
    static String projectPath;
    static XSSFWorkbook workbook;
    static XSSFSheet sheet;

    public static String[] getRowData() throws IOException{
            projectPath=System.getProperty("user.dir");
            workbook = new XSSFWorkbook(projectPath+"\\src\\test\\resources\\qa_codeathon_week3.xlsx");
           // C:\Crio\soubhagya0399-ME_QA_YOUTUBE\src\test\resources\qa_codeathon_week3.xlsx
            sheet = workbook.getSheet("Sheet1");
            String[] arr = new String[5];
            arr[0]=sheet.getRow(1).getCell(0).getStringCellValue();
            arr[1]=sheet.getRow(2).getCell(0).getStringCellValue();
            arr[2]=sheet.getRow(3).getCell(0).getStringCellValue();
            arr[3]=sheet.getRow(4).getCell(0).getStringCellValue();
            arr[4]=sheet.getRow(5).getCell(0).getStringCellValue();
            return arr;    
    }

    @DataProvider(name = "search")
	public static Object[][] dpMethod() throws IOException{
        String[] arr = getRowData();
        System.out.println(arr[0]);
		return new Object[][] {{arr[0]},{arr[1]},{arr[2]},{arr[3]},{arr[4]}};
	}
}
