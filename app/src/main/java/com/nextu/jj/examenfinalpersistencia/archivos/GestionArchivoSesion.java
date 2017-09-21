package com.nextu.jj.examenfinalpersistencia.archivos;

import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.nextu.jj.examenfinalpersistencia.bean.Usuario;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by JJ on 9/10/2017.
 */

public class GestionArchivoSesion {


    private String archivo = "usuario2.obj";


    public boolean validaArchivo(FragmentActivity activity){

        boolean correcto = false;

        try{
            if ((activity.openFileInput(archivo)) != null){
                correcto = true;
            }
        }catch (IOException e){
            Toast.makeText(activity, "No existe un archivo aún", Toast.LENGTH_SHORT).show();
            correcto = false;
        }finally {
            return correcto;
        }

    }

    public Usuario cargarArchivo(FragmentActivity activity){
        Usuario usuario = new Usuario();
        try{
            ObjectInputStream objInput = new ObjectInputStream(activity.openFileInput(archivo));
            usuario = (Usuario) objInput.readObject();
            objInput.close();

        }catch (IOException e){
            Log.i("IOException",e.getCause().toString());

        }catch (ClassNotFoundException e){
            Log.i("ClassNotFoundException",e.getCause().toString());
        }
        return usuario;
    }

    public void guradaArchivo(AppCompatActivity activity, Usuario usuario){
        try{
            ObjectOutputStream objOutput = new ObjectOutputStream(activity.openFileOutput(archivo, MODE_PRIVATE));
            objOutput.writeObject(usuario);
            objOutput.close();
            Toast.makeText(activity, "Archivo guardado correctamente", Toast.LENGTH_SHORT).show();
        }catch (IOException e){
            Log.i("IOException",e.getCause().toString());
        }
    }

}
