package com.example.wafa.studentapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.DateFormat;
import java.util.Date;

public class StudentChatTeacher extends AppCompatActivity {

    RecyclerView mUserList;


    DatabaseReference mDatabase;
    FirebaseUser firebaseUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_chat_teacher);

        mUserList = (RecyclerView) findViewById(R.id.users_list);
        mUserList.setHasFixedSize(true);
        mUserList.setLayoutManager(new LinearLayoutManager(this));
        mDatabase = FirebaseDatabase.getInstance().getReference().child("Teachers");



    }
    @Override
    protected void onStart() {
        super.onStart();

        FirebaseRecyclerAdapter<User , StudentChatTeacher.UserViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<User, StudentChatTeacher.UserViewHolder>(
                User.class,
                R.layout.user_single_item,
                StudentChatTeacher.UserViewHolder.class,
                mDatabase
        ) {
            @Override
            protected  void populateViewHolder(  StudentChatTeacher.UserViewHolder viewHolder, User model, int position) {


                final String currentdate = DateFormat.getDateTimeInstance().format(new Date());

                // __ To get ID for Specific user __ !

                FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

                viewHolder.setDate(currentdate);

                final  String currntUser = firebaseUser.getUid();
                final String user_id = getRef(position).getKey();

                /*
               mDatabase.child(currntUser).child(user_id).setValue(currentdate)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {


                        mDatabase.child(user_id).child(currntUser).setValue(currentdate).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {


                            }
                        });

                    }
                });
                */

                viewHolder.setName(model.getName());


                //

              // viewHolder.isChat(model.getStatus());




                viewHolder.mView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent i = new Intent(StudentChatTeacher.this, MessageStudentTeacher.class);
                        i.putExtra("user_id" , user_id);

                        startActivity(i);
                    }
                });

            }
        };

        mUserList.setAdapter(firebaseRecyclerAdapter);
    }

    public static class UserViewHolder extends  RecyclerView.ViewHolder{

        View mView;


        public UserViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
        }

        /*
        private boolean isChat(String status){
            ImageView img_on = (ImageView) mView.findViewById(R.id.img_on);
            ImageView img_off = (ImageView) mView.findViewById(R.id.img_off);
            User user = new User();
            if(user.getStatus().equals("online")){
               img_on.setVisibility(mView.VISIBLE);
                img_off.setVisibility(mView.GONE);
            }
            else if(user.getStatus().equals("offline")) {
                img_on.setVisibility(mView.GONE);
                img_off.setVisibility(mView.VISIBLE);
            }
            else {

                img_on.setVisibility(mView.GONE);
                img_off.setVisibility(mView.GONE);
            }

            return false;
        }
        */

        public void  setName(String name){

            TextView UserName = (TextView) mView.findViewById(R.id.user_single_name);


            UserName.setText(name);
        }



        public  void setDate(String date){
            TextView userdate = (TextView) mView.findViewById(R.id.date);
            userdate.setText(date);


        }


    }


}
