package com.test.interview;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.test.framework.HandlerAct;
import com.test.thread.asynctask.AsyncTaskAct;
import com.test.ui.fragment.FragmentAct;
import com.test.ui.service.ServiceAct;
import com.test.ui.view.ViewAct;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    List<BeanData> list;

    public MyAdapter() {
        list = new ArrayList<>();
        list.add(new BeanData("Handler", "Handler", HandlerAct.class));
        list.add(new BeanData("AsyncTask", "AsyncTask", AsyncTaskAct.class));
        list.add(new BeanData("IntenService", "IntenService", ServiceAct.class));
        list.add(new BeanData("Fragment", "Fragment", FragmentAct.class));
        list.add(new BeanData("View", "View", ViewAct.class));
    }

    @NonNull
    @Override

    public ViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        final ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int adapterPosition = viewHolder.getAdapterPosition();
                BeanData data = list.get(adapterPosition);
                Class clz = data.getaClass();
                Intent intent = new Intent(parent.getContext(), clz);
                parent.getContext().startActivity(intent);
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        BeanData data = list.get(position);
        holder.tvTitle.setText(data.getTitle());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvTitle;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.textView);
        }
    }
}
