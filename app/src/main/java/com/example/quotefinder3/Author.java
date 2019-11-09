package com.example.quotefinder3;

import java.util.ArrayList;
import java.util.Random;

public class Author {

    private String name;
    private String bio;

    private ArrayList<Quote> quotes = new ArrayList<>();

    private Quote quote ;

    private int pictureId;

    public Author (String name) {
        this.name = name;
        bio = "This author does not have a bio yet!";
        pictureId = R.drawable.blank;
    }

    public Author (String name, int pictureId) {
        this.name = name;
        this.pictureId = pictureId;
    }

    public Author (String name, String bio, int pictureId) {
        this.name = name;
        this.bio = bio;
        this.pictureId = pictureId;
    }


    public Author (String name, String bio) {
        this.name = name;
        this.bio = bio;
        pictureId = R.drawable.blank;
    }


    public Author (String name, Quote quote) {
        this.name = name;
        bio = "This author does not have a bio yet!";
        pictureId = R.drawable.blank;
        quotes.add(quote);
    }


    public Author (String name, int pictureId, Quote quote) {
        this.name = name;
        this.pictureId = pictureId;
        quotes.add(quote);
    }

    public Author (String name, String bio, int pictureId, Quote quote) {
        this.name = name;
        this.bio = bio;
        this.pictureId = pictureId;
        quotes.add(quote);
    }

    public void addQuote (Quote quotesss) {
        quote = quotesss;
        quotes.add(quote);

    }


    public Quote getQuote() {
        return quote;
    }

    public String getName () {
        return name;
    }

    public int getPictureId () {
        return pictureId;
    }

    public int getLength () {
        return quotes.size();
    }

  public Quote getRandomQuote () {
        Random rand = new Random();
        if (quotes.size() == 1) {
            return quotes.get(0);
        }
        else {
            int index = rand.nextInt(quotes.size() -1);
            return quotes.get(index);
        }
    }

    public String getBio () {
        return bio;
    }

    public ArrayList<Quote> getQuotes() {

        return quotes;
    }
}
