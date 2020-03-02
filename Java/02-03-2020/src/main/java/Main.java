public class Main {
    //what is pom.xml, a file to store external library(not core Java Library)
    //For example, in your practical project, you need to read excel file using Java
    //do you want to make an exercise like "read/write an excel file" using external library ?
    //This is not in our course
    //Ex1: we have an .xlsx file with points: math, physics, chemistry
    //=> we use java to calculate sum, average,.. output and save to this excel file
    public static void main(String[] args) {
        ExcelManager excelManager = new ExcelManager("C:\\temp\\input.xlsx");
        excelManager.readDataFromExcel();
    }
}
