package com.nextu.jj.examenfinalpersistencia.adaptador;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nextu.jj.examenfinalpersistencia.R;
import com.nextu.jj.examenfinalpersistencia.bean.Marcador;

import java.util.List;

/**
 * Created by JJ on 9/21/2017.
 */

public class RecyclerMarcadorAdapter extends RecyclerView.Adapter<MarcadorViewHolder> {

    private List<Marcador> marcadores;
    private Activity activity;

    public RecyclerMarcadorAdapter(AppCompatActivity activity, List<Marcador> marcadores) {
        this.activity = activity;
        this.marcadores = marcadores;
    }

    @Override
    public MarcadorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = activity.getLayoutInflater();
        View view = inflater.inflate(R.layout.marcadores_item,parent,false);

        return new MarcadorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MarcadorViewHolder holder, int position) {
        holder.bindMarcador(marcadores.get(position));
    }

    @Override
    public int getItemCount() {
        return marcadores.size();
    }

    public Activity getActivity() {
        return activity;
    }

    public List<Marcador> getMarcadores() {
        return marcadores;
    }

    public void setMarcadores(List<Marcador> marcadores) {
        this.marcadores = marcadores;
    }
}

