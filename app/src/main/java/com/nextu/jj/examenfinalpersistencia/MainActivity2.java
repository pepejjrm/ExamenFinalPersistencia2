package com.nextu.jj.examenfinalpersistencia;

import android.content.Intent;
import android.net.Uri;
import android.support.customtabs.CustomTabsIntent;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.nextu.jj.examenfinalpersistencia.archivos.GestionArchivoSesion;
import com.nextu.jj.examenfinalpersistencia.bean.Usuario;

public class MainActivity2 extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    TabLayout tabLayout;
    Toolbar toolbar;
    CambiaPropiedades cambiaPropiedades = new CambiaPropiedades();

    int colorPrimary ;
    int colorPrimaryDark;
    int idItem;

    String titulo = "Inicio";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_2);

        getWindow().setNavigationBarColor((getResources().getColor(R.color.colorPrimary)));

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, new Inicio())
                .commit();

        actualizaDatosHeader();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        if (navigationView != null)
            navigationView.setNavigationItemSelectedListener(this);
    }

    public void onClickAgregar(View view) {

        DialogoAgregarMarcador dialog = new DialogoAgregarMarcador();
        dialog.show(getSupportFragmentManager(), DialogoAgregarMarcador.TAG);

    }


   public void actualizaDatosHeader(){

        GestionArchivoSesion gestionArchivoSesion = new GestionArchivoSesion();
        Usuario usuario = new Usuario();

        usuario = gestionArchivoSesion.cargarArchivo(this);

           NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
           navigationView.setNavigationItemSelectedListener(this);
           View header=navigationView.getHeaderView(0);

           TextView nombreText = (TextView)header.findViewById(R.id.text_nombre);
           TextView mailText = (TextView)header.findViewById(R.id.text_email);

           String nombreUsuario = usuario.getNombre();
           String mailUsuario = usuario.getMail();

           nombreText.setText(nombreUsuario);
           mailText.setText(mailUsuario);


       Toast.makeText(this, "Sesión iniciada con " + nombreUsuario, Toast.LENGTH_SHORT).show();
    }

    public void onClickLogin(View v){  //}
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, new Inicio())
                .commit();
    }

    public void updateView(String title) {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null){
            toolbar.setTitle(title);
        }

        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toogle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.nav_drawer_open, R.string.nav_drawer_close);
        drawerLayout.addDrawerListener(toogle);

        //Cambio de color toolbar
        toolbar.setSubtitle(titulo);
        toolbar.setBackgroundColor(colorPrimary);
        //Cambio de imagen toolbar

        tabLayout = (TabLayout) findViewById(R.id.tab_layout);

        cambiaPropiedades.cambiaImagen(idItem, tabLayout, this);

        toogle.syncState();

        if (tabLayout != null) {
            //Cambio de color tabLayout
            tabLayout.setBackgroundColor(colorPrimary);
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        idItem = item.getItemId();

        Fragment fragment = null;
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        switch (idItem) {
            case R.id.nav_home:
                colorPrimary = ContextCompat.getColor(this, R.color.colorPrimary);
                colorPrimaryDark = ContextCompat.getColor(this, R.color.colorPrimaryDark);
                titulo = getString(R.string.incio);
                fragment = new Inicio();
                break;

            case R.id.nav_equipos:
                titulo = getString(R.string.seccion2);
                colorPrimary = ContextCompat.getColor(this, R.color.colorPrimaryFacebook);
                colorPrimaryDark = ContextCompat.getColor(this, R.color.colorPrimaryDarkFacebook);
                fragment = new RedesSociales();
                break;

            case R.id.nav_estadisicas:
                titulo = getString(R.string.seccion3);
                colorPrimary = ContextCompat.getColor(this, R.color.colorPrimaryInstagram);
                colorPrimaryDark = ContextCompat.getColor(this, R.color.colorPrimaryDarkInstagram);
                fragment = new RedesSociales();
                break;
            case R.id.nav_resultados:
                titulo = getString(R.string.seccion4);
                colorPrimary = ContextCompat.getColor(this, R.color.colorPrimaryGooglePlus);
                colorPrimaryDark = ContextCompat.getColor(this, R.color.colorPrimaryDarkGooglePlus);
                fragment = new RedesSociales();
                break;
            case R.id.nav_roles:
                titulo = getString(R.string.seccion5);
                colorPrimary = ContextCompat.getColor(this, R.color.colorPrimaryTwiter);
                colorPrimaryDark = ContextCompat.getColor(this, R.color.colorPrimaryDarkTwiter);
                fragment = new RedesSociales();
                break;
            default:
                colorPrimary = ContextCompat.getColor(this, R.color.colorAccent);
        }

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, fragment)
                .commit();

        drawerLayout.closeDrawer(GravityCompat.START);

        navigationView = (NavigationView) findViewById(R.id.nav_view);

        if (navigationView != null)
        {
            cambiaPropiedades.color(colorPrimary, colorPrimaryDark, this);
        }

        return true;
    }

    @Override
    public void onBackPressed() {

    }

    public boolean onCreateOptionsMenu(Menu menu) {

        SubMenu version_web = menu.addSubMenu(0,1,1,R.string.version_web);
        SubMenu compartir = menu.addSubMenu(1,2,2,R.string.compartir);
        SubMenu configuracion = menu.addSubMenu(2,3,3,R.string.configuracion);

        version_web.add(0,4,1,R.string.seccion2).setIcon(R.drawable.teams);
        version_web.add(0,5,2,R.string.seccion3).setIcon(R.drawable.statics);
        version_web.add(0,6,3,R.string.seccion4).setIcon(R.drawable.scores);
        version_web.add(0,7,4,R.string.seccion5).setIcon(R.drawable.schedule);
        version_web.add(0,8,5,R.string.seccion6).setIcon(R.drawable.information);
        version_web.add(0,9,6,R.string.seccion7).setIcon(R.drawable.user);

        getMenuInflater().inflate(R.menu.menu_main, menu);

        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        onClickNavegar(id);

        return super.onOptionsItemSelected(item);
    }

    public void onClickNavegar(int idSubmenu){
        String url = "";

        switch(idSubmenu){
            case 2:
                AlertDialog dialogo = Dialogo.listaCheck(this);
                dialogo.show();
                break;
            case 3:
                Intent intent = new Intent(MainActivity2.this, ConfiguracionActivity.class);
                startActivity(intent);
                break;
            case 4:
                url = getString(R.string.url_facebook);
                colorPrimary = ContextCompat.getColor(this, R.color.colorPrimaryFacebook);
                colorPrimaryDark = ContextCompat.getColor(this, R.color.colorPrimaryDarkFacebook);
                break;
            case 5:
                url = getString(R.string.url_instagram);
                colorPrimary = ContextCompat.getColor(this, R.color.colorPrimaryInstagram);
                colorPrimaryDark = ContextCompat.getColor(this, R.color.colorPrimaryDarkInstagram);
                break;
            case 6:
                url = getString(R.string.url_google_plus);
                colorPrimary = ContextCompat.getColor(this, R.color.colorPrimaryGooglePlus);
                colorPrimaryDark = ContextCompat.getColor(this, R.color.colorPrimaryDarkGooglePlus);
                break;
            case 7:
                url = getString(R.string.url_twiter);
                colorPrimary = ContextCompat.getColor(this, R.color.colorPrimaryTwiter);
                colorPrimaryDark = ContextCompat.getColor(this, R.color.colorPrimaryDarkTwiter);
                break;
        }

        if(idSubmenu>3){
            CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
            builder.setToolbarColor(colorPrimary);
            builder.setStartAnimations(this, android.R.anim.slide_in_left, android.R.anim.slide_out_right);
            builder.setExitAnimations(this, android.R.anim.slide_in_left, android.R.anim.slide_out_right);
            CustomTabsIntent customTabsIntent = builder.build();
            customTabsIntent.launchUrl(this, Uri.parse(url));
        }
    }

}
