package au.edu.unsw.infs3634.gamifiedlearning;

        import androidx.appcompat.app.AppCompatActivity;
        import androidx.recyclerview.widget.LinearLayoutManager;
        import androidx.recyclerview.widget.RecyclerView;

        import android.content.Intent;
        import android.os.Bundle;
        import android.os.Parcelable;

        import java.util.ArrayList;

// Card view five Main topics main activity page

public class TopicMain extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<MainTopicsCategory> allTopic;
    private ArrayList<MainTopicsCategory> adapterList;
    private TopicAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic_main);


        recyclerView = findViewById(R.id.tv_topliclist);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        allTopic = MainTopicsCategory.getMainTopicsCategory();
        adapterList = new ArrayList<>();
        adapterList.addAll(allTopic);

        adapter = new TopicAdapter(this, adapterList);
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new TopicAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(TopicMain.this,SubTopic.class);
                intent.putExtra("data", (Parcelable) adapterList.get(position));
                startActivity(intent);
            }
        });
    }


}
