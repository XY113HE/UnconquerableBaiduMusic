package com.huoer.unconquerablebaidumusic.activity;


import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;


import com.huoer.unconquerablebaidumusic.R;

import com.huoer.unconquerablebaidumusic.base.BaseActivity;
import com.huoer.unconquerablebaidumusic.fragment.MainFragment;
import com.huoer.unconquerablebaidumusic.fragment.MyLoginFragment;
import com.huoer.unconquerablebaidumusic.fragment.SurchMusicFragment;


public class MainActivity extends BaseActivity implements MainFragment.FragmentButtonClick {
    private FragmentManager fragmentManager;
    private final int MYLOGIN_JUMP = 0;
    private final int SURCHMUSIC_JUMP = 1;

    @Override
    protected int bindLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        MainFragment fragment = new MainFragment();
        fragment.setFragmentButtonClick(this);
        ft.add(R.id.frame_mainactivity, fragment);
        ft.commit();

    }

    @Override
    protected void initListener() {

    }

    @Override
    public void onFragmentButtonClick(int which) {
        FragmentTransaction ft = fragmentManager.beginTransaction();

        switch (which){
            case MYLOGIN_JUMP:
                ft.setCustomAnimations(R.anim.anim_fragment_right_in, R.anim.anim_fragment_right_out,
                        R.anim.anim_fragment_right_in_back, R.anim.anim_fragment_right_out_back);
                ft.replace(R.id.frame_mainactivity, new MyLoginFragment());
                ft.addToBackStack(null);
                ft.commit();
                break;
            case SURCHMUSIC_JUMP:
                ft.setCustomAnimations(R.anim.anim_fragment_left_in, R.anim.anim_fragment_left_out,
                        R.anim.anim_fragment_left_in_back, R.anim.anim_fragment_left_out_back);
                ft.replace(R.id.frame_mainactivity, new SurchMusicFragment());
                ft.addToBackStack(null);
                ft.commit();
        }
    }


}
