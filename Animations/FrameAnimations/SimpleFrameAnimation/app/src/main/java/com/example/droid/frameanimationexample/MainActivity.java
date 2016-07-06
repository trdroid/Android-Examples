package com.example.droid.frameanimationexample;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.TransitionDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ImageView logoAnimationBaseImage = (ImageView) findViewById(R.id.logo);
        final AnimationDrawable logoAnimationDrawable = (AnimationDrawable) logoAnimationBaseImage.getDrawable();

        logoAnimationBaseImage.post(() -> logoAnimationDrawable.start());

        View rootLayout = findViewById(R.id.root_layout);

        rootLayout.setOnClickListener((view) -> {
                ImageView lightAnimationBaseImage = (ImageView) findViewById(R.id.image_flip);
                TransitionDrawable lightTransitionDrawable = (TransitionDrawable) lightAnimationBaseImage.getDrawable();

                lightTransitionDrawable.startTransition(2000);
            });

        final ImageView logoAnimationBaseImageForDifferentOrder = (ImageView) findViewById(R.id.logo_different_order);
        final AnimationDrawable logoAnimationDrawableDifferentOrder = (AnimationDrawable) logoAnimationBaseImageForDifferentOrder.getDrawable();
        logoAnimationBaseImageForDifferentOrder.post(() -> logoAnimationDrawableDifferentOrder.start());
    }
}
