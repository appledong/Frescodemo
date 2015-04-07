package com.dong.testfresco.activity;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.TextView;

import com.dong.testfresco.R;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.BaseRepeatedPostProcessor;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.imagepipeline.request.Postprocessor;

/**
 * Created by dong on 2015/4/1.
 */
public class ProcessPictureActivity extends ActionBarActivity {

    String test_pic_url = "http://www.33.la/uploads/20140407pic/543.jpg";

    private int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_process);
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) findViewById(R.id.my_image_view);
        simpleDraweeView.setAspectRatio(1.78f);
        Postprocessor redMeshPostprocessor = new Postprocessor() {
            @Override
            public String getName() {
                return "redMeshPostprocessor";
            }

            @Override
            public void process(Bitmap bitmap) {
                for (int x = 0; x < bitmap.getWidth(); x += 2) {
                    for (int y = 0; y < bitmap.getHeight(); y += 2) {
                        bitmap.setPixel(x, y, Color.RED);
                    }
                }
            }
        };
        ImageRequest request = ImageRequestBuilder.newBuilderWithSource(Uri.parse(test_pic_url))
                .setPostprocessor(redMeshPostprocessor)
                .build();
        PipelineDraweeController controller = (PipelineDraweeController) Fresco.newDraweeControllerBuilder()
                .setImageRequest(request)
                .setOldController(simpleDraweeView.getController())
                .build();
        simpleDraweeView.setController(controller);


        SimpleDraweeView simpleDraweeView2 = (SimpleDraweeView) findViewById(R.id.my_image_view2);
        simpleDraweeView2.setAspectRatio(1.78f);
        final MeshPostprocessor meshPostprocessor = new MeshPostprocessor();
        meshPostprocessor.setColor(Color.RED);
        ImageRequest request2 = ImageRequestBuilder.newBuilderWithSource(Uri.parse(test_pic_url))
                .setPostprocessor(meshPostprocessor)
                .build();
        PipelineDraweeController controller2 = (PipelineDraweeController) Fresco.newDraweeControllerBuilder()
                .setImageRequest(request2)
                .setOldController(simpleDraweeView2.getController())
                .build();
        simpleDraweeView2.setController(controller2);
        findViewById(R.id.textview_process).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(i % 2 == 0){
                    meshPostprocessor.setColor(Color.BLUE);
                } else if(i % 2 == 1){
                    meshPostprocessor.setColor(Color.RED);
                }
                i++;
            }
        });
    }

    class MeshPostprocessor extends BaseRepeatedPostProcessor {
        private int mColor = Color.TRANSPARENT;

        public void setColor(int color) {
            mColor = color;
            update();
        }

        @Override
        public String getName() {
            return "meshPostprocessor";
        }

        @Override
        public void process(Bitmap bitmap) {
            for (int x = 0; x < bitmap.getWidth(); x+=2) {
                for (int y = 0; y < bitmap.getHeight(); y+=2) {
                    bitmap.setPixel(x, y, mColor);
                }
            }
        }
    }


}
