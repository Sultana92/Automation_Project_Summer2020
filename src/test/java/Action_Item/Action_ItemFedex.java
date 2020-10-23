package Action_Item;

import Reusable_Library.Abstract_Class_Cross_Browser;
import Reusable_Library.Reusable_Methods;
import Reusable_Library.Reusable_Methods_Loggers;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

public class Action_ItemFedex extends Abstract_Class_Cross_Browser {

    @Test
    public void Fedex_search() throws InterruptedException {
        logger.log(LogStatus.INFO,"Navigating to Fedex Home page");
        driver.navigate().to("https://www.fedex.com/en-us/home.html");

        //click on design
        Reusable_Methods_Loggers.clickByIndex(driver,"//*[@class='fxg-link fxg-dropdown-js  fxg-keyboard']",2,logger,"Design & Print");
        //click on upload a print ready file
        Reusable_Methods_Loggers.click(driver,"//*[@href='https://www.fedex.com/apps/printonline/#!']","Upload a Print-Ready file");
        //verify the page title
        Reusable_Methods_Loggers.verifyTitle(driver,"FedEx Office Print Online",logger);
        //click on documenting printing image
        Reusable_Methods_Loggers.clickByIndex(driver,"//*[@class='cart-tile-image']",2,logger,"Document Printing");
        //click on copies & custom project
        Reusable_Methods_Loggers.clickByIndex(driver,"//*[@class='get-started']",3,logger,"copies & custom project");
        //click on use your file button
        Reusable_Methods_Loggers.clickByIndex(driver,"//*[@name='upload-files-button']",0,logger,"Use Your File");
        //upload file
        Reusable_Methods_Loggers.uploadFile(driver,"upload",logger,"C:\\Users\\sumay\\OneDrive\\Desktop\\IT CLASS SLIDES\\DSC00057");
        Thread.sleep(4000);
        //change quantity
        Reusable_Methods_Loggers.sendKeys(driver,"//*[@class='quantity-field']","5",logger,"quantity");
        //click on add to cart
        Reusable_Methods_Loggers.click(driver,"//*[@class='cart-addbtn btn fxg-btn-orange full update_quantity_checkout_btn']","cart");
        //click on checkout
        Reusable_Methods_Loggers.click(driver,"//*[@oneclick='javascript:setLinkView('Checkout');']","checkout");
        //continue as guest
        Reusable_Methods_Loggers.click(driver,"//*[@id='continueAsGuest']","continue as a quest");
        //select mile
        Reusable_Methods_Loggers.dropDownMenu(driver,"//*[@class='sel-fedaddaccount-small-1 blue-text font-size-large']","5",logger,"radius");
        //enter zipcode
        Reusable_Methods_Loggers.sendKeys(driver,"//*[@id='loc_seacrh_text']","11218",logger,"zipcode");
        //click continue
        Reusable_Methods_Loggers.click(driver,"//*[@id='saveNContBtn']","continue");
        //capture result
        String result = Reusable_Methods_Loggers.captureResult(driver,"//*[@class='active']",logger,"Search Result");
        //String[] arrayResult = result.split(" ");
        logger.log(LogStatus.PASS,"My nearby store info is " + result);



    }
}
