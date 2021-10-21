package com.techproed.excelautomation;

import com.github.javafaker.Country;
import com.techproed.utilities.ExcelUtil;
import org.apache.poi.ss.usermodel.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Day14_ReadExcel {

    @Test
    public void readExcel() throws IOException {
        //Store the path the file in a string
        String path = "./src/test/java/resources/Capitals1.xlsx";

        //Open the file
        FileInputStream fileInputStream = new FileInputStream(path);

        //Open the workbook using fileinputstream
        Workbook workbook = WorkbookFactory.create(fileInputStream);

        //Open the first worksheet
        Sheet sheet = workbook.getSheetAt(0); //indexes of sheet starts at 0

        //Go to first row
        Row firstRow = sheet.getRow(0); //index of row starts at 0

        //Go to first cell on that first row and print
        Cell firstCell = firstRow.getCell(0); //index of cell starts at 0

        System.out.println(firstCell); //COUNTRY




        //Go to second cell on that first row and print
        //Cell secondCell = firstRow.getCell(1);
        Cell row1Cell2 = sheet.getRow(0).getCell(1);
        System.out.println(row1Cell2); //CAPITAL

        //Go to 2nd row first cell and assert if the data equal to USA
        Cell row2Cell1 = sheet.getRow(1).getCell(0);
        boolean isEqual = row2Cell1.toString().equals("USA");
        System.out.println(isEqual); //true because cell's data type is Cell first we need to make it String then compare to assert
        System.out.println(row2Cell1); //USA
        //Assert.assertTrue(isEqual);


        //Go to 3rd row and 2nd cell-chain th row and cell
        Cell row3Cell2 = sheet.getRow(2).getCell(1);
        System.out.println(row3Cell2.toString()); //Paris


        //Find the number of row
        int lastRowNumber =  sheet.getLastRowNum()+1;//index start with 0 that's why add 1 to get right answer
        System.out.println(lastRowNumber); //16

        //Find the number of used row
        int usedNumberOfRow = sheet.getPhysicalNumberOfRows(); //index starts at 1, no need to add 1
        System.out.println(usedNumberOfRow); //11

        //Print country, capital key value pairs as map object

        Map<String, String> worldCapitals = new HashMap<>();
        int countryColumn = 0;
        int capitalColumn = 1;

        /*
        Starting row number: 1 - because Row 0 is Header
        Ending row number: lastRowNumber - sheet.getLastRowNum()+1;
        USA         sheet.getRow(1) .getCell(0)
        France      sheet.getRow(2) .getCell(0)
        England     sheet.getRow(3) .getCell(0)

        D.C         sheet.getRow(1) .getCell(1)
        Paris       sheet.getRow(2) .getCell(1)
        London      sheet.getRow(3) .getCell(1)

        sheet.getRow(rowNumber).getCell(columnNumber)
         */
        for(int rowNumber = 1; rowNumber<lastRowNumber; rowNumber++){
            String countries = sheet.getRow(rowNumber).getCell(countryColumn).toString();
            String capitals = sheet.getRow(rowNumber).getCell(capitalColumn).toString();
            System.out.println("COUNTRIES : " + countries);
            System.out.println("CAPITALS :" + capitals);

            worldCapitals.put(countries,capitals);//adding the countries and capitals in the map

        }

        System.out.println(worldCapitals);
        //{France-R2C0=Paris-R2C1, Greece=Athens, Canada=Ottowa, USA-R1C0=D.C-R1C1, Turkey=Ankara, Norway=Oslo, Japan=Tokya, England=London, Italy=Rome, Germany=Berlin}

    }
 //=================USING excelUtil ===================// short way of codes that we wrote above but with all important shortcut code
    @Test
    public void excelUtilDemo(){
        //We use Util classes to do faster and accurate automation script
        //Using some the ExcelUtil methods
        String path = "./src/test/java/resources/Capitals1.xlsx";
        String sheetName = "capitals_sheet";

        //To use the ExcelUtil Class, first create ExcelUtil Object
        ExcelUtil excelUtil = new ExcelUtil(path, sheetName);

        //Now I can call the reusable excel methods
        //getDataList()
        System.out.println(excelUtil.getDataList()); //[{COUNTRY-R0C0=USA-R1C0, CAPITAL-R0C1=D.C-R1C1}, {COUNTRY-R0C0=France-R2C0, CAPITAL-R0C1=Paris-R2C1}, {COUNTRY-R0C0=England, CAPITAL-R0C1=London}, {COUNTRY-R0C0=Turkey, CAPITAL-R0C1=Ankara}, {COUNTRY-R0C0=Greece, CAPITAL-R0C1=Athens}, {COUNTRY-R0C0=Italy, CAPITAL-R0C1=Rome}, {COUNTRY-R0C0=Canada, CAPITAL-R0C1=Ottowa}, {COUNTRY-R0C0=Germany, CAPITAL-R0C1=Berlin}, {COUNTRY-R0C0=Japan, CAPITAL-R0C1=Tokya}, {COUNTRY-R0C0=Norway, CAPITAL-R0C1=Oslo}]

        //Find the number of column in Capitals
        System.out.println(excelUtil.columnCount()); //2


        //FInd the number of row in Capitals sheet
        System.out.println(excelUtil.rowCount()); //11

        //Find the data in row 9 column 1
        System.out.println(excelUtil.getCellData(8, 0)); //Germany

        //Find the all column names
        System.out.println(excelUtil.getColumnsNames()); //[COUNTRY-R0C0, CAPITAL-R0C1]






    }
}
