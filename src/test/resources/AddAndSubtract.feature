Feature: Test the application

  @Sample
  Scenario Outline: Sample Addition
    Given launch the application
    And user perform addition operation for <num1> and <num2>
    And user check result is <res>
    Examples:
      | num1 | num2 | res |
      | 2.0  | 3.0  | 5.0 |
      | 3.0  | 4.0  | 5.0 |

  @Sample
  Scenario Outline: Sample Subtraction
    Given launch the application
    And user perform subtraction operation for <num1> and <num2>
    And user check result is <res>
    Examples:
      | num1 | num2 | res  |
      | 3.0  | 2.0  | 1.0  |
      | 3.5  | 4.0  | -0.5 |