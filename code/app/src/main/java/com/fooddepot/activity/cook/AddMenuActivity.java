package com.fooddepot.activity.cook;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.RelativeLayout;
import android.widget.TimePicker;

import com.fooddepot.R;

import java.util.Calendar;

public class AddMenuActivity extends AppCompatActivity {

    private static final int RESULT_LOAD_IMAGE=1;
    Toolbar newtoolbar;

    static Button datebtn, timebtn, datetill,timetill,quantitybtn,photo_btn,cnclbtn,save_btn;
    ImageView imageView;
    int year_s, month_s, day_s,hour_s,min_s;
    static final int CALENDAR_ID=0;
    EditText date;
    DatePickerDialog datePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        newtoolbar=(Toolbar)findViewById(R.id.toolbar);
//        newtoolbar.setTitle("Food Depot");
//        setSupportActionBar(newtoolbar);


        setContentView(R.layout.activity_add_menu);
        datebtn = (Button)findViewById(R.id.date_btn);
        timebtn = (Button)findViewById(R.id.time_btn);
        datetill = (Button)findViewById(R.id.datetil_btn);
        timetill = (Button)findViewById(R.id.timetil_btn);
        quantitybtn = (Button)findViewById(R.id.qnty_btn);
        photo_btn = (Button)findViewById(R.id.photo_btn);
        cnclbtn = (Button)findViewById(R.id.cancel_btn);
        save_btn = (Button)findViewById(R.id.save_btn);
    }

    public void uploadPhoto(){
        photo_btn =(Button)findViewById(R.id.photo_btn);
        photo_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent galeryIntent =new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(galeryIntent,RESULT_LOAD_IMAGE);
                imageView = new ImageView(getApplicationContext());
                RelativeLayout rl = (RelativeLayout)findViewById(R.id.menuRL);
                RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(200, 200);
                lp.topMargin=20;
                lp.leftMargin=20;
                lp.addRule(RelativeLayout.END_OF,photo_btn.getId());
                lp.addRule(RelativeLayout.ALIGN_BASELINE,quantitybtn.getId());
                rl.addView(imageView, lp);
            }
        });

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode,Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode==RESULT_LOAD_IMAGE && resultCode==RESULT_OK && data !=null){
            Uri selectedImage=data.getData();
            imageView.setImageURI(selectedImage);
        }
    }

    public void showCalendar(View view){
        Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);
        System.out.println("the selected " + mDay);
        DatePickerDialog dialog = new DatePickerDialog(this,
                new mDateSetListener(), mYear, mMonth, mDay);
        dialog.show();
    }

    public void showClock(View view){
        Calendar c = Calendar.getInstance();
        int mHour = c.get(Calendar.HOUR_OF_DAY);
        int mMinute = c.get(Calendar.MINUTE);
        TimePickerDialog dialog = new TimePickerDialog(this,
                new mTimeSetListener(), mHour, mMinute,true);
        dialog.show();
    }

    public void showCalendarTil(View view){
        Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);
        System.out.println("the selected " + mDay);
        DatePickerDialog dialog = new DatePickerDialog(this,
                new mDateTilSetListener(), mYear, mMonth, mDay);
        dialog.show();
    }

    public void showClockTil(View view){
        Calendar c = Calendar.getInstance();
        int mHour = c.get(Calendar.HOUR_OF_DAY);
        int mMinute = c.get(Calendar.MINUTE);
        TimePickerDialog dialog = new TimePickerDialog(this,
                new mTimeTilSetListener(), mHour, mMinute,true);
        dialog.show();
    }

    public void selectqnty (View view){
        mQuantitySetListener newFragment = new mQuantitySetListener();
        newFragment.show(getSupportFragmentManager(), "time picker");
//        newFragment.setValueChangeListener(this);
//        newFragment.show(getSupportFragmentManager(), "time picker");
    }




    class mDateSetListener implements DatePickerDialog.OnDateSetListener {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            // TODO Auto-generated method stub
            // getCalender();
            int mYear = year;
            int mMonth = monthOfYear;
            int mDay = dayOfMonth;
            datebtn.setText(new StringBuilder()
                    // Month is 0 based so add 1
                    .append(mMonth + 1).append("/").append(mDay).append("/")
                    .append(mYear).append(" "));
            System.out.println(datebtn.getText().toString());


        }
    }

    class mDateTilSetListener implements DatePickerDialog.OnDateSetListener {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            // TODO Auto-generated method stub
            // getCalender();
            int mYear = year;
            int mMonth = monthOfYear;
            int mDay = dayOfMonth;
            datetill.setText(new StringBuilder()
                    // Month is 0 based so add 1
                    .append(mMonth + 1).append("/").append(mDay).append("/")
                    .append(mYear).append(" "));
            System.out.println(datebtn.getText().toString());


        }
    }

    class mTimeSetListener implements TimePickerDialog.OnTimeSetListener {

        @Override
        public void onTimeSet(TimePicker view, int hour, int minute) {
            // TODO Auto-generated method stub
            // getCalender();
            int mHour = hour;
            int mMinute = minute;
            timebtn.setText(new StringBuilder()
                    // Month is 0 based so add 1
                    .append(mHour).append(":").append(mMinute).append(" "));
            System.out.println(datebtn.getText().toString());

        }
    }

    class mTimeTilSetListener implements TimePickerDialog.OnTimeSetListener {

        @Override
        public void onTimeSet(TimePicker view, int hour, int minute) {
            // TODO Auto-generated method stub
            // getCalender();
            int mHour = hour;
            int mMinute = minute;
            timetill.setText(new StringBuilder()
                    // Month is 0 based so add 1
                    .append(mHour).append(":").append(mMinute).append(" "));
            System.out.println(datebtn.getText().toString());

        }
    }

    public static class mQuantitySetListener extends DialogFragment implements NumberPicker.OnValueChangeListener {

        private NumberPicker.OnValueChangeListener valueChangeListener;

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            final NumberPicker numberPicker = new NumberPicker(getActivity());
            numberPicker.setMinValue(1);
            numberPicker.setMaxValue(100);

            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setTitle("Select quantity");

            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    onValueChange(numberPicker,
                            numberPicker.getValue(), numberPicker.getValue());
                }
            });

            builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    onValueChange(numberPicker,
                            numberPicker.getValue(), numberPicker.getValue());
                }
            });

            builder.setView(numberPicker);
            return builder.create();
        }


        public void onValueChange(NumberPicker numberPicker, int i, int i1) {
            quantitybtn.setText(i+"");
        }
    }




}
