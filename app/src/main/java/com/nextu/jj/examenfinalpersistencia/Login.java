package com.nextu.jj.examenfinalpersistencia;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nextu.jj.examenfinalpersistencia.archivos.GestionArchivoSesion;

/**
 * Created by JJ on 9/6/2017.
 */

public class Login extends Fragment {

    GestionArchivoSesion gestionArchivoSesion = new GestionArchivoSesion();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_login, container, false);

        return view;
    }

}
