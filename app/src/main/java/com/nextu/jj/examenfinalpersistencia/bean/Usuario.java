package com.nextu.jj.examenfinalpersistencia.bean;

/**
 * Created by JJ on 9/7/2017.
 */

public class Usuario {

    private String nombre;
    private String pwd;
    private String recordar;
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

    public String getRecordar() {
        return recordar;
    }

    public void setRecordar(String recordar) {
        this.recordar = recordar;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
