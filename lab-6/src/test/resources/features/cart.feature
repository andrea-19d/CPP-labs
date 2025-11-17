Feature: Gestionarea cosului de cumparaturi

  Scenario: Adaugare si stergere produse din cos
    Given utilizatorul este pe pagina principala
    When utilizatorul navigheaza la categoria Men's wear Clothing
    And utilizatorul adauga in cos produsele cu pozitiile:
      | 2  |
      | 4  |
      | 9  |
      | 11 |
    And utilizatorul sterge din cos produsele cu pozitiile:
      | 2 |
      | 2 |
    And utilizatorul adauga in cos produsul cu pozitia 1
    And utilizatorul inchide minicart-ul
    Then cosul este actualizat corect
