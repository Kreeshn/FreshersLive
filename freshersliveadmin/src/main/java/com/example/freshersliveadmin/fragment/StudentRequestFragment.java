package com.example.freshersliveadmin.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.freshersliveadmin.R;
import com.example.freshersliveadmin.adapter.FragmentAdapter;
import com.example.freshersliveadmin.adapter.FragmentAdapterStudent;
import com.google.android.material.tabs.TabLayout;

public class StudentRequestFragment extends Fragment {
   private TabLayout layout ;
   private ViewPager viewPager;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_student_request, container, false);
        viewPager = (ViewPager) view.findViewById (R.id.viewpagerStudentReq);
        viewPager.setAdapter (new FragmentAdapterStudent(getActivity().getSupportFragmentManager ()));

        layout = (TabLayout) view.findViewById (R.id.TabLayoutIdStudentReq);
        layout.setupWithViewPager (viewPager);
        return  view;
    }
}