package com.example.rezero;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;


public class BannerAdapter extends FragmentStatePagerAdapter {
    private static int NUM_ITEMS = 3;

    public BannerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    // Returns total number of pages
    @Override
    public int getCount() {
        return NUM_ITEMS;
    }

    // Returns the fragment to display for that page
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0: FirstBanner firstBanner = new FirstBanner();
                return firstBanner;
            case 1:FirstBanner firstBanner2 = new FirstBanner();
                return firstBanner2;
            case 2:FirstBanner firstBanner3 = new FirstBanner();
                return firstBanner3;
            default:
                return null;
        }
    }

    // Returns the page title for the top indicator
    @Override
    public CharSequence getPageTitle(int position) {
        return "Page " + position;
    }

}

