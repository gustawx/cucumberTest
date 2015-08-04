package pages;

import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.domain.FluentWebElement;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BasketPage extends FluentPage{

    private static final String BASKET_PAGE_URL = "http://www.marksandspencer.com/OrderCalculate";
    @Override
    public String getUrl() {
        return BASKET_PAGE_URL;
    }
    @Override
    public void isAt() {
        assertThat(title()).isEqualTo("My Basket");
    }

    public String getFirstBasketItemName(){
        List<FluentWebElement> items = find(".heading-product>a");
        return items.size() > 0 ? items.get(0).getText() : "Basket is empty!";
    }
}
