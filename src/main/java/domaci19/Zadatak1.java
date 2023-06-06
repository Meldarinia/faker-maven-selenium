package domaci19;


import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak1 {

    public static void main(String[] args) {


        System.setProperty("webdriver.chrome.driver","C:\\Users\\Gaga\\Desktop\\chrome driver\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://demoqa.com/text-box");

        driver.manage().window().fullscreen();

        Faker faker = new Faker();

        String name = faker.name().fullName();
        String emailAddress = faker.internet().emailAddress();
        String address = faker.address().fullAddress();
        String permaAddress = faker.address().fullAddress();

        WebElement fullName = driver.findElement(By.id("userName"));
        fullName.sendKeys(name);

        WebElement email = driver.findElement(By.id("userEmail"));
        email.sendKeys(emailAddress);

        WebElement currentAddress = driver.findElement(By.id("currentAddress"));
        currentAddress.sendKeys(address);

        WebElement permanentAddress = driver.findElement(By.id("permanentAddress"));
        permanentAddress.sendKeys(permaAddress);

        WebElement submitButton = driver.findElement(By.xpath("//button[contains(text(), 'Submit')]"));
        submitButton.click();

        WebElement outputName = driver.findElement(By.cssSelector("#name"));
        WebElement outputEmail = driver.findElement(By.cssSelector("#email"));


        if ((outputName.getText().equals("Name:" + name)) && (outputEmail.getText().equals("Email:" + emailAddress))){
            System.out.println("Test passed successfully! Output data matches input data.");
        } else {
            System.out.println("Test failed. Output data does not match input data.");
        }

        driver.close();

    }
}
