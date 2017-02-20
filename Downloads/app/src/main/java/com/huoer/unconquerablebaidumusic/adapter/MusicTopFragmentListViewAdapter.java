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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.huoer.unconquerablebaidumusic.R;

import java.util.List;

public class MusicTopFragmentListViewAdapter extends BaseAdapter {
    private static final String TAG = "MusicTopFragmentListVie";

    private Context context;
    private List data;
    private final int NORMAL_VIEW = 0, BOTTOM_VIEW = 1;
    private int dataSize = 10;

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
        TopViewHolder topViewHolder = null;
        BottomViewHolder bottomViewHolder = null;
        if (convertView == null) {
            switch (getItemViewType(position)){
                case NORMAL_VIEW:
                    convertView = LayoutInflater.from(context).inflate(R.layout.item_music_top_listview, parent, false);
                    topViewHolder = new TopViewHolder(convertView);
                    convertView.setTag(topViewHolder);
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
                    topViewHolder = (TopViewHolder) convertView.getTag();
                    break;
                case BOTTOM_VIEW:
                    bottomViewHolder = (BottomViewHolder) convertView.getTag();
                    break;
            }
        }


        switch (getItemViewType(position)){
            case NORMAL_VIEW:
                //TODO 具体数据的设置
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
        if (position == dataSize - 1 || position == dataSize - 2) {
            return BOTTOM_VIEW;
        } else {
            return NORMAL_VIEW;
        }
    }

    class TopViewHolder {
        ImageView bg, play;
        TextView kind, song1, song2, song3;

        TopViewHolder(View view) {
            bg = (ImageView) view.findViewById(R.id.iv_item_music_top_listview_bg);
            play = (ImageView) view.findViewById(R.id.iv_item_music_top_listview_play);
            kind = (TextView) view.findViewById(R.id.tv_item_music_top_listview_kind);
            song1 = (TextView) view.findViewById(R.id.tv_item_music_top_listview_list1);
            song2 = (TextView) view.findViewById(R.id.tv_item_music_top_listview_list2);
            song3 = (TextView) view.findViewById(R.id.tv_item_music_top_listview_list3);
        }

    }

    class BottomViewHolder {
        BottomViewHolder(View v) {

        }
    }
}
