# CardView
研究了CardView常用的知识，尝试兼容5.0以下圆角的设置

## CardView的基本属性

属性 | 描述
----- | -----
app:cardBackgroundColor | 设置背景颜色
app:cardCornerRadius | 设置圆角大小
app:cardElevation | 设置z轴的阴影
app:cardMaxElevation | 设置z轴的最大高度值，并不会起作用
app:cardUseCompatPadding | 是否使用CompatPadding 会给整个CardView设置一个默认的内边距，视觉效果并不好，一般不建议设置
app:cardPreventCornerOverlap | 是否使用PreventCornerOverlap添加内边距(避免内容与边缘重叠，默认false，true则CardView会和content有一段细小的间距)
app:contentPadding | 设置内容的padding
app:contentPaddingLeft | 设置内容的左padding
app:contentPaddingTop | 设置内容的上padding
app:contentPaddingRight | 设置内容的右padding
app:contentPaddingBottom | 设置内容的底padding

## CardView要点记录

* CardView继承自FrameLayout
* CardView设置内边距和背景需要使用app:contentPadding和app:cardBackgroundColor , app:cardXXX形式的属性都是向下兼容的
* 需要CardView点击带有系统默认ripple效果，添加属性：
 ```
 android:clickable="true"
 android:foreground="?attr/selectableItemBackground"
 ```
 * 想要自定义颜色，就要自己写selector和ripple了，详见Demo中drawable下的select_card_foreground.xml
 CardView只能在前景设置ripple效果
  ```
 android:foreground="?attr/selectableItemBackground"
  ```
* 改变ripple颜色需要自定义，参考drawable-v21下的select_card_foreground,修改ripple标签下的color属性
 这种设置方式只适用于CardView，一般控件请使用同目录下的cus_ripple
 
* CardView设置圆角对于5.0以下的版本非常不友好，使用CardView请不要设置app:cardCornerRadius。非要兼容低版本就需自定义圆角ImageView来实现
 本Demo采用Js555的方式[传送门][1]做了处理，兼容效果还不错，感谢Js555的分享。
 
 api22效果
 
 ![api22效果](https://github.com/changliugang/CardView/raw/master/art/oppoa33api22.png)
 
 api19效果
 
 ![api19效果](https://github.com/changliugang/CardView/raw/master/art/hm1sapi19.png)  
 
 [1]:http://www.jianshu.com/p/07097b562acb "传送门"
