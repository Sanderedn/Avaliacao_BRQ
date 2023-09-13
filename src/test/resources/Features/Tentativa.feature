Feature: Realizar uma tentativa de Compra
  Scenario: Fazer uma compra
    Given Acessa a Pagina
    And Completa os dados de acesso com o usuario "problem_user"
    And Seleciona Um produto
    And Adiciona no carrinho
    And Realiza o Checkout
    Then Finaliza a compra