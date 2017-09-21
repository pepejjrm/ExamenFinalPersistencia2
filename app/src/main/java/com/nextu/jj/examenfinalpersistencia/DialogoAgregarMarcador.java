package com.nextu.jj.examenfinalpersistencia;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;


public class DialogoAgregarMarcador extends DialogFragment {

    public static final String TAG = "d_agregar_marcador";

    interface OnAgregarMarcadorListener{
        void onAgregarMarcador(String marcador);
    }

    private OnAgregarMarcadorListener listener;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

        final View view = getActivity().getLayoutInflater().inflate(R.layout.dialogo_agregar, null);
        builder.setView(view);

        //final EditText editLocal = (EditText) view.findViewById(R.id.edit_local);
        //final EditText editVisitante = (EditText) view.findViewById(R.id.edit_visitante);
        final Spinner editLocal = (Spinner) view.findViewById(R.id.edit_local);
        final Spinner editVisitante = (Spinner) view.findViewById(R.id.edit_visitante);
        final EditText editMarcador1 = (EditText) view.findViewById(R.id.edit_marcador1);
        final EditText editMarcador2 = (EditText) view.findViewById(R.id.edit_marcador2);

        Button btnAgregar = (Button) view.findViewById(R.id.btn_agregar);
        Button btnCancelar = (Button) view.findViewById(R.id.btn_cancelar);

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String local = editLocal.getX()x;
                //String visitante = editVisitante.getText().toString();
                String marcador1 = editMarcador1.getText().toString();
                String marcador2 = editMarcador2.getText().toString();
               /* if (!local.equals("") && !visitante.equals("") && !marcador1.equals("")
                        && !marcador2.equals("")){
                    listener.onAgregarMarcador("\n\n" + local + " VS " + visitante +
                        "\nResultado: " + marcador1 + " - " + marcador2);
                }*/
                dismiss();
            }
        });

        incializaEquipos(view);

    return builder.create();

    }

    private void incializaEquipos(View view){
        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("Alemania");
        categories.add("Manchester");
        categories.add("Juventus");
        categories.add("Gremio");
        categories.add("SR");
        categories.add("Portugal");
        categories.add("Atletico Llano");
        categories.add("Atlas");
        categories.add("Carroñeros");
        categories.add("BVB");
        categories.add("Villas");
        categories.add("Nigeria");
        categories.add("Toluca");
        categories.add("KND");
        categories.add("Chelsea");

        // Spinner element
        Spinner spinnerLocal = (Spinner) view.findViewById(R.id.edit_local);
        Spinner spinnerVisitante = (Spinner) view.findViewById(R.id.edit_visitante);

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinnerLocal.setAdapter(dataAdapter);
        spinnerVisitante.setAdapter(dataAdapter);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try{
            listener = (OnAgregarMarcadorListener) getActivity();
        }catch (ClassCastException e){
            Log.e(TAG,"La activity no implementa la interfaz "+ e);
        }
    }
}
