package com.lancapp.views.contents.friends;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.facebook.shimmer.ShimmerFrameLayout;
import com.lancapp.R;

public class SearchFriendsFragment extends Fragment {
    private ShimmerFrameLayout mShimmerViewContainer;
    View viewProfileFragment;


    public SearchFriendsFragment(){}


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        viewProfileFragment = inflater.inflate(R.layout.fragment_search_friends2, container, false);

        mShimmerViewContainer = viewProfileFragment.findViewById(R.id.shimmer_view_search_friends);

       // mShimmerViewContainer.stopShimmerAnimation();
       // mShimmerViewContainer.setVisibility(View.GONE);

        return viewProfileFragment;
    }

        @Override
    public void onResume() {
        mShimmerViewContainer.startShimmerAnimation();
        super.onResume();

        }

    @Override
    public void onPause() {
        mShimmerViewContainer.stopShimmerAnimation();
        super.onPause();
    }




}
