package com.example.loginv1.Detail;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.loginv1.Model.stop_info;
import com.example.loginv1.R;

import java.util.ArrayList;
import java.util.List;


public class BusStopsFragment extends Fragment {

    View view;
    private RecyclerView mrecyclerview;
    private List<stop_info> stopinfo;
    public String strtext = null, str=null;

    public BusStopsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        /*container.removeAllViewsInLayout();*/
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_stops, container, false);
        mrecyclerview = (RecyclerView) view.findViewById(R.id.recyclerview1);
        BusStopAdapter recyclerViewAdapter = new BusStopAdapter(getContext(), stopinfo);
        mrecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        mrecyclerview.setAdapter(recyclerViewAdapter);

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            strtext = getArguments().getString("my");
            str = getArguments().getString("my1");

        }

        if (strtext.equals("AM")) {
            stopinfo = new ArrayList<>();
            stopinfo.add(new stop_info("stop1", "P", "10"));
            stopinfo.add(new stop_info("stop2", "P", "5"));
            stopinfo.add(new stop_info("stop3", "P", "4"));
            stopinfo.add(new stop_info("stop4", "P", "8"));
            stopinfo.add(new stop_info("stop5", "P", "11"));
            stopinfo.add(new stop_info("stop6", "P", "4"));
        } else {
            stopinfo = new ArrayList<>();
            stopinfo.add(new stop_info("stop1", "D", "10"));
            stopinfo.add(new stop_info("stop2", "D", "5"));
            stopinfo.add(new stop_info("stop3", "D", "4"));
            stopinfo.add(new stop_info("stop4", "D", "8"));
            stopinfo.add(new stop_info("stop5", "D", "11"));
            stopinfo.add(new stop_info("stop6", "D", "4"));

        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

      /*  Intent intent = new Intent(getContext(), UserDataActivity.class);
        startActivity(intent);
        */
        if (str.equals("phone")) {
            FragmentManager manager = getFragmentManager();
            manager.popBackStack("List", FragmentManager.POP_BACK_STACK_INCLUSIVE);
        }
    }
}