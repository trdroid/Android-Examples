package com.example.droid.browsequotes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    /*
       Android's naming convention for naming instance members is to prefix their names with an 'm'
     */
    private Button mPreviousButton;
    private Button mNextButton;
    private TextView mQuoteTextView;

    private int mQuoteIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final QuoteModel[] quotes = QuotesCollection.getQuotes();

        mPreviousButton = (Button) findViewById(R.id.previous_button);
        mNextButton = (Button) findViewById(R.id.next_button);
        mQuoteTextView = (TextView) findViewById(R.id.quote_text_view);

        mPreviousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mQuoteIndex = mQuoteIndex > 0 ? --mQuoteIndex : quotes.length - 1;
                setQuoteText(mQuoteTextView, quotes[mQuoteIndex].getQuoteId());
            }
        });

        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mQuoteIndex = ++mQuoteIndex % quotes.length;
                setQuoteText(mQuoteTextView, quotes[mQuoteIndex].getQuoteId());
            }
        });
    }

    private void setQuoteText(TextView quoteTextView, int quoteID) {
        quoteTextView.setText(quoteID);
    }
}
