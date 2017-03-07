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

public class MusicRecommendGridViewHotSellAlbumAdapter extends BaseAdapter {
    private Context context;
    private List<MusicRecommendBean.ResultBeanXXXXXXXXXXXXXXX.Mix22Bean.ResultBeanXXX> resultBeanXXXList;


    public void setResultBeanXXXList(List<MusicRecommendBean.ResultBeanXXXXXXXXXXXXXXX.Mix22Bean.ResultBeanXXX> resultBeanXXXList) {
        this.resultBeanXXXList = resultBeanXXXList;
        notifyDataSetChanged();
    }

    public void setContext(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return resultBeanXXXList.size();
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
        MusicRecommendBean.ResultBeanXXXXXXXXXXXXXXX.Mix22Bean.ResultBeanXXX bean = resultBeanXXXList.get(position);
        Glide.with(context).load(bean.getPic()).into(holder.bg);
        holder.title.setText(bean.getTitle());
        holder.author.setText(bean.getAuthor());

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
