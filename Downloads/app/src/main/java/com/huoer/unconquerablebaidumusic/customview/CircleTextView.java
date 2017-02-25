package com.huoer.unconquerablebaidumusic.customview;
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
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.huoer.unconquerablebaidumusic.R;

public class CircleTextView extends View{
    private static final String TAG = "CircleTextView";
    private Paint mPaint;
    private int mBgColor;
    private int mTextColor;
    private String mText;
    private float mRadiu;
    private float mTextSize;

    public CircleTextView(Context context) {
        super(context);
    }

    public CircleTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.CircleTextView);
        mBgColor = array.getColor(R.styleable.CircleTextView_bgColor, Color.BLACK);
        mTextColor = array.getColor(R.styleable.CircleTextView_textColor, Color.WHITE);
        mText = array.getString(R.styleable.CircleTextView_text);
        mRadiu = array.getDimension(R.styleable.CircleTextView_radius, 50);
        mTextSize = array.getDimension(R.styleable.CircleTextView_textSize, 18);

        array.recycle();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setAntiAlias(true);
        mPaint.setColor(mBgColor);
        int w = getWidth();
        canvas.drawCircle(w/2, mRadiu, mRadiu, mPaint);
        mPaint.setColor(mTextColor);
        mPaint.setTextAlign(Paint.Align.CENTER);
        mPaint.setTextSize(mTextSize);

        Paint.FontMetrics fontMetrics = mPaint.getFontMetrics();
        int height = getLayoutParams().height;
        int y = (int) (height / 2 + Math.abs((fontMetrics.ascent + fontMetrics.descent) / 2));
        canvas.drawText(mText, w/2, y, mPaint);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //注意：为尽可能简洁本文只讨论EXACTLY和AT_MOST模式
        int mode = MeasureSpec.getMode(widthMeasureSpec);
        if(mode == MeasureSpec.AT_MOST || mode == MeasureSpec.EXACTLY) {
//            this.widthMeasureSpec = widthMeasureSpec;
//            this.heightMeasureSpec = heightMeasureSpec;
            int width = MeasureSpec.getSize(widthMeasureSpec);
            int height = MeasureSpec.getSize(heightMeasureSpec);
            setMeasuredDimension(width, height);
        } else if(mode == MeasureSpec.UNSPECIFIED) {
            Log.d("WOGU", "mode=UNSPECIFIED");
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }


}
