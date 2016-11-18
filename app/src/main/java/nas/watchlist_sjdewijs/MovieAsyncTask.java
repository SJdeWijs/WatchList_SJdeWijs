package nas.watchlist_sjdewijs;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Sander de Wijs on 14-11-2016.
 * Retrieves information in JSONObject and passes it to MovieData
 */

// create class which extends to an AsyncTask class, with arguments movie title, integer, and result
public class MovieAsyncTask extends AsyncTask<String, Integer, String> {
    // zoekopdracht, integer, result (hele lijst van info)
    Context context;
    MainActivity activity;

    // constructor waarmee je een instance kan aanmaken. In deze class kunnen we nu ook bij de main activity.
    public MovieAsyncTask(MainActivity activity) {
        this.activity = activity;
        this.context = this.activity.getApplicationContext();
    }


/*    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }*/

    // show toast while processing input and loading data
    public void onPreExecute(){
        Toast.makeText(context, "Retrieving data", Toast.LENGTH_LONG);
    }

    // create array, then send it to onPostExecute()
    protected String doInBackground(String... params) {
        return HttpRequestHelper.downloadFromServer(params);
    }

    public void onProgressUpdate(){
        // als je iets langdurigs doet kan je user update van, je zit nu op 50%.

    }

    // fills ListView with JSONObject, after recieving result from background
    public void onPostExecute(String result){
        super.onPostExecute(result);

        try {
            JSONObject resultObj = new JSONObject(result);
            // JSONObject respObj = new JSONObject(result);

            String response = resultObj.getString("Response");
            // movie title was not found or failed to connect
            if (response.equals("False") == true) {
                Toast.makeText(context, "No data was found", Toast.LENGTH_LONG);
            }
            // iterate through the JSON to extract each object
            else {
                JSONArray movies = resultObj.getJSONArray("Search");
                ArrayList<MovieData> moviedata = new ArrayList<>();

                for (int i = 0; i < movies.length(); i++) {

                    JSONObject movie = movies.getJSONObject(i);
                    String title = movie.getString("Title");
                    String year = movie.getString("Year");
                    String plot = movie.getString("Plot");
                    String actors = movie.getString("Actors");
                    String genre = movie.getString("Genre");
                    String runtime = movie.getString("Runtime");
                    moviedata.add(new MovieData(title, year, plot, actors, genre, runtime));
                }
            }
        }
        catch (JSONException e){
            e.printStackTrace();
        }
            //this.activity.setData(trackdata);
    }
}