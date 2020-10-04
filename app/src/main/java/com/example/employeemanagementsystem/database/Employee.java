package com.example.employeemanagementsystem.database;

import android.provider.BaseColumns;

public class Employee {
    private Employee() {

    }
    public static final class EmpDetails implements BaseColumns {

        public static final String TABLE_NAME="employee";
        public static final String COL_ID="id";
        public static final String COL_NAME="name";
        public static final String COL_NUMBER="number";
        public static final String COL_DEPARTMENT="department";


    }
}
