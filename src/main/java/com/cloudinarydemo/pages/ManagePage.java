package com.cloudinarydemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ManagePage extends LoadableComponent<ManagePage> {

    private final WebDriver driver;
    By titleXpath;

    public ManagePage (WebDriver driver, String imageName){
        this.driver = driver;
        titleXpath = By.xpath("//input[@data-test='item-title'][@value='" + imageName + "']");
    }

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        if (!ManagePage.elementIsFoundable(this.driver,titleXpath)){
            throw new Error("Title In Manage Page does not match image name" );
        }
    }

    protected static boolean elementIsFoundable(WebDriver driver, By by){
        try {
            new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(by));
        }catch (WebDriverException ex){
            return false;
        }
        return true;
    }
}
