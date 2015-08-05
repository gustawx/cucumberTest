package com.bdd.steps;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fluentlenium.core.annotation.Page;
import org.fluentlenium.cucumber.adapter.FluentCucumberTest;
import org.fluentlenium.cucumber.adapter.util.SharedDriver;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.BasketPage;
import pages.HomePage;
import pages.ShirtPage;
import rest.PrepareData;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static junit.framework.Assert.assertTrue;

@SharedDriver(type = SharedDriver.SharedType.PER_FEATURE)
public class BasketSteps extends FluentCucumberTest {

    @Page
    HomePage homePage;
    @Page
    BasketPage basketPage;
    @Page
    ShirtPage shirtPage;

    @Override
    public WebDriver getDefaultDriver(){
        return new FirefoxDriver();
    }

    @Given("^I have added a shirt to my bag$")
    public void i_have_added_a_shirt_to_my_bag() throws Throwable {
        this.initFluent();
        this.initTest();
        goTo(shirtPage);
        shirtPage.isAt();
        shirtPage.addShirtToBasket();
    }

    @When("^I view the contents of my bag$")
    public void i_view_the_contents_of_my_bag() throws Throwable {
        homePage.goToBag();
        basketPage.isAt();
//        shirt could be added by sending rest request, e.g.:
//        Set<Cookie> cookiesSet = this.getDriver().manage().getCookies(); //getting cookies
//        Map<String, String> cookies = cookiesSet.stream().collect(Collectors.toMap(Cookie::getName, Cookie::getValue)); //converting Set to Map
//        String jsessionId = this.getDriver().manage().getCookieNamed("JSESSIONID").getValue(); //getting jsessionId
//        PrepareData.addShirtToBag(jsessionId, cookies);
    }

    @Then("^I can see the contents of the bag include a shirt$")
    public void i_can_see_the_contents_of_the_bag_include_a_shirt() throws Throwable {
        assertTrue(basketPage.getFirstBasketItemName().contains("Shirt"));
    }

    @After
    public void after() {
        this.quit();
    }
}