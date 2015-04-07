package com.dong.testfresco.activity;

import android.app.ActionBar;
import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.dong.testfresco.R;
import com.dong.testfresco.bean.ListItemBean;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeController;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by dong on 2015/4/1.
 */
public class ListPictureActivity extends ActionBarActivity {

    private ListView listview_list;

    private MyAdapter myAdapter;

    private String[] strs_low = new String[]{"http://img4.imgtn.bdimg.com/it/u=3589021438,306361626&fm=11&gp=0.jpg",
            "http://img5.imgtn.bdimg.com/it/u=1506628446,2429934413&fm=21&gp=0.jpg",
            "http://img1.imgtn.bdimg.com/it/u=497951025,587626012&fm=21&gp=0.jpg",
            "http://img5.imgtn.bdimg.com/it/u=456863051,2879777712&fm=21&gp=0.jpg",
            "http://img1.imgtn.bdimg.com/it/u=342785128,10955163&fm=21&gp=0.jpg",
            "http://img3.imgtn.bdimg.com/it/u=3364993285,3370685394&fm=21&gp=0.jpg"
            , "http://img5.imgtn.bdimg.com/it/u=3975589649,3324489520&fm=21&gp=0.jpg",
            "http://img5.imgtn.bdimg.com/it/u=774506393,1315869486&fm=21&gp=0.jpg",
            "http://img2.imgtn.bdimg.com/it/u=612575731,1753194199&fm=21&gp=0.jpg",
            "http://img5.imgtn.bdimg.com/it/u=1586003749,2234739244&fm=21&gp=0.jpg",
            "http://img0.imgtn.bdimg.com/it/u=1354062101,4158260729&fm=21&gp=0.jpg",
            "http://img2.imgtn.bdimg.com/it/u=3917446324,2344054778&fm=21&gp=0.jpg",
            "http://img5.imgtn.bdimg.com/it/u=2936762312,3092039467&fm=21&gp=0.jpg",
            "http://img0.imgtn.bdimg.com/it/u=3870518936,348773740&fm=21&gp=0.jpg",
            "http://img2.imgtn.bdimg.com/it/u=2167088298,770998388&fm=21&gp=0.jpg",
            "http://img5.imgtn.bdimg.com/it/u=2709591341,1319490234&fm=21&gp=0.jpg",
            "http://img5.imgtn.bdimg.com/it/u=520870309,2653747138&fm=21&gp=0.jpg",
            "http://img1.imgtn.bdimg.com/it/u=3690111559,1123046272&fm=21&gp=0.jpg",
            "http://img4.imgtn.bdimg.com/it/u=1549720149,3657579959&fm=21&gp=0.jpg",
            "http://img5.imgtn.bdimg.com/it/u=1739178120,1574105585&fm=21&gp=0.jpg",
            "http://img2.imgtn.bdimg.com/it/u=658013272,2981752822&fm=21&gp=0.jpg"};

    private String[] strs_high = new String[]{"http://image.cnpp.cn/upload/images/20150306/15053757907_1921x1200.jpg",
            "http://h.hiphotos.baidu.com/zhidao/pic/item/9358d109b3de9c82b6acf33f6d81800a18d843b0.jpg",
            "http://www.daimg.com/uploads/allimg/120607/3-12060GJ414944.jpg",
            "http://img.taopic.com/uploads/allimg/110811/1419-110Q110121166.jpg",
            "http://www.siweiw.com/Upload/sy/2013616/20136161824820.jpg",
            "http://img.taopic.com/uploads/allimg/110604/2239-1106041G44030.jpg"
            , "http://h.hiphotos.baidu.com/zhidao/pic/item/83025aafa40f4bfb6446f966024f78f0f7361869.jpg",
            "http://picm.bbzhi.com/jingxuanbizhi/1680x1050gaoqingbizhi/1680x1050gaoqingbizhi_351095_m.jpg",
            "http://pic8.nipic.com/20100806/3320946_081916086188_2.jpg",
            "http://img.taopic.com/uploads/allimg/110123/292-11012313453429.jpg",
            "http://pic8.nipic.com/20100728/4800623_123729985383_2.jpg",
            "http://image.tianjimedia.com/uploadImages/2013/009/A94R3WF07KX4_1600x900.jpg",
            "http://h.hiphotos.baidu.com/zhidao/pic/item/024f78f0f736afc3f6316d5fb119ebc4b74512ce.jpg",
            "http://img.daimg.com/uploads/allimg/120712/3-120g2194250.jpg",
            "http://img.taopic.com/uploads/allimg/110603/53-110603194T559.jpg",
            "http://img.sc115.com/uploads/sc/120419/2012041920421276.jpg",
            "http://img.taopic.com/uploads/allimg/110104/292-11010410531619.jpg",
            "http://pic9.nipic.com/20100824/2531170_082436959168_2.jpg",
            "http://www.qqpk.cn/picture/Files/201406/2014062521524370.jpg",
            "http://pic4.nipic.com/20091126/3823863_155326024216_2.jpg",
            "http://image.tianjimedia.com/uploadImages/2009/333/20091129180531537.jpg"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        listview_list = (ListView) findViewById(R.id.listview_list);
        myAdapter = new MyAdapter();
        listview_list.setAdapter(myAdapter);
        LinkedList<ListItemBean> lists = new LinkedList<ListItemBean>();
        for (int i = 0; i < 21; i++) {
            ListItemBean listitembean = new ListItemBean();
            listitembean.test_pic_low = strs_low[i];
            listitembean.test_pic_high = strs_high[i];
            lists.add(listitembean);
        }
        myAdapter.addItems(lists);
    }

    class MyAdapter extends BaseAdapter {

        public MyAdapter() {
        }

        private List<ListItemBean> list;

        public void addItems(List<ListItemBean> list) {
            this.list = list;
            notifyDataSetChanged();
        }

        @Override
        public int getCount() {
            if (list != null && list.size() > 0) {
                return list.size();
            }
            return 0;
        }

        @Override
        public ListItemBean getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            SimpleDraweeView simpleDraweeView = null;
            if (convertView == null) {
                simpleDraweeView = new SimpleDraweeView(ListPictureActivity.this);
                simpleDraweeView.setAspectRatio(1.78f);
                GenericDraweeHierarchy hierarchy = new GenericDraweeHierarchyBuilder(getResources())
                        .setPlaceholderImage(getResources().getDrawable(R.drawable.bk_low), ScalingUtils.ScaleType.CENTER_CROP).build();
                simpleDraweeView.setHierarchy(hierarchy);
                simpleDraweeView.setPadding(30, 30, 30, 30);
            } else {
                simpleDraweeView = (SimpleDraweeView) convertView;
            }
            Log.e("dongdianzhou","simpleDraweeView.getWidth():" + simpleDraweeView.getWidth() + "simpleDraweeView.getHeight():" + simpleDraweeView.getHeight());
            simpleDraweeView.setLayoutParams(new AbsListView.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT, AbsListView.LayoutParams.WRAP_CONTENT));
            ListItemBean listItemBean = list.get(position);
            ImageRequest imageRequest = ImageRequestBuilder.newBuilderWithSource(Uri.parse(listItemBean.test_pic_high))
                    .setResizeOptions(new ResizeOptions(1280, 720))
                    .build();
            PipelineDraweeController controller = (PipelineDraweeController) Fresco.newDraweeControllerBuilder()
                    .setLowResImageRequest(ImageRequest.fromUri(Uri.parse(listItemBean.test_pic_low)))
                    .setImageRequest(imageRequest)
                    .setOldController(simpleDraweeView.getController())
                    .build();
            simpleDraweeView.setController(controller);
            return simpleDraweeView;
        }
    }


}
