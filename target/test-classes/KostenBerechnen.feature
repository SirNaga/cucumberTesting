Feature: Wie viel Kostet ein Zug von Wien nach Linz?
  Berechne die Kosten einer Zugverbindung

  Scenario: Zug von Wien nach Linz kostet 38,50€
    Given StarteWebApp
    And NavigiereZuTicketBuchung
    When Wähle
      | Von  | Nach | Datum          | Uhrzeit | Anzahl | Ermäßigung
      | Wien | Linz | Mo, 14.06.2021 | 21:50   | 1      | keine
    Then Ticketkosten betragen 38.40