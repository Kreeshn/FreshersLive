package com.example.freshersliveadmin.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.freshersliveadmin.R;
import com.example.freshersliveadmin.adapter.FragmentAdapter;
import com.google.android.material.tabs.TabLayout;

public class CompReqFragment extends Fragment {
    private TabLayout layout ;
    private ViewPager viewPager;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_comp_req, container, false);
        viewPager = (ViewPager) view.findViewById (R.id.viewpagerCompReq);
        viewPager.setAdapter (new FragmentAdapter(getActivity().getSupportFragmentManager ()));

        layout = (TabLayout) view.findViewById (R.id.TabLayoutIdCompReq);
        layout.setupWithViewPager (viewPager);
        return  view;
    }
}