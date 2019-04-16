package com.example.category;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {



    private Button buttonMoti;
    private Button buttonFitness;
    private Button buttonPrenuer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        buttonMoti= (Button) findViewById(R.id.button_moti);
        buttonFitness= (Button) findViewById(R.id.button_bitness);
        buttonPrenuer= (Button) findViewById(R.id.button_prenuer);
        buttonMoti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    openActivtyMoti();

            }
        });



    }

    public void openActivtyMoti(){
        Intent intent = new Intent(this, Motivation.class);
        startActivity(intent);
    }
}



// buttonFitness = (Button) findViewById(R.id.button_bitness);
//buttonPrenuer = (Button) findViewById(R.id.button_prenuer);

       /* View.OnClickListener ourOnClickListner = new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                numTimesClicked = numTimesClicked +1;
                String result = "The button has been tapped "+ numTimesClicked+ " time";
                textView.append(result);
            }
        };
        buttonMoti.setOnClickListener(ourOnClickListner);*/