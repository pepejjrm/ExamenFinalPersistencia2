package com.nextu.jj.examenfinalpersistencia;

import android.content.Intent;
import android.net.Uri;
import android.support.customtabs.CustomTabsIntent;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextInputLayout editUsername;
    TextInputLayout editPassword;

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
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            startActivity(intent);
        }

    }
}
