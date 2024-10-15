package com.saucedemo.automatedtests.utils;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.Objects;

public class ReadExcelFile {

    HSSFWorkbook workbook;
    HSSFSheet worksheet;

    //Constructor
    public ReadExcelFile(String excel_path){
        try {
            ClassLoader classLoarder = getClass().getClassLoader();
            File src = new File(Objects.requireNonNull(classLoarder.getResource(excel_path)).getFile());
            FileInputStream fis = new FileInputStream(src);
            workbook = new HSSFWorkbook(fis);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    //Method to get the data from the sheet
    public String getData(int sheet_number, int row, int column){
        worksheet = workbook.getSheetAt(sheet_number);
        return worksheet.getRow(row).getCell(column).getStringCellValue();
    }

    //Method to count the number of rows in a given sheet
    public int getRowCount(int sheetIndex){
        int row = workbook.getSheetAt(sheetIndex).getLastRowNum();
        row = row + 1;
        return row;
    }
}
