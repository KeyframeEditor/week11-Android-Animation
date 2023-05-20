package com.example.pertemuan11_animation;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ObjectAnimator mAnimator;
    ObjectAnimator exp;
    ObjectAnimator exphide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imgView = findViewById(R.id.image);
        ImageView imagewaduhhh = findViewById(R.id.imagewaduhhh);
        Button btn = findViewById(R.id.btn_animate);


        mAnimator = ObjectAnimator.ofFloat(imgView, "x", 500);
        exp = ObjectAnimator.ofFloat(imagewaduhhh, "scaleX", 0, 1);
        exp.setDuration(1000);
        ObjectAnimator scaleYAnimator = ObjectAnimator.ofFloat(imagewaduhhh, "scaleY", 0, 1);
        scaleYAnimator.setDuration(1000);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imagewaduhhh.setVisibility(View.GONE);
                mAnimator.setDuration(1000);
                mAnimator.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        // Animation ended, start cobaAnimator
                        imagewaduhhh.setVisibility(View.VISIBLE);
                        exp.start();
                        scaleYAnimator.start();
                    }
                });
                mAnimator.start();
            }
        });


    }
}