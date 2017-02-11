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
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.huoer.unconquerablebaidumusic.R;
import com.huoer.unconquerablebaidumusic.adapter.GuideActivityRecycleViewAdapter;
import com.huoer.unconquerablebaidumusic.base.BaseActivity;
import com.huoer.unconquerablebaidumusic.fragment.MainFragment;

import java.util.ArrayList;
import java.util.List;

public class GuideActivity extends BaseActivity {
    private ViewPager viewPager;
    private GuideActivityRecycleViewAdapter adapter;
    private List<View> viewList;

    @Override
    protected int bindLayout() {
        return R.layout.activity_guide;
    }

    @Override
    protected void initView() {
       viewPager = bindView(R.id.viewpager_guide);
    }

    @Override
    protected void initData() {
        viewList = new ArrayList<>();
        LayoutInflater inflater = getLayoutInflater();

        View firstGuidePager = inflater.inflate(R.layout.item_guide_page1, null);
        View secondGuidePager = inflater.inflate(R.layout.item_guide_page2, null);

        secondGuidePager.findViewById(R.id.view_jump).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GuideActivity.this, MainActivity.class));
                finish();
            }
        });

        viewList.add(firstGuidePager);
        viewList.add(secondGuidePager);

        adapter = new GuideActivityRecycleViewAdapter();
        adapter.setViewList(viewList);
        viewPager.setAdapter(adapter);

    }

    @Override
    protected void initListener() {

    }
}
