package com.huoer.unconquerablebaidumusic.fragment;
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

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.huoer.unconquerablebaidumusic.R;
import com.huoer.unconquerablebaidumusic.adapter.SurchMusicListViewAdapter;
import com.huoer.unconquerablebaidumusic.base.BaseFragment;

public class SurchMusicFragment extends BaseFragment {
    private ListView listView;
    private SurchMusicListViewAdapter adapter;
    private TextView noHistory;
    private EditText surchMusic;

    @Override
    protected int bindLayout() {
        return R.layout.fragment_surchmusic;
    }

    @Override
    protected void initView() {
        listView = bindView(R.id.lv_surchmusic_history_list);
        noHistory = bindView(R.id.tv_surchmusic_nohistory);
        surchMusic = bindView(R.id.et_surchmusic);
    }

    @Override
    protected void initData() {
        adapter = new SurchMusicListViewAdapter();
        adapter.setContext(getContext());
        adapter.setOnClearListener(new SurchMusicListViewAdapter.OnClearListener() {
            @Override
            public void clearData() {
                adapter.setDataSize(0);
                noHistory.setVisibility(View.VISIBLE);
                listView.setVisibility(View.GONE);
            }
        });
        listView.setAdapter(adapter);
        surchMusic.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId == EditorInfo.IME_ACTION_SEARCH){
                    showOrHideSoftKeyboard();
                    return true;
                }
                return false;
            }
        });

        showOrHideSoftKeyboard();

    }

    //在点击的时候隐藏软键盘(下面的代码。如果原先的软件盘是没显示的,则将软件盘显示出来)
    private void showOrHideSoftKeyboard() {
        InputMethodManager imm = (InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
    }

    @Override
    protected void initListener() {

    }
}
