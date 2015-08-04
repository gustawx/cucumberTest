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
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import pages.BasketPage;
import pages.HomePage;
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

    @Override
    public WebDriver getDefaultDriver(){
        return new FirefoxDriver();//HtmlUnitDriver();
    }

    @Given("^I have added a shirt to my bag$")
    public void i_have_added_a_shirt_to_my_bag() throws Throwable {
        //using rest request to add shirt to basket, just to shorten a bit...
        //and show restAssured ;)
        this.initFluent();
        this.initTest();
        goTo("http://www.marksandspencer.com");
        homePage.isAt();
    }

    @When("^I view the contents of my bag$")
    public void i_view_the_contents_of_my_bag() throws Throwable {
        homePage.goToBag();
        basketPage.isAt();
        Set<Cookie> cookiesSet = this.getDriver().manage().getCookies();
        Map<String, String> cookies = cookiesSet.stream().collect(Collectors.toMap(Cookie::getName, Cookie::getValue));
        String jsessionId = this.getDriver().manage().getCookieNamed("JSESSIONID").getValue();
        PrepareData.addShirtToBag(jsessionId, cookies);
    }

    @Then("^I can see the contents of the bag include a shirt$")
    public void i_can_see_the_contents_of_the_bag_include_a_shirt() throws Throwable {
        this.initFluent();
        this.initTest();
        this.getDriver().navigate().refresh();
        assertTrue(basketPage.getFirstBasketItemName().contains("Shirt"));
    }

    @After
    public void after() {
        this.quit();
    }
}