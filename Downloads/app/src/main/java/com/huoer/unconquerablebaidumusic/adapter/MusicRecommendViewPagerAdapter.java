package com.huoer.unconquerablebaidumusic.adapter;
/*
         |              |
         | \            | \
         |   | | | | | |    | | | | |||||\
         |                          |||||||\
         |         ( )              ||||||||
         |                           |||||/
         |                  | | | | | |||/
         |    |             |          |
         |    |             |          |
       / |   | |            |          |\
      |      |/             |          \|
       \ |                  |
         |                  |
           \ | | | | | | | /
             |       |            <-----辣鸡
             |       |
              |       |
*/

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.huoer.unconquerablebaidumusic.R;
import com.huoer.unconquerablebaidumusic.bean.MusicRecommendCircleBean;

import java.util.List;

public class MusicRecommendViewPagerAdapter extends PagerAdapter {
    private static final String TAG = "MusicRecommendViewPager";
    private Context context;
    private List<MusicRecommendCircleBean.PicBean> picBeanList;

    public void setPicBeanList(List<MusicRecommendCircleBean.PicBean> picBeanList) {
        this.picBeanList = picBeanList;
        notifyDataSetChanged();
    }

    public void setContext(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        position%=picBeanList.size();
        if (position<0){
            position = picBeanList.size()+position;

        }
        View view = LayoutInflater.from(context).inflate(R.layout.item_music_pk_viewpager,container,false);
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_item_music_pk_circleimg);
        Glide.with(context).load(picBeanList.get(position).getRandpic()).into(imageView);

        //将父容器中删除当前视图。
        ViewParent vp = view.getParent();
        if (vp!=null){
            ViewGroup viewGroup = (ViewGroup) vp;
            viewGroup.removeView(view);

        }
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

    }
}
