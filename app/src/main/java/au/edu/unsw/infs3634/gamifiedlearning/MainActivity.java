package au.edu.unsw.infs3634.gamifiedlearning;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
<<<<<<< Updated upstream
import android.view.View;
import android.widget.SearchView;
=======
import android.widget.Button;
import android.widget.EditText;
>>>>>>> Stashed changes

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerViewAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
<<<<<<< Updated upstream
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.rvList);
        mRecyclerView.setHasFixedSize(true);
        RecyclerViewAdapter.RecyclerViewClickListener listener = new RecyclerViewAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View view, String placesName) {
                launchDetailActivity(placesName);
            }
        };
        mAdapter = new RecyclerViewAdapter(Places.getPlaces(), listener);
        mRecyclerView.setAdapter(mAdapter);
=======
        setContentView(R.layout.activity_login);
        emailIn = findViewById(R.id.etEmail);
        passwordIn = findViewById(R.id.tv_password);
        login = findViewById(R.id.btSignUp);
        signUp = findViewById(R.id.btGoToLogIn);
//        mRecyclerView = findViewById(R.id.rvList);
//        mRecyclerView.setHasFixedSize(true);
//        RecyclerViewAdapter.RecyclerViewClickListener listener = new RecyclerViewAdapter.RecyclerViewClickListener() {
//            @Override
//            public void onClick(View view, String placesName) {
//                launchDetailActivity(placesName);
//            }
//        };
//        mAdapter = new RecyclerViewAdapter(Places.getPlaces(), listener);
//        mRecyclerView.setAdapter(mAdapter);
>>>>>>> Stashed changes
    }

    private void launchDetailActivity(String message) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(DetailActivity.INTENT_MESSAGE, message);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        SearchView searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                mAdapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                mAdapter.getFilter().filter(newText);
                return false;
            }
        });
        return true;
    }

    //select the filter
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.sort_new:
                mAdapter.sort(RecyclerViewAdapter.SORT_REVIEW_NUMBER);
                return true;
            case R.id.sort_total:
                mAdapter.sort(RecyclerViewAdapter.SORT_SCORE);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}