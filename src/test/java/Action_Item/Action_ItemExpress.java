package Action_Item;

import Reusable_Library.Abstract_Class;
import Reusable_Library.Reusable_Methods;
import Reusable_Library.Reusable_Methods_Loggers;
import com.relevantcodes.extentreports.ExtentReports;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class Action_ItemExpress extends Abstract_Class {


    @Test
    public void Express_Abstract() throws IOException, BiffException, InterruptedException, WriteException {
        //readable workbook
        Workbook readableFile;
        //readable sheet
        Sheet readableSheet;
        //writable workbook
        WritableWorkbook writableFile;
        //writable sheet
        WritableSheet writableSheet;
        int rowCount;

        //locate readable excel file
        readableFile = Workbook.getWorkbook(new File("src/main/resources/Express.xls"));
        //locate readable sheet
        readableSheet = readableFile.getSheet(0);
        //define the path to create writable file
        writableFile = Workbook.createWorkbook(new File("src/main/resources/Express_result.xls"),readableFile);
        //create writable sheet
        writableSheet = writableFile.getSheet(0);
        //define the report path
        reports = new ExtentReports("src//main//java//HTML_Report//Express.html",true);

        int rows = writableSheet.getRows();
        logger = reports.startTest("Express Result");

        for(int i = 1; i < rows; i++) {

            //store the size column as string variable
            String size = writableSheet.getCell(0, i).getContents();
            //store the Quantity column as string variable
            String Quantity = writableSheet.getCell(1, i).getContents();
            //store the First name column as string variable
            String firstName = writableSheet.getCell(2, i).getContents();
            //store the last name column as string variable
            String lastName = writableSheet.getCell(3, i).getContents();
            //store the email column as string variable
            String email = writableSheet.getCell(4, i).getContents();
            //store the phone number column as string variable
            String phoneNumber = writableSheet.getCell(5, i).getContents();
            //store the street address column as string variable
            String streetAddress = writableSheet.getCell(6, i).getContents();
            //store the zipcode column as string variable
            String zipCode = writableSheet.getCell(7, i).getContents();
            //store the city column as string variable
            String city = writableSheet.getCell(8, i).getContents();
            //store the state column as string variable
            String state = writableSheet.getCell(9, i).getContents();
            //store the credit card number column as string variable
            String creditCard = writableSheet.getCell(10, i).getContents();
            //store the expire month column as string variable
            String expireMonth = writableSheet.getCell(11, i).getContents();
            //store the expire year column as string variable
            String expireYear = writableSheet.getCell(12, i).getContents();
            //store the CVV column as string variable
            String CVV = writableSheet.getCell(13, i).getContents();
            //store the error message as string variable
            String errorMessage = writableSheet.getCell(14,i).getContents();

            //open a home page
            driver.navigate().to("https://www.express.com");
            //verify title
            Reusable_Methods_Loggers.verifyTitle(driver,"Men's and Women's Clothing",logger);
            //hoover oven men's
            Reusable_Methods.mouseHover(driver,"//*[@href='/mens-clothing']","mens");
            //click on shirts
            //Reusable_Methods_Loggers.click(driver,"//*[@href='/mens-clothing/shirts/cat410008']","shirts");
            Reusable_Methods_Loggers.click(driver,"//*[text()='Shirts']","shirts");
            Thread.sleep(6000);
            //need to scroll little down
            JavascriptExecutor jse = (JavascriptExecutor)driver;
            //scroll down using executeScript command
            jse.executeScript("scroll(0,400)");
            //click on third image
            Reusable_Methods_Loggers.clickByIndex(driver,"//*[@class='_1ddDj _136PD']",2,logger,"3");
            //Reusable_Methods_Loggers.click(driver,"//*[text()='Extra Slim Floral Stretch Cotton 1MX']","third image");
            Thread.sleep(3000);

            //click on size
            Reusable_Methods_Loggers.mouseClick(driver, "//*[@value='"+size+"']","size");

            //need to scroll little down
            JavascriptExecutor jsce = (JavascriptExecutor)driver;
            //scroll down using executeScript command
            jsce.executeScript("scroll(0,400)");

            //add to bag
            Thread.sleep(2000);
            Reusable_Methods.mouseClick(driver,"//*[text()='Add to Bag']","add to bag");

            //click on bag icon
            Reusable_Methods.clickByIndex(driver,"//*[@class='HoverableSlideOutModal_modal__2xYUD DesktopHeader_modalContainer__8Q61X']",2,"bag");

            Thread.sleep(2000);

            //select quantity
            Reusable_Methods_Loggers.dropDownMenu(driver,"//*[@class='dropdown__select _2dMWs inputInactive _34Evv']",Quantity,logger,"quantity");

            //continue to checkout
            Reusable_Methods_Loggers.click(driver,"//*[@id='continue-to-checkout']","checkout");

            //click on checkout as guest
            Reusable_Methods_Loggers.mouseClick(driver,"//*[text()='Checkout as Guest']","guest");
            Thread.sleep(2000);

            //enter first name
            Reusable_Methods_Loggers.sendKeys(driver,"//*[@name='firstname']",firstName,logger,"First name");
            //enter last name
            Reusable_Methods_Loggers.sendKeys(driver,"//*[@name='lastname']",lastName,logger,"Last name");
            //enter email address
            Reusable_Methods_Loggers.sendKeys(driver,"//*[@class='ff8oN has-error inputInactiveError _3Lgrd']",email,logger,"Email");
            //enter confirm email
            Reusable_Methods_Loggers.sendKeys(driver,"//*[@class='ff8oN inputInactive _3Lgrd']",email,logger,"Confirm email");
            //enter phone number
            Reusable_Methods_Loggers.sendKeys(driver,"//*[@name='phone']",phoneNumber,logger,"Phone number");
            //click on continue
            Reusable_Methods_Loggers.click(driver,"//*[@class='btn _9yfmt _194FD _2tFXQ _2SogC']","Continue");
            //enter address
            Reusable_Methods_Loggers.sendKeys(driver,"//*[@name='shipping.line1']",streetAddress,logger,"Street address");
            //enter zipcode
            Reusable_Methods_Loggers.sendKeys(driver,"//*[@name='shipping.postalCode']",zipCode,logger,"ZipCode");
            //enter city
            Reusable_Methods_Loggers.sendKeys(driver,"//*[@name='shipping.city']",city,logger,"City");
            //select state
            Reusable_Methods_Loggers.dropDownMenu(driver,"//*[@id='rvndd--shipping.state--5']",state,logger,"State");
            //click on continue
            Reusable_Methods_Loggers.click(driver,"//*[@class='btn _9yfmt _194FD _2tFXQ _2SogC']", "Continue Again");
            //continue
            Reusable_Methods_Loggers.click(driver,"//*[@class='btn _9yfmt _194FD _2tFXQ _2SogC']","CONTINUE");
            //enter card number
            Reusable_Methods_Loggers.sendKeys(driver,"//*[@name='creditCardNumber']",creditCard,logger,"cardNumber");
            //expire month
            Reusable_Methods_Loggers.dropDownMenu(driver,"//*[@name='expMonth']",expireMonth,logger,"expire month");
            //expire year
            Reusable_Methods_Loggers.dropDownMenu(driver,"//*[@name='expYear']",expireYear,logger,"expire year");
            //enter cvv
            Reusable_Methods_Loggers.sendKeys(driver,"//*[@name='cvv']",CVV,logger,"cvv");
            //place order
            Reusable_Methods_Loggers.click(driver,"//*[text()='Place Order']","place order");
            //capture message
            String error = Reusable_Methods_Loggers.captureResult(driver,"//*[@class='dOxMH labelError']",logger,"error");

            System.out.println("the error message is " + error);
            //write the error message back to writable sheet
            Label label = new Label(14,i,error);


            //adding back to writable cell
            writableSheet.addCell(label);



            driver.manage().deleteAllCookies();

        }//end of loop
        writableFile.write();
        writableFile.close();
        readableFile.close();
    }//end of @Test
}//end of java class
