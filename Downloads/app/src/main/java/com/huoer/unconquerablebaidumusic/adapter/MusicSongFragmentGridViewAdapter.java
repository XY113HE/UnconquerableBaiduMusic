package com.huoer.unconquerablebaidumusic.adapter;/*
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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.huoer.unconquerablebaidumusic.R;

public class MusicSongFragmentGridViewAdapter extends BaseAdapter{

    private Context context;
    private int dataSize = 20;
    private final int NORMAL_VIEW = 0, BOTTOM_VIEW = 1;


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
        SongViewHolder songViewHolder = null;
        BottomViewHolder bottomViewHolder = null;
        if(convertView == null){
            switch (getItemViewType(position)){
                case NORMAL_VIEW:
                    convertView = LayoutInflater.from(context).inflate(R.layout.item_music_song_gridview, parent, false);
                    songViewHolder = new SongViewHolder(convertView);
                    convertView.setTag(songViewHolder);
                    break;
                case BOTTOM_VIEW:
                    convertView = LayoutInflater.from(context).inflate(R.layout.item_bottom_view, parent, false);
                    bottomViewHolder = new BottomViewHolder(convertView);
                    convertView.setTag(bottomViewHolder);
                    break;
            }
        } else{
            switch (getItemViewType(position)){
                case NORMAL_VIEW:
                    songViewHolder = (SongViewHolder) convertView.getTag();
                    break;
                case BOTTOM_VIEW:
                    bottomViewHolder = (BottomViewHolder) convertView.getTag();
                    break;
            }
        }
        switch (getItemViewType(position)){
            case NORMAL_VIEW:
                //TODO 具体数据设置
                break;
            case BOTTOM_VIEW:
                break;
        }

        return convertView;
    }

    class SongViewHolder{
        ImageView bg;
        TextView songAmount, title, author;
        SongViewHolder(View v){
            bg = (ImageView) v.findViewById(R.id.iv_item_music_song_gridview_bg);
            songAmount = (TextView) v.findViewById(R.id.tv_item_music_song_gridview_listen_amount);
            title = (TextView) v.findViewById(R.id.tv_item_music_song_gridview_title);
            author = (TextView) v.findViewById(R.id.tv_item_music_song_gridview_listen_amount);
        }
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        if(position == dataSize-1 || position == dataSize-2){
            return BOTTOM_VIEW;
        }else{
            return NORMAL_VIEW;
        }
    }

    class BottomViewHolder{
        BottomViewHolder(View v){

        }
    }
}
