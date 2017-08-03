package com.example.shefaliupadhyaya.crbs;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Booking extends AppCompatActivity {
    private Spinner dept,regions1,starttime1,endtime1,seat;
    int year_x, month_x, day_x;
    static final int DIALOG_ID=0;
    private TextView date;
    private Button listing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);
        dept = (Spinner) findViewById(R.id.dept);
        regions1 = (Spinner) findViewById(R.id.regions);
        seat = (Spinner)findViewById(R.id.seats);
        starttime1 = (Spinner)findViewById(R.id.starttime);
        endtime1 = (Spinner)findViewById(R.id.endtime);
        date = (TextView)findViewById(R.id.date);
        listing = (Button)findViewById(R.id.listing);
        Calendar myCalendar = Calendar.getInstance();
        year_x = myCalendar.get(Calendar.YEAR);
        month_x = myCalendar.get(Calendar.MONTH);
        day_x = myCalendar.get(Calendar.DAY_OF_MONTH);
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(DIALOG_ID);
            }
        });
        listing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        addDepartments();
        addRegions();
        addStartTime();
        addEndTime();
        addSeats();
    }

    @Override
    public Dialog onCreateDialog(int i) {
        if(i==DIALOG_ID) {
            return new DatePickerDialog(Booking.this,datePickerListener,year_x,month_x,day_x);
        }
        return null;
    }
    protected DatePickerDialog.OnDateSetListener datePickerListener=new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            year_x = year;
            month_x = month;
            day_x = dayOfMonth;
            date.setText(month_x+"/"+day_x+"/"+day_x);
        }
    };

    public void addDepartments() {
        List<String> department = new ArrayList<String>();
        department.add("--DEPARTMENT--");
        // add your departments
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, department);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dept.setAdapter(dataAdapter);
    }
    public void addRegions() {
        List<String> regions = new ArrayList<String>();
        regions.add("--REGION--");
        // add your regions

        ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, regions);
        dataAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        regions1.setAdapter(dataAdapter1);
    }

    public void addStartTime() {
        List<String> starttime = new ArrayList<String>();
        starttime.add("--START TIME--");
        starttime.add("9:00");
        starttime.add("10:00");
        starttime.add("11:00");
        starttime.add("12:00");
        starttime.add("13:00");
        starttime.add("14:00");
        starttime.add("15:00");
        starttime.add("16:00");


        ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, starttime);
        dataAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        starttime1.setAdapter(dataAdapter1);
    }
    public void addEndTime() {
        List<String> endtime = new ArrayList<String>();
        endtime.add("--END TIME--");
        endtime.add("10:00");
        endtime.add("11:00");
        endtime.add("12:00");
        endtime.add("13:00");
        endtime.add("14:00");
        endtime.add("15:00");
        endtime.add("16:00");
        endtime.add("17:00");


        ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, endtime);
        dataAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        endtime1.setAdapter(dataAdapter1);
    }

    public void addSeats() {
        List<String> seats = new ArrayList<String>();
        seats.add("--Number of Seats--");
        seats.add("30");
        seats.add("60");
        seats.add("90");
        seats.add("120");
        seats.add("150");

        ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, seats);
        dataAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        seat.setAdapter(dataAdapter1);
    }


}
