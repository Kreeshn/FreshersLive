package com.example.freshersliveadmin.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.freshersliveadmin.fragment.CompAcceptReqFragment;
import com.example.freshersliveadmin.fragment.CompPenddingReqFragment;
import com.example.freshersliveadmin.fragment.CompRejectReqFragment;
import com.example.freshersliveadmin.fragment.StudentAcceptRequestFragment;
import com.example.freshersliveadmin.fragment.StudentPenndingReqFragment;
import com.example.freshersliveadmin.fragment.StudentRejectRequestFragment;

public class FragmentAdapterStudent extends FragmentPagerAdapter {
    public FragmentAdapterStudent(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0 : return new StudentPenndingReqFragment();
            case 1 : return  new StudentAcceptRequestFragment();
            case 2 : return  new StudentRejectRequestFragment();

            default: return new StudentPenndingReqFragment ();
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
