package com.example.wafa.studentapp;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import  android.support.v4.app.FragmentPagerAdapter;

public class SectionPagerAdapter extends  FragmentPagerAdapter{

    public SectionPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position )
    {
        switch (position){

            case 0:
                ChatFregmant chatFregmant = new ChatFregmant();
                return  chatFregmant;

            case 1:
                UsersFregmant usersFregmant = new UsersFregmant();
                return usersFregmant;


           default:
              return null;

        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    public CharSequence getPageTitle(int position){
        switch (position){
            case 0:
                return "CHAT";
            case 1:
                return "USERS";

                default:
                    return  null;
        }
    }
}
