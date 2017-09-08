package com.nextu.jj.examenfinalpersistencia;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Toast;

import static java.security.AccessController.getContext;

/**
 * Created by JJ on 8/16/2017.
 */

public class Dialogo {

    public static AlertDialog listaCheck(Activity activity){
        final String[] items = {"Facebook","Twiter","Instagram","Google Plus","Whatsapp","Messenger","SMS"};
        final boolean[] checkedItem = {false, false, false, false, false, false, false};
        final Activity actividad = activity;

        AlertDialog.Builder builder = new AlertDialog.Builder(activity);

        builder.setMultiChoiceItems(items, checkedItem
                , new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
            }
        }
        );

        builder.setPositiveButton("Compartir", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String seleccion = "";
                for (int i=0; i<checkedItem.length; i++){
                    if (checkedItem[i])
                        seleccion += "\n"+items[i];
                }

                if(seleccion.length()== 0){
                    Toast.makeText(actividad, "No seleccionaste una aplicación", Toast.LENGTH_LONG).show();
                }else{
                    confirmacion(actividad, seleccion).show();
                }


            }
        });

        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        return builder.create();
    }

    public static Dialog confirmacion(Activity activity, final String seleccion){

        final String redesSeleccionadas = seleccion;
        final Activity actividad = activity;

        AlertDialog.Builder builder = new AlertDialog.Builder(activity, R.style.TemaDialogoLista);

        builder.setTitle(R.string.configuracion);
        builder.setMessage("Compartir esta aplicación a través de los medios seleccionados?");

        builder.setPositiveButton("Si", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                Toast.makeText(actividad.getApplicationContext(),"Compartiste esta aplicacion a través de:\n" + seleccion, Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        return builder.create();
    }
}
