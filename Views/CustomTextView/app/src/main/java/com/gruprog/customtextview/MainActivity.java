package com.gruprog.customtextview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CustomTextView customTextView = new CustomTextView(this);
        customTextView.setText("Hello World!");
        setContentView(customTextView);
    }
}
