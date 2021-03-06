package com.example.rezero;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
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

    ImageButton homeBtn,boxBtn,likeBtn,myBtn,btnOpenDrawer;

    //드로우바 메뉴의 버튼객체 선언
    Button kitchenBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = getApplicationContext();

        // 드로어 화면을 열고 닫을 버튼 객체 참조
        ImageButton btnOpenDrawer = (ImageButton) findViewById(R.id.btn_OpenDrawer);
        //Button btnCloseDrawer = (Button) findViewById(R.id.btn_CloseDrawer);

        //하단 버튼객체생성
        homeBtn = (ImageButton)findViewById(R.id.homeBtn);
        boxBtn = (ImageButton)findViewById(R.id.boxBtn);
        likeBtn = (ImageButton)findViewById(R.id.likeBtn);
        myBtn = (ImageButton)findViewById(R.id.myBtn);

        //하단바 버튼 누름효과지정
        {
            homeBtn.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent event) {
                    if (event.getAction() == MotionEvent.ACTION_DOWN) {

                        homeBtn.setBackgroundColor(Color.parseColor("#F5F5F5"));

                    } else if (event.getAction() == MotionEvent.ACTION_UP) {

                        homeBtn.setBackgroundColor(Color.WHITE);

                    }
                    return false;
                }
            });
            boxBtn.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent event) {
                    if (event.getAction() == MotionEvent.ACTION_DOWN) {

                        boxBtn.setBackgroundColor(Color.parseColor("#F5F5F5"));

                    } else if (event.getAction() == MotionEvent.ACTION_UP) {

                        boxBtn.setBackgroundColor(Color.WHITE);

                    }
                    return false;
                }
            });
            likeBtn.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent event) {
                    if (event.getAction() == MotionEvent.ACTION_DOWN) {

                        likeBtn.setBackgroundColor(Color.parseColor("#F5F5F5"));

                    } else if (event.getAction() == MotionEvent.ACTION_UP) {

                        likeBtn.setBackgroundColor(Color.WHITE);

                    }
                    return false;
                }
            });
            myBtn.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent event) {
                    if (event.getAction() == MotionEvent.ACTION_DOWN) {

                        myBtn.setBackgroundColor(Color.parseColor("#F5F5F5"));

                    } else if (event.getAction() == MotionEvent.ACTION_UP) {

                        myBtn.setBackgroundColor(Color.WHITE);

                    }
                    return false;
                }
            });
        }


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

        //드로우메뉴바의 버튼객체생성 및 눌럿을때 화면전환
        kitchenBtn = (Button) findViewById(R.id.kitchenBtn);
        kitchenBtn.setOnClickListener(new View.OnClickListener() {//주방으로 화면전환
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Kitchen.class);
                startActivity(intent);
            }
        });



    }

    //텝뷰
    private View createTabView(String tabName) {
        View tabView = LayoutInflater.from(mContext).inflate(R.layout.custom_tab, null);
        TextView txt_name = (TextView) tabView.findViewById(R.id.txt_name);
        txt_name.setText(tabName);
        return tabView;
    }

}