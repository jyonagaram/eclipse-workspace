package DataDrivenFramework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	static XSSFWorkbook wb;
	static XSSFSheet sh;
	static XSSFRow Row;
	static XSSFCell Cell;
	static String celldata=null;

	public static Object[][] readExcel(String filepath,String Stheetname) throws Exception {

		FileInputStream fis=new FileInputStream(filepath);
		wb=new XSSFWorkbook(fis);
		sh=wb.getSheet("Sheet1");
		int rowcount=sh.getPhysicalNumberOfRows();
		int colcount=sh.getRow(0).getLastCellNum();
		Object ob[][]=new Object[rowcount-1][colcount];
		for(int i=1;i<rowcount;i++) {
			for(int j=0;j<colcount;j++) {
				if(sh.getRow(i).getCell(j)==null) {
					celldata=" ";
					ob[i-1][j]=celldata;
				}else {

					if(sh.getRow(i).getCell(j).getCellType()==CellType.NUMERIC) {
						celldata=Double.toString((sh.getRow(i).getCell(j).getNumericCellValue()));

						ob[i-1][j]=celldata;
					}
					else {
						celldata=sh.getRow(i).getCell(j).getStringCellValue();
						ob[i-1][j]=celldata;
					}
				}

			}
		}


		return ob;


	}

	public static void writeData(int rownum,int colnum,String result,String filepath) throws Exception {

		Cell=sh.getRow(rownum).getCell(colnum);
		if(Cell==null) {
			Cell=sh.getRow(rownum).createCell(colnum);
			Cell.setCellValue(result);
			System.out.println("the cell been created");
		}else {
			Cell.setCellValue(result);
		}
		FileOutputStream fos=new FileOutputStream(filepath);
		wb.write(fos);
		fos.flush();
		fos.close();

	}






}
