package com.ajay.recycleviewexample;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHolder> {


    private String[]data;
    private  int[]imageData;

    public MyAdapter(String[] data,int[]imageData){

        //declaring constructors variables
        this.data = data;
        this.imageData = imageData;


    }


    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        //here we create layout inflater object for this context
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());


        //access inflater object in view
        //this view inflate our list layout to view
        View view = inflater.inflate(R.layout.list_item_view,parent,false);


        //returning view in Holder
        return new MyHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, final int position) {


        //bind view we want to load in recycle view
        final String title = data[position];//access title from data with position

        holder. txtTitle.setText(title);//set data using holder to declared view id we want to set



        final int image = imageData[position];
        holder.imgView.setImageResource(image);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(view.getContext(),title.toString(),Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(view.getContext(), DetailActivity.class);
                intent.putExtra("Detail_title",title);


                //because image is type int we cannot directly pass it as string so we add them in bumdle and then put as Int
                //and can pass to views,otherwise it will crash app
                Bundle bundle=new Bundle();//Bundle Object
                bundle.putInt("image",image);//putting putInt images to bundle object
                intent.putExtras(bundle);//adding bundle to intent putExtra so we can access from other activity

                //starting activity with context of this class we stored Text Title in intent object so we neet to pass like this
                //to send intent info to other activity to be access
                view.getContext().startActivity(intent);





            }
        });

    }

    @Override
    public int getItemCount() {

        //return count data.lenght
        return data.length;//returning data lenght
    }



    public class MyHolder extends RecyclerView.ViewHolder{


        //here we assigning view ids so we not need to find view by id every time
        //we declairing here beacuse we can access it from here to globally

        ImageView imgView;//declaring ImageView
        TextView txtTitle;//declaring TextView



        //this holds itemView views
        public MyHolder(View itemView) {



            super(itemView);



            //assign find view by id with itemView.findViewById();
            imgView =(ImageView) itemView.findViewById(R.id.list_image_icon);
            txtTitle =(TextView) itemView.findViewById(R.id.list_item_title);


        }

    }
}
