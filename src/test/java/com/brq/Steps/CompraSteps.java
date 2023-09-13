package com.brq.Steps;

import com.brq.Commom.Browser;
import com.brq.PageFactory.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

public class CompraSteps extends Browser {
    Login login = new Login();
    Inventario inventario = new Inventario();
    Produto produto = new Produto();
    Carrinho carrinho = new Carrinho();
    Checkout checkout = new Checkout();
    @Given("Acessa a Pagina")
    public void acessa_a_pagina() {
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
    }

    @And("Completa os dados de acesso com o usuario {string}")
    public void completaOsDadosDeAcessoComOUsuario(String usuario) {
        login.username.sendKeys(usuario);
        login.password.sendKeys("secret_sauce");
        login.btnLogin.submit();
    }

    @When("Ordena os Produtos {string}")
    public void ordenaOsProdutos(String tipo) throws InterruptedException {
        Thread.sleep(5000);
        WebElement selectElement = driver.findElement(By.className("product_sort_container"));
        Select filtroSelect = new Select(selectElement);
        if (tipo.equals("Name (Z to A)")){
            inventario.filtro.click();
            filtroSelect.selectByValue("za");
        } else if (tipo.equals("Name (A to Z)")){
            inventario.filtro.click();
            filtroSelect.selectByValue("az");
        }else if (tipo.equals("Price (low to high)")){
            inventario.filtro.click();
            filtroSelect.selectByValue("lohi");
        }else if (tipo.equals("Price (high to low)")){
            inventario.filtro.click();
            filtroSelect.selectByValue("hilo");
        }
    }

    @And("Seleciona Um produto")
    public void selecionaUmProduto() throws InterruptedException {
        Thread.sleep(5000);
        List <WebElement> produtos = driver.findElements(By.className("inventory_item_name"));
        Random random = new Random();
        int num_random = random.nextInt(produtos.size());
        produtos.get(num_random).click();
    }

    @And("Adiciona no carrinho")
    public void adicionaNoCarrinho() throws InterruptedException {
        Thread.sleep(5000);
        produto.btnCarrinho.click();
        produto.carrinho.click();
    }

    @And("Realiza o Checkout")
    public void realizaOCheckout() throws InterruptedException {
        Thread.sleep(2000);
        carrinho.btnCheckout.click();
        Thread.sleep(3000);
        checkout.primeiroNome.sendKeys("Teste");
        checkout.ultimoNome.sendKeys("Teste");
        checkout.CEP.sendKeys("88888888");
        checkout.btnContinue.click();
    }

    @Then("Finaliza a compra")
    public void finalizaACompra() throws InterruptedException {
        Thread.sleep(2000);
        if (checkout.erro.isDisplayed()){
            System.out.println("Erro no preenchimento");
            driver.quit();
        }else if (checkout.btnFinish.isDisplayed()) {
            checkout.btnFinish.click();
            Thread.sleep(2000);
            if (checkout.txtFinish.isDisplayed()){
                driver.quit();
            }else {
                System.out.println("Erro nao exibiu");
                driver.quit();
            }
        }

    }

}
