package com.example.droid.browsequotes;

public class QuotesCollection {
    public static QuoteModel[] getQuotes() {
        QuoteModel[] quotes = new QuoteModel[] {new QuoteModel(R.string.quote1),
                new QuoteModel(R.string.quote2),
                new QuoteModel(R.string.quote3)
        };

        return quotes;
    }
}
