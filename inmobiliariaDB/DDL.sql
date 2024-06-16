CREATE DATABASE inmobiliaria;

USE inmobiliaria;

CREATE TABLE clientes_arrendatarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    telefono VARCHAR(20),
    direccion VARCHAR(255),
    profesion VARCHAR(100),
    lugar_trabajo VARCHAR(100),
    salario INT,
    barrio VARCHAR(100),
    zona VARCHAR(100),
    precio_alquiler INT,
    propiedad_alquilada VARCHAR(255)
);

CREATE TABLE propiedad (
    snr VARCHAR(50) PRIMARY KEY,
    direccion VARCHAR(255),
    telefono VARCHAR(20),
    barrio VARCHAR(255),
    zona VARCHAR(255),
    precio_alquiler DOUBLE,
    descripcion VARCHAR(255),
    disponible BOOLEAN
);

CREATE TABLE clientes_propietarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    telefono VARCHAR(20),
    direccion VARCHAR(255)
);

CREATE TABLE alquileres (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_arrendatario INT,
    id_propietario INT,
    snr VARCHAR(50), -- Cambiado para referenciar la clave primaria en propiedad
    fecha_inicio DATE,
    fecha_fin DATE,
    CONSTRAINT fk_arrendatario FOREIGN KEY (id_arrendatario) REFERENCES clientes_arrendatarios(id),
    CONSTRAINT fk_propietario FOREIGN KEY (id_propietario) REFERENCES clientes_propietarios(id),
    CONSTRAINT fk_propiedad FOREIGN KEY (snr) REFERENCES propiedad(snr)
);

select * from alquileres;