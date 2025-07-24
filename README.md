![Java](https://img.shields.io/badge/Java-21+-red)
![Selenium](https://img.shields.io/badge/Selenium-4.x-green)
![Azure-Pipelines](https://img.shields.io/badge/Azure%20Pipelines-CI-blue)
![Status](https://img.shields.io/badge/Status-Em%20Desenvolvimento-yellow)

# 📚 Shop-Book com Selenium e Azure

Projeto de estudo voltado para testes automatizados utilizando **Selenium WebDriver** com **Java**, focado em integração com **Azure DevOps** para execução contínua dos testes automatizados. Todo o fluxo foi construído simulando um ambiente profissional: a geração de tarefas foi feita com o apoio de IA, os testes foram versionados e organizados no Azure Boards, e a automação integrada ao pipeline CI.

---

## 🚀 Sobre o Projeto

Este projeto teve como objetivo aprofundar o conhecimento em **Selenium** e **Integração Contínua com Azure DevOps**, utilizando práticas próximas ao ambiente corporativo:

- Exploração prática do **CLI do Azure DevOps** para criar, rastrear e vincular tasks aos testes automatizados.
- Organização de demandas simuladas com uso de **IA para criação de tarefas** realistas no Azure Boards.
- Implementação de um fluxo de testes automatizados Web com **Selenium WebDriver**, integrando as execuções ao pipeline do Azure.
- Controle de versão com Git, integração com GitHub e deploy automatizado de testes via pipeline no Azure.

Essa abordagem trouxe mais realismo e experiência prática de como seria o fluxo de trabalho de uma equipe de QA atuando com **automação de testes em pipelines CI/CD**.

---

## 🛠️ Informações Técnicas

- **Plataforma testada:** [https://practice.automationtesting.in/](https://practice.automationtesting.in/)
- **Framework de automação:** [Selenium WebDriver](https://www.selenium.dev/)
- **Linguagem:** Java 21+
- **Padrão de Projeto:** Page Object Model (POM)
- **Organização dos testes:** JUnit 5
- **Gerenciamento de dependências:** Maven
- **Criação de dados dinâmicos:** Java Faker
- **Execução em ambiente CI:** Azure Pipelines
- **Execução headless:** Ativada via `ChromeOptions` (para compatibilidade CI)
- **Simulação de ambiente profissional:**
  - O projeto foi organizado em formato de sprints com tarefas descritas no **Azure Boards**.
  - As atividades foram geradas com auxílio de IA para simular demandas reais.
- **Boas práticas adotadas:**
  - Testes independentes com `@BeforeEach` e `@AfterEach`
  - Separação clara entre páginas, dados e testes
  - Esperas explícitas com utilitários personalizados (`WaitHelper`)
  - Dados válidos e inválidos criados por meio da fábrica de dados `UserDataFactory`


---

## ✅ Cenários de Teste

Os testes foram organizados com IDs padronizados para facilitar rastreabilidade. Foram criados dados dinâmicos com o JavaFaker e a estrutura `UserDataFactory`.


### 📂 HomeTest.java

| Código    | Cenário                                                                 |
|-----------|-------------------------------------------------------------------------|
| CT-001    | Validar a busca de produtos ao digitar um termo no campo de pesquisa.  |
| CT-002    | Validar a navegação para a página "Shop".                               |
| CT-003    | Validar a navegação para a página "My Account".                         |
| CT-004    | Validar a navegação para a página "Test Cases".                         |
| CT-005    | Validar a navegação para a página "AT Site".                            |
| CT-006    | Validar a navegação para a página "Demo Site".                          |
| CT-007    | Adicionar um único produto ao carrinho e validar botão "View Basket".  |
| CT-008    | Adicionar três produtos ao carrinho e validar botão "View Basket".     |
| CT-009    | Adicionar produtos ao carrinho e acessar o link do carrinho.           |
| CT-010    | Validar envio de e-mail no formulário de newsletter (mensagem esperada).|

<img src="https://github.com/carolprotasio/shop-book/blob/main/src/test/java/utils/assets/homeTest.png" alt="web" width="600"/>

### 📂 ShopTest.java

| Código    | Cenário                                                                                             |
|-----------|-----------------------------------------------------------------------------------------------------|
| CT-001    | Adicionar o primeiro produto da listagem ao carrinho.                                               |
| CT-002    | Adicionar três produtos ao carrinho e validar contagem de itens.                                   |
| CT-003    | Filtrar produtos por faixa de preço e validar produto e preço exibido.                             |
| CT-004    | Verificar os detalhes do produto "Selenium Ruby".                                                  |
| CT-005    | Adicionar um produto ao carrinho diretamente da página de detalhes.                                |
| CT-006    | Adicionar um produto e removê-lo do carrinho na página "Basket".                                   |
| CT-007    | Atualizar a quantidade de um produto no carrinho e validar a alteração.                            |
| CT-008    | Realizar fluxo completo de compra: adicionar produto, preencher dados de checkout e finalizar pedido.|

<img src="https://github.com/carolprotasio/shop-book/blob/main/src/test/java/utils/assets/shopTest.png" alt="web" width="600"/>

## 🔁 Integração Contínua com Azure DevOps

O pipeline no **Azure Pipelines** foi configurado para:

- Executar os testes automatizados a cada push na branch `main` ou `develop`.
- Exibir os resultados diretamente na interface do Azure com logs e status detalhado.
- Permitir visualização clara de falhas e rastreamento dos commits associados.

Também foi utilizado o **Azure Boards** para simular o gerenciamento de tarefas, com cada cenário de teste sendo uma task vinculada a um commit e execução no pipeline.

<img src="https://github.com/carolprotasio/shop-book/blob/main/src/test/java/utils/assets/azure2.png" alt="web" width="600"/>
<img src="https://github.com/carolprotasio/shop-book/blob/main/src/test/java/utils/assets/pipelineStages.png" alt="web" width="600"/>

---

## ⚙️ Pré-requisitos

- Java 21 ou superior
- Maven 3.8+
- Google Chrome instalado
- Git

Clone o projeto:

```bash
git clone https://github.com/carolprotasio/shop-book.git
```

## 📌 Conclusão

Este projeto proporcionou uma experiência completa de testes automatizados Web com foco em:

- Profundidade técnica no uso do Selenium WebDriver com Java.
- Conhecimento aplicado em ambientes CI/CD com Azure Pipelines.
- Integração realista com Azure Boards para simular gestão de QA.
- Uso de boas práticas em arquitetura de testes (POM, fábrica de dados, organização de código).
- Simulação prática de sprints, utilizando IA como geradora de demandas e tarefas de teste.
- Execução contínua e validada automaticamente a cada push no repositório.


---



🔗 Projeto Azure: privado (acesso sob solicitação)
