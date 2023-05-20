package com.example.pertemuan11_animation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ObjectAnimator rainAnimator, smokeRIGHTAnimator, smokeLEFTAnimator, smokeCENTERAnimator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.btn_animate);
        TextView btn_restart = findViewById(R.id.btn_restart);
        TextView tvRAMCleared = findViewById(R.id.tvRAMCleared);
        ImageView rain_imgView = findViewById(R.id.rain);
        ImageView smokeCENTER_imgView = findViewById(R.id.smokeCENTER);
        ImageView smokeLEFT_imgView = findViewById(R.id.smokeLEFT);
        ImageView smokeRIGHT_imgView = findViewById(R.id.smokeRIGHT);
        ImageView rocket_imgView = findViewById(R.id.rocket);

        tvRAMCleared.setVisibility(View.GONE);
        btn_restart.setVisibility(View.GONE);
        rain_imgView.setVisibility(View.GONE);
        smokeCENTER_imgView.setVisibility(View.GONE);
        smokeLEFT_imgView.setVisibility(View.GONE);
        smokeRIGHT_imgView.setVisibility(View.GONE);
        rocket_imgView.setVisibility(View.GONE);

        ObjectAnimator rainAnimator = ObjectAnimator.ofFloat(rain_imgView, "y", -1000, 2000);

        // Smoke CENTER Fade in animation
        ObjectAnimator smokeCENTER_fade = ObjectAnimator.ofFloat(smokeCENTER_imgView, "alpha", 0f, 1f);
        smokeCENTER_fade.setDuration(1000);

        // Smoke CENTER Scale animation
        ObjectAnimator smokeCENTER_scaleX = ObjectAnimator.ofFloat(smokeCENTER_imgView, "scaleX", 0, 1);
        smokeCENTER_scaleX.setDuration(1000);
        ObjectAnimator smokeCENTER_scaleY = ObjectAnimator.ofFloat(smokeCENTER_imgView, "scaleY", 0, 1);
        smokeCENTER_scaleY.setDuration(1000);

        // Smoke LEFT Fade in animation
        ObjectAnimator smokeLEFT_fade = ObjectAnimator.ofFloat(smokeLEFT_imgView, "alpha", 0f, 1f);
        smokeCENTER_fade.setDuration(1000);

        // Smoke LEFT Move animation
        ObjectAnimator smokeLEFT_move = ObjectAnimator.ofFloat(smokeLEFT_imgView, "x", -1500);
        smokeLEFT_move.setDuration(1000);

        // Smoke LEFT Fade in animation
        ObjectAnimator smokeRIGHT_fade = ObjectAnimator.ofFloat(smokeRIGHT_imgView, "alpha", 0f, 1f);
        smokeCENTER_fade.setDuration(1000);

        // Smoke LEFT Move animation
        ObjectAnimator smokeRIGHT_move = ObjectAnimator.ofFloat(smokeRIGHT_imgView, "x", 1500);
        smokeRIGHT_move.setDuration(1000);

        // Rocket Move animation
        ObjectAnimator rocket_move = ObjectAnimator.ofFloat(rocket_imgView, "y", 2000, -400);
        rocket_move.setDuration(2000);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator scaleXAnimator = ObjectAnimator.ofFloat(btn, "scaleX", 1f, 0f);
                ObjectAnimator scaleYAnimator = ObjectAnimator.ofFloat(btn, "scaleY", 1f, 0f);
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playTogether(scaleXAnimator, scaleYAnimator);
                animatorSet.setDuration(500);
                animatorSet.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        btn.setVisibility(View.GONE);
                    }
                });

                animatorSet.start();

                tvRAMCleared.setVisibility(View.GONE);
                rain_imgView.setVisibility(View.VISIBLE);
                smokeCENTER_imgView.setVisibility(View.VISIBLE);
                smokeLEFT_imgView.setVisibility(View.VISIBLE);
                smokeRIGHT_imgView.setVisibility(View.VISIBLE);
                rocket_imgView.setVisibility(View.VISIBLE);

                rainAnimator.setDuration(2000);
                rainAnimator.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        //
                    }
                });
                rainAnimator.start();
                smokeCENTER_fade.start();
                smokeCENTER_scaleX.start();
                smokeCENTER_scaleY.start();
                smokeLEFT_fade.start();
                smokeLEFT_move.start();
                smokeRIGHT_fade.start();
                smokeRIGHT_move.start();
                rocket_move.start();

                btn_restart.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this, MainActivity.this.getClass());
                        startActivity(intent);
                        finish();
                    }
                });

                rainAnimator.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        tvRAMCleared.setVisibility(View.VISIBLE);
                        tvRAMCleared.setScaleX(0f);
                        tvRAMCleared.setScaleY(0f);

                        ObjectAnimator scaleXAnimator = ObjectAnimator.ofFloat(tvRAMCleared, "scaleX", 0f, 1f);
                        ObjectAnimator scaleYAnimator = ObjectAnimator.ofFloat(tvRAMCleared, "scaleY", 0f, 1f);

                        AnimatorSet animatorSet = new AnimatorSet();
                        animatorSet.playTogether(scaleXAnimator, scaleYAnimator);
                        animatorSet.setDuration(400);

                        animatorSet.start();

                        animatorSet.addListener(new AnimatorListenerAdapter() {
                            @Override
                            public void onAnimationEnd(@NonNull Animator animation, boolean isReverse) {
                                btn_restart.setVisibility(View.VISIBLE);
                                btn_restart.setScaleX(0f);
                                btn_restart.setScaleY(0f);

                                ObjectAnimator scaleXAnimator = ObjectAnimator.ofFloat(btn_restart, "scaleX", 0f, 1f);
                                ObjectAnimator scaleYAnimator = ObjectAnimator.ofFloat(btn_restart, "scaleY", 0f, 1f);

                                AnimatorSet animatorSet = new AnimatorSet();
                                animatorSet.playTogether(scaleXAnimator, scaleYAnimator);
                                animatorSet.setDuration(400);

                                animatorSet.start();
                            }
                        });
                    }
                });
            }
        });


    }
}