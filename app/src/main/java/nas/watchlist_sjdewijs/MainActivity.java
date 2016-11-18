package nas.watchlist_sjdewijs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText title_input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void enteredTitle(View view){
        // create variable of edittext with id title_input
        EditText titleEditText = (EditText) findViewById(R.id.title_input);

        if (titleEditText.length() != 0) {
            // convert entered words to separate strings
            String word = titleEditText.getText().toString();

            // create intend to pass entered data to final activity
            Intent titleActivityIntent = new Intent(this, MovieAsyncTask.class);
            startActivity(titleActivityIntent);
            //finish();
            }

        // show error message when no title is entered
        else {
            titleEditText.setError("Please enter a title");
        }
        // replace entered word with nothing, so textbox is emptied
        titleEditText.setText("");
    }


    // switch from current activity to saved watchlist.xml (TracksAdapter activity)
    public void viewWatchList(View view) {
        Intent showViewWatchList = new Intent(this, MoviesAdapter.class);

        startActivity(showViewWatchList);
        // finish();
    }

}
/*    Oncreate {tag_input = (EditText)
            Tracks_listview = (ListView)

            Public void get_data (View view){
// get user input to complete url
        String mytag = tag_input.getText().toString();

// make AsyncTask get the data
        (eerst class implementeren)
        TagAsyncTask asyncTask = new TagAsyncTask(); // andere naam geven dan tag.
        asyncTask.execute(myTag);

    }*/
