package Action_Item;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;

public class Action_item3 {
    public static void main(String[] args) throws InterruptedException {
        //set the chrome driver location
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        //setting the chrome options before defining the driver
        ChromeOptions options = new ChromeOptions();
        //set the driver to be maximized
        options.addArguments("start-maximized");
        //set the driver to be incognito mode(private)
        options.addArguments("incognito");
        //run the driver in headless mode
        //options.addArguments("Headless");

        //defining the web driver that will be using
        WebDriver driver = new ChromeDriver(options);//options variables should be closed

        //set the value for zipcode
        ArrayList<String> zipcode = new ArrayList<>();
        zipcode.add("11218");
        zipcode.add("11354");
        zipcode.add("10001");

        //for loop
        for (int i = 0; i < zipcode.size(); i++){

        //navigate to weightwatcher.com
        driver.navigate().to("https://www.weightwatchers.com");

        //capture the title
        String actualTitle = driver.getTitle();
        //verify it matches the expected title
        if (actualTitle == "Weight Watcher: Weight Loss & Welness Help"){
            System.out.println("Title matches as expected");
        }else {
            System.out.println("Title doesn't match. Actual title is  " + actualTitle);
        }//end of conditional statement

            //click on studio list
            try{
                System.out.println("click on studio list");
                driver.findElement(By.xpath("//*[@data-e2e-name='find_a workshop']")).click();
            } catch (Exception err) {
                System.out.println("unable to click on studio" + err);
            }//end of click exception
        Thread.sleep(2000);

        //enter zipcode
            try{
                System.out.println("Entering zipcode");
                WebElement zipCode = driver.findElement(By.xpath("//*[@id='location-search']"));
                zipCode.clear();
                zipCode.sendKeys(zipcode.get(i));
            } catch (Exception err){
                System.out.println("unable to enter zipcode" + err);
            }//end of entering zipcode

        //click on search arrow
            try{
                System.out.println("click on search arrow");
                driver.findElement(By.xpath("//*[@id='location-search-cta']")).click();
            } catch (Exception err) {
                System.out.println("unable to click on search arrow" + err);
            }//end of click exception
            Thread.sleep(2000);


            if (i==0){
                driver.findElements(By.xpath("//*[@class='linkUnderline-1_h4g']")).get(0).click();
                Thread.sleep(2000);
            }if (i==1){
                driver.findElements(By.xpath("//*[@class='linkUnderline-1_h4g']")).get(1).click();
                Thread.sleep(2000);
            }if (i==2){
                driver.findElements(By.xpath("//*[@class='linkUnderline-1_h4g']")).get(2).click();
                Thread.sleep(2000);
            }//end of if

            Thread.sleep(2000);

            //capture & print address
            try{
                System.out.println("capture studio address");
                String address = driver.findElement(By.xpath("//*[@class='infoContainer-12kv1 noMap-1gRjF']")).getText();
                //address.getText();
                System.out.println("capture address " +address);
            } catch (Exception err) {
                System.out.println("unable to capture address" + err);
            }//end of capture address
            Thread.sleep(2000);

            //need to scroll to the bottom of the page capture the search result
            JavascriptExecutor jse = (JavascriptExecutor)driver;
            jse.executeScript("scroll(0,1000)");
            Thread.sleep(2000);

            //capture & print schedule
            try{
                System.out.println("capture schedule");
                String schedule = driver.findElement(By.xpath("//*[@class='workshopSchedule-2foP8']")).getText();
                System.out.println("My schedule is " +schedule);
            } catch (Exception err) {
                System.out.println("unable to capture schedule" + err);
            }//end of capture schedule

        }//end of for loop

    }//end of main method

}//end of java class
