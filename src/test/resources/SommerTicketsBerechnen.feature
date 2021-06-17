Feature: Wie viel kosten zwei Sommertickets (30 Tage)?
  Berechne die Kosten einer Zugverbindung

  Scenario: Auswahl von zwei Sommertickets (30 Tage)
    Given StarteWebApp2
    When User bestellt 2 Sommertickets
    Then Sommerticketkosten betragen 78.00