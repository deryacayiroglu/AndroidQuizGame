package com.h5190004.derya_cayiroglu.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import com.h5190004.derya_cayiroglu.R;
import com.h5190004.derya_cayiroglu.model.OyuncuModel;
import com.h5190004.derya_cayiroglu.utils.Constants;
import com.h5190004.derya_cayiroglu.utils.ObjectUtil;
import com.h5190004.derya_cayiroglu.utils.PrefUtil;
import com.h5190004.derya_cayiroglu.utils.SoruUtil;

import java.lang.ref.PhantomReference;

public class YanlisCevapActivity extends AppCompatActivity implements View.OnClickListener {
    TextView txtSoruSiraYanlis, txtPuanYanlis, txtOyunBitti;
    Button btnAnaSayfa, btnCikis;
    View imgGameOver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yanlis_cevap);
        init();
    }

    private void init(){
        imgGameOver = findViewById(R.id.imgGameOver);
        txtSoruSiraYanlis = findViewById(R.id.txtSoruSiraYanlis);
        txtPuanYanlis = findViewById(R.id.txtPuanYanlis);
        txtOyunBitti = findViewById(R.id.txtOyunBitti);
        btnAnaSayfa = findViewById(R.id.btnAnaSayfaYanlis);
        btnCikis = findViewById(R.id.btnCikisYanlis);

        txtSoruSiraYanlis.setText(PrefUtil.getStringPref(getApplicationContext(), Constants.PREF_SORU_SIRA) + "/10");
        txtPuanYanlis.setText("Puan: " + PrefUtil.getStringPref(getApplicationContext(),Constants.PREF_PUAN));

        btnCikis.setOnClickListener(this);
        btnAnaSayfa.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnAnaSayfaYanlis:
                startActivity(new Intent(YanlisCevapActivity.this,KategoriActivity.class));
                SoruUtil.listeTemizle();
                finish();
                break;
            case R.id.btnCikisYanlis:
                finish();
        }
    }
}