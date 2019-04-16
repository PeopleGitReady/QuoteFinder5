package com.example.quotefinder3;

import java.util.ArrayList;

public class Quote {

    private Author author;
    private String quote;

    public Quote (String quote, Author author) {
        this.author = author;
        this.quote = quote;
    }

    public String getQuote() {
        return quote;
    }

    public String getAuthor () {
        return author.getName();
    }

}