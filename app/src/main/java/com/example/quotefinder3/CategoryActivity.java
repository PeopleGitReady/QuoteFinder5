package com.example.quotefinder3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CategoryActivity extends AppCompatActivity {

    private Button button_love;
    private Button button_humor;
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



        button_love = (Button) findViewById(R.id.love);
        button_love.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openActivity();

            }
        });

        button_humor = (Button) findViewById(R.id.humor);
        button_humor.setOnClickListener(new View.OnClickListener() {
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
