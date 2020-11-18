package au.edu.unsw.infs3634.gamifiedlearning;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPassword extends AppCompatDialogFragment {
     private EditText Email;
     FirebaseAuth firebaseAuth;


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.activity_forgot_password,null);


        Email = view.findViewById(R.id.tv_email);
        firebaseAuth = FirebaseAuth.getInstance();


        builder.setView(view);
        builder.setTitle("Reset Password ");
        builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.setPositiveButton("Send", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                String email = Email.getText().toString().trim();

                if (email.equals("")) {
                    Toast.makeText(view.getContext(),"All fileds are required", Toast.LENGTH_SHORT).show();

                }else{
                    firebaseAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()){
                                Toast.makeText(view.getContext(),"Please check your email", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(view.getContext(),Login.class));

                            }else{
                               String error = task.getException().getMessage();
                               Toast.makeText(view.getContext(),error,Toast.LENGTH_SHORT).show();
                            }

                        }
                    });

                }

            }
        });


        return builder.create();
    }
}
