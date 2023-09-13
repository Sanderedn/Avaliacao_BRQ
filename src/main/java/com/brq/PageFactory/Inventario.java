package com.brq.PageFactory;

import com.brq.Commom.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Inventario extends Browser {


    @FindBy (className = "product_sort_container")
    public WebElement filtro;



    @FindBy(id = "react-burger-menu-btn")
    public WebElement menu;


    public Inventario(){
        PageFactory.initElements(driver, this);
    }
}
