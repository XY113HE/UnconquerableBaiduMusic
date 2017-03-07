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

public class MusicRecommendGridViewOriginalMusicAdapter extends BaseAdapter {
    private Context context;
    private List<MusicRecommendBean.ResultBeanXXXXXXXXXXXXXXX.Mix9Bean.ResultBean> resultBeanList;

    public void setResultBeanList(List<MusicRecommendBean.ResultBeanXXXXXXXXXXXXXXX.Mix9Bean.ResultBean> resultBeanList) {
        this.resultBeanList = resultBeanList;
        notifyDataSetChanged();
    }

    public void setContext(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return resultBeanList.size();
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
        OriginalMusicViewHolder holder = null;
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_music_recommend_gridview_original_music, parent, false);
            holder = new OriginalMusicViewHolder(convertView);
            convertView.setTag(holder);
        }else{
            holder = (OriginalMusicViewHolder) convertView.getTag();
        }

        //TODO 具体数据的设置操作
        MusicRecommendBean.ResultBeanXXXXXXXXXXXXXXX.Mix9Bean.ResultBean bean = resultBeanList.get(position);
        Glide.with(context).load(bean.getPic()).into(holder.bg);
        holder.title.setText(bean.getTitle());

        return convertView;
    }

    class OriginalMusicViewHolder{
        ImageView bg;
        TextView title;
        OriginalMusicViewHolder(View itemview){
            bg = (ImageView) itemview.findViewById(R.id.iv_item_music_recommend_gridview_original_music_bg);
            title = (TextView) itemview.findViewById(R.id.tv_item_music_recommend_gridview_original_music_title);
        }
    }
}
