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
    public String type;
    //public String plot;
    //public String actors;
    //public String genre;
    //public String runtime;

    public MovieData (String title, String year, String type){
        this.title = title;
        this.year = year;
        this.type = type;
        //this.plot = plot;
        //this.actors = actors;
        //this.genre = genre;
        //this.runtime = runtime;
    }

    // SET methods
 /*   public void setActors(String actors) {
        this.actors = actors;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }*/

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setType(String type) {
        this.type = type;
    }

    // GET methods
/*    public String getActors() {
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
    }*/

    public String getName() {
        return title;
    }

    public String getYear() {
        return year;
    }

    public String getType() {
        return type;
    }

    public String[] getAll() {
        String[] infoarray = new String[] {title, year, type};
        return infoarray;
    }
}
