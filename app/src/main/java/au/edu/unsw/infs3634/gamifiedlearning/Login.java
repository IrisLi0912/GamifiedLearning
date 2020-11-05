package au.edu.unsw.infs3634.gamifiedlearning;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {

    EditText mEmail;
    EditText mPass;
    Button mLogin;
    Button mGoToSignUp;
    FirebaseAuth fAuth;
    ProgressBar status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mEmail = findViewById(R.id.etLoginEmail);
        mPass = findViewById(R.id.etLoginPassword);
        mLogin = findViewById(R.id.btLogIn);
        mGoToSignUp = findViewById(R.id.btGoLogIn);
    }
}