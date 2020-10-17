package Day4_09122020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.lang.Thread.sleep;

public class google_search {
    public static void main(String[] args) throws InterruptedException {

        //set the chrome driver location
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        //defining the web driver that will be using
        WebDriver driver = new ChromeDriver();

        //lets get to google home page
        // driver.get ("https://www.google.com");

        // let's navigate to google home page
        driver.navigate().to("https://www.google.com");
        //maximize my window
        driver.manage().window().maximize();

        //put two second
        Thread.sleep(2000);
        //locate search field by name and enter a keyword ob the field
        driver.findElement(By.name("q")).sendKeys("cars");
        //click on google search
        driver.findElement(By.name("btnK")).click();

        //close driver
        //driver.close();
        //quit the entire session
        // driver.quit();


    }//end of main method


}//end of java class

