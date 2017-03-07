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
import android.view.KeyEvent;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.huoer.unconquerablebaidumusic.R;
import com.huoer.unconquerablebaidumusic.base.BaseActivity;

public class DetailsActivity extends BaseActivity {
    private WebView webView;
    private TextView titleTv;

    @Override
    protected int bindLayout() {
        return R.layout.activity_details;
    }

    @Override
    protected void initView() {
        webView = bindView(R.id.webview_details_activity);
        titleTv = bindView(R.id.tv_details_activity_title);
    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        final String url = intent.getStringExtra("linkurl");
        String title = intent.getStringExtra("title");
        titleTv.setText(title);

        webView.loadUrl(url);
        //希望当前加载的内容再webView中显示
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                view.loadUrl(url);
                return true;
            }
        });
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);

    }

    @Override
    protected void initListener() {

    }
/**
 * 添加网页返回键复写后,退出会发生fragment错乱的bug
 */
//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        // TODO Auto-generated method stub
//        if(keyCode==KeyEvent.KEYCODE_BACK)
//        {
//            if(webView.canGoBack())
//            {
//                webView.goBack();//返回上一页面
//                return true;
//            }
//            else
//            {
//                System.exit(0);//退出程序
//            }
//        }
//        return super.onKeyDown(keyCode, event);
//    }
}
