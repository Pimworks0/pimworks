package Testcase;

import baselibrary.TestBase;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;




public class Democlass
{

    String readExcel (String name, int row, int column, String Path)throws Exception {
        FileInputStream fs = new FileInputStream(Path);
        XSSFWorkbook workbook = new XSSFWorkbook(fs);
        XSSFSheet sheet = workbook.getSheet(name);
        return String.valueOf(sheet.getRow(row).getCell(column));
    }
    public static void main(String[] args) throws Exception {

     Democlass demo= new Democlass();
        System.out.println(demo.readExcel("ProductDetails_verification",0,2,""));


    }
}
