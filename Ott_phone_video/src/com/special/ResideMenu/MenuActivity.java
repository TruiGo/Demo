package com.special.ResideMenu;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;
import com.special.ResideMenu.menu.ResideMenu;
import com.special.ResideMenu.menu.ResideMenuItem;
/*
 * https://github.com/SpecialCyCi/AndroidResideMenu/blob/master/README_CN.md
 * DEMO

�����뼴��DEMO�����������غ�ѡ����ϲ����IDE���С�SDK�汾����ʹ��4.0����

Requirements

������ Android 2.3 +

Installation

�������Ҫ��ResideMenuʹ����������Ŀ�У�����Ҫ������²���

1. ����src/com/special/ResideMenu�µ����д��뵽������Ŀ��Ӧλ��

2. ����libs/nineoldandroids-library-2.4.0.jar������Ŀlibs/��

3. ����res/drawable-hdpi/shadow.9.png��������Ŀ��Ӧλ��

4. ����res/layout/residemenu.xml �� residemenu_item.xml��������Ŀ��Ӧλ��

Usage

д��Activity onCreate()��

        // attach to current activity;
        resideMenu = new ResideMenu(this);
        resideMenu.setBackground(R.drawable.menu_background);
        resideMenu.attachToActivity(this);

        // create menu items;
        String titles[] = { "Home", "Profile", "Calendar", "Settings" };
        int icon[] = { R.drawable.icon_home, R.drawable.icon_profile, R.drawable.icon_calendar, R.drawable.icon_settings };

        for (int i = 0; i < titles.length; i++){
            ResideMenuItem item = new ResideMenuItem(this, icon[i], titles[i]);
            item.setOnClickListener(this);
            resideMenu.addMenuItem(item);
        }
�������Ҫʹ�����ƻ�������/�رղ˵����븴дactivity��dispatchTouchEvent()����������

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return resideMenu.onInterceptTouchEvent(ev) || super.dispatchTouchEvent(ev);
    }
��ĳЩ�����£����ƻ�������/�رղ˵�����������ĳЩ�ؼ�������ͻ������viewpager����ʱ�����԰�viewpager���ӵ�ignored view.��μ��½�Ignored Views

����/�رղ˵� open or close menu

resideMenu.openMenu();
resideMenu.closeMenu();
�����˵�״̬

    resideMenu.setMenuListener(menuListener);
    private ResideMenu.OnMenuListener menuListener = new ResideMenu.OnMenuListener() {
        @Override
        public void openMenu() {
            Toast.makeText(mContext, "Menu is opened!", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void closeMenu() {
            Toast.makeText(mContext, "Menu is closed!", Toast.LENGTH_SHORT).show();
        }
    };
Ignored Views

��ĳЩ�����£����ƻ�������/�رղ˵�����������ĳЩ�ؼ�������ͻ������viewpager����ʱ�����԰�viewpager���ӵ�ignored view.

        // add gesture operation's ignored views
        FrameLayout ignored_view = (FrameLayout) findViewById(R.id.ignored_view);
        resideMenu.addIgnoredView(ignored_view);
��������ignored_view����������Ͳ����������ƻ��������˵�.
 */
public class MenuActivity extends Activity implements View.OnClickListener{

    private ResideMenu resideMenu;
    private MenuActivity mContext;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        mContext = this;
        setUpViews();
        setUpMenu();
    }

    private void setUpMenu() {

        // attach to current activity;
        resideMenu = new ResideMenu(this);
        resideMenu.setBackground(R.drawable.menu_background);
        resideMenu.attachToActivity(this);
        resideMenu.setMenuListener(menuListener);

        // create menu items;
        String titles[] = { "��ҳ", "��Ӱ", "�缯", "����","��¼Ƭ","����" };
        int icon[] = { R.drawable.ent_bg, R.drawable.movie_bg, R.drawable.tv_bg, R.drawable.document_bg,R.drawable.variety_bg
        		,R.drawable.setting
        		};

        for (int i = 0; i < titles.length; i++){
            ResideMenuItem item = new ResideMenuItem(this, icon[i], titles[i]);
            item.setOnClickListener(this);
            resideMenu.addMenuItem(item);
        }

        // add gesture operation's ignored views
        FrameLayout ignored_view = (FrameLayout) findViewById(R.id.ignored_view);
        resideMenu.addIgnoredView(ignored_view);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return resideMenu.onInterceptTouchEvent(ev) || super.dispatchTouchEvent(ev);
    }

    private void setUpViews() {
        Button btn_open = (Button) findViewById(R.id.btn_open_menu);
        btn_open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resideMenu.openMenu();
            }
        });
    }

    @Override
    public void onClick(View view) {
        resideMenu.closeMenu();
    }

    private ResideMenu.OnMenuListener menuListener = new ResideMenu.OnMenuListener() {
        @Override
        public void openMenu() {
            Toast.makeText(mContext, " �˵�����!", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void closeMenu() {
            Toast.makeText(mContext, "�˵��ر�!", Toast.LENGTH_SHORT).show();
        }
    };
}