package au.edu.unsw.infs3634.gamifiedlearning;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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


    }
}
