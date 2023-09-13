package com.brq.Commom;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browser {
    public static WebDriver driver = new ChromeDriver();
    public static void Browser(String[] args) {
        WebDriverManager.chromedriver().setup();
    }
}