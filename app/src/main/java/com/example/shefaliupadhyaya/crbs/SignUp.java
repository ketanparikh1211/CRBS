package com.example.shefaliupadhyaya.crbs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SignUp extends AppCompatActivity {
    private EditText govtid,fullname,email,password,cpassword,phone;
    private Button register;
    private Spinner dept,state;
    private String val1,val2,val3,val4,val5,val6,val7,val8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        govtid=(EditText)findViewById(R.id.govtid);
        fullname=(EditText)findViewById(R.id.fullname);
        email=(EditText)findViewById(R.id.email);
        password=(EditText)findViewById(R.id.password);
        cpassword=(EditText)findViewById(R.id.cpassword);
        dept=(Spinner)findViewById(R.id.dept);
        state=(Spinner)findViewById(R.id.regions);
        phone=(EditText)findViewById(R.id.phone);
        register=(Button)findViewById(R.id.register);
        addDepartments();
        addRegions();
        onRegisterClick();
    }
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
       // add your regions

        ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, regions);
        dataAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        state.setAdapter(dataAdapter1);
    }
    public void onRegisterClick() {
        register.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                Toast.makeText(SignUp.this, "Registration Successful", Toast.LENGTH_LONG).show();
                Intent i = new Intent(SignUp.this,MainActivity.class);
                startActivity(i);
            }
        });
    }
}
