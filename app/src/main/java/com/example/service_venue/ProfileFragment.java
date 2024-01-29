package com.example.service_venue;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.widget.Button;
import android.widget.DatePicker;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.squareup.picasso.Picasso;


public class ProfileFragment extends Fragment {

    private static final int PICK_IMAGE_REQUEST = 1;

    ImageView profileImg;
    ImageView profile_pen;
    ImageView profileDoubleCircle;
    ImageView profileBack;
    TextView profileJob;
    ImageView profileRating;
    TextView profileNameTxt;
    EditText profileNameEdt;
    TextView profilePhoneTxt;
    TextView profilePhoneEdt;
    TextView profileEmailTxt;
    EditText profileEmailEdt;
    TextView profileGenderTxt;
    RadioGroup radioGender;
    RadioButton radioMale;
    RadioButton radioFemale;
     TextView profiile_showTxt;
     TextView profile_dateTxt;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // return inflater.inflate(R.layout.fragment_profile, container, false);
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        profileImg = view.findViewById(R.id.profile_img);
        profile_pen = view.findViewById(R.id.profile_pen);
        profileDoubleCircle = view.findViewById(R.id.profile_double_circle);
        profileBack = view.findViewById(R.id.profile_back);
        profileJob = view.findViewById(R.id.profile_job);
        profileRating = view.findViewById(R.id.profile_rating);
        profileNameTxt = view.findViewById(R.id.profile_name_txt);
        profileNameEdt = view.findViewById(R.id.profile_name_edt);
        profilePhoneTxt = view.findViewById(R.id.profile_phone_txt);
        profilePhoneEdt = view.findViewById(R.id.profile_phone_edt);
        profileEmailTxt = view.findViewById(R.id.profile_email_txt);
        profileEmailEdt = view.findViewById(R.id.profile_email_edt);
        profileGenderTxt = view.findViewById(R.id.profile_gender_txt);
        radioGender = view.findViewById(R.id.radioGender);
        radioMale = view.findViewById(R.id.radioMale);
        radioFemale = view.findViewById(R.id.radioFemale);
        profiile_showTxt = view.findViewById(R.id.profiile_showTxt);
        profile_dateTxt = view.findViewById(R.id.profile_dateTxt);



                profile_dateTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openDialog();
            }
        });

        profileGenderTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toggle the visibility of radio buttons
                if (radioGender.getVisibility() == View.VISIBLE) {
                    radioGender.setVisibility(View.VISIBLE);
                } else {
                    radioGender.setVisibility(View.VISIBLE);
                }
            }
        });

        // Handle radio button selection
        radioGender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.radioMale) {
                    profileGenderTxt.setText("Gender \nMale");

                } else if (checkedId == R.id.radioFemale) {
                    profileGenderTxt.setText("Gender \nFemale");

                }
                // Hide the radio buttons
                radioGender.setVisibility(View.GONE);
            }
        });


        if (profile_pen != null) {
            profile_pen.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openImagePicker();
                }
            });
        }

        return view;
    }

    private void openImagePicker() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent, PICK_IMAGE_REQUEST);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == getActivity().RESULT_OK && data != null) {
            Uri selectedImageUri = data.getData();
            Picasso.get().load(selectedImageUri).into(profileImg);
        }
    }


    private void openDialog() {
        DatePickerDialog dialog = new DatePickerDialog(getActivity(), R.style.DialogTheme, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int Year, int Month, int Day) {
                // Handle the selected date
                String selectedDate = Year + "-" + (Month + 1) + "-" + Day;
//                profiile_showTxt.setText("Date of Birth: " + selectedDate);
                profile_dateTxt.setText(selectedDate); // Set text in the TextView
            }
        }, 2023, 0, 1);

        dialog.show();
    }


}