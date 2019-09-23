package com.digitalsoftware.firstbelajar.uts_android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

            final TextView tvNamaDepan = (TextView) findViewById(R.id.tv_namaDepan);
            final TextView tvNamaBelakang = (TextView) findViewById(R.id.tv_namaBelakang);

            Intent i = getIntent();
            tvNamaDepan.setText(i.getStringExtra("i_namaD"));
            tvNamaBelakang.setText(i.getStringExtra("i_namaB"));
            //
            getSupportActionBar().setTitle("Informasi");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
}
