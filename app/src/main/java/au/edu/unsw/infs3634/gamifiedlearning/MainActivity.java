package au.edu.unsw.infs3634.gamifiedlearning;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    EditText mName;
    EditText mEmail;
    EditText mPass;
    Button mSignUp;
    Button mGoToLogin;
    FirebaseAuth fAuth;
    ProgressBar status;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        //was activity main but changed

        mName = findViewById(R.id.etName);
        mEmail = findViewById(R.id.etEmail);
        mPass = findViewById(R.id.etPassword);
        mSignUp = findViewById(R.id.btSignUp);
        mGoToLogin = findViewById(R.id.btGoLogIn);

        fAuth = FirebaseAuth.getInstance();
        status = findViewById(R.id.progressBar);

        if(fAuth.getCurrentUser() !=null){
            startActivity(new Intent(getApplicationContext(), Setting.class));
            finish();
            //Currently redirects to setting screen to test logout functionality
        }

        mSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = mEmail.getText().toString().trim();
                String pass = mPass.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {
                    mEmail.setError("Please enter an Email address!");
                }

                if (TextUtils.isEmpty(pass)) {
                    mPass.setError("Please enter a valid Password");
                }
                // password length restriction can go here

                status.setVisibility(View.VISIBLE);

                fAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            Toast.makeText(MainActivity.this, "Registered", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), Setting.class));
                            //Currently redirects to setting screen to test logout functionality
                        }else{

                            Toast.makeText(MainActivity.this, "Error!", Toast.LENGTH_SHORT).show();

                        }
                    }
                });
            }

        });

    }

    public void goToLogin(View view){
        startActivity(new Intent(getApplicationContext(),Login.class));
        finish();
    }
}