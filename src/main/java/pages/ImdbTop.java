package pages;

import base.MyWebDriver;
import objects.MovieObject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ImdbTop {

    @FindBy(css = "[class='lister-list'] tr")
    private List<WebElement> top250Films;
    @FindBy(css = "[class='titleColumn'] a")
    private List<WebElement> movieListClickable;
    @FindBy(css = "[class='ratingColumn imdbRating']")
    private List<WebElement> top250FilmsRatings;
    @FindBy(css = "[class='secondaryInfo']")
    private List<WebElement> movieProductionYear;

    public List<WebElement> getTopMoviesLinks() {
        return movieListClickable;
    }

    public List<MovieObject> movies;

    public List<MovieObject> getMovies() {
        final List<String> moviesName = top250MoviesNames();
        final List<Double> moviesRating = movieRatings();
        final List<Integer> moviesYear = top250MoviesProductionYearStrip();
        movies = new ArrayList<>();
        for (int i = 0; i < moviesName.size(); i++) {
            movies.add(new MovieObject(moviesName.get(i),
                    moviesRating.get(i),
                    moviesYear.get(i)));
        }
        return movies;

    }


        public List<String> top250MoviesNames() {
        List<String> moviesNames = new ArrayList<>();
        for (WebElement movie : top250Films) {
            String movieName = movie.getText().split("[.]")[1];
            movieName = movieName.split("[(]")[0];
            moviesNames.add(movieName.strip());
        }
        return moviesNames;
    }


        public List<Integer> top250MoviesProductionYearStrip () {
            List<Integer> movieProductionYearList = new ArrayList<>();
            for (WebElement productionYear : movieProductionYear) {
                String productionYearValue = productionYear.getText().split("[(]")[1];
                productionYearValue = productionYearValue.split("[)]")[0];
                movieProductionYearList.add(Integer.parseInt(productionYearValue.strip()));
            }
            return movieProductionYearList;
        }


        public List<Double> movieRatings () {
            List<Double> ratings = new ArrayList<>();
            for (WebElement rating : top250FilmsRatings) {
                String ratingValue = rating.getText();
                if (ratingValue.contains(",")) {
                    ratingValue = ratingValue.replace(",", ".");
                }
                ratings.add(Double.parseDouble(ratingValue));
            }
            return ratings;
        }

        public Map<String, Double> movieRatingMap () {
            Map<String, Double> movieRating = new HashMap<>();
            List<String> top250MoviesNames = top250MoviesNames();
            List<Double> ratings = movieRatings();
            for (int i = 0; i < ratings.size(); i++) {
                movieRating.put(top250MoviesNames.get(i), ratings.get(i));
            }
            return movieRating;
        }


    public List<WebElement> getTop250Films() {
        return top250Films;
    }
}