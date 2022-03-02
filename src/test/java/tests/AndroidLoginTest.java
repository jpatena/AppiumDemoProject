package tests;

import java.net.MalformedURLException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;


public class AndroidLoginTest extends BaseAndroidTest {

	public void setup() throws MalformedURLException{

	}
	
	public void teardown() {
		
	}
	
	@Test
	public void loginValidCredentials() throws InterruptedException, MalformedURLException {
		AndroidDriver driver = DesiredCapabilities();
		Thread.sleep(5000);
		driver.findElementByAccessibilityId("test-Username").click();
		driver.findElementByAccessibilityId("test-Username").sendKeys("standard_user");
		driver.findElementByAccessibilityId("test-Password").click();
		driver.findElementByAccessibilityId("test-Password").sendKeys("secret_sauce");
		driver.pressKey(new KeyEvent(AndroidKey.ENTER)); // hide keyboard
		driver.findElementByAccessibilityId("test-LOGIN").click();
		Thread.sleep(2000);
		Assert.assertEquals(true,
				isElementDisplayed(driver.findElements(By.xpath("//android.view.ViewGroup[@content-desc=\"test-Cart drop zone\"]/android.view.ViewGroup/android.widget.TextView"))));
		driver.quit();
	}
	
	@Test
	public void loginInvalidCredentials() throws InterruptedException, MalformedURLException {
		AndroidDriver driver = DesiredCapabilities();
		Thread.sleep(5000);
		driver.findElementByAccessibilityId("test-Username").click();
		driver.findElementByAccessibilityId("test-Username").sendKeys("standard_user");
		driver.findElementByAccessibilityId("test-Password").click();
		driver.findElementByAccessibilityId("test-Password").sendKeys("invalid_sauce");
		driver.pressKey(new KeyEvent(AndroidKey.ENTER)); // hide keyboard
		driver.findElementByAccessibilityId("test-LOGIN").click();
		Thread.sleep(2000);
		Assert.assertEquals(false,
				isElementDisplayed(driver.findElements(By.xpath("//android.view.ViewGroup[@content-desc=\"test-Cart drop zone\"]/android.view.ViewGroup/android.widget.TextView"))));
		driver.quit();
	}
}
