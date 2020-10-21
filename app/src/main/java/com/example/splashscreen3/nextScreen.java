package com.example.splashscreen3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityOptionsCompat;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Locale;

public class nextScreen extends AppCompatActivity {
    Context context = this;
    String language;
    LinearLayout options_lang;
    LinearLayout options_log;
    Button skip;
    TextView language2;
    Button english;
    Button arabic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        language = getIntent().getStringExtra("language");
        language = language.equals("ENGLISH") ? "en" : "ar";
        setApplocale(language);
        setContentView(R.layout.activity_next_screen);
        final ConstraintLayout layout = (ConstraintLayout) findViewById(R.id.background);
        ViewTreeObserver vto = layout.getViewTreeObserver();
        vto.addOnGlobalLayoutListener (new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                layout.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                setup();
            }
        });

        options_lang = findViewById(R.id.options_lang);
        options_log = findViewById(R.id.options_log);
        skip = findViewById(R.id.skip);
        language2 = findViewById(R.id.langage);
    }
    public void setup() {
        int duration = 0;
        float mul = -3;
        int delay = 0;
        options_lang.animate().setDuration(duration).translationXBy(options_lang.getMeasuredWidth() * mul).setStartDelay(delay);
        language2.animate().setDuration(duration).translationXBy(language2.getMeasuredWidth() * mul).setStartDelay(delay);
    }
    public void setApplocale(String language) {
        Resources resources = getResources();
        Configuration configuration = resources.getConfiguration();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        configuration.locale = new Locale(language);
        resources.updateConfiguration(configuration, displayMetrics);
    }
    @Override
    public void onPause() {
        super.onPause();
        overridePendingTransition(0, 0);
    }
    @Override
    public void onBackPressed() {
        int duration = 500;
        float mul = 3;
        int delay = 0;
        options_lang.animate().setDuration(duration).translationXBy(options_lang.getMeasuredWidth() * mul).setStartDelay(delay);
        language2.animate().setDuration(duration).translationXBy(language2.getMeasuredWidth() * mul).setStartDelay(delay);
        options_log.animate().setDuration(duration).translationXBy(options_log.getMeasuredWidth() * mul).setStartDelay(delay);
        skip.animate().setDuration(duration).translationXBy(options_log.getMeasuredWidth() * mul).setStartDelay(delay).setListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                Intent intent = new Intent(getApplicationContext(), Language.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
                finish();
            }
        });
    }
}