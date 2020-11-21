package au.edu.unsw.infs3634.gamifiedlearning;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class Login extends AppCompatActivity {

    EditText mEmail;
    EditText mPass;
    Button mLogin;
    Button mGoToSignUp;
    FirebaseAuth fAuth;
    ProgressBar mStatus;
    TextView forgotpassword;
    private EditText Email;
    private Button cancel, send;
    EditText send_email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mEmail = findViewById(R.id.etLoginEmail);
        mPass = findViewById(R.id.etLoginPassword);
        mLogin = findViewById(R.id.btLogIn);
        mGoToSignUp = findViewById(R.id.goToSignUp);
        fAuth = FirebaseAuth.getInstance();
        mStatus = findViewById(R.id.loginProgressBar);
        forgotpassword = findViewById(R.id.tv_forgetpass);


        forgotpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        }

        );


        mGoToSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(getBaseContext(), R.anim.shake);
                mGoToSignUp.startAnimation(animation);
                startActivity(new Intent(getApplicationContext(), Register.class));
                finish();
            }
        });


        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(getBaseContext(), R.anim.shake);
                mLogin.startAnimation(animation);
                String email = mEmail.getText().toString().trim();
                String pass = mPass.getText().toString().trim();


                if (TextUtils.isEmpty(email)) {
                    mEmail.setError("Please enter an Email address!");
                }

                if (TextUtils.isEmpty(pass)) {
                    mPass.setError("Please enter a valid Password");
                }
                // password length restriction can go here

                mStatus.setVisibility(View.VISIBLE);
                fAuth = FirebaseAuth.getInstance();
                //try and catch statement if user did not enter password and email;
                try {
                    fAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {

                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(Login.this, "Logged In", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(getApplicationContext(), Register.class));
                            } else {

                                Toast.makeText(Login.this, "The Email / Password is incorrect.", Toast.LENGTH_SHORT).show();

                            }
                        }
                    });

                } catch (Exception e) {
                    System.out.println("yoo this user did not enter the required fields");
                    Toast.makeText(Login.this, "Please enter all the fields.", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    public void openDialog() {
        ForgotPassword forgotPassword = new ForgotPassword();
        forgotPassword.show(getSupportFragmentManager(), "Forgot Password");

    }
}