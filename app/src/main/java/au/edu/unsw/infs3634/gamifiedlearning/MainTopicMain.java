package au.edu.unsw.infs3634.gamifiedlearning;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

// Card view five Main topics main activity page

public class MainTopicMain extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<MainTopicsCategory> allTopic;
    private ArrayList<MainTopicsCategory> adapterList;
    private MainTopicAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic_recyclerview);

        recyclerView = findViewById(R.id.tv_topliclist);

        //display the topic category into a grid layout with card view
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        allTopic = MainTopicsCategory.getMainTopicsCategory();
        adapterList = new ArrayList<>();
        adapterList.addAll(allTopic);


        adapter = new MainTopicAdapter(this, adapterList);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new MainTopicAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {

                //define different type of topic category
                // launch to different activity with different layout
                if(adapterList.get(position).getType() == 1){
                    Intent intent = new Intent(MainTopicMain.this, MissionWebActivity.class);
                    intent.putExtra("data",  adapterList.get(position));
                    startActivity(intent);
                }else if (adapterList.get(position).getType() == 2){
                    Intent intent = new Intent(MainTopicMain.this, FunFactsMain.class);
                    intent.putExtra("data",  adapterList.get(position));
                    startActivity(intent);
                }else {
                    Intent intent = new Intent(MainTopicMain.this, SubTopicMain.class);
                    intent.putExtra("data",  adapterList.get(position));
                    startActivity(intent);
                }

            }
        });


        //initialise and assign variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bnBottomBar);

        //set home selected, later change to set whatever page selected
        bottomNavigationView.setSelectedItemId(R.id.topic);

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
