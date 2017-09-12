package com.nextu.jj.examenfinalpersistencia;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import com.nextu.jj.examenfinalpersistencia.bean.Usuario;

public class MainActivity extends AppCompatActivity {

    private TextInputLayout editUsername;
    private TextInputLayout editPassword;
    private GestionArchivo gestionArchivo = new GestionArchivo();
    private CheckBox recordar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.container1, new Login())
                .commit();

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
            Usuario usuario = new Usuario(editTextUsername.getText().toString(),editTextPassword.getText().toString(),recordar.isChecked());
            gestionArchivo.guradaArchivo(this, usuario);

            Intent intent = new Intent(this, MainActivity2.class);
            startActivity(intent);
        }
    }
}
