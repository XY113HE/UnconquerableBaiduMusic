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
import android.os.Parcelable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.huoer.unconquerablebaidumusic.R;
import com.huoer.unconquerablebaidumusic.adapter.MainFragmentViewPagerAdapter;
import com.huoer.unconquerablebaidumusic.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

public class MainFragment extends BaseFragment implements View.OnClickListener {
    private static final String TAG = "MainFragment";
    private final int MYLOGIN_JUMP = 0;
    private final int SURCHMUSIC_JUMP = 1;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private MainFragmentViewPagerAdapter adapter;
    private List<Fragment> fragmentList;
    private String[] titles = new String[]{"我的", "音乐", "动态", "发现"};

    private ImageView jumpMyLogin, jumpSurchMusic;
    private FragmentButtonClick fragmentButtonClick;

    public void setFragmentButtonClick(FragmentButtonClick fragmentButtonClick) {
        this.fragmentButtonClick = fragmentButtonClick;
    }

    @Override
    protected int bindLayout() {
        return R.layout.fragment_main;
    }

    @Override
    protected void initView() {
        viewPager = bindView(R.id.viewpager_mainfragment);
        tabLayout = bindView(R.id.tablayout_mainfragment);
        jumpMyLogin = bindView(R.id.iv_jump_mylogin);
        jumpSurchMusic = bindView(R.id.iv_jump_surchmusic);
    }

    @Override
    protected void initData() {
        Log.e(TAG, "initData: ");
        fragmentList = new ArrayList<Fragment>();
        fragmentList.add(new MineFragemnt());
        fragmentList.add(new MusicFragment());
        fragmentList.add(new ActionFragment());
        fragmentList.add(new FindFragment());

        adapter = new MainFragmentViewPagerAdapter(getChildFragmentManager());
        adapter.setFragmentList(fragmentList);
        viewPager.setAdapter(adapter);

        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#00000000"));

        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            tabLayout.getTabAt(i).setText(titles[i]);
        }
    }

    @Override
    protected void initListener() {
        jumpMyLogin.setOnClickListener(this);
        jumpSurchMusic.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_jump_mylogin:
                fragmentButtonClick.onFragmentButtonClick(MYLOGIN_JUMP);
                break;
            case R.id.iv_jump_surchmusic:
                fragmentButtonClick.onFragmentButtonClick(SURCHMUSIC_JUMP);
                break;
        }
    }

    public interface FragmentButtonClick{
        void onFragmentButtonClick(int which);
    }
}
