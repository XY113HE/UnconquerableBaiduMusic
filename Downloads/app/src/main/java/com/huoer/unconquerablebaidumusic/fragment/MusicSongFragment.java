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
import com.huoer.unconquerablebaidumusic.adapter.MusicFragmentViewPagerAdapter;
import com.huoer.unconquerablebaidumusic.adapter.MusicSongFragmentGridViewAdapter;
import com.huoer.unconquerablebaidumusic.base.BaseFragment;
import com.huoer.unconquerablebaidumusic.bean.MusicSongHotBean;
import com.huoer.unconquerablebaidumusic.bean.MusicSongNewBean;
import com.huoer.unconquerablebaidumusic.inter.MyCallBack;
import com.huoer.unconquerablebaidumusic.nettools.NetTools;

public class MusicSongFragment extends BaseFragment implements View.OnClickListener {
    private static final String TAG = "MusicSongFragment";

    private GridView gridview;
    private MusicSongFragmentGridViewAdapter adapter;
    private TextView newest, hotest;
    private RelativeLayout layout;
    private boolean topbarIsShow = true;

    private MusicSongHotBean musicSongHotBean;
    private MusicSongNewBean musicSongNewBean;


    @Override
    protected int bindLayout() {
        return R.layout.fragment_music_song;
    }

    @Override
    protected void initView() {
        gridview = bindView(R.id.gridview_musicfragment_song);
        newest = bindView(R.id.tv_musicfragment_song_newest);
        hotest = bindView(R.id.tv_musicfragment_song_hotest);
        layout = bindView(R.id.rl_musicfragment_song_topbar);
    }

    @Override
    protected void initData() {
        adapter = new MusicSongFragmentGridViewAdapter();
        String hotUrl = "http://tingapi.ting.baidu.com/v1/restserver/ting?from=android&version=5.9.8.1&channel=1426d&operator=3&method=baidu.ting.ugcdiy.getChanneldiy&param=aUeJzjQd0Bxv60bsMl1nzvktSPLjc5EcGxFAt77r3ORvfYOi0G0UiMU15Gu9rmiLXpXaecx%2BVhS3VNWrDDHaz%2FdPLIB52H4GjQR8wkaLFrrkLECGMiGJkF9toxnAK5KX&timestamp=1486632431&sign=39afa305d4a82eb67ac1f191f47f64e6";
        NetTools.getInstance().startRequest(hotUrl, MusicSongHotBean.class, new MyCallBack<MusicSongHotBean>() {
            @Override
            public void success(MusicSongHotBean respomse) {
                musicSongHotBean = respomse;

                adapter.setDiyInfoBeanListHot(respomse.getDiyInfo());
                adapter.setContext(getContext());
                gridview.setAdapter(adapter);
            }

            @Override
            public void error(Throwable throwable) {
                Log.e(TAG, "error: fail to internet");
            }
        });

        String newUrl = "http://tingapi.ting.baidu.com/v1/restserver/ting?from=android&version=5.9.8.1&channel=1426d&operator=3&method=baidu.ting.ugcdiy.getChanneldiy&param=KJ8H1UO3TQ2Et%2FEveTV%2Bt8a%2Br2jCR7fbcqsY9ZTHc%2FgPcxyOAIcHfe4iGZVwp1xZsf4wFqntc9HdlL2sikphWMvxv46i1a0Lv2h0Fsugw3e5dDTIseo7qevOW3Bi5BA3&timestamp=1486633214&sign=3cf9f2490198c06166322d80ee105843";
        NetTools.getInstance().startRequest(newUrl, MusicSongNewBean.class, new MyCallBack<MusicSongNewBean>() {
            @Override
            public void success(MusicSongNewBean respomse) {
                musicSongNewBean = respomse;
                adapter.setDiyInfoBeanListNew(respomse.getDiyInfo());
            }

            @Override
            public void error(Throwable throwable) {
                Log.e(TAG, "error: fail to internet");
            }
        });

    }

    @Override
    protected void initListener() {
        newest.setOnClickListener(this);
        hotest.setOnClickListener(this);
        gridview.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem,
                                 int visibleItemCount, int totalItemCount) {
                //当滑动到第三行组件显示的时候,进行topbar的显示隐藏控制
                if(firstVisibleItem >= 4){
                    //定义一个变量记录topbar的状态,保证显示和隐藏只执行一次
                    if(topbarIsShow){
                        topbarIsShow = false;
                        layout.setVisibility(View.INVISIBLE);
//                        layout.setAlpha(0);
                    }
                }else{
                    if(!topbarIsShow){
                        topbarIsShow = true;
                        layout.setVisibility(View.VISIBLE);
//                        layout.setAlpha(1);
                    }
                }
            }
        });



//        gridview.setOnScrollChangeListener(new View.OnScrollChangeListener() {
//            @Override
//            public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
//                Log.e(TAG, "onScrollChange: ");
//            }
//        });
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.tv_musicfragment_song_newest:
                adapter.setDataType(0);
                newest.setTextColor(Color.parseColor("#31d7ef"));
                hotest.setTextColor(Color.parseColor("#606060"));
                gridview.smoothScrollToPosition(0);
                break;
            case R.id.tv_musicfragment_song_hotest:
                adapter.setDataType(1);
                hotest.setTextColor(Color.parseColor("#31d7ef"));
                newest.setTextColor(Color.parseColor("#606060"));
                gridview.smoothScrollToPosition(0);
                break;
        }
    }
}
