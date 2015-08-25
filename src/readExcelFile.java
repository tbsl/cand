import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;


public class readExcelFile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		
		String Filepath="D:\\Excelread\\readexcel.xls" ;
				FileInputStream fs=new FileInputStream(Filepath);
				HSSFWorkbook workbook = new HSSFWorkbook(fs);
				
				HSSFSheet sheet = workbook.getSheetAt(0);
				//String heading = sheet.getRow(0).getCell(0).getStringCellValue();
				String username = sheet.getRow(1).getCell(0).getStringCellValue();
			    
				  String password = sheet.getRow(1).getCell(1).getStringCellValue();

				 // System.out.println("Heading is:" + heading);
				    
				  System.out.println("username is:" + username);
				    
				  System.out.println("password is:" + password);
				 
				  fs.close();
	}

}
