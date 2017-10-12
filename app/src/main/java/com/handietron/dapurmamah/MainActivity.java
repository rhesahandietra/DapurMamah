package com.handietron.dapurmamah;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    String s1[],s2[],bahan[],step[];
    int imageresource[]= {R.drawable.lasagna,R.drawable.kungpao,R.drawable.rendang,R.drawable.empal,R.drawable.migoreng,R.drawable.bakwan,R.drawable.gado};
    RecyclerView recyclerView;
    boolean doubleBackToExitPressedOnce = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.logo3);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView = (RecyclerView) findViewById(R.id.myRecycler);
        recyclerView.setLayoutManager(linearLayoutManager);

        s1 = getResources().getStringArray(R.array.makanan);
        s2 = getResources().getStringArray(R.array.deskripsi);
        bahan = getResources().getStringArray(R.array.bahan);
        step = getResources().getStringArray(R.array.step);


        ArrayList<Resep> resepList = new ArrayList<>();

        for(int i=0;i<s1.length;i++){
            Resep resep = new Resep(imageresource[i],s1[i],s2[i],bahan[i],step[i]);

            resepList.add(resep);
        }
        MyOwnAdapter myOwnAdapter = new MyOwnAdapter(this,resepList);
        recyclerView.setAdapter(myOwnAdapter);
    }

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Tekan kembali sekali lagi", Toast.LENGTH_SHORT).show();
    }
}
