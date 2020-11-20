package au.edu.unsw.infs3634.gamifiedlearning;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainPage extends AppCompatActivity {
    private static final String TAG = MainPage.class.getSimpleName();
    private TextView textViewDesc;
    private TextView textViewCopyRight;
    private TextView textViewTitle;
    private TextView textViewWelcome;
    private ImageView spaceImage;
    private Button buttonMore;
    private WebView webView;

    String userID;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        textViewDesc = findViewById(R.id.text_view_result);
        textViewTitle = findViewById(R.id.tvImageTitle);
        textViewCopyRight = findViewById(R.id.tvAuthor);
        textViewWelcome = findViewById(R.id.tvWelcomeMsg);
        spaceImage = findViewById(R.id.ivMarsCondition);
        buttonMore = findViewById(R.id.btLearnMore);
        webView = (WebView) findViewById(R.id.webview2);

        //fech and display name through firebase
        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        userID = fAuth.getCurrentUser().getUid();

        DocumentReference dR = fStore.collection("users").document(userID);
        dR.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {
                textViewWelcome.setText("Welcome back, " + value.getString("name"));
            }
        });

        //webview display and scale to correct dimension
        String html = "<iframe src='https://mars.nasa.gov/layout/embed/image/insightweather/' width='380' height='390'  scrolling='no' frameborder='0'></iframe>";
        webView = (WebView) findViewById(R.id.webview2);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadData(html, "text/html", null);


        //button to open more
        buttonMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://apod.nasa.gov/apod/astropix.html");

            }
        });

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.nasa.gov/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        JsonPlaceHolderApi service = retrofit.create(JsonPlaceHolderApi.class);
        Call<NASAImage> NASAImgCall = service.getImage();
        NASAImgCall.enqueue(new Callback<NASAImage>() {
            @Override
            public void onResponse(Call<NASAImage> call, Response<NASAImage> response) {
                if (!response.isSuccessful()) {
                    //The actions if the image have not been updated
                    textViewTitle.setText(" Astronomy Picture of the Day: \n Fairytale NEOWISE");
                    textViewCopyRight.setText("© Stephane Guisard (Los Cielos de America, TWAN)");
                    textViewDesc.setText("Error Code: " + response.code() + " Sorry the new image have not been updated yet. But here is a photo from previous weeks. \n  Comet dust falls through a twilight sky in this dream-like scene, but it's not part of a fairytale movie. Still, Castle Neuschwanstein, nestled in the Bavarian Alps, did inspire Disneyland's Sleeping Beauty Castle. Captured on July 20, the bright streak above the castle towers is likely a Perseid meteor. Though it peaks near mid-August, the annual summer meteor shower is active now. The meteor trail over the fairytale castle can be traced back to the shower's radiant in the heroic constellation Perseus off the top right of the frame. Perseid meteors are produced by dust from periodic Comet Swift-Tuttle. With its own broad dust tail now sweeping through northern skies the celestial apparition above the distant horizon is planet Earth's current darling, Comet NEOWISE. ");
                    spaceImage.setImageResource(R.drawable.fairytale);
                    return;
                }
                NASAImage NASAImg = response.body();
                textViewDesc.setText(NASAImg.getExplanation());
                textViewTitle.setText(" Astronomy Picture of the Day. \n" + NASAImg.getTitle());
                textViewCopyRight.setText("©" + NASAImg.getCopyright());
                //add here to get back description
                Glide.with(spaceImage).load(NASAImg.getUrl()).into(spaceImage);

            }

            @Override
            public void onFailure(Call<NASAImage> call, Throwable t) {
                textViewDesc.setText("gg");
            }
        });

        //initialise and assign variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bnBottomBar);

        //set home selected, later change to set whatever page selected
        bottomNavigationView.setSelectedItemId(R.id.home);

        //Perform ItemSelectListener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.topic:
                        startActivity(new Intent(getApplicationContext(), MainTopicMain.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.profile:
                        startActivity(new Intent(getApplicationContext(), User.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(), MainPage.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.journey:
                        startActivity(new Intent(getApplicationContext(), StartingScreenActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                }
                return false;
            }
        });
    }

    private void gotoUrl(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW, uri));
    }
}