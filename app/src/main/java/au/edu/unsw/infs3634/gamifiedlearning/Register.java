package au.edu.unsw.infs3634.gamifiedlearning;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Register extends AppCompatActivity {
    public static final String TAG = "TAG";
    EditText mName;
    EditText mEmail;
    EditText mPass;
    EditText mUserName;
    Button mSignUp;
    Button mGoToLogin;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    String userID;
    ProgressBar status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        //was activity main but changed

        mName = findViewById(R.id.etName);
        mEmail = findViewById(R.id.etEmail);
        mPass = findViewById(R.id.etPassword);
        mUserName = findViewById(R.id.etUserName);
        mSignUp = findViewById(R.id.btSignUp);
        mGoToLogin = findViewById(R.id.btGoLogIn);
        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        status = findViewById(R.id.progressBar);

        mGoToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(getBaseContext(),R.anim.shake);
                mGoToLogin.startAnimation(animation);
                startActivity(new Intent(getApplicationContext(),Login.class));
                finish();

            }
        });

        if(fAuth.getCurrentUser() !=null){
            startActivity(new Intent(getApplicationContext(), MainPage.class));
            finish();
            //redirect user to main page
        }


        mSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(getBaseContext(),R.anim.shake);
                mSignUp.startAnimation(animation);

                String email = mEmail.getText().toString().trim();
                String pass = mPass.getText().toString().trim();
                String name = mName.getText().toString();
                String userName = mUserName.getText().toString();



                if (TextUtils.isEmpty(email)) {
                    mEmail.setError("Please enter an Email address!");
                }

                if (TextUtils.isEmpty(pass)) {
                    mPass.setError("Please enter a valid Password!");
                }

                if (TextUtils.isEmpty(userName)) {
                    mUserName.setError("Please enter a Username!");
                }

                // password length restriction can go here

                status.setVisibility(View.VISIBLE);

                fAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            Toast.makeText(Register.this, "Registered", Toast.LENGTH_SHORT).show();

                            // Stores User Data to FireStore
                            userID = fAuth.getCurrentUser().getUid();
                            DocumentReference dR = fStore.collection("users").document(userID);
                            HashMap<String, Object> user = new HashMap<>();
                            user.put("name", name);
                            user.put("email", email);
                            user.put("userName", userName);
                            user.put("score", 0);

                            dR.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Log.d(TAG, "onSuccess: user created" + userID);
                                }
                            });
                            startActivity(new Intent(getApplicationContext(), MainPage.class));
                            //Currently redirects to setting screen to test logout functionality
                        }else{

                            Toast.makeText(Register.this, "Error!", Toast.LENGTH_SHORT).show();
                            status.setVisibility(View.GONE);

                        }
                    }
                });
            }
        });
    }


}