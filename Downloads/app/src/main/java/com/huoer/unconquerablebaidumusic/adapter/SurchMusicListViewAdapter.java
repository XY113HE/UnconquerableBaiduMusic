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
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.huoer.unconquerablebaidumusic.R;

public class SurchMusicListViewAdapter extends BaseAdapter {
    private Context context;
    private int dataSize = 6;
    private final int BODY_VIEW = 0;
    private final int FOOT_VIEW = 1;
    private OnClearListener onClearListener;

    public void setOnClearListener(OnClearListener onClearListener) {
        this.onClearListener = onClearListener;
    }

    public void setDataSize(int dataSize) {
        this.dataSize = dataSize;
        notifyDataSetChanged();
    }

    public void setContext(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return dataSize+1;
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
                HistoryViewHolder holder = null;
                if(convertView == null){
                    convertView = LayoutInflater.from(context).inflate(R.layout.item_surchmusic_listview, parent, false);
                    holder = new HistoryViewHolder(convertView);
                    convertView.setTag(holder);
                }else{
                    holder = (HistoryViewHolder) convertView.getTag();
                }
                //TODO 具体数据设置操作
                v = convertView;
                break;
            case FOOT_VIEW:
                v = LayoutInflater.from(context).inflate(R.layout.item_surchmusic_footview, parent, false);
                v.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onClearListener.clearData();
                    }
                });
                break;
        }
        return v;
    }

    class HistoryViewHolder{
        TextView history;
        HistoryViewHolder(View itemview){
            history = (TextView) itemview.findViewById(R.id.tv_item_surchmusic_listview_history);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if(position == dataSize){
            return FOOT_VIEW;
        }else{
            return BODY_VIEW;
        }
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    public interface OnClearListener{
        void clearData();
    }
}
