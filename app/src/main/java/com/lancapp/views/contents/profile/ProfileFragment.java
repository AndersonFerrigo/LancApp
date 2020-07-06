package com.lancapp.views.contents.profile;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.textfield.TextInputLayout;
import com.lancapp.R;

import java.io.File;

public class ProfileFragment extends Fragment {
   private static int RESULT_LOAD_IMAGE = 1;


    View viewProfileFragment;
    ImageView imageView;

    TextInputLayout txtFullname;
    TextInputLayout txtAge;
    TextInputLayout txtRelationShip;
    TextInputLayout txtCity;
    TextInputLayout txtProvincyState;
    TextInputLayout txtCountry;

    ImageButton iBtnEnableEditUserInformatio;
    ImageButton iBtnLoadImageUserInformatio;

    Button btnUpdateInformationUser;
    Button btnCancelUpdateInformationUser;

    File caminhoFoto;

    public ProfileFragment(){}

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        viewProfileFragment = inflater.inflate(R.layout.fragment_profile, container, false);



        imageView = viewProfileFragment.findViewById(R.id.image_profile);
        iBtnLoadImageUserInformatio = viewProfileFragment.findViewById(R.id.btn_load_image);
        iBtnEnableEditUserInformatio = viewProfileFragment.findViewById(R.id.btn_enable_edit);
        txtFullname = viewProfileFragment.findViewById(R.id.user_full_name);
        txtAge = viewProfileFragment.findViewById(R.id.user_age);
        txtRelationShip = viewProfileFragment.findViewById(R.id.user_relationship_status);
        txtCity = viewProfileFragment.findViewById(R.id.user_city);
        txtProvincyState = viewProfileFragment.findViewById(R.id.user_provincy_state);
        txtCountry = viewProfileFragment.findViewById(R.id.user_country);

        btnUpdateInformationUser = viewProfileFragment.findViewById(R.id.update_user_information);
        btnCancelUpdateInformationUser = viewProfileFragment.findViewById(R.id.cancel_update_user_information);

        return viewProfileFragment;

    }

    @Override
    public void onStart() {
        super.onStart();

        iBtnEnableEditUserInformatio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtFullname.setEnabled(true);
                txtAge.setEnabled(true);
                txtRelationShip.setEnabled(true);
                txtCity.setEnabled(true);
                txtProvincyState.setEnabled(true);
                txtCountry.setEnabled(true);

            }
        });

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(
                        Intent.ACTION_GET_CONTENT, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(i, RESULT_LOAD_IMAGE);

            }
        });

    }

    public void onActivityResult(
            int requestCode, int resultCode, Intent data) {
        super.onActivityResult(
                requestCode, resultCode, data);

        if (resultCode == RESULT_LOAD_IMAGE && requestCode == 1) {

            // Obtém o tamanho da ImageView
            int targetW = imageView.getWidth();
            int targetH = imageView.getHeight();

            // Obtém a largura e altura da foto
            BitmapFactory.Options bmOptions =
                    new BitmapFactory.Options();
            bmOptions.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(
                    caminhoFoto.getAbsolutePath(), bmOptions);

            int photoW = bmOptions.outWidth;
            int photoH = bmOptions.outHeight;

            // Determina o fator de redimensionamento
            int scaleFactor = Math.min(
                    photoW/targetW, photoH/targetH);

            // Decodifica o arquivo de imagem em
            // um Bitmap que preencherá a ImageView
            bmOptions.inJustDecodeBounds = false;
            bmOptions.inSampleSize = scaleFactor;
            bmOptions.inPurgeable = true;

            Bitmap bitmap = BitmapFactory.decodeFile(
                    caminhoFoto.getAbsolutePath(), bmOptions);
            imageView.setImageBitmap(bitmap);
        }
    }

}
