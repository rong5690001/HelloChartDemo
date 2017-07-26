package com.rong.map.recyclerviewitemtouchhelper.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * 作者：陈华榕
 * 邮箱:mpa.chen@sportq.com
 * 时间：2017/7/21  17:17
 */

public class ChartView extends View {

    private Paint mPaint;
    private RectF cRectF;
    private int bgColor = Color.TRANSPARENT;
    private int width, height;
    private TextPaint mTextPaint;

    public ChartView(Context context) {
        this(context, null);
    }

    public ChartView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mTextPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG);
        mTextPaint.setTextSize(22);
        mTextPaint.setAntiAlias(true);
        mTextPaint.setTextAlign(Paint.Align.CENTER);
        cRectF = new RectF(0, 0, 295, 129);
        width = 295;
        height = 129;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setStrokeWidth(10);
        int translateX = 100;
        int translateY = height * 2;
        canvas.translate(translateX, translateY);
        canvas.scale(1, -1);//旋转坐标系
        //画坐标系
        //TODO
        bgColor = Color.YELLOW;
        mPaint.setColor(bgColor);
        canvas.drawRect(cRectF, mPaint);

        mPaint.setColor(Color.WHITE);
        canvas.drawCircle(0, 50, 20, mPaint);

        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setPathEffect(new DashPathEffect(new float[]{8, 10}, 0));
        canvas.drawLine(150, 50, 150, 500, mPaint);

        Path path = new Path();
        path.moveTo(50, 50);
        path.lineTo(50, 200);
        canvas.drawPath(path, mPaint);

        canvas.save();
        canvas.scale(1, -1);
        String text = "1/2\n2016";
        Rect rect = new Rect();
        mTextPaint.getTextBounds(text, 0, text.length(), rect);
        //Text换行
        StaticLayout layout = new StaticLayout(text, mTextPaint
                , rect.width(), Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true);
        layout.draw(canvas);
        canvas.restore();
    }
}
