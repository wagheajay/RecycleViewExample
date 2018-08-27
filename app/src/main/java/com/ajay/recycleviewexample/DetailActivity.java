package com.ajay.recycleviewexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //we created getIncomingIntent() method to varify and get intent to detail activity and called here
        getIncomeingIntent();


    }

    //method to getIntentents
    private void getIncomeingIntent(){

        if (getIntent().hasExtra("Detail_title")){


            Log.d("Message","Extra Intents Found");


            //accessing Text title from putExtra to getExtra for other detail activity like this
            // type variable = getIntent().getStringExtra("Key");//this is String type so we can acess like this
            String DetailText = getIntent().getStringExtra("Detail_title");



            //accessing Bundle intents like this using
            //Bundle object = this.getIntent.getExtras();//we use context of this activity and getIntent() with getExtras()
            Bundle bundle=this.getIntent().getExtras();
            int pic=bundle.getInt("image");//accessing Bundle putInt from Bundle we created to putInt
            //access it using int variable=bundle.getInt(key);//from bundle



           SetDetails(DetailText,pic);//calling SetDetail(Detailtext,pic); with parameters/constructors
        }
    }

    //SetDetail() method we created to set our Extra intent data to views
    //passed constructor function (String Detailtext,int pic)//as type we want to access
    private void SetDetails(String DetailText,int pic){


        //finding views by id where we want to show our extra intent data
        ImageView FinalDetailImage = findViewById(R.id.actress_image);//ImageView
        TextView FinalDetailText = findViewById(R.id.actrees_name_title);//textView

       FinalDetailImage.setImageResource(pic);//setting image resource like this to view variable

        FinalDetailText.setText(DetailText);//setting Text using Viewvariable.setText(getting extra data variable)like this to view variable


    }



}
