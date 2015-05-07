package com.dong.testfresco.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ImageView;

import com.dong.testfresco.R;

import uk.co.senab.photoview.PhotoView;

/**
 * Created by dong on 2015/4/1.
 */
public class PhotoviewPictureActivity extends ActionBarActivity {

    private String test_url = "http://img.daimg.com/uploads/allimg/120225/3-120225130605612.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);
        PhotoView frescoImageView = (PhotoView) findViewById(R.id.frescoImageView_test);
        frescoImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        frescoImageView.setImageUrl(test_url, 1080, 1920);
    }

    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }
}
