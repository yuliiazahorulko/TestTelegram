package com.example.myapplication;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.nio.file.Paths;

public class TelegramInstallTest {

    private AndroidDriver<AndroidElement> driver;

    @BeforeEach
    public void setUp() throws MalformedURLException {
        // Path to the Telegram APK file
        String telegramApkPath = Paths.get(System.getProperty("user.dir"), "apps", "Telegram.apk").toString();

        // Define the capabilities for the Appium session
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554"); // Change this to your AVD device name
        capabilities.setCapability(MobileCapabilityType.APP, telegramApkPath);        // Set the path to the Telegram APK
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, Duration.ofMinutes(2));
        capabilities.setCapability(MobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);  // Automatically grant app permissions

        // Initialize the AndroidDriver with the Appium server URL and capabilities
        driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testInstallAndOpenTelegram() {
        // Check that the driver is initialized
        assert driver != null;

        // Launch the Telegram app
        driver.launchApp();

        // Add further tests here to interact with the app as needed
    }
}
