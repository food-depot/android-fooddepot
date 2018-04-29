package com.fooddepot.activity.cook;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.fooddepot.R;

import static android.app.Activity.RESULT_OK;


/**
 * A simple {@link Fragment} subclass.
 */
public class CookProfileFragment extends Fragment {


    EditText description;
    Button profilepic_btn;
    ImageView profileImg;
    private static final int RESULT_LOAD_IMAGE=2;

    public CookProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cook_profile, container, false);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        description = (EditText) getView().findViewById(R.id.desc_edtxt);
        description.setMovementMethod(new ScrollingMovementMethod());
        uploadprofilePic();
    }

    public void uploadprofilePic(){
        profilepic_btn =(Button)getView().findViewById(R.id.profilepic_btn);
        profileImg =(ImageView)getView().findViewById(R.id.profile_img);
        profilepic_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent galeryIntent =new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(galeryIntent,RESULT_LOAD_IMAGE);
            }
        });

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode,Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode==RESULT_LOAD_IMAGE && resultCode==RESULT_OK && data !=null){
            Uri selectedImage=data.getData();
            profileImg.setImageURI(selectedImage);
        }
    }

}
