package com.cloudinarydemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MediaLibraryPage extends LoadableComponent<MediaLibraryPage> {

    private final WebDriver driver;
    private final Actions actions;
    public MediaLibraryPage (WebDriver driver){
        this.driver = driver;
        actions = new Actions(this.driver);
    }

    public void openContextMenu(){
        WebElement image = driver.findElement(By.xpath("//main//span[@role='button'][div='Home assignment']/div"));
        actions.contextClick(image).perform();
    }
    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        if (!MediaLibraryPage.elementIsFoundable(this.driver,By.xpath("//main//span[@role='button'][div='Home assignment']/div"))){
            throw new Error("MediaLibraryPage was not successfully loaded");
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
