package com.brq.PageFactory;

import com.brq.Commom.Browser;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Produto extends Browser {

    @FindBy (css = "div > div > div >div:nth-child(2) > div > div > div:nth-child(2)>button")
    public WebElement btnCarrinho;

    @FindBy (id = "shopping_cart_container")
    public WebElement carrinho;
    public Produto(){
        PageFactory.initElements(driver, this);
    }
}
