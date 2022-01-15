package com.cloudinarydemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.LoadableComponent;

public class LoginPage extends LoadableComponent<LoginPage> {

    private final WebDriver driver;

    public LoginPage (WebDriver driver){
        this.driver = driver;
        driver.get("https://staging.cloudinary.com/users/login");
    }

    public void setEmail(String email){
        WebElement emailField = driver.findElement(By.id("user_session_email"));
        emailField.sendKeys(email);
    }

    public void setPassword(String password){
        WebElement passwordField = driver.findElement(By.id("user_session_password"));
        passwordField.sendKeys(password);
    }

    public void signIn(){
        driver.findElement(By.id("sign-in")).click();
    }

    @Override
    protected void load() {
        //driver.get("https://staging.cloudinary.com/users/login");
    }

    @Override
    protected void isLoaded() throws Error {
        String url = driver.getCurrentUrl();
        assert url.endsWith("/login") : "You are not in the Login Page";
    }


}
