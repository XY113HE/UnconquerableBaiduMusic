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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

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
