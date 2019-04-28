package com.example.quotefinder3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class FavoriteQuotesActivity extends AppCompatActivity {

    public static ArrayList<Quote> favorite_quotes = new ArrayList<>();
    public static ArrayList<Author> favorite_authors = new ArrayList<>();


    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite_quotes);

        ArrayAdapter adapter = new ArrayAdapter<Quote>(this, R.layout.activity_favorite_quotes, favorite_quotes);

        ListView listView = (ListView) findViewById(R.id.window_list);
        listView.setAdapter(adapter);
    }


}
