package com.huoer.unconquerablebaidumusic.fragment;
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

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.huoer.unconquerablebaidumusic.R;
import com.huoer.unconquerablebaidumusic.adapter.MyLoginListViewAdapter;
import com.huoer.unconquerablebaidumusic.base.BaseFragment;

public class MyLoginFragment extends BaseFragment {
    private ListView listView;
    private String[] titles = {"我的消息", "我的积分", "成为白金VIP",
            "免流量听歌", "邀请有奖", "设置", "定时关闭", "电脑导歌", "精品应用"};
    private MyLoginListViewAdapter adapter;

    @Override
    protected int bindLayout() {
        return R.layout.fragment_mylogin;
    }

    @Override
    protected void initView() {
        listView = bindView(R.id.lv_myloginfragment);
    }

    @Override
    protected void initData() {
        adapter = new MyLoginListViewAdapter();
        adapter.setContext(getContext());
        adapter.setTitles(titles);
        listView.setAdapter(adapter);
//        addHeadView();
    }

    private void addHeadView() {

        View headView = LayoutInflater.from(getContext()).inflate(R.layout.item_mylogin_head_view, null);
        TextView username;
        ImageView level, headimg;
        username = (TextView) headView.findViewById(R.id.tv_item_mylogin_topbar_username);
        level = (ImageView) headView.findViewById(R.id.iv_item_mylogin_topbar_level);
        headimg = (ImageView) headView.findViewById(R.id.iv_item_mylogin_topbar_headimg);
        listView.addHeaderView(headView);
    }



    @Override
    protected void initListener() {

    }
}
