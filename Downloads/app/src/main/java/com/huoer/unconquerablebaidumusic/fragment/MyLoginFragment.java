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
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.huoer.unconquerablebaidumusic.R;
import com.huoer.unconquerablebaidumusic.activity.LoginInActivity;
import com.huoer.unconquerablebaidumusic.adapter.MyLoginListViewAdapter;
import com.huoer.unconquerablebaidumusic.base.BaseFragment;
import com.huoer.unconquerablebaidumusic.bean.UserInfoBean;

import org.greenrobot.eventbus.EventBus;

public class MyLoginFragment extends BaseFragment implements View.OnClickListener, View.OnTouchListener {
    private static final String TAG = "MyLoginFragment";
    private ListView listView;
    private String[] titles = {"我的消息", "我的积分", "成为白金VIP", "免流量听歌",
            "邀请有奖", "设置", "定时关闭", "电脑导歌", "精品应用"};
    private int[] imgIds = {R.mipmap.icon_option_setting_my_message, R.mipmap.icon_option_setting_user_points,
            R.mipmap.icon_option_setting_vip2, R.mipmap.icon_option_setting_flow_package, R.mipmap.icon_option_setting_invite_friends,
            R.mipmap.icon_option_setting_setting, R.mipmap.icon_option_setting_auto_close,
            R.mipmap.icon_option_setting_pc_sync, R.mipmap.icon_option_setting_app_recommend,};
    private MyLoginListViewAdapter adapter;
    private TextView backMain;
    private ImageView signIn;
    private boolean isSignIn;
    private TextView loginInText;
    private boolean isLoginIn;
    private SharedPreferences sp;
    private ImageView headImg;
    private TextView username, loginhint;
    private ImageView level;

    @Override
    protected int bindLayout() {
        return R.layout.fragment_mylogin;
    }

    @Override
    protected void initView() {
        listView = bindView(R.id.lv_myloginfragment);
        backMain = bindView(R.id.tv_myloginfragment_topbar);
        signIn = bindView(R.id.iv_item_mylogin_topbar_loginicon);
        loginInText = bindView(R.id.tv_item_mylogin_topbar_username);
        headImg = bindView(R.id.iv_item_mylogin_topbar_headimg);
        username = bindView(R.id.tv_item_mylogin_topbar_username);
        loginhint = bindView(R.id.iv_item_mylogin_login_hint);
        level = bindView(R.id.iv_item_mylogin_topbar_level);
    }

    @Override
    protected void initData() {

        sp = getContext().getSharedPreferences("user_state", Context.MODE_PRIVATE);
        isSignIn = sp.getBoolean("sign", false);
        isLoginIn = sp.getBoolean("login", false);
        Log.e(TAG, "initData: " + "sign"+isSignIn+", login"+isLoginIn);
        adapter = new MyLoginListViewAdapter();
        adapter.setContext(getContext());
        adapter.setTitles(titles);
        adapter.setImgIds(imgIds);
        listView.setAdapter(adapter);

        if (isLoginIn) {
            Log.e(TAG, "initData: isLoginIn");
            if (isSignIn) {
                signIn.setImageResource(R.mipmap.bt_option_setting_sign_in_done);
                Log.e(TAG, "initData: isSignIn");
            } else {
                signIn.setImageResource(R.mipmap.bt_option_setting_sign_in_normal);
            }

            String url = sp.getString("headurl", "");
            Log.e(TAG, "initData: " + url);
            if (!TextUtils.isEmpty(url)) {
                Glide.with(getContext()).load(url).asBitmap().centerCrop().into(new BitmapImageViewTarget(headImg) {
                    @Override
                    protected void setResource(Bitmap resource) {
                        RoundedBitmapDrawable circularBitmapDrawable =
                                RoundedBitmapDrawableFactory.create(getContext().getResources(), resource);
                        circularBitmapDrawable.setCircular(true);
                        headImg.setImageDrawable(circularBitmapDrawable);
                    }
                });
            }

            String nickname = sp.getString("nickname", "");
            Log.e(TAG, "initData: " + nickname);
            if (!TextUtils.isEmpty(nickname)) {
                username.setText(nickname);
            }

            level.setVisibility(View.VISIBLE);
            loginhint.setVisibility(View.GONE);
            level.setImageResource(R.mipmap.icon_user_level_8);

            adapter.setLoginIn(true);

        } else {
            signIn.setImageResource(R.mipmap.bt_option_setting_sign_in_normal);

            headImg.setImageResource(R.mipmap.img_option_setting_user);
            username.setText(" 立即登录");
            level.setVisibility(View.GONE);
            loginhint.setVisibility(View.VISIBLE);
        }
        adapter.setLoginStateListener(new MyLoginListViewAdapter.LoginStateChanged() {
            @Override
            public void updateView() {
                initData();
                UserInfoBean userInfoBean = new UserInfoBean();
                String url = sp.getString("headurl", "");
                String nickname = sp.getString("nickname", "");
                boolean isLogin = sp.getBoolean("login", false);
                userInfoBean.setHeadurl(url);
                userInfoBean.setName(nickname);
                userInfoBean.setLogin(isLogin);
                EventBus.getDefault().post(userInfoBean);
                Log.e(TAG, "updateView: post");
            }
        });

    }

    @Override
    protected void initListener() {
        backMain.setOnClickListener(this);
        signIn.setOnClickListener(this);
        loginInText.setOnClickListener(this);
        v.setOnTouchListener(this);
    }

    @Override
    public void onClick(View v) {


        switch (v.getId()) {
            case R.id.tv_myloginfragment_topbar:
                getFragmentManager().popBackStack();
                break;
            case R.id.iv_item_mylogin_topbar_loginicon:
                if (isLoginIn) {

                    //TODO 显示签到后的效果
                    if (!isSignIn) {
                        SharedPreferences.Editor editor = sp.edit();
                        editor.putBoolean("sign", true);
                        editor.commit();

                        Toast.makeText(getContext(), "签到成功", Toast.LENGTH_SHORT).show();

                        isSignIn = true;
                        signIn.setImageResource(R.mipmap.bt_option_setting_sign_in_done);
                    }
                } else {
                    startActivityForResult(new Intent(getContext(), LoginInActivity.class), 200);
                }
                break;
            case R.id.tv_item_mylogin_topbar_username:

                if (!isLoginIn) {
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

                Glide.with(getContext()).load(url).asBitmap().centerCrop().into(new BitmapImageViewTarget(headImg) {
                    @Override
                    protected void setResource(Bitmap resource) {
                        RoundedBitmapDrawable circularBitmapDrawable =
                                RoundedBitmapDrawableFactory.create(getContext().getResources(), resource);
                        circularBitmapDrawable.setCircular(true);
                        headImg.setImageDrawable(circularBitmapDrawable);
                    }
                });
                username.setText(nickname);
                level.setVisibility(View.VISIBLE);
                loginhint.setVisibility(View.GONE);
                level.setImageResource(R.mipmap.icon_user_level_8);
                if(sp.getBoolean("sign", false)){
                   signIn.setImageResource(R.mipmap.bt_option_setting_sign_in_done);
                }else{
                   signIn.setImageResource(R.mipmap.bt_option_setting_sign_in_normal);
                }
                isLoginIn = sp.getBoolean("login", false);
                adapter.setLoginIn(true);
            }
        }


        EventBus.getDefault().post(new UserInfoBean());
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        return true;
    }
}
