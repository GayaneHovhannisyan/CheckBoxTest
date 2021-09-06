package objects;

import java.util.Objects;

public class MovieObject {


    private final String movieName;
    private final Double rating;
    private final Integer year;


    public MovieObject(final String movieName, final Double rating, final Integer year) {
        this.movieName = movieName;
        this.rating = rating;
        this.year = year;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovieObject that = (MovieObject) o;
        return Objects.equals(movieName, that.movieName) &&
                (Objects.equals(rating, that.rating) ||
                        Objects.equals(rating - 0.1, that.rating) ||
                        Objects.equals(rating, that.rating - 0.1))
                &&
                Objects.equals(year, that.year);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "MovieObject{" +
                "rating=" + rating +
                '}';
    }



    public String getMovieName() {
        return movieName;
    }

    public Double getRating() {
        return rating;
    }

    public Integer getYear() {
        return year;
    }

}
