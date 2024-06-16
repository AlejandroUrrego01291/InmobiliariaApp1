package controllers;

import models.ClientePropietario;
import utils.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientePropietarioController {

    public static void ClientePropietario(ClientePropietario nuevoClientePropietario) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    private Connection connection;

    public ClientePropietarioController() {
        try {
            connection = DatabaseConnection.getConnection();
        } catch (SQLException e) {
            System.err.println("Error al conectar a la base de datos: " + e.getMessage());
        }
    }

    public void addClientePropietario(ClientePropietario clientePropietario) {
        String query = "INSERT INTO clientes_propietarios (nombre, telefono, direccion) VALUES (?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, clientePropietario.getNombre());
            statement.setString(2, clientePropietario.getTelefono());
            statement.setString(3, clientePropietario.getDireccion());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Cliente propietario registrado en la base de datos.");
            }
        } catch (SQLException e) {
            System.err.println("Error al registrar el cliente propietario en la base de datos: " + e.getMessage());
        }
    }

    public List<ClientePropietario> getAllClientesPropietarios() {
        List<ClientePropietario> clientesPropietarios = new ArrayList<>();
        String query = "SELECT * FROM clientes_propietarios";

        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");
                String telefono = resultSet.getString("telefono");
                String direccion = resultSet.getString("direccion");

                ClientePropietario clientePropietario = new ClientePropietario(nombre, telefono, direccion);
                clientePropietario.setId(id); // Asignar el ID recuperado de la base de datos
                clientesPropietarios.add(clientePropietario);
            }

        } catch (SQLException e) {
            System.err.println("Error al obtener los clientes propietarios desde la base de datos: " + e.getMessage());
        }

        return clientesPropietarios;
    }

    public void updateClientePropietario(ClientePropietario clientePropietario) {
        String query = "UPDATE clientes_propietarios SET nombre=?, telefono=?, direccion=? WHERE id=?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, clientePropietario.getNombre());
            statement.setString(2, clientePropietario.getTelefono());
            statement.setString(3, clientePropietario.getDireccion());
            statement.setInt(4, clientePropietario.getId());

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Cliente propietario actualizado en la base de datos.");
            }
        } catch (SQLException e) {
            System.err.println("Error al actualizar el cliente propietario en la base de datos: " + e.getMessage());
        }
    }

    public void deleteClientePropietario(int id) {
        String query = "DELETE FROM clientes_propietarios WHERE id=?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Cliente propietario eliminado de la base de datos.");
            }
        } catch (SQLException e) {
            System.err.println("Error al eliminar el cliente propietario de la base de datos: " + e.getMessage());
        }
    }

    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexión a la base de datos: " + e.getMessage());
            }
        }
    }
}

