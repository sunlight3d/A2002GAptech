/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aptech.data;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

public class ExcelManager {
    private String fileName;
    private Workbook workbook;
    ExcelManager(String fileName) {
        this.fileName = fileName;
    }
    public void readDataFromExcel(){                
        this.workbook = WorkbookFactory.create(new File("./"+this.fileName));
    }
    public void updateDataToExcel(){
    }
}
