package com.test.interview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.test.interview.android_thread.asynctask.AsyncTaskAct;
import com.test.interview.android_ui.android_fragment.FragmentAct;
import com.test.interview.android_ui.android_service.ServiceAct;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RecyclerView recyclerView = new RecyclerView(this);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT);
        addContentView(recyclerView, layoutParams);
        GridLayoutManager manager = new GridLayoutManager(this,3);
        recyclerView.setLayoutManager(manager);
        MyAdapter adapter = new MyAdapter();
        recyclerView.setAdapter(adapter);
    }
}

class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    List<BeanData> list ;

    public MyAdapter() {
        list = new ArrayList<>();
        list.add(new BeanData("AsyncTask","AsyncTask"));
        list.add(new BeanData("IntenService","IntenService"));
        list.add(new BeanData("Fragment","Fragment"));
    }

    @NonNull
    @Override

    public ViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent,false);
        final ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int adapterPosition = viewHolder.getAdapterPosition();
                BeanData data = list.get(adapterPosition);
                String action = data.getAction();
                Class clz =null;
                switch (action) {
                    case "AsyncTask":
                        clz = AsyncTaskAct.class;
                        break;
                    case "IntenService":
                        clz = ServiceAct.class;
                        break;
                    case "Fragment":
                        clz = FragmentAct.class;
                        break;
                }
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

class BeanData {
    private String title;
    private String action;

    public BeanData(String title,String action) {
        this.title = title;
        this.action = action;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}