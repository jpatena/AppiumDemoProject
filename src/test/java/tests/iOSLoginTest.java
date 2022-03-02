package tests;

import java.net.MalformedURLException;
import java.util.List;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.ios.IOSDriver;

public class iOSLoginTest extends BaseiOSTest {
	
	public void setup() throws MalformedURLException{

	}
	
	public void teardown() {
		
	}
	
	@Test
	public void loginValidCredentials() throws InterruptedException, MalformedURLException {
		IOSDriver driver = DesiredCapabilities();
		driver.findElementByAccessibilityId("test-Username").click();
		driver.findElementByAccessibilityId("test-Username").sendKeys("standard_user");
		driver.findElementByAccessibilityId("test-Password").click();
		driver.findElementByAccessibilityId("test-Password").sendKeys("secret_sauce\n");
		driver.findElementByAccessibilityId("test-LOGIN").click();
		Thread.sleep(2000);
		Assert.assertEquals(true,
				isElementDisplayed(driver.findElements(By.xpath("//XCUIElementTypeStaticText[@name=\"PRODUCTS\"]"))));
		driver.quit();
	}
	
	@Test
	public void loginInvalidCredentials() throws InterruptedException, MalformedURLException {
		IOSDriver driver = DesiredCapabilities();
		driver.findElementByAccessibilityId("test-Username").click();
		driver.findElementByAccessibilityId("test-Username").sendKeys("standard_user");
		driver.findElementByAccessibilityId("test-Password").click();
		driver.findElementByAccessibilityId("test-Password").sendKeys("invalid_sauce\n");
		driver.findElementByAccessibilityId("test-LOGIN").click();
		Thread.sleep(2000);
		Assert.assertEquals(false,
				isElementDisplayed(driver.findElements(By.xpath("//XCUIElementTypeStaticText[@name=\"PRODUCTS\"]"))));
		driver.quit();
	}
}
