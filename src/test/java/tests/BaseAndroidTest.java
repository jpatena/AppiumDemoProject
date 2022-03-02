package tests;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseAndroidTest {

	public static AndroidDriver DesiredCapabilities() throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.0");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_3a_XL_API_30");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		capabilities.setCapability("appPackage", "com.swaglabsmobileapp");
		capabilities.setCapability("appActivity", "com.swaglabsmobileapp.MainActivity");
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);	
		capabilities.setCapability(AndroidMobileCapabilityType.AVD_LAUNCH_TIMEOUT, 500000);	
		capabilities.setCapability(AndroidMobileCapabilityType.AVD_READY_TIMEOUT, 500000);	
		capabilities.setCapability("commandTimeouts", "12000");
		
		//app file
		File f = new File("src/test/resources");
		File fs = new File(f,"Android.SauceLabs.Mobile.Sample.app.2.7.1.apk");
		
		capabilities.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());

		URL url = new URL("http://localhost:4723/wd/hub");
		AndroidDriver<AndroidElement> driver = new AndroidDriver<>(url, capabilities);
		
		return driver;
	}
	
	public boolean isElementDisplayed(List findElements) {
		List elements = findElements;
		if(elements.size()>0 ) {
			return true;
		}
		else {
			return false;
		}
	}
}
