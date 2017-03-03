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

import com.huoer.unconquerablebaidumusic.R;

public class FindGridViewLiveAdapter extends BaseAdapter {
    private static final String TAG = "FindGridViewLiveAdapter";
    private final int BODY_VIEW = 0;
    private final int FOOT_VIEW = 1;
    private Context context;
    private int dataSize = 4;

    public void setContext(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return dataSize+2;
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
        LiveViewHolder liveViewHolder = null;
        BottomViewHolder bottomViewHolder = null;
        if(convertView == null){
            switch (getItemViewType(position)){
                case BODY_VIEW:
                    convertView = LayoutInflater.from(context).inflate(R.layout.item_find_gridview_live, parent, false);
                    liveViewHolder = new LiveViewHolder(convertView);
                    convertView.setTag(liveViewHolder);
                    break;
                case FOOT_VIEW:
                    convertView = LayoutInflater.from(context).inflate(R.layout.item_bottom_view, parent, false);
                    bottomViewHolder = new BottomViewHolder(convertView);
                    convertView.setTag(bottomViewHolder);
                    break;
            }
        }else{
            switch (getItemViewType(position)){
                case BODY_VIEW:
                    liveViewHolder = (LiveViewHolder) convertView.getTag();
                    break;
                case FOOT_VIEW:
                    bottomViewHolder = (BottomViewHolder) convertView.getTag();
                    break;
            }
        }
        //TODO 具体数据设置操作
        return convertView;
    }

    class LiveViewHolder{
        ImageView bg;
        TextView amount, title;
        LiveViewHolder(View viewitem){
            bg = (ImageView) viewitem.findViewById(R.id.iv_item_find_gridview_live_bg);
            amount = (TextView) viewitem.findViewById(R.id.tv_item_find_gridview_live_amount);
            title = (TextView) viewitem.findViewById(R.id.tv_item_find_gridview_live_title);
        }
    }

    class BottomViewHolder{
        BottomViewHolder(View itemview){

        }

    }

    @Override
    public int getItemViewType(int position) {
//        return BODY_VIEW;
        if(position == dataSize || position == dataSize+1){
            return FOOT_VIEW;
        }else{
            return BODY_VIEW;
        }
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }
}
