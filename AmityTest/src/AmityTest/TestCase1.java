/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package AmityTest;

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
public class TestCase1 {

public static void main(String[] args) {
    try {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\mujtaba.ali1\\Downloads\\chromedriver_winOld\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        // Login Page URL
        String baseUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
        driver.get(baseUrl);
        
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
        
        WebElement userName = driver.findElement(By.name("username"));
        userName.sendKeys("Admin");
        WebElement pass = driver.findElement(By.name("password"));
        pass.sendKeys("admin123");
        // Click on Login Button
        driver.findElement(By.cssSelector("button[class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button'")).click();
               
        // sleep for 3 seconds for page to be loaded
        Thread.sleep(3000);
        
        // Check Side bar Menu
        WebElement pim = driver.findElement(By.linkText("PIM"));
        pim.click();
        
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
        // Set Employee Input field
        driver.findElement(By.xpath("//label[contains(.,'Employee Name')]//following::input[1]")).sendKeys("CH");
        
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
        // Click on Search Button to show Employees
    	driver.findElement(By.cssSelector("button[class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space'")).click();
         
    } catch (InterruptedException ex)
    {
        System.out.println(""+ex.getMessage());
    }    
	}
}
