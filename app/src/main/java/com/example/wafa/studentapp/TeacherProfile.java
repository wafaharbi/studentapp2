package com.example.wafa.studentapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class TeacherProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_profile);
    }


    public void info(View v){

        Intent i = new Intent(this , TeacherInfo.class);
        startActivity(i);
    }



    public  void listParent(View v){

        Intent i = new Intent(this , TeachersChatParents.class);
        startActivity(i);

    }

    public  void listStudent(View v){

        Intent i = new Intent(this , TeachersChatStudents.class);
        startActivity(i);

    }
}
