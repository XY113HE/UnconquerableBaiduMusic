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

import com.huoer.unconquerablebaidumusic.R;

public class FindGridViewShopAdapter extends BaseAdapter {
    private Context context;
    private int dataSize = 3;

    public void setContext(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return dataSize;
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
        ShopViewHolder holder = null;
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_find_gridview_shop, parent, false);
            holder = new ShopViewHolder(convertView);
            convertView.setTag(holder);
        }else{
            holder = (ShopViewHolder) convertView.getTag();
        }

        //TODO 具体数据设 置操作
        return convertView;
    }

    class ShopViewHolder{
        ImageView bg;
        TextView title;
        ShopViewHolder(View itemview){
            bg = (ImageView) itemview.findViewById(R.id.iv_item_find_gridview_shop);
            title = (TextView) itemview.findViewById(R.id.tv_item_find_gridview_shop);
        }
    }
}
