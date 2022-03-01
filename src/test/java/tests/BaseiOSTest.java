package tests;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.logging.Log;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.google.common.io.Resources;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseiOSTest {

	
	public static void main(String[] args) throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "15.0");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 12");
		
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);	
		capabilities.setCapability(IOSMobileCapabilityType.LAUNCH_TIMEOUT, 500000);	
		capabilities.setCapability("commandTimeouts", "12000");
		
		//app file
		capabilities.setCapability(MobileCapabilityType.APP, "Users/jarz/eclipse-workspace/AppiumDemoProject/target/test-classes/IOS.Simulator.SauceLabs.Mobile.Sample.app.2.7.1.app");

		
		
		URL url = new URL("http://localhost:4723/wd/hub");
		IOSDriver<IOSElement> driver = new IOSDriver<>(url, capabilities);
		
		
		
		
	}

}