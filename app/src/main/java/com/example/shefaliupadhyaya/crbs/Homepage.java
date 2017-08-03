package com.example.shefaliupadhyaya.crbs;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.hitomi.cmlibrary.CircleMenu;
import com.hitomi.cmlibrary.OnMenuSelectedListener;
import com.hitomi.cmlibrary.OnMenuStatusChangeListener;
import com.muddzdev.styleabletoastlibrary.StyleableToast;

import java.util.Calendar;

public class Homepage extends AppCompatActivity   {
    String arr[] = {"1", "2", "3", "4", "5"};
    static int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        CircleMenu cm = (CircleMenu) findViewById(R.id.circle_menu);
        final CircleMenu circleMenu = cm.setMainMenu(Color.parseColor("#CDCDCD"), R.drawable.home, R.drawable.home)
                .addSubMenu(Color.parseColor("#258CFF"), R.drawable.booking)
                .addSubMenu(Color.parseColor("#6d4c41"), R.drawable.cancel)
                .addSubMenu(Color.parseColor("#ff0000"), R.drawable.marker)
                .addSubMenu(Color.parseColor("#03a9f4"), R.drawable.calendar)
                .addSubMenu(Color.parseColor("#1a237e"), R.drawable.nav_toolbar).
                        setOnMenuSelectedListener(new OnMenuSelectedListener() {
                            @Override

                            public void onMenuSelected(final int i) {

                                count=i;

                            }
                        });
        circleMenu.setOnMenuStatusChangeListener(new OnMenuStatusChangeListener() {
            @Override
            public void onMenuOpened() {

            }

            @Override
            public void onMenuClosed() {
                if(count==0) {
                    StyleableToast st =new StyleableToast(getApplicationContext(),"Book conference rooms", Toast.LENGTH_SHORT);
                    st.setBackgroundColor(Color.parseColor("#771e44"));
                    st.setTextColor(Color.WHITE);
                    st.setIcon(R.drawable.refresh);
                    st.spinIcon();
                    st.show();
                    Intent intent=new Intent(Homepage.this, Booking.class);
                    startActivity(intent);
                }
                else if(count==1) {
                    StyleableToast st =new StyleableToast(getApplicationContext(),"Cancel booking", Toast.LENGTH_SHORT);
                    st.setBackgroundColor(Color.parseColor("#771e44"));
                    st.setTextColor(Color.WHITE);
                    st.setIcon(R.drawable.refresh);
                    st.spinIcon();
                    st.show();
                    Intent intent=new Intent(Homepage.this, Cancellation.class);
                    startActivity(intent);
                }
                else if(count==2) {
                    StyleableToast st =new StyleableToast(getApplicationContext(),"GPS", Toast.LENGTH_SHORT);
                    st.setBackgroundColor(Color.parseColor("#771e44"));
                    st.setTextColor(Color.WHITE);
                    st.setIcon(R.drawable.refresh);
                    st.spinIcon();
                    st.show();
                    Intent intent=new Intent(Homepage.this, MapsActivity.class);
                    startActivity(intent);
                }
                else if(count==3) {
                    StyleableToast st =new StyleableToast(getApplicationContext(),"Calendar", Toast.LENGTH_SHORT);
                    st.setBackgroundColor(Color.parseColor("#771e44"));
                    st.setTextColor(Color.WHITE);
                    st.setIcon(R.drawable.refresh);
                    st.spinIcon();
                    st.show();
                    Intent intent=new Intent(Homepage.this, CalendarNew.class);
                    startActivity(intent);
                }
                else if(count==4) {
                    StyleableToast st =new StyleableToast(getApplicationContext(),"Navigation Drawer", Toast.LENGTH_SHORT);
                    st.setBackgroundColor(Color.parseColor("#771e44"));
                    st.setTextColor(Color.WHITE);
                    st.setIcon(R.drawable.refresh);
                    st.spinIcon();
                    st.show();
                    Intent intent=new Intent(Homepage.this,NavigationDrawer.class);
                    startActivity(intent);
                }

            }
        });

          }
}