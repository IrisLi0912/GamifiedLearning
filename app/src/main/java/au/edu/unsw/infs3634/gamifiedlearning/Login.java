package au.edu.unsw.infs3634.gamifiedlearning;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import android.app.AlertDialog;


public class Login extends AppCompatActivity {

    EditText mEmail;
    EditText mPass;
    Button mLogin;
    Button mGoToSignUp;
    FirebaseAuth fAuth;
    ProgressBar mStatus;
    TextView forgot_password;
    private EditText Email;
    private Button cancel, send;

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
        forgot_password = findViewById(R.id.tv_forgetpass);

    }


            public void MyClick (View view) {
                Email = findViewById(R.id.tv_email);
                fAuth = FirebaseAuth.getInstance();
                // build a new dialog for forgot password.
                AlertDialog.Builder builder = new AlertDialog.Builder(Login.this);
                // modify the dialog
                //set two buttons
                View mview = getLayoutInflater().inflate(R.layout.activity_forgot_password,null);
                cancel = mview.findViewById(R.id.bt_cancel);
                send = mview.findViewById(R.id.bt_send);
                builder.setView(mview);

                AlertDialog alertDialog = builder.create();
                alertDialog.setCanceledOnTouchOutside(false);
                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Animation animation = AnimationUtils.loadAnimation(getBaseContext(),R.anim.shake);
                        cancel.startAnimation(animation);
                        alertDialog.dismiss();
                    }
                });

                send.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Animation animation = AnimationUtils.loadAnimation(getBaseContext(),R.anim.shake);
                        send.startAnimation(animation);

                        String email = Email.getText().toString().trim();

                        // email textfiled can not be null, otherwise popup relate message
                        if (email.equals("")) {
                            Toast.makeText(view.getContext(), "All fileds are required", Toast.LENGTH_SHORT).show();
                        } else {
                            fAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    // if the email was correct,send a link to users email to reset password
                                    //the dialog closed, user will be back to login page
                                    if (task.isSuccessful()) {
                                        Toast.makeText(view.getContext(), "Please check your email", Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(view.getContext(), Login.class));
                                    } else {
                                        //otherwise an error exception catched
                                        String error = task.getException().getMessage();
                                        Toast.makeText(view.getContext(), error, Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                        }

                    }
                });
                alertDialog.show();





        mGoToSignUp.setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick(View v){
               Animation animation = AnimationUtils.loadAnimation(getBaseContext(),R.anim.shake);
               mGoToSignUp.startAnimation(animation);
               startActivity(new Intent(getApplicationContext(), Register.class));
               finish();
           }
        });


        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(getBaseContext(),R.anim.shake);
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

                //try and catch statement if user did not enter password and email
                try{fAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {

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

                }catch (Exception e){
                    System.out.println("yoo this user did not enter the required fields");
                    Toast.makeText(Login.this, "Please enter all the fields.", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }


}