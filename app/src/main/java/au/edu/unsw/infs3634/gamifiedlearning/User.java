package au.edu.unsw.infs3634.gamifiedlearning;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class User extends AppCompatActivity {
    Button mLogout;
    TextView mName;
    TextView mUserName;
    TextView mEmail;
    TextView mScore;
    TextView mFirst;
    TextView mSecond;
    TextView mThird;
    TextView mFirstScore;
    TextView mSecondScore;
    TextView mThirdScore;
    ImageView mAvatar;
    String userID;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        mName =findViewById(R.id.tvName);
        mUserName = findViewById(R.id.tvUserName);
        mEmail = findViewById(R.id.tvProfileEmail);
        mScore = findViewById(R.id.tvCoinNumber);
        mAvatar = findViewById(R.id.ivAvatar);
        mFirst = findViewById(R.id.tvFirstUser);
        mSecond = findViewById(R.id.tvSecondUser);
        mThird = findViewById(R.id.tvThirdUser);
        mFirstScore = findViewById(R.id.tvFirstScore);
        mSecondScore = findViewById(R.id.tvSecondScore);
        mThirdScore = findViewById(R.id.tvThirdScore);

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        userID = fAuth.getCurrentUser().getUid();

//        CollectionReference collectionRef = fStore.collection("users");
//        Query query = collectionRef.orderBy("score", Direction.DESCENDING).limit(1);
        DocumentReference dR = fStore.collection("users").document(userID);
        dR.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {
                mName.setText(value.getString("name"));
                mEmail.setText(value.getString("email"));
                mUserName.setText(value.getString("userName"));
                mScore.setText(value.getDouble("score") + " Points");

            }

        });

        CollectionReference Ref = fStore.collection("users");
        Query query = Ref.orderBy("score",Query.Direction.DESCENDING).limit(1);
        query.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        mFirst.setText(document.getString("userName"));
                        mFirstScore.setText(document.getDouble("score").toString());
                    }
                }
            }
        });

        Query query2 = Ref.orderBy("score",Query.Direction.DESCENDING).limit(2);
        query2.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        mSecond.setText(document.getString("userName"));
                        mSecondScore.setText(document.getDouble("score").toString());
                    }
                }
            }
        });

        Query query3 = Ref.orderBy("score",Query.Direction.DESCENDING).limit(3);
        query3.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        mThird.setText(document.getString("userName"));
                        mThirdScore.setText(document.getDouble("score").toString());
                    }
                }
            }
        });


        //initialise and assign variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bnBottomBar);

        //set home selected, later change to set whatever page selected
        bottomNavigationView.setSelectedItemId(R.id.profile);

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

    public void logout(View view){
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(getApplicationContext(),Login.class));
        finish();

    }

    public void goToPasswordReset(View view){
        startActivity(new Intent(getApplicationContext(),Setting.class));
        finish();
    }
}