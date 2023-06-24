package com.playlists;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

public class ReadExcel {

    public static void main(String ... a) throws IOException {
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/playlists/"+"data1.xlsx");
        XSSFWorkbook book = new XSSFWorkbook(fis);
        XSSFSheet sheet = book.getSheetAt(0);
        Iterator<Row> rows = sheet.iterator();

        while(rows.hasNext())
        {
//            rows.next().getPhysicalNumberOfCells();
                Iterator<Cell> cells = rows.next().cellIterator();
            while(cells.hasNext())
            {
                System.out.print(cells.next()+"  ");
            }
            System.out.println("");
        }
    }
}
