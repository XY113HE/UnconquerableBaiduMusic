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
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.widget.ImageView;

import com.huoer.unconquerablebaidumusic.R;
import com.huoer.unconquerablebaidumusic.base.BaseActivity;

public class LoadDataActivity extends BaseActivity {
    private ImageView loaddataImg;
    private Handler handler = new Handler(Looper.getMainLooper());
    private int[] imgIds = new int[]{R.mipmap.loaddata, };

    @Override
    protected int bindLayout() {
        return R.layout.activity_loaddata;
    }

    @Override
    protected void initView() {
        loaddataImg = bindView(R.id.iv_loaddata);
    }

    @Override
    protected void initData() {
        delayJump();
    }

    private void delayJump() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                SystemClock.sleep(1000);
                startActivity(new Intent(LoadDataActivity.this, MainActivity.class));
                finish();
            }
        }).start();
    }

    @Override
    protected void initListener() {

    }
}
