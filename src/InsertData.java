import java.util.*;  
import java.time.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InsertData {

   private ChromeDriver driver;

    public InsertData(){
        System.setProperty("webdriver.chrome.driver","./src/driver/chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.get(" https://demoqa.com/");
        this.driver.manage().window().maximize();
    }
    
    public ChromeDriver getDriver(){
        return this.driver;
    }
    

    public void setForm(){
        WebElement firstName = driver.findElement(By.id("firstName"));
        firstName.sendKeys("Katherine");
        WebElement lastName = driver.findElement(By.id("lastName"));
        lastName.sendKeys("Lombardo");
        WebElement userEmail = driver.findElement(By.id("userEmail"));
        userEmail.sendKeys("kamon@gmail.com");
        insertGender("Female");
        WebElement userNumber = driver.findElement(By.id("userNumber"));
        userNumber.sendKeys("1234567890");
        insertDateOfBirth("27", "April", "1999");
        insertSubjects("Maths");
        insertHobbie("Sports");
        insertHobbie("Music");
        WebElement currentAddress = driver.findElement(By.id("currentAddress"));
        currentAddress.sendKeys("Grove Street 247");
        insertPicture("female.jpg");
        insertStateAndCity("Haryana", "Panipat");


       WebElement submitBtn = driver.findElement(By.xpath("//*[@id=\"submit\"]"));
       submitBtn.sendKeys(Keys.ENTER);


    }
    
    public void insertPicture(String fileName){
        try{  
            WebElement uploadPicture = driver.findElement(By.xpath("//input[@id='uploadPicture']")); 
            uploadPicture.sendKeys( System.getProperty("user.dir")+"/src/pictures/"+fileName);

        }catch (NoSuchElementException e) {
            System.out.println(e.getStackTrace());
        }
        catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
    }

    public void insertGender(String genderInput){
        if (genderInput.equals("Male")){
            WebElement gender = driver.findElement(By.cssSelector("label[for='gender-radio-1']"));
            gender.click();
        }
        if(genderInput.equals("Female")){
            WebElement gender = driver.findElement(By.cssSelector("label[for='gender-radio-2']"));
            gender.click();
        }
        if(genderInput.equals("Male")){
            WebElement gender = driver.findElement(By.cssSelector("label[for='gender-radio-3']"));
            gender.click();
        }
    }

    public void insertHobbie(String hobbie){
        if(hobbie.equals("Sports")){
            WebElement hobbies = driver.findElement(By.cssSelector("label[for='hobbies-checkbox-1']"));
            hobbies.click();
        }
        if(hobbie.equals("Reading")){
            WebElement hobbies = driver.findElement(By.cssSelector("label[for='hobbies-checkbox-2']"));
            hobbies.click();
        }
        if(hobbie.equals("Music")){
            WebElement hobbies = driver.findElement(By.cssSelector("label[for='hobbies-checkbox-3']"));
            hobbies.click();
        }
    }
    
    public void insertStateAndCity(String stateInput, String cityInput){
        //Insert state
        WebElement state =  new WebDriverWait(driver, Duration.ofSeconds(10))
        .until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='react-select-3-input']")));
        state.sendKeys(stateInput);
        state.sendKeys(Keys.ENTER);
        WebElement city = new WebDriverWait(driver, Duration.ofSeconds(10))
        .until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='react-select-4-input']")));
        city.sendKeys(cityInput);
        city.sendKeys(Keys.ENTER);
        

    }

    public void insertSubjects(String subject){
        driver.findElement(By.id("subjectsInput")).sendKeys(subject);
        WebElement subjectsInput = new WebDriverWait(driver, Duration.ofSeconds(10))
        .until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='subjectsInput']")));
        subjectsInput.sendKeys(Keys.ENTER);

    }
    
    public void insertDateOfBirth(String day, String month, String year){
        WebElement dateOfBirthInput = driver.findElement(By.id("dateOfBirthInput"));
        dateOfBirthInput.click();

        //Select month
        WebElement monthOfBirthInput = new WebDriverWait(driver, Duration.ofSeconds(10))
        .until(ExpectedConditions.elementToBeClickable(By.className("react-datepicker__month-select")));
        monthOfBirthInput.click();
        Select selectObject = new Select (monthOfBirthInput);
        selectObject.selectByVisibleText(month);
        monthOfBirthInput.click();

        //Select year
        WebElement yearOfBirthInput = new WebDriverWait(driver, Duration.ofSeconds(10))
        .until(ExpectedConditions.elementToBeClickable(By.className("react-datepicker__year-select")));
        yearOfBirthInput.click();
        selectObject = new Select (yearOfBirthInput);
        selectObject.selectByVisibleText(year);
        yearOfBirthInput.click();

        //Select Day
        WebElement dayofBirthInput = new WebDriverWait(driver, Duration.ofSeconds(10))
        .until(ExpectedConditions.elementToBeClickable(By.className("react-datepicker__day--0"+day)));
        dayofBirthInput.click();

    }

   
    
    
}

