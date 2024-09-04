package com.example.myapplication;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class TelegramInstallTest {

    private AndroidDriver<AndroidElement> driver;
    private WebDriverWait wait;

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
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 120);
        //capabilities.setCapability(MobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);  // Automatically grant app permissions

        // Initialize the AndroidDriver with the Appium server URL and capabilities
        driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), capabilities);

        // Initialize WebDriverWait with a timeout of 10 seconds
        wait = new WebDriverWait(driver, 20);
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

        // Example: Wait until a specific element is visible (replace with actual element ID)
//        WebElement element = wait.until(
//                ExpectedConditions.visibilityOfElementLocated(
//                        // Replace with the actual locator, e.g., By.id("element_id")
//                )
//        );

        // Add further tests here to interact with the app as needed
    }
}
