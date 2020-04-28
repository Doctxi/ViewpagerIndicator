package com.example.lastchance;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.viewpagerindicator.TabPageIndicator;
public class MainActivity extends Activity {

    //定义一串数据源。这里是定义死的，当然大部分都是来源于网络解析的数据
    private static final String[] CONTENT = new String[] { "YELLOW","GREEN", "RED","BLUE","BLACK"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewPager pager = findViewById(R.id.pager);
        //设置viewpage的适配器
        MyAdapter adapter = new MyAdapter();
        pager.setAdapter(adapter);
        //把viewpage和TabPageIndicator关联
        TabPageIndicator indicator = findViewById(R.id.indicator);
        indicator.setViewPager(pager);
    }

    private class MyAdapter extends PagerAdapter{

        @Override
        public int getCount() {
            return CONTENT.length;//告诉viewpage，我有多少条数据，要加载
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0 == arg1;//官方推荐写法
    }
        /**
         * 页签显示数据的方法
         */
        @Override
                public CharSequence getPageTitle(int position) {
            return CONTENT[position];
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            //先使每页page上显示text文本
            // 本page要展示的内容。替换掉Fragmenlayout那张白纸。 改变子类自己的界面数据与样式。暂时先用textview代表整块view
            TextView textView = new TextView(MainActivity.this);
            switch (CONTENT[position]){
                case "RED":
                    textView.setBackgroundColor(Color.RED);break;
                case "BLUE":
                    textView.setBackgroundColor(Color.BLUE); break;
                case "YELLOW":
                    textView.setBackgroundColor(Color.YELLOW);break;
                case "BLACK":
                    textView.setBackgroundColor(Color.BLACK);break;
                case "GREEN":
                    textView.setBackgroundColor(Color.GREEN);break;

                default:break;
            }
            //别忘记把view添加到page里面
            container.addView(textView);
            return textView;
        }

    }
}