package com.example.daftarmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    EditText EditText2, EditText3;
    Button btnSignIn;
    TextView btnregister;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText2 = findViewById(R.id.editText2);
        EditText3 = findViewById(R.id.editText3);
        btnSignIn = findViewById(R.id.masuk);
        btnregister = findViewById(R.id.daftar);
        fAuth = FirebaseAuth.getInstance();

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = EditText2.getText().toString().trim();
                String password = EditText3.getText().toString().trim();

                if (TextUtils.isEmpty(email)){
                    EditText2.setError("Email is Required.");
                    return;
                }

                if (TextUtils.isEmpty(password)){
                    EditText3.setError("Password is Required.");
                    return;
                }

                if (password.length() < 6){
                    EditText3.setError("Password Must be More than 6 Characters");
                    return;
                }

                // Authenticate User

                fAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(LoginActivity.this, "Berhasil", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        }else {
                            Toast.makeText(LoginActivity.this, "Error !" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });

        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), RegistationActivity.class));
            }
        });
    }
}