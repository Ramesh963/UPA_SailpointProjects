package utilsFiles;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ReadDataFromExcel {
	@DataProvider(name="fetchdata")
	public static String[][] getData(String testdatasheetname,int sheetnum) throws IOException {

		FileInputStream fis=new FileInputStream("./testdata/"+testdatasheetname+".xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheetAt(sheetnum);
		int rowcount=sheet.getLastRowNum();
		int columncount=sheet.getRow(1).getLastCellNum();
		String [][] testdata=new String[rowcount][columncount];
		for(int i=1;i<=rowcount;i++) {
			XSSFRow row=sheet.getRow(i);
			for(int j=0;j<columncount;j++) {
				XSSFCell cell= row.getCell(j);
				cell.setCellType(cell.CELL_TYPE_STRING);
				String cellvalue=cell.getStringCellValue();
				testdata[i-1][j]=cellvalue;
				//System.out.println(cellvalue);
			}
		}
		return testdata;
		
	}
}
