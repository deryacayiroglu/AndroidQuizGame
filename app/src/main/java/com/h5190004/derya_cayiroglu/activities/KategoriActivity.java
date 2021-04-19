package com.h5190004.derya_cayiroglu.activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.h5190004.derya_cayiroglu.R;
import com.h5190004.derya_cayiroglu.model.OyuncuModel;
import com.h5190004.derya_cayiroglu.utils.Constants;
import com.h5190004.derya_cayiroglu.utils.ObjectUtil;
import com.h5190004.derya_cayiroglu.utils.PrefUtil;
import com.h5190004.derya_cayiroglu.utils.SoruUtil;

public class KategoriActivity extends AppCompatActivity implements View.OnClickListener {
    View logo, imgIcon1, imgIcon2;
    TextView txtOyuncuAd;
    Button btnCikis, btnKategori1, btnKategori2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kategori);
        init();
    }

    private void init(){
        txtOyuncuAd = findViewById(R.id.txtOyuncuAd);
        logo =findViewById(R.id.imgLogo3);
        imgIcon1 = findViewById(R.id.imgIcon1);
        imgIcon2 = findViewById(R.id.imgIcon2);
        btnCikis = findViewById(R.id.btnCikis);
        btnKategori1 = findViewById(R.id.btnKategori1);
        btnKategori2 = findViewById(R.id.btnKategori2);

        btnCikis.setOnClickListener(this::onClick);
        btnKategori1.setOnClickListener(this::onClick);
        btnKategori2.setOnClickListener(this::onClick);
        prefOyuncuGetir();
    }

    private void prefOyuncuGetir(){
        String oyuncuJson = PrefUtil.getStringPref(getApplicationContext(), Constants.PREF_OYUNCU_OBJESI);
        OyuncuModel oyuncu = ObjectUtil.jsonStringToOyuncu(oyuncuJson);
        txtOyuncuAd.setText("Hoşgeldin,  " + oyuncu.getAdi());
    }

    private void dialogGoster(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("ÇIKIŞ");
        builder.setMessage("Uygulamadan Çıkılsın Mı?");
        builder.setPositiveButton("Hayır", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.setNegativeButton("Evet", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                finish();
            }
        });

        builder.show();
    }

    public void kategoriAdıTut(Button btnTiklananKategori , int kategoriId){
        PrefUtil.setStringPref(getApplicationContext(),Constants.PREF_KATEGORI_ADI,btnTiklananKategori.getText().toString());
        PrefUtil.setIntPref(getApplicationContext(),Constants.PREF_KATEGORI_ID,kategoriId);
        startActivity(new Intent(KategoriActivity.this, SoruActivity.class));
        finish();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnCikis:
                dialogGoster();
                break;

            case R.id.btnKategori1:
                kategoriAdıTut(btnKategori1,1);
                break;

            case R.id.btnKategori2:
                kategoriAdıTut(btnKategori2,2);
                break;
        }
    }
}