package com.konceptsandcode.citiesactivitiy;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setOnClickListener(R.id.beijing);
        setOnClickListener(R.id.brussels);
        setOnClickListener(R.id.london);
        setOnClickListener(R.id.montreal);
        setOnClickListener(R.id.newdelhi);
        setOnClickListener(R.id.newyork);
        setOnClickListener(R.id.sydney);
        setOnClickListener(R.id.tokyo);
        setOnClickListener(R.id.toronto);
        setOnClickListener(R.id.vancouver);
    }

    private void setOnClickListener(int viewId) {
        View view = findViewById(viewId);

        view.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int viewId = view.getId();
        int cityTopSpotsId = 0;

        switch(viewId) {
            case R.id.beijing:
                cityTopSpotsId = R.string.beijing;
                break;

            case R.id.brussels:
                cityTopSpotsId = R.string.brussels;
                break;

            case R.id.london:
                cityTopSpotsId = R.string.london;
                break;

            case R.id.montreal:
                cityTopSpotsId = R.string.montreal;
                break;

            case R.id.newdelhi:
                cityTopSpotsId = R.string.newdelhi;
                break;

            case R.id.newyork:
                cityTopSpotsId = R.string.newyork;
                break;

            case R.id.sydney:
                cityTopSpotsId = R.string.sydney;
                break;

            case R.id.tokyo:
                cityTopSpotsId = R.string.tokyo;
                break;

            case R.id.toronto:
                cityTopSpotsId = R.string.toronto;
                break;

            case R.id.vancouver:
                cityTopSpotsId = R.string.vancouver;
                break;
        }

        if(cityTopSpotsId != 0) {
            TextView cityWelcomeMessage = (TextView) findViewById(R.id.cityTopSpots);
            cityWelcomeMessage.setText(cityTopSpotsId);
        }
    }
}
