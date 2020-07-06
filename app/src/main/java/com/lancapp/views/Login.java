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

public class Login extends AppCompatActivity {

    MaterialButton callRegisterNewUserActivity;
    MaterialButton loginUserAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }

         callRegisterNewUserActivity = findViewById(R.id.register_new_user);
         loginUserAccount = findViewById(R.id.login_user_account);
    }

    @Override
    protected void onStart() {
        super.onStart();

        callRegisterNewUserActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callRegisterNewUser = new Intent(getApplicationContext(), RegisterNewUserActivity.class);
                startActivity(callRegisterNewUser);
                finish();
            }
        });

        loginUserAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Logado", Toast.LENGTH_LONG).show();
                Intent showMainContentActivity = new Intent(getApplicationContext(), MainContentActivity.class);
                startActivity(showMainContentActivity);
                finish();
            }
        });

    }
}
