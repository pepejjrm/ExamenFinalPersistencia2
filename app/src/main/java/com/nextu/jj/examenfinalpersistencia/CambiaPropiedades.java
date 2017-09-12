package com.nextu.jj.examenfinalpersistencia;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

import com.nextu.jj.examenfinalpersistencia.R;
import com.nextu.jj.examenfinalpersistencia.adaptador.BaseViewPagerAdapter;

/**
 * Created by JJ on 8/18/2017.
 */

public class CambiaPropiedades {

    public void color(int colorPrimary, int colorPrimaryDark, AppCompatActivity activity){

        LinearLayout linearLayout = (LinearLayout) activity.findViewById(R.id.nav_header_container);
        linearLayout.setBackgroundColor(colorPrimary);

        Drawable bgColor = new ColorDrawable(colorPrimary);

        if(activity.getSupportActionBar() != null){
            activity.getSupportActionBar().setBackgroundDrawable(bgColor);
        }

        if (Build.VERSION.SDK_INT >= 21){
            activity.getWindow().setStatusBarColor(colorPrimaryDark);
        }
    }

    public void cambiaImagen(int redSocial, TabLayout tabLayout, AppCompatActivity activity){

        int tab1 = 0;
        int tab2 = 0;
        int tab3 = 0;
        int imagen = 0;
        int titulo = 0;

        tabLayout = (TabLayout) activity.findViewById(R.id.tab_layout);

        switch(redSocial){
            case R.id.nav_equipos:
                tab1 = R.drawable.noticias;
                tab2 = R.drawable.group;
                tab3 = R.drawable.earth;
                imagen = R.array.facebook;
                titulo = R.array.facebook_titulo;
                break;
            case R.id.nav_estadisicas:
                tab1 = R.drawable.search;
                tab2 = R.drawable.camara;
                tab3 = R.drawable.like;
                imagen = R.array.instagram;
                titulo = R.array.instagram_titulo;
                break;
            case R.id.nav_resultados:
                tab1 = R.drawable.grid;
                tab2 = R.drawable.grupo_g;
                tab3 = R.drawable.campana;
                imagen = R.array.google_plus;
                titulo = R.array.google_plus_titulo;
                break;
            case R.id.nav_roles:
                tab1 = R.drawable.campana;
                tab2 = R.drawable.mensaje;
                tab3 = R.drawable.search;
                imagen = R.array.twiter;
                titulo = R.array.twiter_titulo;
                break;
        }

        if (activity.getSupportActionBar() != null)
            activity.getSupportActionBar().setElevation(0);

        ViewPager viewPager = (ViewPager) activity.findViewById(R.id.view_pager);
        if (viewPager != null)
            viewPager.setAdapter(new BaseViewPagerAdapter(activity.getSupportFragmentManager(), activity.getApplicationContext(), imagen, titulo));

        if (tabLayout != null) {
            tabLayout.setupWithViewPager(viewPager);
            for (int i = 0; i < tabLayout.getTabCount(); i++) {
                TabLayout.Tab tab = tabLayout.getTabAt(i);
                Drawable icon = null;
                switch (i) {
                    case 0:
                        icon = ContextCompat.getDrawable(activity, tab1);
                        break;
                    case 1:
                        icon = ContextCompat.getDrawable(activity, tab2);
                        break;
                    case 2:
                        icon = ContextCompat.getDrawable(activity, tab3);
                        break;
                }
                DrawableCompat.setTint(icon, ContextCompat.getColor(activity, android.R.color.white));
                if (tab != null)
                    tab.setIcon(icon);
            }
        }
    }
}
