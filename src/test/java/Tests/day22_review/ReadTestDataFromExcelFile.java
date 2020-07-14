package Tests.day22_review;

import org.testng.annotations.Test;
import utils.ExcelUtil;

import java.util.HashMap;
import java.util.Map;

public class ReadTestDataFromExcelFile {
    @Test
    private void test1(){
        ExcelUtil cars=new ExcelUtil("cars.xlsx","Cars");
        System.out.println(cars.getDataList());
        //get (0) means get data from first row
        //get("color") means get value of color(key) column from first row
        String color=cars.getDataList().get(0).get("Color");
        System.out.println(color);

        //to read the driver name from the excel file
        String driver=cars.getDataList().get(0).get("Driver");
        System.out.println(driver);

        //instead if indexes we use key name(1 row)
        //in list we use index, in map key name
        //every value is referenced by key
        //key must be unique
        //we have to specify data type of key and value<String,String>
        //same thing like with list: List<String>
        //map it is key=value
        //list is index=value
        //key always colum name in map
        Map<String, String> row=new HashMap<>();
        row.put("Licence Plate","777");
        row.put("Driver","SDET driver");
        System.out.println(row.get("Driver"));

        //ex:
        Map<Integer,String> values=new HashMap<>();
        values.put(1,"Filiz");
        System.out.println(values.get(1));
        //exp2
        Map<String, String> countrCodes=new HashMap<>();
        countrCodes.put("USA","+1");
        countrCodes.put("Australia","036");
        countrCodes.put("China","+1");
        countrCodes.put("Kazakhstan","+7");
        countrCodes.put("Ukraine","+380");
        countrCodes.put("South Korea","+1");
        countrCodes.put("Turkey","+90");

        System.out.println(countrCodes.get("Turkey"));


    }
}
