package com.cloudinarydemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ContextMenu extends LoadableComponent<ContextMenu> {

    private final WebDriver driver;
    By  contextMenuByXpath = By.xpath("//div[@data-test='popover']");
    //"//div[@data-test='action-manage-btn']"

    public ContextMenu (WebDriver driver){
        this.driver = driver;
    }

    public void OpenManage(){
        WebElement manage = driver.findElement(By.xpath("//div[@data-test='action-manage-btn']"));
        manage.click();
    }

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        if (!ContextMenu.elementIsFoundable(this.driver,contextMenuByXpath)){
            throw new Error("ContextMenu is not displayed");
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
