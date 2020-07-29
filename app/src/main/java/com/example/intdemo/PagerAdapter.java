package com.example.intdemo;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class PagerAdapter extends FragmentStateAdapter {
    public PagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new fragContact();
            case 1:
                return new fragImage();
            case 2:
                return new fragView();
            default:return null;
        }
//        return null;
    }

    @Override
    public int getItemCount() {
        return 3;
    }
//    private int tabsCount;
//    public PagerAdapter(@NonNull FragmentManager fm, int behavior, int tabs) {
//        super(fm,behavior);
//        this.tabsCount=tabs;
//    }
//
//
//    @NonNull
//    @Override
//    public Fragment getItem(int position) {
//        switch (position){
//            case 0:
//                return new fragContact();
//            case 1:
//                return new fragImage();
//            case 2:
//                return new fragView();
//            default:return null;
//        }
//
//    }
//
//    @Override
//    public int getCount() {
//        return tabsCount;
//    }
}
