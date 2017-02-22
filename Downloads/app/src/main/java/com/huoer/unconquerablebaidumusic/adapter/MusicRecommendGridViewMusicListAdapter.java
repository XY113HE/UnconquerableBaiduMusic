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
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.huoer.unconquerablebaidumusic.R;

public class MusicRecommendGridViewMusicListAdapter extends BaseAdapter {
    private int dataSize = 6;
    private Context context;

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
        MusicListViewHolder holder = null;
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_music_recommend_gridview_musilist, parent, false);
            holder = new MusicListViewHolder(convertView);
            convertView.setTag(holder);
        }else{
            holder = (MusicListViewHolder) convertView.getTag();
        }
        //TODO 具体数据在视图上的设置
        return convertView;
    }

    class MusicListViewHolder{
        ImageView bg;
        TextView amount, title;
        MusicListViewHolder(View itemview){
            bg = (ImageView) itemview.findViewById(R.id.iv_item_music_recommend_gridview_musiclist_bg);
            amount = (TextView) itemview.findViewById(R.id.tv_item_music_recommend_gridview_musiclist_listen_amount);
            title = (TextView) itemview.findViewById(R.id.tv_item_music_recommend_gridview_musiclist_title);
        }

    }
}
