package com.kendaraan.sewa.aplikasi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText txtNama = findViewById(R.id.txt_nama);
        EditText txtKtp = findViewById(R.id.txt_ktp);
        EditText txtSim = findViewById(R.id.txt_sim);
        EditText txtTelpon = findViewById(R.id.txt_telpon);
        EditText txtAlamat = findViewById(R.id.txt_alamat);

        Button btnSimpan = findViewById(R.id.btn_simpan);

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), txtNama.getText(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Activity Lifecycle", "Sedang Start");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Activity Lifecycle", "Sedang Resume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Activity Lifecycle", "Sedang Stop");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Activity Lifecycle", "Sedang Pause");
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Activity Lifecycle", "Sedang Destroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Activity Lifecycle", "Restart");
    }
}
