package com.example.shefaliupadhyaya.crbs;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.muddzdev.styleabletoastlibrary.StyleableToast;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.CalendarMode;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarNew extends AppCompatActivity {
    MaterialCalendarView materialCalendarView;
    Date date2,date4; String date3,date5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar_new);
        String date1="02/04/2017";
        final SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
        try {
            date2 = sdf.parse(date1);
            date3= sdf.format(date2);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        materialCalendarView = (MaterialCalendarView)findViewById(R.id.CalenderView);
        materialCalendarView.state().edit().setFirstDayOfWeek(Calendar.MONDAY).setMinimumDate(CalendarDay.from(2017,3,1)).setMaximumDate(CalendarDay.from(2100,12,31))
                .setCalendarDisplayMode(CalendarMode.MONTHS).commit();
        materialCalendarView.setOnDateChangedListener(new OnDateSelectedListener() {
            @Override
            public void onDateSelected(@NonNull MaterialCalendarView widget, @NonNull CalendarDay date, boolean selected) {
                //Toast.makeText(CalendarNew.this,""+date, Toast.LENGTH_SHORT).show();
                try {
                    date4 = sdf.parse(String.valueOf(date));
                    date5= sdf.format(date4);

                } catch (ParseException e) {
                    e.printStackTrace();
                }
                Toast.makeText(CalendarNew.this, ""+date5, Toast.LENGTH_SHORT).show();
                Toast.makeText(CalendarNew.this, ""+date3, Toast.LENGTH_SHORT).show();
                if(date3==date5) {
                    StyleableToast st =new StyleableToast(getApplicationContext(),"E", Toast.LENGTH_SHORT);
                    st.setBackgroundColor(Color.parseColor("#000000"));
                    st.setTextColor(Color.WHITE);
                    st.setIcon(R.drawable.refresh);
                    st.spinIcon();
                    st.show();
                }
                else {
                    StyleableToast st =new StyleableToast(getApplicationContext(),"NE", Toast.LENGTH_SHORT);
                    st.setBackgroundColor(Color.parseColor("#771e44"));
                    st.setTextColor(Color.WHITE);
                    st.setIcon(R.drawable.refresh);
                    st.spinIcon();
                    st.show();
                }

            }
        });
    }
}
