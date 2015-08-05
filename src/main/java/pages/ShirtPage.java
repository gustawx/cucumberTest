package pages;

import org.fluentlenium.core.FluentPage;

import static org.assertj.core.api.Assertions.assertThat;
import static org.fluentlenium.core.filter.FilterConstructor.withId;
import static org.fluentlenium.core.filter.FilterConstructor.withText;

public class ShirtPage extends FluentPage{

    private static final String SHIRT_PAGE_URL = "http://www.marksandspencer.com/no-peep-pure-cotton-embroidered-shirt/p/p60070191";

    @Override
    public String getUrl() {
        return SHIRT_PAGE_URL;
    }
    @Override
    public void isAt() {
        assertThat(title()).isEqualTo("No Peep™ Pure Cotton Embroidered Shirt | M&S");
    }

    public void addShirtToBasket(){
        find("label", withText("16")).click();
        find("input", withId().startsWith("basket_")).click();
    }
}
