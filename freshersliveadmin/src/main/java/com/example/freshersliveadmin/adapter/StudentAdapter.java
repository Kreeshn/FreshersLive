package com.example.freshersliveadmin.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.freshersliveadmin.R;
import com.example.freshersliveadmin.model.Comp;
import com.example.freshersliveadmin.model.Student;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.viewHolder> {
    Context context;
    List<Student> StdList;

    public StudentAdapter(Context context, List<Student> stdList) {
        this.context = context;
        StdList = stdList;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.student_item, parent, false);
        return new StudentAdapter.viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        String fullName = StdList.get(position).getFname()+" "+StdList.get(position).getLname();
        holder.etStdName.setText(fullName);
        holder.etStdEmail.setText(StdList.get(position).getEmail());
    }

    @Override
    public int getItemCount() {
        return StdList.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView etStdName, etStdEmail;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            etStdName = (TextView) itemView.findViewById(R.id.stdName);
            etStdEmail = (TextView) itemView.findViewById(R.id.stdEmail);
        }
    }
}
