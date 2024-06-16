package controllers;

import models.Alquiler;
import models.ClienteArrendatario;
import models.ClientePropietario;
import models.Propiedad;
import utils.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AlquilerController {
    private Connection connection;

    public AlquilerController() {
        try {
            connection = DatabaseConnection.getConnection();
        } catch (SQLException e) {
            System.err.println("Error al conectar a la base de datos: " + e.getMessage());
        }
    }

    public void addAlquiler(Alquiler alquiler) {
    String query = "INSERT INTO alquileres (id_arrendatario, id_propietario, id_propiedad) VALUES (?, ?, ?)";

    try (PreparedStatement statement = connection.prepareStatement(query)) {
        statement.setInt(1, alquiler.getClienteArrendatario().getId()); // Suponiendo que cada cliente tiene un ID en la base de datos
        statement.setInt(2, alquiler.getClientePropietario().getId()); // Usando getId() para obtener el ID del propietario
        statement.setInt(3, alquiler.getPropiedad().getId());

        int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("Alquiler registrado en la base de datos.");
        }
    } catch (SQLException e) {
        System.err.println("Error al registrar el alquiler en la base de datos: " + e.getMessage());
    }
}

   public List<Alquiler> getAllAlquileres() {
    List<Alquiler> alquileres = new ArrayList<>();
    String query = "SELECT * FROM alquileres";

    try (PreparedStatement statement = connection.prepareStatement(query);
         ResultSet resultSet = statement.executeQuery()) {

        while (resultSet.next()) {
            int idArrendatario = resultSet.getInt("id_arrendatario");
            int idPropietario = resultSet.getInt("id_propietario");
            int idPropiedad = resultSet.getInt("id_propiedad");

            // Obtener los objetos ClienteArrendatario, ClientePropietario y Propiedad por sus IDs
            ClienteArrendatario arrendatario = obtenerArrendatarioPorId(idArrendatario);
            ClientePropietario propietario = obtenerPropietarioPorId(idPropietario);
            Propiedad propiedad = obtenerPropiedadPorId(idPropiedad);

            if (arrendatario != null && propietario != null && propiedad != null) {
                // Asignar los valores de fechaInicio, fechaFin y montoAlquiler adecuadamente
                LocalDate fechaInicio = resultSet.getDate("fecha_inicio").toLocalDate(); // Ejemplo de cómo obtener la fecha desde ResultSet
                LocalDate fechaFin = resultSet.getDate("fecha_fin").toLocalDate();       // Ejemplo de cómo obtener la fecha desde ResultSet
                double montoAlquiler = resultSet.getDouble("monto_alquiler");             // Ejemplo de cómo obtener el monto desde ResultSet

                // Crear el objeto Alquiler con los datos obtenidos
                Alquiler alquiler = new Alquiler(arrendatario, propiedad, fechaInicio, fechaFin, montoAlquiler);
                alquileres.add(alquiler);
            }
        }

    } catch (SQLException e) {
        System.err.println("Error al obtener los alquileres desde la base de datos: " + e.getMessage());
    }

    return alquileres;
}


    private ClienteArrendatario obtenerArrendatarioPorId(int idArrendatario) {
        // Implementación para obtener el ClienteArrendatario por su ID desde la base de datos
        // Ejemplo:
        // return clienteArrendatarioDAO.getById(idArrendatario);
        return null;
    }

    private ClientePropietario obtenerPropietarioPorId(int idPropietario) {
        // Implementación para obtener el ClientePropietario por su ID desde la base de datos
        // Ejemplo:
        // return clientePropietarioDAO.getById(idPropietario);
        return null;
    }

    private Propiedad obtenerPropiedadPorId(int idPropiedad) {
        // Implementación para obtener la Propiedad por su ID desde la base de datos
        // Ejemplo:
        // return propiedadDAO.getById(idPropiedad);
        return null;
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
