package com.movie.chang.cardview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.widget.SeekBar;

/**
 * 1、在CardView里设置 android:padding="10dp"是没有用的，要设置 app:contentPadding="10dp"
 * 2、在CardView里设置 android:background是没有用的，要设置app:cardBackgroundColor
 * 3、想要CardView点击有系统默认ripple效果，添加属性：
 * android:clickable="true"
 * android:foreground="?attr/selectableItemBackground"
 * 想要自定义颜色，就要自己写selector和ripple了
 * 4、CardView继承自FrameLayout
 * 5、app:cardXXX形式的属性都是向下兼容的
 * 6、CardView的基本属性：
 * app:cardBackgroundColor 这是设置背景颜色
 * app:cardCornerRadius 这是设置圆角大小
 * app:cardElevation 这是设置z轴的阴影
 * app:cardMaxElevation 这是设置z轴的最大高度值，并不会起作用
 * app:cardUseCompatPadding 是否使用CompatPadding 会给整个CardView设置一个默认的内边距，不建议设置
 * app:cardPreventCornerOverlap 是否使用PreventCornerOverlap添加内边距(避免内容与边缘重叠，默认false，true则CardView会和content有一段细小的间距)
 * app:contentPadding 设置内容的padding
 * app:contentPaddingLeft 设置内容的左padding
 * app:contentPaddingTop 设置内容的上padding
 * app:contentPaddingRight 设置内容的右padding
 * app:contentPaddingBottom 设置内容的底padding
 * 7、CardView只能在前景设置ripple效果（ android:foreground="?attr/selectableItemBackground"）
 * 改变ripple颜色需要自定义，参考drawable-v21下的select_card_foreground,修改ripple标签下的color属性
 * 这种设置方式只适用于CardView，一般控件请使用同目录下的cus_ripple
 * 8、CardView设置圆角对于5.0以下的版本非常不友好，使用CardView请不要设置app:cardCornerRadius。非要兼容低版本就需自定义圆角ImageView来实现
 * 本Demo采用Js555的（http://www.jianshu.com/p/07097b562acb）的方式做了处理，兼容效果还不错。感谢Js555的分享。
 */
public class MainActivity extends AppCompatActivity {
    CardView cardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cardView = (CardView) findViewById(R.id.cardview_card_cv);
        SeekBar elevationSeekBar = (SeekBar) findViewById(R.id.cardview_seekbar_elevation_sb);
        // 设置SeekBar改变CardView的elevation属性，方便观察其作用
        elevationSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                cardView.setCardElevation((float) progress / 10);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        // 设置SeekBar改变CardView的radius属性，方便观察其作用
        SeekBar radiusSeekBar = (SeekBar) findViewById(R.id.cardview_seekbar_radius_sb);
        radiusSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                cardView.setRadius((float) progress / 10);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
