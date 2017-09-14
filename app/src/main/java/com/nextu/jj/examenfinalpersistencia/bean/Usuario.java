package com.nextu.jj.examenfinalpersistencia.bean;

import android.util.Log;

import java.io.Serializable;

/**
 * Created by JJ on 9/7/2017.
 */

public class Usuario implements Serializable {

    public Usuario(String nombre, String pwd, boolean recordar) {
        this.nombre = nombre;
        this.pwd = pwd;
        this.recordar = recordar;
        this.mail = nombre+"@correo.mail.com";
        Log.i("JJRM2",this.recordar + "");
    }

    public  Usuario(){
    }

    private String nombre;
    private String pwd;
    private boolean recordar;
    private String mail;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public boolean getRecordar() {
        return recordar;
    }

    public void setRecordar(boolean recordar) {
        this.recordar = recordar;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
