package com.example.myapplication;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ByIdOrName;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class CalculatorTest {

    WebDriver driver;
    String fileName = "calculator.apk";
    File calculatorApp = new File("C:\\Users\\duc.vm4\\" + fileName);

    @BeforeTest
    public void beforeTest() throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("app", calculatorApp);
        // khai báo platform
        cap.setCapability("platformName", "ANDROID");
        // khai báo deviceName
        cap.setCapability("deviceName", "emulator-5554");
        // Tìm app và cài đặt app
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test
    public void addTest() {
        WebElement button_2 = driver.findElement(By.xpath("//android.widget.Button[@resource-id = 'com.google.android.calculator:id/digit_2']"));

        WebElement button_9 =
                driver.findElement(By.xpath("//android.widget.Button[@resource-id = 'com.google.android.calculator:id/digit_9']"));
        WebElement op_mul =
                driver.findElement(By.id("com.google.android.calculator:id/op_mul"));
        WebElement button_equal =
                driver.findElement(By.id("com.google.android.calculator:id/eq"));

        button_2.click();
//        op_mul.click();
        button_9.click();
//        button_equal.click();

//        WebElement result =
//                driver.findElement(By.id("com.google.android.calculator:id/result"));
//        Assert.assertEquals(result.getText(), "18");
    }

    //@Test
    public void mulTest() {
        WebElement button_1 =
                driver.findElement(By.id("com.google.android.calculator:id/digit_1"));
        WebElement button_9 =
                driver.findElement(By.id("com.google.android.calculator:id/digit_9"));
        WebElement op_add =
                driver.findElement(By.id("com.google.android.calculator:id/op_add"));
        WebElement button_equal =
                driver.findElement(By.id("com.google.android.calculator:id/eq"));

        button_1.click();
        op_add.click();
        button_9.click();
        button_equal.click();

        WebElement result =
                driver.findElement(By.id("com.google.android.calculator:id/result"));
        Assert.assertEquals(result.getText(), "10");
    }

    @AfterTest
    public void afterTest() {
        //driver.quit();
    }
}
