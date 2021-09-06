package real;

import base.BaseTest;
import base.Helper;
import dataproviders.IndexDataProvider;
import objects.MovieObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert.*;
import org.testng.annotations.*;
import pages.ImdbTop;
import pages.MoviePage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.testng.Assert.*;

public class TopMoviesTest extends BaseTest {
    private List<String> moviesName;
    private List<Integer> moviesProductionYear;
    private List<WebElement> moviesLinks;
    private List<Double> movieRatings;
    private List<String> moviesNames;
    private ImdbTop moviesListPage;
    private MoviePage moviePage;
    private Helper helper;
    private List<MovieObject> movies;

    @BeforeClass
    public void setUp() {
        getDriver().get("https://www.imdb.com/chart/top/");
        moviesListPage = PageFactory.initElements(getDriver(), ImdbTop.class);
        moviesName = moviesListPage.top250MoviesNames();
        moviesProductionYear = moviesListPage.top250MoviesProductionYearStrip();
        moviesLinks = moviesListPage.getTopMoviesLinks();
        movies = moviesListPage.getMovies();
        movieRatings=moviesListPage.movieRatings();
        helper = new Helper();

    }

    /*
        @Test(testName = "Top IMDB movies")
        public void topMoviesTest() {
            final String shawshankRedemption = "Побег из Шоушенка";
            final String pulpFiction = "Криминальное чтиво";
            final int shawshankRedemptionindex = 0;
            final int pulpFictionIndex = 7;


            moviesNames = moviesListPage.top250MoviesNames();
    //        tell about magic number
            assertEquals(moviesNames.get(shawshankRedemptionindex), shawshankRedemption);
            assertEquals(moviesNames.get(pulpFictionIndex), pulpFiction);

            movieRatings = moviesListPage.movieRatings();
            for (int i = 0; i < movieRatings.size() - 1; i++) {
                assertTrue(movieRatings.get(i) - movieRatings.get(i + 1) >= 0);
            }

            List<Double> ratingsSorted = new ArrayList<>(movieRatings);
            ratingsSorted.sort(Collections.reverseOrder());
            assertEquals(movieRatings, ratingsSorted);
        }
    */
    @Test(priority = 1, testName = "Check list and details page rating correspondence", dataProvider = "indexes", dataProviderClass = IndexDataProvider.class)
    public void listDetailsRatingsTest(int movieRatingIndex) {
        helper.scrollIntoView(moviesLinks.get(movieRatingIndex));
        Double movieRating = movieRatings.get(movieRatingIndex);
        helper.ctrlClick(getDriver(), moviesLinks.get(movieRatingIndex));

        ArrayList<String> tabs2 = new ArrayList<>(getDriver().getWindowHandles());
        getDriver().switchTo().window(tabs2.get(1));
        MoviePage moviePage = PageFactory.initElements(getDriver(), MoviePage.class);
        getDriver().close();
        getDriver().switchTo().window(tabs2.get(0));

        assertEquals(moviePage.getMovieRatingFromPage(), movieRating, "The movie " + moviesNames.get(movieRatingIndex) + " rating is defferent in list and page");
    }

    @Test(priority = 0, testName = "Check list and details page name correspondence", dataProvider = "indexes", dataProviderClass = IndexDataProvider.class)
    public void topMoviesNameTest(int movieNameIndex) {
        Helper helper = new Helper();
        String path = "C:\\Users\\HP\\Desktop\\FileScreen\\";
        String fileName = "Element.jpg";
        helper.screenShotAshot(getDriver(), path + fileName);


        helper.scrollIntoView(moviesLinks.get(movieNameIndex));
        WebElement movieLink = moviesLinks.get(movieNameIndex);
        helper.ctrlClick(getDriver(), movieLink);
        List<String> tabs = new ArrayList<>(getDriver().getWindowHandles());
        getDriver().switchTo().window(tabs.get(1));
        moviePage = PageFactory.initElements(getDriver(), MoviePage.class);
        String movieName = moviePage.getMoviePageName();
        getDriver().close();
        getDriver().switchTo().window(tabs.get(0));

        assertEquals(movieName, moviesName.get(movieNameIndex));
    }

    @Test(priority = 1, testName = "check Movie production Year", dataProvider = "indexes",
            dataProviderClass = IndexDataProvider.class)
    public void topMovieProductionYearTest(int movieIndex) {
        WebElement movieLink = moviesLinks.get(movieIndex);
        Integer movieYear = moviesProductionYear.get(movieIndex);
        helper.ctrlClick(getDriver(), movieLink);
        List<String> tabs = new ArrayList<>(getDriver().getWindowHandles());
        getDriver().switchTo().window(tabs.get(1));
        moviePage = PageFactory.initElements(getDriver(), MoviePage.class);
        Integer movieYearOfPage = moviePage.getMovieProductionYear();
        getDriver().close();
        getDriver().switchTo().window(tabs.get(0));

        assertEquals(movieYearOfPage, movieYear);
    }

    @Test(testName = "MoviesObjectTest", dataProvider = "indexes",
            dataProviderClass = IndexDataProvider.class)
    public void moviesObjectTest(int movieIndex) {
        Helper helper = new Helper();
        helper.scrollIntoView(moviesLinks.get(movieIndex));
        helper.ctrlClick(getDriver(), moviesLinks.get(movieIndex));
        ArrayList<String> tabs2 = new ArrayList<>(getDriver().getWindowHandles());
        getDriver().switchTo().window(tabs2.get(1));
        MoviePage moviePage = PageFactory.initElements(getDriver(), MoviePage.class);
        MovieObject movie = moviePage.getMovie();
        getDriver().close();
        getDriver().switchTo().window(tabs2.get(0));

        assertEquals(movies.get(movieIndex), movie);
    }

    @AfterTest(alwaysRun = true)
    public void tearDown() {
        getDriver().quit();
    }
}