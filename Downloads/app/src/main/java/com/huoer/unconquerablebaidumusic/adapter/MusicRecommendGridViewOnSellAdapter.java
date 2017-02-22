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

public class MusicRecommendGridViewOnSellAdapter extends BaseAdapter {
    private Context context;

    public void setContext(Context context) {
        this.context = context;
    }

    private int dataSize = 6;

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
        OnSellViewHolder holder = null;
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_music_recommend_gridview_onsell, parent, false);
            holder = new OnSellViewHolder(convertView);
            convertView.setTag(holder);
        }else{
            holder = (OnSellViewHolder) convertView.getTag();
        }

        //TODO 做具体数据的设置

        return convertView;
    }

    class OnSellViewHolder{
        ImageView bg;
        TextView title, author;
        OnSellViewHolder(View itemview){
            bg = (ImageView) itemview.findViewById(R.id.iv_item_music_recommend_gridview_onsell_bg);
            title = (TextView) itemview.findViewById(R.id.tv_item_music_recommend_gridview_onsell_title);
            author = (TextView) itemview.findViewById(R.id.tv_item_music_recommend_gridview_onsell_author);
        }
    }
}
