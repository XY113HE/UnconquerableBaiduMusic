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
import android.content.SharedPreferences;
import android.content.pm.ProviderInfo;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.huoer.unconquerablebaidumusic.R;

import java.security.PrivateKey;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.tencent.qq.QQ;

public class MyLoginListViewAdapter extends BaseAdapter {
    private static final String TAG = "MyLoginListViewAdapter";
    private final int BODY_VIEW = 0;
    private final int FOOT_VIEW = 1;
    private boolean isLoginIn;

    private Context context;
    private String[] titles;
    private int[] imgIds;

    private LoginStateChanged loginStateListener;

    public void setLoginStateListener(LoginStateChanged loginStateListener) {
        this.loginStateListener = loginStateListener;
    }

    public void setLoginIn(boolean loginIn) {
        isLoginIn = loginIn;
        Log.e(TAG, "setLoginIn: " +isLoginIn);
        notifyDataSetChanged();
    }

    public void setContext(Context context) {
        this.context = context;
        ShareSDK.initSDK(context);
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
        return titles.length+1;
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
                TextView tv = (TextView) v.findViewById(R.id.tv_item_mylogin_foot_view);
                tv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Log.e(TAG, "onClick: qq.removeAccount");
                        Platform qq = ShareSDK.getPlatform(context, QQ.NAME);
                        qq.removeAccount();
                        SharedPreferences sp = context.getSharedPreferences("user_state", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sp.edit();
                        editor.putBoolean("login", false);
                        editor.commit();
                        loginStateListener.updateView();
                    }
                });
                if(isLoginIn){
                    Log.e(TAG, "getView: " + isLoginIn);
                   tv.setVisibility(View.VISIBLE);
                }else {
                    Log.e(TAG, "getView: " + isLoginIn);
                    tv.setVisibility(View.GONE);
                }
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
        if(position == titles.length){
            return FOOT_VIEW;
        }else{
            return BODY_VIEW;
        }
    }

    public interface LoginStateChanged{
        void updateView();
    }
}
