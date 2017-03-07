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
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
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
import com.huoer.unconquerablebaidumusic.bean.MusicRecommendBean;
import com.huoer.unconquerablebaidumusic.bean.MusicRecommendCircleBean;
import com.huoer.unconquerablebaidumusic.inter.MyCallBack;
import com.huoer.unconquerablebaidumusic.nettools.NetTools;

import java.util.ArrayList;
import java.util.List;

public class MusicRecommendFragment extends BaseFragment {
    private static final String TAG = "MusicRecommendFragment";
    public ViewPager viewPager;
    private boolean shouldContinue = true;
    private boolean shouldDestory = false;
    private RelativeLayout container;
    private MusicRecommendViewPagerAdapter adapter;
    private MusicRecommendCircleBean musicRecommendCircleBean;

    private Handler handler = new Handler(Looper.getMainLooper());
    private LinearLayout linearLayout;
    private List<View> viewList;

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
    private int lastId = 0;

    private MusicRecommendBean musicRecommendBean;

    private ImageView adImage;
    private TextView adTitle, adDesc;

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
        linearLayout = bindView(R.id.ll_musicfragment_recommend_ad_content_tag);

        adImage = bindView(R.id.iv_musicfragment_recommend_ad);
        adTitle = bindView(R.id.tv_musicfragment_recommend_ad_title);
        adDesc = bindView(R.id.tv_musicfragment_recommend_ad_content);
    }

    @Override
    protected void initData() {

        viewPager.setOffscreenPageLimit(3);
        viewPager.setPageMargin(30);
        String viewPagerUrl = "http://tingapi.ting.baidu.com/v1/restserver/ting?method=baidu.ting.plaza.getFocusPic&format=json&from=ios&version=5.2.3&from=ios&channel=appstore";
        NetTools.getInstance().startRequest(viewPagerUrl, MusicRecommendCircleBean.class, new MyCallBack<MusicRecommendCircleBean>() {
            @Override
            public void success(MusicRecommendCircleBean respomse) {
                musicRecommendCircleBean = respomse;
                adapter = new MusicRecommendViewPagerAdapter();
                adapter.setPicBeanList(respomse.getPic());
                adapter.setContext(getContext());
                viewPager.setAdapter(adapter);
                viewPager.setCurrentItem(0);
                startCirclePlay();
                viewList = new ArrayList<View>();
                createViewPagerTag();
                viewPagerAddView();
            }

            @Override
            public void error(Throwable throwable) {

            }
        });

        String url = "http://tingapi.ting.baidu.com/v1/restserver/ting?from=android&version=5.9.8.1&channel=xiaomi&operator=0&method=baidu.ting.plaza.index&cuid=F5143A6FD911";

        NetTools.getInstance().startRequest(url, MusicRecommendBean.class, new MyCallBack<MusicRecommendBean>() {
            @Override
            public void success(MusicRecommendBean respomse) {
                musicRecommendBean = respomse;

                albumAdapter = new MusicRecommendGridViewHotSellAlbumAdapter();
                albumAdapter.setResultBeanXXXList(respomse.getResult().getMix_22().getResult());
                albumAdapter.setContext(getContext());
                hotSellAlbumGridView.setAdapter(albumAdapter);

                originalMusicAdapter = new MusicRecommendGridViewOriginalMusicAdapter();
                originalMusicAdapter.setResultBeanList(respomse.getResult().getMix_9().getResult());
                originalMusicAdapter.setContext(getContext());
                originalMusicGridView.setAdapter(originalMusicAdapter);

                musicListAdapter = new MusicRecommendGridViewMusicListAdapter();
                musicListAdapter.setResultBeanXXXXList(respomse.getResult().getDiy().getResult());
                musicListAdapter.setContext(getContext());
                musicListGridView.setAdapter(musicListAdapter);

//                Glide.with(getContext()).load(respomse.getResult().getMix_2().getResult().get(0).getPic()).into(adImage);
//                adTitle.setText(respomse.getResult().getMix_2().getResult().get(0).getTitle());
//                String desc = respomse.getResult().getMix_2().getResult().get(0).getDesc();
//                adDesc.setText(desc);

                hotMvAdapter = new MusicRecommendGridViewHotMvAdapter();
                hotMvAdapter.setResultBeanXXXXXXXList(respomse.getResult().getMix_5().getResult());
                hotMvAdapter.setContext(getContext());
                hotMvGridView.setAdapter(hotMvAdapter);

                leProgramAdapter = new MusicRecommendGridViewLeProgramAdapter();
                leProgramAdapter.setResultBeanXXXXXXXXList(respomse.getResult().getRadio().getResult());
                leProgramAdapter.setContext(getContext());
                leProgramGridView.setAdapter(leProgramAdapter);

                specialColumnAdapter = new MusicRecommendListViewSpecialColumnAdapter();
                specialColumnAdapter.setResultBeanXXXXXXList(respomse.getResult().getMod_7().getResult());
                specialColumnAdapter.setContext(getContext());
                specialColumnListView.setAdapter(specialColumnAdapter);


                onSellAdapter = new MusicRecommendGridViewOnSellAdapter();
                onSellAdapter.setResultBeanXXXXXXXXXXXList(respomse.getResult().getMix_1().getResult());
                onSellAdapter.setContext(getContext());
                newListOnSellGridView.setAdapter(onSellAdapter);

                todayAdapter = new MusicRecommendListViewTodayAdapter();
                todayAdapter.setResultBeanXXXXXXXXXList(respomse.getResult().getRecsong().getResult());
                todayAdapter.setContext(getContext());
                todayRecommendListView.setAdapter(todayAdapter);
            }

            @Override
            public void error(Throwable throwable) {

            }
        });


















        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                int nowId = 1008600 + (position % viewList.size());
                if (lastId == 0) {
                    v.findViewById(nowId).setSelected(true);
                    lastId = nowId;
                } else {
                    v.findViewById(lastId).setSelected(false);
                    v.findViewById(nowId).setSelected(true);
                    lastId = nowId;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    private void viewPagerAddView() {
        for (int i = 0; i < viewList.size(); i++) {
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(20, 10);
            params.setMargins(5, 0, 5, 0);
            linearLayout.addView(viewList.get(i), params);

        }
    }

    private void createViewPagerTag() {

        for (int i = 0; i < musicRecommendCircleBean.getPic().size(); i++) {
            View view = LayoutInflater.from(getContext()).inflate(R.layout.item_viewpager_tag, null);
            view.setId(1008600 + i);
            viewList.add(view);

        }
    }

    private void startCirclePlay() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (!shouldDestory) {
                    if(shouldContinue){

                        SystemClock.sleep(3000);
                        changeCirclePlayImg();
                    }
                    SystemClock.sleep(500);
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

    //在这个阶段控制线程的循环开始
    @Override
    public void onResume() {
        super.onResume();
        shouldContinue = true;
    }

    //在这个阶段控制线程的循环结束
    @Override
    public void onPause() {
        super.onPause();
        shouldContinue = false;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        shouldDestory = true;
    }
}
