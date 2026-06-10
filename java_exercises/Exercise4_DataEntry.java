import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * EXERCISE 4: Data Entry Form Automation
 * ----------------------------------------
 * TASK:
 *   1. Open the file: practice_pages/ex4_dataentry.html
 *   2. Fill in:
 *        Full Name  : "Nizam Ali"
 *        Email      : "nizam@example.com"
 *        Country    : "India"   (from dropdown)
 *        Message    : "Hello, this is a test message."
 *   3. Click the Submit button
 *   4. Read and print the output div text
 *
 * KEY CONCEPT: Dropdowns use the Select class
 *   Select select = new Select(driver.findElement(By.id("country")));
 *   select.selectByVisibleText("India");
 */
public class Exercise4_DataEntry {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless", "--no-sandbox", "--disable-dev-shm-usage");
        WebDriver driver = new ChromeDriver(options);

        try {
            String filePath = System.getProperty("user.dir") + "/practice_pages/ex4_dataentry.html";
            driver.get("file://" + filePath);

            // Fill Full Name
            driver.findElement(By.id("fullname")).sendKeys("Nizam Ali");

            // Fill Email
            driver.findElement(By.id("email")).sendKeys("nizam@example.com");

            // Select Country from dropdown
            // We need the Select class for <select> dropdowns
            WebElement countryDropdown = driver.findElement(By.id("country"));
            Select select = new Select(countryDropdown);
            select.selectByVisibleText("India");   // selects by the visible label
            // Other ways:
            // select.selectByValue("India");       // selects by value attribute
            // select.selectByIndex(1);             // selects by position (0-based)

            // Fill Message (textarea)
            driver.findElement(By.id("message")).sendKeys("Hello, this is a test message.");

            // Click Submit
            driver.findElement(By.id("submit-btn")).click();

            // Read the output section
            WebElement output = driver.findElement(By.id("output"));
            System.out.println("Form Output:\n" + output.getText());

        } finally {
            driver.quit();
        }
    }
}
