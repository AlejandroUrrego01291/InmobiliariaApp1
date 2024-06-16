package controllers;

import models.ClienteArrendatario;
import utils.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteArrendatarioController {
    private List<ClienteArrendatario> clientes = new ArrayList<>();

    // Crear un nuevo cliente arrendatario
    public void addClienteArrendatario(ClienteArrendatario cliente) {
        // Agregar cliente a la lista local
        clientes.add(cliente);

        // Insertar cliente en la base de datos
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = DatabaseConnection.getConnection();
            String query = "INSERT INTO clientes_arrendatarios (nombre, telefono, direccion, profesion, lugar_trabajo, salario, barrio, zona, precio_alquiler, propiedad_alquilada) " +
                           "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            stmt = conn.prepareStatement(query);
            stmt.setString(1, cliente.getNombre());
            stmt.setString(2, cliente.getTelefono());
            stmt.setString(3, cliente.getDireccion());
            stmt.setString(4, cliente.getProfesion());
            stmt.setString(5, cliente.getLugarTrabajo());
            stmt.setInt(6, cliente.getSalario());
            stmt.setString(7, cliente.getBarrio());
            stmt.setString(8, cliente.getZona());
            stmt.setInt(9, cliente.getPrecioAlquiler());
            stmt.setString(10, cliente.getPropiedadAlquilada());

            stmt.executeUpdate();
            System.out.println("Cliente arrendatario registrado en la base de datos: " + cliente.getNombre());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Leer todos los clientes arrendatarios (si fuera necesario)
    public List<ClienteArrendatario> getAllClientesArrendatarios() {
        return clientes; // Aquí podrías hacer una consulta a la base de datos si lo prefieres
    }

    // Leer un cliente arrendatario por nombre (si fuera necesario)
    public ClienteArrendatario getClienteArrendatarioByName(String nombre) {
        for (ClienteArrendatario cliente : clientes) {
            if (cliente.getNombre().equalsIgnoreCase(nombre)) {
                return cliente;
            }
        }
        return null; // Aquí podrías hacer una consulta a la base de datos si lo prefieres
    }

    // Actualizar un cliente arrendatario (si fuera necesario)
    public boolean updateClienteArrendatario(String nombre, ClienteArrendatario updatedCliente) {
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getNombre().equalsIgnoreCase(nombre)) {
                clientes.set(i, updatedCliente);
                return true;
            }
        }
        return false; // Aquí podrías hacer una actualización en la base de datos si lo prefieres
    }

    // Eliminar un cliente arrendatario (si fuera necesario)
    public boolean deleteClienteArrendatario(String nombre) {
        return clientes.removeIf(cliente -> cliente.getNombre().equalsIgnoreCase(nombre)); // Aquí podrías hacer una eliminación en la base de datos si lo prefieres
    }
}
