package views;

import controllers.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import models.ClienteArrendatario;
import models.Propiedad;
import java.time.LocalDate;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import models.Alquiler;
import models.ClientePropietario;

public class MainView extends Application {

    private final ClienteArrendatarioController clienteArrendatarioController = new ClienteArrendatarioController();
    private final PropiedadController propiedadController = new PropiedadController();
    private final AlquilerController AlquilerController = new AlquilerController();
    
    private static final String TITLE = "Inmobiliaria Interamericana";
    private static final String BTN_REG_CLIENTE_ARR = "Registrar Cliente Arrendatario";
    private static final String BTN_REG_PROPIETARIO = "Registrar Propietario";
    private static final String BTN_REG_ALQUILER = "Registrar Alquiler";
    private static final String BTN_MOD_DATOS = "Modificar Datos";
    private static final String BTN_MOSTRAR_DIRECCIONES = "Mostrar Direcciones";
    private static final String BTN_AGREGAR_PROPIEDAD = "Agregar Propiedad";
    private static final String BTN_MODIFICAR_PROPIEDAD = "Modificar Propiedad";
    private static final String BTN_ELIMINAR_PROPIEDAD = "Eliminar Propiedad";

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle(TITLE);

        Button btnClientesArrendatarios = new Button(BTN_REG_CLIENTE_ARR);
        Button btnPropietario = new Button(BTN_REG_PROPIETARIO);
        Button btnRegistrarAlquiler = new Button(BTN_REG_ALQUILER);
        Button btnModificarDatos = new Button(BTN_MOD_DATOS);
        Button btnMostrarDirecciones = new Button(BTN_MOSTRAR_DIRECCIONES);
        Button btnAgregarPropiedad = new Button(BTN_AGREGAR_PROPIEDAD);
        Button btnModificarPropiedad = new Button(BTN_MODIFICAR_PROPIEDAD);
        Button btnEliminarPropiedad = new Button(BTN_ELIMINAR_PROPIEDAD);

        btnClientesArrendatarios.setOnAction(event -> showRegistroClienteArrendatarioForm());
        btnPropietario.setOnAction(event -> showRegistroPropietarioForm());
        btnRegistrarAlquiler.setOnAction(event -> registrarAlquiler());
        btnModificarDatos.setOnAction(event -> modificarDatos());
        btnMostrarDirecciones.setOnAction(event -> mostrarDirecciones());
        btnAgregarPropiedad.setOnAction(event -> showAgregarPropiedadForm());
        btnModificarPropiedad.setOnAction(event -> showModificarPropiedadForm());
        btnEliminarPropiedad.setOnAction(event -> eliminarPropiedad());

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20));
        grid.setVgap(10);
        grid.setHgap(10);

        grid.add(btnClientesArrendatarios, 0, 0);
        grid.add(btnRegistrarAlquiler, 1, 0);
        grid.add(btnModificarDatos, 0, 1);
        grid.add(btnMostrarDirecciones, 1, 1);
        grid.add(btnAgregarPropiedad, 0, 2);
        grid.add(btnModificarPropiedad, 1, 2);
        grid.add(btnEliminarPropiedad, 0, 3);

        Scene scene = new Scene(grid, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    

     private void showRegistroClienteArrendatarioForm() {
    Stage stage = new Stage();
    stage.initModality(Modality.APPLICATION_MODAL);
    stage.setTitle("Registrar Cliente Arrendatario");

    GridPane grid = new GridPane();
    grid.setPadding(new Insets(10));
    grid.setVgap(10);
    grid.setHgap(10);

    TextField nombreField = new TextField();
    TextField telefonoField = new TextField();
    TextField direccionField = new TextField();
    TextField profesionField = new TextField();
    TextField lugarTrabajoField = new TextField();
    TextField salarioField = new TextField();
    TextField barrioField = new TextField();
    TextField zonaField = new TextField();
    TextField precioAlquilerField = new TextField();
    TextField propiedadAlquiladaField = new TextField();

    grid.add(new Label("Nombre:"), 0, 0);
    grid.add(nombreField, 1, 0);
    grid.add(new Label("Teléfono:"), 0, 1);
    grid.add(telefonoField, 1, 1);
    grid.add(new Label("Dirección:"), 0, 2);
    grid.add(direccionField, 1, 2);
    grid.add(new Label("Profesión:"), 0, 3);
    grid.add(profesionField, 1, 3);
    grid.add(new Label("Lugar de Trabajo:"), 0, 4);
    grid.add(lugarTrabajoField, 1, 4);
    grid.add(new Label("Salario:"), 0, 5);
    grid.add(salarioField, 1, 5);
    grid.add(new Label("Barrio:"), 0, 6);
    grid.add(barrioField, 1, 6);
    grid.add(new Label("Zona:"), 0, 7);
    grid.add(zonaField, 1, 7);
    grid.add(new Label("Precio Alquiler:"), 0, 8);
    grid.add(precioAlquilerField, 1, 8);
    grid.add(new Label("Propiedad Alquilada:"), 0, 9);
    grid.add(propiedadAlquiladaField, 1, 9);

    Button submitButton = new Button("Registrar");
    submitButton.setOnAction(e -> {
        try {
            // Validar y obtener los datos de los campos
            String nombre = nombreField.getText();
            String telefono = telefonoField.getText();
            String direccion = direccionField.getText();
            String profesion = profesionField.getText();
            String lugarTrabajo = lugarTrabajoField.getText();
            int salario = Integer.parseInt(salarioField.getText());
            String barrio = barrioField.getText();
            String zona = zonaField.getText();
            int precioAlquiler = Integer.parseInt(precioAlquilerField.getText());
            String propiedadAlquilada = propiedadAlquiladaField.getText();

            // Crear nuevo cliente arrendatario
            ClienteArrendatario nuevoCliente = new ClienteArrendatario(nombre, telefono, direccion, profesion,
                    lugarTrabajo, salario, barrio, zona, precioAlquiler, propiedadAlquilada);

            // Agregar el nuevo cliente arrendatario al controlador
            clienteArrendatarioController.addClienteArrendatario(nuevoCliente);

            // Cerrar la ventana de registro
            System.out.println("Cliente arrendatario registrado: " + nuevoCliente.getNombre());
            stage.close();
        } catch (NumberFormatException ex) {
            // Manejar errores de conversión de tipo (por ejemplo, si el salario o precio de alquiler no es un número válido)
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Por favor, ingrese valores numéricos válidos para salario y precio de alquiler.");
            alert.showAndWait();
        }
    });

    grid.add(submitButton, 1, 10);

    Scene scene = new Scene(grid, 400, 400);
    stage.setScene(scene);
    stage.showAndWait();
}
  
    
    private void registrarAlquiler() {
    Stage stage = new Stage();
    stage.initModality(Modality.APPLICATION_MODAL);
    stage.setTitle("Registro de Alquiler");

    GridPane grid = new GridPane();
    grid.setPadding(new Insets(10));
    grid.setVgap(10);
    grid.setHgap(10);

    // ComboBox para seleccionar la propiedad a alquilar
    ComboBox<Propiedad> propiedadComboBox = new ComboBox<>();
    propiedadComboBox.getItems().addAll(propiedadController.getAllPropiedades());

    TextField clienteField = new TextField();
    DatePicker fechaInicioPicker = new DatePicker();
    DatePicker fechaFinPicker = new DatePicker();
    TextField costoField = new TextField();

    grid.add(new Label("Seleccionar Propiedad:"), 0, 0);
    grid.add(propiedadComboBox, 1, 0);
    grid.add(new Label("Cliente:"), 0, 1);
    grid.add(clienteField, 1, 1);
    grid.add(new Label("Fecha Inicio:"), 0, 2);
    grid.add(fechaInicioPicker, 1, 2);
    grid.add(new Label("Fecha Fin:"), 0, 3);
    grid.add(fechaFinPicker, 1, 3);
    grid.add(new Label("Costo Mensual:"), 0, 4);
    grid.add(costoField, 1, 4);

    Button registrarButton = new Button("Registrar Alquiler");
    registrarButton.setOnAction(e -> {
        try {
            Propiedad propiedadSeleccionada = propiedadComboBox.getValue();
            if (propiedadSeleccionada == null) {
                mostrarAlerta(Alert.AlertType.WARNING, "Selección Requerida", "Por favor selecciona una propiedad.");
                return;
            }
            
            String clienteArrendatario = clienteField.getText();
            LocalDate fechaInicio = fechaInicioPicker.getValue();
            LocalDate fechaFin = fechaFinPicker.getValue();
            double montoAlquiler = Double.parseDouble(costoField.getText());
            
            // Validación de campos requeridos
            if (clienteArrendatario.isEmpty() || fechaInicio == null || fechaFin == null) {
                mostrarAlerta(Alert.AlertType.WARNING, "Campos Requeridos", "Por favor completa todos los campos obligatorios.");
                return;
            }
            
            // Crear un nuevo registro de alquiler
            ClienteArrendatario cliente = new ClienteArrendatario(clienteArrendatario);
            Alquiler nuevoAlquiler = new Alquiler(cliente, propiedadSeleccionada, fechaInicio, fechaFin, montoAlquiler);
            propiedadSeleccionada.addAlquiler(nuevoAlquiler);
            
            mostrarAlerta(Alert.AlertType.INFORMATION, "Alquiler Registrado", "Alquiler registrado correctamente.");
            stage.close();
        } catch (NumberFormatException ex) {
            mostrarAlerta(Alert.AlertType.ERROR, "Error de Entrada", "Por favor ingresa un costo mensual válido.");
        }
    });

    grid.add(registrarButton, 1, 5);

    Scene scene = new Scene(grid, 400, 300);
    stage.setScene(scene);
    stage.showAndWait();
}




    private void modificarDatos() {
        // Implementación de la funcionalidad de modificar datos
    }

    private void mostrarDirecciones() {
        // Implementación de la funcionalidad de mostrar direcciones
    }

    private void showAgregarPropiedadForm() {
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Agregar Propiedad");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setVgap(10);
        grid.setHgap(10);

        TextField snrField = new TextField();
        TextField direccionField = new TextField();
        TextField telefonoField = new TextField();
        TextField barrioField = new TextField();
        TextField zonaField = new TextField();
        TextField precioAlquilerField = new TextField();
        TextField descripcionField = new TextField();
        CheckBox disponibilidadBox = new CheckBox("Disponible");

        grid.add(new Label("Número de Matrícula (SNR):"), 0, 0);
        grid.add(snrField, 1, 0);
        grid.add(new Label("Dirección:"), 0, 1);
        grid.add(direccionField, 1, 1);
        grid.add(new Label("Teléfono:"), 0, 2);
        grid.add(telefonoField, 1, 2);
        grid.add(new Label("Barrio:"), 0, 3);
        grid.add(barrioField, 1, 3);
        grid.add(new Label("Zona:"), 0, 4);
        grid.add(zonaField, 1, 4);
        grid.add(new Label("Precio Alquiler:"), 0, 5);
        grid.add(precioAlquilerField, 1, 5);
        grid.add(new Label("Descripción:"), 0, 6);
        grid.add(descripcionField, 1, 6);
        grid.add(disponibilidadBox, 1, 7);

        Button submitButton = new Button("Agregar");
        submitButton.setOnAction(e -> {
            Propiedad nuevaPropiedad = new Propiedad(
                    snrField.getText(),
                    direccionField.getText(),
                    telefonoField.getText(),
                    barrioField.getText(),
                    zonaField.getText(),
                    Double.parseDouble(precioAlquilerField.getText()),
                    descripcionField.getText(),
                    disponibilidadBox.isSelected()
            );
            propiedadController.addPropiedad(nuevaPropiedad);
            System.out.println("Propiedad agregada: " + nuevaPropiedad.getDireccion());
            stage.close();
        });

        grid.add(submitButton, 1, 8);

        Scene scene = new Scene(grid, 400, 400);
        stage.setScene(scene);
        stage.showAndWait();
    }

    private void showModificarPropiedadForm() {
    Stage stage = new Stage();
    stage.initModality(Modality.APPLICATION_MODAL);
    stage.setTitle("Visualizar y Modificar  Propiedad");

    GridPane grid = new GridPane();
    grid.setPadding(new Insets(10));
    grid.setVgap(10);
    grid.setHgap(10);

    // ComboBox para seleccionar la propiedad a modificar
    ComboBox<Propiedad> propiedadComboBox = new ComboBox<>();
    propiedadComboBox.getItems().addAll(propiedadController.getAllPropiedades());

    TextField snrField = new TextField();
    TextField direccionField = new TextField();
    TextField telefonoField = new TextField();
    TextField barrioField = new TextField();
    TextField zonaField = new TextField();
    TextField precioAlquilerField = new TextField();
    TextField descripcionField = new TextField();
    CheckBox disponibilidadBox = new CheckBox("Disponible");

    // Colocar los controles en el grid
    grid.add(new Label("Seleccionar Propiedad:"), 0, 0);
    grid.add(propiedadComboBox, 1, 0);
    grid.add(new Label("Número de Matrícula (SNR):"), 0, 1);
    grid.add(snrField, 1, 1);
    grid.add(new Label("Dirección:"), 0, 2);
    grid.add(direccionField, 1, 2);
    grid.add(new Label("Teléfono:"), 0, 3);
    grid.add(telefonoField, 1, 3);
    grid.add(new Label("Barrio:"), 0, 4);
    grid.add(barrioField, 1, 4);
    grid.add(new Label("Zona:"), 0, 5);
    grid.add(zonaField, 1, 5);
    grid.add(new Label("Precio Alquiler:"), 0, 6);
    grid.add(precioAlquilerField, 1, 6);
    grid.add(new Label("Descripción:"), 0, 7);
    grid.add(descripcionField, 1, 7);
    grid.add(disponibilidadBox, 1, 8);

    // Listener para cargar los datos de la propiedad seleccionada
    propiedadComboBox.setOnAction(event -> {
        Propiedad propiedadSeleccionada = propiedadComboBox.getValue();
        if (propiedadSeleccionada != null) {
            snrField.setText(propiedadSeleccionada.getSnr());
            direccionField.setText(propiedadSeleccionada.getDireccion());
            telefonoField.setText(propiedadSeleccionada.getTelefono());
            barrioField.setText(propiedadSeleccionada.getBarrio());
            zonaField.setText(propiedadSeleccionada.getZona());
            precioAlquilerField.setText(String.valueOf(propiedadSeleccionada.getPrecioAlquiler()));
            descripcionField.setText(propiedadSeleccionada.getDescripcion());
            disponibilidadBox.setSelected(propiedadSeleccionada.isDisponible());
        }
    });

    Button submitButton = new Button("Modificar");
    submitButton.setOnAction(e -> {
        Propiedad propiedadSeleccionada = propiedadComboBox.getValue();
        if (propiedadSeleccionada != null) {
            // Actualizar los datos de la propiedad seleccionada
            propiedadSeleccionada.setSnr(snrField.getText());
            propiedadSeleccionada.setDireccion(direccionField.getText());
            propiedadSeleccionada.setTelefono(telefonoField.getText());
            propiedadSeleccionada.setBarrio(barrioField.getText());
            propiedadSeleccionada.setZona(zonaField.getText());
            propiedadSeleccionada.setPrecioAlquiler(Double.parseDouble(precioAlquilerField.getText()));
            propiedadSeleccionada.setDescripcion(descripcionField.getText());
            propiedadSeleccionada.setDisponible(disponibilidadBox.isSelected());

            // Usar el método correcto del controlador para actualizar la propiedad
            propiedadController.updatePropiedad(propiedadSeleccionada.getSnr(), propiedadSeleccionada);

            System.out.println("Propiedad modificada: " + propiedadSeleccionada.getDireccion());
            stage.close();
        }
    });

    grid.add(submitButton, 1, 9);

    Scene scene = new Scene(grid, 400, 400);
    stage.setScene(scene);
    stage.showAndWait();
}


    private void eliminarPropiedad() {
    Stage stage = new Stage();
    stage.initModality(Modality.APPLICATION_MODAL);
    stage.setTitle("Eliminar Propiedad");

    GridPane grid = new GridPane();
    grid.setPadding(new Insets(10));
    grid.setVgap(10);
    grid.setHgap(10);

    // ComboBox para seleccionar la propiedad a eliminar
    ComboBox<Propiedad> propiedadComboBox = new ComboBox<>();
    propiedadComboBox.getItems().addAll(propiedadController.getAllPropiedades());

    Button eliminarButton = new Button("Eliminar Propiedad");
    eliminarButton.setOnAction(e -> {
        Propiedad selectedPropiedad = propiedadComboBox.getValue();
        if (selectedPropiedad != null) {
            propiedadController.deletePropiedad(selectedPropiedad.getSnr());
            mostrarAlerta(Alert.AlertType.INFORMATION, "Propiedad Eliminada", "Propiedad eliminada correctamente.");
            stage.close();
        } else {
            mostrarAlerta(Alert.AlertType.WARNING, "Selección Requerida", "Por favor selecciona una propiedad.");
        }
    });

    grid.add(new Label("Seleccionar Propiedad:"), 0, 0);
    grid.add(propiedadComboBox, 1, 0);
    grid.add(eliminarButton, 1, 1);

    Scene scene = new Scene(grid, 400, 200);
    stage.setScene(scene);
    stage.showAndWait();
}

private void mostrarAlerta(Alert.AlertType tipo, String titulo, String mensaje) {
    Alert alert = new Alert(tipo);
    alert.setTitle(titulo);
    alert.setHeaderText(null);
    alert.setContentText(mensaje);
    alert.showAndWait();
}


    private void showRegistroPropietarioForm() {
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Registrar Propietario");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setVgap(10);
        grid.setHgap(10);

        TextField nombreField = new TextField();
        TextField telefonoField = new TextField();
        TextField direccionField = new TextField();

        grid.add(new Label("Nombre:"), 0, 0);
        grid.add(nombreField, 1, 0);
        grid.add(new Label("Teléfono:"), 0, 1);
        grid.add(telefonoField, 1, 1);
        grid.add(new Label("Dirección:"), 0, 2);
        grid.add(direccionField, 1, 2);

        Button submitButton = new Button("Registrar");
        submitButton.setOnAction(e -> {
            try {
                // Validar y obtener los datos de los campos
                String nombre = nombreField.getText();
                String telefono = telefonoField.getText();
                String direccion = direccionField.getText();

                // Crear nuevo propietario
                ClientePropietario nuevoClientePropietario = new ClientePropietario(nombre, telefono, direccion);

                // Agregar el nuevo propietario al controlador
                ClientePropietarioController.ClientePropietario(nuevoClientePropietario);

                // Cerrar la ventana de registro
                System.out.println("Propietario registrado: " + nuevoClientePropietario.getNombre());
                stage.close();
            } catch (NumberFormatException ex) {
                // Manejar errores de conversión de tipo (por ejemplo, si el teléfono no es un número válido)
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Por favor, ingrese un número de teléfono válido.");
                alert.showAndWait();
            }
        });

        grid.add(submitButton, 1, 3);

        Scene scene = new Scene(grid, 400, 200);
        stage.setScene(scene);
        stage.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
