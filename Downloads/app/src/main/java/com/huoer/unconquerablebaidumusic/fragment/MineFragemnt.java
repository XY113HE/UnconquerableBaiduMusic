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

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.huoer.unconquerablebaidumusic.R;
import com.huoer.unconquerablebaidumusic.base.BaseFragment;
import com.huoer.unconquerablebaidumusic.bean.UserInfoBean;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

public class MineFragemnt extends BaseFragment{
    private TextView randomTry;
    private ImageView headImg;
    private TextView username;
    private TextView userinfo;
    private View loginInBottomView, loginOutBottomView;
    private ImageView collectHint;
    private RelativeLayout loginLayout;


    @Override
    protected int bindLayout() {
        return R.layout.fragment_mine;
    }

    @Override
    protected void initView() {
        randomTry = bindView(R.id.tv_random_music);
        headImg = bindView(R.id.iv_user_head);
        username = bindView(R.id.tv_user_name);
        userinfo = bindView(R.id.tv_user_content);
        loginInBottomView = bindView(R.id.login_in_bottom_view);
        loginOutBottomView = bindView(R.id.login_out_bottom_view);
        collectHint = bindView(R.id.iv_minefragment_collect);
        loginLayout = bindView(R.id.rl_musicfragment_login);

    }

    @Override
    protected void initData() {
        SharedPreferences sp = getContext().getSharedPreferences("user_state", Context.MODE_PRIVATE);
        if(sp.getBoolean("login", false)){
            String url = sp.getString("headurl", null);
            String name = sp.getString("nickname", null);
            if(!TextUtils.isEmpty(url) && !TextUtils.isEmpty(name)){

                Glide.with(getContext()).load(url).asBitmap().centerCrop().into(new BitmapImageViewTarget(headImg) {
                    @Override
                    protected void setResource(Bitmap resource) {
                        RoundedBitmapDrawable circularBitmapDrawable =
                                RoundedBitmapDrawableFactory.create(getContext().getResources(), resource);
                        circularBitmapDrawable.setCircular(true);
                        headImg.setImageDrawable(circularBitmapDrawable);
                    }
                });
                username.setText(name);
                userinfo.setText("动态 0    关注 2    粉丝 0");
                loginLayout.setVisibility(View.INVISIBLE);
                loginOutBottomView.setVisibility(View.INVISIBLE);
                collectHint.setVisibility(View.VISIBLE);
                loginInBottomView.setVisibility(View.VISIBLE);
            }

        }
    }



    @Override
    protected void initListener() {
        randomTry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }


}
