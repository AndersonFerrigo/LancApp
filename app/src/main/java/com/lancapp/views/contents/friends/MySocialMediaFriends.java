package com.lancapp.views.contents.friends;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.facebook.shimmer.ShimmerFrameLayout;
import com.lancapp.R;

public class MySocialMediaFriends extends Fragment {
    private ShimmerFrameLayout mShimmerViewSocialMedia;
    View viewMyFriendsFragment;


    public MySocialMediaFriends() { }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@Nullable LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        viewMyFriendsFragment = inflater.inflate(R.layout.fragment_my_social_media_friends, container, false);

        mShimmerViewSocialMedia = viewMyFriendsFragment.findViewById(R.id.shimmer_view_friends_app);

        // mShimmerViewContainer.stopShimmerAnimation();
        // mShimmerViewContainer.setVisibility(View.GONE);

        return viewMyFriendsFragment;
    }

    @Override
    public void onResume() {
        super.onResume();
        mShimmerViewSocialMedia.startShimmerAnimation();

    }

    @Override
    public void onPause() {
        mShimmerViewSocialMedia.stopShimmerAnimation();
        super.onPause();
    }

}
