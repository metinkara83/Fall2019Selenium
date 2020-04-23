package com.automation.tests.day28_write_into_Excel;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;

public class WriteIntoExcelFile {

    @Test
    public void writeIntoFileTest() throws IOException {
        FileInputStream inputStream = new FileInputStream("VytrackTestUsers.xlsx");
        Workbook workbook = WorkbookFactory.create(inputStream);
        inputStream.close();
        Sheet sheet = workbook.getSheet("QA3-short");
        Row row = sheet.getRow(1); // 2nd row
        Cell cell = row.getCell(5); // last column
        System.out.println("Before :: "+cell.getStringCellValue());
        cell.setCellValue("FAILED"); // I am changing from n/a to passed
        System.out.println("After :: "+cell.getStringCellValue());

        Row firstRow = sheet.getRow(0); // get first row
        Cell newCell = firstRow.createCell(6); // create new cell
        newCell.setCellValue("Date of execution"); // give the name to this cell

        Row secondRow = sheet.getRow(1);
        Cell newCell2 = secondRow.createCell(6);
        newCell2.setCellValue(LocalDateTime.now().toString());

        FileOutputStream outputStream = new FileOutputStream("VytrackTestUsers.xlsx");
        workbook.write(outputStream);
        workbook.close();
    }
}
