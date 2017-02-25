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

import android.widget.GridView;

import com.huoer.unconquerablebaidumusic.R;
import com.huoer.unconquerablebaidumusic.adapter.FindGridViewLiveAdapter;
import com.huoer.unconquerablebaidumusic.adapter.FindGridViewShopAdapter;
import com.huoer.unconquerablebaidumusic.base.BaseFragment;

public class FindFragment extends BaseFragment {
    private GridView shopGridView;
    private FindGridViewShopAdapter shopAdapter;
    private GridView liveGridView;
    private FindGridViewLiveAdapter liveAdapter;

    @Override
    protected int bindLayout() {
        return R.layout.fragment_find;
    }

    @Override
    protected void initView() {
//        shopGridView = bindView(R.id.gridview_findfragment_shop);
        liveGridView = bindView(R.id.gridview_findfragment_live);
    }

    @Override
    protected void initData() {
//        shopAdapter = new FindGridViewShopAdapter();
//        shopAdapter.setContext(getContext());
//        shopGridView.setAdapter(shopAdapter);
//
        liveAdapter = new FindGridViewLiveAdapter();
        liveAdapter.setContext(getContext());
        liveGridView.setAdapter(liveAdapter);
    }

    @Override
    protected void initListener() {

    }
}
