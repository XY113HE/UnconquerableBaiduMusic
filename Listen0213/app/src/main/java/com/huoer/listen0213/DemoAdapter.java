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
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class DemoAdapter extends FragmentPagerAdapter {
    private String[] strings;

    public DemoAdapter(FragmentManager fm) {
        super(fm);
    }

    public void setStrings(String[] strings) {
        this.strings = strings;
    }

    @Override
    public Fragment getItem(int position) {
        return FragmentFactory.getFragment(0, strings[position]);
    }

    @Override
    public int getCount() {
        return strings.length;
    }
}
