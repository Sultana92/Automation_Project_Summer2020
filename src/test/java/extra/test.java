package extra;

import Reusable_Library.Reusable_Methods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class test {
    public static void main(String[] args) throws InterruptedException {
        //set the chrome driver location
        /**
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
        //navigate to destination
         */
        WebDriver driver;
        driver = Reusable_Methods.getDriver();
        driver.navigate().to("https://www.weightwatchers.com");

        //wait time
        //Thread.sleep(2000);

        String[] zipcode = new String[3];
        zipcode[0] = "11218";
        zipcode[1] = "10304";
        zipcode[2] = "10475";

        //store your actual title
        String actualTitle = driver.getTitle();
        if (actualTitle.equals("Weight watchers: Weight loss & Wellness help")){
            System.out.println("Title matches with expected");
        }else {
            System.out.println("Title doesn't match " + actualTitle);
            for (int i=0; i<=2; i++) {
                //locate find a workshop
                driver.findElement(By.xpath("//*[@data-e2e-name='find_a workshop']")).click();
                //wait
                Thread.sleep(2000);
                //input zipcode
                driver.findElement(By.xpath("//*[@id='location-search']")).sendKeys(zipcode[i]);
                //wait
                Thread.sleep(2000);
                driver.findElement(By.xpath("//*[@id='location-search-cta']")).submit();

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

                String location = driver.findElement(By.xpath("//*[@class='address-2PZwW']")).getText();
                //driver.findElements(By.xpath("//div[contains(@class,'location__name')]")).get(2).click();

                System.out.println(location);

                //find schedule
                String schedule = driver.findElement(By.xpath("//*[@class='workshopSchedule-2foP8']")).getText();

                //print schedule
                System.out.println(schedule);



            }//end of for
        }//end of if else method

    }
}
