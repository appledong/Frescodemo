package com.dong.testfresco.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.dong.testfresco.R;


public class MainActivity extends ActionBarActivity {

    private Context mContext;

    private int sigleposition = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.textview_list).setOnClickListener(l);
        findViewById(R.id.textview_photoview).setOnClickListener(l);
        findViewById(R.id.textview_sigle).setOnClickListener(l);
        findViewById(R.id.textview_jpg).setOnClickListener(l);
        findViewById(R.id.textview_progress).setOnClickListener(l);
        findViewById(R.id.textview_daxiao).setOnClickListener(l);
        mContext = this;
    }

    View.OnClickListener l = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent();
            int id = view.getId();
            switch (id) {
                case R.id.textview_list:
                    intent.setClass(mContext, ListPictureActivity.class);
                    break;
                case R.id.textview_photoview:
                    intent.setClass(mContext, PhotoviewPictureActivity.class);
                    break;
                case R.id.textview_jpg:
                    intent.setClass(mContext, JpgPictureActivity.class);
                    break;
                case R.id.textview_progress:
                    intent.setClass(mContext, ProcessPictureActivity.class);
                    break;
                case R.id.textview_daxiao:
                    intent.setClass(mContext, BigPictureActivity.class);
                    break;
                case R.id.textview_sigle:
                    intent.putExtra("sigleposition", sigleposition % 2);
                    intent.setClass(mContext, SiglePictureActivity.class);
                    sigleposition++;
                    break;
            }
            startActivity(intent);
        }
    };


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
