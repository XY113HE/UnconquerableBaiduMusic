package com.huoer.unconquerablebaidumusic.activity;


import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.PersistableBundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;


import com.huoer.unconquerablebaidumusic.R;

import com.huoer.unconquerablebaidumusic.base.BaseActivity;
import com.huoer.unconquerablebaidumusic.bean.SongBean;
import com.huoer.unconquerablebaidumusic.fragment.MainFragment;
import com.huoer.unconquerablebaidumusic.fragment.MyLoginFragment;
import com.huoer.unconquerablebaidumusic.fragment.SurchMusicFragment;
import com.huoer.unconquerablebaidumusic.service.MusicPlayService;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class MainActivity extends BaseActivity implements MainFragment.FragmentButtonClick, View.OnClickListener , SeekBar.OnSeekBarChangeListener{
    private static final String TAG = "MainActivity";
    private FragmentManager fragmentManager;
    private final int MYLOGIN_JUMP = 0;
    private final int SURCHMUSIC_JUMP = 1;
    private ImageView playBtn, songBg, nextSong, songList;
    private TextView  songName, singer;
    private SeekBar mPlaySeekBar;
    private RelativeLayout bottomBar;
    private ServiceConnection serviceConnection;//绑定服务用的serviceConnection对象
    private MusicPlayService.MyBinder mSongBinder;
    private SongReceiver songReceiver;//广播接收器对象
    private boolean isActive = true;
    private Intent mIntent;//绑定服务用的intent



    @Override
    protected void onPause() {
        super.onPause();
        isActive = false;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        unbindService(serviceConnection);//解绑操作
        unregisterReceiver(songReceiver);//注销广播接收器
    }

    @Override
    protected int bindLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        playBtn = bindView(R.id.iv_mainactivity_play_music);
        mPlaySeekBar = bindView(R.id.seekbar_main);
        songBg = bindView(R.id.iv_mainactivity_music_cover);
        nextSong = bindView(R.id.iv_mainactivity_next_music);
        songList = bindView(R.id.iv_mainactivity_list_music);
        songName = bindView(R.id.tv_mainactivity_music_name);
        singer = bindView(R.id.tv_mainactivity_music_shiger);
        bottomBar = bindView(R.id.main_bottom_bar);
    }

    @Override
    protected void initData() {
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        MainFragment fragment = new MainFragment();
        fragment.setFragmentButtonClick(this);
        ft.add(R.id.frame_mainactivity, fragment);
        ft.commit();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (isActive){
                    //判断线程刚执行的时候,服务还没有绑定,也就是说songBinder对象是空的
                    //当songBinder不为空 说明服务已经绑定 当isPlaying返回true,说明正在播放歌曲
                    if (mSongBinder != null && mSongBinder.isPlaying()){
                        //获取值得过程可以在子线程中操作
                        //但是更爱ui的过程,需要在主线程中执行
                        //runOnUiThread方法
                        //就可以调到主线程中执行run方法里面的内容

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                mPlaySeekBar.setMax(mSongBinder.getDuration());
                                mPlaySeekBar.setProgress(mSongBinder.getCurrentProgress());
                            }
                        });
                    }
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        serviceConnection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                //获取binder对象
                mSongBinder = (MusicPlayService.MyBinder) service;
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {

            }
        };
        mIntent = new Intent(this, MusicPlayService.class);//绑定的intent
        bindService(mIntent, serviceConnection, BIND_AUTO_CREATE);//绑定注册
        //注册广播接收器
        IntentFilter intentFilter = new IntentFilter(MusicPlayService.PLAYMUSIC_ACTION);
        songReceiver = new SongReceiver();
        registerReceiver(songReceiver, intentFilter);


    }

    @Override
    protected void initListener() {
        playBtn.setOnClickListener(this);
        nextSong.setOnClickListener(this);
        songList.setOnClickListener(this);
        bottomBar.setOnClickListener(this);
    }

    @Override
    public void onFragmentButtonClick(int which) {
        FragmentTransaction ft = fragmentManager.beginTransaction();

        switch (which){
            case MYLOGIN_JUMP:
                ft.setCustomAnimations(R.anim.anim_fragment_right_in, R.anim.anim_fragment_right_out,
                        R.anim.anim_fragment_right_in_back, R.anim.anim_fragment_right_out_back);
                ft.add(R.id.frame_mainactivity, new MyLoginFragment());
                ft.addToBackStack(null);
                ft.commit();
                break;
            case SURCHMUSIC_JUMP:
                ft.setCustomAnimations(R.anim.anim_fragment_left_in, R.anim.anim_fragment_left_out,
                        R.anim.anim_fragment_left_in_back, R.anim.anim_fragment_left_out_back);
                ft.add(R.id.frame_mainactivity, new SurchMusicFragment());
                ft.addToBackStack(null);
                ft.commit();
        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_mainactivity_play_music:
                if (mSongBinder != null){
                    //如果正在播放
                    if (mSongBinder.isPlaying()){
                        //那么暂停
                        mSongBinder.pause();
                        playBtn.setImageResource(R.mipmap.bt_minibar_play_normal);
                    }else {
                        //如果没播放 并且现在是第一次播放
                        if (mSongBinder.isFirst()){
                            //那么调用play 设置url 准备 播放
                            mSongBinder.play();
                            //改掉isFirst属性为false
                            mSongBinder.setFirstFalse();
                        }else {
                            //如果播放过了
                            //那么设置继续播放
                            mSongBinder.continuePlay();
                        }
                        playBtn.setImageResource(R.mipmap.bt_minibar_pause_normal);
                    }
                }

                break;
            case R.id.iv_mainactivity_next_music:
                break;
            case R.id.iv_mainactivity_list_music:
                break;
            case R.id.seekbar_main:
                break;
        }
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        mSongBinder.setMediaProgress(seekBar.getProgress());
    }

    //动态广播接收器(内部类 可以操作这整类的成员变量)
    class SongReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getParcelableExtra(MusicPlayService.SONG_BEAN)!=null){
                //接受广播发送过来的歌曲信息实体类对象
                SongBean songBean = intent.getParcelableExtra(MusicPlayService.SONG_BEAN);//设定常量 避免敲错
                singer.setText(songBean.getSingerName());
                songName.setText(songBean.getSongName());
                String duration = transferMilliToTime(songBean.getDuration());
//                mDurationTv.setText(duration);
            }else if (intent.getLongExtra(MusicPlayService.CURRENT_TIME,0)!=0){
                String current = transferMilliToTime(intent.getLongExtra(MusicPlayService.CURRENT_TIME,0));
//                mTimeTv.setText(current);
            }
        }
    }
    //格式化时间
    private String transferMilliToTime(long millis){
        DateFormat format = new SimpleDateFormat("mm:ss");
        String result = format.format(new Date(millis));
        return result;
    }
}
