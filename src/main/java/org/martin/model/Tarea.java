/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.martin.model;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author mdominguez
 */
public class Tarea {
    private Integer id;
    private String nombre;
    private Date fecha;
    private Boolean completada;

    public Tarea() {
    }

    public Tarea(Integer id, String nombre, Date fecha, Boolean completada) {
        this.id = id;
        this.nombre = nombre;
        this.fecha = fecha;
        this.completada = completada;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Boolean getCompletada() {
        return completada;
    }

    public void setCompletada(Boolean completada) {
        this.completada = completada;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.id);
        hash = 67 * hash + Objects.hashCode(this.nombre);
        return hash;
    }

    @Override
    public String toString() {
        return "Tarea{" + "id=" + id + ", nombre=" + nombre + ", fecha=" + fecha + ", completada=" + completada + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Tarea other = (Tarea) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    
    
}
