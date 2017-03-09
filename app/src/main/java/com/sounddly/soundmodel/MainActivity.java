package com.sounddly.soundmodel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import butterknife.BindColor;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import jp.wasabeef.picasso.transformations.ColorFilterTransformation;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.bitsound_repeat_init_count) protected TextView mBitsoundRepeatInitCount;
    @BindView(R.id.bitsound_repeat_init) protected ImageView mBitsoundRepeatInit;
    @BindView(R.id.bitsound_mic_permission) protected ImageView mBitsoundMicPermission;
    @BindView(R.id.bitsound_check_and_init) protected ImageView mBitsoundCheckAndInit;
    @BindView(R.id.bitsound_init) protected ImageView mBitsoundInit;
    @BindView(R.id.bitsound_release) protected ImageView mBitsoundRelease;



    @BindColor(R.color.grey) protected int GREY;
    @BindColor(R.color.green) protected int GREEN;
    @BindColor(R.color.red) protected int RED;
    @BindColor(R.color.blue) protected int BLUE;
    @BindColor(R.color.white) protected int WHITE;

    protected int current=1, currentim;
    protected ImageView currentimloc;

    private View.OnTouchListener ALPHA_EFFECT = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent event) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    view.setAlpha(0.5f);
                    break;
                case MotionEvent.ACTION_UP:
                    view.setAlpha(1f);
                    break;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(MainActivity.this);


        /* Initialize Dashboard */
        initializeBitsoundDashboard();


    }

    /* Bitsound Dashboard Listeners 0*/
    private void initializeBitsoundDashboard() {
        mBitsoundRepeatInit.setOnTouchListener(ALPHA_EFFECT);
        mBitsoundMicPermission.setOnTouchListener(ALPHA_EFFECT);
        mBitsoundCheckAndInit.setOnTouchListener(ALPHA_EFFECT);
        mBitsoundInit.setOnTouchListener(ALPHA_EFFECT);
        mBitsoundRelease.setOnTouchListener(ALPHA_EFFECT);
        Picasso.with(this).load(R.drawable.ic_repeat_white_24dp).transform(new ColorFilterTransformation(WHITE)).into(mBitsoundRepeatInit);
        Picasso.with(this).load(R.drawable.ic_mic_white_24dp).transform(new ColorFilterTransformation(WHITE)).into(mBitsoundMicPermission);
        Picasso.with(this).load(R.drawable.ic_check_white_24dp).transform(new ColorFilterTransformation(WHITE)).into(mBitsoundCheckAndInit);
        Picasso.with(this).load(R.drawable.ic_play_arrow_white_24dp).transform(new ColorFilterTransformation(WHITE)).into(mBitsoundInit);
        Picasso.with(this).load(R.drawable.ic_pause_white_24dp).transform(new ColorFilterTransformation(WHITE)).into(mBitsoundRelease);

    }
    @OnClick(R.id.bitsound_repeat_init)
    protected void onBitsoundRepeatInit() {
        setColor(R.drawable.ic_repeat_white_24dp, BLUE, mBitsoundRepeatInit);
    }

    @OnClick(R.id.bitsound_mic_permission)
    protected void onBitsoundMicPermission(){
        setColor(R.drawable.ic_mic_white_24dp,GREY, mBitsoundMicPermission);
    }
    @OnClick(R.id.bitsound_check_and_init)
    protected void onBitsoundCheckAndInit() {
        setColor(R.drawable.ic_check_white_24dp, RED, mBitsoundCheckAndInit);
    }
    @OnClick(R.id.bitsound_init)
    protected void onBitsoundInit() {
        setColor(R.drawable.ic_play_arrow_white_24dp,GREEN,mBitsoundInit);
    }
    @OnClick(R.id.bitsound_release)
    protected void onBitsoundRelease(){
        setColor(R.drawable.ic_pause_white_24dp,RED,mBitsoundRelease);

    }

    public void setColor(int im, int color, ImageView imloc){

        if(current != 1){

            Picasso.with(MainActivity.this)
                    .load(currentim)
                    .transform(new ColorFilterTransformation(WHITE))
                    .into(currentimloc);
            Toast.makeText(this, "Hello", Toast.LENGTH_SHORT).show();

        }else{
            current = 0;
        }
        Picasso.with(MainActivity.this)
                .load(im)
                .transform(new ColorFilterTransformation(color))
                .into(imloc);
        currentim =im; currentimloc = imloc;
    }

}
