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

本代码即是DEMO，您可以下载后选择您喜欢的IDE运行。SDK版本建议使用4.0以上

Requirements

运行在 Android 2.3 +

Installation

如果您需要将ResideMenu使用在您的项目中，您需要完成以下步骤

1. 复制src/com/special/ResideMenu下的所有代码到您的项目相应位置

2. 复制libs/nineoldandroids-library-2.4.0.jar到您项目libs/下

3. 复制res/drawable-hdpi/shadow.9.png到您的项目相应位置

4. 复制res/layout/residemenu.xml 和 residemenu_item.xml到您的项目相应位置

Usage

写在Activity onCreate()中

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
如果您需要使用手势滑动开启/关闭菜单，请复写activity的dispatchTouchEvent()，代码如下

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return resideMenu.onInterceptTouchEvent(ev) || super.dispatchTouchEvent(ev);
    }
在某些场景下，手势滑动开启/关闭菜单可能与您的某些控件产生冲突，例如viewpager，这时您可以把viewpager添加到ignored view.请参见下节Ignored Views

开启/关闭菜单 open or close menu

resideMenu.openMenu();
resideMenu.closeMenu();
监听菜单状态

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

在某些场景下，手势滑动开启/关闭菜单可能与您的某些控件产生冲突，例如viewpager，这时您可以把viewpager添加到ignored view.

        // add gesture operation's ignored views
        FrameLayout ignored_view = (FrameLayout) findViewById(R.id.ignored_view);
        resideMenu.addIgnoredView(ignored_view);
这样子在ignored_view操作的区域就不允许用手势滑动操作菜单.
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
        String titles[] = { "Home", "Profile", "Calendar", "Settings" };
        int icon[] = { R.drawable.icon_home, R.drawable.icon_profile, R.drawable.icon_calendar, R.drawable.icon_settings };

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
            Toast.makeText(mContext, " 菜单开启!", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void closeMenu() {
            Toast.makeText(mContext, "菜单关闭!", Toast.LENGTH_SHORT).show();
        }
    };
}
