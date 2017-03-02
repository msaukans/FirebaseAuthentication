package com.sample.maris.firebaseauthentication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class display extends AppCompatActivity {

    String p = "1000000";

    ListView list;
    String[] players = {
            "marsis999",
            "inabox1",
            "guffaw",
            "swaggatron",
            "shady",
            "derpyjazz",
            "user"
    } ;
    String[] score = {
            p,
            "2000",
            "300",
            "40",
            "10",
            "5",
            "1"
    } ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        CustomList adapter = new
                CustomList(display.this, players, score);
        list=(ListView)findViewById(R.id.cList);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(display.this, players[+ position] + " has " + score[+position] + " points", Toast.LENGTH_SHORT).show();

            }
        });

    }
}