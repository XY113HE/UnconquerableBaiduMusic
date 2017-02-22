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

import com.huoer.unconquerablebaidumusic.R;

public class MusicRecommendViewPagerAdapter extends PagerAdapter {
    private static final String TAG = "MusicRecommendViewPager";
    private int[] imgIds;
    private Context context;

    public void setContext(Context context) {
        this.context = context;
    }

    public void setImgIds(int[] imgIds) {
        this.imgIds = imgIds;
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
        position%=imgIds.length;
        if (position<0){
            position = imgIds.length+position;

        }
        View view = LayoutInflater.from(context).inflate(R.layout.item_music_pk_viewpager,container,false);
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_item_music_pk_circleimg);
        imageView.setImageResource(imgIds[position]);

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
