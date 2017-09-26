package com.nextu.jj.examenfinalpersistencia;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;


import com.nextu.jj.examenfinalpersistencia.adaptador.RecyclerMarcadorAdapter;
import com.nextu.jj.examenfinalpersistencia.archivos.GestionArchivoMarcadores;
import com.nextu.jj.examenfinalpersistencia.bean.Marcador;

public class BasicFragment extends Fragment {

    TextView textTab;
    ImageView imageTab;

    private int mCurrentImage;
    private String mCurrentText;

    private static final String ARG_IMAGE = "imagen";
    private static final String ARG_TEXT = "texto";
    private static AppCompatActivity ARG_ACTIVITY = new AppCompatActivity();

    private RecyclerView notasRecyclerView;
    //private EditText editMarcador;
    private RecyclerMarcadorAdapter adapter;

    private GestionArchivoMarcadores servicio;

    public static BasicFragment getInstance(int imagen, String titulo, AppCompatActivity activity ) {
        BasicFragment fragment = new BasicFragment();

        Bundle bundle = new Bundle();
        bundle.putInt(ARG_IMAGE, imagen);
        bundle.putString(ARG_TEXT, titulo);

        fragment.setArguments(bundle);

        ARG_ACTIVITY = activity;
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_basic, container, false);

        if (savedInstanceState != null){
            this.mCurrentImage = savedInstanceState.getInt(ARG_IMAGE);
            this.mCurrentText = savedInstanceState.getString(ARG_TEXT, "Titulo");
        }

        servicio = new GestionArchivoMarcadores(ARG_ACTIVITY);

        Context context = view.getContext();
        notasRecyclerView = (RecyclerView) view.findViewById(R.id.rv_notas);

        try {
            //adapter = new RecyclerMarcadorAdapter(ARG_ACTIVITY, servicio.leerMarcadores());
            adapter = new RecyclerMarcadorAdapter(ARG_ACTIVITY, servicio.leerMarcadores());
            //Arrays.asList(servicio.leerMarcadores().get(0).getEquipoLocal());
        } catch (IOException e) {
            Toast.makeText(ARG_ACTIVITY, "No existe un archivo aún", Toast.LENGTH_SHORT).show();
            adapter = new RecyclerMarcadorAdapter(ARG_ACTIVITY, new ArrayList<Marcador>());
        }

        notasRecyclerView.setHasFixedSize(true);
        notasRecyclerView.setLayoutManager(new GridLayoutManager(context, 2));
        notasRecyclerView.setAdapter(adapter);
        return view;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }

    /*@Override
    public void onStart() {
        super.onStart();

        Bundle arguments = getArguments();
        if (arguments != null)
            updateView(arguments.getInt(ARG_IMAGE), arguments.getString(ARG_TEXT, "Titulo"));
        else if (mCurrentImage != -1)
            updateView(mCurrentImage, mCurrentText);
    }*/


    private void updateView(int imagen, String titulo)
    {
        Toast.makeText(ARG_ACTIVITY, "updateView", Toast.LENGTH_SHORT).show();
        this.imageTab.setImageResource(imagen);
        this.textTab.setText(titulo);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(ARG_TEXT, mCurrentText);
        outState.putInt(ARG_IMAGE, mCurrentImage);
    }
}
