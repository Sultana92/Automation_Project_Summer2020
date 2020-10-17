package Day7_09202020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Try_catch_in_mlcalc {
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
        WebDriver driver = new ChromeDriver(options);//options variable should be passed

        //navigate to mlcalc website
        driver.navigate().to("https://www.mlcalc.com");
        //delay 2 seconds
        Thread.sleep(2000);

        //clear and enter purchase price
        try{
            System.out.println("Entering new value on Purchase Price");
            WebElement pPrice = driver.findElement(By.xpath("//*[@name='ma']"));
            pPrice.clear();
            pPrice.sendKeys("400000");
        }catch (Exception err){
            System.out.println("Unable to enter value on Purchase Price" +err);
        }//end of purchase price exception

        //clear and enter down payment
        try{
            System.out.println("Entering new value on Down Payment");
            WebElement dpayment = driver.findElement(By.xpath("//*[@name='dp']"));
            dpayment.clear();
            dpayment.sendKeys("40");
        }catch (Exception err) {
            System.out.println("unable to enter value on down payment" +err);
        }//end of down payment exception

        //select a start month
        try{
            WebElement startMonth = driver.findElement(By.xpath("//*[@name='sm']"));
            Select smList = new Select(startMonth);
            smList.selectByVisibleText("Feb");
        }catch (Exception err){
            System.out.println("Unable to select start month" + err);
        }//end of down payment exception

        //click on calculate
        try{
            driver.findElement(By.xpath("//*[@alt='Calculate']")).click();
        }catch (Exception err){
            System.out.println("unable to click on Calculate button" + err);
        }//end of Calculate exception

    }//end of main method


}//end of Java class
