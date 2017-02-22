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
import android.widget.GridView;
import android.widget.ListView;

import com.huoer.unconquerablebaidumusic.R;
import com.huoer.unconquerablebaidumusic.adapter.MusicPKGridViewMyPkAdapter;
import com.huoer.unconquerablebaidumusic.adapter.MusicPKListViewWeSingAdapter;
import com.huoer.unconquerablebaidumusic.adapter.MusicPKViewPagerAdapter;
import com.huoer.unconquerablebaidumusic.base.BaseFragment;

public class MusicPKFragment extends BaseFragment {
    private ViewPager viewPager;
    private int[] imgIds = {R.mipmap.img6, R.mipmap.timg2};
    private MusicPKViewPagerAdapter adapter;
    private boolean shouldContinue = true;
    private Handler handler = new Handler(Looper.getMainLooper());

    private GridView myPkGridView;
    private MusicPKGridViewMyPkAdapter myPkAdapter;
    private ListView weSingListView;
    private MusicPKListViewWeSingAdapter weSingAdapter;

    @Override
    protected int bindLayout() {
        return R.layout.fragment_music_pk;
    }

    @Override
    protected void initView() {
        viewPager = bindView(R.id.viewpager_musicfragment_pk_topimg);
        myPkGridView = bindView(R.id.gridview_musicfragment_pk_mypk);
        weSingListView = bindView(R.id.lv_musicfragment_pk);
    }

    @Override
    protected void initData() {
        adapter = new MusicPKViewPagerAdapter();
        adapter.setContext(getContext());
        adapter.setImgIds(imgIds);
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(3);
        viewPager.setCurrentItem(0);
        startCirclePlay();

        myPkAdapter = new MusicPKGridViewMyPkAdapter();
        myPkAdapter.setContext(getContext());
        myPkGridView.setAdapter(myPkAdapter);

        weSingAdapter = new MusicPKListViewWeSingAdapter();
        weSingAdapter.setContext(getContext());
        weSingListView.setAdapter(weSingAdapter);

    }



    @Override
    protected void initListener() {

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
                viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
            }
        });
    }

    @Override
    public void onDetach() {
        super.onDetach();
        shouldContinue = false;
    }
}
