package com.example.quotefinder3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CategoryActivity extends AppCompatActivity {

    private Button button_smth;
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



        button_smth = (Button) findViewById(R.id.button);
        button_smth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openActivity();

            }
        });

        button_fitness = (Button) findViewById(R.id.button3);
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
