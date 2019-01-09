Feature: Sample One Feature

  @Sample
  Scenario Outline: Sample Multiplication
    Given launch the application
    And user perform multiplication operation for <num1> and <num2>
    And user check result is <res>
    Examples:
      | num1 | num2 | res  |
      | 3.0  | 2.0  | 6.0  |
      | 3.5  | 4.0  | 11.0 |

  @Sample
  Scenario Outline: Sample Division
    Given launch the application
    And user perform division operation for <num1> and <num2>
    And user check result is <res>
    Examples:
      | num1 | num2 | res      |
      | 3.0  | 2.0  | 1.5      |
      | 0    | 1    | 1.0      |
      | 1    | 0    | Infinity |