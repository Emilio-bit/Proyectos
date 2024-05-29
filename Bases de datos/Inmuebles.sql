
USE administracion_ventaOrenta_inmuebles;

SELECT * FROM inmueble WHERE tipo = 'Casa';
SELECT * FROM inmueble WHERE precio > 300000.00;
SELECT * FROM inmueble WHERE direccion = 'Avenida';

SELECT * FROM cliente WHERE apellido_paterno = 'García';
SELECT * FROM cliente WHERE telefono LIKE '5552';
SELECT * FROM cliente WHERE apellido_materno = 'Rodriguez';

SELECT * FROM contrato WHERE venta_O_renta = 'venta';
SELECT * FROM contrato WHERE interes_simple > 0.05;
SELECT * FROM contrato WHERE estatus = 'inactivo';


select * from documento where inmueble_O_cliente = 'cliente';
select * from documento where tipo_documento = 'Escritura de Propiedad';
select * from documento where fecha_adquisicion is not null;

select * from agente where apellido_paterno = 'Fernández';
select * from agente where telefono  like '5460';
select * from agente where correo_electronico = 'email.com';

SELECT * FROM pago WHERE monto >= 6000.00;
SELECT * FROM pago WHERE estatus = 'realizado' AND fecha > '2023-03-01';
SELECT * FROM pago WHERE id_contrato = 'CTR00003';

SELECT * FROM historial_estado_contrato WHERE id_contrato = 'CTR00007';
SELECT * FROM historial_estado_contrato WHERE estatus = 'inactivo';
SELECT * FROM historial_estado_contrato where fecha > '2023-02-12';

SELECT * FROM agenda WHERE tipo_actividad IN ('Cita de venta', 'Cita de alquiler');
SELECT * FROM agenda WHERE id_cliente = 'CLI00003';
SELECT * FROM agenda WHERE tipo_actividad = 'Cita de alquiler';

SELECT * FROM visita_inmueble WHERE calificacion >= 4;
SELECT * FROM visita_inmueble WHERE id_agente = 'AG03';
SELECT * FROM visita_inmueble WHERE id_cliente = 'CLI00005';



select p.tipo_actividad from agenda p;





