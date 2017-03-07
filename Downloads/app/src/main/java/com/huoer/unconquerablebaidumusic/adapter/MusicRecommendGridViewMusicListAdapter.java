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

import com.bumptech.glide.Glide;
import com.huoer.unconquerablebaidumusic.R;
import com.huoer.unconquerablebaidumusic.bean.MusicRecommendBean;

import java.util.List;

public class MusicRecommendGridViewMusicListAdapter extends BaseAdapter {
    private Context context;
    private List<MusicRecommendBean.ResultBeanXXXXXXXXXXXXXXX.DiyBean.ResultBeanXXXX> resultBeanXXXXList;

    public void setResultBeanXXXXList(List<MusicRecommendBean.ResultBeanXXXXXXXXXXXXXXX.DiyBean.ResultBeanXXXX> resultBeanXXXXList) {
        this.resultBeanXXXXList = resultBeanXXXXList;
        notifyDataSetChanged();
    }

    public void setContext(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return resultBeanXXXXList.size();
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
        MusicRecommendBean.ResultBeanXXXXXXXXXXXXXXX.DiyBean.ResultBeanXXXX bean = resultBeanXXXXList.get(position);
        Glide.with(context).load(bean.getPic()).into(holder.bg);
        holder.amount.setText(bean.getListenum()+"");
        holder.title.setText(bean.getTitle());

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
