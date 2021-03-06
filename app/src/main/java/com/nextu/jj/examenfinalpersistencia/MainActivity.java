package com.nextu.jj.examenfinalpersistencia;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import com.nextu.jj.examenfinalpersistencia.archivos.GestionArchivoSesion;
import com.nextu.jj.examenfinalpersistencia.bean.Usuario;

public class MainActivity extends AppCompatActivity {

    private TextInputLayout editUsername;
    private TextInputLayout editPassword;
    private GestionArchivoSesion gestionArchivoSesion = new GestionArchivoSesion();
    private CheckBox recordar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boolean login = false;

        getWindow().setNavigationBarColor((getResources().getColor(R.color.colorPrimary)));

        if(gestionArchivoSesion.validaArchivo(this)) {
            Usuario usuario =  recuperaDatos();
            Log.i("JJRM4",usuario.getRecordar() + "");
            if(usuario.getRecordar()){
                login = true;
                Intent intent = new Intent(this, MainActivity2.class);
                startActivity(intent);
            }
        }

        if (!login){
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container1, new Login())
                    .commit();
        }
    }

    private Usuario recuperaDatos(){
        Usuario usuario = gestionArchivoSesion.cargarArchivo(this);
        return usuario;
    }

    public void onClickLogin(View v){

        editUsername = (TextInputLayout) findViewById(R.id.edit_username);
        editPassword = (TextInputLayout) findViewById(R.id.edit_password);

        EditText editTextUsername = editUsername.getEditText();
        String username = null;
        if (editTextUsername != null && editTextUsername.getText() != null) {
            username = editTextUsername.getText().toString();
        }

        EditText editTextPassword = editPassword.getEditText();
        String password = null;
        if (editTextPassword != null && editTextPassword.getText() != null) {
            password = editTextPassword.getText().toString();
        }

        boolean login = true;
        if ("".equals(username)) {
            login = false;
            editUsername.setError(getString(R.string.text_error_username));
        }

        if ("".equals(password)) {
            login = false;
            editPassword.setError(getString(R.string.text_error_password));
        }

        if(login){

            recordar = (CheckBox) findViewById(R.id.switch_opcion1);
            Log.i("JJRM1",recordar.isChecked() + "");
            Usuario usuario = new Usuario(editTextUsername.getText().toString(),editTextPassword.getText().toString(),recordar.isChecked());
            gestionArchivoSesion.guradaArchivo(this, usuario);

            Intent intent = new Intent(this, MainActivity2.class);
            startActivity(intent);
        }
    }
}
