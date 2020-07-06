package com.lancapp.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.lancapp.R;

public class RegisterNewUserActivity extends AppCompatActivity {

    MaterialButton cancelRegisterNewUser;
    MaterialButton makeRegisterNewUserAccount;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_new_user);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }

        cancelRegisterNewUser = findViewById(R.id.cancel_register_new_user_account);
        makeRegisterNewUserAccount = findViewById(R.id.make_register_new_user_account);
    }


    @Override
    protected void onStart() {
        super.onStart();

        cancelRegisterNewUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cancelRegisterNewUserAccount = new Intent(getApplicationContext(), Login.class);
                startActivity(cancelRegisterNewUserAccount);
                finish();
            }
        });

        makeRegisterNewUserAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(), "Validating register", Toast.LENGTH_LONG).show();

            }
        });
    }
}
