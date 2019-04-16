package com.example.quotefinder3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class AuthorPageActivity extends AppCompatActivity {

    TextView authorName;
    TextView authorBio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_author_page);

        Intent authorInfo = getIntent();
        Bundle b = authorInfo.getExtras();

        if(b != null) {

            String name = (String)b.get("Author Name");
            authorName = findViewById(R.id.authorName);
            authorName.setText(name);

            String bio = (String)b.get("Bio");
            authorBio = findViewById(R.id.bio);
            authorBio.setText(bio);

            int pictureId = (int)b.get("Picture id");
            ImageView imageView = findViewById(R.id.authorProfile);
            imageView.setImageResource(pictureId);

        }

        ListView listView = findViewById(R.id.quoteList);
        //listView.add()



    }
}
