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
import android.widget.TextView;

import com.huoer.unconquerablebaidumusic.R;
import com.huoer.unconquerablebaidumusic.bean.MusicPkWeSingBean;

import java.util.List;

public class MusicPKListViewWeSingAdapter extends BaseAdapter {
    private Context context;
    private List<MusicPkWeSingBean.ResultBean.ItemsBean> itemsBeanList;

    public void setItemsBeanList(List<MusicPkWeSingBean.ResultBean.ItemsBean> itemsBeanList) {
        this.itemsBeanList = itemsBeanList;
        notifyDataSetChanged();
    }

    public void setContext(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return itemsBeanList.size();
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
        WeSingViewHolder holder = null;
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_music_pk_listview_wesing, parent, false);
            holder = new WeSingViewHolder(convertView);
            convertView.setTag(holder);
        }else{
            holder = (WeSingViewHolder) convertView.getTag();
        }
        //TODO 设置具体数据的操作
        MusicPkWeSingBean.ResultBean.ItemsBean bean = itemsBeanList.get(position);
        holder.songName.setText(bean.getSong_title()+" - "+bean.getArtist_name());
        holder.amount.setText(bean.getPlay_num()+"人唱过");

        return convertView;
    }

    class WeSingViewHolder{
        TextView songName, amount;
        WeSingViewHolder(View itemview){
            songName = (TextView) itemview.findViewById(R.id.tv_item_music_pk_mypk_wesing_songname);
            amount = (TextView) itemview.findViewById(R.id.tv_item_music_pk_mypk_wesing_amount);
        }
    }
}
