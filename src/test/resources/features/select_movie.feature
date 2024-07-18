Feature: Movie Selection

  Scenario: Select Movie and Theater
    Given The user "UserQA" Login with user "automationtestbc@yopmail.com" and password "Colombia2024#"
    And The user selects a theater "Lab v5 Multiplaza"
    When The user selects movie "Capitana" at "20:40" the day "HOY"
    Then The user can see the showtimes for the selected movie and theater