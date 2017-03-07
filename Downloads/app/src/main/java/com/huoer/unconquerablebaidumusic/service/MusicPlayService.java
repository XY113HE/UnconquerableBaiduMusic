package com.huoer.unconquerablebaidumusic.service;
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

import android.app.Service;
import android.content.Intent;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.util.Log;

import com.huoer.unconquerablebaidumusic.bean.SongBean;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MusicPlayService extends Service{
    private MyBinder myBinder;
    private MediaPlayer mediaPlayer;//声明一个MediaPlayer
    private List<SongBean> songBeans;//装在音乐的集合
    private int position;
    private boolean isFirst = true;
    private static final String TAG = "PlayService";
    public static final String PLAYMUSIC_ACTION = "PlayingMusic";
    public static final String SONG_BEAN = "songBean";
    public static final String CURRENT_TIME = "currentTime";
    private Timer timer;

    @Override
    public void onCreate() {
        super.onCreate();

        myBinder = new MyBinder();
        mediaPlayer = new MediaPlayer();
        songBeans = new ArrayList<>();
        getMusicData();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return myBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        if(mediaPlayer != null){
            mediaPlayer.reset();//重置播放器
            mediaPlayer.release();//释放资源
            timer.cancel();
        }
        return super.onUnbind(intent);
    }

    public class MyBinder extends Binder{
        public void play(){
            try{
                SongBean songBean = songBeans.get(position);
//                mediaPlayer.setDataSource(songBean.getUrl());
//                Uri uri = Uri.parse("http://yinyueshiting.baidu.com/data2/music/5d62ab148fc1d5f05c033409b6d07e84/266958163/266958163.mp3?xcode=792bb367e2df230359dc68219d22c373");
                Uri uri = Uri.parse("http://yinyueshiting.baidu.com/data2/music/187ccc63d230408fdf39c51e37828e24/266958159/266958159.mp3?xcode=4307c7abd06bf33fb59adc403ebeee44");
                mediaPlayer.setDataSource(getApplicationContext(), uri);
                mediaPlayer.prepareAsync();
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        playNext();
                    }
                });
                mySendBroadcast(SONG_BEAN,songBean);//发送广播

                //发送广播更新当前时间
                timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        // TODO Auto-generated method stub
                        mySendBroadcast(CURRENT_TIME,mediaPlayer.getCurrentPosition());
                    }
                },0,100);//参数意义:延时时长,间隔时长

            }catch (Exception e){
                e.printStackTrace();
            }finally {

            }
        }
        //是否正在播放
        public boolean isPlaying(){
            return mediaPlayer.isPlaying();
        }
        //暂停
        public void pause(){
            mediaPlayer.pause();
        }
        //继续
        public void continuePlay(){
            mediaPlayer.start();
        }
        //播放下一首
        public void playNext(){
            position++;
            if (position > songBeans.size()-1){
                position=0;//判断position大于长度 循环播放第一首
            }
            mediaPlayer.reset();//重置
            play();
        }


        //播放上一首
        public void playLast(){
            position--;
            if (position<0){
                position = songBeans.size()-1;//判断position为首位的时候点击上一首 播放最后一首歌
            }
            mediaPlayer.reset();//重置
            play();
        }
        //返回是否第一次
        public boolean isFirst(){
            return isFirst;
        }
        //改变第一次的状态
        public void setFirstFalse(){
            isFirst = false;
        }
        //获取mediaPlayer总时长
        public int getDuration(){
            return mediaPlayer.getDuration();
        }
        //获取当前正在播放的时长
        public int getCurrentProgress(){
            return mediaPlayer.getCurrentPosition();
        }
        //设置当前播放的进度
        public void setMediaProgress(int index){
            mediaPlayer.seekTo(index);
        }

    }

    private void mySendBroadcast(String key, SongBean value){
        Intent sendMySong = new Intent(PLAYMUSIC_ACTION);
        sendMySong.putExtra(key, value);
        sendBroadcast(sendMySong);
    }

    public void mySendBroadcast(String key, long value){
        Intent sendMySong = new Intent(PLAYMUSIC_ACTION);
        sendMySong.putExtra(key, value);
        sendBroadcast(sendMySong);
    }

    private void getMusicData() {
        Cursor cursor = getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, null, null, null, null);
        if(cursor!=null && cursor.moveToFirst()){
            do{
                //获取音乐的名字
                String songName = cursor.getString(
                        cursor.getColumnIndex(
                                MediaStore.Audio.Media.TITLE));
                //歌手名字
                String singerName = cursor.getString(
                        cursor.getColumnIndex(
                                MediaStore.Audio.Media.ARTIST));
                //获取歌曲的url
                String url = cursor.getString
                        (cursor.getColumnIndex
                                (MediaStore.Audio.Media.DATA));
                Log.e(TAG, "getMusicData: " + url);
                //获取音乐类型 0 代表不是音乐
                int isMusic = cursor.getInt
                        (cursor.getColumnIndex
                                (MediaStore.Audio.Media.IS_MUSIC));
                //获取音乐的时长(毫秒)
                Long duringTime = cursor.getLong
                        (cursor.getColumnIndex
                                (MediaStore.Audio.Media.DURATION));
                //判断歌曲 是否是音乐和时长大于1分钟
                if (isMusic != 0 && duringTime / (60 * 1000) > 1) {
                    SongBean songBean = new SongBean(songName,singerName,url,duringTime);
                    songBeans.add(songBean);
                }
            }while (cursor.moveToNext());
//            for (SongBean songBean : songBeans) {
//                Log.e(TAG, "getMusicData: "+songBean.getSingerName()+" "+songBean.getSongName()+" "+songBean.getUrl());
//            }
        }

        cursor.close();
    }

}
