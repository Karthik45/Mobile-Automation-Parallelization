package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverFactory {

    private AppiumDriver appiumDriver;
    private DesiredCapabilities desiredCapabilities;

    public DriverFactory() throws Exception {
        FactoryUtils factoryUtils = new FactoryUtils();
        System.out.println("Port Number: " + factoryUtils.getPort());
        desiredCapabilities = new DesiredCapabilities();
        switch (System.getProperty("testFor")) {
            case "Android":
                capabilitiesForAndroid();
                break;
            case "IOS":
                capabilitiesForIOS();
                break;
            default:
                throw new Exception("Invalid OS");
        }
        appiumDriver = new AppiumDriver(new URL("http://0.0.0.0:" + factoryUtils.getPort() + "/wd/hub"), desiredCapabilities);
        appiumDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    private void capabilitiesForAndroid() {
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("deviceName", "Pixel");
        desiredCapabilities.setCapability("appium-version", "1.7.2");
        desiredCapabilities.setCapability("app", System.getProperty("user.dir") + "/app/android-sample-app.apk");
        desiredCapabilities.setCapability("clearSystemFiles", true);
        desiredCapabilities.setCapability("appPackage", "com.vbanthia.androidsampleapp");
        desiredCapabilities.setCapability("appActivity", "com.vbanthia.androidsampleapp.MainActivity");
        desiredCapabilities.setCapability(MobileCapabilityType.UDID, System.getProperty("udid"));
    }

    private void capabilitiesForIOS() {
        desiredCapabilities.setCapability("appium-version", "1.7.2");
        desiredCapabilities.setCapability("platformName", "iOS");
        desiredCapabilities.setCapability("platformVersion", "11.4");
        desiredCapabilities.setCapability("deviceName", "iPhone 5");
        desiredCapabilities.setCapability("app", System.getProperty("user.dir") + "/app/TestApp-iphonesimulator.app");
        desiredCapabilities.setCapability("automationName", "XcuiTest");
        desiredCapabilities.setCapability("clearSystemFiles", true);
        desiredCapabilities.setCapability("launchTimeout", 300000);
        desiredCapabilities.setCapability("useNewWDA", false);
        desiredCapabilities.setCapability("showXcodeLog", true);
        desiredCapabilities.setCapability(MobileCapabilityType.UDID, System.getProperty("udid"));
    }

    public AppiumDriver getDriver() {
        return appiumDriver;
    }
}
