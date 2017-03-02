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
import android.view.LayoutInflater;
import android.view.View;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.huoer.unconquerablebaidumusic.R;
import com.huoer.unconquerablebaidumusic.adapter.MusicPKGridViewMyPkAdapter;
import com.huoer.unconquerablebaidumusic.adapter.MusicPKListViewWeSingAdapter;
import com.huoer.unconquerablebaidumusic.adapter.MusicPKViewPagerAdapter;
import com.huoer.unconquerablebaidumusic.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

public class MusicPKFragment extends BaseFragment {
    private static final String TAG = "MusicPKFragment";
    private ViewPager viewPager;
    private int[] imgIds = {R.mipmap.img6, R.mipmap.timg2};
    private MusicPKViewPagerAdapter adapter;
    private boolean shouldContinue = true;
    private Handler handler = new Handler(Looper.getMainLooper());

    private GridView myPkGridView;
    private MusicPKGridViewMyPkAdapter myPkAdapter;
    private ListView weSingListView;
    private MusicPKListViewWeSingAdapter weSingAdapter;
    private LinearLayout viewPagerTag;
    private List<View> viewList;
    private int lastId = 0;

    @Override
    protected int bindLayout() {
        return R.layout.fragment_music_pk;
    }

    @Override
    protected void initView() {
        viewPager = bindView(R.id.viewpager_musicfragment_pk_topimg);
        myPkGridView = bindView(R.id.gridview_musicfragment_pk_mypk);
        weSingListView = bindView(R.id.lv_musicfragment_pk);
        viewPagerTag = bindView(R.id.ll_musicfragment_viewpager_tag);
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

        viewList = new ArrayList<View>();
        createViewPagerTag();
        viewPagerAddView();
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                int nowId = 1008600 + (position % viewList.size());
                if(lastId == 0) {
                    v.findViewById(nowId).setSelected(true);
                    lastId = nowId;
                }else{
                    v.findViewById(lastId).setSelected(false);
                    v.findViewById(nowId).setSelected(true);
                    lastId = nowId;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });



        myPkAdapter = new MusicPKGridViewMyPkAdapter();
        myPkAdapter.setContext(getContext());
        myPkGridView.setAdapter(myPkAdapter);

        weSingAdapter = new MusicPKListViewWeSingAdapter();
        weSingAdapter.setContext(getContext());
        weSingListView.setAdapter(weSingAdapter);

    }

    private void viewPagerAddView() {
        for (int i = 0; i < viewList.size(); i++){
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(20, 10);
            params.setMargins(5, 0, 5, 0);
            viewPagerTag.addView(viewList.get(i), params);

        }
    }

    private void createViewPagerTag() {

        for(int i = 0; i < imgIds.length; i++){
            View view = LayoutInflater.from(getContext()).inflate(R.layout.item_viewpager_tag, null);
            view.setId(1008600+i);
            viewList.add(view);

        }
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
