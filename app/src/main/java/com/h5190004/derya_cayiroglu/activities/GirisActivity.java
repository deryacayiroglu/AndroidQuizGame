package com.h5190004.derya_cayiroglu.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.h5190004.derya_cayiroglu.R;
import com.h5190004.derya_cayiroglu.model.OyuncuModel;
import com.h5190004.derya_cayiroglu.utils.Constants;
import com.h5190004.derya_cayiroglu.utils.ObjectUtil;
import com.h5190004.derya_cayiroglu.utils.PrefUtil;

public class GirisActivity extends AppCompatActivity {
    View logo;
    TextView txtOyuncuAdi;
    Button btnNext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giris);
        init();

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                oyuncuAdıBosKontrolu();
            }
        });
    }

    private void init(){
        txtOyuncuAdi = findViewById(R.id.txtOyuncuAdi);
        btnNext = findViewById(R.id.btnNext);
        logo = findViewById(R.id.imgLogo2);
    }

    private void oyuncuAdıBosKontrolu(){
        if(txtOyuncuAdi.getText().toString().isEmpty()){
            Toast.makeText(GirisActivity.this, "Oyuncu Adı Girilmedi!", Toast.LENGTH_SHORT).show();
        }else{
            OyuncuModel oyuncu = new OyuncuModel(
                    txtOyuncuAdi.getText().toString(),
                    0
            );

            String oyuncuJson = ObjectUtil.oyuncuToJsonString(oyuncu);
            PrefUtil.setStringPref(getApplicationContext(), Constants.PREF_OYUNCU_OBJESI,oyuncuJson);
            startActivity(new Intent(GirisActivity.this,KategoriActivity.class));
            finish();
        }
    }

}