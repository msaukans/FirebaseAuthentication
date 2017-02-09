package com.sample.maris.firebaseauthentication;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
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

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button registerBtn;
    private EditText edEmail,edPass;
    private TextView tv1;
    private ProgressDialog bar;

    private FirebaseAuth fire;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bar = new ProgressDialog(this);

        fire = FirebaseAuth.getInstance();

        if(fire.getCurrentUser() !=null){
            finish();
            startActivity(new Intent(MainActivity.this,ProfileActivity.class));
        }

        registerBtn = (Button) findViewById(R.id.registerBtn);
        edEmail = (EditText) findViewById(R.id.editTextEmail);
        edPass = (EditText) findViewById(R.id.editTextPass);

        tv1 = (TextView) findViewById(R.id.tv1);

        registerBtn.setOnClickListener(this);
        tv1.setOnClickListener(this);
    }

    private void registerUser(){
        String email = edEmail.getText().toString().trim();
        String pass = edPass.getText().toString().trim();

        if(TextUtils.isEmpty(email)){
            //email is empty
            Toast.makeText(this,"Please enter email", Toast.LENGTH_SHORT).show();
            return;
        }

        if(TextUtils.isEmpty(pass)){
            Toast.makeText(this,"Please enter pass", Toast.LENGTH_SHORT).show();
            return;
        }

        bar.setMessage("Registering user...");
        bar.show();


        fire.createUserWithEmailAndPassword(email,pass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            Toast.makeText(MainActivity.this, "Registered user", Toast.LENGTH_SHORT);
                        }
                        else{
                            Toast.makeText(MainActivity.this, "Fail register",Toast.LENGTH_SHORT);
                        }
                    }
                }
        );


    }

    @Override
    public void onClick(View view) {
        if(registerBtn == view){
            registerUser();
        }

        if(view == tv1){
            startActivity(new Intent(MainActivity.this,LoginActivity.class));
        }
    }
}

