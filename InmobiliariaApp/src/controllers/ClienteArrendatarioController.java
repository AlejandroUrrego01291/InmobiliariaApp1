package controllers;

import models.ClienteArrendatario;

import java.util.ArrayList;
import java.util.List;

public class ClienteArrendatarioController {
    private List<ClienteArrendatario> clientes = new ArrayList<>();

    // Crear un nuevo cliente arrendatario
    public void addClienteArrendatario(ClienteArrendatario cliente) {
        clientes.add(cliente);
    }

    // Leer todos los clientes arrendatarios
    public List<ClienteArrendatario> getAllClientesArrendatarios() {
        return clientes;
    }

    // Leer un cliente arrendatario por nombre
    public ClienteArrendatario getClienteArrendatarioByName(String nombre) {
        for (ClienteArrendatario cliente : clientes) {
            if (cliente.getNombre().equalsIgnoreCase(nombre)) {
                return cliente;
            }
        }
        return null;
    }

    // Actualizar un cliente arrendatario
    public boolean updateClienteArrendatario(String nombre, ClienteArrendatario updatedCliente) {
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getNombre().equalsIgnoreCase(nombre)) {
                clientes.set(i, updatedCliente);
                return true;
            }
        }
        return false;
    }

    // Eliminar un cliente arrendatario
    public boolean deleteClienteArrendatario(String nombre) {
        return clientes.removeIf(cliente -> cliente.getNombre().equalsIgnoreCase(nombre));
    }
}

