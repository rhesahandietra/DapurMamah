package com.handietron.dapurmamah;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Detail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent intent = getIntent();
        getSupportActionBar().setTitle(intent.getStringExtra("Judul"));

        TextView bahan = (TextView) findViewById(R.id.bahan);
        TextView step = (TextView) findViewById(R.id.step);
        ImageView gambar = (ImageView) findViewById(R.id.myImage);

        gambar.setImageResource(intent.getIntExtra("Gambar",0));
        bahan.setText(intent.getStringExtra("Bahan"));
        step.setText(intent.getStringExtra("Step"));
    }
}
