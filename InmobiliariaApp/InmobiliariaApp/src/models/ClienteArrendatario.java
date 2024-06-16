package models;

public class ClienteArrendatario {
    private String nombre;
    private String telefono;
    private String direccion;
    private String profesion;
    private String lugarTrabajo;
    private int salario;
    private String barrio;
    private String zona;
    private int precioAlquiler;
    private String propiedadAlquilada;

    public ClienteArrendatario(String nombre) {
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

    public ClienteArrendatario(String nombre, String telefono, String direccion, String profesion, String lugarTrabajo, int salario, String barrio, String zona, int precioAlquiler, String propiedadAlquilada) {
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

    public int getId() {
        // Implementar lógica para obtener el ID
        // Esto puede involucrar la generación de un ID único o la consulta a una base de datos
        // En este ejemplo, simplemente devolveré un valor fijo, pero deberías adaptarlo a tu lógica real
        return 1;
    }

    @Override
    public String toString() {
        return "ClienteArrendatario{" +
                "nombre='" + nombre + '\'' +
                ", telefono='" + telefono + '\'' +
                ", direccion='" + direccion + '\'' +
                ", profesion='" + profesion + '\'' +
                ", lugarTrabajo='" + lugarTrabajo + '\'' +
                ", salario=" + salario +
                ", barrio='" + barrio + '\'' +
                ", zona='" + zona + '\'' +
                ", precioAlquiler=" + precioAlquiler +
                ", propiedadAlquilada='" + propiedadAlquilada + '\'' +
                '}';
    }
}
