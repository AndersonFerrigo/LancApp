package com.lancapp.views;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.lancapp.R;
import com.lancapp.views.account.AccountSettingsUser;
import com.lancapp.views.contents.activitiesUsers.ListActivitiesUsersFragment;
import com.lancapp.views.contents.friends.MySocialMediaFriends;
import com.lancapp.views.contents.home.HomeFragment;
import com.lancapp.views.contents.profile.ProfileFragment;
import com.lancapp.views.contents.friends.SearchFriendsFragment;

public class MainContentActivity extends AppCompatActivity{

    FrameLayout mainContent;
    BottomNavigationView navigationView;

    ImageButton moreOptionsUser;

    HomeFragment homeFragmentUser = new HomeFragment();
    ProfileFragment proflileFragmentUser = new ProfileFragment();
    ListActivitiesUsersFragment activitiesUsersFragment = new ListActivitiesUsersFragment();
    SearchFriendsFragment friendsFragment = new SearchFriendsFragment();
    MySocialMediaFriends mySocialFriendsFragment = new MySocialMediaFriends();
    AccountSettingsUser accountUserFragment = new AccountSettingsUser();

    private static final String HOME_USER = "HOME_USER";
    private static final String PROFILE_USER = "PROFILE_USER";
    private static final String LIKED_SHAREDS = "LIKED_SHAREDS";
    private static final String FRIENDS_FINDS = "FRIENDS_FRIENDS";
    private static final String SOCIAL_FRIENDS = "SOCIAL_FRIENDS";
    private static final String ACCOUNT_USER = "ACCOUNT_USER";

    private static long back_pressed_aluno;

    PopupMenu dropDownMenu;
    Menu menu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_content);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }

      mainContent = findViewById(R.id.frame_layout_main_content);
      navigationView = findViewById(R.id.bottom_nav_main_content);
      moreOptionsUser = findViewById(R.id.button_call_settings);

      dropDownMenu = new PopupMenu(getApplicationContext(), moreOptionsUser);
        
      menu = dropDownMenu.getMenu();
      

    }

    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    protected void onStart() {
        super.onStart();
        navigationView.setOnNavigationItemSelectedListener(itemSelectedListener);

        HomeFragment homeFragmentUser = new HomeFragment();
        changeFragment(homeFragmentUser, HOME_USER);

        dropDownMenu.getMenuInflater().inflate(R.menu.menu_personal_options, menu);

        dropDownMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                
                switch (item.getItemId()) {
                    case R.id.ic_settings_user:
                        changeFragment(accountUserFragment, ACCOUNT_USER);
                        return true;
                    case R.id.ic_friends_user:
                        changeFragment(mySocialFriendsFragment, SOCIAL_FRIENDS);
                        return true;
                }
                return false;
            }
        });
        moreOptionsUser.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                
                dropDownMenu.show();

            }
        });
    }


    @SuppressLint("ResourceType")
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_personal_options, menu);

        return true;
    }

    private BottomNavigationView.OnNavigationItemSelectedListener itemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.ic_home: {
                    changeFragment(homeFragmentUser, HOME_USER);
                    return true;
                }

                case R.id.ic_liked_shares: {
                    changeFragment(activitiesUsersFragment,LIKED_SHAREDS );
                    return true;
                }


                case R.id.ic_list_friends: {
                    changeFragment(friendsFragment,FRIENDS_FINDS);
                    return true;
                }

                case R.id.ic_profile_user: {
                    changeFragment(proflileFragmentUser,PROFILE_USER);
                    return true;
                }

            }

            return false;
        }
    };

    public void changeFragment(Fragment fragment, String tagFragmentName) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        Fragment currentFragment = fragmentManager.getPrimaryNavigationFragment();
        if (currentFragment != null) {
            fragmentTransaction.detach(currentFragment);
        }
        Fragment fragmentTemp = fragmentManager.findFragmentByTag(tagFragmentName);
        if (fragmentTemp == null) {
            fragmentTemp = fragment;
            fragmentTransaction.add(R.id.frame_layout_main_content, fragmentTemp, tagFragmentName);
        } else {
            fragmentTransaction.attach(fragmentTemp);
        }

        fragmentTransaction.setPrimaryNavigationFragment(fragmentTemp);
        fragmentTransaction.setReorderingAllowed(true);
        fragmentTransaction.commitAllowingStateLoss();
    }


}
