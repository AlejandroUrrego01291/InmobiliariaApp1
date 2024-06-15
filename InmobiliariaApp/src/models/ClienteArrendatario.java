package models;

public class ClienteArrendatario {
    private String nombre;
    private String telefono;
    private String direccion;
    private String profesion;
    private String lugarTrabajo;
    private int salario; // o double, dependiendo de lo que necesites
    private String barrio;
    private String zona;
    private int precioAlquiler; // o double, dependiendo de lo que necesites
    private String propiedadAlquilada;

    public ClienteArrendatario(String nombre, String telefono, String direccion, String profesion,
                               String lugarTrabajo, int salario, String barrio, String zona,
                               int precioAlquiler, String propiedadAlquilada) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.profesion = profesion;
        this.lugarTrabajo = lugarTrabajo;
        this.salario = salario;
        this.barrio = barrio;
        this.zona = zona;
        this.precioAlquiler = precioAlquiler;
        this.propiedadAlquilada = propiedadAlquilada;
    }

    public ClienteArrendatario(String clienteArrendatario) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public String getLugarTrabajo() {
        return lugarTrabajo;
    }

    public void setLugarTrabajo(String lugarTrabajo) {
        this.lugarTrabajo = lugarTrabajo;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
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

    public int getPrecioAlquiler() {
        return precioAlquiler;
    }

    public void setPrecioAlquiler(int precioAlquiler) {
        this.precioAlquiler = precioAlquiler;
    }

    public String getPropiedadAlquilada() {
        return propiedadAlquilada;
    }

    public void setPropiedadAlquilada(String propiedadAlquilada) {
        this.propiedadAlquilada = propiedadAlquilada;
    }
}
