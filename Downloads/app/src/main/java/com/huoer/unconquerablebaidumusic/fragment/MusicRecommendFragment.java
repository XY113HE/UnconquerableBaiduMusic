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

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.huoer.unconquerablebaidumusic.R;
import com.huoer.unconquerablebaidumusic.adapter.MusicRecommendGridViewHotMvAdapter;
import com.huoer.unconquerablebaidumusic.adapter.MusicRecommendGridViewHotSellAlbumAdapter;
import com.huoer.unconquerablebaidumusic.adapter.MusicRecommendGridViewLeProgramAdapter;
import com.huoer.unconquerablebaidumusic.adapter.MusicRecommendGridViewMusicListAdapter;
import com.huoer.unconquerablebaidumusic.adapter.MusicRecommendGridViewOnSellAdapter;
import com.huoer.unconquerablebaidumusic.adapter.MusicRecommendGridViewOriginalMusicAdapter;
import com.huoer.unconquerablebaidumusic.adapter.MusicRecommendListViewSpecialColumnAdapter;
import com.huoer.unconquerablebaidumusic.adapter.MusicRecommendListViewTodayAdapter;
import com.huoer.unconquerablebaidumusic.adapter.MusicRecommendViewPagerAdapter;
import com.huoer.unconquerablebaidumusic.base.BaseFragment;

public class MusicRecommendFragment extends BaseFragment {
    private static final String TAG = "MusicRecommendFragment";
    public ViewPager viewPager;
    private boolean shouldContinue = true;
    private RelativeLayout container;
    private MusicRecommendViewPagerAdapter adapter;
    private int[] imgIds = {R.mipmap.num1, R.mipmap.num2, R.mipmap.num3,
            R.mipmap.num4, R.mipmap.num5};
    private Handler handler = new Handler(Looper.getMainLooper());

    private GridView musicListGridView;
    private MusicRecommendGridViewMusicListAdapter musicListAdapter;
    private GridView newListOnSellGridView;
    private MusicRecommendGridViewOnSellAdapter onSellAdapter;
    private GridView hotSellAlbumGridView;
    private MusicRecommendGridViewHotSellAlbumAdapter albumAdapter;
    private ListView todayRecommendListView;
    private MusicRecommendListViewTodayAdapter todayAdapter;
    private GridView originalMusicGridView;
    private MusicRecommendGridViewOriginalMusicAdapter originalMusicAdapter;
    private GridView hotMvGridView;
    private MusicRecommendGridViewHotMvAdapter hotMvAdapter;
    private GridView leProgramGridView;
    private MusicRecommendGridViewLeProgramAdapter leProgramAdapter;
    private ListView specialColumnListView;
    private MusicRecommendListViewSpecialColumnAdapter specialColumnAdapter;

    @Override
    protected int bindLayout() {
        return R.layout.fragment_music_recommend;
    }

    @Override
    protected void initView() {
        viewPager = bindView(R.id.viewpager_musicfragment_recommend_ad_content);
        container = bindView(R.id.rl_musicfragment_muisc_recommend_layout);
        musicListGridView = bindView(R.id.gridview_musicfragment_musiclist_recommend);
        newListOnSellGridView = bindView(R.id.gridview_musicfragment_newlist_onsell);
        hotSellAlbumGridView = bindView(R.id.gridview_musicfragment_hotsell_album);
        todayRecommendListView = bindView(R.id.lv_musicfragment_recommend_today);
        originalMusicGridView = bindView(R.id.gridview_musicfragment_original_music);
        hotMvGridView = bindView(R.id.gridview_musicfragment_hot_mv_recommend);
        leProgramGridView = bindView(R.id.gridview_musicfragment_leprogram);
        specialColumnListView = bindView(R.id.lv_musicfragment_special_column);
    }

    @Override
    protected void initData() {

        viewPager.setOffscreenPageLimit(3);
        viewPager.setPageMargin(30);
        adapter = new MusicRecommendViewPagerAdapter();
        adapter.setImgIds(imgIds);
        adapter.setContext(getContext());
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(0);
        startCirclePlay();

        musicListAdapter = new MusicRecommendGridViewMusicListAdapter();
        musicListAdapter.setContext(getContext());
        musicListGridView.setAdapter(musicListAdapter);

        onSellAdapter = new MusicRecommendGridViewOnSellAdapter();
        onSellAdapter.setContext(getContext());
        newListOnSellGridView.setAdapter(onSellAdapter);

        albumAdapter = new MusicRecommendGridViewHotSellAlbumAdapter();
        albumAdapter.setContext(getContext());
        hotSellAlbumGridView.setAdapter(albumAdapter);

        todayAdapter = new MusicRecommendListViewTodayAdapter();
        todayAdapter.setContext(getContext());
        todayRecommendListView.setAdapter(todayAdapter);

        originalMusicAdapter = new MusicRecommendGridViewOriginalMusicAdapter();
        originalMusicAdapter.setContext(getContext());
        originalMusicGridView.setAdapter(originalMusicAdapter);

        hotMvAdapter = new MusicRecommendGridViewHotMvAdapter();
        hotMvAdapter.setContext(getContext());
        hotMvGridView.setAdapter(hotMvAdapter);

        leProgramAdapter = new MusicRecommendGridViewLeProgramAdapter();
        leProgramAdapter.setContext(getContext());
        leProgramGridView.setAdapter(leProgramAdapter);

        specialColumnAdapter = new MusicRecommendListViewSpecialColumnAdapter();
        specialColumnAdapter.setContext(getContext());
        specialColumnListView.setAdapter(specialColumnAdapter);

    }

    private void startCirclePlay() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(shouldContinue) {
                    SystemClock.sleep(3000);
                    changeCirclePlayImg();
                }
            }
        }).start();
    }

    private void changeCirclePlayImg() {

        handler.post(new Runnable() {
            @Override
            public void run() {
                viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
            }
        });
    }

    @Override
    protected void initListener() {
        container.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return viewPager.dispatchTouchEvent(event);
            }
        });
    }

    //当销毁的时候进行线程的停止运行
    @Override
    public void onDetach() {
        super.onDetach();
        shouldContinue = false;
    }
}
