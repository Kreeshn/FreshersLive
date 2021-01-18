package com.example.fresherslivecompany.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fresherslivecompany.R;
import com.example.fresherslivecompany.model.CompLoginResponse;
import com.example.fresherslivecompany.model.FetchOneJobDetailsResponse;
import com.example.fresherslivecompany.model.JobComp;
import com.example.fresherslivecompany.retrofitutil.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JobDetailsFragment extends Fragment {
    private TextView JobProfile, CompName, WFH, StartDate, JobDuration, Salary_type, PartTime, aboutCompTitle, WebSite, aboutComp, respo, skill, NOO;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_job_details, container, false);
        JobProfile = view.findViewById(R.id.jobDetailsProfile);
        CompName = view.findViewById(R.id.jobDetailsCompName);
        WFH = view.findViewById(R.id.jobDetailsWFH);
       /* StartDate = view.findViewById(R.id.jobDetailStartDate);
        JobDuration = view.findViewById(R.id.jobDetailsDuration);
        Salary_type = view.findViewById(R.id.jobDetailsSalary);
        PartTime = view.findViewById(R.id.jobDetailsPartTime);
        aboutCompTitle = view.findViewById(R.id.jobDetailsAboutComp);
        WebSite = view.findViewById(R.id.jobDetailsWebseite);
        aboutComp = view.findViewById(R.id.jobDetailsAboutCompContent);
        respo = view.findViewById(R.id.jobDetailsRespo);
        skill = view.findViewById(R.id.jobDetailsSkill);
        NOO = view.findViewById(R.id.jobDetailsOpening);*/

        Bundle bundle = getArguments();
        int job_id = bundle.getInt("jobid");

        Call<FetchOneJobDetailsResponse> call = RetrofitClient
                .getInstance()
                .getApi()
                .fetchJobAllDetails(job_id);
        call.enqueue(new Callback<FetchOneJobDetailsResponse>() {
            @Override
            public void onResponse(Call<FetchOneJobDetailsResponse> call, Response<FetchOneJobDetailsResponse> response) {
                if(response.isSuccessful()){
                   JobProfile.setText(response.body().getProfile());
                   CompName.setText(response.body().getCo_name());
                   WFH.setText(response.body().getWork_type());
                 /*  StartDate.setText(String.valueOf(response.body().getStart_date()));
                   JobDuration.setText(response.body().getDuration());
                   Salary_type.setText(response.body().getSallaty_type());
                   PartTime.setText(response.body().getParttime());
                   String abco = "About "+response.body().getCo_name();
                   aboutCompTitle.setText(abco);
                   WebSite.setText(response.body().getCo_web());
                   aboutComp.setText(response.body().getCo_desc());
                   respo.setText(response.body().getRespo());
                   skill.setText(response.body().getSkill_required());
                   NOO.setText(response.body().getOpening()); */
                }
            }

            @Override
            public void onFailure(Call<FetchOneJobDetailsResponse> call, Throwable t) {
                Toast.makeText(getActivity(),t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}