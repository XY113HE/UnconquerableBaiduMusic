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

import android.widget.ListView;

import com.huoer.unconquerablebaidumusic.R;
import com.huoer.unconquerablebaidumusic.adapter.MusicTopFragmentListViewAdapter;
import com.huoer.unconquerablebaidumusic.base.BaseFragment;

public class MusicTopFragment extends BaseFragment {
    private ListView listView;
    private MusicTopFragmentListViewAdapter adapter;

    @Override
    protected int bindLayout() {
        return R.layout.fragment_music_top;
    }

    @Override
    protected void initView() {
        listView = bindView(R.id.lv_musicfragment_top);
    }

    @Override
    protected void initData() {
        adapter = new MusicTopFragmentListViewAdapter();
        adapter.setContext(getContext());
        listView.setAdapter(adapter);
    }

    @Override
    protected void initListener() {

    }
}
