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
import com.huoer.unconquerablebaidumusic.adapter.MusicMovieFragmentGridViewAdapter;
import com.huoer.unconquerablebaidumusic.base.BaseFragment;

public class MusicMovieFragment extends BaseFragment {
    private GridView gridView;
    private MusicMovieFragmentGridViewAdapter adapter;

    @Override
    protected int bindLayout() {
        return R.layout.fragment_music_movie;
    }

    @Override
    protected void initView() {
        gridView = bindView(R.id.gridview_musicfragment_movie);
    }

    @Override
    protected void initData() {
        adapter = new MusicMovieFragmentGridViewAdapter();
        adapter.setContext(getContext());
        gridView.setAdapter(adapter);

    }

    @Override
    protected void initListener() {

    }
}
