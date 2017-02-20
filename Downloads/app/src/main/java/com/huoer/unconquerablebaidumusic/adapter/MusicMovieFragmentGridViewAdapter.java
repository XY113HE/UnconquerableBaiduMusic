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
import android.graphics.Paint;
import android.os.Build;
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
    private final int NORMAL_VIEW = 0, BOTTOM_VIEW = 1;

    public void setContext(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return 20;
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

        MovieViewHolder movieViewHolder = null;
        BottomViewHolder bottomViewHolder = null;


        if (convertView == null) {
            switch (getItemViewType(position)){
                case NORMAL_VIEW:
                    convertView = LayoutInflater.from(context).inflate(R.layout.item_music_movie_gridview, parent, false);
                    movieViewHolder = new MovieViewHolder(convertView);
                    convertView.setTag(movieViewHolder);
                    break;
                case BOTTOM_VIEW:
                    convertView = LayoutInflater.from(context).inflate(R.layout.item_bottom_view, parent, false);
                    bottomViewHolder = new BottomViewHolder(convertView);
                    convertView.setTag(bottomViewHolder);
                    break;
            }
        } else {
            switch (getItemViewType(position)){
                case NORMAL_VIEW:
                    movieViewHolder = (MovieViewHolder) convertView.getTag();
                    break;
                case BOTTOM_VIEW:
                    bottomViewHolder = (BottomViewHolder) convertView.getTag();
                    break;
            }
        }

        switch (getItemViewType(position)){
            case NORMAL_VIEW:
                //TODO 具体控件赋予数据
                break;
            case BOTTOM_VIEW:
                break;
        }


        return convertView;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 18 || position == 19) {
            return BOTTOM_VIEW;
        } else {
            return NORMAL_VIEW;
        }
    }

    class MovieViewHolder {
        ImageView bg;
        TextView songName, songSinger;

        MovieViewHolder(View view) {
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
