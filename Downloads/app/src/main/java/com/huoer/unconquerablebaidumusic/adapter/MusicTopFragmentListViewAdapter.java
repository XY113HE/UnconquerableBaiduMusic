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
import com.huoer.unconquerablebaidumusic.bean.MusicTopBean;

import java.util.List;

public class MusicTopFragmentListViewAdapter extends BaseAdapter {
    private static final String TAG = "MusicTopFragmentListVie";

    private Context context;
    private List<MusicTopBean.ContentBeanX> contentBeanXList;
    private final int NORMAL_VIEW = 0, BOTTOM_VIEW = 1;

    public void setContentBeanXList(List<MusicTopBean.ContentBeanX> contentBeanXList) {
        this.contentBeanXList = contentBeanXList;
        notifyDataSetChanged();
    }

    public void setContext(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return contentBeanXList.size()+1;
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
        TopViewHolder topViewHolder = null;
        BottomViewHolder bottomViewHolder = null;
        if (convertView == null) {
            switch (getItemViewType(position)){
                case NORMAL_VIEW:
                    convertView = LayoutInflater.from(context).inflate(R.layout.item_music_top_listview, parent, false);
                    topViewHolder = new TopViewHolder(convertView);
                    convertView.setTag(topViewHolder);
                    break;
                case BOTTOM_VIEW:
                    convertView = LayoutInflater.from(context).inflate(R.layout.item_bottom_view, parent, false);
                    bottomViewHolder = new BottomViewHolder(convertView);
                    convertView.setTag(bottomViewHolder);
                    break;
            }
        } else {
            switch (getItemViewType(position)){
                case NORMAL_VIEW:
                    topViewHolder = (TopViewHolder) convertView.getTag();
                    break;
                case BOTTOM_VIEW:
                    bottomViewHolder = (BottomViewHolder) convertView.getTag();
                    break;
            }
        }


        switch (getItemViewType(position)){
            case NORMAL_VIEW:
                //TODO 具体数据的设置
                MusicTopBean.ContentBeanX bean = contentBeanXList.get(position);
                Glide.with(context).load(bean.getPic_s210()).into(topViewHolder.bg);
                topViewHolder.kind.setText(bean.getName());
                List<MusicTopBean.ContentBeanX.ContentBean> beans = bean.getContent();
                topViewHolder.song1.setText(beans.get(0).getTitle());
                topViewHolder.song2.setText(beans.get(1).getTitle());
                topViewHolder.song3.setText(beans.get(2).getTitle());
                break;
            case BOTTOM_VIEW:
                break;
        }




        return convertView;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == contentBeanXList.size()) {
            return BOTTOM_VIEW;
        } else {
            return NORMAL_VIEW;
        }
    }

    class TopViewHolder {
        ImageView bg;
        TextView kind, song1, song2, song3;

        TopViewHolder(View view) {
            bg = (ImageView) view.findViewById(R.id.iv_item_music_top_listview_bg);
            kind = (TextView) view.findViewById(R.id.tv_item_music_top_listview_kind);
            song1 = (TextView) view.findViewById(R.id.tv_item_music_top_listview_list1);
            song2 = (TextView) view.findViewById(R.id.tv_item_music_top_listview_list2);
            song3 = (TextView) view.findViewById(R.id.tv_item_music_top_listview_list3);
        }

    }

    class BottomViewHolder {
        BottomViewHolder(View v) {

        }
    }
}
