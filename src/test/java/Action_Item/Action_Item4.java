package Action_Item;

import Reusable_Library.Reusable_Methods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class Action_Item4 {
    public static void main(String[] args) throws InterruptedException {
        //set the chrome driver location
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        //setting the chrome options before defining the driver
        ChromeOptions options = new ChromeOptions();
        //set the driver to be maximized
        options.addArguments("start-maximized");
        //set the driver to be incognito mode(private)
        options.addArguments("incognito");

        //defining the web driver that will be using
        WebDriver driver = new ChromeDriver(options);//options variables should be closed

        //set the value for first name
        ArrayList<String> firstName = new ArrayList<>();
        firstName.add("James");
        firstName.add("Sara");
        firstName.add("Ana");

        //set the value for last name
        ArrayList<String> lastName = new ArrayList<>();
        lastName.add("Carter");
        lastName.add("Paulsen");
        lastName.add("frank");

        //set the value for date
        ArrayList<String> date = new ArrayList<>();
        date.add("12");
        date.add("16");
        date.add("15");

        //set the value for year
        ArrayList<String> month = new ArrayList<>();
        month.add("March");
        month.add("April");
        month.add("May");

        //set the value for year
        ArrayList<String> year = new ArrayList<>();
        year.add("1970");
        year.add("1980");
        year.add("1990");

        //set the value for SSN
        ArrayList<String> ssn = new ArrayList<>();
        ssn.add("125456");
        ssn.add("127456");
        ssn.add("120456");

        //set the value for zip code
        ArrayList<String> zipCode = new ArrayList<>();
        zipCode.add("11218");
        zipCode.add("11354");
        zipCode.add("10001");

        //for loop
        for (int i = 0; i < firstName.size(); i++){

            //navigate to uhc.com
            driver.navigate().to("https://www.uhc.com");
            Thread.sleep(2000);

            //capture the title
            String actualTitle = driver.getTitle();
            //verify it matches the expected title
            if (actualTitle == "Health insurance plans"){
                System.out.println("Title matches as expected");
            }else {
                System.out.println("Title doesn't match. Actual title is  " + actualTitle);
            }//end of conditional statement

            //click on find a doctor
            Reusable_Methods.click(driver, "//*[@class='find-doctor position-relative  cta button-style__outline-blue cta--remove-icon mr-2 lg-items-center lg-flex']","find a doctor");

            //click on find a provider
            Thread.sleep(2000);
            Reusable_Methods.click(driver,"//*[@id='btn-sign-in']","find a provider");

            //go on a new tab
            Thread.sleep(2000);
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));

            //click on register
            Reusable_Methods.click(driver,"//*[@id='registerbutton']","register");

            //enter first name
            Reusable_Methods.sendKeys(driver,"//*[@id='firstName']",firstName.get(i),"Firstname");
            Thread.sleep(2000);

            //enter last name
            Reusable_Methods.sendKeys(driver,"//*[@id='lastName']",lastName.get(i),"Lastname");
            Thread.sleep(2000);

            //enter month
            Reusable_Methods.dropdownByText(driver,"//*[@name='dob_month']",month.get(i),"Month");
            //enter date
            Reusable_Methods.sendKeys(driver,"//*[@id='dob_day']",date.get(i),"Date");
            //enter year
            Reusable_Methods.sendKeys(driver,"//*[@id='dob_year']",year.get(i),"Year");

            //click on SSN
            Reusable_Methods.click(driver,"//*[@id='ssn_container']","SSN");

            //enter ssn
            Reusable_Methods.sendKeys(driver,"//*[@id='ssnLastSixDigits']",ssn.get(i),"Social Security");
            Thread.sleep(2000);
            //enter zipcode
            Reusable_Methods.sendKeys(driver,"//*[@id='zipCode']",zipCode.get(i),"ZipCOde");
            //click on continue
            Reusable_Methods.click(driver,"//*[@id='submitBtn']","Resister");
            Thread.sleep(2000);
            //capture the error text
            Reusable_Methods.captureText(driver,"//*[@class='ErrorContent--3ZzRv']","error text");



            driver.close();
            driver.switchTo().window(tabs.get(0));

        }//end of for loop
        }//end of main method
}//end of java class
