package com.digitalsoftware.firstbelajar.uts_android;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et_namabelakang, et_namadepan, et_alamat;
    Spinner sp_kelamin;
    CheckBox cb_smk1,cb_smk2,cb_smk3,cb_smk4;
    RadioGroup rg_lulusan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_namadepan = findViewById(R.id.et_namadepan);
        et_namabelakang = findViewById(R.id.et_namabelakang);
        et_alamat = findViewById(R.id.et_alamat);

        sp_kelamin = findViewById(R.id.sp_kelamin);
        cb_smk1 = findViewById(R.id.cb_smk1);
        cb_smk2 = findViewById(R.id.cb_smk2);
        cb_smk3 = findViewById(R.id.cb_smk3);
        cb_smk4 = findViewById(R.id.cb_smk4);

        rg_lulusan = findViewById(R.id.rg_lulusan);

        final RadioButton rbSMA = findViewById(R.id.rb_SMA);
        rbSMA.setChecked(true);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Memanggil Layout menunya
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);

        //definisi searview agar dapat diolah textnya
        MenuItem menuItem = menu.findItem(R.id.mn_cari);
        SearchView searchView = (SearchView)menuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Toast.makeText(getApplicationContext(),newText, Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case  R.id.mn_simpan:
                String namaD,namaB;

                namaD = et_namadepan.getText().toString();
                namaB = et_namabelakang.getText().toString();

                //selipkan data
                Intent i = new Intent(MainActivity.this,DetailActivity.class);
                i.putExtra("i_namaD",namaD);
                i.putExtra("i_namaB",namaB);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                getApplicationContext().startActivity(i);
                return true;

            case R.id.mn_biodata:
                View view = findViewById(R.id.main_layout_id);
                String pesan = "HERMAWAN";
                int durasi = Snackbar.LENGTH_SHORT;
                Snackbar.make(view,pesan,durasi).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
