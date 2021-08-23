package EcommerceDemoProj;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LaunchBrowser {


    public static void main(String args[]) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // Access to Ecommerce Site
        driver.get("http://tutorialsninja.com/demo/");
        driver.manage().window().maximize();;
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        System.out.println("supriya's update");
        //Navigating to login page
        driver.findElement(By.xpath("//a[@title='My Account']")).click();
        driver.findElement(By.linkText("Login")).click();

        //Entering login credentials
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("QAFox.QAFox@gmail.com");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("QAFox123");
        driver.findElement(By.xpath("//input[@type='submit']")).submit();

        //Verifying that user is login into the application successfully
        System.out.println("Is account home page displayed :"+ driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Account']")).isDisplayed());

        //Search for iphone
        driver.findElement(By.xpath("//input[@name='search']")).sendKeys("iphone");
        driver.findElement(By.cssSelector(".fa.fa-search")).click();
        System.out.println("Is iPhone displayed :"+ driver.findElement(By.xpath("//*[@class='product-thumb']//a[text()='iPhone']")).isDisplayed());

        //Click on iphone link and verify that usr is navigated successfully on iPhone product page.
        driver.findElement(By.xpath("//*[@class='product-thumb']//a[text()='iPhone']")).click();
        System.out.println("Is iPhone product page displayed" + driver.findElement(By.xpath("//*[@class='breadcrumb']//a[text()='iPhone']")).isDisplayed());

        //add 2 quantities for order
        WebElement quantity= driver.findElement(By.id("input-quantity"));
        quantity.clear();
        quantity.sendKeys("2");
        driver.findElement(By.id("button-cart")).click();
        System.out.println("Is success msg displayed : " +driver.findElement(By.xpath("//div [@class='alert alert-success alert-dismissible']")).getText().contains("Success: You have added iPhone to your shopping cart!"));

    }
}