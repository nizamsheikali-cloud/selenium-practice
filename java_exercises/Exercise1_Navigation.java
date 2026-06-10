import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * EXERCISE 1: Basic Navigation & Reading Elements
 * -----------------------------------------------
 * TASK:
 *   1. Open the file: practice_pages/ex1_navigation.html  (use the full path on your machine)
 *   2. Read and print the text of the element with id="greeting"
 *   3. Read and print the text of the element with id="page-title"
 *   4. Read and print the text of the element with id="version"
 *
 * EXPECTED OUTPUT:
 *   Greeting : Hello, Selenium Learner!
 *   Page Title: Welcome to Exercise 1
 *   Version   : Selenium Version: 4.x
 */
public class Exercise1_Navigation {

    public static void main(String[] args) {

        // STEP 1: Set up ChromeDriver (headless = runs without opening a visible window)
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless", "--no-sandbox", "--disable-dev-shm-usage");
        WebDriver driver = new ChromeDriver(options);

        try {
            // STEP 2: Open the HTML file (replace <YOUR_PATH> with the actual path to the file)
            // Example on Windows: driver.get("file:///C:/Users/YourName/Desktop/practice_pages/ex1_navigation.html");
            // Example on Mac/Linux: driver.get("file:///Users/YourName/Desktop/practice_pages/ex1_navigation.html");
            // In Codespaces, use the path relative to the workspace root
            String filePath = System.getProperty("user.dir") + "/practice_pages/ex1_navigation.html";
            driver.get("file://" + filePath);

            // STEP 3: Find element by ID and read its text
            // TODO: Find the element with id="greeting" and print its text
            WebElement greetingEl = driver.findElement(By.id("greeting"));
            System.out.println("Greeting : " + greetingEl.getText());

            // TODO: Find the element with id="page-title" and print its text
            WebElement titleEl = driver.findElement(By.id("page-title"));
            System.out.println("Page Title: " + titleEl.getText());

            // TODO: Find the element with id="version" and print its text
            WebElement versionEl = driver.findElement(By.id("version"));
            System.out.println("Version   : " + versionEl.getText());

        } finally {
            driver.quit(); // Always close the browser
        }
    }
}
