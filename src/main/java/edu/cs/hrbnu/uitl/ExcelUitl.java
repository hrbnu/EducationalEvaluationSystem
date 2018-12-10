package edu.cs.hrbnu.uitl;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

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
}
