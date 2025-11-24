Feature: Scenarii extra pentru Google Search

  Scenario: Utilizatorul poate cauta in limbi diferite
    Given utilizatorul deschide browserul pe pagina Google
    When utilizatorul cauta dupa textul "instagram"
    Then se afiseaza un numar pozitiv de rezultate in pagina
    When utilizatorul cauta dupa textul "Инстаграм"
    Then se afiseaza un numar pozitiv de rezultate in pagina
    When utilizatorul cauta dupa textul "インスタグラム"
    Then se afiseaza un numar pozitiv de rezultate in pagina


  Scenario: Google Search nu este case sensitive
    Given utilizatorul deschide browserul pe pagina Google
    When utilizatorul cauta dupa textul "Selenium WebDriver"
    Then salveaza primul rezultat
    When utilizatorul cauta dupa textul "selenium webdriver"
    Then primul rezultat este acelasi ca primul salvat

  Scenario: La cautarea "calculator" apare widgetul de calculator
    Given utilizatorul deschide browserul pe pagina Google
    When utilizatorul cauta dupa textul "calculator"
    Then se afiseaza calculatorul Google

  Scenario: La cautarea "Google converter services" apare converterul sus
    Given utilizatorul deschide browserul pe pagina Google
    When utilizatorul cauta dupa textul "Google converter services"
    Then serviciul de conversie apare in partea de sus
