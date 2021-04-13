package com.h5190004.derya_cayiroglu.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.h5190004.derya_cayiroglu.R;
import com.h5190004.derya_cayiroglu.utils.Constants;
import com.h5190004.derya_cayiroglu.utils.PrefUtil;
import com.h5190004.derya_cayiroglu.utils.SoruUtil;

public class OyunSonuActivity extends AppCompatActivity implements View.OnClickListener {
    TextView txtSoruSiraOyunSonu, txtPuanOyunSonu, txtBilgiOyunSonu;
    Button btnAnaSayfa, btnCikis;
    View imgWinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oyun_sonu);
        init();
    }

    private void init(){
        SoruUtil.listeTemizle();
        imgWinner = findViewById(R.id.imgWinner);
        txtSoruSiraOyunSonu = findViewById(R.id.txtSoruSiraOyunSonu);
        txtPuanOyunSonu = findViewById(R.id.txtPuanOyunSonu);
        txtBilgiOyunSonu = findViewById(R.id.txtBilgiOyunSonu);
        btnAnaSayfa = findViewById(R.id.btnAnaSayfaOyunSonu);
        btnCikis = findViewById(R.id.btnCikisOyunSonu);

        txtSoruSiraOyunSonu.setText(PrefUtil.getStringPref(getApplicationContext(), Constants.PREF_SORU_SIRA) + "/10");
        txtPuanOyunSonu.setText("Puan: " + PrefUtil.getStringPref(getApplicationContext(),Constants.PREF_PUAN));

        btnAnaSayfa.setOnClickListener(this);
        btnCikis.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnAnaSayfaOyunSonu:

                startActivity(new Intent(OyunSonuActivity.this,KategoriActivity.class));
                finish();
                break;
            case R.id.btnCikisOyunSonu:
                finish();
        }
    }
}