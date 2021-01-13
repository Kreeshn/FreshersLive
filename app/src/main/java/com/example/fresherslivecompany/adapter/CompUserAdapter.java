package com.example.fresherslivecompany.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fresherslivecompany.R;
import com.example.fresherslivecompany.model.UserComp;

import java.util.List;

public class CompUserAdapter extends RecyclerView.Adapter<CompUserAdapter.viewHolder>{
    Context context;
    List<UserComp> compList;

    public CompUserAdapter(Context context, List<UserComp> compList) {
        this.context = context;
        this.compList = compList;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.compuser_item, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
           holder.textCompRV.setText(compList.get(position).getCo_name());
           holder.textEmailRV.setText(compList.get(position).getCo_email());

           holder.itemView.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   String list = "Id : "+ compList.get(position).getCo_id()+"\nComp Name : "+ compList.get(position).getCo_name();
                   Toast.makeText(context,list,Toast.LENGTH_SHORT).show();
               }
           });
    }

    @Override
    public int getItemCount() {
        return compList.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView textCompRV, textEmailRV;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            textCompRV = (TextView) itemView.findViewById(R.id.textCompNameRV);
            textEmailRV = (TextView) itemView.findViewById(R.id.textEmailRV);
        }
    }
}
