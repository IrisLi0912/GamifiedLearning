package au.edu.unsw.infs3634.gamifiedlearning;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class Setting extends AppCompatActivity {
    private FirebaseAuth fAuth;
    private TextView currentpass;
    private TextView newpass;
    private TextView confirmpass;
    private Button changepass;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        fAuth = FirebaseAuth.getInstance();
        currentpass = findViewById(R.id.tv_current_password);
        newpass = findViewById(R.id.tv_new_password);
        confirmpass = findViewById(R.id.tv_confirm_password);
        changepass = findViewById(R.id.bt_change_password);

        changepass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changePassword();
            }

        });

    }

    public void changePassword() {
        if (currentpass != null && newpass != null && confirmpass != null) {

            if (newpass.toString().equals(confirmpass.toString())) {


                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                if (user != null && user.getEmail() != null) {

                    AuthCredential credential = EmailAuthProvider.getCredential(user.getEmail(), currentpass.toString());
                    user.reauthenticate(credential).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(Setting.this, "Re-Authentication success. ", Toast.LENGTH_SHORT).show();

                                user.updatePassword(newpass.toString())
                                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {
                                                if (task.isSuccessful()) {
                                                    Toast.makeText(Setting.this, "Password changed successfully. ", Toast.LENGTH_SHORT).show();
                                                    fAuth.signOut();
                                                    startActivity(new Intent(getApplicationContext(), Login.class));
                                                    finish();


                                                }
                                            }
                                        });
                            } else {
                                Toast.makeText(Setting.this, "Re-Authentication failed. ", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });


                } else {
                    startActivity(new Intent(this, Login.class));
                    finish();

                }


            } else {
                Toast.makeText(Setting.this, "Password mismatching.", Toast.LENGTH_SHORT).show();

            }


        } else {
            Toast.makeText(Setting.this, "Please enter all the fields.", Toast.LENGTH_SHORT).show();


        }



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

    public void logout(View view) {
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(getApplicationContext(), Login.class));
        finish();

    }

}
