package com.example.wafa.studentapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

public class StudentHome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_home);
    }

    public  void StudentInformation(View v) {



        Intent i = new Intent(this, StudentInfo.class);
        startActivity(i);
    }

    public  void listTeacher(View v) {



        Intent i = new Intent(this, StudentChatTeacher.class);
        startActivity(i);
    }

    public  void listchat(View v) {



        Intent i = new Intent(this, listStudentChat.class);
        startActivity(i);
    }


}

