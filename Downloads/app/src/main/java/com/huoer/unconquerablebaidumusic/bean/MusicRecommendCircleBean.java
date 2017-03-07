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

public class MusicRecommendCircleBean {
    /**
     * pic : [{"type":6,"mo_type":4,"code":"http://music.baidu.com/h5pc/spec_detail?id=185&columnid=84","randpic":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_1488621116696915dcb4bf92873f8e8013b89cded5.jpg","randpic_ios5":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_1488621128dc42bc755baf167500b20060fee5fac4.jpg","randpic_desc":"曾宇谦","randpic_ipad":"","randpic_qq":"","randpic_2":"bos_client_1488621128dc42bc755baf167500b20060fee5fac4","randpic_iphone6":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_1488621128dc42bc755baf167500b20060fee5fac4.jpg","special_type":0,"ipad_desc":"","is_publish":"110000"},{"type":7,"mo_type":5,"code":"365147441","randpic":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_148853714881059171c3be295942732f5601add9ae.jpg","randpic_ios5":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_1488537152aec982c3b979f2b59b4ecf945dbcd85e.jpg","randpic_desc":"有待咖啡8","randpic_ipad":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_14885372054bb750da743abd33acf48a0fc978e3b7.jpg","randpic_qq":"","randpic_2":"bos_client_1488537152aec982c3b979f2b59b4ecf945dbcd85e","randpic_iphone6":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_1488537152aec982c3b979f2b59b4ecf945dbcd85e.jpg","special_type":0,"ipad_desc":"有待咖啡8","is_publish":"111100"},{"type":6,"mo_type":4,"code":"http://music.baidu.com/h5pc/spec_detail?id=172&columnid=88","randpic":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_1488520099caa081bb4eae93b92581475d9c14a8d7.jpg","randpic_ios5":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_1488520103114456b867596527f775b8347d4f87cf.jpg","randpic_desc":"华语乐坛的那些幕后大师们\u2014陈小霞（上）","randpic_ipad":"","randpic_qq":"","randpic_2":"bos_client_1488520103114456b867596527f775b8347d4f87cf","randpic_iphone6":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_1488520103114456b867596527f775b8347d4f87cf.jpg","special_type":0,"ipad_desc":"","is_publish":"110000"},{"type":6,"mo_type":4,"code":"http://music.baidu.com/cms/webview/bigwig/xusong0229/index.html","randpic":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_14883513291b6d3c35953ee8a240d4d28f7e8a9635.jpg","randpic_ios5":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_14883513342e8f411f2d905ce9127bd591458d84ec.jpg","randpic_desc":"许嵩青年晚报演唱会","randpic_ipad":"","randpic_qq":"","randpic_2":"bos_client_14883513342e8f411f2d905ce9127bd591458d84ec","randpic_iphone6":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_14883513342e8f411f2d905ce9127bd591458d84ec.jpg","special_type":0,"ipad_desc":"","is_publish":"110000"},{"type":6,"mo_type":4,"code":"http://music.baidu.com/cms/webview/bigwig/vote_zb/index.html?liveid=lss-hbsv2v1u6hxjnwan","randpic":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_148757750884583297d922fbfd86ee2ae967a2797d.jpg","randpic_ios5":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_148757751402f8f5351322e295beee7fe5579ab828.jpg","randpic_desc":"2017说唱歌曲创作大赛","randpic_ipad":"","randpic_qq":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_148757753083228022b5038d4d427ca758a829e7f1.jpg","randpic_2":"bos_client_148757751402f8f5351322e295beee7fe5579ab828","randpic_iphone6":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_148757751402f8f5351322e295beee7fe5579ab828.jpg","special_type":0,"ipad_desc":"2017说唱歌曲创作大赛","is_publish":"110000"}]
     * error_code : 22000
     */

    private int error_code;
    private List<PicBean> pic;

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public List<PicBean> getPic() {
        return pic;
    }

    public void setPic(List<PicBean> pic) {
        this.pic = pic;
    }

    public static class PicBean {
        /**
         * type : 6
         * mo_type : 4
         * code : http://music.baidu.com/h5pc/spec_detail?id=185&columnid=84
         * randpic : http://business.cdn.qianqian.com/qianqian/pic/bos_client_1488621116696915dcb4bf92873f8e8013b89cded5.jpg
         * randpic_ios5 : http://business.cdn.qianqian.com/qianqian/pic/bos_client_1488621128dc42bc755baf167500b20060fee5fac4.jpg
         * randpic_desc : 曾宇谦
         * randpic_ipad :
         * randpic_qq :
         * randpic_2 : bos_client_1488621128dc42bc755baf167500b20060fee5fac4
         * randpic_iphone6 : http://business.cdn.qianqian.com/qianqian/pic/bos_client_1488621128dc42bc755baf167500b20060fee5fac4.jpg
         * special_type : 0
         * ipad_desc :
         * is_publish : 110000
         */

        private int type;
        private int mo_type;
        private String code;
        private String randpic;
        private String randpic_ios5;
        private String randpic_desc;
        private String randpic_ipad;
        private String randpic_qq;
        private String randpic_2;
        private String randpic_iphone6;
        private int special_type;
        private String ipad_desc;
        private String is_publish;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getMo_type() {
            return mo_type;
        }

        public void setMo_type(int mo_type) {
            this.mo_type = mo_type;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getRandpic() {
            return randpic;
        }

        public void setRandpic(String randpic) {
            this.randpic = randpic;
        }

        public String getRandpic_ios5() {
            return randpic_ios5;
        }

        public void setRandpic_ios5(String randpic_ios5) {
            this.randpic_ios5 = randpic_ios5;
        }

        public String getRandpic_desc() {
            return randpic_desc;
        }

        public void setRandpic_desc(String randpic_desc) {
            this.randpic_desc = randpic_desc;
        }

        public String getRandpic_ipad() {
            return randpic_ipad;
        }

        public void setRandpic_ipad(String randpic_ipad) {
            this.randpic_ipad = randpic_ipad;
        }

        public String getRandpic_qq() {
            return randpic_qq;
        }

        public void setRandpic_qq(String randpic_qq) {
            this.randpic_qq = randpic_qq;
        }

        public String getRandpic_2() {
            return randpic_2;
        }

        public void setRandpic_2(String randpic_2) {
            this.randpic_2 = randpic_2;
        }

        public String getRandpic_iphone6() {
            return randpic_iphone6;
        }

        public void setRandpic_iphone6(String randpic_iphone6) {
            this.randpic_iphone6 = randpic_iphone6;
        }

        public int getSpecial_type() {
            return special_type;
        }

        public void setSpecial_type(int special_type) {
            this.special_type = special_type;
        }

        public String getIpad_desc() {
            return ipad_desc;
        }

        public void setIpad_desc(String ipad_desc) {
            this.ipad_desc = ipad_desc;
        }

        public String getIs_publish() {
            return is_publish;
        }

        public void setIs_publish(String is_publish) {
            this.is_publish = is_publish;
        }
    }
}
