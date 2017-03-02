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

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.huoer.unconquerablebaidumusic.R;
import com.huoer.unconquerablebaidumusic.base.BaseActivity;

public class LoginInActivity extends BaseActivity implements View.OnClickListener {
    private ImageView back;
    private EditText phoneEt, pswEt;

    @Override
    protected int bindLayout() {
        return R.layout.activity_login_in;
    }

    @Override
    protected void initView() {
        back = bindView(R.id.iv_logininactivity_back);
        phoneEt = bindView(R.id.et_logininactivity_phonenumber);
        pswEt = bindView(R.id.et_logininactivity_password);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {
        back.setOnClickListener(this);
        phoneEt.addTextChangedListener(new MyTextWatcher());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_logininactivity_back:
                finish();
                break;
        }
    }

    class MyTextWatcher implements TextWatcher {


        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            int length = s.length();
            if(length == 0){

            }else{

            }
        }
    }
}
