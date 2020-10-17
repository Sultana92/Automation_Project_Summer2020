package Day7_09202020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import javax.swing.*;
import java.util.ArrayList;

public class Array_List {
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

        //click on different months from the drop down using array list
        //ArrayList<String> smList = new ArrayList<>();
        ArrayList<String> smList = new ArrayList<>();
        smList.add("Oct");
        smList.add("Feb");
        smList.add("Mar");
        smList.add("Apr");
        smList.add("May");
        smList.add("Jun");
        smList.add("Jul");
        smList.add("Jan");


        //navigate to mlcalc website
        driver.navigate().to("https://www.mlcalc.com");
        Thread.sleep(1000);
        //using loop I want to iterate through all month list and click on each one
        for (int i = 0; i < smList.size(); i++){
            WebElement startMonth = driver.findElement(By.xpath("//*[@name='sm']"));
            Select smDropdown = new Select(startMonth);
            smDropdown.selectByVisibleText(smList.get(i));

            //selecting start month when the html tag is not under Select tag
            driver.findElement(By.xpath("//*[@name='sm']")).click();
            Thread.sleep(500);
            driver.findElement(By.xpath("//*[text()='"+smList.get(i)+"']")).click();
        }


    }//end of main method


}//end of java class



