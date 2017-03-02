package com.sample.maris.firebaseauthentication;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class CustomList extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] players;
    private final String[] score;

    public CustomList(Activity context, String[] p, String[] s) {
        super(context, R.layout.list_single, s);
        this.context = context;
        this.players = p;
        this.score = s;

    }//end Constructor

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.list_single, null, true);
        TextView txtTitle1 = (TextView) rowView.findViewById(R.id.txt1);
        TextView txtTitle2 = (TextView) rowView.findViewById(R.id.txt2);


        txtTitle1.setText(players[position]);
        txtTitle2.setText(score[position]);

        return rowView;
    }
}