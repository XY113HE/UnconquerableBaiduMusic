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

import com.bumptech.glide.Glide;
import com.huoer.unconquerablebaidumusic.R;
import com.huoer.unconquerablebaidumusic.bean.MusicRecommendBean;

import java.util.List;

public class MusicRecommendGridViewLeProgramAdapter extends BaseAdapter {
    private Context context;
    private List<MusicRecommendBean.ResultBeanXXXXXXXXXXXXXXX.RadioBean.ResultBeanXXXXXXXX> resultBeanXXXXXXXXList;

    public void setResultBeanXXXXXXXXList(List<MusicRecommendBean.ResultBeanXXXXXXXXXXXXXXX.RadioBean.ResultBeanXXXXXXXX> resultBeanXXXXXXXXList) {
        this.resultBeanXXXXXXXXList = resultBeanXXXXXXXXList;
        notifyDataSetChanged();
    }

    public void setContext(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return resultBeanXXXXXXXXList.size();
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
        LeProgramViewHolder holder = null;
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_music_recommend_gridview_leprogram, parent, false);
            holder = new LeProgramViewHolder(convertView);
            convertView.setTag(holder);
        }else{
            holder = (LeProgramViewHolder) convertView.getTag();
        }

        //TODO 具体数据的设置操作
        MusicRecommendBean.ResultBeanXXXXXXXXXXXXXXX.RadioBean.ResultBeanXXXXXXXX bean = resultBeanXXXXXXXXList.get(position);
        Glide.with(context).load(bean.getPic()).into(holder.bg);
        holder.title.setText(bean.getTitle());

        return convertView;
    }

    class LeProgramViewHolder{
        ImageView bg;
        TextView title;
        LeProgramViewHolder(View itemview){
            bg = (ImageView) itemview.findViewById(R.id.iv_item_music_recommend_gridview_leprogram_bg);
            title = (TextView) itemview.findViewById(R.id.tv_item_music_recommend_gridview_leprogram_title);
        }
    }
}
