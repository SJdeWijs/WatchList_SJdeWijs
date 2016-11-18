package nas.watchlist_sjdewijs;

import android.app.Activity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Sander de Wijs on 14-11-2016.
 *
 */

public class HttpRequestHelper extends Activity {

    // create string for URL's
    private static final String url1 = "http://www.omdbapi.com/?s=";
    private static final String url2 = "";

    // downloads server then converts JSON to string object
    protected static synchronized String downloadFromServer(String... params) {

        // declare return string result
        String result = "";

        // get first element in params array, which is the given title
        String inputTitle = params[0];

        // complete string for URL
        String completeUrl = url1 + inputTitle + url2;
        URL url = null;

        try {
            url = new URL(completeUrl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        HttpURLConnection connection;
        if (url != null) {
            try {
                connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                Integer responseCode = connection.getResponseCode();

                if (200 <= responseCode && responseCode <= 299) {
                    BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    String line;
                    while ((line = br.readLine()) != null) {
                        result = result + line;
                    }
                }

                else {
                    BufferedReader br = new BufferedReader(new InputStreamReader(connection.getErrorStream()));

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return result;
        }
        return result;
    }
}
