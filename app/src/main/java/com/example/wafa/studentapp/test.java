package com.example.wafa.studentapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class test extends AppCompatActivity {

    TextView id ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);


      String user_id=   getIntent().getStringExtra("user_id");
        id =(TextView) findViewById(R.id.profileName);
        id.setText(user_id);

    }
}
