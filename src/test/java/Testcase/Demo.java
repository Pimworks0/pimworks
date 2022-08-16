package Testcase;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class Demo {


    public static void main(String[] args) throws IOException {
        String excelPath="./src/Testdata/UploadAttributesTemplate.xlsx";

        File file= new File(excelPath);

        FileInputStream fis= new FileInputStream(file);

        XSSFWorkbook wb= new XSSFWorkbook(fis);

        XSSFSheet sheet= wb.getSheetAt(1);
        Row row = sheet.createRow(0);
        Cell cell = row.createCell(0);
        cell.setCellValue("Written by apache poi");
//        sheet.getRow(0).createCell(2).setCellValue("2.41.0");
//        sheet.getRow(0).createCell(1).setCellValue("cellvalue");

        FileOutputStream fos= new FileOutputStream(file);

        wb.write(fos);
//        wb.close();
//        fos.close();
    }
}
