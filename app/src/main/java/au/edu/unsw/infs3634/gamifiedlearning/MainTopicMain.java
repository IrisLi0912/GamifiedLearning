package au.edu.unsw.infs3634.gamifiedlearning;

        import androidx.annotation.NonNull;
        import androidx.appcompat.app.AppCompatActivity;
        import androidx.recyclerview.widget.GridLayoutManager;
        import androidx.recyclerview.widget.RecyclerView;

        import android.content.Intent;
        import android.os.Bundle;
        import android.os.Parcelable;
        import android.view.MenuItem;

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
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        allTopic = MainTopicsCategory.getMainTopicsCategory();
        adapterList = new ArrayList<>();
        adapterList.addAll(allTopic);
        adapter = new MainTopicAdapter(this, adapterList);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new MainTopicAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(MainTopicMain.this, SubTopic.class);
                intent.putExtra("data", (Parcelable) adapterList.get(position));
                startActivity(intent);
            }
        });


        //initialise and assign variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bnUser);

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
                    case R.id.about:
                        startActivity(new Intent(getApplicationContext(), User.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(), MainPage.class));
                        overridePendingTransition(0, 0);
                        return true;

                }
                return false;
            }
        });

    }
}
