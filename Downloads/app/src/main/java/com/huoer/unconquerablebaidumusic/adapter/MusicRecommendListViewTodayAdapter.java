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
import android.graphics.Bitmap;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.huoer.unconquerablebaidumusic.R;
import com.huoer.unconquerablebaidumusic.bean.MusicRecommendBean;

import java.util.List;

public class MusicRecommendListViewTodayAdapter extends BaseAdapter {
    private Context context;
    private List<MusicRecommendBean.ResultBeanXXXXXXXXXXXXXXX.RecsongBean.ResultBeanXXXXXXXXX> resultBeanXXXXXXXXXList;

    public void setResultBeanXXXXXXXXXList(List<MusicRecommendBean.ResultBeanXXXXXXXXXXXXXXX.RecsongBean.ResultBeanXXXXXXXXX> resultBeanXXXXXXXXXList) {
        this.resultBeanXXXXXXXXXList = resultBeanXXXXXXXXXList;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
//        return resultBeanXXXXXXXXXList.size();
        return 3;
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
        TodayViewHolder holder = null;
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_music_recommend_listview_today, parent, false);
            holder = new TodayViewHolder(convertView);
            convertView.setTag(holder);
        }else{
            holder = (TodayViewHolder) convertView.getTag();
        }

        //TODO  具体数据的设置

        MusicRecommendBean.ResultBeanXXXXXXXXXXXXXXX.RecsongBean.ResultBeanXXXXXXXXX bean = resultBeanXXXXXXXXXList.get(position);
        Glide.with(context).load(bean.getPic_premium()).into(holder.bg);
        holder.author.setText(bean.getAuthor());
        holder.songName.setText(bean.getTitle());

        return convertView;
    }

    class TodayViewHolder{
        ImageView bg;
        TextView songName, author;
        TodayViewHolder(View itemview){
            bg = (ImageView) itemview.findViewById(R.id.iv_item_music_recommend_listview_today_bg);
            songName = (TextView) itemview.findViewById(R.id.tv_item_music_recommend_listview_today_songname);
            author = (TextView) itemview.findViewById(R.id.tv_item_music_recommend_listview_today_author);

        }
    }
}
