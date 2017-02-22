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

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.huoer.unconquerablebaidumusic.R;
import com.huoer.unconquerablebaidumusic.adapter.MusicFragmentViewPagerAdapter;
import com.huoer.unconquerablebaidumusic.base.BaseFragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MusicFragment extends BaseFragment {
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private String[] tabtitles = {"推荐", "歌单", "榜单", "视频", "K歌"};
    private MusicFragmentViewPagerAdapter adapter;
    private List<Fragment> fragmentList;

    @Override
    protected int bindLayout() {
        return R.layout.fragment_music;
    }

    @Override
    protected void initView() {
        viewPager = bindView(R.id.viewpager_musicfragment);
        tabLayout = bindView(R.id.tablayout_musicfragment);
    }

    @Override
    protected void initData() {
        fragmentList = new ArrayList<Fragment>();
        fragmentList.add(new MusicRecommendFragment());
        fragmentList.add(new MusicSongFragment());
        fragmentList.add(new MusicTopFragment());
        fragmentList.add(new MusicMovieFragment());
        fragmentList.add(new MusicPKFragment());
        //TODO

        adapter = new MusicFragmentViewPagerAdapter(getChildFragmentManager());
        adapter.setData(Arrays.asList(tabtitles));
        adapter.setFragmentList(fragmentList);
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(5);
        tabLayout.setupWithViewPager(viewPager);
        for (int i = 0; i < tabLayout.getTabCount(); i++){
            tabLayout.getTabAt(i).setText(tabtitles[i]);
        }
    }

    @Override
    protected void initListener() {

    }
}
