package com.example.rezero;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    public static Context context;

    private ViewPager mViewPager;
    private ContentsPagerAdapter mContentPagerAdapter;
    private TabLayout mTabLayout;
    private Context mContext;

    Button homeBtn,boxBtn,likeBtn,myBtn;
    ImageButton btnOpenDrawer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = getApplicationContext();

        // 드로어 화면을 열고 닫을 버튼 객체 참조
        ImageButton btnOpenDrawer = (ImageButton) findViewById(R.id.btn_OpenDrawer);
        //Button btnCloseDrawer = (Button) findViewById(R.id.btn_CloseDrawer);

        //하단 버튼객체생성
        homeBtn = (Button)findViewById(R.id.homeBtn);
        boxBtn = (Button)findViewById(R.id.boxBtn);
        likeBtn = (Button)findViewById(R.id.likeBtn);
        myBtn = (Button)findViewById(R.id.myBtn);


        //메뉴바버튼이미지삽입
        btnOpenDrawer.setImageResource(R.drawable.menubtn);

        //탭레이아웃
        {mTabLayout = (TabLayout) findViewById(R.id.layout_tab);

            mTabLayout.addTab(mTabLayout.newTab().setCustomView(createTabView("TODAY")));
            mTabLayout.addTab(mTabLayout.newTab().setCustomView(createTabView("BEST")));
            mTabLayout.addTab(mTabLayout.newTab().setCustomView(createTabView("NEW")));
            mTabLayout.addTab(mTabLayout.newTab().setCustomView(createTabView("MISSION")));

            mViewPager = (ViewPager) findViewById(R.id.pager_content);
            ContentsPagerAdapter mContentsPagerAdapter = new ContentsPagerAdapter(
                    getSupportFragmentManager(), mTabLayout.getTabCount());
            mViewPager.setAdapter(mContentsPagerAdapter);

            mViewPager.addOnPageChangeListener(
                    new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
            mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

                @Override
                public void onTabSelected(TabLayout.Tab tab) {
                    mViewPager.setCurrentItem(tab.getPosition());
                }

                @Override
                public void onTabUnselected(TabLayout.Tab tab) {
                }

                @Override
                public void onTabReselected(TabLayout.Tab tab) {
                }
            });}


        //드로우메뉴바
        {// 전체화면인 DrawerLayout 객체 참조
            final DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawerLay);

            // Drawer 화면(뷰) 객체 참조
            final View drawerView = (View) findViewById(R.id.drawer);



            // 드로어 여는 버튼 리스너
            btnOpenDrawer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    drawerLayout.openDrawer(drawerView);
                }
            });


            System.out.println(55);
            // 드로어 닫는 버튼 리스너
//            btnCloseDrawer.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    drawerLayout.closeDrawer(drawerView);
//                }
//            });
          }




    }

    //텝뷰
    private View createTabView(String tabName) {
        View tabView = LayoutInflater.from(mContext).inflate(R.layout.custom_tab, null);
        TextView txt_name = (TextView) tabView.findViewById(R.id.txt_name);
        txt_name.setText(tabName);
        return tabView;
    }

}