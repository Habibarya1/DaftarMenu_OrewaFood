package com.example.daftarmenu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<com.example.daftarmenu.SetterGetter> datamenu;
    GridLayoutManager gridLayoutManager;
     com.example.daftarmenu.DashBoardActivity adapter;
     FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        addData();
        gridLayoutManager = new GridLayoutManager(this,1);
        recyclerView.setLayoutManager(gridLayoutManager);

        adapter = new com.example.daftarmenu.DashBoardActivity(datamenu);
        recyclerView.setAdapter(adapter);

        fAuth = FirebaseAuth.getInstance();
    }

    public void addData(){
        datamenu = new ArrayList<>();
        datamenu.add(new com.example.daftarmenu.SetterGetter("Takoyaki","FotoMakanan1","Rp.21.000","Adonan Tepung yang sudah dicampur dengan berbagai macam bahan dan di isi dengan gurita","Harga:   Rp.21.000",R.drawable.takoyaki));
        datamenu.add(new com.example.daftarmenu.SetterGetter("Sushi","FotoMakanan2","Rp.25.000","Nasi yang digulung dengan rumput laut dan ikan sebagai isinya","Harga:   Rp.25.000",R.drawable.sushi));
        datamenu.add(new com.example.daftarmenu.SetterGetter("Onigiri","FotoMakanan3","Rp.10.000","Nasi yang dibentuk bulat atau segitiga dengan balutan rumput laut dan isi biji-bijian","Harga   Rp.10.000",R.drawable.onigiri));
        datamenu.add(new com.example.daftarmenu.SetterGetter("Ramen","FotoMakanan4","Rp.18.000","Ramen adalah masakan mi kuah Jepang yang berasal dari Tiongkok. Orang Jepang juga menyebut ramen sebagai chuka soba atau shina soba karena soba atau o-soba dalam bahasa Jepang sering juga berarti mi.","Harga   Rp.18.000",R.drawable.ramen));
    }

    public void logout(View view) {
        fAuth.signOut();

        startActivity(new Intent(MainActivity.this, WelcomeActivity.class));
    }
}