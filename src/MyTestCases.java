import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyTestCases extends Parameters {

	@BeforeTest
	public void preTest() {

		driver.manage().window().maximize();
	}

	@Test()
	public void testOne() throws InterruptedException {
		login();
		addToCart("Fleece");
		logOut();
		Thread.sleep(3000);
	}

	@Test(priority = 1)
	public void testTwo() throws InterruptedException {
		login();
		addToCart("Light", "Bolt");
		logOut();
		Thread.sleep(3000);
	}

	@Test(priority = 2)
	public void testThree() throws InterruptedException {
		login();
		addToCart("Backpack", "allTheThings", "Shirt");
		logOut();
		Thread.sleep(3000);
	}

	@AfterTest
	public void postTest() {
	}

}
