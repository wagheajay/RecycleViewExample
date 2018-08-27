package com.ajay.recycleviewexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


//array of images we want to display in view Holder of recycle
  int[] Images = {R.drawable.actress_1, R.drawable.actress_2, R.drawable.actress_3, R.drawable.actress_4,

            R.drawable.actress_1, R.drawable.actress_2, R.drawable.actress_3, R.drawable.actress_4,
            R.drawable.actress_1, R.drawable.actress_2, R.drawable.actress_3, R.drawable.actress_4,
            R.drawable.actress_1, R.drawable.actress_2, R.drawable.actress_3, R.drawable.actress_4};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





        RecyclerView myRView = (RecyclerView) findViewById(R.id.MyRecycleView);//finding recycler view by id


        //setting layout for our Recycler view to show in layout manager various type
        myRView.setLayoutManager(new LinearLayoutManager(this));//setting layout to our recycle view so we can display content right way



        //Array of type String we want to display in view holder titles
        String[] FamilyMembers = {"Tammanna", "Ramya", "Kajol", "shivanya",
                "Tammanna", "Ramya", "Kajol", "shivanya",
                "Tammanna", "Ramya", "Kajol", "shivanya",
                "Tammanna", "Ramya", "Kajol", "shivanya"};

        //sending data to adapter to view
        myRView.setAdapter(new MyAdapter(FamilyMembers, Images));//setting arrays of String and images to recycle view adapter


    }
}
