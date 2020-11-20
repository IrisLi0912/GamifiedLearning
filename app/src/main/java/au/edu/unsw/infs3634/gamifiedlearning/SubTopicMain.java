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
    private ArrayList<SubTopic> allTopic;
    private ArrayList<SubTopic> adapterList;
    private SubTopicAdapter adapter;

    MainTopicsCategory mainTopicsCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subtopic_recyclerview);

        //intent message
        mainTopicsCategory = (MainTopicsCategory) getIntent().getSerializableExtra("data");

        recyclerView = findViewById(R.id.tv_subtopiclist);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        allTopic = SubTopic.getSubTopics();

        adapterList = new ArrayList<>();

        //put all subtopic into a arraylist
        //using the key: topic category name to classfile all the subtopic into correct topic category
        for (int i = 0; i < allTopic.size(); i++) {
            if (allTopic.get(i).getKey().equals(mainTopicsCategory.getTopicCategory())) {
                adapterList.add(allTopic.get(i));

            }
        }

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new SubTopicAdapter(this, adapterList);
        recyclerView.setAdapter(adapter);
        // launch to subtopic detail activity
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