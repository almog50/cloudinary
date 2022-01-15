package com.cloudinarydemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage extends LoadableComponent<MainPage> {

    private final WebDriver driver;

    public MainPage (WebDriver driver){
        this.driver = driver;
    }

    public void openMediaLibrary(){
        WebElement mediaLibrary = driver.findElement(By.xpath("//header/div/nav//b[@data-balloon='Media Library']"));
        mediaLibrary.click();
    }


    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        if (!MainPage.elementIsFoundable(this.driver,By.xpath("//header/div/nav//b[@data-balloon='Media Library']"))){
            throw new Error("MainPage was not successfully loaded");
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
