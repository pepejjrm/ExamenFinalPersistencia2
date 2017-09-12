package com.nextu.jj.examenfinalpersistencia;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nextu.jj.examenfinalpersistencia.bean.Usuario;

/**
 * Created by JJ on 9/6/2017.
 */

public class Login extends Fragment {

    GestionArchivo gestionArchivo = new GestionArchivo();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_login, container, false);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if(gestionArchivo.validaArchivo(getActivity())){

            Usuario usuario =  recuperaDatos();

            if(usuario.getRecordar()){
                Intent intent = new Intent(getActivity(), MainActivity2.class);
                intent.putExtra("nombreUsuario",usuario.getNombre());
                intent.putExtra("mailUsuario",usuario.getMail());
                startActivity(intent);
            }
        }
    }


    private Usuario recuperaDatos(){
        Usuario usuario = gestionArchivo.cargarArchivo(getActivity());

        TextInputLayout editUsername = (TextInputLayout) getActivity().findViewById(R.id.edit_username);
        //Log.i("TesJJRM",usuario.getNombre());
        //editUsername.getEditText().setText(usuario.getNombre());
        return usuario;
    }

}
