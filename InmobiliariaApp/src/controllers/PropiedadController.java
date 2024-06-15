package controllers;

import models.Propiedad;

import java.util.ArrayList;
import java.util.List;

public class PropiedadController {
    private List<Propiedad> propiedades = new ArrayList<>();

    // Crear una nueva propiedad
    public void addPropiedad(Propiedad propiedad) {
        propiedades.add(propiedad);
    }

    // Leer todas las propiedades
    public List<Propiedad> getAllPropiedades() {
        return propiedades;
    }

    // Leer una propiedad por SNR
    public Propiedad getPropiedadBySnr(String snr) {
        for (Propiedad propiedad : propiedades) {
            if (propiedad.getSnr().equalsIgnoreCase(snr)) {
                return propiedad;
            }
        }
        return null;
    }

    // Actualizar una propiedad
    public boolean updatePropiedad(String snr, Propiedad updatedPropiedad) {
        for (int i = 0; i < propiedades.size(); i++) {
            if (propiedades.get(i).getSnr().equalsIgnoreCase(snr)) {
                propiedades.set(i, updatedPropiedad);
                return true;
            }
        }
        return false;
    }

    // Eliminar una propiedad
    public boolean deletePropiedad(String snr) {
        return propiedades.removeIf(propiedad -> propiedad.getSnr().equalsIgnoreCase(snr));
    }
}