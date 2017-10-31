package edu.orangecoastcollege.cs273.cthastanaphonh.ocmusicevents;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class EventsDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events_detail);

        // Get the data out of the intent
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        String details = intent.getStringExtra("details");

        // Create reference to the text views
        TextView titleTextView = (TextView) findViewById(R.id.eventTitleTextView);
        TextView detailsTextView = (TextView) findViewById(R.id.eventDetailTextView);
        ImageView eventImageView = (ImageView) findViewById(R.id.eventImageView);

        // set the text of the text views
        titleTextView.setText(title);
        detailsTextView.setText(details);

        // Use the Asset Manager to retrieve a file (image)
        AssetManager am = getAssets();
        String imageFileName = title.replace(" ", "") + ".jpeg";
        // Use the Asset Manager to open a stream to the file name
        try {
            InputStream stream = am.open(imageFileName);
            Drawable image = Drawable.createFromStream(stream, title);
            eventImageView.setImageDrawable(image);
        } catch (IOException e) {
            Log.e("OC Music Events", "Error loading image: " + imageFileName, e);
        }
    }

    /**
     * This function returns user back to the list, by calling finish() to terminate the
     * eventDetailActivity page
     * @param v the current view that is loaded
     */
    protected void goBackToList(View v)
    {
        // Terminates the current activity (terminate the details activity
        finish();
    }
}
