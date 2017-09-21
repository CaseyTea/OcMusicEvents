package edu.orangecoastcollege.cs273.cthastanaphonh.ocmusicevents;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class EventListActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // content has already been set for the ListActivity
       // setContentView(R.layout.activity_event_list);

        // Define a built-in list adapter for this ListActivity
        setListAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, MusicEvent.titles));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {

        // Use the position in the array to look up the titles array
        String title = MusicEvent.titles[position];
        String details = MusicEvent.details[position];


        // Create an intent to go to DetailsActivity with titles and details sent
        Intent detailsIntent = new Intent(this, EventsDetailActivity.class);
        detailsIntent.putExtra("title", title);
        detailsIntent.putExtra("details", details);
        startActivity(detailsIntent);



    }
}
