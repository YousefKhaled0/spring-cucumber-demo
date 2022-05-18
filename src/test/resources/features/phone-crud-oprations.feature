Feature: Phone CRUD operations

  Scenario: Get all stored phones
    Given the the following phones
      | brand   | model               |
      | Samsung | Galaxy Z Flip       |
      | Samsung | Galaxy M31          |
      | Xiaomi  | Redmi 10 Prime 2022 |
      | Xiaomi  | Redmi 10 Power      |
    When the user requests all phones
    Then all phones are returned

  Scenario: Add new phone
    Given the the following phone
      | brand   | model         |
      | Samsung | Galaxy Z Flip |
    When the user requests add phone
    Then success response with the phone created

  Scenario: Get phone
    Given the the following phones with IDs
      | id                                   | brand   | model               |
      | a12bee16-5e70-4038-83de-413837e22d2f | Samsung | Galaxy Z Flip       |
      | 91ac07a0-80a7-49c1-922a-9abd8b23c57f | Samsung | Galaxy M31          |
      | e2b97db5-19b8-4dd5-9cfb-f9264477f13b | Xiaomi  | Redmi 10 Prime 2022 |
      | 7f223352-bab7-427b-a155-05d80ad270a3 | Xiaomi  | Redmi 10 Power      |
    When  the user requests to get phone with id e2b97db5-19b8-4dd5-9cfb-f9264477f13b
    Then success response with the phone details

  Scenario: Delete a phone
    Given the the following phones with IDs
      | id                                   | brand   | model               |
      | a12bee16-5e70-4038-83de-413837e22d2f | Samsung | Galaxy Z Flip       |
      | 91ac07a0-80a7-49c1-922a-9abd8b23c57f | Samsung | Galaxy M31          |
      | e2b97db5-19b8-4dd5-9cfb-f9264477f13b | Xiaomi  | Redmi 10 Prime 2022 |
      | 7f223352-bab7-427b-a155-05d80ad270a3 | Xiaomi  | Redmi 10 Power      |
    When the user requests to delete phone with id e2b97db5-19b8-4dd5-9cfb-f9264477f13b
    Then the phone is deleted with no content response