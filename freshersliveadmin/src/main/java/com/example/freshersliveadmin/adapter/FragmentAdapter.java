package com.example.freshersliveadmin.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.freshersliveadmin.fragment.CompAcceptReqFragment;
import com.example.freshersliveadmin.fragment.CompPenddingReqFragment;
import com.example.freshersliveadmin.fragment.CompRejectReqFragment;

public class FragmentAdapter extends FragmentPagerAdapter {
    public FragmentAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    public FragmentAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0 : return new CompPenddingReqFragment();
            case 1 : return  new CompAcceptReqFragment();
            case 2 : return  new CompRejectReqFragment();

            default: return new CompPenddingReqFragment ();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title = null;
        if(position == 0){
            title = "Pendding";
        }
        else if (position == 1){
            title = "Approved";
        }
        else if(position == 2){
            title = "Rejected";
        }
        return title;
    }
}
