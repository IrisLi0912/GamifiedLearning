package au.edu.unsw.infs3634.gamifiedlearning;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

public class Badges extends AppCompatActivity {
    String userID;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    private ImageView imageBadge0;
    private ImageView imageBadge1;
    private ImageView imageBadge2;
    private ImageView imageBadge3;
    private ImageView imageBadge4;
    private ImageView imageBadge5;
    private TextView textBadge0;
    private TextView textBadge1;
    private TextView textBadge2;
    private TextView textBadge3;
    private TextView textBadge4;
    private TextView textBadge5;
    private int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_badges);

        imageBadge0 = findViewById(R.id.ivBadge0);
        imageBadge1 = findViewById(R.id.ivBadge1);
        imageBadge2 = findViewById(R.id.ivBadge2);
        imageBadge3 = findViewById(R.id.ivBadge3);
        imageBadge4 = findViewById(R.id.ivBadge4);
        imageBadge5 = findViewById(R.id.ivBadge5);
        textBadge0 = findViewById(R.id.tvBadge0);
        textBadge1 = findViewById(R.id.tvBadge1);
        textBadge2 = findViewById(R.id.tvBadge2);
        textBadge3 = findViewById(R.id.tvBadge3);
        textBadge4 = findViewById(R.id.tvBadge4);
        textBadge5 = findViewById(R.id.tvBadge5);

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        userID = fAuth.getCurrentUser().getUid();

        DocumentReference dR = fStore.collection("users").document(userID);
        dR.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {
                textBadge0.setText(value.getDouble("score") + " Points");
                double score = value.getDouble("score");

                //show avliable chapters base on user score
                if (score < 4) {
                    imageBadge0.setImageResource(R.drawable.hidden);
                    imageBadge1.setImageResource(R.drawable.hidden);
                    imageBadge2.setImageResource(R.drawable.hidden);
                    imageBadge3.setImageResource(R.drawable.hidden);
                    imageBadge4.setImageResource(R.drawable.hidden);
                    imageBadge5.setImageResource(R.drawable.hidden);

                } else if (score >= 5.0 && score < 10.0) {
                    imageBadge0.setImageResource(R.drawable.hidden);
                    imageBadge1.setImageResource(R.drawable.hidden);
                    imageBadge2.setImageResource(R.drawable.hidden);
                    imageBadge3.setImageResource(R.drawable.hidden);
                    imageBadge4.setImageResource(R.drawable.hidden);
                    imageBadge5.setImageResource(R.drawable.hidden);
                } else if (score >= 10.0 && score < 15.0) {
                    imageBadge0.setImageResource(R.drawable.hidden);
                    imageBadge1.setImageResource(R.drawable.hidden);
                    imageBadge2.setImageResource(R.drawable.hidden);
                    imageBadge3.setImageResource(R.drawable.hidden);
                    imageBadge4.setImageResource(R.drawable.hidden);
                    imageBadge5.setImageResource(R.drawable.hidden);
                } else if (score >= 15.0 && score < 20.0) {
                    imageBadge0.setImageResource(R.drawable.hidden);
                    imageBadge1.setImageResource(R.drawable.hidden);
                    imageBadge2.setImageResource(R.drawable.hidden);
                    imageBadge3.setImageResource(R.drawable.hidden);
                    imageBadge4.setImageResource(R.drawable.hidden);
                    imageBadge5.setImageResource(R.drawable.hidden);
                } else if (score >= 20.0 && score < 25) {
                    imageBadge0.setImageResource(R.drawable.hidden);
                    imageBadge1.setImageResource(R.drawable.hidden);
                    imageBadge2.setImageResource(R.drawable.hidden);
                    imageBadge3.setImageResource(R.drawable.hidden);
                    imageBadge4.setImageResource(R.drawable.hidden);
                    imageBadge5.setImageResource(R.drawable.hidden);
                } else if (score >= 25.0 && score < 100000.0) {
                    imageBadge0.setImageResource(R.drawable.hidden);
                    imageBadge1.setImageResource(R.drawable.hidden);
                    imageBadge2.setImageResource(R.drawable.hidden);
                    imageBadge3.setImageResource(R.drawable.hidden);
                    imageBadge4.setImageResource(R.drawable.hidden);
                    imageBadge5.setImageResource(R.drawable.hidden);
                } else {


                }

            }
        });


    }
}