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

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.huoer.unconquerablebaidumusic.R;
import com.huoer.unconquerablebaidumusic.activity.DetailsActivity;
import com.huoer.unconquerablebaidumusic.adapter.FindGridViewLiveAdapter;
import com.huoer.unconquerablebaidumusic.adapter.FindGridViewShopAdapter;
import com.huoer.unconquerablebaidumusic.base.BaseFragment;
import com.huoer.unconquerablebaidumusic.bean.FindBean;
import com.huoer.unconquerablebaidumusic.inter.MyCallBack;
import com.huoer.unconquerablebaidumusic.nettools.NetTools;

public class FindFragment extends BaseFragment {
    private static final String TAG = "FindFragment";

    private GridView shopGridView;
    private FindGridViewShopAdapter shopAdapter;
    private GridView liveGridView;
    private FindGridViewLiveAdapter liveAdapter;
    private FindBean findBean;

    @Override
    protected int bindLayout() {
        return R.layout.fragment_find;
    }

    @Override
    protected void initView() {
        shopGridView = bindView(R.id.gridview_findfragment_shop);
        liveGridView = bindView(R.id.gridview_findfragment_live);
    }

    @Override
    protected void initData() {
        String url = "http://tingapi.ting.baidu.com/v1/restserver/ting?from=android&version=5.9.8.1&channel=1426d&operator=3&method=baidu.ting.plaza.indexFind&param=WV%2FB0OohBbFuGg0xKpldarz7CAZJJXK4auqEmfBO1bA7r5yF%2F1ts1cMw%2FqXkgAkH7eNZQOWL5ksdBTJ6dz5gNxIRZboV1KztZxa0%2F3Zsdi4%3D&timestamp=1486632421&sign=2ed28fc410e34aba61e0a7f5369bc02f";
        NetTools.getInstance().startRequest(url, FindBean.class, new MyCallBack<FindBean>() {
            @Override
            public void success(FindBean respomse) {
                findBean = respomse;

                shopAdapter = new FindGridViewShopAdapter();
                shopAdapter.setShopListBeanList(respomse.getResult().getShopInfo().getShopList());
                shopAdapter.setContext(getContext());
                shopGridView.setAdapter(shopAdapter);


                liveAdapter = new FindGridViewLiveAdapter();
                liveAdapter.setLiveListBeen(respomse.getResult().getLiveInfo().getLiveList());
                liveAdapter.setContext(getContext());
                liveGridView.setAdapter(liveAdapter);
            }

            @Override
            public void error(Throwable throwable) {
                Log.e(TAG, "error: fail to internet");
            }
        });




    }

    @Override
    protected void initListener() {
        shopGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getContext(), DetailsActivity.class);
                intent.putExtra("linkurl", findBean.getResult().getShopInfo().getShopList().get(position).getLinkurl());
                intent.putExtra("title", "百度音乐& "+findBean.getResult().getShopInfo().getShopList().get(position).getTitle());
                startActivity(intent);
            }
        });
    }
}
