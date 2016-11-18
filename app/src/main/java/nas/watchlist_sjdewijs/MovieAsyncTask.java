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
 */

public class MovieAsyncTask extends AsyncTask<String, Integer, String> {

    Context context;
    MainActivity activity;

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

        // tag slaat nergens op of verbinding is niet gelukt
        if (result.length() == 0) {
            Toast.makeText(context, "No data was found", Toast.LENGTH_LONG);
        }
        else {
            // in TrackData staan titel, omschrijving e.d., zelf aangemaakt.
            ArrayList<MovieData> trackdata = new ArrayList<>();
            try {
                JSONObject respObj = new JSONObject(result);
                JSONObject topTracksObj = respObj.getJSONObject("tracks");
                JSONArray tracks = topTracksObj.getJSONArray("track");

                // iterate through the JSON to extract each object
                for (int i = 0; i < tracks.length(); i++){
                    JSONObject track = tracks.getJSONObject(i);
                    String trackname = track.getString("name");
                    JSONObject artistObj = track.getJSONObject("artist");
                    String artistName = artistObj.getString("name");
                    //trackdata.add(new MovieData(trackname, artistName));
                }
            }
            catch (JSONException e){
                e.printStackTrace();
            }
            //this.activity.setData(trackdata);
        }
    }
}