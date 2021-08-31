package com.example.rezero;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class CategoryAdapter extends FragmentStatePagerAdapter {
    private int mPageCount;

    public CategoryAdapter(FragmentManager fm, int pageCount) {
        super(fm);
        this.mPageCount = pageCount;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                ProductFragment productFragment = new ProductFragment();
                return productFragment;
            case 1:
                DesignerFragment designerFragment = new DesignerFragment();
                return designerFragment;

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mPageCount;
    }

}