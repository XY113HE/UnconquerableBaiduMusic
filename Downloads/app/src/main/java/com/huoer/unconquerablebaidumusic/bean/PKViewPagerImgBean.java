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

public class PKViewPagerImgBean {

    /**
     * error_code : 22000
     * result : [{"type":"learn","picture":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_6dd2a7b10ce1ec57eeb6ab08e48f227d.jpg","picture_iphone6":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_73fd36cf0747dbe57d614e1bb9619941.jpg","web_url":"http://music.baidu.com/cms/webview/ktv_activity/20170220/index.html"},{"type":"learn","picture":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_0c1de026bdcde37137344a5b92e73b92.jpg","picture_iphone6":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_016beec46a0dcd0e5f13b833fb48d561.jpg","web_url":"http://music.baidu.com/cms/webview/ktv_activity/20170120/index.html"},{"type":"learn","picture":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_2b983ddd40a431e1b66a6cb290f0a770.jpg","picture_iphone6":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_2bc81ed7070a7db830a9c8309080d2f4.jpg","web_url":"http://music.baidu.com/cms/webview/ktv_activity/20170112/"}]
     */

    private int error_code;
    private List<ResultBean> result;

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * type : learn
         * picture : http://business.cdn.qianqian.com/qianqian/pic/bos_client_6dd2a7b10ce1ec57eeb6ab08e48f227d.jpg
         * picture_iphone6 : http://business.cdn.qianqian.com/qianqian/pic/bos_client_73fd36cf0747dbe57d614e1bb9619941.jpg
         * web_url : http://music.baidu.com/cms/webview/ktv_activity/20170220/index.html
         */

        private String type;
        private String picture;
        private String picture_iphone6;
        private String web_url;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getPicture() {
            return picture;
        }

        public void setPicture(String picture) {
            this.picture = picture;
        }

        public String getPicture_iphone6() {
            return picture_iphone6;
        }

        public void setPicture_iphone6(String picture_iphone6) {
            this.picture_iphone6 = picture_iphone6;
        }

        public String getWeb_url() {
            return web_url;
        }

        public void setWeb_url(String web_url) {
            this.web_url = web_url;
        }
    }
}
