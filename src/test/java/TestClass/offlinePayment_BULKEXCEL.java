package TestClass;

import BaseClass.BaseClass;
import PageObjectsClass.offlinePageObjects;
import actionclass.actionClass;
import configFileReader.configFileRead;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class offlinePayment_BULKEXCEL extends BaseClass {
    @Test(invocationCount = 1)
    public void offlinePayment() throws IOException, InterruptedException {


        actionClass act = new actionClass();

        List<String[]> data;

        // Step 1:

        FileInputStream fileInputStream = new FileInputStream("src/test/resources/DataProvider/offlinePaymentQRURL.xlsx");
        Workbook workbook = new XSSFWorkbook(fileInputStream);
        Sheet sheet = workbook.getSheetAt(0);  // Assuming data is in the first sheet
        Iterator<Row> rowIterator = sheet.iterator();
        data = new ArrayList<>();
        int no_of_rows = sheet.getLastRowNum();
        int no_of_columns=sheet.getRow(0).getLastCellNum();
        rowIterator.next(); // Skip header row

        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            String[] rowData = new String[row.getPhysicalNumberOfCells()];
            for (int i = 0; i < row.getPhysicalNumberOfCells(); i++) {
                rowData[i] = String.valueOf(row.getCell(i));
            }
            data.add(rowData);
        }


        workbook.close();


        // Fill the shop update form with the data
        for (int colIndex = 0; colIndex < no_of_columns; colIndex++) {
            for (String[] row : data) {


                driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
                PageFactory.initElements(driver, offlinePageObjects.class);

                act.clear(offlinePageObjects.getSubMID());
                act.sendKeys(offlinePageObjects.getSubMID(), row[0]);
                //Thread.sleep(2000);
                act.clear(offlinePageObjects.getMtID());
                act.sendKeys(offlinePageObjects.getMtID(), row[1]);
                //Thread.sleep(2000);
                act.clear(offlinePageObjects.getPayerAmount());
                act.sendKeys(offlinePageObjects.getPayerAmount(), row[2]);
                act.click(offlinePageObjects.getSubmit());
                Thread.sleep(4000);
                driver.get(configFileRead.getURL());

            }}

        }
    }


