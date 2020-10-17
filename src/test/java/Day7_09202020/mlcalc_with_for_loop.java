package Day7_09202020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class mlcalc_with_for_loop {
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

        //set the values for down payment array list
        ArrayList<String>pPricelist = new ArrayList<>();
        pPricelist.add("350000");
        pPricelist.add("400000");

        //set the values for down payment
        ArrayList<String>dPaymentList = new ArrayList<>();
        dPaymentList.add("30");
        dPaymentList.add("50");

        //call the for loop to iterate through the array list
        for (int i = 0; i < dPaymentList.size(); i++){
            //navigate to mlcalc page
            driver.navigate().to("https://www.mlcalc.com");
            Thread.sleep(2000);

            //clear and enter purchase price
            try{
                System.out.println("Entering new value on Purchase price");
                WebElement pPrice = driver.findElement(By.xpath("//*[@name='ma']"));
                pPrice.clear();
                pPrice.sendKeys(pPricelist.get(i));
            }catch (Exception err){
                System.out.println("Unable to enter value on Purchase Price" +err);
            }//end of purchase price exception

            //clear and enter down payment
            try{
                System.out.println("Entering new value on Down Payment");
                WebElement dpayment = driver.findElement(By.xpath("//*[@name='dp']"));
                dpayment.clear();
                dpayment.sendKeys(dPaymentList.get(i));
            }catch (Exception err) {
                System.out.println("unable to enter value on down payment" +err);
            }//end of down payment exception

            //clicking Calculate button
            try{
                System.out.println("Entering new value on Calculate button");
                driver.findElement(By.xpath("//*[@alt='Calculate']")).click();
            }catch (Exception err) {
                System.out.println("unable to click on Calculate button" +err);
            }//end of Calculate payment exception

            Thread.sleep(2500);

            //capture and print monthly payment
            try{
                System.out.println("Capturing monthly payment");
                String mntPayment = driver.findElements(By.xpath("//*[@class='big']")).get(0).getText();
                System.out.println("My monthly payment is" +mntPayment);
            } catch (Exception err) {
                System.out.println("unable to capture the Monthly Payment" + err);
            }//end of down payment exception




        }//end for loop


    }//end of main method



}//end of java class
