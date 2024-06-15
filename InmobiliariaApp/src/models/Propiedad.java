package models;

import java.util.ArrayList;
import java.util.List;

public class Propiedad {
    private String snr; // Número de Matrícula
    private String direccion;
    private String telefono;
    private String barrio;
    private String zona;
    private double precioAlquiler;
    private String descripcion;
    private boolean disponible;
    private List<Alquiler> alquileres;


    public Propiedad(String snr, String direccion, String telefono, String barrio, String zona, double precioAlquiler, String descripcion, boolean disponible) {
        this.snr = snr;
        this.direccion = direccion;
        this.telefono = telefono;
        this.barrio = barrio;
        this.zona = zona;
        this.precioAlquiler = precioAlquiler;
        this.descripcion = descripcion;
        this.disponible = disponible;
    }

    // Getters y Setters
    public String getSnr() {
        return snr;
    }

    public void setSnr(String snr) {
        this.snr = snr;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public double getPrecioAlquiler() {
        return precioAlquiler;
    }

    public void setPrecioAlquiler(double precioAlquiler) {
        this.precioAlquiler = precioAlquiler;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        return  "Snr: " + snr  +
                ", Direccion: " + direccion + 
                ", Barrio: " + barrio + 
                ", Zona: " + zona ;
    }
     public void addAlquiler(Alquiler alquiler) {
        if (alquileres == null) {
            alquileres = new ArrayList<>();
        }
        alquileres.add(alquiler);
    }
}
