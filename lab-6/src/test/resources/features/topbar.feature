Feature: Top bar navigation

  Scenario: Navigare prin meniul de sus
    Given utilizatorul este pe pagina principala
    When utilizatorul navigheaza prin meniul de sus accesand linkurile:
      | About          |
      | Men's wear     |
      | Clothing       |
      | Women's wear   |
      | Women Clothing |
      | Contact        |
    Then fiecare pagina din meniu este afisata corect
