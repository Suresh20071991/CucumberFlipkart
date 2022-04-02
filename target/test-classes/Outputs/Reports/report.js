$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/Feature/Flipkart.feature");
formatter.feature({
  "name": "Testing sorting functionality in Flipkart",
  "description": "",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "Login to Flipkart",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@Sortprice"
    }
  ]
});
formatter.step({
  "name": "launch chrome and navigate to Flipkart url",
  "keyword": "Given "
});
formatter.step({
  "name": "user enters username as \"8012082898\" and password as \"Surabi@123\"",
  "keyword": "When "
});
formatter.step({
  "name": "user search products as \"\u003cproducts\u003e\"",
  "keyword": "And "
});
formatter.step({
  "name": "The products displayed",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "products"
      ]
    },
    {
      "cells": [
        "Samsung TV"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Login to Flipkart",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@Sortprice"
    }
  ]
});
formatter.step({
  "name": "launch chrome and navigate to Flipkart url",
  "keyword": "Given "
});
formatter.match({
  "location": "FlipkartStepdef.launchChromeAndNavigateURL()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user enters username as \"8012082898\" and password as \"Surabi@123\"",
  "keyword": "When "
});
formatter.match({
  "location": "FlipkartStepdef.user_enters_username_as_and_password_as(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user search products as \"Samsung TV\"",
  "keyword": "And "
});
formatter.match({
  "location": "FlipkartStepdef.searchProdunct(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "The products displayed",
  "keyword": "Then "
});
formatter.match({
  "location": "FlipkartStepdef.the_products_displayed()"
});
formatter.result({
  "status": "passed"
});
});