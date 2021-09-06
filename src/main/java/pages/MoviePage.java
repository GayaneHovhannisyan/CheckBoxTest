package pages;

import base.Helper;
import base.MyWait;
import base.MyWebDriver;
import objects.MovieObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MoviePage {
    @FindBy(css = "[data-testid='hero-title-block__title']")
    private WebElement moviePageName;
    @FindBy(css = "[data-testid='hero-title-block__metadata'] [href*='rdat']")
    private WebElement movieProductionYear;
    @FindBy(css = "[class^='AggregateRatingButton__RatingScore']")
    private List<WebElement> moviePageRating;
    private final MyWait wait = new MyWait();

    public MovieObject getMovie() {
        return new MovieObject(getMoviePageName(),
                getMoviePageRating(),
                getMovieProductionYear());
    }

    public String getMoviePageName() {
        return wait.waitForElement(MyWebDriver.getDriver(), moviePageName).getText();
    }

    public Double getMoviePageRating() {

        return Double.parseDouble(moviePageRating.get(0).getText());
    }

    public Integer getMovieProductionYear() {

        return Integer.parseInt(movieProductionYear.getText());
    }

    public Double getMovieRatingFromPage() {
        Double.parseDouble(moviePageRating.get(0).getText());
        return Double.parseDouble(moviePageRating.get(0).getText());
    }

}
