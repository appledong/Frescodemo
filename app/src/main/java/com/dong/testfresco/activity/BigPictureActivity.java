package com.dong.testfresco.activity;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import com.dong.testfresco.R;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

/**
 * Created by dong on 2015/4/1.
 */
public class BigPictureActivity extends ActionBarActivity {
    String test_pic_url_low = "http://img3.imgtn.bdimg.com/it/u=2872301667,392316348&fm=23&gp=0.jpg";
    String test_pic_url_high = "http://cdn.wall88.com/51a608a0b386977146.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_big);
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) findViewById(R.id.my_image_view);
        simpleDraweeView.setAspectRatio(1.78f);
         PipelineDraweeController controller = (PipelineDraweeController) Fresco.newDraweeControllerBuilder()
                .setLowResImageRequest(ImageRequest.fromUri(Uri.parse(test_pic_url_low)))
                .setImageRequest(ImageRequest.fromUri(Uri.parse(test_pic_url_high)))
                .setOldController(simpleDraweeView.getController())
                .build();
        simpleDraweeView.setController(controller);
    }


}
