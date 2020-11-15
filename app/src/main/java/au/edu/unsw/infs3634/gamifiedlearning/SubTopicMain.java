package au.edu.unsw.infs3634.gamifiedlearning;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SubTopicMain extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<SubTopic> allSight;
    private ArrayList<SubTopic> adapterList;
    private SubTopicAdapter adapter;

    MainTopicsCategory mainTopicsCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subtopic_recyclerview);

//        Toolbar mToolbar = findViewById(R.id.toolbar2);
//        setSupportActionBar(mToolbar);
//        mToolbar.setTitleTextColor(Color.BLACK);
//        mToolbar.setBackgroundColor(Color.CYAN);

        mainTopicsCategory = (MainTopicsCategory) getIntent().getSerializableExtra("data");


        recyclerView = findViewById(R.id.tv_subtopiclist);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        allSight = SubTopic.getSubTopics();


        adapterList = new ArrayList<>();


        for (int i = 0; i < allSight.size(); i++) {
            if (allSight.get(i).getKey().equals(mainTopicsCategory.getTopicCategory())) {
                adapterList.add(allSight.get(i));

            }
        }


        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new SubTopicAdapter(this, adapterList);
        recyclerView.setAdapter(adapter);
        // redirect to detail page
        adapter.setOnItemClickListener(new SubTopicAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(SubTopicMain.this, SubTopicDetail.class);
                intent.putExtra("data", adapterList.get(position));
                startActivity(intent);
            }
        });
    }
}