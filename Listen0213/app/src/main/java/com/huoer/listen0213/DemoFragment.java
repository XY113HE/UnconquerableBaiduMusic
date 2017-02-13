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

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DemoFragment extends Fragment {
    private String result;
    private TextView tvShow;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        result = bundle.getString("result");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_demo, container, false);
        tvShow = (TextView) v.findViewById(R.id.tv_show);
        tvShow.setText(result);
        return v;
    }

    public static Fragment instanceDemoFragment(String result){
        Fragment fragment = new DemoFragment();
        Bundle bundle = new Bundle();
        bundle.putString("result", result);
        fragment.setArguments(bundle);
        return fragment;
    }

    public static DemoFragment newInstance(Object data) {

        Bundle args = new Bundle();
        args.putString("result", (String) data);
        DemoFragment fragment = new DemoFragment();
        fragment.setArguments(args);
        return fragment;
    }

}
