package com.sample.maris.firebaseauthentication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener{

    private FirebaseAuth fire;
    private Button logoutBtn;
    private TextView userEmailTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        fire = FirebaseAuth.getInstance();
        if(fire.getCurrentUser() !=null){
            //finish();//t
            //startActivity(new Intent(ProfileActivity.this,LoginActivity.class));
        }

        FirebaseUser user = fire.getCurrentUser();
        String user1;
        user1 = user.getEmail();
        userEmailTv = (TextView) findViewById(R.id.userEmailTv);
        userEmailTv.setText("Welcome " + user1);
        logoutBtn = (Button) findViewById(R.id.logoutBtn);
        logoutBtn.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        if(logoutBtn == v){
            //fire.signOut();
            //finish();//t
            //startActivity(new Intent(ProfileActivity.this,LoginActivity.class));
            Toast.makeText(this, "Signing out, -unfinished", Toast.LENGTH_SHORT).show();
        }
    }
}
