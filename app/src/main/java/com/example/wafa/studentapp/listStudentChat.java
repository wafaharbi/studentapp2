package com.example.wafa.studentapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class listStudentChat extends AppCompatActivity {

    RecyclerView recyclerView;

    UserAdapter userAdapter;

    List<User> mChat;
    List<String> userlist;

    FirebaseUser fuser;
    DatabaseReference reference , ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_student_chat);

        recyclerView = (RecyclerView) findViewById(R.id.recycle_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        fuser = FirebaseAuth.getInstance().getCurrentUser();
        userlist = new ArrayList<>();
        mChat = new ArrayList<>();

        reference = FirebaseDatabase.getInstance().getReference().child("Teachers");
        reference.keepSynced(true);
        ref = FirebaseDatabase.getInstance().getReference().child("Chats");
        ref.keepSynced(true);

/*
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                userlist.clear();
                for(DataSnapshot snapshot: dataSnapshot.getChildren()){

                    Chat chat = snapshot.getValue(Chat.class);

                    if(chat.getSender().equals(fuser.getUid())){
                        userlist.add(chat.getReciver());
                    }
                    if(chat.getReciver().equals(fuser.getUid())){
                        userlist.add(chat.getSender());
                    }


                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


*/
    }

    /*

    public  void read(){



        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                mChat.clear();

                for(DataSnapshot snapshot: dataSnapshot.getChildren()){

                    Chat chat = snapshot.getValue(Chat.class);

                    if(chat.getSender().equals(fuser.getUid())){
                        mChat.add(chat);
                    }
                    if(chat.getReciver().equals(fuser.getUid())){
                        mChat.add(chat);
                    }


                }

//                userAdapter = new UserAdapter(listStudentChat.this, mChat);
                recyclerView.setAdapter(userAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }

*/

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseRecyclerAdapter<User , UserViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<User, UserViewHolder>(
                User.class,
                R.layout.user_single_item,
                UserViewHolder.class,
                ref
        )
        {
            @Override
            protected  void populateViewHolder( final UserViewHolder viewHolder, User model, int position) {


                //final String currentdate = DateFormat.getDateTimeInstance().format(new Date());

                // __ To get ID for Specific user __ !


                final String user_id = getRef(position).getKey();

          if(ref.child("reciver").equals(reference.child(user_id)))

          {
              ref.addValueEventListener(new ValueEventListener() {
                  @Override
                  public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                      userlist.clear();
                      for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                          Chat chat = snapshot.getValue(Chat.class);

                          if (chat.getSender().equals(fuser.getUid())) {
                              userlist.add(chat.getReciver());
                          }
                          if (chat.getReciver().equals(fuser.getUid())) {
                              userlist.add(chat.getSender());
                          }

                      }

                      reference.addValueEventListener(new ValueEventListener() {
                          @Override
                          public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                              mChat.clear();

                              for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                                  User user = snapshot.getValue(User.class);

                                  for (String id : userlist) {

                                      if (user_id != fuser.getUid()) {
                                          if (mChat.size() != 0) {

                                              for (User user1 : mChat) {


                                                  mChat.add(user);
                                              }
                                          }
                                      }
                                  }

                              }

                              //  userAdapter = new UserAdapter(listStudentChat.this, mChat);
                              // recyclerView.setAdapter(userAdapter);
                          }

                          @Override
                          public void onCancelled(@NonNull DatabaseError databaseError) {

                          }
                      });

                  }

                  @Override
                  public void onCancelled(@NonNull DatabaseError databaseError) {

                  }
              });


               /*
              ref.addValueEventListener(new ValueEventListener() {
                  @Override
                  public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                      mChat.clear();

                      for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                          User user = snapshot.getValue(User.class);

                          for (String id : userlist) {

                              if (user_id != fuser.getUid()) {
                                  if (mChat.size() != 0) {

                                      for (User user1 : mChat) {
                                          mChat.add(user);
                                      }
                                  }
                              }
                          }

                      }


                      //  userAdapter = new UserAdapter(listStudentChat.this, mChat);
                      // recyclerView.setAdapter(userAdapter);
                  }

                  @Override
                  public void onCancelled(@NonNull DatabaseError databaseError) {

                  }
              });

*/
          }


              /*  mDatabase.child(user_id).setValue(currentdate).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {


                    }
                });
                */

                //viewHolder.setDate(currentdate);
                //

                viewHolder.setName(model.getName());




/*
                viewHolder.mView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent i = new Intent(listStudentChat.this, MessageStudentTeacher.class);
                        i.putExtra("user_id" , user_id);

                        startActivity(i);
                    }
                });
                */

            }
        };

        recyclerView.setAdapter(firebaseRecyclerAdapter);
    }



    public static class UserViewHolder extends  RecyclerView.ViewHolder{

        View mView;
        public UserViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
        }
        public void  setName(String name){

            TextView UserName = (TextView) mView.findViewById(R.id.user_single_name);
            UserName.setText(name);
        }


/*
        public  void setDate(String date){
            TextView userdate = (TextView) mView.findViewById(R.id.date);
            userdate.setText(date);


        }
*/

    }


}

