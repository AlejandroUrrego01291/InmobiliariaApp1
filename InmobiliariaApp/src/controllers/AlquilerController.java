package controllers;

import models.ClienteArrendatario;
import models.ClientePropietario;
import models.Propiedad;
import models.Alquiler;

import java.util.ArrayList;
import java.util.List;

public class AlquilerController {
    private List<Alquiler> alquileres;

    public AlquilerController() {
        alquileres = new ArrayList<>();
    }

    public void addAlquiler(Alquiler alquiler) {
        alquileres.add(alquiler);
    }

    public void registrarAlquiler(ClienteArrendatario arrendatario, ClientePropietario propietario, Propiedad propiedad) {
        // Lógica para registrar el alquiler
        // Esto puede incluir asociar la propiedad con el arrendatario, actualizar la disponibilidad de la propiedad, etc.
        if (propiedad.isDisponible()) {
            propiedad.setDisponible(false);
            arrendatario.setPropiedadAlquilada(propiedad.getDireccion());
            System.out.println("Alquiler registrado: " + arrendatario.getNombre() + " ha alquilado " + propiedad.getDireccion() + " de " + propietario.getNombre());
        } else {
            System.out.println("La propiedad no está disponible para alquiler.");
        }
    }
}
