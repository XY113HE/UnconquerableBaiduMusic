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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.huoer.unconquerablebaidumusic.R;

public class MusicRecommendListViewSpecialColumnAdapter extends BaseAdapter {
    private Context context;
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
        SpecialColumnViewHolder holder = null;
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_music_recommend_listview_special_column, parent, false);
            holder = new SpecialColumnViewHolder(convertView);
            convertView.setTag(holder);
        }else{
            holder = (SpecialColumnViewHolder) convertView.getTag();
        }
        return convertView;
    }

    class SpecialColumnViewHolder{
        ImageView bg;
        TextView title, author;
        SpecialColumnViewHolder(View itemview){
            bg = (ImageView) itemview.findViewById(R.id.iv_item_music_recommend_listview_special_column_bg);
            title = (TextView) itemview.findViewById(R.id.tv_item_music_recommend_listview_special_column_title);
            author = (TextView) itemview.findViewById(R.id.tv_item_music_recommend_listview_special_column_author);
        }
    }
}
