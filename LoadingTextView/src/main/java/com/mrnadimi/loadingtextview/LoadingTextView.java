package com.mrnadimi.loadingtextview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * Developer: Mohamad Nadimi
 * Company: Saghe
 * Website: https://www.mrnadimi.com
 * Created on 30 April 2022
 * <p>
 * Description: ...
 */
public class LoadingTextView  extends androidx.appcompat.widget.AppCompatTextView {
    private int durationInMills ;
    private int loadingCount ;
    private String loadingText ;
    private final CountDownTimer timer;
    private String defaultText ;
    private boolean started;

    public LoadingTextView(@NonNull Context context) {
        this(context , null);
    }

    public LoadingTextView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs , 0);
    }

    public LoadingTextView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initDefaultValues();
        if (attrs != null){
            TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.LoadingTextView, defStyleAttr, 0);
            durationInMills = a.getInteger(R.styleable.LoadingTextView_ltv_animateDurationInMills, 0);
            loadingCount = a.getInteger(R.styleable.LoadingTextView_ltv_dotCount , 3);
            String textL = a.getString(R.styleable.LoadingTextView_ltv_loading);
            if (textL != null){
                loadingText = textL;
            }
            a.recycle();
        }
        if (loadingCount < 1){
            throw new IllegalArgumentException("dotCount can not less than 1");
        }
        timer = createTimer();
    }

    private void initDefaultValues(){
        durationInMills = 0;
        loadingCount = 3;
        loadingText = "\u25AA";
        defaultText = "";
        started = false;
    }

    private CountDownTimer createTimer(){
        return new CountDownTimer(Integer.MAX_VALUE, durationInMills) {

            private int count = 0;
            private final StringBuffer extra = new StringBuffer();


            @SuppressLint("SetTextI18n")
            public void onTick(long millisUntilFinished) {
                setText(defaultText+" "+extra.toString());
                Log.e("heree" , "   "+defaultText+" "+extra.toString());
                extra.append(loadingText);
                count++;
                if (count > loadingCount){
                    count = 0;
                    extra.delete(0, extra.length());
                }
            }

            public void onFinish() {
            }
        };
    }


    public void startTimer(){
        if (started){
            return;
        }
        defaultText = getText().toString();
        started = true;
        timer.start();
    }

    public void resetTimer(){
        timer.cancel();
        timer.start();
    }

    public void cancelTimer(){
        started = false;
        timer.cancel();
    }
}
