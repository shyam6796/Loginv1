package com.example.loginv1.Detail;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.loginv1.Model.stop_info;
import com.example.loginv1.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class BusStopAdapter extends RecyclerView.Adapter<BusStopAdapter.ViewHolder> {
    List<stop_info> mdata;
    Context mcontext;

    public BusStopAdapter(Context mcontext, List<stop_info> mdata) {


        this.mdata = mdata;
        this.mcontext = mcontext;

    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_item_1, parent, false);
        ViewHolder holder = new ViewHolder(view);

        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textView1.setText(mdata.get(position).getS_name());
        holder.textView2.setText(mdata.get(position).getS_staus());
        holder.textView3.setText(mdata.get(position).getS_count());


    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView textView1, textView2, textView3;
        ConstraintLayout constraintLayout;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.imageView);
            textView1 = itemView.findViewById(R.id.textView_1);
            textView2 = itemView.findViewById(R.id.textView_2);
            textView3 = itemView.findViewById(R.id.textView_3);
            constraintLayout = itemView.findViewById(R.id.ConstrainLayout11);

        }
    }

}
