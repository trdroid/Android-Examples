package com.example.droid.browsequotes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    /*
       Android's naming convention for naming instance members is to prefix their names with an 'm'
     */
    private Button mPreviousButton;
    private Button mNextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        QuotesModel[] quotes = QuotesCollection.getQuotes();

        mPreviousButton = (Button) findViewById(R.id.previous_button);
        mNextButton = (Button) findViewById(R.id.next_button);

        mPreviousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
