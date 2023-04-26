CREATE DATABASE IF NOT EXISTS CGB;
USE CGB;

CREATE TABLE IF NOT EXISTS SEG_EMPRESAS(
	ID_EMP INT(11) PRIMARY KEY,
    NOMBRE_EMP VARCHAR(30),
    PAIS_EMP VARCHAR(3),
    EMPRESA_EMP VARCHAR(3),
    DEPARTAMENTO_EMP INT(11),
    PERIODO_EMP VARCHAR(5),
    TIPO_CONTA_EMP VARCHAR(1),
    CONTA_AUTOMATICA_EMP VARCHAR(1),
    ELIMINADO_EMP VARCHAR(1),
    USUARIO_EMP VARCHAR(25),
    FECHA_EM DATE,
    IP_EMP VARCHAR(50)
);
CREATE TABLE IF NOT EXISTS SEG_EMPRESAS_L(
	ID_EMP INT(11) PRIMARY KEY,
	NOMBRE_EMP VARCHAR(30),
	PAIS_EMP VARCHAR(3),
	EMPRESA_EMP VARCHAR(3),
	DEPARTAMENTO_EMP INT(11),
	PERIODO_EMP VARCHAR(5),
	TIPO_CONTA_EMP VARCHAR(1),
	CONTA_AUTOMATICA_EMP VARCHAR(1),
	ELIMINADO_EMP VARCHAR(1),
	USUARIO_EMP VARCHAR(25),
	FECHA_EM DATE,
	IP_EMP VARCHAR(50),
	FECHA_LOG_EMP TIMESTAMP,
	UDI_EMP VARCHAR(1)
);
CREATE TABLE IF NOT EXISTS SEG_USUARIOS(
	ID_USU INT(11) PRIMARY KEY,
	ID_EMP_USU INT(11),
	NOMBRE_USU VARCHAR (60),
	CODIGO_USU VARCHAR (20),
	PUESTO_USU VARCHAR (50),
	CORREO_USU VARCHAR (60),
	SUCURSAL_USU VARCHAR (50),
	UNIDAD_NEGOCIO_USU VARCHAR (50),
	SUPERVISOR_USU INT(11),
	ACTIVO_USU VARCHAR (1),
	ELIMINADO_USU VARCHAR (1),
	INSPECTOR_USU VARCHAR (1),
	NOTIFICACION_USU VARCHAR (1),
	CLAVE_USU VARCHAR (100),
	USUARIO_USU VARCHAR (25),
	FECHA_USU DATE,
	IP_USU  VARCHAR (50),
	FOREIGN KEY (ID_EMP_USU) REFERENCES SEG_EMPRESAS (ID_EMP)
);

CREATE TABLE IF NOT EXISTS SEG_USUARIOS_L(
	ID_USU INT(11) PRIMARY KEY,
	NOMBRE_USU VARCHAR	(60),
	CODIGO_USU VARCHAR	(20),
	PUESTO_USU VARCHAR	(50),
	CORREO_USU VARCHAR	(60),
	SUCURSAL_USU VARCHAR	(50),
	UNIDAD_NEGOCIO_USU	VARCHAR	(50),
	SUPERVISOR_USU	INT	(11),
	ACTIVO_USU	VARCHAR	(1),
	ELIMINADO_USU VARCHAR(1),
	INSPECTOR_USU VARCHAR(1),
	NOTIFICACION_USU VARCHAR(1),
	CLAVE_USU VARCHAR (100),
	USUARIO_USU	VARCHAR (25),
	FECHA_USU DATE,
	IP_USU	VARCHAR	(50),
	FECHA_LOG_USU TIMESTAMP,	
	UDI_USU	VARCHAR	(1)
);

/*
GEN TIPO CONTRATO - Level Up - Marlón Hernández
*/

CREATE TABLE IF NOT EXISTS GEN_TIPO_CONTRATO(
	ID_TCO INT,
	DESCRIPCION_TCO VARCHAR (30),
	ELIMINADO_TCO VARCHAR (1),
	USUARIO_TCO VARCHAR (25),
	FECHA_TCO DATE,
	IP_TCO VARCHAR (50)
);

CREATE TABLE IF NOT EXISTS GEN_TIPO_CONTRATO_L(
	ID_TCO INT,
	DESCRIPCION_TCO VARCHAR (30),
	ELIMINADO_TCO VARCHAR (1),
	USUARIO_TCO VARCHAR (25),
	FECHA_TCO DATE,
	IP_TCO VARCHAR (50),
	FECHA_LOG_TCO TIMESTAMP,
	UDI_TCO VARCHAR(1)
);