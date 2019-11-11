package com.example.tvtime2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.text.Spannable;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.view.View;
import android.widget.TextView;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Signup extends AppCompatActivity {

    //Variables
    private ConstraintLayout background;
    private TextView termsAndCondition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        background = (ConstraintLayout) findViewById(R.id.background);
        termsAndCondition = (TextView) findViewById(R.id.termsAndConditionText);
        termsAndCondition.setMovementMethod(LinkMovementMethod.getInstance());
        if(termsAndCondition != null) {
            StringUtil.stripUnderlines((Spannable) //Remove underline in links
                    termsAndCondition.getText());
        }

        Timer timer = new Timer();
        MyTimer mT = new MyTimer();

        timer.schedule(mT, 1000, 2000);

    }

    //go back to mainActivity
    public void goBack(View view){
        startActivity(new Intent(this, MainActivity.class));
    }

    public void goToHome(View view){
        startActivity(new Intent(this, ShowsWatchListDefaultPage.class));
    }

    //Timer for auto-image slider
    class MyTimer extends TimerTask{

        @Override
        public void run(){
            runOnUiThread(new Runnable() {

                Random rand = new Random();

                @Override
                public void run() {
                    int images[] = {
                            R.drawable.daenerys, R.drawable.sherlock_holmes,
                            R.drawable.eleven,R.drawable.rick_grimes
                    };
                    background.setBackgroundResource(images[getRandomNumber()]);

                }

                private int getRandomNumber(){
                    return rand.nextInt(4);
                }
            });
        }
    }

}

//Remove underlink in links
class URLSpanNoUnderline extends URLSpan {
    public URLSpanNoUnderline(String url) {
        super(url);
    }
    @Override
    public void updateDrawState(TextPaint textPaint) {
        super.updateDrawState(textPaint);
        textPaint.setUnderlineText(false); //setting this true will underline the text content.
    }
}

//Remove all underlines in text
class StringUtil {
    public static void stripUnderlines(Spannable textView) {
        URLSpan[] spans = textView.getSpans(0, textView.length(), URLSpan.class);
        for (URLSpan span: spans) {
            int start = textView.getSpanStart(span);
            int end = textView.getSpanEnd(span);
            textView.removeSpan(span);
            span = new URLSpanNoUnderline(span.getURL());
            textView.setSpan(span, start, end, 0);
        }
    }
}