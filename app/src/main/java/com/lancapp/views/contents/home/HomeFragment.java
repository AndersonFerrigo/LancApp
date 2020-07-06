package com.lancapp.views.contents.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.lancapp.R;
import com.lancapp.views.adapters.ListAdapterFeedContent;

public class HomeFragment extends Fragment {

    View viewHomeFragment;
    RecyclerView recyclerViewHome;

    public HomeFragment(){}

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container,
                                                        Bundle savedInstanceState) {


        viewHomeFragment = inflater.inflate(R.layout.fragment_home, container, false);



        recyclerViewHome = viewHomeFragment.findViewById(R.id.recycler_view_home);


        recyclerViewHome.setAdapter(new ListAdapterFeedContent(getContext()));

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(),
                                                            LinearLayoutManager.VERTICAL,false);

        recyclerViewHome.setLayoutManager(layoutManager);

        return viewHomeFragment;
    }

}
