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
import android.content.pm.LabeledIntent;
import android.graphics.Bitmap;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.huoer.unconquerablebaidumusic.R;

public class MusicRecommendListViewTodayAdapter extends BaseAdapter {
    private Context context;
    private int dataSize = 3;

    public void setContext(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return dataSize;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TodayViewHolder holder = null;
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_music_recommend_listview_today, parent, false);
            holder = new TodayViewHolder(convertView);
            convertView.setTag(holder);
        }else{
            holder = (TodayViewHolder) convertView.getTag();
        }

        //TODO  具体数据的设置
        final TodayViewHolder finalHolder = holder;
        Glide.with(context).load("http://g.hiphotos.baidu.com/zhidao/wh%3D450%2C600/sign=4c33f1b70dd162d985bb6a1824ef85da/5366d0160924ab18d9105e4432fae6cd7b890bba.jpg").asBitmap().centerCrop().into(new BitmapImageViewTarget(finalHolder.bg) {
            @Override
            protected void setResource(Bitmap resource) {
                RoundedBitmapDrawable circularBitmapDrawable =
                        RoundedBitmapDrawableFactory.create(context.getResources(), resource);
                circularBitmapDrawable.setCircular(true);
                finalHolder.bg.setImageDrawable(circularBitmapDrawable);
            }
        });
        return convertView;
    }

    class TodayViewHolder{
        ImageView bg;
        TextView songName, author;
        TodayViewHolder(View itemview){
            bg = (ImageView) itemview.findViewById(R.id.iv_item_music_recommend_listview_today_bg);
            songName = (TextView) itemview.findViewById(R.id.tv_item_music_recommend_listview_today_songname);
            author = (TextView) itemview.findViewById(R.id.tv_item_music_recommend_listview_today_author);

        }
    }
}
