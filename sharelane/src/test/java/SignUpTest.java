import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUpTest {

    @Test
    public void fiveDigitZipCodeTest() {
        //Open Chrome browser
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();


        //Open url of zipcode page
        driver.get("https://www.sharelane.com/cgi-bin/register.py");

        //Input 5 digits into field
        driver.findElement(By.name("zip_code")).sendKeys("12345");

        //Click 'Continue'
        driver.findElement(By.cssSelector("[value=Continue]")).click();

        //Add check
        WebElement registerButton = driver.findElement(By.cssSelector("[value=Register]"));
        boolean isRegisterDisplayed = registerButton.isDisplayed();
        driver.quit();
        Assert.assertTrue(isRegisterDisplayed, "'Register' button is not displayed");

    }

    @Test
    public void fourDigitZipCodeTest() {
        //Open Chrome browser
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();


        //Open url of zipcode page
        driver.get("https://www.sharelane.com/cgi-bin/register.py");

        //Input 4 digits into field
        driver.findElement(By.name("zip_code")).sendKeys("1234");

        //Click 'Continue'
        driver.findElement(By.cssSelector("[value=Continue]")).click();

        //Add check
        WebElement errorMessage = driver.findElement(By.className("error_message"));
        boolean isErrorDisplayed = errorMessage.isDisplayed();
        driver.quit();
        Assert.assertTrue(isErrorDisplayed, "Error message is not displayed");

    }

    @Test
    public void sixDigitZipCodeTest() {
        //Open Chrome browser
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();


        //Open url of zipcode page
        driver.get("https://www.sharelane.com/cgi-bin/register.py");

        //Input 6 digits into field
        driver.findElement(By.name("zip_code")).sendKeys("123456");

        //Click 'Continue'
        driver.findElement(By.cssSelector("[value=Continue]")).click();

        //Add check
        boolean isErrorDisplayed = false;

        try {
            WebElement errorMessage = driver.findElement(By.className("error_message"));
            isErrorDisplayed = errorMessage.isDisplayed();

        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());

        } finally {
            driver.quit();
        }
        Assert.assertTrue(isErrorDisplayed, "Error message is not displayed");

    }

    @Test
    public void successfulSignUp() {
        //Open Chrome browser
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();

        //Open url of zipcode page
        driver.get("https://www.sharelane.com/cgi-bin/register.py");

        //Input 5 digits into field
        driver.findElement(By.name("zip_code")).sendKeys("12345");

        //Click 'Continue'
        driver.findElement(By.cssSelector("[value=Continue]")).click();

        //Enter name to FirstName field
        driver.findElement(By.name("first_name")).sendKeys("Alina");

        //Enter surname to FirstName field
        driver.findElement(By.name("last_name")).sendKeys("Bokaya");

        //Enter email to Email field
        driver.findElement(By.name("email")).sendKeys("axrlpserccfcqnyxcj@kvhrr.com");

        //Enter password
        driver.findElement(By.name("password1")).sendKeys("12345");

        //Confirm password
        driver.findElement(By.name("password2")).sendKeys("12345");

        //Click 'Register'
        driver.findElement(By.cssSelector("[value=Register]")).click();

        //Add check
        WebElement confirmationMessage = driver.findElement(By.className("confirmation_message"));
        boolean isConfirmationMessageDisplayed = confirmationMessage.isDisplayed();
        driver.quit();
        Assert.assertTrue(isConfirmationMessageDisplayed, "Confirmation message is not displayed");

    }

}
