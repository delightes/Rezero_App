package com.example.rezero;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;


public class ContentsPagerAdapter extends FragmentStatePagerAdapter {
    private int mPageCount;

    public ContentsPagerAdapter(FragmentManager fm, int pageCount) {
        super(fm);
        this.mPageCount = pageCount;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                TodayFragment todayFragment = new TodayFragment();
                return todayFragment;

            case 1:
                BestFragment bestFragment = new BestFragment();
                return bestFragment;

            case 2:
                NewFragment newFragment = new NewFragment();
                return newFragment;

            case 3:
                MissionFragment missionFragment = new MissionFragment();
                return missionFragment;

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mPageCount;
    }

}