package com.huoer.unconquerablebaidumusic.activity;
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
import android.content.SharedPreferences;
import android.os.SystemClock;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.huoer.unconquerablebaidumusic.R;
import com.huoer.unconquerablebaidumusic.base.BaseActivity;

import org.greenrobot.eventbus.EventBus;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.OnekeyShare;
import cn.sharesdk.sina.weibo.SinaWeibo;
import cn.sharesdk.tencent.qq.QQ;

public class LoginInActivity extends BaseActivity implements View.OnClickListener {
    private static final String TAG = "LoginInActivity";
    private ImageView back;
    private EditText phoneEt, pswEt;
    private TextView loginByWeibo, loginByWeiXin, loginByQQ;
    private boolean phoneIsNull = true, pswIsNull = true;
    private Button loginBtn;
    private Platform qq;
    private Platform weibo;

    private String nickname;

    private String headurl;
    private EventBus eventBus;

    @Override
    protected int bindLayout() {
        return R.layout.activity_login_in;
    }

    @Override
    protected void initView() {
        back = bindView(R.id.iv_logininactivity_back);
        phoneEt = bindView(R.id.et_logininactivity_phonenumber);
        pswEt = bindView(R.id.et_logininactivity_password);
        loginByWeibo = bindView(R.id.tv_logininactivity_loginbyweibo);
        loginByWeiXin = bindView(R.id.tv_logininactivity_loginbyweixin);
        loginByQQ = bindView(R.id.tv_logininactivity_loginbyqq);
        loginBtn = bindView(R.id.btn_logininactivity_login);

        eventBus = EventBus.getDefault();
    }

    @Override
    protected void initData() {
        ShareSDK.initSDK(this);
    }

    @Override
    protected void initListener() {
        back.setOnClickListener(this);
        phoneEt.addTextChangedListener(new MyTextWatcher(phoneEt));
        pswEt.addTextChangedListener(new MyTextWatcher(pswEt));

        loginByWeibo.setOnClickListener(this);
        loginByWeiXin.setOnClickListener(this);
        loginByQQ.setOnClickListener(this);

        loginBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_logininactivity_back:
                OnekeyShare oks = new OnekeyShare();
                //关闭sso授权
//                oks.disableSSOWhenAuthorize();
                // title标题，印象笔记、邮箱、信息、微信、人人网、QQ和QQ空间使用
                oks.setTitle("请用两个字形容我的一生");
                // titleUrl是标题的网络链接，仅在Linked-in,QQ和QQ空间使用
                oks.setTitleUrl("http://sharesdk.cn");
                // text是分享文本，所有平台都需要这个字段
                oks.setText("大写的\"牛逼\"");
                //分享网络图片，新浪微博分享网络图片需要通过审核后申请高级写入接口，否则请注释掉测试新浪微博
                oks.setImageUrl("http://f1.sharesdk.cn/imgs/2014/02/26/owWpLZo_638x960.jpg");
                // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
                //oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
                // url仅在微信（包括好友和朋友圈）中使用
                oks.setUrl("http://sharesdk.cn");
                // comment是我对这条分享的评论，仅在人人网和QQ空间使用
                oks.setComment("我是测试评论文本");
                // site是分享此内容的网站名称，仅在QQ空间使用
                oks.setSite("ShareSDK");
                // siteUrl是分享此内容的网站地址，仅在QQ空间使用
                oks.setSiteUrl("http://sharesdk.cn");
                oks.show(LoginInActivity.this);
                finish();
                break;
            case R.id.tv_logininactivity_loginbyweibo:

                weibo = ShareSDK.getPlatform(this, SinaWeibo.NAME);
                //回调信息，可以在这里获取基本的授权返回的信息，但是注意如果做提示和UI操作要传到主线程handler里去执行
                weibo.setPlatformActionListener(new PlatformActionListener() {

                    @Override
                    public void onError(Platform arg0, int arg1, Throwable arg2) {
                        // TODO Auto-generated method stub
                        arg2.printStackTrace();
                    }

                    @Override
                    public void onComplete(Platform arg0, int arg1, HashMap<String, Object> arg2) {
                        // TODO Auto-generated method stub
                        //输出所有授权信息
                        arg0.getDb().exportData();
                    }

                    @Override
                    public void onCancel(Platform arg0, int arg1) {
                        // TODO Auto-generated method stub

                    }
                });
                weibo.showUser(null);
                finish();
                //执行登录，登录后在回调里面获取用户资料
                //weibo.showUser(“3189087725”);
                //获取账号为“3189087725”的资料
                break;
            case R.id.tv_logininactivity_loginbyqq:
                qq = ShareSDK.getPlatform(this, QQ.NAME);
                //回调信息，可以在这里获取基本的授权返回的信息，但是注意如果做提示和UI操作要传到主线程handler里去执行
                qq.setPlatformActionListener(new PlatformActionListener() {

                    @Override
                    public void onError(Platform arg0, int arg1, Throwable arg2) {
                        // TODO Auto-generated method stub
                        arg2.printStackTrace();
                    }

                    @Override
                    public void onComplete(Platform arg0, int arg1, HashMap<String, Object> arg2) {
                        // TODO Auto-generated method stub
                        //输出所有授权信息
                        arg0.getDb().exportData();
                        //遍历Map
                        Iterator ite = arg2.entrySet().iterator();
                        while (ite.hasNext()) {
                            Map.Entry entry = (Map.Entry) ite.next();
                            Object key = entry.getKey();
                            if (key.toString().equals("nickname")) {
                                nickname = entry.getValue().toString();
                                Log.e(TAG, "onComplete: " + nickname);
                            }
                            if (key.toString().equals("figureurl_qq_2")) {
                                headurl = entry.getValue().toString();
                                Log.e(TAG, "onComplete: " + headurl);

                            }

                        }

                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                SystemClock.sleep(500);
                                Intent intent = getIntent();
                                intent.putExtra("nickname", nickname);
                                intent.putExtra("headurl", headurl);
                                setResult(100, intent);
                                finish();
                            }
                        }).start();

                    }

                    @Override
                    public void onCancel(Platform arg0, int arg1) {
                        // TODO Auto-generated method stub

                    }
                });
                qq.showUser(null);

                SharedPreferences sp = getSharedPreferences("user_state", MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.putBoolean("login", true);
                editor.commit();

//                qq.removeAccount();
                //执行登录，登录后在回调里面获取用户资料
                //weibo.showUser(“3189087725”);
                //获取账号为“3189087725”的资料


                break;

            case R.id.btn_logininactivity_login:
                if (!phoneIsNull && !pswIsNull) {
                    Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
                    finish();
                }
                break;
        }
    }

    class MyTextWatcher implements TextWatcher {
        private View view;

        public MyTextWatcher(View view) {
            this.view = view;
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            if (TextUtils.isEmpty(s)) {
                if (view.getId() == R.id.et_logininactivity_phonenumber) {
                    phoneIsNull = true;
                } else {
                    pswIsNull = true;
                }
            } else {
                if (view.getId() == R.id.et_logininactivity_phonenumber) {
                    phoneIsNull = false;
                } else {
                    pswIsNull = false;
                }
            }

            if (phoneIsNull || pswIsNull) {
                loginBtn.setBackgroundResource(R.drawable.login_btn_shape_normal);
            } else {
                loginBtn.setBackgroundResource(R.drawable.login_btn_shape_press);
            }
        }
    }

//    public void onComplete(Platform platform, int action, HashMap<String, Object> res) {
//        //遍历Map
//        Iterator ite =res.entrySet().iterator();
//        while (ite.hasNext()) {
//            Map.Entry entry = (Map.Entry)ite.next();
//            Object key = entry.getKey();
//            Object value = entry.getValue();
//            System.out.println(key+"： "+value);
//        }
//    }
//    public void onComplete(Platform platform, int action, HashMap<String, Object> res) {
////用户资源都保存到res
////通过打印res数据看看有哪些数据是你想要的
//        if (action == Platform.ACTION_USER_INFOR) {
//            PlatformDb platDB = platform.getDb();//获取数平台数据DB
//            //通过DB获取各种数据
//            platDB.getToken();
//            platDB.getUserGender();
//            platDB.getUserIcon();
//            platDB.getUserId();
//            platDB.getUserName();
//        }
//    }
//    Platform weibo = ShareSDK.getPlatform(this, SinaWeibo.NAME);
//    weibo.setPlatformActionListener(paListener);
}
