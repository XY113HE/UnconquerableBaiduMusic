package com.huoer.listen0213;
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

import android.support.v4.app.Fragment;

public class FragmentFactory  {
    public static Fragment getFragment(int type, Object data){
        Fragment fragment = null;
        switch (type){
            case 0:
                DemoFragment.newInstance(data);
                break;
            case 1:
                DemoFragment.newInstance(data);
                break;
        }
        return fragment;
    }
}
