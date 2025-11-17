Feature: Gestionarea produselor din cos

  Scenario: Stergerea unui produs din minicart
    Given utilizatorul este pe pagina principala
    And utilizatorul navigheaza la categoria Men's wear Clothing
    And utilizatorul adauga in cos produsele cu pozitiile: 1, 2, 3
    And utilizatorul sterge din minicart produsul cu pozitia 2
    Then produsul este eliminat din minicart