package com.tzs.eyepetizer.activity;

import android.os.Bundle;
import android.widget.SeekBar;

import com.google.vr.sdk.widgets.video.VrVideoEventListener;
import com.google.vr.sdk.widgets.video.VrVideoView;
import com.tzs.eyepetizer.R;

import java.io.IOException;

public class PlayVrActivity extends BaseActivity implements SeekBar.OnSeekBarChangeListener {
    String videoPath;
    protected VrVideoView videoWidgetView;

    SeekBar seekBar;
    private boolean isPaused = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_vr);
        initState();

//        videoPath = getIntent().getStringExtra("data0");
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(this);
        videoWidgetView = (VrVideoView) findViewById(R.id.video_view);
        videoWidgetView.setEventListener(new ActivityEventListener());
        VrVideoView.Options options = new VrVideoView.Options();
        options.inputType = VrVideoView.Options.TYPE_STEREO_OVER_UNDER;
        try {
//            videoWidgetView.loadVideo(Uri.parse(videoPath), options);
            videoWidgetView.loadVideoFromAsset("videos/congo.mp4", options);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void onPause() {
        super.onPause();
        videoWidgetView.pauseRendering();
        isPaused = true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        videoWidgetView.resumeRendering();
    }

    @Override
    protected void onDestroy() {
        videoWidgetView.shutdown();
        super.onDestroy();
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        if (fromUser) {
            videoWidgetView.seekTo(progress);
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    private void togglePause() {
        if (isPaused) {
            videoWidgetView.playVideo();
        } else {
            videoWidgetView.pauseVideo();
        }
        isPaused = !isPaused;
    }

    private class ActivityEventListener extends VrVideoEventListener {


        @Override
        public void onLoadSuccess() {
            super.onLoadSuccess();
            seekBar.setMax((int) videoWidgetView.getDuration());
        }

        @Override
        public void onClick() {
            super.onClick();
            togglePause();
        }

        @Override
        public void onNewFrame() {
            super.onNewFrame();
            seekBar.setProgress((int) videoWidgetView.getCurrentPosition());
        }

        @Override
        public void onCompletion() {
            videoWidgetView.seekTo(0);
        }

        @Override
        public void onLoadError(String errorMessage) {
            super.onLoadError(errorMessage);
        }
    }


}
