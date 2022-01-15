package com.cloudinarydemo;

import com.cloudinarydemo.pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();

        //1) login to cloudinary
        LoginPage login = new LoginPage(driver).get();
        login.setEmail("felix+almog@cloudinary.com");
        login.setPassword("lAECwWJ96Nie!");
        login.signIn();

        //2) Open Media Library
        MainPage mainPage = new MainPage(driver).get();
        mainPage.openMediaLibrary();

        //3)Right Click on image
        MediaLibraryPage mediaLibraryPage = new MediaLibraryPage(driver).get();
        mediaLibraryPage.openContextMenu();

        //4) click Manage on the Context Menu
        ContextMenu contextMenu = new ContextMenu(driver).get();
        contextMenu.OpenManage();

        //5) validate page title
        ManagePage managePage = new ManagePage(driver,"Home assignment").get();

        //close browser
        driver.quit();
    }
}
