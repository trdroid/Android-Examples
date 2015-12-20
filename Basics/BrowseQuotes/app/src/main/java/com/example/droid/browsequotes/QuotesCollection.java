package com.example.droid.browsequotes;

public class QuotesCollection {
    public static QuotesModel[] getQuotes() {
        QuotesModel[] quotes = new QuotesModel[] {new QuotesModel(R.string.quote1),
                new QuotesModel(R.string.quote2),
                new QuotesModel(R.string.quote3)
        };

        return quotes;
    }
}
