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
 */

public class HttpRequestHelper extends Activity {

    // create string for URL's
    private static final String url1 = "";
    private static final String url2 = "";

    // downloads server then converts JSON to string object
    protected static synchronized String downloadFromServer(String... params) {

        // declare return string result
        String result = "";

        // get chosen title from argument
        String inputTitle = params[0];

        // complete string for URL
        String completeUrl = url1 + inputTitle + url2;

        // turn string into URL
        URL url = null;

        try {
            url = new URL(completeUrl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        // make the connection
        HttpURLConnection connection;
        if (url != null) {
            try {
                connection = (HttpURLConnection) url.openConnection();

                // open connection, set request method
                connection.setRequestMethod("GET");

                // get response code
                Integer responseCode = connection.getResponseCode();


                // if 200-300 read input stream
                if (200 <= responseCode && responseCode <= 299) {
                    BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    String line;
                    while ((line = br.readLine()) != null) {
                        // places JSON in variable result
                        result = result + line;
                    }
                }
                // else, read error stream
                else {
                    BufferedReader br = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                    // communicate correct error “server is not online” oid.
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            // return result
            return result;
        }
        return result;
    }

}
