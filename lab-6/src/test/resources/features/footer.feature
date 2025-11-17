Feature: Verificarea linkurilor din footer

  Scenario: Linkurile din footer deschid paginile corecte
    Given utilizatorul este pe pagina principala
    When utilizatorul navigheaza la sectiunea de footer
    And utilizatorul verifica linkurile din footer folosind css:
      | css                                | urlPart      |
#      | .col-md-4 li:nth-child(1) > a      | /            | #
      | .col-md-4 li:nth-child(2) > a      | men          | # Men's Wear
      | .col-md-4 li:nth-child(3) > a      | womens       | # Women's Wear
      | .col-md-4 li:nth-child(4) > a      | about        | # About
      | .col-md-4 li:nth-child(5) > a      | contact      | # Contact
