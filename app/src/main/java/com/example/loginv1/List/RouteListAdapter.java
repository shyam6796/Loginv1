package com.example.loginv1.List;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.loginv1.CustomItemClickListener;
import com.example.loginv1.Model.route_info;
import com.example.loginv1.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;


public class RouteListAdapter extends RecyclerView.Adapter<RouteListAdapter.ViewHolder> {
    private static final String TAG = "RecyclerViewAdpater";
    List<route_info> mdata;
    Context mcontext;
    CustomItemClickListener onItemClickListener;


    public void setOnItemClickListener(CustomItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }


    public RouteListAdapter(Context mcontext, List<route_info> mdata, CustomItemClickListener onItemClickListener) {


        this.mdata = mdata;
        this.mcontext = mcontext;
        this.onItemClickListener = onItemClickListener;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_item, parent, false);
        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(TAG, "Onbind:called");
        holder.textView1.setText(mdata.get(position).getR_name());
        holder.textView2.setText(mdata.get(position).getAM_PM());
        holder.textView3.setText(mdata.get(position).getS_time());
        holder.textView4.setText(mdata.get(position).getE_time());
        holder.image.setImageResource(mdata.get(position).getImage());
        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                onItemClickListener.onItemClick(mdata.get(position).getAM_PM(), position);
            }
        });

        /*holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            Intent intent = new Intent(mcontext,DetailsActivity.class);

                mcontext.startActivity(intent);

            }
        });*/
    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView image;
        TextView textView1, textView2, textView3, textView4;
        ConstraintLayout constraintLayout;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.imageView);
            textView1 = itemView.findViewById(R.id.textView1);
            textView2 = itemView.findViewById(R.id.textView2);
            textView3 = itemView.findViewById(R.id.textView3);
            textView4 = itemView.findViewById(R.id.textView4);
            constraintLayout = itemView.findViewById(R.id.ConstrainLayout1);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

        }
    }
}
