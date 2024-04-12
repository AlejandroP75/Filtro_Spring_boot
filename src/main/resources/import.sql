-- Active: 1712862849617@@127.0.0.1@3306@db_filtro
-- Zonas
INSERT INTO zonas (nombre) VALUES ('Zona 1');
INSERT INTO zonas (nombre) VALUES ('Zona 2');
-- Inserta las otras zonas aquí

-- Oficinas
INSERT INTO oficinas (nombre, id_zona) VALUES ('Oficina 1', 1);
INSERT INTO oficinas (nombre, id_zona) VALUES ('Oficina 2', 2);
-- Inserta las otras oficinas aquí

-- Clientes
INSERT INTO clientes (nombre, telefono) VALUES ('Cliente 1', '123456789');
INSERT INTO clientes (nombre, telefono) VALUES ('Cliente 2', '987654321');
-- Inserta los otros clientes aquí

-- Casas
INSERT INTO casa (aseos, baños, cocinas, direccion, habitaciones, llaves, m2, nom_propietario, parqueaderos, precio, puerta_blindada, telefono_propietario, tipo_contrato, tipo_gas, id_oficina, id_zona) 
VALUES (2, 2, 1, 'Dirección 1', 3, 1, 150, 'Propietario 1', 2, 200000, 1, '987654321', 1, 1, 1, 1);
-- Inserta las otras casas aquí

-- Pisos Nuevos
INSERT INTO pisos_nuevos (aseos, baños, cocinas, direccion, habitaciones, llaves, m2, nom_propietario, parqueaderos, precio, puerta_blindada, telefono_propietario, tipo_contrato, tipo_gas, id_oficina, id_zona) 
VALUES (1, 1, 1, 'Dirección 1', 2, 1, 100, 'Propietario 1', 1, 150000, 0, '123456789', 1, 0, 1, 1);
-- Inserta los otros pisos nuevos aquí

-- Pisos de Ocasión
INSERT INTO pisos_ocasion (aseos, baños, cocinas, direccion, habitaciones, llaves, m2, nom_propietario, parqueaderos, precio, puerta_blindada, telefono_propietario, tipo_contrato, tipo_gas, id_oficina, id_zona) 
VALUES (2, 1, 1, 'Dirección 1', 2, 1, 80, 'Propietario 1', 0, 100000, 0, '987654321', 1, 0, 2, 2);
-- Inserta los otros pisos de ocasión aquí

-- Villas
INSERT INTO villas (aseos, baños, cocinas, direccion, habitaciones, llaves, m2, nom_propietario, parqueaderos, precio, puerta_blindada, tamaño_parcela, telefono_propietario, tipo_contrato, tipo_gas, urbanizacion, id_oficina) 
VALUES (3, 2, 1, 'Dirección 1', 4, 1, 200, 'Propietario 1', 2, 300000, 1, 500, '123456789', 1, 1, 'Urbanización 1', 1);
-- Inserta las otras villas aquí

-- Locales
INSERT INTO locales (acondicionado, diafano, direccion, llaves, m2, nom_propietario, numero_puertas, precio, telefono_propietario, tipo_contrato, id_oficina, id_zona) 
VALUES (1, 0, 'Dirección 1', 1, 150, 'Propietario 1', 2, 500, '987654321', 1, 1, 1);
-- Inserta los otros locales aquí

-- Casa
INSERT INTO casa (aseos, baños, cocinas, direccion, habitaciones, llaves, m2, nom_propietario, parqueaderos, precio, puerta_blindada, telefono_propietario, tipo_contrato, tipo_gas, id_oficina, id_zona) 
VALUES (2, 2, 1, 'Dirección Casa 1', 3, 1, 150, 'Propietario Casa 1', 2, 200000, 1, '123456789', 1, 1, 1, 1);

-- Piso Nuevo
INSERT INTO pisos_nuevos (aseos, baños, cocinas, direccion, habitaciones, llaves, m2, nom_propietario, parqueaderos, precio, puerta_blindada, telefono_propietario, tipo_contrato, tipo_gas, id_oficina, id_zona) 
VALUES (1, 1, 1, 'Dirección Piso Nuevo 1', 2, 1, 100, 'Propietario Piso Nuevo 1', 1, 150000, 0, '987654321', 1, 0, 1, 1);

-- Piso de Ocasión
INSERT INTO pisos_ocasion (aseos, baños, cocinas, direccion, habitaciones, llaves, m2, nom_propietario, parqueaderos, precio, puerta_blindada, telefono_propietario, tipo_contrato, tipo_gas, id_oficina, id_zona) 
VALUES (2, 1, 1, 'Dirección Piso Ocasión 1', 2, 1, 80, 'Propietario Piso Ocasión 1', 0, 100000, 0, '123456789', 1, 0, 2, 2);

-- Local
INSERT INTO locales (acondicionado, diafano, direccion, llaves, m2, nom_propietario, numero_puertas, precio, telefono_propietario, tipo_contrato, id_oficina, id_zona) 
VALUES (1, 0, 'Dirección Local 1', 1, 150, 'Propietario Local 1', 2, 500, '987654321', 1, 1, 1);

-- Villa
INSERT INTO villas (aseos, baños, cocinas, direccion, habitaciones, llaves, m2, nom_propietario, parqueaderos, precio, puerta_blindada, tamaño_parcela, telefono_propietario, tipo_contrato, tipo_gas, urbanizacion, id_oficina) 
VALUES (3, 2, 1, 'Dirección Villa 1', 4, 1, 200, 'Propietario Villa 1', 2, 300000, 1, 500, '123456789', 1, 1, 'Urbanización 1', 1);


-- Visitas Casa
INSERT INTO visitas_casa (comentario, fecha_hora, id_casa, id_cliente) VALUES ('Visita 1', '2024-04-11', 1, 1);
INSERT INTO visitas_casa (comentario, fecha_hora, id_casa, id_cliente) VALUES ('Visita 2', '2024-04-12', 2, 2);
-- Inserta las otras visitas a casas aquí

-- Visitas Piso Nuevo
INSERT INTO visitas_piso_nuevo (comentario, fecha_hora, id_cliente, id_piso_nuevo) VALUES ('Visita 1', '2024-04-11', 1, 1);
INSERT INTO visitas_piso_nuevo (comentario, fecha_hora, id_cliente, id_piso_nuevo) VALUES ('Visita 2', '2024-04-12', 2, 2);
-- Inserta las otras visitas a pisos nuevos aquí

-- Visitas Piso de Ocasión
INSERT INTO visitas_piso_ocasion (comentario, fecha_hora, id_cliente, id_piso_ocasion) VALUES ('Visita 1', '2024-04-11', 1, 1);
INSERT INTO visitas_piso_ocasion (comentario, fecha_hora, id_cliente, id_piso_ocasion) VALUES ('Visita 2', '2024-04-12', 2, 2);
-- Inserta las otras visitas a pisos de ocasión aquí

-- Visitas Villa
INSERT INTO visitas_villa (comentario, fecha_hora, id_cliente, id_villa) VALUES ('Visita 1', '2024-04-11', 1, 1);
INSERT INTO visitas_villa (comentario, fecha_hora, id_cliente, id_villa) VALUES ('Visita 2', '2024-04-12', 2, 2);
-- Inserta las otras visitas a villas aquí

-- Visitas Local
INSERT INTO visitas_local (comentario, fecha_hora, id_cliente, id_local) VALUES ('Visita 1', '2024-04-11', 1, 1);
INSERT INTO visitas_local (comentario, fecha_hora, id_cliente, id_local) VALUES ('Visita 2', '2024-04-12', 2, 2);