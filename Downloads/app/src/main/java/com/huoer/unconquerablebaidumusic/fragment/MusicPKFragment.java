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
import com.huoer.unconquerablebaidumusic.bean.MusicPkListBean;
import com.huoer.unconquerablebaidumusic.bean.MusicPkWeSingBean;
import com.huoer.unconquerablebaidumusic.bean.PKViewPagerImgBean;
import com.huoer.unconquerablebaidumusic.inter.MyCallBack;
import com.huoer.unconquerablebaidumusic.nettools.NetTools;

import java.util.ArrayList;
import java.util.List;

public class MusicPKFragment extends BaseFragment {
    private static final String TAG = "MusicPKFragment";
    private ViewPager viewPager;
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

    private MusicPkWeSingBean musicPkWeSingBean;
    private MusicPkListBean musicPkListBean;

    private int[] imgIds = {R.mipmap.img_k_ktv, R.mipmap.img_k_chinese, R.mipmap.img_k_occident
            ,R.mipmap.img_k_man ,R.mipmap.img_k_woman, R.mipmap.img_k_band};


    private PKViewPagerImgBean pkViewPagerImgBean;

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

        String url = "http://tingapi.ting.baidu.com/v1/restserver/ting?from=android&version=5.9.8.1&channel=1426d&operator=3&method=baidu.ting.active.showList";
        NetTools.getInstance().startRequest(url, PKViewPagerImgBean.class, new MyCallBack<PKViewPagerImgBean>() {
            @Override
            public void success(PKViewPagerImgBean respomse) {
                pkViewPagerImgBean = respomse;
                adapter.setResultBeanList(respomse.getResult());

                createViewPagerTag();
                viewPagerAddView();


                adapter.setContext(getContext());
                viewPager.setAdapter(adapter);
                viewPager.setOffscreenPageLimit(3);
                viewPager.setCurrentItem(0);
                startCirclePlay();
            }

            @Override
            public void error(Throwable throwable) {
                Log.e(TAG, "error: fail to internet");
            }
        });



        viewList = new ArrayList<View>();

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

        final String weSingUrl = "http://tingapi.ting.baidu.com/v1/restserver/ting?from=android&version=5.9.8.1&channel=1413b&operator=1&method=baidu.ting.learn.now&page_size=50";
        NetTools.getInstance().startRequest(weSingUrl, MusicPkWeSingBean.class, new MyCallBack<MusicPkWeSingBean>() {
            @Override
            public void success(MusicPkWeSingBean respomse) {
                musicPkWeSingBean = respomse;
                weSingAdapter = new MusicPKListViewWeSingAdapter();
                weSingAdapter.setItemsBeanList(respomse.getResult().getItems());
                weSingAdapter.setContext(getContext());
                weSingListView.setAdapter(weSingAdapter);
            }

            @Override
            public void error(Throwable throwable) {

            }
        });

        String listUrl = "http://tingapi.ting.baidu.com/v1/restserver/ting?from=android&version=5.9.8.1&channel=1413b&operator=1&method=baidu.ting.learn.category";
        NetTools.getInstance().startRequest(listUrl, MusicPkListBean.class, new MyCallBack<MusicPkListBean>() {
            @Override
            public void success(MusicPkListBean respomse) {
                musicPkListBean = respomse;
                myPkAdapter = new MusicPKGridViewMyPkAdapter();
                myPkAdapter.setItemsBeanList(respomse.getResult().getItems());
                myPkAdapter.setImgIds(imgIds);
                myPkAdapter.setContext(getContext());
                myPkGridView.setAdapter(myPkAdapter);
            }

            @Override
            public void error(Throwable throwable) {

            }
        });





    }

    private void viewPagerAddView() {
        for (int i = 0; i < viewList.size(); i++){
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(20, 10);
            params.setMargins(5, 0, 5, 0);
            viewPagerTag.addView(viewList.get(i), params);

        }
    }

    private void createViewPagerTag() {

        for(int i = 0; i < pkViewPagerImgBean.getResult().size(); i++){
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
