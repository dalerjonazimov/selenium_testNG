package com.techproed.notes;

public class Day14_Notes {
}

/*
EXCEL AUTOMATION

1. Must use apache.po and poi-ooxml  dependencies in pom file
2. Use excelUtiles class to test in short way
3. Then can use microsoft files

4.EXCEL consist of:
    workbook : the excile file
    worksheet: each open excel tab like Sheet1, Sheet2... pages
    row: Java counts rows if and only if there is data inside. By Default, the number of row is 0
    cells: Java will look at each row and count the number of cell if any only if there is data in the cell
    ===================================================================
    Workbook>Worksheet>Row>Cell   : there is no Column from the Java Perspective
    ===================================================================


*******dependencies****************
  <!-- https://mvnrepository.com/artifact/org.apache.poi/poi -->
        <dependency>
            <groupId>org.apache.poi</groupId>
            <artifactId>poi</artifactId>
            <version>4.1.2</version>
        </dependency>
        <!-- https://mvnrepository.com/artifact/org.apache.poi/poi-ooxml -->
        <dependency>
            <groupId>org.apache.poi</groupId>
            <artifactId>poi-ooxml</artifactId>
            <version>4.1.2</version>
        </dependency>
********************************************
*********test example************

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
 */
