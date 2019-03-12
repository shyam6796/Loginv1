package com.example.loginv1.List;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.loginv1.CustomItemClickListener;
import com.example.loginv1.Model.route_info;
import com.example.loginv1.R;

import java.util.ArrayList;
import java.util.List;


public class RouteListFragment extends Fragment {

    View view;
    private RecyclerView mrecyclerview;
    private List<route_info> listroute;

    private CustomItemClickListener onItemClickListener;

    public RouteListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        /*container.removeAllViewsInLayout();*/
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_route, container, false);
        mrecyclerview = (RecyclerView) view.findViewById(R.id.recyclerview);
        onItemClickListener = (CustomItemClickListener) getActivity();
        RouteListAdapter recyclerViewAdapter = new RouteListAdapter(getContext(), listroute, onItemClickListener);
        mrecyclerview.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        mrecyclerview.setAdapter(recyclerViewAdapter);
        return view;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        listroute = new ArrayList<>();
        listroute.add(new route_info("School1", "AM", "8:00", "9:30", R.drawable.ic_launcher_foreground));
        listroute.add(new route_info("Schoo11", "PM", "8:00", "9:30", R.drawable.ic_launcher_foreground));
        listroute.add(new route_info("School2", "AM", "8:00", "9:30", R.drawable.ic_launcher_foreground));
        listroute.add(new route_info("School2", "PM", "8:00", "9:30", R.drawable.ic_launcher_foreground));
        listroute.add(new route_info("School3", "AM", "8:00", "9:30", R.drawable.ic_launcher_foreground));
        listroute.add(new route_info("School3", "PM", "8:00", "9:30", R.drawable.ic_launcher_foreground));
        listroute.add(new route_info("School4", "AM", "8:00", "9:30", R.drawable.ic_launcher_foreground));
        listroute.add(new route_info("School4", "PM", "8:00", "9:30", R.drawable.ic_launcher_foreground));
        listroute.add(new route_info("School5", "AM", "8:00", "9:30", R.drawable.ic_launcher_foreground));
        listroute.add(new route_info("School5", "PM", "8:00", "9:30", R.drawable.ic_launcher_foreground));
    }

}