package com.example.quotefinder3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class FavoriteQuotesActivity extends AppCompatActivity {

    public ArrayList<Quote> favorite_quotes = new ArrayList<>();
    public ArrayList<Author> favorite_authors = new ArrayList<>();



    private Author reddit = new Author("Reddit", "Big news all day, everyday homie!");
    private Author blondie = new Author("Blondie", "Singer of a famous pop band", R.drawable.blondie);
    private Author jackCanfield = new Author("Jack Canfield", R.drawable.jackcanfield);
    private Author cocoChanel = new Author("Coco Chanel", R.drawable.cocochanel);
    private Author leoBurnett = new Author("Leo Burnett", R.drawable.leoburnett);
    private Author terryPratchett = new Author("Terry Pratchett", R.drawable.terrypratchett);
    private Author buddhistProverb = new Author("Buddhist Proverb");
    private Author horaceWalpole = new Author("Horace Walpole");

    private Quote quote1 = new Quote("If you reach for a star you might not get one. But you won't come up with a hand full of mud either.", leoBurnett, "Motivation");
    private Quote quote2 = new Quote("The tide is high but I'm holding on.", blondie, "Motivation");
    private Quote quote3 = new Quote("Simplicity is the key note of all true elegance.", cocoChanel, "Motivation");
    private Quote quote4 = new Quote("Wisdom comes from experience. Experience is often a result of lack of wisdom.", terryPratchett,"Motivation");
    private Quote quote5 = new Quote("Everything you want is on the other side of fear.", jackCanfield,"Motivation");
    private Quote quote7 = new Quote("The world is a comedy to those that think; a tragedy to those that feel", horaceWalpole,"Motivation");
    private Quote quote8 = new Quote("When you see a swordsman, draw your sword. Do not recite poetry to one who is not a poet.", buddhistProverb,"Motivation");
    private Quote quote6 = new Quote("We judge others by their actions and ourselves by our intentions", reddit,"Motivation");


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite_quotes);

        favorite_quotes.add(quote1);
        favorite_quotes.add(quote2);
        favorite_quotes.add(quote3);
        favorite_quotes.add(quote4);
        favorite_quotes.add(quote5);
        favorite_quotes.add(quote6);
        favorite_quotes.add(quote7);
        favorite_quotes.add(quote8);

        ArrayAdapter adapter = new ArrayAdapter<Quote>(this, R.layout.activity_list, favorite_quotes);
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);
    }

    public ArrayList<Quote> getFavorite_quotes() {
        return favorite_quotes;
    }




}
