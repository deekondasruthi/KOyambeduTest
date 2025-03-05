package API_Automation;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MerchantAPI_offline {
    @Test
    public void offLinePayment() throws IOException {
         List<String[]> data;
         int n=0;
        // Step 1:

            FileInputStream fileInputStream = new FileInputStream("src/test/resources/DataProvider/offlinePayment.xlsx");
            Workbook workbook = new XSSFWorkbook(fileInputStream);
            Sheet sheet = workbook.getSheetAt(0);  // Assuming data is in the first sheet
            Iterator<Row> rowIterator = sheet.iterator();
            data = new ArrayList<>();

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
        for (String[] row : data) {

            n++;
           // System.out.println(String.valueOf(row[0]) + " "+String.valueOf(row[1])+ "  "+ row[2] + " " +row[3] + " "+row[4] + "  ");
            String requestBody = "{ \"accountId\": \"" +String.valueOf( row[0]) + "\", \"paymentId\": \"" + row[1] + "\", \"success\": " + row[2] + ", \"transactionAmt\": \"" + row[3] + "\", \"terminalId\": \"" + row[4] + "\" }";

            // Make the POST request to the first API endpoint
            Response response1 = RestAssured.given()
                    .baseUri("https://staging-mmsapi.basispay.in") // Replace with your base URI
                    .basePath("/soundBox/soundBoxReqfromPG") // Replace with your API endpoint path
                    .header("x-api-key-id", "xdi4073jx2clwSh7q5Snx8fA4pIg7eIic5t2rtySAurkd4tyam")  // Add Livekey in the header
                    .header("x-api-key-secret", "S6AA5254BmA3SI5xe5fYd5nzsBgo4o8x")  // Add Application-ID in the header
                    .contentType("application/json")
                    .body(requestBody)
                    .post();
            System.out.println("Posted Successfully");

            // Step 2: Validate the first API response and extract the encoded response
            response1.then().statusCode(200); // Check for 200 status code, indicating success

            // Assuming the response contains an 'encodedResponse' field that is Base64 encoded
            // Extract the encoded 'data' field from the response
            String encodedData = response1.jsonPath().getString("message");
            System.out.println("\n " + n+": ******************************");
            System.out.println("\n Message: " + encodedData);
            System.out.println("\n " + n+": ******************************");
        }
    }
}