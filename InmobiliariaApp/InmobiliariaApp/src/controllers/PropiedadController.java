package controllers;

import models.Propiedad;
import utils.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PropiedadController {
    private Connection connection;

    public PropiedadController() {
        try {
            connection = DatabaseConnection.getConnection(); // Obtener conexión a la base de datos
        } catch (SQLException e) {
            System.err.println("Error al conectar a la base de datos: " + e.getMessage());
        }
    }

    // Crear una nueva propiedad en la base de datos
    public void addPropiedad(Propiedad propiedad) {
        String query = "INSERT INTO propiedad (snr, direccion, telefono, barrio, zona, precio_alquiler, descripcion, disponible) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, propiedad.getSnr());
            statement.setString(2, propiedad.getDireccion());
            statement.setString(3, propiedad.getTelefono());
            statement.setString(4, propiedad.getBarrio());
            statement.setString(5, propiedad.getZona());
            statement.setDouble(6, propiedad.getPrecioAlquiler());
            statement.setString(7, propiedad.getDescripcion());
            statement.setBoolean(8, propiedad.isDisponible());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Propiedad creada en la base de datos.");
            }
        } catch (SQLException e) {
            System.err.println("Error al crear la propiedad en la base de datos: " + e.getMessage());
        }
    }

    // Leer todas las propiedades desde la base de datos
    public List<Propiedad> getAllPropiedades() {
        List<Propiedad> propiedades = new ArrayList<>();
        String query = "SELECT * FROM propiedad";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                Propiedad propiedad = new Propiedad(
                        resultSet.getString("snr"),
                        resultSet.getString("direccion"),
                        resultSet.getString("telefono"),
                        resultSet.getString("barrio"),
                        resultSet.getString("zona"),
                        resultSet.getDouble("precio_alquiler"),
                        resultSet.getString("descripcion"),
                        resultSet.getBoolean("disponible")
                );
                propiedades.add(propiedad);
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener las propiedades desde la base de datos: " + e.getMessage());
        }
        return propiedades;
    }

    // Leer una propiedad por SNR desde la base de datos
    public Propiedad getPropiedadBySnr(String snr) {
        String query = "SELECT * FROM propiedad WHERE snr = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, snr);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Propiedad(
                        resultSet.getString("snr"),
                        resultSet.getString("direccion"),
                        resultSet.getString("telefono"),
                        resultSet.getString("barrio"),
                        resultSet.getString("zona"),
                        resultSet.getDouble("precio_alquiler"),
                        resultSet.getString("descripcion"),
                        resultSet.getBoolean("disponible")
                );
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener la propiedad desde la base de datos: " + e.getMessage());
        }
        return null;
    }

    // Actualizar una propiedad en la base de datos
    public boolean updatePropiedad(String snr, Propiedad updatedPropiedad) {
        String query = "UPDATE propiedad SET direccion = ?, telefono = ?, barrio = ?, zona = ?, precio_alquiler = ?, descripcion = ?, disponible = ? " +
                "WHERE snr = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, updatedPropiedad.getDireccion());
            statement.setString(2, updatedPropiedad.getTelefono());
            statement.setString(3, updatedPropiedad.getBarrio());
            statement.setString(4, updatedPropiedad.getZona());
            statement.setDouble(5, updatedPropiedad.getPrecioAlquiler());
            statement.setString(6, updatedPropiedad.getDescripcion());
            statement.setBoolean(7, updatedPropiedad.isDisponible());
            statement.setString(8, snr);

            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            System.err.println("Error al actualizar la propiedad en la base de datos: " + e.getMessage());
            return false;
        }
    }

    // Eliminar una propiedad de la base de datos por SNR
    public boolean deletePropiedad(String snr) {
        String query = "DELETE FROM propiedad WHERE snr = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, snr);
            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            System.err.println("Error al eliminar la propiedad en la base de datos: " + e.getMessage());
            return false;
        }
    }

    // Método para cerrar la conexión a la base de datos
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
