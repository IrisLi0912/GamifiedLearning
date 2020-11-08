package au.edu.unsw.infs3634.gamifiedlearning;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Parcelable;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SubTopicMain extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<SubTopic> allSight;
    private ArrayList<SubTopic> adapterList;
    private SubTopicAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subtopic_recyclerview);

//        Toolbar mToolbar = findViewById(R.id.toolbar2);
//        setSupportActionBar(mToolbar);
//        mToolbar.setTitleTextColor(Color.BLACK);
//        mToolbar.setBackgroundColor(Color.CYAN);


        recyclerView = findViewById(R.id.tv_subtopiclist);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        allSight = SubTopic.getSubTopics();
        adapterList = new ArrayList<>();
        adapterList.addAll(allSight);

        //modify the whole recycler view is clickable
        adapter = new SubTopicAdapter(this, adapterList);
        recyclerView.setAdapter(adapter);
        // redirect to detail page
        adapter.setOnItemClickListener(new SubTopicAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(SubTopicMain.this, SubTopicDetail.class);
                intent.putExtra("data", (Parcelable) adapterList.get(position));
                startActivity(intent);
            }
        });
    }
}