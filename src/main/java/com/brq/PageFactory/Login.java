package com.brq.PageFactory;

import com.brq.Commom.Browser;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login extends Browser {
    @FindBy (id = "user-name")
    public WebElement username;

    @FindBy (id = "password")
    public WebElement password;

    @FindBy (id = "login-button")
    public WebElement btnLogin;
    public Login(){
        PageFactory.initElements(driver, this);
    }
}
