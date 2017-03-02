package com.huoer.unconquerablebaidumusic.nettools;
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

import android.os.Handler;
import android.os.Looper;

import com.google.gson.Gson;
import com.huoer.unconquerablebaidumusic.inter.MyCallBack;
import com.huoer.unconquerablebaidumusic.inter.InternetRequest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OKTool implements InternetRequest{
    private Gson gson;
    private OkHttpClient okHttpClient;
    private Handler handler = new Handler(Looper.getMainLooper());

    public OKTool(){
        okHttpClient = new OkHttpClient.Builder().connectTimeout(5, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true).build();
        gson = new Gson();
    }


    @Override
    public <T> void startRequest(String url, final Class<T> tClass, final MyCallBack<T> tMyCallBack) {
        Request request = new Request.Builder().url(url).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        tMyCallBack.error(e);
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                //将成功请求到到数据解析成对应的bean或数据类型
                String back = response.body().string();
                final T result = gson.fromJson(back, tClass);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        tMyCallBack.success(result);
                    }
                });
            }
        });
    }
}
