import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.List;

/**
 * EXERCISE 3: Web Scraping — Extract Table Data
 * -----------------------------------------------
 * TASK:
 *   1. Open the file: practice_pages/ex3_scraping.html
 *   2. Find ALL product names on the page (elements with class="product-name")
 *   3. Print each product name
 *   4. Find ALL prices (elements with class="price")
 *   5. Print each price
 *
 * EXPECTED OUTPUT:
 *   Products:
 *     - Laptop
 *     - Chair
 *     - Headphones
 *     - Desk
 *     - Mouse
 *
 *   Prices:
 *     - $999
 *     - $150
 *     - $79
 *     - $320
 *     - $35
 *
 * KEY CONCEPT: findElements() (plural) returns a List<WebElement>
 *              findElement()  (singular) returns one WebElement (throws error if not found)
 */
public class Exercise3_Scraping {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless", "--no-sandbox", "--disable-dev-shm-usage");
        WebDriver driver = new ChromeDriver(options);

        try {
            String filePath = System.getProperty("user.dir") + "/practice_pages/ex3_scraping.html";
            driver.get("file://" + filePath);

            // findElements returns a list of ALL matching elements
            List<WebElement> productNames = driver.findElements(By.className("product-name"));

            System.out.println("Products:");
            for (WebElement product : productNames) {
                System.out.println("  - " + product.getText());
            }

            System.out.println();

            // Find all price elements
            List<WebElement> prices = driver.findElements(By.className("price"));

            System.out.println("Prices:");
            for (WebElement price : prices) {
                System.out.println("  - " + price.getText());
            }

            // BONUS: Print table rows using XPath
            // XPath: all <tr> elements inside <tbody>
            System.out.println("\nFull Table (using XPath):");
            List<WebElement> rows = driver.findElements(By.xpath("//table[@id='product-table']/tbody/tr"));
            for (WebElement row : rows) {
                List<WebElement> cells = row.findElements(By.tagName("td"));
                System.out.println("  ID=" + cells.get(0).getText()
                        + " | Name=" + cells.get(1).getText()
                        + " | Category=" + cells.get(2).getText()
                        + " | Price=" + cells.get(3).getText());
            }

        } finally {
            driver.quit();
        }
    }
}
