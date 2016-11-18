package nas.watchlist_sjdewijs;

import android.app.Activity;

/**
 * Created by Sander de Wijs on 14-11-2016.
 * Contains the information of chosen movies.
 */

public class MovieData {

    // create strings for each element of information to return to user
    public String title;
    public String year;
    public String plot;
    public String actors;
    public String genre;
    public String runtime;

    public MovieData (String title, String year, String plot, String actors, String genre, String runtime){
        this.title = title;
        this.year = year;
        this.plot = plot;
        this.actors = actors;
        this.genre = genre;
        this.runtime = runtime;
    }

    public String getActors() {
        return actors;
    }

    public String getGenre() {
        return genre;
    }

    public String getPlot() {
        return plot;
    }

    public String getRuntime() {
        return runtime;
    }

    public String getTitle() {
        return title;
    }

    public String getYear() {
        return year;
    }

    public String[] getAll() {
        String[] infoarray = new String[] {title, year, plot, actors, genre, runtime};
        return infoarray;
    }
}
