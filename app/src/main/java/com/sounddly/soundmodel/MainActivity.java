package com.sounddly.soundmodel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

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

    @BindView(R.id.bitsound_receiver_repeat_count) protected TextView mBitsoundRepeatDetectionCount;
    @BindView(R.id.bitsound_receiver_repeat) protected ImageView mBitsoundRepeatDetection;
    @BindView(R.id.bitsound_receiver_start) protected ImageView mBitsoundStartDetection;
    @BindView(R.id.bitsound_receiver_stop) protected ImageView mBitsoundStopDetection;

    @BindView(R.id.bitsound_shaking_repeat_count) protected TextView mBitsoundRepeatShakingCount;
    @BindView(R.id.bitsound_shaking_repeat) protected ImageView mBitsoundRepeatShaking;
    @BindView(R.id.bitsound_shaking_enable) protected ImageView mBitsoundEnableShaking;
    @BindView(R.id.bitsound_shaking_disable) protected ImageView mBitsoundDisableShaking;

    @BindView(R.id.bitsound_smarton_repeat) protected ImageView mBitsoundRepeatSmartOn;
    @BindView(R.id.bitsound_smarton_start_10sec_later) protected ImageView mBitsoundStartSmartOnIn10Sec;
    @BindView(R.id.bitsound_smarton_start) protected ImageView mBitsoundStartSmartOn;
    @BindView(R.id.bitsound_smarton_stop) protected ImageView mBitsoundStopSmartOn;

    @BindView(R.id.misc_get_scheduled_contents_repeat_count) protected TextView mMiscGetScheduledContentsCount;
    @BindView(R.id.misc_get_scheduled_contents_repeat) protected ImageView mMiscRepeatGetScheduledContents;
    @BindView(R.id.misc_get_scheduled_contents) protected Button mMiscGetScheduledContents;

    @BindView(R.id.misc_send_custom_log_repeat_count) protected TextView mMiscSendCustomLogCount;
    @BindView(R.id.misc_send_custom_log_repeat) protected ImageView mMiscRepeatSendCustomLogCount;
    @BindView(R.id.misc_send_custom_log) protected Button mMiscSendCustomLog;


    @BindColor(R.color.grey) protected int GREY;
    @BindColor(R.color.green) protected int GREEN;
    @BindColor(R.color.red) protected int RED;
    @BindColor(R.color.blue) protected int BLUE;
    @BindColor(R.color.white) protected int WHITE;

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
        initializeBitsoundReceiverDashboard();
        initializeBitsoundShakingDashboard();
        initializeBitsoundSmartOnDashboard();
        initializeBitsoundMiscDashboard();


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
        setColor(0,BLUE,0);
    }

    @OnClick(R.id.bitsound_mic_permission)
    protected void onBitsoundMicPermission() {
        setColor(1,GREY,0);

    }
    @OnClick(R.id.bitsound_check_and_init)
    protected void onBitsoundCheckAndInit() {
        setColor(2,RED,0);

    }
    @OnClick(R.id.bitsound_init)
    protected void onBitsoundInit() {
        setColor(3,GREEN,0);
    }
    @OnClick(R.id.bitsound_release)
    protected void onBitsoundRelease() {
        setColor(4,RED,0);
    }

    /* BitsoundReceiver Dashboard Listeners 1*/
    private void initializeBitsoundReceiverDashboard() {
        mBitsoundRepeatDetection.setOnTouchListener(ALPHA_EFFECT);
        mBitsoundStartDetection.setOnTouchListener(ALPHA_EFFECT);
        mBitsoundStopDetection.setOnTouchListener(ALPHA_EFFECT);
        Picasso.with(this).load(R.drawable.ic_repeat_white_24dp).transform(new ColorFilterTransformation(WHITE)).into(mBitsoundRepeatDetection);
        Picasso.with(this).load(R.drawable.ic_play_arrow_white_24dp).transform(new ColorFilterTransformation(WHITE)).into(mBitsoundStartDetection);
        Picasso.with(this).load(R.drawable.ic_pause_white_24dp).transform(new ColorFilterTransformation(WHITE)).into(mBitsoundStopDetection);
    }
    @OnClick(R.id.bitsound_receiver_repeat)
    public void onBitsoundRepeatDetection() {
        setColor(0,BLUE,1);
    }
    @OnClick(R.id.bitsound_receiver_start)
    public void onBitsoundStartDetection() {
        setColor(1,GREEN,1);

    }
    @OnClick(R.id.bitsound_receiver_stop)
    public void onBitsoundStopDetection() {
        setColor(2,RED,1);
    }


    /* BitsoundShaking Dashboard Listeners 2*/

    private void initializeBitsoundShakingDashboard() {

        mBitsoundRepeatShaking.setOnTouchListener(ALPHA_EFFECT);
        mBitsoundEnableShaking.setOnTouchListener(ALPHA_EFFECT);
        mBitsoundDisableShaking.setOnTouchListener(ALPHA_EFFECT);
        Picasso.with(this).load(R.drawable.ic_repeat_white_24dp).transform(new ColorFilterTransformation(WHITE)).into(mBitsoundRepeatShaking);
        Picasso.with(this).load(R.drawable.ic_play_arrow_white_24dp).transform(new ColorFilterTransformation(WHITE)).into(mBitsoundEnableShaking);
        Picasso.with(this).load(R.drawable.ic_pause_white_24dp).transform(new ColorFilterTransformation(WHITE)).into(mBitsoundDisableShaking);
    }
    @OnClick(R.id.bitsound_shaking_repeat)
    protected void onBitsoundRepeatShaking() {
        setColor(0,BLUE,2);

    }
    @OnClick(R.id.bitsound_shaking_enable)
    protected void onBitsoundEnableShaking() {
        setColor(1,GREEN,2);

    }
    @OnClick(R.id.bitsound_shaking_disable)
    protected void onBitsoundDisableShaking() {
        setColor(2,RED,2);

    }

    /* BitsoundSmartOn Dashboard Listeners 3*/
    private void initializeBitsoundSmartOnDashboard() {
        mBitsoundRepeatSmartOn.setOnTouchListener(ALPHA_EFFECT);
        mBitsoundStartSmartOnIn10Sec.setOnTouchListener(ALPHA_EFFECT);
        mBitsoundStartSmartOn.setOnTouchListener(ALPHA_EFFECT);
        mBitsoundStopSmartOn.setOnTouchListener(ALPHA_EFFECT);
        Picasso.with(this).load(R.drawable.ic_repeat_white_24dp).transform(new ColorFilterTransformation(WHITE)).into(mBitsoundRepeatSmartOn);
        Picasso.with(this).load(R.drawable.ic_timer_10_white_24dp).transform(new ColorFilterTransformation(WHITE)).into(mBitsoundStartSmartOnIn10Sec);
        Picasso.with(this).load(R.drawable.ic_play_arrow_white_24dp).transform(new ColorFilterTransformation(WHITE)).into(mBitsoundStartSmartOn);
        Picasso.with(this).load(R.drawable.ic_pause_white_24dp).transform(new ColorFilterTransformation(WHITE)).into(mBitsoundStopSmartOn);

    }

    @OnClick(R.id.bitsound_smarton_repeat)
    protected void onBitsoundRepeatSmartOn() {
        setColor(0,BLUE,3);

    }
    @OnClick(R.id.bitsound_smarton_start_10sec_later)
    protected void onBitsoundStartSmartOnIn10Sec() {
        setColor(1,GREEN,3);
    }
    @OnClick(R.id.bitsound_smarton_start)
    protected void onBitsoundStartSmartOn() {
        setColor(2,GREEN,3);

    }
    @OnClick(R.id.bitsound_smarton_stop)
    protected void onBitsoundStopSmartOn() {
        setColor(3,RED,3);
    }

    /* Bitsound Miscellaneous Dashboard Listeners 4*/
    private void initializeBitsoundMiscDashboard() {

        mMiscRepeatGetScheduledContents.setOnTouchListener(ALPHA_EFFECT);
        Picasso.with(this).load(R.drawable.ic_repeat_white_24dp).transform(new ColorFilterTransformation(WHITE)).into(mMiscRepeatGetScheduledContents);

        mMiscRepeatSendCustomLogCount.setOnTouchListener(ALPHA_EFFECT);
        Picasso.with(this).load(R.drawable.ic_repeat_white_24dp).transform(new ColorFilterTransformation(WHITE)).into(mMiscRepeatSendCustomLogCount);
    }
    @OnClick(R.id.misc_get_scheduled_contents_repeat)
    protected void onMiscRepeatGetScheduledContents() {

    }
    @OnClick(R.id.misc_get_scheduled_contents)
    protected void onMiscGetScheduledContents() {

    }

    @OnClick(R.id.misc_send_custom_log_repeat)
    protected void onMiscRepeatSendCustomLog() {

    }
    @OnClick(R.id.misc_send_custom_log)
    protected void onMiscSendCustomLog() {
    }


    //이미 클릭시 색깔 상태 변환
    protected void setColor(int n,int color, int from){     //n : 몇번째 이미지만 변환 할지  color : 어떤색   from : 어느 부분에 있는 이미지인지

        switch (from){
            case 0:    //Bitsound
                int[] tempcolor0 = {WHITE,WHITE,WHITE,WHITE,WHITE};         //흰색으로 초기화 후
                tempcolor0[n] = color;                                      //원하는 부분만 색을 지정
                Picasso.with(this).load(R.drawable.ic_repeat_white_24dp).transform(new ColorFilterTransformation(tempcolor0[0])).into(mBitsoundRepeatInit);
                Picasso.with(this).load(R.drawable.ic_mic_white_24dp).transform(new ColorFilterTransformation(tempcolor0[1])).into(mBitsoundMicPermission);
                Picasso.with(this).load(R.drawable.ic_check_white_24dp).transform(new ColorFilterTransformation(tempcolor0[2])).into(mBitsoundCheckAndInit);
                Picasso.with(this).load(R.drawable.ic_play_arrow_white_24dp).transform(new ColorFilterTransformation(tempcolor0[3])).into(mBitsoundInit);
                Picasso.with(this).load(R.drawable.ic_pause_white_24dp).transform(new ColorFilterTransformation(tempcolor0[4])).into(mBitsoundRelease);
                break;

            case 1:     //BitsoundReceiver
                int[] tempcolor1 = {WHITE,WHITE,WHITE};
                tempcolor1[n] = color;
                Picasso.with(this).load(R.drawable.ic_repeat_white_24dp).transform(new ColorFilterTransformation(tempcolor1[0])).into(mBitsoundRepeatDetection);
                Picasso.with(this).load(R.drawable.ic_play_arrow_white_24dp).transform(new ColorFilterTransformation(tempcolor1[1])).into(mBitsoundStartDetection);
                Picasso.with(this).load(R.drawable.ic_pause_white_24dp).transform(new ColorFilterTransformation(tempcolor1[2])).into(mBitsoundStopDetection);
                break;

            case 2:     //BitsoundShaking
                int[] tempcolor2 = {WHITE,WHITE,WHITE};
                tempcolor2[n] = color;
                Picasso.with(this).load(R.drawable.ic_repeat_white_24dp).transform(new ColorFilterTransformation(tempcolor2[0])).into(mBitsoundRepeatShaking);
                Picasso.with(this).load(R.drawable.ic_play_arrow_white_24dp).transform(new ColorFilterTransformation(tempcolor2[1])).into(mBitsoundEnableShaking);
                Picasso.with(this).load(R.drawable.ic_pause_white_24dp).transform(new ColorFilterTransformation(tempcolor2[2])).into(mBitsoundDisableShaking);
                break;

            case 3:     //BitsoundSmartOn
                int[] tempcolor3 = {WHITE,WHITE,WHITE,WHITE};
                tempcolor3[n] = color;
                Picasso.with(this).load(R.drawable.ic_repeat_white_24dp).transform(new ColorFilterTransformation(tempcolor3[0])).into(mBitsoundRepeatSmartOn);
                Picasso.with(this).load(R.drawable.ic_timer_10_white_24dp).transform(new ColorFilterTransformation(tempcolor3[1])).into(mBitsoundStartSmartOnIn10Sec);
                Picasso.with(this).load(R.drawable.ic_play_arrow_white_24dp).transform(new ColorFilterTransformation(tempcolor3[2])).into(mBitsoundStartSmartOn);
                Picasso.with(this).load(R.drawable.ic_pause_white_24dp).transform(new ColorFilterTransformation(tempcolor3[3])).into(mBitsoundStopSmartOn);
                break;

            case 4:     //BitsoundMisc
                int[] tempcolor4 = {WHITE,WHITE};
                tempcolor4[n] = color;
                Picasso.with(this).load(R.drawable.ic_repeat_white_24dp).transform(new ColorFilterTransformation(tempcolor4[0])).into(mMiscRepeatGetScheduledContents);
                Picasso.with(this).load(R.drawable.ic_repeat_white_24dp).transform(new ColorFilterTransformation(tempcolor4[1])).into(mMiscRepeatSendCustomLogCount);
                break;
        }

    }

}
