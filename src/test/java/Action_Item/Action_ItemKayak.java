package Action_Item;

import Reusable_Library.Reusable_Methods;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Action_ItemKayak {

    //declare all the global variables outside
    WebDriver driver;
    //readable workbook
    Workbook readableFile;
    //readable sheet
    Sheet readableSheet;
    //writable workbook
    WritableWorkbook writableFile;
    //writable sheet
    WritableSheet writableSheet;
    //int rowCount;

    @BeforeSuite
    public void setDriver() throws IOException, BiffException {
        //locate readable excel file
        readableFile = Workbook.getWorkbook(new File("src/main/resources/Kayak.xls"));
        //locate readable sheet
        Sheet readableSheet = readableFile.getSheet(0);
        //define the path to create writable file
        writableFile = Workbook.createWorkbook(new File("src/main/resources/Kayak_result.xls"),readableFile);
        //create writable sheet
        writableSheet = writableFile.getSheet(0);
        //defined the driver
        driver = Reusable_Methods.getDriver();
    }//end of BeforeMethod

    @Test
    public void kayak_actionItem() throws InterruptedException, WriteException {

        int rows = writableSheet.getRows();

        for (int i = 1; i < rows; i++) {

            //store the airport column as string variable
            String airPort = writableSheet.getCell(0, i).getContents();
            //store the start date column as string variable
            String startDate = writableSheet.getCell(1, i).getContents();
            //store the start time column as string variable
            String startTime = writableSheet.getCell(2, i).getContents();
            //store the end date column as string variable
            String endDate = writableSheet.getCell(3, i).getContents();
            //store the end time column as string variable
            String endTime = writableSheet.getCell(4, i).getContents();
            //store the vehicle size column as string variable
            String vehicleSize = writableSheet.getCell(5, i).getContents();
            //store the pick up column as string variable
            String pickUp = writableSheet.getCell(6, i).getContents();
            //store the drop off column as string variable
            String dropOff = writableSheet.getCell(7,i).getContents();
            //store the total due column as string variable
            String totalDue = writableSheet.getCell(8,i).getContents();

            //navigate to kayak.com
            //empty out all cookies
            driver.manage().deleteAllCookies();
            driver.navigate().to("https://www.kayak.com");

            Thread.sleep(2000);

            //click airport or city
            Reusable_Methods.click(driver,"//*[text()='Enter an airport or city']","Search Field");
            Thread.sleep(2000);
            //enter the airport
            Reusable_Methods.typeAndSubmit(driver,"//*[@name='pickup']",airPort,"Search Field");
            Thread.sleep(2000);
            //click on start date
            Reusable_Methods.click(driver,"//*[@data-placeholder='Pick-up']","startDate");
            Thread.sleep(2000);
            //enter start date
            Reusable_Methods.typeAndSubmit(driver,"//*[contains(@id,'pickup-date-input')]",startDate,"start date");
            //click outside
            Reusable_Methods.click(driver,"//*[@class='title dark']","click on empty space");
            Thread.sleep(2000);
            //click on start time
            Reusable_Methods.mouseClick(driver,"//*[contains(@id,'start-time-select-display')]","start time");
            //enter start time
            Reusable_Methods.click(driver,"//*[contains(@id,'start-time-select-option') and @data-title='10:00 am']","time");
            //click outside
            Reusable_Methods.click(driver,"//*[@class='title dark']","click on empty space");
            //click on end date
            Reusable_Methods.mouseClick(driver,"//*[@class=' _id7 _ijM _idA _ioF _ii0 _j0G _iQh']","end date");
            Thread.sleep(2000);
            //enter end date
            Reusable_Methods.typeAndSubmit(driver,"//*[@id='aqpq-dropoff-date-input']",endDate,"end date");
            Thread.sleep(3000);
            //click outside
            Reusable_Methods.click(driver,"//*[@class='title dark']","click on empty space");
            //click on end time
            Reusable_Methods.click(driver,"//*[contains(@id,'end-time-select-display')]","endTime");
            Thread.sleep(2000);
            //enter end time
            Reusable_Methods.click(driver,"//*[contains(@id,'start-time-select-option') and @data-title='10:00 am']","end time");
            Thread.sleep(2000);

            //click outside
            Reusable_Methods.click(driver,"//*[@class='title dark']","click on empty space");

            //click on search
            Reusable_Methods.click(driver,"//*[contains(@id,'submit')]","submit");

            //select size
            Reusable_Methods.clickByIndex(driver,"//*[@class='MPti']",1,"size");

            //click on third index for View Deal
            Reusable_Methods.mouseClick(driver,"//*[class='_iac _ikn _h-2 _iab _iaB _id7 _ia1 _iAr _iiZ _idj _ii0 _iir _inw']","view Deal");

            //go on a new tab
            Thread.sleep(2000);
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));


        }//end of loop


    }//end of kayak Test

    @AfterSuite
    public void quitDriver() throws IOException, WriteException {
        writableFile.write();
        writableFile.close();
        readableFile.close();
        driver.quit();

    }//end of AfterMethod





}//end of Java class
