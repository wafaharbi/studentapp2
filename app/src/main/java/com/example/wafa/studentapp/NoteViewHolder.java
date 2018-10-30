package com.example.wafa.studentapp;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class NoteViewHolder extends RecyclerView.ViewHolder {


    View mView;

    TextView  textTime;
    //CardView noteCard;

    public NoteViewHolder(View itemView) {
        super(itemView);

        mView = itemView;

        textTime = mView.findViewById(R.id.date);

    }



    public void setNoteTime(String time) {

        textTime.setText(time);
    }

}


