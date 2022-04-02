Feature: Testing sorting functionality in Flipkart

  @Sortprice
  Scenario Outline: Login to Flipkart
    Given launch chrome and navigate to Flipkart url
    When user enters username as "8012082898" and password as "Surabi@123"
    And user search products as "<products>"
    Then The products displayed

    Examples: 
      | products   |
      | Samsung TV |
