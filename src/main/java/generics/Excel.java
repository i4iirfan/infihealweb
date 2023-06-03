package generics;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;


public class Excel implements utility {
    static Workbook wb;
    static Sheet s;
    static Row r;
    static Cell c;

    public static void openExcel(){
        try {
            wb = WorkbookFactory.create(new FileInputStream(excelPath));
        } catch (Exception e) {
        }
    }
    public static void identifySheet(String sheetname){
        s= wb.getSheet(sheetname);
    }
    public static int totalRowCount(){
        return s.getLastRowNum();
    }
    public static void identifyRow(int rownum){
        r= s.getRow(rownum);

    }public static int totalCellCount(){
        return r.getLastCellNum();
    }
    public static void identifyCell(int cellnum){
        c= r.getCell(cellnum);
    }
    public static String identifyData(){
        return c.toString();
    }
}
