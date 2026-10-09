# Base de datos de Páginas de Villa Serena

## 1. Resumen del caso
La librería Páginas de Villa Serena opera a través de tres tiendas físicas (Centro, Ribera y Universidad). Ahora mismo gestiona su inventario, stock, empleados, clientes y ventas mediante hojas de cálculo, lo que genera errores de sincronización y pérdida para rastrear los precios y el inventarios. El objetivo de este sistema es centralizar la información mediante una base de datos entidad relacion que permita controlar el stock específico por ubicación, registrar clientes y socios, y trazar cada venta con precisión histórica de precios y empleados intervinientes.
## 2. Análisis del caso

### 2.1 Entidades y atributos

### 2.2 Relaciones

### 2.3 Datos descartados

## 3. Reglas de negocio
-Cada empleado está vinculado obligatoriamente a una única tienda de trabajo.

-Un libro pertenece de manera estricta a una única editorial.

-El stock de un libro se gestiona de forma independiente para cada sucursal (tienda).

-Los precios de venta en los pedidos deben reflejar de forma persistente el valor cobrado en el momento de la transacción, protegiendo la factura frente a futuras fluctuaciones del precio de catálogo.

-El correo electrónico del cliente/socio debe ser un dato único dentro del sistema para permitir avisos comerciales y gestión de cuentas.
## 4. Diagrama entidad-relación

## 5. Modelo lógico
tienda (id_tienda [PK], nombre, direccion, telefono, ciudad)

editorial (id_editorial [PK], nombre, pais, telefono)

autor (id_autor [PK], nombre, nacionalidad, año_nacimiento)

libro (isbn [PK], titulo, año_publicacion, num_paginas, precio_catalogo, id_editorial [FK])

Libro_Autor (isbn [PK/FK], id_autor [PK/FK], rol)

Inventario (id_tienda [PK/FK], isbn [PK/FK], stock, fecha_conteo)

empleado (dni [PK], nombre, apellidos, cargo, fecha_contratacion, correo, id_tienda [FK])

cliente (id_cliente [PK], nombre_completo, email [UNIQUE], telefono, es_socio, fecha_alta)

pedido (id_pedido [PK], fecha, forma_pago, estado, id_tienda [FK], dni_empleado [FK], id_cliente [FK])

Detalle_Pedido (id_pedido [PK/FK], isbn [PK/FK], cantidad, precio_cobrado)
## 6. Script SQL (schema.sql)

## 7. Diccionario de datos
Tabla: Tienda
| Columna | Tipo | Obligatorio | Descripción |
|---|---|:---:|---|
|id_tienda|int|Sí|Da un tipo int al campo que no se puede repetir para identificarle. Clave primaria|
|nombre|varchar(100)|Sí|Nombre de la tienda|
|direccion|varchar(200)|Sí|Dirección física de la tienda|
|telefono|varchar(20)|Sí|Teléfono de la tienda|
|ciudad|varchar(100)|Sí|Ciudad donde se encuentra la tienda|

Tabla: Editorial
| Columna | Tipo | Obligatorio | Descripción |
|---|---|:---:|---|
|id_editorial|int|Sí|Campo obligatorio y unico para identificar. Clave primaria|
|nombre|varchar(150)|Sí|Nombre de la editorial|
|pais|varchar(100)|Sí|País de origen de la editorial|
|telefono|varchar(20)|Sí|Telefono de contacto de la editorial|
 
Tabla: Autor
| Columna | Tipo | Obligatorio | Descripción |
|---|---|:---:|---|
|id_autor|int|Sí|Id para identificar el autor concreto. Clave primaria|
|nombre|varchar(200)|Sí|Nombre del autor|
|nacionalidad|varchar(100)|Sí|Nacionalidad del autor|
|año_nacimiento|year|Sí|Año de nacimiento del autor| 

Tabla: Libro
| Columna | Tipo | Obligatorio | Descripción |
|---|---|:---:|---|
|isbn|char(13)|Sí|Código ISBN de 13 dígitos que identifica el libro de forma única.|
|titulo|varchar(250)|Sí|Nombre,titulo del libro|
|año_publicacion|year|Sí|Año en la que el libro se publico|
|num_paginas|int|Sí|Número de páginas totales del libro|
|precio_catalogo|decimal(10,2)|Sí|Precio que tiene el libro|

Tabla: Libro_Autor
| Columna | Tipo | Obligatorio | Descripción |
|---|---|:---:|---|
|isbn|char(13)|Sí|Código ISBN de 13 dígitos que identifica el libro de forma única.|
|id_autor|int|Sí|Id para identificar el autor concreto. Clave primaria|
|rol|ENUM('principal', 'colaborador')|Sí|Define el rol del autor si ha sido el principal o si ha sido un colaborador|

Tabla: Inventario
| Columna | Tipo | Obligatorio | Descripción |
|---|---|:---:|---|
|id_tienda|int|Sí|Da un tipo int al campo que no se puede repetir para identificarle|
|isbn|char(13)|Sí|Código ISBN de 13 dígitos que identifica el libro de forma única.|
|stock|int|Sí|Cantidad de libros que quedan en el inventario|
|fecha_conteo|date|Sí|Fecha en la que se hizo el recuento del inventario|

Tabla: Empleado
| Columna | Tipo | Obligatorio | Descripción |
|---|---|:---:|---|
|dni|varchar(9)|Sí|Documento personal y único para identificar a una persona|
|nombre|varchar(100)|Sí|Nombre de la persona contratada|
|apellidos|varchar(150)|Sí|Apellidos de la persona contratada|
|cargo|ENUM('librero', 'cajero', 'encargado')|Sí|Declara el puesto del empleado|
|fecha_contratacion|date|Sí|Fecha de inscripcion del empleado|
|correo|varchar(150)|Sí|Correo electronico del empleado|
|id_tienda|int|Sí|Da un tipo int al campo que no se puede repetir para identificarle|

Tabla: Cliente
| Columna | Tipo | Obligatorio | Descripción |
|---|---|:---:|---|
|id_cliente|int|Sí|Id único para identificar el cliente con sus datos correspondientes|
|nombre_completo|varchar(200)|Sí|
## 8. Decisiones de diseño

## 9. Datos de prueba

## 10. Consultas de prueba

## 11. Limitaciones y mejoras futuras
