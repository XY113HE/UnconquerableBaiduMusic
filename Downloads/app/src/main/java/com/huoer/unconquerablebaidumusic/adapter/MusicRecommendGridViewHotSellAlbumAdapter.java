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

public class MusicRecommendGridViewHotSellAlbumAdapter extends BaseAdapter {
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
        HotSellViewHolder holder = null;
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_music_recommend_gridview_hotsell_album, parent, false);
            holder = new HotSellViewHolder(convertView);
            convertView.setTag(holder);
        }else{
            holder = (HotSellViewHolder) convertView.getTag();
        }

        //TODO 具体数据的设置


        return convertView;
    }

    class HotSellViewHolder{
        ImageView bg;
        TextView title, author;
        HotSellViewHolder(View itemview){
            bg = (ImageView) itemview.findViewById(R.id.iv_item_music_recommend_gridview_hotsell_bg);
            title = (TextView) itemview.findViewById(R.id.tv_item_music_recommend_gridview_hotsell_title);
            author = (TextView) itemview.findViewById(R.id.tv_item_music_recommend_gridview_hotsell_author);

        }
    }
}
