package com.example.fresherslivecompany.fragment;

import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fresherslivecompany.R;
import com.example.fresherslivecompany.apputil.SharedPrefManager;
import com.example.fresherslivecompany.model.FetchOneJobDetailsResponse;
import com.example.fresherslivecompany.retrofitutil.RetrofitClient;

import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CreateJobFragment extends Fragment {
    private EditText etJobProfCJ, etOpeningCJ, etStartDateCJ, etDurationCJ, etRespoCJ, etSkillCJ, etAss1, etAss2;
    private CheckBox parttimeCJ;
    private RadioGroup rgWorkType, rgSalaryType;
    private RadioButton radioButtons, radioButtonw;
    private int getRadioIdSal, getRadioIdwork;
    private Button btnCreateJob;
    SharedPrefManager sharedPrefManager;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_create_job, container, false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        etJobProfCJ = (EditText) view.findViewById(R.id.etJobProfCJ);
        etOpeningCJ = (EditText) view.findViewById(R.id.etNOOCJ);
        etStartDateCJ = (EditText) view.findViewById(R.id.etStartDateCJ);
        etDurationCJ = (EditText) view.findViewById(R.id.etDurationCJ);
        etRespoCJ = (EditText) view.findViewById(R.id.etRespoCJ);
        etSkillCJ = (EditText) view.findViewById(R.id.etSkillCJ);
        etAss1 = (EditText) view.findViewById(R.id.etass1CJ);
        etAss2 = (EditText) view.findViewById(R.id.etass2CJ);
        rgWorkType = (RadioGroup) view.findViewById(R.id.rgWorktypeCJ);
        rgSalaryType = (RadioGroup) view.findViewById(R.id.rgSallaryCJ);
        parttimeCJ = (CheckBox) view.findViewById(R.id.chkParttimeCJ);
        btnCreateJob = (Button) view.findViewById(R.id.btnCJ);
        sharedPrefManager = new SharedPrefManager(view.getContext());

        getRadioIdSal = rgSalaryType.getCheckedRadioButtonId();
        radioButtons = (RadioButton) view.findViewById(getRadioIdSal);

        getRadioIdwork = rgWorkType.getCheckedRadioButtonId();
        radioButtonw = (RadioButton) view.findViewById(getRadioIdwork);


        btnCreateJob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"hi",Toast.LENGTH_SHORT).show();
            }
        });
    }
}