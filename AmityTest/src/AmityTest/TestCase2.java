/*
* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
* Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
*/
package AmityTest;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
* Below code can be divided into sub classes but for testing purpose intention is to make it simple to run
* Classes can be make in such a way to reduce the code effort by calling same usable functions to other test cases. E.g Login Class
* @author Mujtaba.Ali1
*/
public class TestCase2 {

public static void main(String[] args) {

try {
    System.setProperty("webdriver.chrome.driver", "C:\\Users\\mujtaba.ali1\\Downloads\\chromedriver_winOld\\chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    // Login Page URL
    String baseUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
    driver.get(baseUrl);
    
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    
    WebElement username = driver.findElement(By.name("username"));
    username.sendKeys("Admin");   // Set username in input field
    WebElement passord = driver.findElement(By.name("password"));
    passord.sendKeys("admin123"); // Set password in input field
    // Click on Login Button
    driver.findElement(By.cssSelector("button[class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button'")).click();  

    // sleep for 3 seconds for page to be loaded
    Thread.sleep(3000);

    // Check Side bar Menu
    WebElement adminSideBar = driver.findElement(By.linkText("Admin"));
    adminSideBar.click(); // Click on side bar menu
    
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    
    // Check Admin Tab List
    List<WebElement>  adminTabList = driver.findElements(By.className("oxd-topbar-body-nav-tab-item"));
    adminTabList.get(1).click(); // Click on Job tab under Admin menu

    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    
    WebElement jobList = driver.findElement(By.linkText("Pay Grades")); // Get Job List
    jobList.click();
    
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); 

    // Click on Add Pay Grade Button
    driver.findElement(By.cssSelector("button[class='oxd-button oxd-button--medium oxd-button--secondary'")).click();

    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    driver.findElement(By.xpath("//label[contains(.,'Name')]//following::input[1]")).sendKeys("Indian Rupee"); 
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    driver.findElement(By.cssSelector("button[class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space'")).click();
    
     // sleep for 10 seconds for page to be loaded
    Thread.sleep(10000);
   
    try {
        // Edit Pay Grade record. We can update below command dynamic based on Pay Grade name. Currently it will work for Indian Rupee.
        // To make it dynamic we can take the Pay Grade as an input 
        WebElement editPayGrade = driver.findElement(By.xpath("//*[text()='Indian Rupee']//following::button[2]"));
        editPayGrade.click();
        
   } catch (Exception e)
    {
        System.out.println("Exception Occured :"+e.getMessage());
    }
            
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    
    //Click on Add Currency button
    WebElement addCurrency = driver.findElement(By.xpath("//*[text()='Currencies']//following::button[1]"));
    addCurrency.click();
     
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
     
    // Get Currency dropdown list
    WebElement currencyDropDown = driver.findElement(By.className("oxd-select-text-input"));  
    currencyDropDown.click();  // Click on Currency dropdown
     
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
     
    currencyDropDown.findElement(By.xpath("//*[text()='INR - Indian Rupee']")).click(); // Select Currency dropdown list
    driver.findElement(By.xpath("//label[contains(.,'Minimum Salary')]//following::input[1]")).sendKeys("30000"); //Set Min Salary
    driver.findElement(By.xpath("//label[contains(.,'Maximum Salary')]//following::input[1]")).sendKeys("100000"); //Set Max Salary
    driver.findElement(By.xpath("//*[text()='Add Currency']//following::button[2]")).click(); //Click to Add Salary Range
    
} catch (InterruptedException ex) 
{
    System.out.println("Exception Occured :"+ex.getMessage());
}	    
    }
}
