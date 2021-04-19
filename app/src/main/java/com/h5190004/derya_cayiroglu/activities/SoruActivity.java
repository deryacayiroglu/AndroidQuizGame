package com.h5190004.derya_cayiroglu.activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.h5190004.derya_cayiroglu.R;
import com.h5190004.derya_cayiroglu.model.OyuncuModel;
import com.h5190004.derya_cayiroglu.model.SoruModel;
import com.h5190004.derya_cayiroglu.utils.SoruUtil;
import com.h5190004.derya_cayiroglu.utils.Constants;
import com.h5190004.derya_cayiroglu.utils.ObjectUtil;
import com.h5190004.derya_cayiroglu.utils.PrefUtil;

public class SoruActivity extends AppCompatActivity implements View.OnClickListener {
    TextView txtKategori, txtPuan, txtSoruSira, txtSoru;
    Button btnCevap1, btnCevap2, btnCevap3;
    int soruSıra = 1;
    int puan = 0;
    int soruSayısı;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soru);
        init();
    }

    private void init(){
        soruSayısı = SoruUtil.soruSayisiGetir();
        txtKategori = findViewById(R.id.txtKategori);
        txtKategori.setText(PrefUtil.getStringPref(getApplicationContext(), Constants.PREF_KATEGORI_ADI));
        txtPuan = findViewById(R.id.txtPuan);
        txtSoruSira = findViewById(R.id.txtSoruSira);
        txtSoru = findViewById(R.id.txtSoru);
        btnCevap1 = findViewById(R.id.btnCevap1);
        btnCevap2 = findViewById(R.id.btnCevap2);
        btnCevap3 = findViewById(R.id.btnCevap3);

        btnCevap1.setOnClickListener(this);
        btnCevap2.setOnClickListener(this);
        btnCevap3.setOnClickListener(this);
        txtPuan.setText("Puan: " + puan);


        SoruUtil.sorulariOlustur(getApplicationContext());
        butonlarıResetle();
        soruDoldur();

    }

    private void soruDoldur(){
        butonlarıResetle();
        SoruModel soru = SoruUtil.siradakiSoruyuGetir();
        txtSoru.setText(soru.getSoru());
        btnCevap1.setText(soru.getCevap1());
        btnCevap2.setText(soru.getCevap2());
        btnCevap3.setText(soru.getCevap3());
        txtPuan.setText("Puan: " + puan);
        txtSoruSira.setText(soruSıra +"/"+ SoruUtil.soruSayisiGetir());

    }

    private void butonlarıResetle(){
        btnCevap1.setBackground(getDrawable(R.drawable.btn_cevap));
        btnCevap2.setBackground(getDrawable(R.drawable.btn_cevap));
        btnCevap3.setBackground(getDrawable(R.drawable.btn_cevap));
    }


    private void cevapKontrolEt(int tıklananCevap , View btnTiklanan){
        if(SoruUtil.cevapDogruMu(tıklananCevap)){
            btnTiklanan.setBackground(getDrawable(R.drawable.btn_cevap_dogru));
            CountDownTimer countDownTimer = new CountDownTimer(1000,1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                }

                @Override
                public void onFinish() {
                    if(soruSıra==SoruUtil.soruSayisiGetir()){
                        oyunSonu();
                    }else{
                        dogruCevapDialog();
                    }
                }
            }.start();
        }
        else {
            btnTiklanan.setBackground(getDrawable(R.drawable.btn_cevap_yanlis));
            soruSiraVePuanTut();
            CountDownTimer countDownTimer = new CountDownTimer(1000,1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                }

                @Override
                public void onFinish() {
                    startActivity(new Intent(SoruActivity.this,YanlisCevapActivity.class));
                    finish();
                }
            }.start();
        }
    }

    private void dogruCevapDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("CEVAP DOGRU");
        builder.setMessage("Devam Etmek İstiyor Musunuz?");
        builder.setPositiveButton("Evet", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                puanVeSoruSiraGuncelle();
                soruDoldur();
            }
        });
        builder.setNegativeButton("Hayır", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                SoruUtil.listeTemizle();
                startActivity(new Intent(SoruActivity.this,KategoriActivity.class));
                finish();
            }
        });

        builder.show();
    }

    private void puanVeSoruSiraGuncelle(){
        puan += 100;
        soruSıra++;
    }
    private void soruSiraVePuanTut(){
        PrefUtil.setStringPref(getApplicationContext(),Constants.PREF_SORU_SIRA,String.valueOf(soruSıra-1));
        PrefUtil.setStringPref(getApplicationContext(),Constants.PREF_PUAN,String.valueOf(puan));
    }

    private void oyunSonu(){
        puanVeSoruSiraGuncelle();
        soruSiraVePuanTut();
        startActivity(new Intent(SoruActivity.this,OyunSonuActivity.class));
        finish();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnCevap1:
                cevapKontrolEt(1,v);
                break;

            case R.id.btnCevap2:
                cevapKontrolEt(2,v);
                break;

            case R.id.btnCevap3:
                cevapKontrolEt(3,v);
                break;
        }
    }
}