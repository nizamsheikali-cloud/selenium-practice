import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * EXERCISE 2: Login Form Automation
 * -----------------------------------
 * TASK:
 *   1. Open the file: practice_pages/ex2_login.html
 *   2. Enter username: admin
 *   3. Enter password: secret123
 *   4. Click the Login button
 *   5. Read and print the result message shown on screen
 *
 * EXPECTED OUTPUT:
 *   Result: Login successful! Welcome, admin.
 *
 * BONUS CHALLENGE:
 *   Try with wrong credentials (e.g., username="wrong", password="wrong")
 *   and print what message appears.
 */
public class Exercise2_Login {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless", "--no-sandbox", "--disable-dev-shm-usage");
        WebDriver driver = new ChromeDriver(options);

        try {
            String filePath = System.getProperty("user.dir") + "/practice_pages/ex2_login.html";
            driver.get("file://" + filePath);

            // STEP 1: Find the username field and type into it
            WebElement usernameField = driver.findElement(By.id("username"));
            usernameField.sendKeys("admin");

            // STEP 2: Find the password field and type into it
            WebElement passwordField = driver.findElement(By.id("password"));
            passwordField.sendKeys("secret123");

            // STEP 3: Click the login button
            WebElement loginBtn = driver.findElement(By.id("login-btn"));
            loginBtn.click();

            // STEP 4: Read the result message
            WebElement resultEl = driver.findElement(By.id("result"));
            System.out.println("Result: " + resultEl.getText());

            // ---- BONUS: Test with wrong credentials ----
            // Clear the fields first using .clear()
            usernameField.clear();
            passwordField.clear();

            usernameField.sendKeys("wronguser");
            passwordField.sendKeys("wrongpass");
            loginBtn.click();

            System.out.println("Wrong creds result: " + resultEl.getText());

        } finally {
            driver.quit();
        }
    }
}
