package SeleniumPractice.Basics;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Hashtable;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {
	static String sheetname="test";
	static XSSFWorkbook workbook=new XSSFWorkbook();
	static XSSFSheet sheet=workbook.createSheet(sheetname);
	static String excelfilepath="C:\\Users\\Ranjeeth\\eclipse-workspace\\data.xlsx";
	
	public static Object[][]  readexcel() throws IOException {
		File path=new File(excelfilepath);
		
			FileInputStream fis= new FileInputStream(path);
			XSSFWorkbook wb=new XSSFWorkbook(fis);
			XSSFSheet sh=wb.getSheet("testdata");
			int rowcount=sh.getLastRowNum();
			int colcount=sh.getRow(0).getLastCellNum();
			System.out.println("the number of rows in an excel sheet is "+(rowcount+1));
			System.out.println("the number of columns in an excel sheet is "+colcount);
			Object[][] datasets=new Object[1][1];
			
			Hashtable<Integer,Hashtable<String,String>> masterdata=new Hashtable<Integer,Hashtable<String,String>>();
			for(int i=1 ;i<=rowcount;i++){
				Hashtable<String,String> dataset=new Hashtable<String,String>();
				for(int j=0;j<colcount;j++) {
					if(sh.getRow(i).getCell(j)==null) {
						dataset.put(sh.getRow(0).getCell(j).getStringCellValue(), " ");
						
					}else {
						if(sh.getRow(i).getCell(j).getCellTypeEnum()==CellType.NUMERIC) {
						dataset.put(sh.getRow(0).getCell(j).getStringCellValue(), Double.toString(sh.getRow(i).getCell(j).getNumericCellValue()))	;
						
						}else {
						dataset.put(sh.getRow(0).getCell(j).getStringCellValue(), sh.getRow(i).getCell(j).getStringCellValue());
						}
					}
				
				}
				masterdata.put(i, dataset);
				
			}
			
			datasets[0][0]=masterdata;
			System.out.println(datasets[0][0]);
			return datasets;
		
		
	
	}

	public  static void writeexcel(int Rownum,int colnum,String result) throws IOException {
		//create a sheet
		File path=new File(excelfilepath);
		XSSFSheet Excelsheet=sheet;
		XSSFCell Cell;
		XSSFRow Row;
		try {
			Row=sheet.createRow(Rownum);
			Cell=Row.getCell(colnum);
			if(Cell==null) {
				Cell=Row.createCell(colnum);
				Cell.setCellValue(result);
			}else {
				Cell.setCellValue(result);
			}
		FileOutputStream fos=new FileOutputStream(path);
		workbook.write(fos);
		fos.flush();
		fos.close();
		System.out.println("the data has been return succesfully");
		
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		
	}

	public static void writeData(String excelfilepath,String sheetname,String cellname,String cellvalue,int rownum) throws Exception {
		File filepath=new File (excelfilepath);
		XSSFWorkbook wb=new XSSFWorkbook();
		XSSFSheet sh=wb.getSheet(sheetname);
		int numofcol=sh.getRow(0).getLastCellNum();
		int testcell=0;
		boolean cellfound=false;
		for(int j=0;j<numofcol;j++) {
			if(sh.getRow(0).getCell(j).getStringCellValue().equals(cellname)) {
			cellfound=true;
			testcell=j;
			}
		}if(cellfound==true) {
			XSSFCell Cell=sh.getRow(rownum).getCell(testcell);
			if(Cell==null) {
				Cell=sh.getRow(rownum).createCell(testcell);
				Cell.setCellValue(cellvalue);
			}else {
				Cell.setCellValue(cellvalue);
			}
			FileOutputStream fos=new FileOutputStream(filepath);
			wb.write(fos);
			fos.flush();
			fos.close();
		}
		
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
      Excel.readexcel();
	}

}

