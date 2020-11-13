package au.edu.unsw.infs3634.gamifiedlearning;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainPage extends AppCompatActivity {
    private static final String TAG = MainPage.class.getSimpleName();
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);


        textViewResult = findViewById(R.id.text_view_result);

        String data = "{ \"copyright\": \"Ignacio Diaz Bobillo\", \"date\": \"2020-11-13\", \"explanation\": \"The Tarantula Nebula, also known as 30 Doradus, is more than a thousand light-years in diameter, a giant star forming region within nearby satellite galaxy the Large Magellanic Cloud. About 180 thousand light-years away, it's the largest, most violent star forming region known in the whole Local Group of galaxies. The cosmic arachnid sprawls across the top of this spectacular view, composed with narrowband filter data centered on emission from ionized hydrogen and oxygen atoms. Within the Tarantula (NGC 2070), intense radiation, stellar winds and supernova shocks from the central young cluster of massive stars, cataloged as R136, energize the nebular glow and shape the spidery filaments. Around the Tarantula are other star forming regions with young star clusters, filaments, and blown-out bubble-shaped clouds. In fact, the frame includes the site of the closest supernova in modern times, SN 1987A, right of center. The rich field of view spans about 2 degrees or 4 full moons, in the southern constellation Dorado. But were the Tarantula Nebula closer, say 1,500 light-years distant like the local star forming Orion Nebula, it would take up half the sky.\", \"hdurl\": \"https://apod.nasa.gov/apod/image/2011/Tarantula_HOO_final_2_2048.jpg\", \"media_type\": \"image\", \"service_version\": \"v1\", \"title\": \"The Tarantula Zone\", \"url\": \"https://apod.nasa.gov/apod/image/2011/Tarantula_HOO_final_2_1024.jpg\" }";
        Gson gson = new Gson();
        NASAImage joke = gson.fromJson(data,NASAImage.class);
        Log.d(TAG, joke.getUrl());





//        Retrofit retrofit = new Retrofit.Builder()
////                .baseUrl("https://api.nasa.gov/")
//                .baseUrl("https://jsonplaceholder.typicode.com/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);
//        Call<List<Post>> call = jsonPlaceHolderApi.getPosts();
//        call.enqueue(new Callback<List<Post>>() {
//            @Override
//            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
//                if (!response.isSuccessful()) {
//                    textViewResult.setText("Code: " + response.code());
//                    return;
//                }
//                List<Post> posts = response.body();
//                for (Post post : posts) {
//                    String content = "";
//                    content += "ID: " + post.getId() + "\n";
//                    content += "User ID: " + post.getUserId() + "\n";
//                    content += "Title: " + post.getTitle() + "\n";
//                    content += "Text: " + post.getText() + "\n\n";
//                    textViewResult.append(content);
//                }
//            }
//            @Override
//            public void onFailure(Call<List<Post>> call, Throwable t) {
//                textViewResult.setText("it failed" + t.getMessage());
//            }
//        });


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