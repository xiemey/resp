package com.tq;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.tq.activity.LoginActivity;

public class MainActivity extends FragmentActivity implements View.OnClickListener {

    //变量——————————————————————————————————————————-————
    //定义3个Fragment的对象
    private Fragment1 fg1;
    private Fragment2 fg2;
    private Fragment3 fg3;
    private Fragment4 fg4;
    //帧布局对象,就是用来存放Fragment的容器
    private FrameLayout flayout;
    //定义底部导航栏的si个布局
    private RelativeLayout data_layout;
    private RelativeLayout today_layout;
    private RelativeLayout tts_layout;
    private RelativeLayout setting_layout;
    //定义底部导航栏中的ImageView与TextView
    private ImageView data_image;
    private ImageView today_image;
    private ImageView setting_image;
    private ImageView tts_image;
    private TextView data_text;
    private TextView setting_text;
    private TextView today_text;
    private TextView tts_text;
    //定义要用的颜色值
    private int whirt = 0xFFFFFFFF;
    private int gray = 0xFF7597B3;
    private int blue = 0xFF0AB2FB;

    //定义FragmentManager对象
    FragmentManager fManager;

    //函数————————————————————————————————————————————————
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fManager = getSupportFragmentManager();
        initViews();
    }

    //完成组件的初始化
    public void initViews() {
        data_image = (ImageView) findViewById(R.id.course_image);
        today_image = (ImageView) findViewById(R.id.found_image);
        setting_image = (ImageView) findViewById(R.id.setting_image);
        tts_image = (ImageView) findViewById(R.id.tts_image);

        data_text = (TextView) findViewById(R.id.course_text);
        today_text = (TextView) findViewById(R.id.found_text);
        tts_text = (TextView) findViewById(R.id.tts_text);
        setting_text = (TextView) findViewById(R.id.setting_text);

        data_layout = (RelativeLayout) findViewById(R.id.data_layout);
        today_layout = (RelativeLayout) findViewById(R.id.today_layout);
        tts_layout = (RelativeLayout) findViewById(R.id.tts_layout);
        setting_layout = (RelativeLayout) findViewById(R.id.setting_layout);

        data_layout.setOnClickListener(this);
        today_layout.setOnClickListener(this);
        tts_layout.setOnClickListener(this);
        setting_layout.setOnClickListener(this);
    }

    //重写onClick事件


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.data_layout:
                setChioceItem(0);
                break;
            case R.id.today_layout:
                setChioceItem(1);
                break;
            case R.id.tts_layout:
                setChioceItem(2);
                break;
            case R.id.setting_layout:
                setChioceItem(3);
                break;
            default:
                break;
        }
    }

    public void setChioceItem(int index) {
        //重置选项+隐藏所有Fragment
        FragmentTransaction transaction = fManager.beginTransaction();
        clearChioce();
        hideFragments(transaction);
        switch (index) {
            case 0:

                data_text.setTextColor(blue);

                if (fg1 == null) {
                    // 如果fg1为空，则创建一个并添加到界面上
                    fg1 = new Fragment1();
                    transaction.add(R.id.content, fg1);
                } else {
                    // 如果MessageFragment不为空，则直接将它显示出来
                    transaction.show(fg1);
                }
                break;

            case 1:

                today_text.setTextColor(blue);

                if (fg2 == null) {
                    // 如果fg1为空，则创建一个并添加到界面上
                    fg2 = new Fragment2();
                    transaction.add(R.id.content, fg2);
                } else {
                    // 如果MessageFragment不为空，则直接将它显示出来
                    transaction.show(fg2);
                }
                break;


            case 2:

                tts_text.setTextColor(blue);

                if (fg3 == null) {
                    fg3 = new Fragment3();
                    transaction.add(R.id.content, fg3);
                } else {
                    transaction.show(fg3);
                }
                break;


            case 3:
                setting_text.setTextColor(blue);

                if (fg4 == null) {
                    // 如果fg1为空，则创建一个并添加到界面上
                    fg4 = new Fragment4();
                    transaction.add(R.id.content, fg4);
                } else {
                    // 如果MessageFragment不为空，则直接将它显示出来
                    transaction.show(fg4);
                }
                break;
        }
        transaction.commit();
    }

    //隐藏所有的Fragment,避免fragment混乱
    private void hideFragments(FragmentTransaction transaction) {
        if (fg1 != null) {
            transaction.hide(fg1);
        }
        if (fg2 != null) {
            transaction.hide(fg2);
        }
        if (fg3 != null) {
            transaction.hide(fg3);
        }
        if (fg4 != null) {
            transaction.hide(fg4);
        }
    }


    //定义一个重置所有选项的方法
    public void clearChioce() {

        data_layout.setBackgroundColor(whirt);
        data_text.setTextColor(gray);

        today_layout.setBackgroundColor(whirt);
        today_text.setTextColor(gray);

        tts_layout.setBackgroundColor(whirt);
        tts_text.setTextColor(gray);

        setting_layout.setBackgroundColor(whirt);
        setting_text.setTextColor(gray);
    }

    public void back_to_login(View view) {
        //setContentView(R.layout.login);
        Intent intent3 = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent3);
        finish();
    }

}
