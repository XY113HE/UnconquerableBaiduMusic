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
import com.huoer.unconquerablebaidumusic.bean.MusicPkListBean;
import com.huoer.unconquerablebaidumusic.bean.MusicPkWeSingBean;

import java.util.List;

public class MusicPKGridViewMyPkAdapter extends BaseAdapter {
    private Context context;
    private List<MusicPkListBean.ResultBean.ItemsBean> itemsBeanList;
    private int[] imgIds;

    public void setItemsBeanList(List<MusicPkListBean.ResultBean.ItemsBean> itemsBeanList) {
        this.itemsBeanList = itemsBeanList;
        notifyDataSetChanged();
    }

    public void setImgIds(int[] imgIds) {
        this.imgIds = imgIds;
        notifyDataSetChanged();
    }

    public void setContext(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return itemsBeanList.size();
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
        MyPkViewHolder holder = null;
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_music_pk_gridview_mypk, parent, false);
            holder = new MyPkViewHolder(convertView);
            convertView.setTag(holder);
        }else{
            holder = (MyPkViewHolder) convertView.getTag();
        }
        //TODO 具体数据的设置操作
        final MyPkViewHolder finalHolder = holder;

        MusicPkListBean.ResultBean.ItemsBean bean = itemsBeanList.get(position);
        Glide.with(context).load(imgIds[position]).asBitmap().centerCrop().into(new BitmapImageViewTarget(finalHolder.bg) {
            @Override
            protected void setResource(Bitmap resource) {
                RoundedBitmapDrawable circularBitmapDrawable =
                        RoundedBitmapDrawableFactory.create(context.getResources(), resource);
                circularBitmapDrawable.setCircular(true);
                finalHolder.bg.setImageDrawable(circularBitmapDrawable);
            }
        });
        holder.title.setText(bean.getDesc());

        return convertView;
    }

    class MyPkViewHolder{
        ImageView bg;
        TextView title;
        MyPkViewHolder(View itemview){
            bg = (ImageView) itemview.findViewById(R.id.iv_item_music_pk_mypk_bg);
            title = (TextView) itemview.findViewById(R.id.tv_item_music_pk_mypk_title);
        }
    }
}
