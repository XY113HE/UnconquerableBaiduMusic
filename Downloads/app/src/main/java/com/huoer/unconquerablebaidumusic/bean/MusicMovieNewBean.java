package com.huoer.unconquerablebaidumusic.bean;
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

import java.util.List;

public class MusicMovieNewBean {
    /**
     * error_code : 22000
     * result : {"total":996091,"havemore":"1","mv_list":[{"aliastitle":"","all_artist_id":"259516743","artist":"","artist_id":"259516743","del_status":"0","mv_id":"326186760","play_nums":"0","provider":"11","publishtime":"1970-01-01","subtitle":"gugudan - One Step Closer - KBS音乐银行 现场版 17/03/03","title":"One Step Closer - KBS音乐银行","thumbnail":"http://musicdata.baidu.com/data2/pic/6222b3139ebee465ddc7b3165b41f423/327550412/327550412.jpg","thumbnail2":"http://musicdata.baidu.com/data2/pic/6222b3139ebee465ddc7b3165b41f423/327550412/327550412.jpg"},{"aliastitle":"","all_artist_id":"259516743","artist":"","artist_id":"259516743","del_status":"0","mv_id":"326186413","play_nums":"0","provider":"11","publishtime":"1970-01-01","subtitle":"B.I.G - 1.2.3 - KBS音乐银行 现场版 17/03/03","title":"1.2.3 - KBS音乐银行","thumbnail":"http://musicdata.baidu.com/data2/pic/ae00a6ba9b9d1017169290dcb6b66fa8/327550346/327550346.jpg","thumbnail2":"http://musicdata.baidu.com/data2/pic/ae00a6ba9b9d1017169290dcb6b66fa8/327550346/327550346.jpg"},{"aliastitle":"","all_artist_id":"259516743","artist":"","artist_id":"259516743","del_status":"0","mv_id":"326186688","play_nums":"0","provider":"11","publishtime":"1970-01-01","subtitle":"CROSS GENE - Black or White - KBS音乐银行 现场版 17/03/03","title":"Black or White - KBS音乐银行","thumbnail":"http://musicdata.baidu.com/data2/pic/7cfe5eebc0539074d50f3924eb73e700/327550403/327550403.jpg","thumbnail2":"http://musicdata.baidu.com/data2/pic/7cfe5eebc0539074d50f3924eb73e700/327550403/327550403.jpg"},{"aliastitle":"","all_artist_id":"259516743","artist":"","artist_id":"259516743","del_status":"0","mv_id":"326186483","play_nums":"0","provider":"11","publishtime":"1970-01-01","subtitle":"宇宙少女 - I Wish - KBS音乐银行 现场版 17/03/03","title":"I Wish - KBS音乐银行","thumbnail":"http://musicdata.baidu.com/data2/pic/a2a058763dd0ae5883560b85eb5f0771/327550361/327550361.jpg","thumbnail2":"http://musicdata.baidu.com/data2/pic/a2a058763dd0ae5883560b85eb5f0771/327550361/327550361.jpg"},{"aliastitle":"","all_artist_id":"259516743","artist":"","artist_id":"259516743","del_status":"0","mv_id":"326186433","play_nums":"0","provider":"11","publishtime":"1970-01-01","subtitle":"MASC - Tina - KBS音乐银行 现场版 17/03/03","title":"Tina - KBS音乐银行","thumbnail":"http://musicdata.baidu.com/data2/pic/97fd0ba924d6bac9cefc1b06f3d434f1/327550351/327550351.jpg","thumbnail2":"http://musicdata.baidu.com/data2/pic/97fd0ba924d6bac9cefc1b06f3d434f1/327550351/327550351.jpg"},{"aliastitle":"","all_artist_id":"259516743","artist":"","artist_id":"259516743","del_status":"0","mv_id":"326186551","play_nums":"0","provider":"11","publishtime":"1970-01-01","subtitle":"Dream Catcher - Chase Me - KBS音乐银行 现场版 17/03/03","title":"Chase Me - KBS音乐银行","thumbnail":"http://musicdata.baidu.com/data2/pic/e768daeaa01239a186061da19557a76e/327550383/327550383.jpg","thumbnail2":"http://musicdata.baidu.com/data2/pic/e768daeaa01239a186061da19557a76e/327550383/327550383.jpg"},{"aliastitle":"","all_artist_id":"259516743","artist":"","artist_id":"259516743","del_status":"0","mv_id":"326186664","play_nums":"0","provider":"11","publishtime":"1970-01-01","subtitle":"MelodyDay - KISS ON THE LIPS - KBS音乐银行 现场版 17/03/03","title":"KISS ON THE LIPS - KBS音乐银行","thumbnail":"http://musicdata.baidu.com/data2/pic/ecd07cb6a632f16ee1add04bbee9e672/327550398/327550398.jpg","thumbnail2":"http://musicdata.baidu.com/data2/pic/ecd07cb6a632f16ee1add04bbee9e672/327550398/327550398.jpg"},{"aliastitle":"","all_artist_id":"259516743","artist":"","artist_id":"259516743","del_status":"0","mv_id":"326186398","play_nums":"0","provider":"11","publishtime":"1970-01-01","subtitle":"Gavy NJ - An obvious Melo - KBS音乐银行 现场版 17/03/03","title":"An obvious Melo - KBS音乐银行","thumbnail":"http://musicdata.baidu.com/data2/pic/a28cbc98240a2938fb6ea8e1ec1e5c90/327550341/327550341.jpg","thumbnail2":"http://musicdata.baidu.com/data2/pic/a28cbc98240a2938fb6ea8e1ec1e5c90/327550341/327550341.jpg"},{"aliastitle":"","all_artist_id":"259516743","artist":"","artist_id":"259516743","del_status":"0","mv_id":"326186507","play_nums":"0","provider":"11","publishtime":"1970-01-01","subtitle":"VICTON - EYEZ EYEZ - KBS音乐银行 现场版 17/03/03","title":"EYEZ EYEZ - KBS音乐银行","thumbnail":"http://musicdata.baidu.com/data2/pic/a24bd9ac8bae63d94ef7d6ffc495a1ee/327550366/327550366.jpg","thumbnail2":"http://musicdata.baidu.com/data2/pic/a24bd9ac8bae63d94ef7d6ffc495a1ee/327550366/327550366.jpg"},{"aliastitle":"","all_artist_id":"259516743","artist":"","artist_id":"259516743","del_status":"0","mv_id":"326186787","play_nums":"0","provider":"11","publishtime":"1970-01-01","subtitle":"gugudan - A Girl Like Me - KBS音乐银行 现场版 17/03/03","title":"A Girl Like Me - KBS音乐银行","thumbnail":"http://musicdata.baidu.com/data2/pic/17a96d84f85f7b3617cc9e7f3b227fe0/327550418/327550418.jpg","thumbnail2":"http://musicdata.baidu.com/data2/pic/17a96d84f85f7b3617cc9e7f3b227fe0/327550418/327550418.jpg"},{"aliastitle":"","all_artist_id":"259516743","artist":"","artist_id":"259516743","del_status":"0","mv_id":"326186458","play_nums":"0","provider":"11","publishtime":"1970-01-01","subtitle":"The Ray - Nostalgia - KBS音乐银行 现场版 17/03/03","title":"Nostalgia - KBS音乐银行","thumbnail":"http://musicdata.baidu.com/data2/pic/5019e5b09079daa2ca6ec613228ab02f/327550356/327550356.jpg","thumbnail2":"http://musicdata.baidu.com/data2/pic/5019e5b09079daa2ca6ec613228ab02f/327550356/327550356.jpg"},{"aliastitle":"","all_artist_id":"259516743","artist":"","artist_id":"259516743","del_status":"0","mv_id":"326186643","play_nums":"0","provider":"11","publishtime":"1970-01-01","subtitle":"VAV - VENUS - KBS音乐银行 现场版 17/03/03","title":"VENUS - KBS音乐银行","thumbnail":"http://musicdata.baidu.com/data2/pic/f8d675b20aeb8fd5ac4e83b56c8cf22c/327550393/327550393.jpg","thumbnail2":"http://musicdata.baidu.com/data2/pic/f8d675b20aeb8fd5ac4e83b56c8cf22c/327550393/327550393.jpg"},{"aliastitle":"","all_artist_id":"259516743","artist":"","artist_id":"259516743","del_status":"0","mv_id":"326186532","play_nums":"0","provider":"11","publishtime":"1970-01-01","subtitle":"SF9 - ROAR - KBS音乐银行 现场版 17/03/03","title":"ROAR - KBS音乐银行","thumbnail":"http://musicdata.baidu.com/data2/pic/ab62242c5c08779fbeaaa66745a221a3/327550378/327550378.jpg","thumbnail2":"http://musicdata.baidu.com/data2/pic/ab62242c5c08779fbeaaa66745a221a3/327550378/327550378.jpg"},{"aliastitle":"","all_artist_id":"259516743","artist":"","artist_id":"259516743","del_status":"0","mv_id":"326186596","play_nums":"0","provider":"11","publishtime":"1970-01-01","subtitle":"NCT DREAM - My First and Last - KBS音乐银行 现场版 17/03/03","title":"My First and Last - KBS音乐银行","thumbnail":"http://musicdata.baidu.com/data2/pic/61c6d2ee04abcf48d204c1bd08d0a902/327550388/327550388.jpg","thumbnail2":"http://musicdata.baidu.com/data2/pic/61c6d2ee04abcf48d204c1bd08d0a902/327550388/327550388.jpg"},{"aliastitle":"","all_artist_id":"259516743","artist":"","artist_id":"259516743","del_status":"0","mv_id":"326186713","play_nums":"0","provider":"11","publishtime":"1970-01-01","subtitle":"BP RANIA - Make Me Ah - KBS音乐银行 现场版 17/03/03","title":"Make Me Ah - KBS音乐银行","thumbnail":"http://musicdata.baidu.com/data2/pic/b71eb45e5d880c4e752e12ccd6877f3b/327550408/327550408.jpg","thumbnail2":"http://musicdata.baidu.com/data2/pic/b71eb45e5d880c4e752e12ccd6877f3b/327550408/327550408.jpg"},{"aliastitle":"","all_artist_id":"259516743","artist":"","artist_id":"259516743","del_status":"0","mv_id":"326083192","play_nums":"0","provider":"11","publishtime":"1970-01-01","subtitle":"TWICE - KNOCK KNOCK - KBS音乐银行 现场版 17/03/03","title":"KNOCK KNOCK - KBS音乐银行","thumbnail":"http://musicdata.baidu.com/data2/pic/dce4409916075f74ac0cae9bb990fc41/326083203/326083203.jpg","thumbnail2":"http://musicdata.baidu.com/data2/pic/dce4409916075f74ac0cae9bb990fc41/326083203/326083203.jpg"},{"aliastitle":"","all_artist_id":"259516743","artist":"","artist_id":"259516743","del_status":"0","mv_id":"326083229","play_nums":"0","provider":"11","publishtime":"1970-01-01","subtitle":"泰妍 - Fine - KBS音乐银行 现场版 17/03/03","title":"Fine - KBS音乐银行","thumbnail":"http://musicdata.baidu.com/data2/pic/4ddbec3a661ceca77a5441c39bc93330/326083235/326083235.jpg","thumbnail2":"http://musicdata.baidu.com/data2/pic/4ddbec3a661ceca77a5441c39bc93330/326083235/326083235.jpg"},{"aliastitle":"","all_artist_id":"34497","artist":"Dreamtale","artist_id":"34497","del_status":"0","mv_id":"325986769","play_nums":"0","provider":"11","publishtime":"1970-01-01","subtitle":"2017奥斯卡最佳影片混剪 （Intro: The Dawn - Dreamtale）","title":"Dreamtale）","thumbnail":"http://musicdata.baidu.com/data2/pic/5c3a8afdcf5b6d67f9769d5b16cfd0ea/325986774/325986774.jpg","thumbnail2":"http://musicdata.baidu.com/data2/pic/5c3a8afdcf5b6d67f9769d5b16cfd0ea/325986774/325986774.jpg"},{"aliastitle":"","all_artist_id":"24371156","artist":"山猿","artist_id":"24371156","del_status":"0","mv_id":"325917578","play_nums":"0","provider":"11","publishtime":"1970-01-01","subtitle":"山猿 - バイバイ (Bye Bye)","title":"バイバイ","thumbnail":"http://musicdata.baidu.com/data2/pic/a5d18cba684ca7fd83d4c15a5cf0d025/325918181/325918181.jpg","thumbnail2":"http://musicdata.baidu.com/data2/pic/a5d18cba684ca7fd83d4c15a5cf0d025/325918181/325918181.jpg"},{"aliastitle":"","all_artist_id":"64464163","artist":"Charisma.com","artist_id":"64464163","del_status":"0","mv_id":"325913300","play_nums":"0","provider":"11","publishtime":"1970-01-01","subtitle":"Charisma.com - #Hashdark","title":"#Hashdark","thumbnail":"http://musicdata.baidu.com/data2/pic/28202151611d88496bb28edbc4b2021d/325914541/325914541.jpg","thumbnail2":"http://musicdata.baidu.com/data2/pic/28202151611d88496bb28edbc4b2021d/325914541/325914541.jpg"}]}
     */

    private int error_code;
    private ResultBean result;

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * total : 996091
         * havemore : 1
         * mv_list : [{"aliastitle":"","all_artist_id":"259516743","artist":"","artist_id":"259516743","del_status":"0","mv_id":"326186760","play_nums":"0","provider":"11","publishtime":"1970-01-01","subtitle":"gugudan - One Step Closer - KBS音乐银行 现场版 17/03/03","title":"One Step Closer - KBS音乐银行","thumbnail":"http://musicdata.baidu.com/data2/pic/6222b3139ebee465ddc7b3165b41f423/327550412/327550412.jpg","thumbnail2":"http://musicdata.baidu.com/data2/pic/6222b3139ebee465ddc7b3165b41f423/327550412/327550412.jpg"},{"aliastitle":"","all_artist_id":"259516743","artist":"","artist_id":"259516743","del_status":"0","mv_id":"326186413","play_nums":"0","provider":"11","publishtime":"1970-01-01","subtitle":"B.I.G - 1.2.3 - KBS音乐银行 现场版 17/03/03","title":"1.2.3 - KBS音乐银行","thumbnail":"http://musicdata.baidu.com/data2/pic/ae00a6ba9b9d1017169290dcb6b66fa8/327550346/327550346.jpg","thumbnail2":"http://musicdata.baidu.com/data2/pic/ae00a6ba9b9d1017169290dcb6b66fa8/327550346/327550346.jpg"},{"aliastitle":"","all_artist_id":"259516743","artist":"","artist_id":"259516743","del_status":"0","mv_id":"326186688","play_nums":"0","provider":"11","publishtime":"1970-01-01","subtitle":"CROSS GENE - Black or White - KBS音乐银行 现场版 17/03/03","title":"Black or White - KBS音乐银行","thumbnail":"http://musicdata.baidu.com/data2/pic/7cfe5eebc0539074d50f3924eb73e700/327550403/327550403.jpg","thumbnail2":"http://musicdata.baidu.com/data2/pic/7cfe5eebc0539074d50f3924eb73e700/327550403/327550403.jpg"},{"aliastitle":"","all_artist_id":"259516743","artist":"","artist_id":"259516743","del_status":"0","mv_id":"326186483","play_nums":"0","provider":"11","publishtime":"1970-01-01","subtitle":"宇宙少女 - I Wish - KBS音乐银行 现场版 17/03/03","title":"I Wish - KBS音乐银行","thumbnail":"http://musicdata.baidu.com/data2/pic/a2a058763dd0ae5883560b85eb5f0771/327550361/327550361.jpg","thumbnail2":"http://musicdata.baidu.com/data2/pic/a2a058763dd0ae5883560b85eb5f0771/327550361/327550361.jpg"},{"aliastitle":"","all_artist_id":"259516743","artist":"","artist_id":"259516743","del_status":"0","mv_id":"326186433","play_nums":"0","provider":"11","publishtime":"1970-01-01","subtitle":"MASC - Tina - KBS音乐银行 现场版 17/03/03","title":"Tina - KBS音乐银行","thumbnail":"http://musicdata.baidu.com/data2/pic/97fd0ba924d6bac9cefc1b06f3d434f1/327550351/327550351.jpg","thumbnail2":"http://musicdata.baidu.com/data2/pic/97fd0ba924d6bac9cefc1b06f3d434f1/327550351/327550351.jpg"},{"aliastitle":"","all_artist_id":"259516743","artist":"","artist_id":"259516743","del_status":"0","mv_id":"326186551","play_nums":"0","provider":"11","publishtime":"1970-01-01","subtitle":"Dream Catcher - Chase Me - KBS音乐银行 现场版 17/03/03","title":"Chase Me - KBS音乐银行","thumbnail":"http://musicdata.baidu.com/data2/pic/e768daeaa01239a186061da19557a76e/327550383/327550383.jpg","thumbnail2":"http://musicdata.baidu.com/data2/pic/e768daeaa01239a186061da19557a76e/327550383/327550383.jpg"},{"aliastitle":"","all_artist_id":"259516743","artist":"","artist_id":"259516743","del_status":"0","mv_id":"326186664","play_nums":"0","provider":"11","publishtime":"1970-01-01","subtitle":"MelodyDay - KISS ON THE LIPS - KBS音乐银行 现场版 17/03/03","title":"KISS ON THE LIPS - KBS音乐银行","thumbnail":"http://musicdata.baidu.com/data2/pic/ecd07cb6a632f16ee1add04bbee9e672/327550398/327550398.jpg","thumbnail2":"http://musicdata.baidu.com/data2/pic/ecd07cb6a632f16ee1add04bbee9e672/327550398/327550398.jpg"},{"aliastitle":"","all_artist_id":"259516743","artist":"","artist_id":"259516743","del_status":"0","mv_id":"326186398","play_nums":"0","provider":"11","publishtime":"1970-01-01","subtitle":"Gavy NJ - An obvious Melo - KBS音乐银行 现场版 17/03/03","title":"An obvious Melo - KBS音乐银行","thumbnail":"http://musicdata.baidu.com/data2/pic/a28cbc98240a2938fb6ea8e1ec1e5c90/327550341/327550341.jpg","thumbnail2":"http://musicdata.baidu.com/data2/pic/a28cbc98240a2938fb6ea8e1ec1e5c90/327550341/327550341.jpg"},{"aliastitle":"","all_artist_id":"259516743","artist":"","artist_id":"259516743","del_status":"0","mv_id":"326186507","play_nums":"0","provider":"11","publishtime":"1970-01-01","subtitle":"VICTON - EYEZ EYEZ - KBS音乐银行 现场版 17/03/03","title":"EYEZ EYEZ - KBS音乐银行","thumbnail":"http://musicdata.baidu.com/data2/pic/a24bd9ac8bae63d94ef7d6ffc495a1ee/327550366/327550366.jpg","thumbnail2":"http://musicdata.baidu.com/data2/pic/a24bd9ac8bae63d94ef7d6ffc495a1ee/327550366/327550366.jpg"},{"aliastitle":"","all_artist_id":"259516743","artist":"","artist_id":"259516743","del_status":"0","mv_id":"326186787","play_nums":"0","provider":"11","publishtime":"1970-01-01","subtitle":"gugudan - A Girl Like Me - KBS音乐银行 现场版 17/03/03","title":"A Girl Like Me - KBS音乐银行","thumbnail":"http://musicdata.baidu.com/data2/pic/17a96d84f85f7b3617cc9e7f3b227fe0/327550418/327550418.jpg","thumbnail2":"http://musicdata.baidu.com/data2/pic/17a96d84f85f7b3617cc9e7f3b227fe0/327550418/327550418.jpg"},{"aliastitle":"","all_artist_id":"259516743","artist":"","artist_id":"259516743","del_status":"0","mv_id":"326186458","play_nums":"0","provider":"11","publishtime":"1970-01-01","subtitle":"The Ray - Nostalgia - KBS音乐银行 现场版 17/03/03","title":"Nostalgia - KBS音乐银行","thumbnail":"http://musicdata.baidu.com/data2/pic/5019e5b09079daa2ca6ec613228ab02f/327550356/327550356.jpg","thumbnail2":"http://musicdata.baidu.com/data2/pic/5019e5b09079daa2ca6ec613228ab02f/327550356/327550356.jpg"},{"aliastitle":"","all_artist_id":"259516743","artist":"","artist_id":"259516743","del_status":"0","mv_id":"326186643","play_nums":"0","provider":"11","publishtime":"1970-01-01","subtitle":"VAV - VENUS - KBS音乐银行 现场版 17/03/03","title":"VENUS - KBS音乐银行","thumbnail":"http://musicdata.baidu.com/data2/pic/f8d675b20aeb8fd5ac4e83b56c8cf22c/327550393/327550393.jpg","thumbnail2":"http://musicdata.baidu.com/data2/pic/f8d675b20aeb8fd5ac4e83b56c8cf22c/327550393/327550393.jpg"},{"aliastitle":"","all_artist_id":"259516743","artist":"","artist_id":"259516743","del_status":"0","mv_id":"326186532","play_nums":"0","provider":"11","publishtime":"1970-01-01","subtitle":"SF9 - ROAR - KBS音乐银行 现场版 17/03/03","title":"ROAR - KBS音乐银行","thumbnail":"http://musicdata.baidu.com/data2/pic/ab62242c5c08779fbeaaa66745a221a3/327550378/327550378.jpg","thumbnail2":"http://musicdata.baidu.com/data2/pic/ab62242c5c08779fbeaaa66745a221a3/327550378/327550378.jpg"},{"aliastitle":"","all_artist_id":"259516743","artist":"","artist_id":"259516743","del_status":"0","mv_id":"326186596","play_nums":"0","provider":"11","publishtime":"1970-01-01","subtitle":"NCT DREAM - My First and Last - KBS音乐银行 现场版 17/03/03","title":"My First and Last - KBS音乐银行","thumbnail":"http://musicdata.baidu.com/data2/pic/61c6d2ee04abcf48d204c1bd08d0a902/327550388/327550388.jpg","thumbnail2":"http://musicdata.baidu.com/data2/pic/61c6d2ee04abcf48d204c1bd08d0a902/327550388/327550388.jpg"},{"aliastitle":"","all_artist_id":"259516743","artist":"","artist_id":"259516743","del_status":"0","mv_id":"326186713","play_nums":"0","provider":"11","publishtime":"1970-01-01","subtitle":"BP RANIA - Make Me Ah - KBS音乐银行 现场版 17/03/03","title":"Make Me Ah - KBS音乐银行","thumbnail":"http://musicdata.baidu.com/data2/pic/b71eb45e5d880c4e752e12ccd6877f3b/327550408/327550408.jpg","thumbnail2":"http://musicdata.baidu.com/data2/pic/b71eb45e5d880c4e752e12ccd6877f3b/327550408/327550408.jpg"},{"aliastitle":"","all_artist_id":"259516743","artist":"","artist_id":"259516743","del_status":"0","mv_id":"326083192","play_nums":"0","provider":"11","publishtime":"1970-01-01","subtitle":"TWICE - KNOCK KNOCK - KBS音乐银行 现场版 17/03/03","title":"KNOCK KNOCK - KBS音乐银行","thumbnail":"http://musicdata.baidu.com/data2/pic/dce4409916075f74ac0cae9bb990fc41/326083203/326083203.jpg","thumbnail2":"http://musicdata.baidu.com/data2/pic/dce4409916075f74ac0cae9bb990fc41/326083203/326083203.jpg"},{"aliastitle":"","all_artist_id":"259516743","artist":"","artist_id":"259516743","del_status":"0","mv_id":"326083229","play_nums":"0","provider":"11","publishtime":"1970-01-01","subtitle":"泰妍 - Fine - KBS音乐银行 现场版 17/03/03","title":"Fine - KBS音乐银行","thumbnail":"http://musicdata.baidu.com/data2/pic/4ddbec3a661ceca77a5441c39bc93330/326083235/326083235.jpg","thumbnail2":"http://musicdata.baidu.com/data2/pic/4ddbec3a661ceca77a5441c39bc93330/326083235/326083235.jpg"},{"aliastitle":"","all_artist_id":"34497","artist":"Dreamtale","artist_id":"34497","del_status":"0","mv_id":"325986769","play_nums":"0","provider":"11","publishtime":"1970-01-01","subtitle":"2017奥斯卡最佳影片混剪 （Intro: The Dawn - Dreamtale）","title":"Dreamtale）","thumbnail":"http://musicdata.baidu.com/data2/pic/5c3a8afdcf5b6d67f9769d5b16cfd0ea/325986774/325986774.jpg","thumbnail2":"http://musicdata.baidu.com/data2/pic/5c3a8afdcf5b6d67f9769d5b16cfd0ea/325986774/325986774.jpg"},{"aliastitle":"","all_artist_id":"24371156","artist":"山猿","artist_id":"24371156","del_status":"0","mv_id":"325917578","play_nums":"0","provider":"11","publishtime":"1970-01-01","subtitle":"山猿 - バイバイ (Bye Bye)","title":"バイバイ","thumbnail":"http://musicdata.baidu.com/data2/pic/a5d18cba684ca7fd83d4c15a5cf0d025/325918181/325918181.jpg","thumbnail2":"http://musicdata.baidu.com/data2/pic/a5d18cba684ca7fd83d4c15a5cf0d025/325918181/325918181.jpg"},{"aliastitle":"","all_artist_id":"64464163","artist":"Charisma.com","artist_id":"64464163","del_status":"0","mv_id":"325913300","play_nums":"0","provider":"11","publishtime":"1970-01-01","subtitle":"Charisma.com - #Hashdark","title":"#Hashdark","thumbnail":"http://musicdata.baidu.com/data2/pic/28202151611d88496bb28edbc4b2021d/325914541/325914541.jpg","thumbnail2":"http://musicdata.baidu.com/data2/pic/28202151611d88496bb28edbc4b2021d/325914541/325914541.jpg"}]
         */

        private int total;
        private String havemore;
        private List<MvListBean> mv_list;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public String getHavemore() {
            return havemore;
        }

        public void setHavemore(String havemore) {
            this.havemore = havemore;
        }

        public List<MvListBean> getMv_list() {
            return mv_list;
        }

        public void setMv_list(List<MvListBean> mv_list) {
            this.mv_list = mv_list;
        }

        public static class MvListBean {
            /**
             * aliastitle :
             * all_artist_id : 259516743
             * artist :
             * artist_id : 259516743
             * del_status : 0
             * mv_id : 326186760
             * play_nums : 0
             * provider : 11
             * publishtime : 1970-01-01
             * subtitle : gugudan - One Step Closer - KBS音乐银行 现场版 17/03/03
             * title : One Step Closer - KBS音乐银行
             * thumbnail : http://musicdata.baidu.com/data2/pic/6222b3139ebee465ddc7b3165b41f423/327550412/327550412.jpg
             * thumbnail2 : http://musicdata.baidu.com/data2/pic/6222b3139ebee465ddc7b3165b41f423/327550412/327550412.jpg
             */

            private String aliastitle;
            private String all_artist_id;
            private String artist;
            private String artist_id;
            private String del_status;
            private String mv_id;
            private String play_nums;
            private String provider;
            private String publishtime;
            private String subtitle;
            private String title;
            private String thumbnail;
            private String thumbnail2;

            public String getAliastitle() {
                return aliastitle;
            }

            public void setAliastitle(String aliastitle) {
                this.aliastitle = aliastitle;
            }

            public String getAll_artist_id() {
                return all_artist_id;
            }

            public void setAll_artist_id(String all_artist_id) {
                this.all_artist_id = all_artist_id;
            }

            public String getArtist() {
                return artist;
            }

            public void setArtist(String artist) {
                this.artist = artist;
            }

            public String getArtist_id() {
                return artist_id;
            }

            public void setArtist_id(String artist_id) {
                this.artist_id = artist_id;
            }

            public String getDel_status() {
                return del_status;
            }

            public void setDel_status(String del_status) {
                this.del_status = del_status;
            }

            public String getMv_id() {
                return mv_id;
            }

            public void setMv_id(String mv_id) {
                this.mv_id = mv_id;
            }

            public String getPlay_nums() {
                return play_nums;
            }

            public void setPlay_nums(String play_nums) {
                this.play_nums = play_nums;
            }

            public String getProvider() {
                return provider;
            }

            public void setProvider(String provider) {
                this.provider = provider;
            }

            public String getPublishtime() {
                return publishtime;
            }

            public void setPublishtime(String publishtime) {
                this.publishtime = publishtime;
            }

            public String getSubtitle() {
                return subtitle;
            }

            public void setSubtitle(String subtitle) {
                this.subtitle = subtitle;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getThumbnail() {
                return thumbnail;
            }

            public void setThumbnail(String thumbnail) {
                this.thumbnail = thumbnail;
            }

            public String getThumbnail2() {
                return thumbnail2;
            }

            public void setThumbnail2(String thumbnail2) {
                this.thumbnail2 = thumbnail2;
            }
        }
    }
}
