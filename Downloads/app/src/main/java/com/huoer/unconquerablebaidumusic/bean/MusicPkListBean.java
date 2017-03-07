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

public class MusicPkListBean {
    /**
     * error_code : 22000
     * result : {"items":[{"query":"all","value":0,"desc":"KTV热歌榜"},{"query":"area","value":1,"desc":"华语金曲"},{"query":"area","value":2,"desc":"欧美经典"},{"query":"gender","value":0,"desc":"男歌手"},{"query":"gender","value":1,"desc":"女歌手"},{"query":"gender","value":2,"desc":"乐队组合"}]}
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
        private List<ItemsBean> items;

        public List<ItemsBean> getItems() {
            return items;
        }

        public void setItems(List<ItemsBean> items) {
            this.items = items;
        }

        public static class ItemsBean {
            /**
             * query : all
             * value : 0
             * desc : KTV热歌榜
             */

            private String query;
            private int value;
            private String desc;

            public String getQuery() {
                return query;
            }

            public void setQuery(String query) {
                this.query = query;
            }

            public int getValue() {
                return value;
            }

            public void setValue(int value) {
                this.value = value;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }
        }
    }
}
