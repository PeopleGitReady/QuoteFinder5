package com.example.category;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class Motivation extends AppCompatActivity {



    Random rand = new Random();

    ArrayList<String> quotes = new ArrayList<String>();

    {
        quotes.add("I'm selfish, impatient and a little insecure. I make mistakes, I am out of control and at times hard to handle. But if you can’t handle me at my worst, then you sure as hell don’t deserve me at my best.\n\n-Marilyn Monroe");
        quotes.add("Twenty years from now you will be more disappointed by the things that you didn’t do than by the ones you did do.\n\n-Mark Twain");
        quotes.add("Great minds discuss ideas; average minds discuss events; small minds discuss people.\n\n-Eleanor Roosevelt");
        quotes.add("A successful man is one who can lay a firm foundation with the bricks others have thrown at him.\n\n-David Brinkley");
        quotes.add("Love yourself first and everything else falls into line. You really have to love yourself to get anything done in this world.\n\n-Lucille Ball");
        quotes.add("It is our choices, that show what we truly are, far more than our abilities.\n\n-J.K. Rowling");
        quotes.add("If you want to live a happy life, tie it to a goal, not to people or things.\n\n-Albert Einstein");
        quotes.add("The question isn’t who is going to let me; it’s who is going to stop me.\n\n-Ayn Rand");
        quotes.add("Life is trying things to see if they work.\n\n-Ray Bradbury");
        quotes.add("May you live all the days of your life.\n\n-Jonathan Swift");
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motivation);


        Button addBtn = (Button) findViewById(R.id.addBtn);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView resultTextView = (TextView) findViewById(R.id.resultTextView);
                resultTextView.setText(quotes.get(rand.nextInt(quotes.size())));
            }
        });
    }
}
