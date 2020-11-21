//package au.edu.unsw.infs3634.gamifiedlearning;
//
//import android.app.AlertDialog;
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.Toast;
//
//import androidx.annotation.NonNull;
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.google.android.gms.tasks.OnCompleteListener;
//import com.google.android.gms.tasks.Task;
//import com.google.firebase.auth.FirebaseAuth;
//
//
//public class ForgotPassword extends AppCompatActivity {
//    FirebaseAuth firebaseAuth;
//    private EditText Email;
//    private Button cancel, send;
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_login);
//
//        Email = findViewById(R.id.tv_email);
//        firebaseAuth = FirebaseAuth.getInstance();
//
//
//    }
//
//    public void MyClick(View view) {
//        // build a new dialog for forgot password.
//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        // modify the dialog
//        //set two buttons
//        View mview = getLayoutInflater().inflate(R.layout.activity_forgot_password, null);
//        cancel = mview.findViewById(R.id.bt_cancel);
//        send = mview.findViewById(R.id.bt_send);
//        builder.setView(mview);
//        AlertDialog alertDialog = builder.create();
//
//        alertDialog.setCanceledOnTouchOutside(false);
//        cancel.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                alertDialog.dismiss();
//            }
//        });
//
//        send.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String email = Email.getText().toString().trim();
//
//                // email textfiled can not be null, otherwise popup relate message
//                if (email.equals("")) {
//                    Toast.makeText(view.getContext(), "All fileds are required", Toast.LENGTH_SHORT).show();
//                } else {
//                    firebaseAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
//                        @Override
//                        public void onComplete(@NonNull Task<Void> task) {
//                            // if the email was correct,send a link to users email to reset password
//                            //the dialog closed, user will be back to login page
//                            if (task.isSuccessful()) {
//                                Toast.makeText(view.getContext(), "Please check your email", Toast.LENGTH_SHORT).show();
//                                startActivity(new Intent(view.getContext(), Login.class));
//                            } else {
//                                //otherwise an error exception catched
//                                String error = task.getException().getMessage();
//                                Toast.makeText(view.getContext(), error, Toast.LENGTH_SHORT).show();
//                            }
//                        }
//                    });
//                }
//
//            }
//        });
//        alertDialog.show();
//    }
//}
//
//
//
//
//
//
//
