package com.example.activitymanager.AndroidApp;
import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.content.Context;
import java.util.ArrayList;
import android.view.View;
import android.widget.TextView;


public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder>{
    Context context;
    ArrayList category, activity, description, date, time, duration;
    CustomAdapter( Context context, ArrayList category, ArrayList activity, ArrayList description, ArrayList date, ArrayList time, ArrayList duration){
            this.context = context;
            this.category = category;
            this.activity = activity;
            this.description = description;
            this.date = date;
            this.time = time;
            this.duration = duration;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.row, parent, false);
        return new MyViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.categoryText.setText(String.valueOf(category.get(position)));
        holder.activityText.setText(String.valueOf(activity.get(position)));
        holder.descriptionText.setText(String.valueOf(description.get(position)));
        holder.dateText.setText(String.valueOf(date.get(position)));
        holder.timeText.setText(String.valueOf(time.get(position)));
        holder.durationText.setText(String.valueOf(duration.get(position)));

    }

    @Override
    public int getItemCount() {
        return activity.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView categoryText, activityText, descriptionText, dateText, timeText, durationText;

        public MyViewHolder(View itemView) {
            super(itemView);
            categoryText = itemView.findViewById(R.id.categoryView);
            activityText = itemView.findViewById(R.id.activityView);
            descriptionText = itemView.findViewById(R.id.descriptionView);
            dateText = itemView.findViewById(R.id.dateView);
            timeText = itemView.findViewById(R.id.timeView);
            durationText = itemView.findViewById(R.id.durationView);
        }
    }
}
