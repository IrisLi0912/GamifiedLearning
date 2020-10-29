package au.edu.unsw.infs3634.gamifiedlearning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {
    public static final String INTENT_MESSAGE = "au.edu.unsw.infs3634.covidtracker.intent_message";
    private TextView mPlaceName;
    private ImageView mPicture;
    private ImageView mPicture1;
    private ImageView mPicture2;
    private ImageView mPicture3;
    private TextView tvScoreRating;
    private TextView mDetail;
    private ImageView mSearch;
    private ImageView mRush;
    private TextView mReviewPopulation;
    private TextView mAddress;
    private TextView mDuration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        mPlaceName = findViewById(R.id.tvPlace);
        mPicture = findViewById(R.id.ivPicture);
        mPicture1 = findViewById(R.id.ivPicture1);
        mPicture2 = findViewById(R.id.ivPicture2);
        mPicture3 = findViewById(R.id.ivPicture3);
        mAddress = findViewById(R.id.tvAddress);
        tvScoreRating = findViewById(R.id.tvUserScore);
        mDetail = findViewById(R.id.tvDetail);
        mSearch = findViewById(R.id.ivSearch);
        mRush = findViewById(R.id.ivRush);
        mReviewPopulation = findViewById(R.id.tvReviewPopulation);
        mDuration = findViewById(R.id.tvDuration);

        Intent intent = getIntent();

        String titleMessage = intent.getStringExtra(INTENT_MESSAGE);
        ArrayList<Places> placeReference = Places.getPlaces();
        for (final Places places : placeReference) {
            if (places.getPlacesName().equals(titleMessage)) {
                DecimalFormat df = new DecimalFormat("#,###,###,###");
                setTitle(places.getPlacesName());
                mPlaceName.setText(places.getPlacesName());
                mDetail.setText(places.getPlaceDetail());
                mReviewPopulation.setText("(From " + df.format(places.getReviewPopulation()) + " users)");
                mPicture.setImageResource(places.getPlacePicture());
                mPicture1.setImageResource(places.getPlacePicture1());
                mPicture2.setImageResource(places.getPlacePicture2());
                mPicture3.setImageResource(places.getPlacePicture3());
                mAddress.setText(places.getPlaceAddress());
                mDuration.setText("Suggested duration: " + places.getPlaceDuration() + " hours");

                //convert int to double
                double temp;
                temp = Double.parseDouble(df.format(places.getPlaceScore())) / 10;
                tvScoreRating.setText(Double.toString(temp));

                mSearch.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        searchPlaces(places.getPlacesName());
                    }
                });
                mRush.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        rushPlaces(places.getPlacesName());
                    }
                });
                mAddress.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        rushPlaces(places.getPlacesName());
                    }
                });
            }
        }
    }

    //a method to open the browser to search
    private void searchPlaces(String destination) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/search?q= " + destination));
        startActivity(intent);
    }

    //a method to open google map
    private void rushPlaces(String destination) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=" + destination));
        intent.setPackage("com.google.android.apps.maps");
        startActivity(intent);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}