$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("cucumber/basket.feature");
formatter.feature({
  "id": "as-a-customer,-i-wish-to-view-the-contents-of-my-bag-prior-to-checkout",
  "description": "",
  "name": "As a customer, I wish to view the contents of my bag prior to checkout",
  "keyword": "Feature",
  "line": 1
});
formatter.scenario({
  "id": "as-a-customer,-i-wish-to-view-the-contents-of-my-bag-prior-to-checkout;add-shirt-to-bag-and-view-bag",
  "description": "",
  "name": "Add shirt to bag and view bag",
  "keyword": "Scenario",
  "line": 3,
  "type": "scenario"
});
formatter.step({
  "name": "I have added a shirt to my bag",
  "keyword": "Given ",
  "line": 4
});
formatter.step({
  "name": "I view the contents of my bag",
  "keyword": "When ",
  "line": 5
});
formatter.step({
  "name": "I can see the contents of the bag include a shirt",
  "keyword": "Then ",
  "line": 6
});
formatter.match({
  "location": "BasketSteps.i_have_added_a_shirt_to_my_bag()"
});
formatter.result({
  "duration": 14318784570,
  "status": "passed"
});
formatter.match({
  "location": "BasketSteps.i_view_the_contents_of_my_bag()"
});
formatter.result({
  "duration": 5286617921,
  "status": "passed"
});
formatter.match({
  "location": "BasketSteps.i_can_see_the_contents_of_the_bag_include_a_shirt()"
});
formatter.result({
  "duration": 1846974,
  "status": "passed"
});
});