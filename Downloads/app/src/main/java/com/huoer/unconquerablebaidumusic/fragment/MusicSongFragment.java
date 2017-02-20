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
import com.huoer.unconquerablebaidumusic.adapter.MusicFragmentViewPagerAdapter;
import com.huoer.unconquerablebaidumusic.adapter.MusicSongFragmentGridViewAdapter;
import com.huoer.unconquerablebaidumusic.base.BaseFragment;

public class MusicSongFragment extends BaseFragment{
    private GridView gridview;
    private MusicSongFragmentGridViewAdapter adapter;

    @Override
    protected int bindLayout() {
        return R.layout.fragment_music_song;
    }

    @Override
    protected void initView() {
        gridview = bindView(R.id.gridview_musicfragment_song);
    }

    @Override
    protected void initData() {
        adapter = new MusicSongFragmentGridViewAdapter();
        adapter.setContext(getContext());
        gridview.setAdapter(adapter);

    }

    @Override
    protected void initListener() {

    }
}
