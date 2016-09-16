package com.herprogramacion.crmleads;

import java.util.UUID;

/**
 * Entidad Lead
 */
public class Lead {
    private String mId;
    private String mName;
    private String mFechaIni;
    private String mDescripcion;


    public Lead(String name, String fechaIni, String descripcion) {
        mId = UUID.randomUUID().toString();
        mName = name;
        mFechaIni = fechaIni;
        mDescripcion = descripcion;
    }

    public String getId() {
        return mId;
    }

    public void setId(String mId) {
        this.mId = mId;
    }

    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public String getfechaIni() {
        return mFechaIni;
    }

    public void setfechaIni(String fechaIni) {
        this.mFechaIni = fechaIni;
    }

    public String getDescripcion() {
        return mDescripcion;
    }

    public void setDescripcion(String mDescripcion) {
        this.mDescripcion = mDescripcion;
    }


    @Override
    public String toString() {
        return "Lead{" +
                "ID='" + mId + '\'' +
                ", Nombre='" + mName + '\'' +
                ", Descripcion='" + mDescripcion + '\'' +
                ", FechaInicial='" + mFechaIni + '\'' +
                '}';
    }
}
