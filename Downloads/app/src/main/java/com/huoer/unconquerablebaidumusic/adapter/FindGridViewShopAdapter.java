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
import com.huoer.unconquerablebaidumusic.bean.FindBean;

import java.util.List;

public class FindGridViewShopAdapter extends BaseAdapter {
    private List<FindBean.ResultBean.ShopInfoBean.ShopListBean> shopListBeanList;
    private static final String TAG = "FindGridViewShopAdapter";
    private Context context;

    public void setShopListBeanList(List<FindBean.ResultBean.ShopInfoBean.ShopListBean> shopListBeanList) {
        this.shopListBeanList = shopListBeanList;
        notifyDataSetChanged();
    }

    public void setContext(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return shopListBeanList.size();
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
        FindBean.ResultBean.ShopInfoBean.ShopListBean bean = shopListBeanList.get(position);
        Glide.with(context).load(bean.getPicurl()).into(holder.bg);
        holder.title.setText(bean.getTitle());

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
