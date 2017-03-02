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
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.huoer.unconquerablebaidumusic.R;

public class MusicMovieFragmentGridViewAdapter extends BaseAdapter {
    private Context context;
    private int dataSize = 20;
    private int dataType;
    private final int HEAD_VIEW = 0, NORMAL_VIEW_LEFT = 1, NORMAL_VIEW_RIGHT = 2, BOTTOM_VIEW = 3;

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

        MovieViewHolderLeft movieViewHolderLeft = null;
        MovieViewHolderRight movieViewHolderRight = null;
        BottomViewHolder bottomViewHolder = null;


        if (convertView == null) {
            switch (getItemViewType(position)){
                case HEAD_VIEW:
                    convertView = LayoutInflater.from(context).inflate(R.layout.item_bottom_view, parent, false);

                    break;
                case NORMAL_VIEW_RIGHT:
                    convertView = LayoutInflater.from(context).inflate(R.layout.item_music_movie_gridview_right, parent, false);
                    movieViewHolderRight = new MovieViewHolderRight(convertView);
                    convertView.setTag(movieViewHolderRight);
                    break;
                case NORMAL_VIEW_LEFT:
                    convertView = LayoutInflater.from(context).inflate(R.layout.item_music_movie_gridview_left, parent, false);
                    movieViewHolderLeft = new MovieViewHolderLeft(convertView);
                    convertView.setTag(movieViewHolderLeft);
                    break;
                case BOTTOM_VIEW:
                    convertView = LayoutInflater.from(context).inflate(R.layout.item_bottom_view, parent, false);
                    bottomViewHolder = new BottomViewHolder(convertView);
                    convertView.setTag(bottomViewHolder);
                    break;
            }
        } else {
            switch (getItemViewType(position)){
                case HEAD_VIEW:
                    convertView = LayoutInflater.from(context).inflate(R.layout.item_bottom_view, parent, false);
                    break;
                case NORMAL_VIEW_LEFT:
                    movieViewHolderLeft = (MovieViewHolderLeft) convertView.getTag();
                    break;
                case NORMAL_VIEW_RIGHT:
                    movieViewHolderRight = (MovieViewHolderRight) convertView.getTag();
                    break;
                case BOTTOM_VIEW:
                    bottomViewHolder = (BottomViewHolder) convertView.getTag();
                    break;
            }
        }

        int color = dataType == 0 ? Color.parseColor("#c0c2dc")
                    : Color.parseColor("#a8faa8");

        switch (getItemViewType(position)){
            case HEAD_VIEW:
                break;
            case NORMAL_VIEW_LEFT:
                //TODO 具体控件赋予数据
                movieViewHolderLeft.bg.setBackgroundColor(color);
                break;
            case NORMAL_VIEW_RIGHT:
                movieViewHolderRight.bg.setBackgroundColor(color);
                break;
            case BOTTOM_VIEW:
                break;
        }


        return convertView;
    }

    @Override
    public int getViewTypeCount() {
        return 4;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == dataSize || position == dataSize+1) {
            return BOTTOM_VIEW;
        }else if(position == 0 || position == 1){
            return HEAD_VIEW;
        }else if(position%2 == 0){
            return NORMAL_VIEW_LEFT;
        }else{
            return NORMAL_VIEW_RIGHT;
        }
    }

    class MovieViewHolderLeft {
        ImageView bg;
        TextView songName, songSinger;

        MovieViewHolderLeft(View view) {
            bg = (ImageView) view.findViewById(R.id.iv_item_music_movie_gridview_bg);
            songName = (TextView) view.findViewById(R.id.tv_item_music_movie_gridview_songname);
            songSinger = (TextView) view.findViewById(R.id.tv_item_music_movie_gridview_songsinger);
        }
    }

    class MovieViewHolderRight {
        ImageView bg;
        TextView songName, songSinger;

        MovieViewHolderRight(View view) {
            bg = (ImageView) view.findViewById(R.id.iv_item_music_movie_gridview_bg);
            songName = (TextView) view.findViewById(R.id.tv_item_music_movie_gridview_songname);
            songSinger = (TextView) view.findViewById(R.id.tv_item_music_movie_gridview_songsinger);
        }
    }

    class BottomViewHolder {
        BottomViewHolder(View v) {

        }
    }
}
