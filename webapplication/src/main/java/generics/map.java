package generics;

import java.util.HashMap;

public class map implements utility{
static HashMap<String,String> rv ;
public static void addDataIntoMap(String sheetname){
    rv = new HashMap<>();
    Excel.openExcel();
    Excel.identifySheet(sheetname);
    int rowCount= Excel.totalRowCount();
    for (int r=0; r<=rowCount;r++){
        Excel.identifyRow(r);
        int cellCount = Excel.totalCellCount();
        for (int c=1;c<cellCount;c++){
            Excel.identifyCell(c-1);
            String key = Excel.identifyData();
            Excel.identifyCell(c);
            String value = Excel.identifyData();
            rv.put(key,value);
        }
    }
}
public static String getDataFromMap(String keyName){
    return rv.get(keyName);
}
}
