package com.example.utsdeo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    RecyclerView recycleView;
    Button btn;

    String s1[], s2[], s3[], s4[];
    int images[]= {R.drawable.sate_loso,R.drawable.lontong_dekem,R.drawable.nasi_grombyang,R.drawable.pecakbelut,R.drawable.apemcomal,R.drawable.kroco};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btnDetail);

        recycleView = findViewById(R.id.recyclerView);

        s1 = getResources().getStringArray(R.array.daftar_makanan);
        s2 = getResources().getStringArray(R.array.deskripsi);
        s3 = getResources().getStringArray(R.array.harga);
        s4 = getResources().getStringArray(R.array.deksripsi_full);

        MyAdapter myAdapter = new MyAdapter(this, s1, s2, s3, s4, images, btn);
        recycleView.setAdapter(myAdapter);
        recycleView.setLayoutManager(new LinearLayoutManager(this));

    }

}