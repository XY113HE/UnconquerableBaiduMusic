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
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.text.TextUtils;
import android.util.Log;
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
import com.huoer.unconquerablebaidumusic.activity.LoginInActivity;
import com.huoer.unconquerablebaidumusic.base.BaseFragment;
import com.huoer.unconquerablebaidumusic.bean.UserInfoBean;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

public class MineFragemnt extends BaseFragment implements View.OnClickListener {
    private static final String TAG = "MineFragemnt";
    private TextView randomTry;
    private ImageView headImg;
    private TextView username, loginRightNow;
    private TextView userinfo;
    private View loginInBottomView, loginOutBottomView;
    private ImageView collectHint;
    private RelativeLayout loginLayout;

    private boolean isLoginIn;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        EventBus.getDefault().register(this);
    }

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
        loginRightNow = bindView(R.id.tv_minefragment_login);

    }

    @Override
    protected void initData() {
        SharedPreferences sp = getContext().getSharedPreferences("user_state", Context.MODE_PRIVATE);
        isLoginIn = sp.getBoolean("login", false);
        if(isLoginIn){
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

        }else {
            headImg.setImageResource(R.mipmap.img_titlebar_login);
            username.setText("立即登录");
            userinfo.setText("收藏的歌曲永不丢失");

            loginLayout.setVisibility(View.VISIBLE);
            loginOutBottomView.setVisibility(View.VISIBLE);
            collectHint.setVisibility(View.INVISIBLE);
            loginInBottomView.setVisibility(View.INVISIBLE);
        }
    }



    @Override
    protected void initListener() {
        randomTry.setOnClickListener(this);

        username.setOnClickListener(this);
        loginRightNow.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_random_music:
                break;
            case R.id.tv_user_name:
                if(!isLoginIn){
                    startActivityForResult(new Intent(getContext(), LoginInActivity.class), 200);
                }
                break;
            case R.id.tv_minefragment_login:
                if(!isLoginIn){
                    startActivityForResult(new Intent(getContext(), LoginInActivity.class), 200);
                }
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.e(TAG, "onActivityResult: ");
        if (data != null && requestCode == 200 && resultCode == 100) {
            String url = data.getStringExtra("headurl");
            String nickname = data.getStringExtra("nickname");
            Log.e(TAG, "onActivityResult: " + url + ", " + nickname);
            if (!TextUtils.isEmpty(url) && !TextUtils.isEmpty(nickname)) {
                Log.e(TAG, "onActivityResult: ");
                SharedPreferences sp = getContext().getSharedPreferences("user_state", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("headurl", url);
                editor.putString("nickname", nickname);
                editor.commit();

            }
            initData();
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void userLoginStateChanged(UserInfoBean userInfoBean){
        Log.e(TAG, "userLoginStateChanged: ");
        initData();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        EventBus.getDefault().unregister(this);
    }
}
