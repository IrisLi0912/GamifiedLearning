package au.edu.unsw.infs3634.gamifiedlearning;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainPage extends AppCompatActivity {
    private static final String TAG = MainPage.class.getSimpleName();
    private TextView textViewResult;
    private ImageView spaceImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        spaceImage = findViewById(R.id.ivMarsCondition);


        textViewResult = findViewById(R.id.text_view_result);
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
                    textViewResult.setText("Code" + response.code() + " Sorry there are no space picture of the day yea i can not believe this as well");
                    return;
                }
                NASAImage NASAImg = response.body();
                textViewResult.setText(NASAImg.getUrl());
                //add here to get back description
                Glide.with(spaceImage).load(NASAImg.getUrl()).into(spaceImage);

            }

            @Override
            public void onFailure(Call<NASAImage> call, Throwable t) {
                textViewResult.setText("gg");

            }
        });


        //initialise and assign variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bnSetting);

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
}