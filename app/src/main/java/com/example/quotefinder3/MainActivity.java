package com.example.quotefinder3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener {

    public static final int SWIPE_THRESHOLD = 80;
    public static final int SWIPE_VELOCITY_THRESHOLD = 80;

    private Random rand = new Random();
    private GestureDetector detector;

    private int currentAuthorIndex;
    private int backwardsSwipeCounter = 0;
    private int counter = 0;

    private TextView quoteDisplay;
    private TextView authorDisplay;

    private Author currentAuthor;
    private Quote currentQuote;

    private ArrayList<Author> authors = new ArrayList<>();
    private ArrayList<Quote> previousQuotes = new ArrayList<>();


    private Author bobMarley = new Author("Bob Marley", "This guy smoked a lot of weed ..", R.drawable.marley);
    private Author markTwain = new Author("Mark Twain", "Cool mofo", R.drawable.marktwain);
    private Author reddit = new Author("Reddit", "Big news all day, everyday homie!");
    private Author blondie = new Author("Blondie", "Singer of a famous pop band", R.drawable.blondie);
    private Author jackCanfield = new Author("Jack Canfield", R.drawable.jackcanfield);
    private Author cocoChanel = new Author("Coco Chanel", R.drawable.cocochanel);
    private Author leoBurnett = new Author("Leo Burnett", R.drawable.leoburnett);
    private Author terryPratchett = new Author("Terry Pratchett", R.drawable.terrypratchett);
    private Author buddhistProverb = new Author("Buddhist Proverb");
    private Author horaceWalpole = new Author("Horace Walpole");

    private Quote quote1 = new Quote("If you reach for a star you might not get one. But you won't come up with a hand full of mud either.", leoBurnett);
    private Quote quote2 = new Quote("The tide is high but I'm holding on.", blondie);
    private Quote quote3 = new Quote("Simplicity is the key note of all true elegance.", cocoChanel);
    private Quote quote4 = new Quote("Wisdom comes from experience. Experience is often a result of lack of wisdom.", terryPratchett);
    private Quote quote5 = new Quote("Everything you want is on the other side of fear.", jackCanfield);
    private Quote quote7 = new Quote("The world is a comedy to those that think; a tragedy to those that feel", horaceWalpole);
    private Quote quote8 = new Quote("When you see a swordsman, draw your sword. Do not recite poetry to one who is not a poet.", buddhistProverb);
    private Quote quote6 = new Quote("We judge others by their actions and ourselves by our intentions", reddit);
    private Quote quote9 = new Quote("“I have never let my schooling interfere with my education.", markTwain);
    private Quote quote10 = new Quote("If you tell the truth, you don't have to remember anything.", markTwain);
    private Quote quote11 = new Quote("When there's a will, there's always a way", bobMarley);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        detector = new GestureDetector(this);

        leoBurnett.addQuote(quote1);
        blondie.addQuote(quote2);
        cocoChanel.addQuote(quote3);
        terryPratchett.addQuote(quote4);
        jackCanfield.addQuote(quote5);
        reddit.addQuote(quote6);
        horaceWalpole.addQuote(quote7);
        buddhistProverb.addQuote(quote8);
        markTwain.addQuote(quote9);
        markTwain.addQuote(quote10);
        bobMarley.addQuote(quote11);

        authors.add(bobMarley);
        authors.add(markTwain);
        authors.add(reddit);
        authors.add(cocoChanel);
        authors.add(jackCanfield);
        authors.add(blondie);

        System.out.println(getQuoteListSize());
        onSwipeRight();

        Button likeButton = (Button) findViewById(R.id.likeButton);
        likeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                System.out.println("Quote saved!");

                FavoriteQuotesActivity.favorite_quotes.add(currentQuote);
                FavoriteQuotesActivity.favorite_authors.add(currentAuthor);


                // add quote that is currently being displayed to favorite_authors
                // if possible, confirm this with a blinking animation

            }
        });
    }



    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    public void onClickAuthor(View view) {
        Intent authorIntent = new Intent(MainActivity.this, AuthorPageActivity.class);
        authorIntent.putExtra("Author Name", authorDisplay.getText().toString());
        authorIntent.putExtra("Bio", authors.get(currentAuthorIndex).getBio());
        authorIntent.putExtra("Picture id", authors.get(currentAuthorIndex).getPictureId());
        startActivity(authorIntent);
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }


    @Override
    public boolean onFling(MotionEvent downEvent, MotionEvent moveEvent, float velocityX, float velocityY) {
        boolean result = false;
        float diffY = moveEvent.getY() - downEvent.getY();
        float diffX = moveEvent.getX() - downEvent.getX();
        // which was greater? movement across Y or X?
        if (Math.abs(diffX) > Math.abs(diffY)) {
            //right or left swipe
            if (Math.abs(diffX) > SWIPE_THRESHOLD && Math.abs(velocityX) > SWIPE_VELOCITY_THRESHOLD) {
                if (diffX > 0) {
                    // swipe for previous quotes unless at end of list:
                    if (previousQuotes.size() > 2 && (previousQuotes.size() - (2 + counter)) >= 0) {
                        runAnimationSwipeRight();
                    } else {
                        Toast.makeText(this, "End of list!", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    // swipe for new quotes:
                    runAnimationSwipeLeft();
                }
                result = true;
            }

        } else {
            // up or down swipe
            if (Math.abs(diffY) > SWIPE_THRESHOLD && Math.abs(velocityY) > SWIPE_VELOCITY_THRESHOLD) {
                if (diffY > 0) {
                    onSwipeBottom();
                } else {
                    onSwipeTop();
                }
                result = true;
            }
        }
        return result;
    }

    private void onSwipeBottom() {

        Intent intent = new Intent(this, CategoryActivity.class);
        startActivity(intent);

        Toast.makeText(this, "Swipe Bottom", Toast.LENGTH_LONG).show();
    }

    private void onSwipeTop() {
        Toast.makeText(this, "Swipe Top", Toast.LENGTH_LONG).show();
    }

    private void onSwipeRight() {

        quoteDisplay = findViewById(R.id.quoteDisplay);
        authorDisplay = findViewById(R.id.quoteAuthor);

        currentAuthorIndex = rand.nextInt(authors.size() - 1);
        currentAuthor = authors.get(currentAuthorIndex);
        currentQuote = authors.get(currentAuthorIndex).getRandomQuote();

        authorDisplay.setText(currentAuthor.getName());
        quoteDisplay.setText(currentQuote.getQuote());

        previousQuotes.add(currentQuote);
        Toast.makeText(this, "Swipe Right", Toast.LENGTH_SHORT).show();
        counter = 0;


        /*
        // check if user has browsed through ALL available quotes:
        if ( ! previousQuotes.isEmpty() && ( previousQuotes.size() >= getQuoteListSize() ) ) {
            Toast.makeText(this, "End of list!", Toast.LENGTH_SHORT).show();
        }

        // code to make sure user will not see the same quote twice:
        if (! previousQuotes.isEmpty() ) {
            boolean myTruth = false;

            while (! myTruth ) {
                currentAuthorIndex = rand.nextInt(authors.size() - 1);
                currentAuthor = authors.get(currentAuthorIndex);
                currentQuote = authors.get(currentAuthorIndex).getRandomQuote();

                if ( ! previousQuotes.contains(currentQuote)) {
                    authorDisplay.setText(currentAuthor.getName());
                    quoteDisplay.setText(currentQuote.getQuote());

                    previousQuotes.add(currentQuote);
                    counter = 0;
                    Toast.makeText(this, "Swipe Right", Toast.LENGTH_SHORT).show();
                    myTruth = true;
                }
            }
        } */
    }

    private void onSwipeLeft() {

        Toast.makeText(this, "Swipe Left", Toast.LENGTH_SHORT).show();

        quoteDisplay = findViewById(R.id.quoteDisplay);
        authorDisplay = findViewById(R.id.quoteAuthor);

        if (counter == 0) {
            quoteDisplay.setText(previousQuotes.get(previousQuotes.size() - 2).getQuote());
            authorDisplay.setText(previousQuotes.get(previousQuotes.size() - 2).getAuthor());

            counter++;
        } else {
            quoteDisplay.setText(previousQuotes.get(previousQuotes.size() - (2 + counter)).getQuote());
            authorDisplay.setText(previousQuotes.get(previousQuotes.size() - (2 + counter)).getAuthor());

            counter++;
        }


    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        detector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    private void runAnimationSwipeRight() {
        Animation slide = AnimationUtils.loadAnimation(this, R.anim.slide_out_right);
        slide.reset();
        slide.setDuration(500);

        slide.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                onSwipeLeft();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        quoteDisplay.clearAnimation();
        quoteDisplay.startAnimation(slide);
        authorDisplay.clearAnimation();
        authorDisplay.startAnimation(slide);

    }

    private void runAnimationSwipeLeft() {
        Animation slide = AnimationUtils.loadAnimation(this, R.anim.slide_out_left);
        slide.reset();
        slide.setDuration(500);

        slide.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                onSwipeRight();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        quoteDisplay.clearAnimation();
        quoteDisplay.startAnimation(slide);
        authorDisplay.clearAnimation();
        authorDisplay.startAnimation(slide);
    }

    public int getQuoteListSize() {
        int sumOfQuotes = 0;
        for (int i = 0; i < authors.size(); i++) {
            sumOfQuotes += authors.get(i).getLength();
        }
        return sumOfQuotes;
    }


}
