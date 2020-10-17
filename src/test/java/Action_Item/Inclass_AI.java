package Action_Item;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.swing.*;
import java.util.ArrayList;

public class Inclass_AI {
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
        WebDriver driver = new ChromeDriver(options);//options variables should be passed
        ArrayList<String> destination = new ArrayList<>();
        destination.add("Philadelphia, Pennsylvania, United States of America");
        destination.add("Miami, Florida, United States of America");
        destination.add("Boston, Massachusetts, United States of America");

        ArrayList<String> CheckIn = new ArrayList<>();
        CheckIn.add("9/27/20");
        CheckIn.add("9/28/20");
        CheckIn.add("9/29/20");

        ArrayList<String> CheckOut = new ArrayList<>();
        CheckOut.add("9/30/20");
        CheckOut.add("10/01/20");
        CheckOut.add("10/31/20");

        //for loop
        for (int i = 0; i < destination.size(); i++){

            //navigate
            driver.navigate().to("https://www.hotels.com");

            //entering destination
            try{
                System.out.println("Entering destination");
                WebElement hotel = driver.findElement(By.xpath("//*[@name='q-destination']"));
                hotel.clear();
                hotel.sendKeys(destination.get(i));
            } catch (Exception err){
                System.out.println("unable to enter destination" + err);
            }//end of entering destination
            Thread.sleep(2000);

            //select check in date
            try{
                System.out.println("Entering check in date");
                WebElement checkIn = driver.findElement(By.xpath("//*[@name='q-localised-check-in']"));
                checkIn.clear();
                checkIn.sendKeys(CheckIn.get(i));

            } catch (Exception err){
                System.out.println("unable to enter CheckIN" + err);
            }//end of entering check in date
            Thread.sleep(2000);

            //select check out date
            try{
                System.out.println("Entering check out date");
                WebElement checkOut = driver.findElement(By.xpath("//*[@name='q-localised-check-out']"));
                checkOut.clear();
                checkOut.sendKeys(CheckOut.get(i));

            } catch (Exception err){
                System.out.println("unable to enter CheckOut" + err);
            }//end of entering check out date

            //entering guest number
            try{
                System.out.println("Entering destination");
                WebElement guest = driver.findElements(By.xpath("//*[@name='q-room-0-adults']")).get(1);
            } catch (Exception err){
                System.out.println("unable to enter guest number" + err);
            }//end of entering destination

            //click on search
            try{
                System.out.println("click on search");
                driver.findElement(By.xpath("//*[@type='submit']")).click();
            } catch (Exception err) {
                System.out.println("unable to click on search" + err);
            }//end of click exception
            Thread.sleep(2000);





        }//end of for




    }//end of main method


}//end of java class
