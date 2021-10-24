package com.techproed.excelautomation;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

//Create a new class: WriteExcel
public class Day15_WriteExcel {

    //Create a new method: writeExcel()
    @Test
    public void writeExcel() throws IOException {
//Store the path of the file as string and open the file
        String path = "./src/test/java/resources/Capitals.xlsx";
//Open the workbook
        //Open the file
        FileInputStream fileInputStream = new FileInputStream(path);
        //Open the workbook using fileinputstream
        Workbook workbook = WorkbookFactory.create(fileInputStream);
//Open the first worksheet
        Sheet sheet = workbook.getSheetAt(0); //indexes of sheet starts at 0
//Go to the first row
        Row firstRow = sheet.getRow(0); //index of row starts at 0
//Create a cell on the 3rd column (2nd index) on the first row
        //create a cell on 3rd column (2nd index)
        Cell row1Cell3 = firstRow.createCell(2);
//Write “POPULATION” on that cell
        row1Cell3.setCellValue("POPULATION");
//Create a cell on the 2nd row 4th cell(index3), and write 150000
        sheet.getRow(1).createCell(2).setCellValue("150000");
//Create a cell on the 3rd row 4th cell(index3), and write 250000
        sheet.getRow(2).createCell(2).setCellValue("250000");
//Create a cell on the 4th row 4th cell(index3), and write 54000
        sheet.getRow(3).createCell(2).setCellValue("54000");
//Write and save the workbook
        //if you create a cell but not save it will not show in the excel
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        workbook.write(fileOutputStream); //saving the entered data or any update
//Close the file
        fileInputStream.close();
        fileOutputStream.close();

//Close the workbook
        workbook.close();

    }
}
/*








 */
