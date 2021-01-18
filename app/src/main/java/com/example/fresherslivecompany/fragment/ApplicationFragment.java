package com.example.fresherslivecompany.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.fresherslivecompany.R;
import com.example.fresherslivecompany.apputil.SharedPrefManager;

public class ApplicationFragment extends Fragment {
    private SharedPrefManager sharedPrefManager;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        TextView textView;
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_application, container, false);
        sharedPrefManager = new SharedPrefManager(getActivity());
        textView = view.findViewById(R.id.idtest);
        textView.setText(sharedPrefManager.getNameofComp());
        return view;
    }
}