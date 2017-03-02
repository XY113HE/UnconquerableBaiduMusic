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

import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.GridView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.huoer.unconquerablebaidumusic.R;
import com.huoer.unconquerablebaidumusic.adapter.MusicMovieFragmentGridViewAdapter;
import com.huoer.unconquerablebaidumusic.base.BaseFragment;


public class MusicMovieFragment extends BaseFragment implements View.OnClickListener {
    private static final String TAG = "MusicMovieFragment";
    private GridView gridView;
    private MusicMovieFragmentGridViewAdapter adapter;
    private TextView hotest, newest;
    private boolean topBarIsShow = true;
    private RelativeLayout topBarLayout;

    @Override
    protected int bindLayout() {
        return R.layout.fragment_music_movie;
    }

    @Override
    protected void initView() {
        gridView = bindView(R.id.gridview_musicfragment_movie);
        hotest = bindView(R.id.tv_musicfragment_movie_hotest);
        newest = bindView(R.id.tv_musicfragment_movie_newest);
        topBarLayout = bindView(R.id.rl_musicfragment_movie);
    }

    @Override
    protected void initData() {
        adapter = new MusicMovieFragmentGridViewAdapter();
        adapter.setContext(getContext());
        gridView.setAdapter(adapter);

    }

    @Override
    protected void initListener() {
        hotest.setOnClickListener(this);
        newest.setOnClickListener(this);
        gridView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                if(firstVisibleItem >= 4){
                    if(topBarIsShow){
                        topBarLayout.setVisibility(View.INVISIBLE);
                        topBarIsShow = false;
                        Log.e(TAG, "onScroll: isHide");
                    }
                }else{
                    if(!topBarIsShow){
                        topBarLayout.setVisibility(View.VISIBLE);
                        topBarIsShow = true;
                        Log.e(TAG, "onScroll: isShow");
                    }
                }
            }
        });
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_musicfragment_movie_newest:
                newest.setTextColor(Color.parseColor("#31d7ef"));
                hotest.setTextColor(Color.parseColor("#606060"));
                adapter.setDataType(0);
                break;
            case R.id.tv_musicfragment_movie_hotest:
                hotest.setTextColor(Color.parseColor("#31d7ef"));
                newest.setTextColor(Color.parseColor("#606060"));
                adapter.setDataType(1);
                break;
        }
    }
}
