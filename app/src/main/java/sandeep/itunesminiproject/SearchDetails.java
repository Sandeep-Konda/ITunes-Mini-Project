package sandeep.itunesminiproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import sandeep.itunesminiproject.DTO.Result;

public class SearchDetails extends AppCompatActivity {

    private TextView trackTitle,trackPrice,trackDescription;
    private ImageView art_image_full;
    private int position;
    private ITunesApplication iTunesApplication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_details);
        trackTitle=(TextView)findViewById(R.id.trackTitle);
        trackPrice=(TextView)findViewById(R.id.trackPrice);
        trackDescription=(TextView)findViewById(R.id.trackDescription);
        iTunesApplication=ITunesApplication.getInstance();
        art_image_full=(ImageView)findViewById(R.id.art_image_full);
        position=getIntent().getIntExtra("clickedposition",-1);

        Result result=iTunesApplication.getOutputResult().get(position);
        trackTitle.setText(result.getTrackName());
        trackPrice.setText(result.getCurrency()+" "+result.getTrackPrice());
        trackDescription.setText(result.getTrackExplicitness());
        Picasso.with(this).load(result.getArtworkUrl100()).into(art_image_full);
    }
}
