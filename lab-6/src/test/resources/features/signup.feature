Feature: Sign up user

  Scenario: Sign up cu date valide
    Given utilizatorul este pe pagina principala
    When utilizatorul deschide formularul de inregistrare
    And utilizatorul completeaza formularul de inregistrare cu:
      | name        | andrea                 |
      | email       | andrea.robu@mail.com   |
      | password    | rererere               |
      | confirmPass | rererere               |
    And utilizatorul trimite formularul de inregistrare
    Then pagina de dupa inregistrare este afisata corect

  Scenario: Sign up cu date invalide
    Given utilizatorul este pe pagina principala
    When utilizatorul deschide formularul de inregistrare
    And utilizatorul completeaza formularul de inregistrare cu:
      | name        | ande22  |
      | email       | andrea  |
      | password    | a1      |
      | confirmPass | a1      |
    And utilizatorul trimite formularul de inregistrare
    Then inregistrarea nu este efectuata