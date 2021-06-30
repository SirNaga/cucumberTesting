Feature: Gibt es eine Verbindung von Wien Hbf nach Linz/Donau Hbf am 30.6. zur aktuellen Uhrzeit?
  Suche eine gültige Zugverbindung

  Scenario: Zug von Wien Hbf nach Linz/Donau Hbf am 30.6. zur aktuellen Uhrzeit wird gefunden.
    Given StarteApp
    When Auswahl
    Then connection from Wien Hbf exists true