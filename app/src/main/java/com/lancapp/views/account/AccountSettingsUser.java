package com.lancapp.views.account;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.google.android.material.textfield.TextInputLayout;
import com.lancapp.R;

public class AccountSettingsUser extends Fragment {

    View vAccountSettings;

    ImageView imageView;

    TextInputLayout txtEmail;
    TextInputLayout txtConfirmEmail;
    TextInputLayout txtPassword;
    TextInputLayout txtConfirmPassword;

    ImageButton iBtnEnableEditUserSettings;

    Button btnUpdateUserSettings;
    Button btnCancelUpdateUserSettings;



    public AccountSettingsUser() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        vAccountSettings = inflater.inflate(R.layout.fragment_account_settings_user, container, false);

         txtEmail = vAccountSettings.findViewById(R.id.update_register_user_email);
         txtConfirmEmail = vAccountSettings.findViewById(R.id.update_register_user_confirm_email);
         txtPassword = vAccountSettings.findViewById(R.id.update_register_password_user);
         txtConfirmPassword = vAccountSettings.findViewById(R.id.update_register_confirm_password_user);

         iBtnEnableEditUserSettings = vAccountSettings.findViewById(R.id.btn_enable_settings_user);

         btnUpdateUserSettings = vAccountSettings.findViewById(R.id.update_register_new_user_account);
         btnCancelUpdateUserSettings = vAccountSettings.findViewById(R.id.update_cancel_register_new_user_account);

        return vAccountSettings;
    }

    @Override
    public void onStart() {
        super.onStart();
        iBtnEnableEditUserSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtEmail.setEnabled(true);
                txtConfirmEmail.setEnabled(true);
                txtPassword.setEnabled(true);
                txtConfirmPassword.setEnabled(true);

            }
        });

        btnCancelUpdateUserSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Account Update canceled", Toast.LENGTH_LONG).show();
                try {
                    finalize();
                } catch (Throwable throwable) {
                    throwable.printStackTrace();
                }
            }
        });

        btnUpdateUserSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Account Updated", Toast.LENGTH_LONG).show();
                try {
                    finalize();
                } catch (Throwable throwable) {
                    throwable.printStackTrace();
                }
            }
        });
    }
}
