package com.example.quotefinder3;

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

    public Author getAuthor () {
        return author;
    }

}