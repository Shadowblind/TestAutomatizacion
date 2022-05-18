import java.util.*;  
import java.time.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import javax.xml.xpath.XPath;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class App {
    public static void main(String[] args) throws Exception {
       
        InsertData data = new InsertData();
        
        //Localizar el formulario
        data.getDriver().findElement(By.cssSelector("#app > div > div > div.home-body > div > div:nth-child(2)")).click();
        data.getDriver().findElement(By.cssSelector("#app > div > div > div.row > div:nth-child(1) > div > div > div:nth-child(2) > div > ul >li")).click();

        data.setForm();

        
    }
    
}
