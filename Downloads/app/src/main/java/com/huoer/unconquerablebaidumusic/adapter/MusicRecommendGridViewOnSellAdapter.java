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

public class MusicRecommendGridViewOnSellAdapter extends BaseAdapter {
    private Context context;
    private List<MusicRecommendBean.ResultBeanXXXXXXXXXXXXXXX.Mix1Bean.ResultBeanXXXXXXXXXXX> resultBeanXXXXXXXXXXXList;

    public void setResultBeanXXXXXXXXXXXList(List<MusicRecommendBean.ResultBeanXXXXXXXXXXXXXXX.Mix1Bean.ResultBeanXXXXXXXXXXX> resultBeanXXXXXXXXXXXList) {
        this.resultBeanXXXXXXXXXXXList = resultBeanXXXXXXXXXXXList;
        notifyDataSetChanged();
    }

    public void setContext(Context context) {
        this.context = context;
    }


    @Override
    public int getCount() {
        return resultBeanXXXXXXXXXXXList.size();
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
        MusicRecommendBean.ResultBeanXXXXXXXXXXXXXXX.Mix1Bean.ResultBeanXXXXXXXXXXX bean = resultBeanXXXXXXXXXXXList.get(position);
        Glide.with(context).load(bean.getPic()).into(holder.bg);
        holder.title.setText(bean.getTitle());
        holder.author.setText(bean.getAuthor());

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
