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
import android.content.pm.ProviderInfo;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.huoer.unconquerablebaidumusic.R;

public class MyLoginListViewAdapter extends BaseAdapter {
    private final int BODY_VIEW = 0;
    private final int FOOT_VIEW = 1;

    private Context context;
    private String[] titles;
    private int[] imgIds;

    public void setContext(Context context) {
        this.context = context;
    }

    public void setTitles(String[] titles) {
        this.titles = titles;
    }

    public void setImgIds(int[] imgIds) {
        this.imgIds = imgIds;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return titles.length;
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
        View v = null;
        switch (getItemViewType(position)){

            case BODY_VIEW:
                MyLoginViewHolder holder = null;
                if(convertView == null){
                    convertView = LayoutInflater.from(context).inflate(R.layout.item_mylogin_listview, parent, false);
                    holder = new MyLoginViewHolder(convertView);
                    convertView.setTag(holder);
                }else{
                    holder = (MyLoginViewHolder) convertView.getTag();
                }

                //TODO 具体数据设置操作
                holder.title.setText(titles[position]);
                holder.icon.setImageResource(imgIds[position]);
                holder.extrainfo.setVisibility(View.GONE);
                v = convertView;
                break;
            case FOOT_VIEW:

                v = LayoutInflater.from(context).inflate(R.layout.item_mylogin_foot_view, parent, false);
                v.findViewById(R.id.tv_item_mylogin_foot_view).setVisibility(View.GONE);

                break;
        }


        return v;
    }

    class MyLoginViewHolder{
        TextView title, extrainfo;
        ImageView icon;
        MyLoginViewHolder(View itemview){
            title = (TextView) itemview.findViewById(R.id.tv_item_mylogin_listview_title);
            extrainfo = (TextView) itemview.findViewById(R.id.tv_item_mylogin_listview_extrainfo);
            icon = (ImageView) itemview.findViewById(R.id.iv_item_mylogin_listview_icon);
        }
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        if(position == titles.length+1){
            return FOOT_VIEW;
        }else{
            return BODY_VIEW;
        }
    }
}
