package com.h5190004.derya_cayiroglu.utils;

import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;

import com.h5190004.derya_cayiroglu.R;
import com.h5190004.derya_cayiroglu.activities.KategoriActivity;
import com.h5190004.derya_cayiroglu.model.SoruModel;
import com.h5190004.derya_cayiroglu.utils.Constants;
import com.h5190004.derya_cayiroglu.utils.PrefUtil;

import java.util.ArrayList;

public class SoruUtil {
    static ArrayList<SoruModel> sorularKat1 = new ArrayList<>();
    static ArrayList<SoruModel> sorularKat2 = new ArrayList<>();
    static ArrayList<SoruModel> sorular = new ArrayList<>();
    static int SORU_INDEX = -1;
    public static void sorulariOlustur(Context context){
        sorularKat1.clear();
        sorularKat2.clear();
        sorular.clear();
        SoruModel kat1Soru1 = new SoruModel(
                context.getResources().getString(R.string.ktg1Soru1),
                context.getResources().getString(R.string.ktg1Soru1Cevap1),
                context.getResources().getString(R.string.ktg1Soru1Cevap2),
                context.getResources().getString(R.string.ktg1Soru1Cevap3),
                1
        );

        SoruModel kat1Soru2 = new SoruModel(
                context.getResources().getString(R.string.ktg1Soru2),
                context.getResources().getString(R.string.ktg1Soru2Cevap1),
                context.getResources().getString(R.string.ktg1Soru2Cevap2),
                context.getResources().getString(R.string.ktg1Soru2Cevap3),
                3
        );

        SoruModel kat1Soru3 = new SoruModel(
                context.getResources().getString(R.string.ktg1Soru3),
                context.getResources().getString(R.string.ktg1Soru3Cevap1),
                context.getResources().getString(R.string.ktg1Soru3Cevap2),
                context.getResources().getString(R.string.ktg1Soru3Cevap3),
                2
        );

        SoruModel kat1Soru4 = new SoruModel(
                context.getResources().getString(R.string.ktg1Soru4),
                context.getResources().getString(R.string.ktg1Soru4Cevap1),
                context.getResources().getString(R.string.ktg1Soru4Cevap2),
                context.getResources().getString(R.string.ktg1Soru4Cevap3),
                1
        );

        SoruModel kat1Soru5 = new SoruModel(
                context.getResources().getString(R.string.ktg1Soru5),
                context.getResources().getString(R.string.ktg1Soru5Cevap1),
                context.getResources().getString(R.string.ktg1Soru5Cevap2),
                context.getResources().getString(R.string.ktg1Soru5Cevap3),
                3
        );

        SoruModel kat1Soru6 = new SoruModel(
                context.getResources().getString(R.string.ktg1Soru6),
                context.getResources().getString(R.string.ktg1Soru6Cevap1),
                context.getResources().getString(R.string.ktg1Soru6Cevap2),
                context.getResources().getString(R.string.ktg1Soru6Cevap3),
                1
        );

        SoruModel kat1Soru7 = new SoruModel(
                context.getResources().getString(R.string.ktg1Soru7),
                context.getResources().getString(R.string.ktg1Soru7Cevap1),
                context.getResources().getString(R.string.ktg1Soru7Cevap2),
                context.getResources().getString(R.string.ktg1Soru7Cevap3),
                2
        );

        SoruModel kat1Soru8 = new SoruModel(
                context.getResources().getString(R.string.ktg1Soru8),
                context.getResources().getString(R.string.ktg1Soru8Cevap1),
                context.getResources().getString(R.string.ktg1Soru8Cevap2),
                context.getResources().getString(R.string.ktg1Soru8Cevap3),
                1
        );

        SoruModel kat1Soru9 = new SoruModel(
                context.getResources().getString(R.string.ktg1Soru9),
                context.getResources().getString(R.string.ktg1Soru9Cevap1),
                context.getResources().getString(R.string.ktg1Soru9Cevap2),
                context.getResources().getString(R.string.ktg1Soru9Cevap3),
                2
        );

        SoruModel kat1Soru10 = new SoruModel(
                context.getResources().getString(R.string.ktg1Soru10),
                context.getResources().getString(R.string.ktg1Soru10Cevap1),
                context.getResources().getString(R.string.ktg1Soru10Cevap2),
                context.getResources().getString(R.string.ktg1Soru10Cevap3),
                3
        );

        SoruModel kat2Soru1 = new SoruModel(
                context.getResources().getString(R.string.ktg2Soru1),
                context.getResources().getString(R.string.ktg2Soru1Cevap1),
                context.getResources().getString(R.string.ktg2Soru1Cevap2),
                context.getResources().getString(R.string.ktg2Soru1Cevap3),
                1
        );

        SoruModel kat2Soru2 = new SoruModel(
                context.getResources().getString(R.string.ktg2Soru2),
                context.getResources().getString(R.string.ktg2Soru2Cevap1),
                context.getResources().getString(R.string.ktg2Soru2Cevap2),
                context.getResources().getString(R.string.ktg2Soru2Cevap3),
                3
        );

        SoruModel kat2Soru3 = new SoruModel(
                context.getResources().getString(R.string.ktg2Soru3),
                context.getResources().getString(R.string.ktg2Soru3Cevap1),
                context.getResources().getString(R.string.ktg2Soru3Cevap2),
                context.getResources().getString(R.string.ktg2Soru3Cevap3),
                1
        );

        SoruModel kat2Soru4 = new SoruModel(
                context.getResources().getString(R.string.ktg2Soru4),
                context.getResources().getString(R.string.ktg2Soru4Cevap1),
                context.getResources().getString(R.string.ktg2Soru4Cevap2),
                context.getResources().getString(R.string.ktg2Soru4Cevap3),
                2
        );

        SoruModel kat2Soru5 = new SoruModel(
                context.getResources().getString(R.string.ktg2Soru5),
                context.getResources().getString(R.string.ktg2Soru5Cevap1),
                context.getResources().getString(R.string.ktg2Soru5Cevap2),
                context.getResources().getString(R.string.ktg2Soru5Cevap3),
                3
        );

        SoruModel kat2Soru6 = new SoruModel(
                context.getResources().getString(R.string.ktg2Soru6),
                context.getResources().getString(R.string.ktg2Soru6Cevap1),
                context.getResources().getString(R.string.ktg2Soru6Cevap2),
                context.getResources().getString(R.string.ktg2Soru6Cevap3),
                1
        );

        SoruModel kat2Soru7 = new SoruModel(
                context.getResources().getString(R.string.ktg2Soru7),
                context.getResources().getString(R.string.ktg2Soru7Cevap1),
                context.getResources().getString(R.string.ktg2Soru7Cevap2),
                context.getResources().getString(R.string.ktg2Soru7Cevap3),
                1
        );

        SoruModel kat2Soru8 = new SoruModel(
                context.getResources().getString(R.string.ktg2Soru8),
                context.getResources().getString(R.string.ktg2Soru8Cevap1),
                context.getResources().getString(R.string.ktg2Soru8Cevap2),
                context.getResources().getString(R.string.ktg2Soru8Cevap3),
                3
        );

        SoruModel kat2Soru9 = new SoruModel(
                context.getResources().getString(R.string.ktg2Soru9),
                context.getResources().getString(R.string.ktg2Soru9Cevap1),
                context.getResources().getString(R.string.ktg2Soru9Cevap2),
                context.getResources().getString(R.string.ktg2Soru9Cevap3),
                2
        );

        SoruModel kat2Soru10 = new SoruModel(
                context.getResources().getString(R.string.ktg2Soru10),
                context.getResources().getString(R.string.ktg2Soru10Cevap1),
                context.getResources().getString(R.string.ktg2Soru10Cevap2),
                context.getResources().getString(R.string.ktg2Soru10Cevap3),
                1
        );


        sorularKat1.add(kat1Soru1);
        sorularKat1.add(kat1Soru2);
        sorularKat1.add(kat1Soru3);
        sorularKat1.add(kat1Soru4);
        sorularKat1.add(kat1Soru5);
        sorularKat1.add(kat1Soru6);
        sorularKat1.add(kat1Soru7);
        sorularKat1.add(kat1Soru8);
        sorularKat1.add(kat1Soru9);
        sorularKat1.add(kat1Soru10);

        sorularKat2.add(kat2Soru1);
        sorularKat2.add(kat2Soru2);
        sorularKat2.add(kat2Soru3);
        sorularKat2.add(kat2Soru4);
        sorularKat2.add(kat2Soru5);
        sorularKat2.add(kat2Soru6);
        sorularKat2.add(kat2Soru7);
        sorularKat2.add(kat2Soru8);
        sorularKat2.add(kat2Soru9);
        sorularKat2.add(kat2Soru10);

        if(PrefUtil.getIntPref(context,Constants.PREF_KATEGORİ_ID)==Constants.KATEGORI1_ID){
            sorular = sorularKat1;
        }else {
            sorular = sorularKat2;
        }

    }


    public static void listeTemizle(){
        sorular.clear();
        SORU_INDEX = -1;
    }


    public static SoruModel siradakiSoruyuGetir(){
        SORU_INDEX++;
        return sorular.get(SORU_INDEX);
    }

    public static int soruSayisiGetir(){
        return sorular.size();
    }

    public static Boolean cevapDogruMu(int cevap){

        if(sorular.get(SORU_INDEX).getDogruCevap() == cevap){
            return true;
        }else{
            return false;
        }
    }
}
