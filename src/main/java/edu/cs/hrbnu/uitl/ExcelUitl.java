package edu.cs.hrbnu.uitl;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ExcelUitl {

    // 获取Workbook
    public static Workbook getWorkbook(String filePath){
        File file = new File(filePath);
        InputStream inputStream = null;
        try{
            inputStream = new FileInputStream(file);
        }catch (IOException ex){
            ex.printStackTrace();
        }

        // 看是xls格式还是xlsx格式
        char species = filePath.charAt(filePath.length()-1);
        Workbook workbook = null;
        try{
            if(species == 's'){
                workbook = new HSSFWorkbook(inputStream);
            }else{
                workbook = new XSSFWorkbook(inputStream);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return workbook;
    }

    // 创建xlsx格式excel，需要传入sheet、title、content
    public static XSSFWorkbook getXSSFWorkbook(String sheetName,String[] title,String[][] content){
        // 基本构造
        XSSFWorkbook wb = new XSSFWorkbook();
        XSSFSheet sheet = wb.createSheet(sheetName);
        XSSFRow row = sheet.createRow(0);

        // 列名
        XSSFCell cell = null;
        for(int i = 0;i < title.length;i++){
            cell = row.createCell(i);
            cell.setCellValue(title[i]);
        }

        // 填充内容
        for(int i = 0;i < content.length;i++){
            // 第一行是标题，从第二行开始
            row = sheet.createRow(i+1);
            for(int j = 0;j < title.length;j++){
                row.createCell(j).setCellValue(content[i][j]);
            }
        }

        return wb;
    }
}
