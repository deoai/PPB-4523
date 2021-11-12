package com.example.utsdeo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    ImageView mainImageView;
    TextView title, deskripsi, harga;

    String data1, data2, data3, data4;
    int myImage;

    Button btnContact,btnInsta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        mainImageView = findViewById((R.id.mainImageView));
        title = findViewById((R.id.title));
        deskripsi = findViewById(R.id.deskripsi);
        harga = findViewById(R.id.harga);

        btnContact = findViewById(R.id.contact);
        btnInsta = findViewById(R.id.inst);

        btnContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://api.whatsapp.com/send?phone=6289659615260&text=halo%20mas%20ganteng");
            }
        });
        btnInsta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://www.instagram.com/deoiskndr/");
            }
        });



        getData();
        setData();
    }

    private void gotoUrl(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }

    private void getData(){
        if(getIntent().hasExtra("myImage") && getIntent().hasExtra("data1") &&
        getIntent().hasExtra("data2")){

            data1 = getIntent().getStringExtra("data1");
            data2 = getIntent().getStringExtra("data2");
            data3 = getIntent().getStringExtra("data3");
            data4 = getIntent().getStringExtra("data4");
            myImage = getIntent().getIntExtra("myImage", 1);

        }else{
            Toast.makeText(this, "No Data.", Toast.LENGTH_SHORT).show();
        }
    }
    private void setData(){
        title.setText(data1);
        deskripsi.setText(data4);
        harga.setText(data3);
        mainImageView.setImageResource(myImage);
    }
}