package models;

import java.time.LocalDate;

public class Alquiler {
    private ClienteArrendatario clienteArrendatario;
    private ClientePropietario clientePropietario; // Propietario de la propiedad alquilada
    private Propiedad propiedad; // Propiedad que se alquila
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private double montoAlquiler;

    public Alquiler(ClienteArrendatario clienteArrendatario, Propiedad propiedad, LocalDate fechaInicio1, LocalDate fechaFin1, double montoAlquiler1) {
        this.clienteArrendatario = clienteArrendatario;
        this.clientePropietario = clientePropietario;
        this.propiedad = propiedad;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.montoAlquiler = montoAlquiler;
    }

    public ClienteArrendatario getClienteArrendatario() {
        return clienteArrendatario;
    }

    public void setClienteArrendatario(ClienteArrendatario clienteArrendatario) {
        this.clienteArrendatario = clienteArrendatario;
    }

    public ClientePropietario getClientePropietario() {
        return clientePropietario;
    }

    public void setClientePropietario(ClientePropietario clientePropietario) {
        this.clientePropietario = clientePropietario;
    }

    public Propiedad getPropiedad() {
        return propiedad;
    }

    public void setPropiedad(Propiedad propiedad) {
        this.propiedad = propiedad;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public double getMontoAlquiler() {
        return montoAlquiler;
    }

    public void setMontoAlquiler(double montoAlquiler) {
        this.montoAlquiler = montoAlquiler;
    }
}
