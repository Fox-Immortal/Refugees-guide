package com.example.splashscreen3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Context context = this;
    ImageView top;
    ImageView bottom_dark;
    ImageView bottom_light;
    ImageView logo;
    TextView language;
    Button english;
    Button arabic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        top = findViewById(R.id.top);
        bottom_dark = findViewById(R.id.bottom_dark);
        bottom_light = findViewById(R.id.bottom_light);
        logo = findViewById(R.id.logo);
        language = findViewById(R.id.langage);
        english = findViewById(R.id.english);
        arabic = findViewById(R.id.arabic);
        setup();
        move_logo();
    }
    public void setup() {
        Animation move_top = AnimationUtils.loadAnimation(context, R.anim.top_move);
        top.startAnimation(move_top);

        Animation move_bottom = AnimationUtils.loadAnimation(context, R.anim.bottom_move);
        bottom_light.startAnimation(move_bottom);
        bottom_dark.startAnimation(move_bottom);

        Animation move_logo = AnimationUtils.loadAnimation(context, R.anim.setuplogo);
        logo.startAnimation(move_logo);

        Animation move_side = AnimationUtils.loadAnimation(context, R.anim.setup_side);
        language.startAnimation(move_side);
        english.startAnimation(move_side);
        arabic.startAnimation(move_side);
    }
    public void move_top() {
        Animation move_back = AnimationUtils.loadAnimation(context, R.anim.top_move_back);
        Animation logo_move = AnimationUtils.loadAnimation(context, R.anim.logo_move_top);
        move_back.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {}
            @Override
            public void onAnimationEnd(Animation animation) {
                move_bottom();
            }
            @Override
            public void onAnimationRepeat(Animation animation) {}
        });
        top.startAnimation(move_back);
        logo.startAnimation(logo_move);
    }

    public void move_bottom() {
        Animation move_back = AnimationUtils.loadAnimation(context, R.anim.bottom_move_back);
        Animation move_logo = AnimationUtils.loadAnimation(context, R.anim.logo_move_bottom);
        move_back.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {}
            @Override
            public void onAnimationEnd(Animation animation) {
                move_side();
            }
            @Override
            public void onAnimationRepeat(Animation animation) {}
        });
        logo.startAnimation(move_logo);
        bottom_dark.startAnimation(move_back);
        bottom_light.startAnimation(move_back);
    }
    public void move_logo() {
        Animation move = AnimationUtils.loadAnimation(context, R.anim.logo_move);
        move.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {}
            @Override
            public void onAnimationEnd(Animation animation) {
                move_top();
            }
            @Override
            public void onAnimationRepeat(Animation animation) {}
        });
        logo.startAnimation(move);
    }
    public void move_side() {
        Animation move_side = AnimationUtils.loadAnimation(context, R.anim.move_side);
        language.startAnimation(move_side);
        english.startAnimation(move_side);
        arabic.startAnimation(move_side);
    }
}