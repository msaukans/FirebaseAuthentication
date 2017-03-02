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

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private Button loginBtn;
    private EditText email,pass;
    private TextView tv1;

    private ProgressDialog bar;
    private FirebaseAuth fire;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        fire = FirebaseAuth.getInstance();
        if(fire.getCurrentUser() != null){

        }

        loginBtn = (Button) findViewById(R.id.loginBtn);

        email = (EditText) findViewById(R.id.editTextEmail);
        pass = (EditText) findViewById(R.id.editTextPass);

        tv1 = (TextView) findViewById(R.id.tv1);

        loginBtn.setOnClickListener(this);
        tv1.setOnClickListener(this);

        bar = new ProgressDialog(this);



    }

    @Override
    public void onClick(View v) {
        if(v == loginBtn){
            userLogin();
        }

        if(v == tv1){

            startActivity(new Intent(LoginActivity.this, MainActivity.class));
        }
    }

    public void userLogin(){
        String em = email.getText().toString().trim();
        String p = pass.getText().toString().trim();

        if(TextUtils.isEmpty(em)){
            Toast.makeText(this,"Please enter email",Toast.LENGTH_SHORT);
            return;
        }

        if(TextUtils.isEmpty(p)){
            Toast.makeText(this,"Please enter email",Toast.LENGTH_SHORT);
            return;
        }

        bar.setMessage("logging in....");
        bar.show();

        fire.signInWithEmailAndPassword(em,p)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {

                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            //start profile activity
                            finish();//t
                            startActivity(new Intent(LoginActivity.this,ProfileActivity.class));

                        }
                        else{
                            Toast.makeText(LoginActivity.this,"Please enter email",Toast.LENGTH_SHORT).show();

                            startActivity(new Intent(LoginActivity.this,ProfileActivity.class));

                        }


                    }
                });

    }
}
