package Action_Item;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Action_Item2 {

    public static void main(String[] args) throws InterruptedException {
        //set the chrome driver location
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        //setting the chrome options before defining the driver
        ChromeOptions options = new ChromeOptions();
        //set the driver to be maximized
        options.addArguments("start-maximized");
        //set the driver to be incognito mode(private)
        //options.addArguments("incognito");
        //define web driver
        WebDriver driver = new ChromeDriver();

        //create dynamic array to handle multiple values
        String [] vacation = new String[5];
        vacation[0] = "poconos";
        vacation[1] = "bushkill falls";
        vacation[2] = "kent falls state park";
        vacation[3] = "horseshoe falls";
        vacation[4] = "amish village";

        for (int i = 0; i< vacation.length; i ++){
            //navigate to bing.com
            driver.navigate().to("http://www.bing.com");
            //maximize your browser
            driver.manage().window().maximize();
            //sleep statements handle in milliseconds
            Thread.sleep(2000);
            //locate the search field by inspection it first and then enter a keyword
            driver.findElement(By.id("sb_form_q")).sendKeys(vacation[i]);

            //press "enter" for bing search
            driver.findElement(By.id("sb_form_q")).submit();
            Thread.sleep(2000);

            //capture text from website
            String message = driver.findElement(By.className("sb_count")).getText();
            //using array variables to split above message
            String[] arrayResult = message.split(" ");
            System.out.println("My next vacation would be " + vacation[i] + " and search number is " + arrayResult[0]);


        }//end of for

    }//end of main method

}//end of java class


