package com.dong.testfresco;

import android.app.Application;
import android.util.Log;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.imagepipeline.decoder.ProgressiveJpegConfig;
import com.facebook.imagepipeline.image.ImmutableQualityInfo;
import com.facebook.imagepipeline.image.QualityInfo;

/**
 * Created by dong on 2015/4/1.
 */
public class ImageApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ProgressiveJpegConfig pjpegConfig = new ProgressiveJpegConfig() {
            @Override
            public int getNextScanNumberToDecode(int scanNumber) {
                Log.e("dongdianzhou", "getNextScanNumberToDecode:scanNumber+++" + scanNumber);
                return scanNumber + 1;
            }

            public QualityInfo getQualityInfo(int scanNumber) {
                Log.e("dongdianzhou","getQualityInfo:scanNumber+++" + scanNumber);
                boolean isGoodEnough = (scanNumber >= 0);
                return ImmutableQualityInfo.of(scanNumber, isGoodEnough, false);
            }
        };
        ImagePipelineConfig config = ImagePipelineConfig.newBuilder(this)
                .setProgressiveJpegConfig(pjpegConfig)
//                .set //多种配置设置，内存大小，disk存储大小等，参考文档
                .build();
        Fresco.initialize(getApplicationContext(), config);
//        Fresco.initialize(getApplicationContext());
    }
}
