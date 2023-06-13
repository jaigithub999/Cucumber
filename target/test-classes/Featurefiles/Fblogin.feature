Feature: To validate the login functinality

  Background: 
    Given user launch the facebook application

  Scenario: To validate login functionality with invalid username and invalid password
    When user enter invalid username and invalid password
      | username   | password         | credential |
      | djlskd     | djlskd@gamil.com | negative   |
      | xzvbjl     | xzvbjl@gmail     | negative   |
      | Tesasjstng | Tesasjstng@123   | negative   |
    And user click login button
    Then user see the results based on the credential

  Scenario: To validate the login functionality without entering username and password
    When user click login button without username and password
    Then user should see error message
