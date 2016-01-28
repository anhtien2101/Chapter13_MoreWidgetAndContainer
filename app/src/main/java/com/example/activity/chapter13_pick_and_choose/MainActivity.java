package com.example.activity.chapter13_pick_and_choose;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.DateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tvDateAndTime;
    Calendar calendarDateAndTime = Calendar.getInstance();
    DateFormat fmtDateAndTime = DateFormat.getDateTimeInstance();
    Button btnSetDate, btnSetTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDateAndTime = (TextView) findViewById(R.id.tvDateAndTime);
        btnSetDate = (Button) findViewById(R.id.btnSetDate);
        btnSetTime = (Button) findViewById(R.id.btnSetTime);

        btnSetDate.setOnClickListener(this);
        btnSetTime.setOnClickListener(this);

    }

    public void updateLabel() {
        tvDateAndTime.setText(fmtDateAndTime.format(calendarDateAndTime.getTime()));
    }

    DatePickerDialog.OnDateSetListener d = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
            calendarDateAndTime.set(Calendar.YEAR, year);
            calendarDateAndTime.set(Calendar.MONTH, monthOfYear);
            calendarDateAndTime.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            updateLabel();
        }
    };

    TimePickerDialog.OnTimeSetListener t = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute) {
            calendarDateAndTime.set(Calendar.HOUR_OF_DAY, hourOfDay);
            calendarDateAndTime.set(Calendar.MINUTE, minute);
            updateLabel();
        }
    };

    public void chooseDate(){
        new DatePickerDialog(this, d, calendarDateAndTime.get(Calendar.YEAR),
                calendarDateAndTime.get(Calendar.MONTH), calendarDateAndTime.get(Calendar.DAY_OF_MONTH)).show();
    }

    public void chooseTime(){
        new TimePickerDialog(this, t,
                calendarDateAndTime.get(Calendar.HOUR_OF_DAY),
                calendarDateAndTime.get(Calendar.MINUTE),true).show();
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.btnSetDate:
                chooseDate();
                break;
            case R.id.btnSetTime:
                chooseTime();
                break;
        }
    }
}
