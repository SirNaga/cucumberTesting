Feature: Gibt es eine Verbindung von Wien Hbf nach Linz/Donau Hbf am 3.7. zur aktuellen Uhrzeit, die nicht mehr als 50 Euro kostet?

  Scenario: Zug von Wien Hbf nach Linz/Donau Hbf am 3.7. zur aktuellen Uhrzeit kostet nicht mehr als 50 Euro.
    Given StartePreisApp
    When PreisAuswahl
    Then connection from Wien Hbf costs less than fifty bucks