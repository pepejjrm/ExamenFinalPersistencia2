package com.nextu.jj.examenfinalpersistencia.adaptador;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.nextu.jj.examenfinalpersistencia.R;
import com.nextu.jj.examenfinalpersistencia.bean.Marcador;

/**
 * Created by JJ on 9/19/2017.
 */

public class MarcadorViewHolder extends RecyclerView.ViewHolder {

    private TextView txtNota;

    public MarcadorViewHolder(View itemView) {
        super(itemView);
        //txtNota = (TextView) itemView.findViewById(R.id.txt_Nota);
    }

    public void bindMarcador(Marcador marcador){
        //txtNota.setText(nota);
    }
}

