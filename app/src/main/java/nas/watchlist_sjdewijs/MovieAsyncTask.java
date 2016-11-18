package nas.watchlist_sjdewijs;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
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
    Context context;
    MainActivity activity;

    // make main activity accesable in this class
    public MovieAsyncTask(MainActivity activity) {
        this.activity = activity;
        this.context = this.activity.getApplicationContext();
    }

    // show toast while processing input and loading data
    public void onPreExecute(){
        Toast.makeText(context, "Retrieving data", Toast.LENGTH_LONG);
    }

    // create an array of strings, then send return value from server to onPostExecute()
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

            ArrayList<MovieData> moviedata = new ArrayList<>();

            // movie title was not found or failed to connect
            if (response.equals("False") == true) {
                Toast.makeText(context, "No data was found", Toast.LENGTH_LONG);
            }
            // iterate through the JSON to extract each object
            else {
                // starts looking when "Search" is found in JSON
                JSONArray movies = resultObj.getJSONArray("Search");

                for (int i = 0; i < movies.length(); i++) {

                    JSONObject movie = movies.getJSONObject(i);
                    String title = movie.getString("Title");
                    String year = movie.getString("Year");
                    String type = movie.getString("Type");
                    //String actors = movie.getString("Actors");
                    //String genre = movie.getString("Genre");
                    //String runtime = movie.getString("Runtime");
                    moviedata.add(new MovieData(title, year, type));
                }
                String message = moviedata.get(0).getYear();
                Log.d("Year is ", message);
            }
            activity.setData(moviedata);
        }
        catch (JSONException e){
            e.printStackTrace();
        }
    }
}