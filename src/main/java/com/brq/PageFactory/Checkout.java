package com.brq.PageFactory;

import com.brq.Commom.Browser;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Checkout extends Browser {
    @FindBy (id = "first-name")
    public WebElement primeiroNome;

    @FindBy(id = "last-name")
    public WebElement ultimoNome;
    @FindBy(id = "postal-code")
    public WebElement CEP;

    @FindBy(id = "continue")
    public WebElement btnContinue;
    @FindBy(id = "finish")
    public WebElement btnFinish;

    @FindBy(className = "complete-header")
    public WebElement txtFinish;

    @FindBy(className = "error-button")
    public WebElement erro;

    public Checkout(){
        PageFactory.initElements(driver, this);
    }
}
