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
import android.content.pm.LabeledIntent;
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

public class MusicRecommendGridViewHotMvAdapter extends BaseAdapter {
    private Context context;
    private List<MusicRecommendBean.ResultBeanXXXXXXXXXXXXXXX.Mix5Bean.ResultBeanXXXXXXX> resultBeanXXXXXXXList;

    public void setResultBeanXXXXXXXList(List<MusicRecommendBean.ResultBeanXXXXXXXXXXXXXXX.Mix5Bean.ResultBeanXXXXXXX> resultBeanXXXXXXXList) {
        this.resultBeanXXXXXXXList = resultBeanXXXXXXXList;
        notifyDataSetChanged();
    }

    public void setContext(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return resultBeanXXXXXXXList.size();
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
        HotMvViewHolder holder = null;
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_music_recommend_gridview_hotmv, parent, false);
            holder = new HotMvViewHolder(convertView);
            convertView.setTag(holder);
        }else{
            holder = (HotMvViewHolder) convertView.getTag();
        }
        //TODO 具体数据的设置操作
        MusicRecommendBean.ResultBeanXXXXXXXXXXXXXXX.Mix5Bean.ResultBeanXXXXXXX bean = resultBeanXXXXXXXList.get(position);
        Glide.with(context).load(bean.getPic()).into(holder.bg);
        holder.author.setText(bean.getAuthor());
        holder.mvname.setText(bean.getTitle());

        return convertView;
    }

    class HotMvViewHolder{
        ImageView bg;
        TextView mvname, author;
        HotMvViewHolder(View itemview){
            bg = (ImageView) itemview.findViewById(R.id.iv_item_music_recommend_gridview_hotmv_bg);
            mvname = (TextView) itemview.findViewById(R.id.tv_item_music_recommend_gridview_hotmv_mvname);
            author = (TextView) itemview.findViewById(R.id.tv_item_music_recommend_gridview_hotmv_author);
        }
    }
}
