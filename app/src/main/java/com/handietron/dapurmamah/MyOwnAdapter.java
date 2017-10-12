package com.handietron.dapurmamah;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Handietron on 05/10/2017.
 */

public class MyOwnAdapter extends RecyclerView.Adapter<MyOwnAdapter.MyOwnHolder> {


    Context ctx;
    ArrayList<Resep>resep;

    public MyOwnAdapter(Context ct, ArrayList<Resep>resep){
        ctx = ct;
        this.resep = resep;
    }

    @Override
    public MyOwnHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater myInflator = LayoutInflater.from(ctx);
        View MyOwnView = myInflator.inflate(R.layout.my_row,parent,false);


        return new MyOwnHolder(MyOwnView);
    }

    @Override
    public void onBindViewHolder(MyOwnHolder holder,final int position) {
        holder.t1.setText(resep.get(position).getJudulResep());
        holder.t2.setText(resep.get(position).getPenjelasanResep());
        holder.myImage.setImageResource(resep.get(position).getGambarResep());

        holder.relativelayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ctx,Detail.class);
                intent.putExtra("Bahan",resep.get(position).getBahanResep());
                intent.putExtra("Step",resep.get(position).getStepResep());
                intent.putExtra("Gambar",resep.get(position).getGambarResep());
                intent.putExtra("Judul",resep.get(position).getJudulResep());
                ctx.startActivity(intent);
            }
        });
        }


    public class MyOwnHolder extends RecyclerView.ViewHolder {
        TextView t1,t2;
        ImageView myImage;
        RelativeLayout relativelayout;
        public MyOwnHolder(View itemView) {
            super(itemView);
            relativelayout =(RelativeLayout)itemView.findViewById(R.id.parent);
            t1 = (TextView)itemView.findViewById(R.id.text1);
            t2 = (TextView)itemView.findViewById(R.id.text2);
            myImage = (ImageView)itemView.findViewById(R.id.myImage);
        }
    }

    @Override
    public int getItemCount(){
        return resep.size();
    }


}
