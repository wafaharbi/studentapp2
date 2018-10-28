package com.example.wafa.studentapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ParentProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent_profile);
    }

    public void info(View v){

        Intent i = new Intent(this , ParentInfo.class);
        startActivity(i);
    }

    public  void userlist(View v){
        Intent i = new Intent(this , ParentHome.class);
        startActivity(i);
    }

public  void list(View v){

    Intent i = new Intent(this , ParentChatTeacher.class);
    startActivity(i);

}




}
