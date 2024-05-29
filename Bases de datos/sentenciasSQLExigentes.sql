# SELECT
SET @start_time = UNIX_TIMESTAMP();
SELECT COUNT(*) FROM agenda;
SELECT COUNT(*) FROM agente;
SELECT COUNT(*) FROM cliente;
SELECT COUNT(*) FROM contrato;
SELECT COUNT(*) FROM documento;
SELECT COUNT(*) FROM historial_estado_contrato;
SELECT COUNT(*) FROM inmueble;
SELECT COUNT(*) FROM pago;
SELECT COUNT(*) FROM visita_inmueble;
SET @end_time = UNIX_TIMESTAMP();
SET @tiempo_ejecucion = (@end_time - @start_time);
INSERT INTO tiempo_ejecucion(sentencia, segundos) VALUES('SELECT', (SELECT @tiempo_ejecucion));

# SELECT y WHERE
SET @start_time = UNIX_TIMESTAMP();
SELECT *
FROM contrato
WHERE interes_simple >= 0.2 AND interes_simple_adicional >= 0.2
LIMIT 3;
SET @end_time = UNIX_TIMESTAMP();
SET @tiempo_ejecucion = (@end_time - @start_time);
INSERT INTO tiempo_ejecucion(sentencia, segundos) VALUES('SELECT_WHERE', (SELECT @tiempo_ejecucion));

# SELECT, JOIN, GROUP BY y HAVING
SET @start_time = UNIX_TIMESTAMP();
SELECT d.id_cliente, d.inmueble_O_cliente, d.tipo_documento, d.fecha_adquisicion
FROM documento d
INNER JOIN (
    SELECT id_cliente, COUNT(*)  AS doc_counts
    FROM cliente
    GROUP BY id_cliente
    HAVING COUNT(*) >= 3) AS cl ON cl.id_cliente = d.id_cliente
LIMIT 3;
SET @end_time = UNIX_TIMESTAMP();
SET @tiempo_ejecucion = (@end_time - @start_time);
INSERT INTO tiempo_ejecucion(sentencia, segundos) VALUES('SELECT_JOIN_GROUPBY_HAVING', (SELECT @tiempo_ejecucion));

# SELECT, JOIN, GROUP BY y HAVING
SET @start_time = UNIX_TIMESTAMP();
SELECT d.id_inmueble, d.inmueble_O_cliente, d.tipo_documento, d.fecha_adquisicion
FROM documento d
INNER JOIN (
    SELECT id_cliente, COUNT(*)  AS doc_counts
    FROM cliente
    GROUP BY id_cliente
    HAVING COUNT(*) >= 3) AS cl ON cl.id_cliente = d.id_cliente
LIMIT 3;
SET @end_time = UNIX_TIMESTAMP();
SET @tiempo_ejecucion = (@end_time - @start_time);
INSERT INTO tiempo_ejecucion(sentencia, segundos) VALUES('SELECT_JOIN_GROUPBY_HAVING', (SELECT @tiempo_ejecucion));

# SELECT, JOIN y WHERE
SET @start_time = UNIX_TIMESTAMP();
SELECT i.direccion, i.tipo, i.area, i.descripcion, i.precio, c.interes_simple, c.interes_simple_adicional
FROM (inmueble i
	RIGHT JOIN contrato c ON i.id_inmueble = c.id_inmueble)
WHERE i.tipo = ('Casa' OR 'TERRENO')
LIMIT 3;
SET @end_time = UNIX_TIMESTAMP();
SET @tiempo_ejecucion = (@end_time - @start_time);
INSERT INTO tiempo_ejecucion(sentencia, segundos) VALUES('SELECT_JOIN_WHERE', (SELECT @tiempo_ejecucion));

# SELECT, GROUP BY y HAVING
SET @start_time = UNIX_TIMESTAMP();
SELECT id_cliente, COUNT(*) AS total_repeticiones
FROM cliente
GROUP BY id_cliente
HAVING COUNT(*) > 1
LIMIT 3;
SET @end_time = UNIX_TIMESTAMP();
SET @tiempo_ejecucion = (@end_time - @start_time);
INSERT INTO tiempo_ejecucion(sentencia, segundos) VALUES('SELECT_GROUPBY_HAVING', (SELECT @tiempo_ejecucion));

# SELECT, GROUP BY y HAVING
SET @start_time = UNIX_TIMESTAMP();
SELECT id_agente, COUNT(*) AS total_repeticiones
FROM agente
GROUP BY id_agente
HAVING COUNT(*) > 1
LIMIT 3;
SET @end_time = UNIX_TIMESTAMP();
SET @tiempo_ejecucion = (@end_time - @start_time);
INSERT INTO tiempo_ejecucion(sentencia, segundos) VALUES('SELECT_GROUPBY_HAVING', (SELECT @tiempo_ejecucion));

# SELECT, WHERE, GROUP BY, HAVING y ORDER BY
SET @start_time = UNIX_TIMESTAMP();
SELECT *
FROM cliente
WHERE id_cliente IN (
	SELECT id_cliente
	FROM cliente
	GROUP BY id_cliente
	HAVING COUNT(*) > 1)
ORDER BY id_cliente ASC
LIMIT 3;
SET @end_time = UNIX_TIMESTAMP();
SET @tiempo_ejecucion = (@end_time - @start_time);
INSERT INTO tiempo_ejecucion(sentencia, segundos) VALUES('SELECT_WHERE_GROUPBY_HAVING_ORDERBY', (SELECT @tiempo_ejecucion));

# SELECT, WHERE, GROUP BY, HAVING y ORDER BY
SET @start_time = UNIX_TIMESTAMP();
SELECT *
FROM contrato
WHERE id_agente IN (
	SELECT id_agente
	FROM agente
	GROUP BY id_agente
	HAVING COUNT(*) > 1)
ORDER BY id_agente ASC
LIMIT 3;
SET @end_time = UNIX_TIMESTAMP();
SET @tiempo_ejecucion = (@end_time - @start_time);
INSERT INTO tiempo_ejecucion(sentencia, segundos) VALUES('SELECT_WHERE_GROUPBY_HAVING_ORDERBY', (SELECT @tiempo_ejecucion));

# SELECT, JOIN, WHERE y GROUP BY
SET @start_time = UNIX_TIMESTAMP();
SELECT *
FROM (((inmueble i
	INNER JOIN contrato c ON i.id_inmueble = c.id_inmueble)
		INNER JOIN pago p ON c.id_contrato = p.id_contrato)
			INNER JOIN cliente cl ON cl.id_cliente = c.id_cliente)
WHERE i.precio > 10000
ORDER BY c.interes_simple, interes_simple_adicional ASC
LIMIT 3;
SET @end_time = UNIX_TIMESTAMP();
SET @tiempo_ejecucion = (@end_time - @start_time);
INSERT INTO tiempo_ejecucion(sentencia, segundos) VALUES('SELECT_JOIN_WHERE_GROUPBY', (SELECT @tiempo_ejecucion));



# CREATE, SELECT, JOIN y WHERE
SET @start_time = UNIX_TIMESTAMP();
CREATE TEMPORARY TABLE contratos_temporales AS
SELECT c.*
FROM (contrato c
	INNER JOIN inmueble i ON c.id_inmueble = i.id_inmueble)
WHERE i.precio > 10000 AND c.interes_simple > 0.05 AND c.numero_pagos = 1;
SET @end_time = UNIX_TIMESTAMP();
SET @tiempo_ejecucion = (@end_time - @start_time);
INSERT INTO tiempo_ejecucion(sentencia, segundos) VALUES('CREATE_SELECT_JOIN_WHERE', (SELECT @tiempo_ejecucion));

# SELECT
SET @start_time = UNIX_TIMESTAMP();
SELECT COUNT(*)
FROM contratos_temporales
LIMIT 3;
SET @end_time = UNIX_TIMESTAMP();
SET @tiempo_ejecucion = (@end_time - @start_time);
INSERT INTO tiempo_ejecucion(sentencia, segundos) VALUES('SELECT', (SELECT @tiempo_ejecucion));

# SELECT, JOIN, WHERE, GROUP BY y HAVING
SET @start_time = UNIX_TIMESTAMP();
SELECT c.id_contrato, COUNT(p.id_pago) as num_pagos
FROM ((contrato c
	INNER JOIN pago p ON c.id_contrato = p.id_contrato)
		INNER JOIN inmueble i ON c.id_inmueble = i.id_inmueble)
WHERE i.precio > 37000 AND c.interes_simple < 0.08 AND c.interes_simple_adicional < 0.17 AND c.numero_pagos > 1
GROUP BY c.id_contrato, c.interes_simple, c.interes_simple_adicional, c.numero_pagos
HAVING COUNT(p.id_pago) = c.numero_pagos
LIMIT 3;
SET @end_time = UNIX_TIMESTAMP();
SET @tiempo_ejecucion = (@end_time - @start_time);
INSERT INTO tiempo_ejecucion(sentencia, segundos) VALUES('SELECT_JOIN_WHERE_GROUPBY_HAVING', (SELECT @tiempo_ejecucion));

# CREATE, SELECT, JOIN y WHERE
SET @start_time = UNIX_TIMESTAMP();
CREATE TEMPORARY TABLE pagos_temporales AS
SELECT p.*
FROM ((pago p
	INNER JOIN contrato c ON p.id_contrato = c.id_contrato)
		INNER JOIN inmueble i ON c.id_inmueble = i.id_inmueble)
WHERE i.precio > 100000 AND c.interes_simple > 0.05 AND c.numero_pagos < 48;
SET @end_time = UNIX_TIMESTAMP();
SET @tiempo_ejecucion = (@end_time - @start_time);
INSERT INTO tiempo_ejecucion(sentencia, segundos) VALUES('CREATE_SELECT_JOIN_WHERE', (SELECT @tiempo_ejecucion));

# SELECT
SET @start_time = UNIX_TIMESTAMP();
SELECT COUNT(*)
FROM pagos_temporales
LIMIT 3;
SET @end_time = UNIX_TIMESTAMP();
SET @tiempo_ejecucion = (@end_time - @start_time);
INSERT INTO tiempo_ejecucion(sentencia, segundos) VALUES('SELECT', (SELECT @tiempo_ejecucion));

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

# UPDATE, JOIN y WHERE
SET @start_time = UNIX_TIMESTAMP();
UPDATE (contrato c
	INNER JOIN inmueble i ON c.id_inmueble = i.id_inmueble)
SET c.interes_simple = 0.44, c.interes_simple_adicional = 0.33
WHERE i.precio > 10000 AND c.interes_simple > 0.05 AND c.numero_pagos = 1;
SET @end_time = UNIX_TIMESTAMP();
SET @tiempo_ejecucion = (@end_time - @start_time);
INSERT INTO tiempo_ejecucion(sentencia, segundos) VALUES('UPDATE_JOIN_WHERE', (SELECT @tiempo_ejecucion));

# SELECT, JOIN y WHERE
SET @start_time = UNIX_TIMESTAMP();
SELECT COUNT(*)
FROM (contrato c
	INNER JOIN inmueble i ON c.id_inmueble = i.id_inmueble)
WHERE i.precio > 10000 AND c.interes_simple = 0.44 AND c.interes_simple_adicional = 0.33
LIMIT 3;
SET @end_time = UNIX_TIMESTAMP();
SET @tiempo_ejecucion = (@end_time - @start_time);
INSERT INTO tiempo_ejecucion(sentencia, segundos) VALUES('SELECT_JOIN_WHERE', (SELECT @tiempo_ejecucion));

# UPDATE, JOIN y WHERE
SET @start_time = UNIX_TIMESTAMP();
UPDATE ((pago p
	INNER JOIN contrato c ON p.id_contrato = c.id_contrato)
		INNER JOIN inmueble i ON c.id_inmueble = i.id_inmueble)
SET p.estatus = 'Abonado'
WHERE i.precio > 100000 AND c.interes_simple > 0.05 AND c.numero_pagos < 48;
SET @end_time = UNIX_TIMESTAMP();
SET @tiempo_ejecucion = (@end_time - @start_time);
INSERT INTO tiempo_ejecucion(sentencia, segundos) VALUES('UPDATE_JOIN_WHERE', (SELECT @tiempo_ejecucion));

# SELECT y WHERE
SET @start_time = UNIX_TIMESTAMP();
SELECT COUNT(*)
FROM pago
WHERE estatus = 'Abonado'
LIMIT 3;
SET @end_time = UNIX_TIMESTAMP();
SET @tiempo_ejecucion = (@end_time - @start_time);
INSERT INTO tiempo_ejecucion(sentencia, segundos) VALUES('SELECT_WHERE', (SELECT @tiempo_ejecucion));

# UPDATE y WHERE
SET @start_time = UNIX_TIMESTAMP();
UPDATE contrato
SET interes_simple = 0.0007 AND interes_simple_adicional = 0.0003
WHERE interes_simple = 0.15 AND interes_simple_adicional = 0.1;
SET @end_time = UNIX_TIMESTAMP();
SET @tiempo_ejecucion = (@end_time - @start_time);
INSERT INTO tiempo_ejecucion(sentencia, segundos) VALUES('UPDATE_WHERE', (SELECT @tiempo_ejecucion));

# CREATE, SELECT y WHERE
SET @start_time = UNIX_TIMESTAMP();
CREATE TEMPORARY TABLE intereses_temporales AS
SELECT *
FROM contrato
WHERE interes_simple = 0.0007 AND interes_simple_adicional = 0.0003;
SET @end_time = UNIX_TIMESTAMP();
SET @tiempo_ejecucion = (@end_time - @start_time);
INSERT INTO tiempo_ejecucion(sentencia, segundos) VALUES('CREATE_SELECT_WHERE', (SELECT @tiempo_ejecucion));

# UPDATE
SET @start_time = UNIX_TIMESTAMP();
UPDATE intereses_temporales
SET interes_simple = 0.15 AND interes_simple_adicional = 0.1;
SET @end_time = UNIX_TIMESTAMP();
SET @tiempo_ejecucion = (@end_time - @start_time);
INSERT INTO tiempo_ejecucion(sentencia, segundos) VALUES('UPDATE', (SELECT @tiempo_ejecucion));

# DELETE y WHERE
SET @start_time = UNIX_TIMESTAMP();
DELETE FROM contrato
WHERE (id_contrato, id_inmueble, id_cliente, id_agente) IN (
	SELECT id_contrato, id_inmueble, id_cliente, id_agente
	FROM contratos_temporales);
SET @end_time = UNIX_TIMESTAMP();
SET @tiempo_ejecucion = (@end_time - @start_time);
INSERT INTO tiempo_ejecucion(sentencia, segundos) VALUES('DELETE_WHERE', (SELECT @tiempo_ejecucion));

# DELETE y WHERE
SET @start_time = UNIX_TIMESTAMP();
DELETE FROM pago
WHERE estatus = 'Abonado';
SET @end_time = UNIX_TIMESTAMP();
SET @tiempo_ejecucion = (@end_time - @start_time);
INSERT INTO tiempo_ejecucion(sentencia, segundos) VALUES('DELETE_WHERE', (SELECT @tiempo_ejecucion));

# DELETE y WHERE
SET @start_time = UNIX_TIMESTAMP();
DELETE FROM contrato
WHERE interes_simple = 0.0007 AND interes_simple_adicional = 0.0003;
SET @end_time = UNIX_TIMESTAMP();
SET @tiempo_ejecucion = (@end_time - @start_time);
INSERT INTO tiempo_ejecucion(sentencia, segundos) VALUES('DELETE_WHERE', (SELECT @tiempo_ejecucion));

# INSERT y SELECT
SET @start_time = UNIX_TIMESTAMP();
INSERT INTO contrato
SELECT *
FROM contratos_temporales;
SET @end_time = UNIX_TIMESTAMP();
SET @tiempo_ejecucion = (@end_time - @start_time);
INSERT INTO tiempo_ejecucion(sentencia, segundos) VALUES('INSERT_SELECT', (SELECT @tiempo_ejecucion));

# INSERT y SELECT
SET @start_time = UNIX_TIMESTAMP();
INSERT INTO pago
SELECT *
FROM pagos_temporales;
SET @end_time = UNIX_TIMESTAMP();
SET @tiempo_ejecucion = (@end_time - @start_time);
INSERT INTO tiempo_ejecucion(sentencia, segundos) VALUES('INSERT_SELECT', (SELECT @tiempo_ejecucion));

# INSERT y SELECT
SET @start_time = UNIX_TIMESTAMP();
INSERT INTO contrato
SELECT *
FROM intereses_temporales;
SET @end_time = UNIX_TIMESTAMP();
SET @tiempo_ejecucion = (@end_time - @start_time);
INSERT INTO tiempo_ejecucion(sentencia, segundos) VALUES('INSERT_SELECT', (SELECT @tiempo_ejecucion));

# CREATE y SELECT
SET @start_time = UNIX_TIMESTAMP();
CREATE TEMPORARY TABLE tabla_contrato AS
SELECT *
FROM contrato;
CREATE TEMPORARY TABLE tabla_cliente AS
SELECT *
FROM cliente;
CREATE TEMPORARY TABLE tabla_pago AS
SELECT *
FROM pago;
SET @end_time = UNIX_TIMESTAMP();
SET @tiempo_ejecucion = (@end_time - @start_time);
INSERT INTO tiempo_ejecucion(sentencia, segundos) VALUES('CREATE_SELECT', (SELECT @tiempo_ejecucion));

# DROP
SET @start_time = UNIX_TIMESTAMP();
DROP TABLE contratos_temporales;
DROP TABLE pagos_temporales;
DROP TABLE intereses_temporales;
SET @end_time = UNIX_TIMESTAMP();
SET @tiempo_ejecucion = (@end_time - @start_time);
INSERT INTO tiempo_ejecucion(sentencia, segundos) VALUES('DROP', (SELECT @tiempo_ejecucion));

# DROP
SET @start_time = UNIX_TIMESTAMP();
DROP TABLE tabla_contrato;
DROP TABLE tabla_cliente;
DROP TABLE tabla_pago;
SET @end_time = UNIX_TIMESTAMP();
SET @tiempo_ejecucion = (@end_time - @start_time);
INSERT INTO tiempo_ejecucion(sentencia, segundos) VALUES('DROP', (SELECT @tiempo_ejecucion));

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

# CREATE, SELECT, JOIN y WHERE
SET @start_time = UNIX_TIMESTAMP();
CREATE TEMPORARY TABLE contratos_temporales AS
SELECT c.*
FROM (contrato c
	INNER JOIN inmueble i ON c.id_inmueble = i.id_inmueble)
WHERE i.precio > 10000 AND c.interes_simple > 0.05 AND c.numero_pagos = 1;
SET @end_time = UNIX_TIMESTAMP();
SET @tiempo_ejecucion = (@end_time - @start_time);
INSERT INTO tiempo_ejecucion(sentencia, segundos) VALUES('CREATE_SELECT_JOIN_WHERE', (SELECT @tiempo_ejecucion));

# SELECT
SET @start_time = UNIX_TIMESTAMP();
SELECT COUNT(*)
FROM contratos_temporales
LIMIT 3;
SET @end_time = UNIX_TIMESTAMP();
SET @tiempo_ejecucion = (@end_time - @start_time);
INSERT INTO tiempo_ejecucion(sentencia, segundos) VALUES('SELECT', (SELECT @tiempo_ejecucion));

# SELECT, JOIN, WHERE, GROUP BY y HAVING
SET @start_time = UNIX_TIMESTAMP();
SELECT *
FROM ((contrato c
	INNER JOIN pago p ON c.id_contrato = p.id_contrato)
		INNER JOIN inmueble i ON c.id_inmueble = i.id_inmueble)
WHERE i.precio > 37000 AND c.interes_simple < 0.08 AND c.interes_simple_adicional < 0.17 AND c.numero_pagos > 1
GROUP BY c.id_contrato
HAVING COUNT(p.id_pago) = c.numero_pagos
LIMIT 3;
SET @end_time = UNIX_TIMESTAMP();
SET @tiempo_ejecucion = (@end_time - @start_time);
INSERT INTO tiempo_ejecucion(sentencia, segundos) VALUES('SELECT_JOIN_WHERE_GROUPBY_HAVING', (SELECT @tiempo_ejecucion));

# CREATE, SELECT, JOIN y WHERE
SET @start_time = UNIX_TIMESTAMP();
CREATE TEMPORARY TABLE pagos_temporales AS
SELECT p.*
FROM ((pago p
	INNER JOIN contrato c ON p.id_contrato = c.id_contrato)
		INNER JOIN inmueble i ON c.id_inmueble = i.id_inmueble)
WHERE i.precio > 100000 AND c.interes_simple > 0.05 AND c.numero_pagos < 48;
SET @end_time = UNIX_TIMESTAMP();
SET @tiempo_ejecucion = (@end_time - @start_time);
INSERT INTO tiempo_ejecucion(sentencia, segundos) VALUES('CREATE_SELECT_JOIN_WHERE', (SELECT @tiempo_ejecucion));

# SELECT
SET @start_time = UNIX_TIMESTAMP();
SELECT COUNT(*)
FROM pagos_temporales
LIMIT 3;
SET @end_time = UNIX_TIMESTAMP();
SET @tiempo_ejecucion = (@end_time - @start_time);
INSERT INTO tiempo_ejecucion(sentencia, segundos) VALUES('SELECT', (SELECT @tiempo_ejecucion));

# UPDATE, JOIN y WHERE
SET @start_time = UNIX_TIMESTAMP();
UPDATE (contrato c
	INNER JOIN inmueble i ON c.id_inmueble = i.id_inmueble)
SET c.interes_simple = 0.44, c.interes_simple_adicional = 0.33
WHERE i.precio > 10000 AND c.interes_simple > 0.05 AND c.numero_pagos = 1;
SET @end_time = UNIX_TIMESTAMP();
SET @tiempo_ejecucion = (@end_time - @start_time);
INSERT INTO tiempo_ejecucion(sentencia, segundos) VALUES('UPDATE_JOIN_WHERE', (SELECT @tiempo_ejecucion));

# DELETE y WHERE
SET @start_time = UNIX_TIMESTAMP();
DELETE FROM contrato
WHERE (id_contrato, id_inmueble, id_cliente, id_agente) IN (
	SELECT id_contrato, id_inmueble, id_cliente, id_agente
	FROM contratos_temporales);
SET @end_time = UNIX_TIMESTAMP();
SET @tiempo_ejecucion = (@end_time - @start_time);
INSERT INTO tiempo_ejecucion(sentencia, segundos) VALUES('DELETE_WHERE', (SELECT @tiempo_ejecucion));

# INSERT y SELECT
SET @start_time = UNIX_TIMESTAMP();
INSERT INTO contrato
SELECT *
FROM contratos_temporales;
SET @end_time = UNIX_TIMESTAMP();
SET @tiempo_ejecucion = (@end_time - @start_time);
INSERT INTO tiempo_ejecucion(sentencia, segundos) VALUES('INSERT_SELECT', (SELECT @tiempo_ejecucion));

# DROP
SET @start_time = UNIX_TIMESTAMP();
DROP TABLE contratos_temporales;
SET @end_time = UNIX_TIMESTAMP();
SET @tiempo_ejecucion = (@end_time - @start_time);
INSERT INTO tiempo_ejecucion(sentencia, segundos) VALUES('DROP', (SELECT @tiempo_ejecucion));

# CREATE y SELECT
SET @start_time = UNIX_TIMESTAMP();
CREATE TEMPORARY TABLE tabla_contrato AS
SELECT *
FROM contrato;
CREATE TEMPORARY TABLE tabla_cliente AS
SELECT *
FROM cliente;
CREATE TEMPORARY TABLE tabla_pago AS
SELECT *
FROM pago;
SET @end_time = UNIX_TIMESTAMP();
SET @tiempo_ejecucion = (@end_time - @start_time);
INSERT INTO tiempo_ejecucion(sentencia, segundos) VALUES('CREATE_SELECT', (SELECT @tiempo_ejecucion));

# DROP
SET @start_time = UNIX_TIMESTAMP();
DROP TABLE tabla_contrato;
DROP TABLE tabla_cliente;
DROP TABLE tabla_pago;
SET @end_time = UNIX_TIMESTAMP();
SET @tiempo_ejecucion = (@end_time - @start_time);
INSERT INTO tiempo_ejecucion(sentencia, segundos) VALUES('DROP', (SELECT @tiempo_ejecucion));
