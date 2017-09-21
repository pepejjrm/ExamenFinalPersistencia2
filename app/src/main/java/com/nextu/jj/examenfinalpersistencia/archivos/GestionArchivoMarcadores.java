package com.nextu.jj.examenfinalpersistencia.archivos;

import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.widget.Toast;

import com.nextu.jj.examenfinalpersistencia.bean.Marcador;
import com.nextu.jj.examenfinalpersistencia.bean.Usuario;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by JJ on 9/19/2017.
 */

public class GestionArchivoMarcadores {

    private Activity activity;
    private static final String ARCHIVO_MARCADOR = "notas.txt";

    public GestionArchivoMarcadores(Activity activity){
        this.activity = activity;
    }

    public void agregarNota(Marcador marcador) throws IOException {
        List <Marcador> marcadores = new ArrayList<Marcador>();
        marcadores = cargar();
        marcadores.add(marcador);
        guardar(marcadores);
    }

    public List<Marcador> leerMarcadores() throws IOException {
        List <Marcador> marcadores = new ArrayList<Marcador>();
        marcadores = cargar();
        return marcadores;
    }

    /*public String leerNotas(int posicion) throws IOException {
        cargar();
        String[] listaNotas = notas.split(";");
        return listaNotas[posicion];
    }*/

    private void guardar(List<Marcador> marcador) throws IOException {
        try{
            ObjectOutputStream objOutput = new ObjectOutputStream(activity.openFileOutput(ARCHIVO_MARCADOR, MODE_PRIVATE));
            objOutput.writeObject(marcador);
            objOutput.close();
            Toast.makeText(activity, "Archivo guardado correctamente", Toast.LENGTH_SHORT).show();
        }catch (IOException e){
            Log.i("IOException",e.getCause().toString());
        }
    }

    public List<Marcador> cargar(){

        List<Marcador> marcadorLista = new ArrayList<Marcador>();
        try{
            ObjectInputStream objInput = new ObjectInputStream(activity.openFileInput(ARCHIVO_MARCADOR));
            marcadorLista = (ArrayList) objInput.readObject();
            objInput.close();

        }catch (IOException e){
            Log.i("IOException",e.getCause().toString());

        }catch (ClassNotFoundException e){
            Log.i("ClassNotFoundException",e.getCause().toString());
        }
        return marcadorLista;
    }


    public void eliminar(){
        activity.deleteFile(ARCHIVO_MARCADOR);
    }
}
