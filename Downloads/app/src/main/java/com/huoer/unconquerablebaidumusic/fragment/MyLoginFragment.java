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
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.huoer.unconquerablebaidumusic.R;
import com.huoer.unconquerablebaidumusic.activity.LoginInActivity;
import com.huoer.unconquerablebaidumusic.adapter.MyLoginListViewAdapter;
import com.huoer.unconquerablebaidumusic.base.BaseFragment;

public class MyLoginFragment extends BaseFragment implements View.OnClickListener {
    private ListView listView;
    private String[] titles = {"我的消息", "我的积分", "成为白金VIP",
            "邀请有奖", "设置", "定时关闭", "电脑导歌", "精品应用"};
    private int[] imgIds = {R.mipmap.icon_option_setting_my_message, R.mipmap.icon_option_setting_user_points,
         R.mipmap.icon_option_setting_vip2, R.mipmap.icon_option_setting_invite_friends,
            R.mipmap.icon_option_setting_setting, R.mipmap.icon_option_setting_auto_close,
            R.mipmap.icon_option_setting_pc_sync, R.mipmap.icon_option_setting_app_recommend,};
    private MyLoginListViewAdapter adapter;
    private TextView backMain;
    private ImageView signIn;
    private boolean isSignIn;
    private TextView loginInText;
    private boolean isLoginIn;
    private SharedPreferences sp;

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
    }

    @Override
    protected void initData() {
        sp = getContext().getSharedPreferences("user_state", Context.MODE_PRIVATE);
        adapter = new MyLoginListViewAdapter();
        adapter.setContext(getContext());
        adapter.setTitles(titles);
        adapter.setImgIds(imgIds);
        listView.setAdapter(adapter);
        isSignIn = sp.getBoolean("sign", false);
//        addHeadView();
//        listView.setNestedScrollingEnabled(false);//API21
    }

    private void addHeadView() {

        View headView = LayoutInflater.from(getContext()).inflate(R.layout.item_mylogin_head_view, null);
        TextView username;
        ImageView level, headimg;
        username = (TextView) headView.findViewById(R.id.tv_item_mylogin_topbar_username);
        level = (ImageView) headView.findViewById(R.id.iv_item_mylogin_topbar_level);
        headimg = (ImageView) headView.findViewById(R.id.iv_item_mylogin_topbar_headimg);
        listView.addHeaderView(headView);
    }



    @Override
    protected void initListener() {
        backMain.setOnClickListener(this);
        signIn.setOnClickListener(this);
        loginInText.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.tv_myloginfragment_topbar:
                getFragmentManager().popBackStack();
                break;
            case R.id.iv_item_mylogin_topbar_loginicon:
                //TODO 显示签到后的效果
                if(!isSignIn){
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putBoolean("sign", true);
                    editor.commit();

                    Toast.makeText(getContext(), "签到成功", Toast.LENGTH_SHORT).show();

                    isSignIn = true;
                    signIn.setImageResource(R.mipmap.bt_option_setting_sign_in_done);
                }
                break;
            case R.id.tv_item_mylogin_topbar_username:
                isLoginIn = sp.getBoolean("login", false);
                if(!isLoginIn){
                    startActivity(new Intent(getContext(), LoginInActivity.class));
                }
                break;
        }
    }
}
