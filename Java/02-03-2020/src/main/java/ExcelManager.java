import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

public class ExcelManager {
    private String fileName;
    private Workbook workbook;
    ExcelManager(String fileName) {
        this.fileName = fileName;
    }
    private DataFormatter dataFormatter = new DataFormatter();
    public void readDataFromExcel(){
        try {
            this.workbook = WorkbookFactory.create(new File(this.fileName));
            Sheet firstSheet = this.workbook.getSheetAt(0);
            Iterator<Row> rowIterator = firstSheet.rowIterator();
            int i = 0;
            while (rowIterator.hasNext()) {
                //Bypass the first cell ?
                Row row = rowIterator.next();
                if(i == 0) {
                    i++;
                    continue;
                }
                //convert string to Float
                Float mathPoint = Float.valueOf(dataFormatter.formatCellValue(row.getCell(0)));
                Float physicsPoint = Float.valueOf(dataFormatter.formatCellValue(row.getCell(1)));
                Float chemistryPoint = Float.valueOf(dataFormatter.formatCellValue(row.getCell(2)));
                Float sum = mathPoint + physicsPoint + chemistryPoint;
                Float average = sum / 3.0f;
                Cell sumCell = row.getCell(3);
                Cell averageCell = row.getCell(4);
                sumCell.setCellType(CellType.NUMERIC);
                sumCell.setCellValue(sum);

                averageCell.setCellValue(average);
                averageCell.setCellType(CellType.NUMERIC);
                System.out.println("haha");

                i++;
            }
            FileOutputStream fileOut = new FileOutputStream(this.fileName+"output");
            workbook.write(fileOut);
            this.workbook.close();
        }catch (Exception error) {
            System.err.println("Cannot read the excel file"+error.getStackTrace());
        }
    }
    public void updateDataToExcel(){
    }
}
