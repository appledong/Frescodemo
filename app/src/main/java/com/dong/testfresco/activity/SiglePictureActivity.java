package com.dong.testfresco.activity;

import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;

import com.dong.testfresco.R;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

import javax.annotation.Nullable;

/**
 * Created by dong on 2015/4/1.
 */
public class SiglePictureActivity extends ActionBarActivity {

    String test_pic_url = "http://www.sucaifengbao.com/uploadfile/photo/meinvtupianbizhi/meinvtupianbizhi_813_036.jpg";

    String test_pic_url2 = "http://image.tianjimedia.com/uploadImages/2014/282/50/F35XBP96JTQ5.jpg";

    String test_pic_url3 = "http://cdn.wall88.com/51aa2dbbebd3519627.jpg";

    String test_pic_gif = "http://hz.focus.cn/upload/photos/130032/JvUtiTwR.gif";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("dongdianzhou", "onCreate+++++++++++++++++++++++++++");
        setContentView(R.layout.activity_sigle);
        /************************************ 设置view的宽高比 *********************************/
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) findViewById(R.id.my_image_view);
        simpleDraweeView.setAspectRatio(1.78f);
        simpleDraweeView.setImageURI(Uri.parse(test_pic_url));
        /************************************ 设置view的宽高比 *********************************/
        /************************************ 设置view的加载动画 *********************************/
        SimpleDraweeView simpleDraweeView2 = (SimpleDraweeView) findViewById(R.id.my_image_view2);
        simpleDraweeView2.setAspectRatio(1.78f);
        int sigleposition = getIntent().getIntExtra("sigleposition", 0);
        if (sigleposition == 0) {
            simpleDraweeView2.setImageURI(Uri.parse(test_pic_url));
        } else if (sigleposition == 1) {
            simpleDraweeView2.setImageURI(Uri.parse(test_pic_url2));
        }
        /************************************ 设置view的加载动画 *********************************/
        /************************************ 设置view的scaltype *********************************/
        SimpleDraweeView simpleDraweeView3 = (SimpleDraweeView) findViewById(R.id.my_image_view3);
        simpleDraweeView3.setImageURI(Uri.parse(test_pic_url));
        simpleDraweeView3.getHierarchy().setActualImageFocusPoint(new PointF(300, 200));
        SimpleDraweeView simpleDraweeView4 = (SimpleDraweeView) findViewById(R.id.my_image_view4);
        simpleDraweeView4.setImageURI(Uri.parse(test_pic_url));
        simpleDraweeView4.getHierarchy().setActualImageFocusPoint(new PointF(800, 700));
        SimpleDraweeView simpleDraweeView5 = (SimpleDraweeView) findViewById(R.id.my_image_view5);
        simpleDraweeView5.setImageURI(Uri.parse(test_pic_url));
        /************************************ 设置view的scaltype *********************************/
        /************************************ 设置view的展位图进度条 *********************************/
        SimpleDraweeView simpleDraweeView6 = (SimpleDraweeView) findViewById(R.id.my_image_view6);
        simpleDraweeView6.setImageURI(Uri.parse("http://image.tianjimedia.com/uploadImages/2014/282/50/F35XBP96JTQ5.png"));//
        /************************************ 设置view的展位图进度条 *********************************/
        /************************************ 设置view的覆盖层 *********************************/
        SimpleDraweeView simpleDraweeView7 = (SimpleDraweeView) findViewById(R.id.my_image_view7);
        simpleDraweeView7.setAspectRatio(1.78f);
        simpleDraweeView7.setImageURI(Uri.parse(test_pic_url));
        /************************************ 设置view的覆盖层 *********************************/
        /************************************ 设置view的按下覆盖层 *********************************/
        /*SimpleDraweeView simpleDraweeView8 = (SimpleDraweeView) findViewById(R.id.my_image_view8);
        simpleDraweeView8.setAspectRatio(1.78f);
        simpleDraweeView8.setImageURI(Uri.parse(test_pic_url));*/
        /************************************ 设置view的按下覆盖层 *********************************/

        /************************************ 设置view的圆角 *********************************/
        SimpleDraweeView simpleDraweeView9 = (SimpleDraweeView) findViewById(R.id.my_image_view9);
        simpleDraweeView9.setAspectRatio(1.78f);
        simpleDraweeView9.setImageURI(Uri.parse(test_pic_url));
        /************************************ 设置view的圆角 *********************************/
        /************************************ 设置view的圆角 *********************************/
        SimpleDraweeView simpleDraweeView10 = (SimpleDraweeView) findViewById(R.id.my_image_view10);
        simpleDraweeView10.setAspectRatio(1.78f);
        simpleDraweeView10.setImageURI(Uri.parse(test_pic_url));
        /************************************ 设置view的圆角 *********************************/
        /************************************ 设置view的圆角 *********************************/
        SimpleDraweeView simpleDraweeView11 = (SimpleDraweeView) findViewById(R.id.my_image_view11);
        simpleDraweeView11.setAspectRatio(1.78f);
        simpleDraweeView11.setImageURI(Uri.parse(test_pic_url));
        /************************************ 设置view的圆角 *********************************/
        /************************************ 设置view的圆角 *********************************/
        SimpleDraweeView simpleDraweeView12 = (SimpleDraweeView) findViewById(R.id.my_image_view12);
        simpleDraweeView12.setAspectRatio(1.78f);
        simpleDraweeView12.setImageURI(Uri.parse(test_pic_url));
        /************************************ 设置view的圆角 *********************************/
        /************************************ 设置view的重新加载 *********************************/
        SimpleDraweeView simpleDraweeView13 = (SimpleDraweeView) findViewById(R.id.my_image_view13);
        simpleDraweeView13.setAspectRatio(1.78f);
        ControllerListener controllerListener = new ControllerListener() {
            /**
             * 图片提交的时候会被调用
             * @param s
             * @param o
             */
            @Override
            public void onSubmit(String s, Object o) {
                Log.e("dongdianzhou", "onSubmit+++++++++++++++++++");
            }

            /**
             * 图片加载成功的时候被调用
             * @param s
             * @param o
             * @param animatable
             */
            @Override
            public void onFinalImageSet(String s, @Nullable Object o, @Nullable Animatable animatable) {
                Log.e("dongdianzhou", "onFinalImageSet+++++++++++++++++++");
            }

            /**
             * 图片扫描加载的时候扫描成功会调用这个回调
             * @param s
             * @param o
             */
            @Override
            public void onIntermediateImageSet(String s, @Nullable Object o) {
                Log.e("dongdianzhou", "onIntermediateImageSet+++++++++++++++++++");
            }

            /**
             * 图片扫描加载的时候扫描失败会调用这个回调
             * @param s
             * @param throwable
             */
            @Override
            public void onIntermediateImageFailed(String s, Throwable throwable) {
                Log.e("dongdianzhou", "onIntermediateImageFailed+++++++++++++++++++");
            }

            /***
             * 加载失败的时候调用，后面失败的原因
             * @param s
             * @param throwable
             */
            @Override
            public void onFailure(String s, Throwable throwable) {
                Log.e("dongdianzhou", "onFailure+++++++++++++++++++");
            }

            @Override
            public void onRelease(String s) {
                Log.e("dongdianzhou", "onRelease+++++++++++++++++++");
            }
        };
        DraweeController controllerBuilder = Fresco.newDraweeControllerBuilder()
                .setUri(Uri.parse("http://"))
                .setTapToRetryEnabled(true)
                .setOldController(simpleDraweeView13.getController())
                .setControllerListener(controllerListener).build();
        GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder = new GenericDraweeHierarchyBuilder(getResources());
        GenericDraweeHierarchy genericDraweeHierarchy = genericDraweeHierarchyBuilder
                .setRetryImage(getResources().getDrawable(R.drawable.error), ScalingUtils.ScaleType.CENTER_CROP)
                .build();
        simpleDraweeView13.setHierarchy(genericDraweeHierarchy);//对于同一个view,不要反复的设置，需要修改属性参数的时候读取修改即可
        simpleDraweeView13.setController(controllerBuilder);
        /************************************ 设置view的重新加载  *********************************/
        /************************************ 设置view加载gif图片 *********************************/
        SimpleDraweeView simpleDraweeView14 = (SimpleDraweeView) findViewById(R.id.my_image_view14);
        simpleDraweeView14.setAspectRatio(1.78f);
        ImageRequest imageRequest = ImageRequestBuilder.newBuilderWithSource(Uri.parse(test_pic_gif))
                .build();
        DraweeController draweeController = Fresco.newDraweeControllerBuilder()
                .setOldController(simpleDraweeView14.getController())
                .setImageRequest(imageRequest)
//                .setAutoPlayAnimations(true) //可以在此直接设置播放gif，设置以后下面无需再监听
                .setControllerListener(new BaseControllerListener<ImageInfo>() {
                    @Override
                    public void onFinalImageSet(String id, @Nullable ImageInfo imageInfo, @Nullable Animatable animatable) {
                        if (animatable != null && !animatable.isRunning()) {
                            animatable.start();
                        }
                    }
                }).build();
        simpleDraweeView14.setController(draweeController);
        /*Animatable animatable = simpleDraweeView14.getController().getAnimatable();
        if(animatable != null){
            animatable.
        }*/// 在外面可以获取到gif动画进行操作
        /************************************ 设置view加载gif图片 *********************************/
        /************************************ 设置view Colorfiter *********************************/
        SimpleDraweeView simpleDraweeView15 = (SimpleDraweeView) findViewById(R.id.my_image_view15);
        simpleDraweeView15.setAspectRatio(1.78f);
        simpleDraweeView15.setColorFilter(Color.GREEN);
//        simpleDraweeView15.setColorFilter(Color.GREEN,PorterDuff.Mode.SRC_OUT);
//        GenericDraweeHierarchy genericDraweeHierarchy1 = null;
//        ColorFilter filter = new Launche
//        filter.
//        genericDraweeHierarchy1.setActualImageColorFilter();
//        simpleDraweeView15.setHierarchy();
        simpleDraweeView15.setImageURI(Uri.parse(test_pic_url));
        /************************************ 设置view Colorfiter  *********************************/
        /************************************ 设置view 重定义大小 *********************************/
        SimpleDraweeView simpleDraweeView16 = (SimpleDraweeView) findViewById(R.id.my_image_view16);
//        simpleDraweeView16.setAspectRatio(1.78f);
        int width = 240, height = 426;
        ResizeOptions resizeOptions = new ResizeOptions(width, height);
        ImageRequest imageRequest1 = ImageRequestBuilder.newBuilderWithSource(Uri.parse(test_pic_url))
                .setResizeOptions(resizeOptions)
                .setAutoRotateEnabled(true)//设置可以自动旋转，可以解决三星手机的拍照方向问题
                .build();
        DraweeController draweeController1 = Fresco.newDraweeControllerBuilder()
                .setOldController(simpleDraweeView16.getController())
                .setImageRequest(imageRequest1).build();
        simpleDraweeView16.setController(draweeController1);//1. 仅支持jpg格式2. 此处的缩放只是降低了图片的内存占用和显示样式无关，显示样式和scaltype有关
//        simpleDraweeView16.setImageURI(Uri.parse(test_pic_url));
        /************************************ 设置view 重定义大小  *********************************/
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
