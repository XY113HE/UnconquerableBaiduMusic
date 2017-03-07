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
import com.huoer.unconquerablebaidumusic.bean.MusicTopBean;
import com.huoer.unconquerablebaidumusic.inter.MyCallBack;
import com.huoer.unconquerablebaidumusic.nettools.NetTools;

public class MusicTopFragment extends BaseFragment {
    private ListView listView;
    private MusicTopFragmentListViewAdapter adapter;
    private MusicTopBean musicTopBean;

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
        String url = "http://tingapi.ting.baidu.com/v1/restserver/ting?from=android&version=5.9.8.1&channel=1426d&operator=3&method=baidu.ting.billboard.billCategory&format=json&kfl";
        NetTools.getInstance().startRequest(url, MusicTopBean.class, new MyCallBack<MusicTopBean>() {
            @Override
            public void success(MusicTopBean respomse) {
                musicTopBean = respomse;
                adapter.setContentBeanXList(respomse.getContent());

                adapter.setContext(getContext());
                listView.setAdapter(adapter);
            }

            @Override
            public void error(Throwable throwable) {

            }
        });

    }

    @Override
    protected void initListener() {

    }
}
