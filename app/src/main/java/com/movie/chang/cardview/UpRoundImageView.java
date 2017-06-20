package com.movie.chang.cardview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;

/**
 * 圆角ImageView
 * @author 2017/6/20 15:17 / changliugang
 */
public class UpRoundImageView extends android.support.v7.widget.AppCompatImageView {

    // 8这个数字对应app:cardCornerRadius="8dp"
    private float mRadus = 8 * getContext().getResources().getDisplayMetrics().density;

    /*圆角的半径，依次为左上角xy半径，右上角，右下角，左下角*/
    private float[] rids = {mRadus, mRadus, mRadus, mRadus, mRadus, mRadus, mRadus, mRadus};
    private Path path;
    private RectF mRectF;

    public UpRoundImageView(Context context) {
        this(context, null, 0);
    }

    public UpRoundImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public UpRoundImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        path = new Path();
    }

    /**
     * 画图
     *
     * @param canvas
     */
    protected void onDraw(Canvas canvas) {
        int w = this.getWidth();
        int h = this.getHeight();
        if (mRectF == null) {
            mRectF = new RectF(0, 0, w, h);
        }
        /*向路径中添加圆角矩形。rids数组定义圆角矩形的四个圆角的x,y半径*/
        path.addRoundRect(mRectF, rids, Path.Direction.CW);
        canvas.clipPath(path);
        super.onDraw(canvas);
    }
}
