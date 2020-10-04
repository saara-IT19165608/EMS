package com.example.employeemanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.employeemanagementsystem.database.DBHandler;

import javax.net.ssl.SSLEngineResult;

public class AddNew extends AppCompatActivity {

    EditText empid,empname,empnumber,empdepartment;
    DBHandler dbHandler;
    Button b;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new);

        empid= findViewById(R.id.empid);
        empname= findViewById(R.id.empname);
        empnumber= findViewById(R.id.empnumber);
        empdepartment= findViewById(R.id.empdepartment);

        dbHandler=new DBHandler(this);

        b=(Button) findViewById(R.id.button2);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (empid.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Please Enter Emoployee ID", Toast.LENGTH_SHORT).show();
                } else if (empname.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Please Enter Employee Name", Toast.LENGTH_SHORT).show();
                } else if (!empnumber.getText().toString().matches("[0-9]{10}")) {
                    empnumber.setError("Enter Only 10 Digit Mobile Number");
                } else if (empdepartment.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Please Enter Employee Name", Toast.LENGTH_SHORT).show();
                }
            }

        });


        }

    public void btnadd(View v){

        int id =Integer.parseInt(empid.getText().toString());
        String name = empname.getText().toString();
        String number = empnumber.getText().toString();
        String department = empdepartment.getText().toString();

        boolean status= dbHandler.addEmployee(id,name,number,department);

        if (status) {
            Toast.makeText(this, "Inserted Successfully", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "Inserted Fail", Toast.LENGTH_SHORT).show();
        }
    }
}