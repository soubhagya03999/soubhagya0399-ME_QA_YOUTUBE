package demo;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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
            for(int i=0;i<5;i++){
                arr[i]=sheet.getRow(i+1).getCell(0).getStringCellValue();
            }
            return arr;
    }

    @DataProvider(name = "search")
	public static Object[][] dpMethod() throws IOException{
        String[] arr = getRowData();
        System.out.println(arr[0]);
		return new Object[][] {{arr[0]},{arr[1]},{arr[2]},{arr[3]},{arr[4]}};
	}
}
