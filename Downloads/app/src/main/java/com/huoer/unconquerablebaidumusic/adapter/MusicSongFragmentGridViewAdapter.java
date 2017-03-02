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
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.huoer.unconquerablebaidumusic.R;

public class MusicSongFragmentGridViewAdapter extends BaseAdapter {
    private static final String TAG = "MusicSongFragmentGridVi";

    private Context context;
    private int dataSize = 20;
    private final int NORMAL_VIEW_LEFT = 0, NORMAL_VIEW_RIGHT = 1,
            BOTTOM_VIEW = 2, HEAD_VIEW = 3;
    private int dataType = 1;

    public void setDataType(int dataType) {
        this.dataType = dataType;
        notifyDataSetChanged();
    }

    public void setContext(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return dataSize+2;
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
        SongLeftViewHolder songLeftViewHolder = null;
        SongRightViewHolder songRightViewHolder = null;
        BottomViewHolder bottomViewHolder = null;
        if (convertView == null) {
            switch (getItemViewType(position)) {
                case NORMAL_VIEW_LEFT:
                    convertView = LayoutInflater.from(context).inflate(R.layout.item_music_song_gridview_left, parent, false);
                    songLeftViewHolder = new SongLeftViewHolder(convertView);
                    convertView.setTag(songLeftViewHolder);
                    break;
                case NORMAL_VIEW_RIGHT:
                    convertView = LayoutInflater.from(context).inflate(R.layout.item_music_song_gridview_right, parent, false);
                    songRightViewHolder = new SongRightViewHolder(convertView);
                    convertView.setTag(songRightViewHolder);
                    break;
                case BOTTOM_VIEW:
                    convertView = LayoutInflater.from(context).inflate(R.layout.item_bottom_view, parent, false);
                    bottomViewHolder = new BottomViewHolder(convertView);
                    convertView.setTag(bottomViewHolder);
                    break;
                case HEAD_VIEW:
                    convertView = LayoutInflater.from(context).inflate(R.layout.item_bottom_view, parent, false);

                    break;
            }
        } else {
            switch (getItemViewType(position)) {
                case NORMAL_VIEW_LEFT:
                    songLeftViewHolder = (SongLeftViewHolder) convertView.getTag();
                    break;
                case NORMAL_VIEW_RIGHT:
                    songRightViewHolder = (SongRightViewHolder) convertView.getTag();
                    break;
                case BOTTOM_VIEW:
                    bottomViewHolder = (BottomViewHolder) convertView.getTag();
                    break;
                case HEAD_VIEW:
                    break;
            }
        }
        int bgColor = dataType == 0 ? Color.parseColor("#c5efb1")
                    : Color.parseColor("#ecd2d2");

        switch (getItemViewType(position)) {

            case NORMAL_VIEW_LEFT:
                //TODO 具体数据设置
                songLeftViewHolder.bg.setBackgroundColor(bgColor);
                break;
            case NORMAL_VIEW_RIGHT:
                songRightViewHolder.bg.setBackgroundColor(bgColor);
                break;
            case BOTTOM_VIEW:
                break;
            case HEAD_VIEW:
                break;
        }

        return convertView;
    }

    class SongLeftViewHolder {
        ImageView bg;
        TextView songAmount, title, author;

        SongLeftViewHolder(View v) {
            bg = (ImageView) v.findViewById(R.id.iv_item_music_song_gridview_bg);
            songAmount = (TextView) v.findViewById(R.id.tv_item_music_song_gridview_listen_amount);
            title = (TextView) v.findViewById(R.id.tv_item_music_song_gridview_title);
            author = (TextView) v.findViewById(R.id.tv_item_music_song_gridview_listen_amount);
        }
    }

    class SongRightViewHolder {
        ImageView bg;
        TextView songAmount, title, author;

        SongRightViewHolder(View v) {
            bg = (ImageView) v.findViewById(R.id.iv_item_music_song_gridview_bg);
            songAmount = (TextView) v.findViewById(R.id.tv_item_music_song_gridview_listen_amount);
            title = (TextView) v.findViewById(R.id.tv_item_music_song_gridview_title);
            author = (TextView) v.findViewById(R.id.tv_item_music_song_gridview_listen_amount);
        }
    }

    @Override
    public int getViewTypeCount() {
        return 4;
    }

    @Override
    public int getItemViewType(int position) {
        if(position == 0 || position == 1){
            return HEAD_VIEW;
        }else if (position == dataSize + 1 || position == dataSize) {
            return BOTTOM_VIEW;
        } else if (position % 2 == 0) {
            return NORMAL_VIEW_LEFT;
        } else {
            return NORMAL_VIEW_RIGHT;
        }
    }

    class BottomViewHolder {
        BottomViewHolder(View v) {

        }
    }
}
