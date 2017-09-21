package com.nextu.jj.examenfinalpersistencia.adaptador;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.app.AppCompatActivity;

import com.nextu.jj.examenfinalpersistencia.BasicFragment;

public class BaseViewPagerAdapter extends FragmentStatePagerAdapter {

    private TypedArray img;
    private String[] titulo;
    private AppCompatActivity activity;

    public BaseViewPagerAdapter(FragmentManager manager, Context context, int redSocial, int texto, AppCompatActivity activity ) {
        super(manager);
        this.img = context.getResources().obtainTypedArray(redSocial);
        this.titulo = context.getResources().getStringArray(texto);
        this.activity = activity;
    }

    @Override
    public Fragment getItem(int position) {
    return BasicFragment.getInstance(this.img.getResourceId(position, 0), titulo[position]);
    }

    @Override
    public int getCount() {
       return this.img.length();
    }

}
