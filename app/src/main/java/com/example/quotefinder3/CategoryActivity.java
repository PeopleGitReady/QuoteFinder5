package com.example.quotefinder3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CategoryActivity extends AppCompatActivity {

    private Button loveButton;
    private Button button_fitness;
    private Button button_moti;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        button_moti = (Button) findViewById(R.id.button_Moti);
        button_moti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityForMotivation();
            }
        });



        loveButton = (Button) findViewById(R.id.love);
        loveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openActivity();

            }
        });

        button_fitness = (Button) findViewById(R.id.fitness);
        button_fitness.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityForMotivation();
            }
        });
    }

    public void openActivity(){
        Intent homeIntent = new Intent(this, MainActivity.class);
        startActivity(homeIntent);
    }

    public void openActivityForMotivation(){
        Intent homeIntent = new Intent(this, MainActivity.class);
        startActivity(homeIntent);

    }

}
