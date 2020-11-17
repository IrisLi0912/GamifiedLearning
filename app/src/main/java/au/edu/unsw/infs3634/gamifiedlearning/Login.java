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
import android.widget.TextView;
import android.widget.Toast;

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
    TextView forgot_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mEmail = findViewById(R.id.etLoginEmail);
        mPass = findViewById(R.id.etLoginPassword);
        mLogin = findViewById(R.id.btLogIn);
        mGoToSignUp = findViewById(R.id.btGoLogIn);
        fAuth = FirebaseAuth.getInstance();
        mStatus = findViewById(R.id.loginProgressBar);
        forgot_password = findViewById(R.id.tv_forgetpass);

        forgot_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               openDialog();
            }
        });



        mLogin.setOnClickListener(new View.OnClickListener(){
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

                mStatus.setVisibility(View.VISIBLE);

                fAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(Login.this, "Logged In", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), Setting.class));
                        } else {

                            Toast.makeText(Login.this, "Error!", Toast.LENGTH_SHORT).show();

                        }
                    }
                });

            }
        });
    }

    public void goToSignUp(View view){
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
        finish();
    }

    public void openDialog(){
        ForgotPassword forgotPassword = new ForgotPassword();
        forgotPassword.show(getSupportFragmentManager(),"Forgot Password");

    }
}