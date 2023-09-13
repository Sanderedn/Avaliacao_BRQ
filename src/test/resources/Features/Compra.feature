Feature: Realizar uma compra com sucesso
  Scenario: Fazer uma compra
    Given Acessa a Pagina
    And Completa os dados de acesso com o usuario "performance_glitch_user"
    When Ordena os Produtos "Name (Z to A)"
    And Seleciona Um produto
    And Adiciona no carrinho
    And Realiza o Checkout
    Then Finaliza a compra