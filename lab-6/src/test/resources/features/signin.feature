Feature: Sign in user

  Scenario: Sign in cu date valide
    Given utilizatorul este pe pagina principala
    When utilizatorul deschide formularul de autentificare
    And utilizatorul completeaza formularul de autentificare cu:
      | name  | andrea                    |
      | email | andrea.robu@email.com     |
    And utilizatorul trimite formularul de autentificare
    Then pagina de dupa autentificare este afisata corect

  Scenario: Sign in cu date invalide
    Given utilizatorul este pe pagina principala
    When utilizatorul deschide formularul de autentificare
    And utilizatorul completeaza formularul de autentificare cu:
      | name  | 123     |
      | email | andrea  |
    And utilizatorul trimite formularul de autentificare
    Then autentificarea nu este efectuata