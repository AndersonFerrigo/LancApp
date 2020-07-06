package com.lancapp.views.contents.activitiesUsers;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.facebook.shimmer.ShimmerFrameLayout;
import com.lancapp.R;

public class ListActivitiesUsersFragment extends Fragment {
    private ShimmerFrameLayout mShimmerViewActivitiesFriends;
    View viewListAcitivitiesFragment;

    public ListActivitiesUsersFragment(){}

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        viewListAcitivitiesFragment = inflater.inflate(R.layout.fragment_list_activities_users, container, false);

        mShimmerViewActivitiesFriends = viewListAcitivitiesFragment.findViewById(R.id.shimmer_view_activities_friends);

        // mShimmerViewContainer.stopShimmerAnimation();
        // mShimmerViewContainer.setVisibility(View.GONE);


        return  viewListAcitivitiesFragment;
    }

    @Override
    public void onResume() {
        mShimmerViewActivitiesFriends.startShimmerAnimation();
        super.onResume();

    }

    @Override
    public void onPause() {
        mShimmerViewActivitiesFriends.stopShimmerAnimation();
        super.onPause();
    }



}
