package pages;

import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.filter.FilterConstructor;
import org.openqa.selenium.JavascriptExecutor;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.fluentlenium.core.filter.FilterConstructor.withClass;

public class HomePage extends FluentPage {

    private static final String HOME_PAGE_URL = "http://www.marksandspencer.com";
    @Override
    public String getUrl() {
        return HOME_PAGE_URL;
    }
    @Override
    public void isAt() {
        assertThat(title()).isEqualTo("Welcome to Marks & Spencer");
    }

    public void goToBag(){
        find(".duck-link", withClass().notContains("swap-link duck-link")).get(0).click();
        await().atMost(5, TimeUnit.SECONDS).until("h1").containsText("Your secure bag");
    }
}
