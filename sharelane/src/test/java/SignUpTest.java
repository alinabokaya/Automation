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
    public void successfulSignUpTest() {
        //Open Chrome browser
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();

        //Open url of zipcode page
        driver.get("https://www.sharelane.com/cgi-bin/register.py");

        //Input 5 digits into field
        driver.findElement(By.name("zip_code")).sendKeys("12345");

        //Click 'Continue'
        driver.findElement(By.cssSelector("[value=Continue]")).click();

        //Enter name to First Name field
        driver.findElement(By.name("first_name")).sendKeys("Alina");

        //Enter surname to Last Name field
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

    @Test
    public void signUpWithEmptyFirstNameFieldTest() {
        //Open Chrome browser
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();

        //Open url of zipcode page
        driver.get("https://www.sharelane.com/cgi-bin/register.py");

        //Input 5 digits into field
        driver.findElement(By.name("zip_code")).sendKeys("12345");

        //Click 'Continue'
        driver.findElement(By.cssSelector("[value=Continue]")).click();

        //Leave First Name field empty

        //Enter surname to Last Name field
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
        WebElement errorMessage = driver.findElement(By.className("error_message"));
        boolean isErrorDisplayed = errorMessage.isDisplayed();
        driver.quit();
        Assert.assertTrue(isErrorDisplayed, "Error message is not displayed");

    }

    @Test
    public void signUpWithDigitsInFirstNameFieldTest() {
        //Open Chrome browser
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();

        //Open url of zipcode page
        driver.get("https://www.sharelane.com/cgi-bin/register.py");

        //Input 5 digits into field
        driver.findElement(By.name("zip_code")).sendKeys("12345");

        //Click 'Continue'
        driver.findElement(By.cssSelector("[value=Continue]")).click();

        ///Enter digits to First Name field
        driver.findElement(By.name("first_name")).sendKeys("12345");

        //Enter surname to Last Name field
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
        WebElement errorMessage = driver.findElement(By.className("error_message"));
        boolean isErrorDisplayed = errorMessage.isDisplayed();
        driver.quit();
        Assert.assertTrue(isErrorDisplayed, "Error message is not displayed");

    }

    @Test
    public void signUpWithEmptyEmailFieldTest() {
        //Open Chrome browser
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();

        //Open url of zipcode page
        driver.get("https://www.sharelane.com/cgi-bin/register.py");

        //Input 5 digits into field
        driver.findElement(By.name("zip_code")).sendKeys("12345");

        //Click 'Continue'
        driver.findElement(By.cssSelector("[value=Continue]")).click();

        //Leave First Name field empty
        driver.findElement(By.name("first_name")).sendKeys("Alina");

        //Enter surname to Last Name field
        driver.findElement(By.name("last_name")).sendKeys("Bokaya");

        //Leave Email field empty

        //Enter password
        driver.findElement(By.name("password1")).sendKeys("12345");

        //Confirm password
        driver.findElement(By.name("password2")).sendKeys("12345");

        //Click 'Register'
        driver.findElement(By.cssSelector("[value=Register]")).click();

        //Add check
        WebElement errorMessage = driver.findElement(By.className("error_message"));
        boolean isErrorDisplayed = errorMessage.isDisplayed();
        driver.quit();
        Assert.assertTrue(isErrorDisplayed, "Error message is not displayed");

    }

    @Test
    public void signUpWithInvalidPasswordFieldTest() {
        //Open Chrome browser
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();

        //Open url of zipcode page
        driver.get("https://www.sharelane.com/cgi-bin/register.py");

        //Input 5 digits into field
        driver.findElement(By.name("zip_code")).sendKeys("12345");

        //Click 'Continue'
        driver.findElement(By.cssSelector("[value=Continue]")).click();

        //Leave First Name field empty
        driver.findElement(By.name("first_name")).sendKeys("Alina");

        //Enter surname to Last Name field
        driver.findElement(By.name("last_name")).sendKeys("Bokaya");

        //Enter email to Email field
        driver.findElement(By.name("email")).sendKeys("axrlpserccfcqnyxcj@kvhrr.com");

        //Enter 3-digits password
        driver.findElement(By.name("password1")).sendKeys("123");

        //Confirm 3-digits password
        driver.findElement(By.name("password2")).sendKeys("123");

        //Click 'Register'
        driver.findElement(By.cssSelector("[value=Register]")).click();

        //Add check
        WebElement errorMessage = driver.findElement(By.className("error_message"));
        boolean isErrorDisplayed = errorMessage.isDisplayed();
        driver.quit();
        Assert.assertTrue(isErrorDisplayed, "Error message is not displayed");

    }

    @Test
    public void signUpWithDifferentPasswordsTest() {
        //Open Chrome browser
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();

        //Open url of zipcode page
        driver.get("https://www.sharelane.com/cgi-bin/register.py");

        //Input 5 digits into field
        driver.findElement(By.name("zip_code")).sendKeys("12345");

        //Click 'Continue'
        driver.findElement(By.cssSelector("[value=Continue]")).click();

        //Leave First Name field empty
        driver.findElement(By.name("first_name")).sendKeys("Alina");

        //Enter surname to Last Name field
        driver.findElement(By.name("last_name")).sendKeys("Bokaya");

        //Enter email to Email field
        driver.findElement(By.name("email")).sendKeys("axrlpserccfcqnyxcj@kvhrr.com");

        //Enter password
        driver.findElement(By.name("password1")).sendKeys("12345");

        //Enter different password to Confirm Password field
        driver.findElement(By.name("password2")).sendKeys("54321");

        //Click 'Register'
        driver.findElement(By.cssSelector("[value=Register]")).click();

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
    public void addingBookToShoppingCartTest() {
        //Preconditions: user is registered and has active account
        //Email: linda_baker@605.75.sharelane.com
        //Password: 1111

        //Open Chrome browser
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();

        //Open Login page
        driver.get("https://www.sharelane.com/cgi-bin/main.py");

        //Enter email to Email Field
        driver.findElement(By.name("email")).sendKeys("linda_baker@605.75.sharelane.com");


        //Enter password
        driver.findElement(By.name("password")).sendKeys("1111");

        //Click Login
        driver.findElement(By.cssSelector("[value=Login]")).click();

        //Open book from the list
        driver.get("https://www.sharelane.com/cgi-bin/show_book.py?book_id=4");

        //Click 'Add to Cart'
        driver.get("https://www.sharelane.com/cgi-bin/add_to_cart.py?book_id=4");

        //Add check
        WebElement confirmationMessage = driver.findElement(By.className("confirmation_message"));
        boolean isConfirmationMessageDisplayed = confirmationMessage.isDisplayed();
        driver.quit();
        Assert.assertTrue(isConfirmationMessageDisplayed, "Confirmation message is not displayed");

    }


}
