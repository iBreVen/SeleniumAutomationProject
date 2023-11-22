import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Parameters {

	static WebDriver driver = new ChromeDriver();

	static String myWebSite = "https://www.saucedemo.com/";
	static String loginUserName = "standard_user";
	static String loginPassword = "secret_sauce";

	static void login() {

		driver.get(myWebSite);

		WebElement usernameInput = driver.findElement(By.id("user-name"));
		WebElement passwordInput = driver.findElement(By.id("password"));
		WebElement loginButton = driver.findElement(By.id("login-button"));

		usernameInput.sendKeys(loginUserName);
		passwordInput.sendKeys(loginPassword);
		loginButton.click();

	}

	static void addToCart(String... items) {

		List<WebElement> addToCartButtons = driver.findElements(By.className("btn"));
		List<WebElement> productNames = driver.findElements(By.className("inventory_item_name"));

		for (int i = 0; i < productNames.size(); i++) {

			String productName = productNames.get(i).getText();

			if (containsAny(productName, items)) {

				addToCartButtons.get(i).click();

			}

		}

	}

	private static boolean containsAny(String str, String... items) {

		for (String neededItems : items)

			if (str.contains(neededItems)) {

				return true;

			}

		return false;

	}

	static void logOut() throws InterruptedException {

		driver.findElement(By.id("react-burger-menu-btn")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("reset_sidebar_link")).click();
		Thread.sleep(1000);
		driver.navigate().refresh();
		Thread.sleep(1000);
		driver.findElement(By.id("react-burger-menu-btn")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("logout_sidebar_link")).click();

	}

}
