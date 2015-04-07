package com.dong.testfresco.activity;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;

import com.dong.testfresco.R;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeController;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.imagepipeline.decoder.ProgressiveJpegConfig;
import com.facebook.imagepipeline.image.ImmutableQualityInfo;
import com.facebook.imagepipeline.image.QualityInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

/**
 * Created by dong on 2015/4/1.
 */
public class JpgPictureActivity extends ActionBarActivity {

    String test_pic_url = "http://img1.qq.com/gamezone/pics/13806/13806700.jpg";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jpg);
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) findViewById(R.id.my_image_view);
        simpleDraweeView.setAspectRatio(1.78f);
        ImageRequest request = ImageRequestBuilder
                .newBuilderWithSource(Uri.parse(test_pic_url))
                .setProgressiveRenderingEnabled(true)
                .build();
        PipelineDraweeController controller = (PipelineDraweeController) Fresco.newDraweeControllerBuilder()
                .setImageRequest(request)
                .setOldController(simpleDraweeView.getController())
                .build();
        simpleDraweeView.setController(controller);
    }


}
