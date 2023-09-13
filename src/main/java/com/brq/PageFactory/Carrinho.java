package com.brq.PageFactory;

import com.brq.Commom.Browser;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Carrinho extends Browser {
    @FindBy (id = "checkout")
    public WebElement btnCheckout;

    public Carrinho(){
        PageFactory.initElements(driver, this);
    }
}
