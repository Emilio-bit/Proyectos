CREATE DATABASE administracion_ventaOrenta_inmuebles;

USE administracion_ventaOrenta_inmuebles;

CREATE TABLE inmueble (
	id_inmueble CHAR(7) NOT NULL,
	tipo VARCHAR(20),
    direccion VARCHAR(300) NOT NULL,
	area DECIMAL(7, 2) NOT NULL,
	descripcion TINYTEXT,
	precio DOUBLE NOT NULL);

CREATE TABLE cliente (
    id_cliente CHAR(10) NOT NULL,
	nombre VARCHAR(40) NOT NULL,
	apellido_paterno VARCHAR(40),
	apellido_materno VARCHAR(40),
	telefono CHAR(10));

CREATE TABLE documento (
	id_documento VARCHAR(16) NOT NULL,
	inmueble_O_cliente ENUM('cliente', 'inmueble') NOT NULL,
	id_inmueble CHAR(7),
    id_cliente CHAR(10),
	tipo_documento VARCHAR(70) NOT NULL,
	fecha_adquisicion DATE NOT NULL);

CREATE TABLE agente (
	id_agente CHAR(4) NOT NULL,
	nombre VARCHAR(40) NOT NULL,
	apellido_paterno VARCHAR(40),
	apellido_materno VARCHAR(40),
	telefono CHAR(10),
	correo_electronico VARCHAR(300));

CREATE TABLE contrato (
	id_contrato CHAR(8) NOT NULL,
	id_inmueble CHAR(7) NOT NULL,
	id_cliente CHAR(10) NOT NULL,
	id_agente CHAR(4) NOT NULL,
	fecha_inicio DATE NOT NULL,
	venta_O_renta ENUM('venta', 'renta') NOT NULL,
	interes_simple DOUBLE NOT NULL,
	interes_simple_adicional DOUBLE NOT NULL,
	estatus VARCHAR(20) NOT NULL);

CREATE TABLE pago (
	id_pago CHAR(16) NOT NULL,
	id_contrato CHAR(8) NOT NULL,
	fecha DATE NOT NULL,
	monto DOUBLE NOT NULL,
	estatus VARCHAR(20) NOT NULL);

CREATE TABLE historial_estado_contrato (
	id_estado CHAR(5) NOT NULL,
	id_contrato CHAR(8) NOT NULL,
	fecha DATE NOT NULL,
	estatus VARCHAR(20) NOT NULL);

CREATE TABLE agenda (
	id_actividad INT NOT NULL,
	id_cliente CHAR(10) NOT NULL,
	id_inmueble CHAR(7) NOT NULL,
	tipo_actividad VARCHAR(16) NOT NULL);

CREATE TABLE visita_inmueble (
	id_visita INT NOT NULL,
	id_inmueble CHAR(7) NOT NULL,
	id_cliente CHAR(10) NOT NULL,
	id_agente CHAR(4) NOT NULL,
	comentarios TINYTEXT,
	calificacion TINYINT
    CHECK (calificacion >= 1 AND calificacion <= 5));

ALTER TABLE inmueble
ADD PRIMARY KEY (id_inmueble);

ALTER TABLE cliente
ADD PRIMARY KEY (id_cliente);

ALTER TABLE documento
ADD PRIMARY KEY (id_documento),
ADD FOREIGN KEY (id_inmueble) REFERENCES inmueble(id_inmueble),
ADD FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente);

ALTER TABLE agente
ADD PRIMARY KEY (id_agente);

ALTER TABLE contrato
ADD PRIMARY KEY (id_contrato),
ADD FOREIGN KEY (id_inmueble) REFERENCES inmueble(id_inmueble),
ADD FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente),
ADD FOREIGN KEY (id_agente) REFERENCES agente(id_agente);

ALTER TABLE pago
ADD PRIMARY KEY (id_pago),
ADD FOREIGN KEY (id_contrato) REFERENCES contrato(id_contrato);

ALTER TABLE historial_estado_contrato
ADD PRIMARY KEY (id_estado),
ADD FOREIGN KEY (id_contrato) REFERENCES contrato(id_contrato);

ALTER TABLE agenda
ADD PRIMARY KEY (id_actividad),
ADD FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente);

ALTER TABLE visita_inmueble
ADD PRIMARY KEY (id_visita),
ADD FOREIGN KEY (id_inmueble) REFERENCES inmueble(id_inmueble),
ADD FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente),
ADD FOREIGN KEY (id_agente) REFERENCES agente(id_agente);
