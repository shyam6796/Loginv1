package com.example.loginv1.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

import com.example.loginv1.CustomItemClickListener;
import com.example.loginv1.R;
import com.example.loginv1.List.RouteListFragment;
import com.example.loginv1.Detail.BusStopsFragment;


public class UserDataActivity extends AppCompatActivity implements CustomItemClickListener {

    boolean mDualPane = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userdata);

        View detailsFrame = findViewById(R.id.placeholder2);
        mDualPane =detailsFrame != null && detailsFrame.getVisibility() == View.VISIBLE;
        if(mDualPane){
            RouteListFragment fragment = new RouteListFragment();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

            // Replace whatever is in the fragment_container view with this fragment,
            // and add the transaction to the back stack so the user can navigate back
            /* transaction.replace(R.id.placeholder, fragment1);*/
            transaction.replace(R.id.placeholder1, fragment, "List");
            // Commit the transaction
            transaction.commit();

        }
        else
        {
            RouteListFragment fragment = new RouteListFragment();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

            // Replace whatever is in the fragment_container view with this fragment,
            // and add the transaction to the back stack so the user can navigate back
            /* transaction.replace(R.id.placeholder, fragment1);*/
            transaction.replace(R.id.placeholder_route_fragment, fragment, "List");
            // Commit the transaction
            transaction.commit();
        }
    }



    public void onItemClick(String S, int position) {
        if (mDualPane) {
            Bundle bundle = new Bundle();
            bundle.putString("my", S);
            bundle.putString("my1","tablet");
            BusStopsFragment fragment1 = new BusStopsFragment();
            fragment1.setArguments(bundle);
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

            // Replace whatever is in the fragment_container view with this fragment,
            // and add the transaction to the back stack so the user can navigate back
            transaction.replace(R.id.placeholder2, fragment1);


            // Commit the transaction
            transaction.commit();
        } else {
           /* Intent intent = new Intent(this, DetailsActivity.class);
            intent.putExtra("time", S);
            startActivity(intent);*/
            Bundle bundle = new Bundle();
            bundle.putString("my", S);
            bundle.putString("my1","phone");
            BusStopsFragment fragment1 = new BusStopsFragment();
            fragment1.setArguments(bundle);
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

            // Replace whatever is in the fragment_container view with this fragment,
            // and add the transaction to the back stack so the user can navigate back
            /* transaction.replace(R.id.placeholder, fragment1);*/
            transaction.replace(R.id.placeholder_route_fragment, fragment1, "Detail");
            transaction.addToBackStack(null);

            // Commit the transaction
            transaction.commit();
        }
    }

   /* @Override
    public void onBackPressed() {
        FragmentManager manager = getSupportFragmentManager();
        manager.popBackStack("List",FragmentManager.POP_BACK_STACK_INCLUSIVE);
    }*/
}