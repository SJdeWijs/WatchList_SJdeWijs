package nas.watchlist_sjdewijs;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ListView;

/**
 * Created by Sander de Wijs on 14-11-2016.
 */

public class SavedWatchList extends Activity {

    private ListView tracks_listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.saved_watchlist);
    }

    // SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
    // SharedPreferences.Editor editor = pref.edit();

}