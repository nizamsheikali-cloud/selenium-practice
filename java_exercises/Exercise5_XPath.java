import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.List;

/**
 * EXERCISE 5: XPath Locators
 * ----------------------------
 * XPath is the most powerful locator in Selenium. Master it and you can
 * find ANY element on any page.
 *
 * XPATH CHEAT SHEET:
 * ------------------
 *  //tag                      → find all <tag> anywhere
 *  //tag[@attr='value']       → tag with specific attribute value
 *  //tag[text()='sometext']   → tag with exact text content
 *  //tag[contains(@attr,'x')] → tag whose attribute contains 'x'
 *  //parent/child             → direct child
 *  //parent//descendant       → any level descendant
 *  (.//tag)[1]                → first match
 *
 * TASKS:
 *  1. Click the "Delete" button using its data-action attribute
 *  2. Print the status text after clicking
 *  3. Find all <a> tags with class="nav-link" and print their text
 *  4. Find all user names (class="user-name") and print them
 *  5. Find the list item with data-id="103" and print its text
 */
public class Exercise5_XPath {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless", "--no-sandbox", "--disable-dev-shm-usage");
        WebDriver driver = new ChromeDriver(options);

        try {
            String filePath = System.getProperty("user.dir") + "/practice_pages/ex5_xpath.html";
            driver.get("file://" + filePath);

            // ----- TASK 1: Click Delete button by data-action attribute -----
            // XPath: find a <button> where data-action="delete"
            WebElement deleteBtn = driver.findElement(By.xpath("//button[@data-action='delete']"));
            deleteBtn.click();

            // ----- TASK 2: Read status text after click -----
            WebElement status = driver.findElement(By.id("status"));
            System.out.println("Status after click: " + status.getText());

            // ----- TASK 3: All nav links -----
            List<WebElement> navLinks = driver.findElements(By.xpath("//a[@class='nav-link']"));
            System.out.println("\nNav Links:");
            for (WebElement link : navLinks) {
                System.out.println("  " + link.getText());
            }

            // ----- TASK 4: User names -----
            List<WebElement> userNames = driver.findElements(By.xpath("//span[@class='user-name']"));
            System.out.println("\nUser Names:");
            for (WebElement name : userNames) {
                System.out.println("  " + name.getText());
            }

            // ----- TASK 5: Specific list item by data-id -----
            WebElement cherryItem = driver.findElement(By.xpath("//li[@data-id='103']"));
            System.out.println("\nItem with data-id=103: " + cherryItem.getText());

            // ----- BONUS: contains() function -----
            // Find all buttons whose ID starts with "btn"
            List<WebElement> allBtns = driver.findElements(By.xpath("//button[contains(@id,'btn')]"));
            System.out.println("\nAll buttons containing 'btn' in id:");
            for (WebElement btn : allBtns) {
                System.out.println("  id=" + btn.getAttribute("id") + " text=" + btn.getText());
            }

        } finally {
            driver.quit();
        }
    }
}
