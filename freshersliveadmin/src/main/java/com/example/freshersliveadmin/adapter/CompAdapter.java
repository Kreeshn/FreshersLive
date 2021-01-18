package com.example.freshersliveadmin.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.freshersliveadmin.R;
import com.example.freshersliveadmin.model.Comp;

import java.util.List;

public class CompAdapter extends RecyclerView.Adapter<CompAdapter.viewHolder> {
    Context context;
    List<Comp> CompList;

    public CompAdapter(Context context, List<Comp> compList) {
        this.context = context;
        CompList = compList;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.comp_item, parent, false);
        return new CompAdapter.viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
            holder.compName.setText(CompList.get(position).getCo_name());
            holder.compEmail.setText(CompList.get(position).getCo_email());

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "You Click"+ CompList.get(position).getCo_name(),Toast.LENGTH_SHORT).show();
                }
            });
    }

    @Override
    public int getItemCount() {
        return CompList.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView compName, compEmail;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            compName = (TextView) itemView.findViewById(R.id.CompName);
            compEmail = (TextView) itemView.findViewById(R.id.CompEmail);
        }
    }
}
