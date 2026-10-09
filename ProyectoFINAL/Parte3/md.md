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
|nombre_completo|varchar(200)|Sí|Nombre y apellidos del cliente|
|email|varchar(150)|Sí|correo electronico para contactar con el cliente|
|telefono|varchar(20)|No|Teléfono del cliente para contactar|
|es_socio|boolean|Sí|Declara si un cliente es socio o no|
|fecha_alta|date|No|Fecha de alta del cliente si se hace socio|

Tabla: Pedido
| Columna | Tipo | Obligatorio | Descripción |
|---|---|:---:|---|
|id_pedido|int|Sí|Manera de identificar un pedido en concreto|
|fecha|date|Sí|Fecha del pedido|
|forma_pago|ENUM('efectivo', 'tarjeta', 'bizum')|Sí|Para determinar la forma del pago del pedido|
|estado|ENUM('preparado', 'entregado', 'cancelado')|Sí|Determinado el estado del pedido|
|id_tienda|int|Sí|Da un tipo int al campo que no se puede repetir para identificarle|
|dni_empleado|varchar(9)|Sí|Documento personal y único para identificar a una persona|
|id_cliente|int|Sí|Id único para identificar el cliente con sus datos correspondientes|

Tabla: Detalle_pedido
| Columna | Tipo | Obligatorio | Descripción |
|---|---|:---:|---|
|id_pedido|int|Sí|Manera de identificar un pedido en concreto|
|isbn|char(13)|Sí|Código ISBN de 13 dígitos que identifica el libro de forma única.|
|cantidad|int|Sí|Número de libros pedidos|
|precio_cobrado|decimal(10,2)|Sí|Precio real unitario cobrado por el libro|

## 8. Decisiones de diseñoo1.Inventario por sucursal
	
 Por qué: Para solucionar el problema de Villa Serena y saber el stock exacto que hay en cada tienda (Centro, Ribera o Universidad).
	
 Qué se decidió: Meter una tabla intermedia llamada Inventario entre tiendas y libros.

 Alternativa descartada: Poner un campo de stock directamente en la tabla Libro, pero eso solo sirve para    tener un total global y no te dice en qué tienda física está el libro.

2.Histórico de precios en los pedidos

Por qué: Para que si el día de mañana cambian los precios en el catálogo, los tickets y facturas antiguas sigan mostrando lo que se cobró realmente en su momento.

Qué se decidió: Guardar el campo precio_cobrado en la tabla Detalle_Pedido.

Alternativa descartada: Consultar el precio directamente de la tabla Libro al hacer el ticket, lo cual descartamos porque si suben los precios, te falsearía toda la contabilidad pasada.

3.Gestión de varios autores

Por qué: Para poder meter libros que tienen varios escritores (como las antologías) o gente que hace prólogos.

Qué se decidió: Usar la tabla intermedia Libro_Autor con un campo rol ('principal' o 'colaborador').

Alternativa descartada: Poner el autor como un atributo plano en la tabla Libro, pero con eso solo puedes meter a uno y pierdes toda la gracia de las relaciones.

4.Fechas de alta opcionales para clientes

Por qué: Para que los clientes normales que compran puntualmente sin ser socios puedan registrarse rápido sin inventar datos.
 
Qué se decidió: Dejar que el campo fecha_alta y el campo telefono permita meter valores nulos.

Alternativa descartada: Que tengan que rellenar todos los campos.

## 9. Datos de prueb
INSERT INTO tienda (id_tienda, nombre, direccion, telefono, ciudad) VALUES 
(1, 'Caserio Colesterol', 'Temporada1', '976000111', 'Al lado de mi casa'),
(2, 'La classe', 'Calle  Calle Gomera, 15, 29640 Fuengirola, Málaga, España ', '676 767 676', 'Malaga'),
(3, 'Paconis', 'Debajo de mi casa por ahi', '976 541 123', 'Zaragoza');


INSERT INTO editorial (id_editorial, nombre, pais, telefono) VALUES 
(1, 'Anaya', 'España', '976 812 111'),
(2, 'Ibrea', 'Marruecos', '976 123 534'),
(3, 'Quevedos', 'Rumania', '976 431 852');



INSERT INTO autor (nombre, nacionalidad, año_nacimiento) VALUES 
('Jordi Wild', 'Catalana', 1984),
('Dalas Review', 'Andorrano', 1993),
('Dross', 'Venezuela', 1982);


INSERT INTO libro (isbn, titulo, año_publicacion, num_paginas, precio_catalogo, id_editorial) VALUES 
('9788420471839', 'Asi es la puta vida', 2067, 600, 16.50, 1),
('9788420633145', 'Capitan Calzoncillos', 1999, 220, 12.00, 2),
('9788408035698', 'Sueños de acero y neon', 1963, 450, 14.50, 3),
('9788401352836', 'El libro troll', 2002, 480, 18.00, 1),
('9788420651101', 'Yo soy el Berserk', 1996, 180, 11.50, 2);


INSERT INTO Libro_Autor (isbn, id_autor, rol) VALUES 
('9788420471839', 1, 'principal'),
('9788420633145', 2, 'principal'),
('9788408035698', 3, 'principal'),
('9788401352836', 3, 'principal'),
('9788420651101', 2, 'principal'), 
('9788420633145', 1, 'colaborador');


INSERT INTO Inventario (id_tienda, isbn, stock, fecha_conteo) VALUES 
(1, '9788420471839', 4, '2026-03-02'),
(1, '9788420633145', 2, '2026-03-02'),
(2, '9788420471839', 0, '2026-03-01'),
(2, '9788408035698', 5, '2026-03-02'),
(3, '9788401352836', 3, '2026-03-02'),
(3, '9788420651101', 6, '2026-03-02');

INSERT INTO empleado (dni, nombre, apellidos, cargo, fecha_contratacion, correo, id_tienda) VALUES 
('12345678A', 'Kentaro', 'Miura', 'cajero', '2024-01-15', 'Thegoat@gmail.com', 1),
('87654321B', 'Pedro', 'Sanche', 'librero', '2023-05-10', 'perrosanxe@gmail.com', 2),
('11223344C', 'Octavian', 'Catalin', 'encargado', '2022-11-20', 'rumano@gmail.com', 3);


INSERT INTO cliente (id_cliente, nombre_completo, email, telefono, es_socio, fecha_alta) VALUES 
(1, 'Sergio Adell', 'yo@gmail.com', '600123456', 1, '2025-10-10'),
(2, 'Rayo Mcqueen', 'Elmasrapido@gmail.com', NULL, 0, NULL),
(3, 'Cristiano Ronaldo', 'serre7@gmail.com', '677987654', 1, '2026-01-05');


INSERT INTO pedido (id_pedido, fecha, forma_pago, estado, id_tienda, dni_empleado, id_cliente) VALUES 
(10482, '2026-03-12', 'tarjeta', 'entregado', 1, '12345678A', 1),
(10483, '2026-03-12', 'efectivo', 'preparado', 2, '87654321B', 2),
(10484, '2026-03-13', 'bizum', 'entregado', 3, '11223344C', 3),
(10485, '2026-03-13', 'tarjeta', 'cancelado', 1, '12345678A', 2),
(10486, '2026-03-14', 'efectivo', 'entregado', 2, '87654321B', 1);


INSERT INTO Detalle_Pedido (id_pedido, isbn, cantidad, precio_cobrado) VALUES 
(10482, '9788420471839', 1, 16.50),
(10482, '9788420633145', 2, 12.00),
(10483, '9788408035698', 1, 14.50),
(10484, '9788401352836', 1, 18.00),
(10484, '9788420651101', 2, 11.50),
(10485, '9788420471839', 1, 16.50),
(10486, '9788408035698', 2, 14.50),
(10486, '9788401352836', 1, 18.00);

## 10. Consultas de pruebaa1- ¿Qué libros hay disponibles en el inventario de la tienda "Caserio Colesterol" y cuántas unidades quedan?
    
  Consulta:

SELECT 
    l.titulo, i.stock, i.fecha_conteo
FROM Inventario i
JOIN libro l ON l.isbn = i.isbn
JOIN tienda t ON t.id_tienda = i.id_tienda
WHERE t.nombre = 'Caserio Colesterol';

| titulo | stock | fecha_conteo |
|---|---|---|
| Asi es la puta vida | 4 | 2026-03-02 |
| Capitan Calzoncillos | 2 | 2026-03-02 |

2- ¿Qué libros ha escrito el autor Dross y con qué rol participan?

   Consulta:

SELECT 
   l.titulo, la.rol
FROM Libro_Autor la
JOIN libro l ON l.isbn = la.isbn
WHERE la.id_autor = 3;

| titulo | rol |
|---|---|
| Sueños de acero y neon | principal |
| El libro troll | principal |

3- ¿Qué libros del catálogo pertenecen a la editorial "Anaya"?

   Consulta:
   
SELECT 
    l.titulo, l.precio_catalogo
FROM libro l
JOIN editorial e ON e.id_editorial = l.id_editorial
WHERE e.nombre = 'Anaya';

Resultado esperado:

| titulo | precio_catalogo |
|---|---|
| Asi es la puta vida | 16.50 |
| El libro troll | 18.00 |

4-¿Qué detalles de compra contienen los pedidos atendidos por el empleado "Kentaro Miura"?

   Consulta:
   
SELECT 
    p.id_pedido, p.fecha, dp.isbn, dp.cantidad, dp.precio_cobrado
FROM pedido p
JOIN empleado e ON e.dni = p.dni_empleado
JOIN Detalle_Pedido dp ON dp.id_pedido = p.id_pedido
WHERE e.nombre = 'Kentaro';

   Resultado esperado:
    | id_pedido | fecha | isbn | cantidad | precio_cobrado |
    |---|---|---|---|---|
    | 1 | 2026-03-12 | 9788420471839 | 1 | 16.50 |
    | 1 | 2026-03-12 | 9788420633145 | 2 | 12.00 |
    | 4 | 2026-03-13 | 9788420471839 | 1 | 16.50 |
    
   5-¿Qué clientes de la base de datos son socios y cuál es su fecha de alta?

   Consulta:
    
SELECT 
    nombre_completo, 
    email, 
    fecha_alta
FROM cliente
WHERE es_socio = 1;

   Resultado esperado:
    | nombre_completo | email | fecha_alta |
    |---|---|---|
    | Sergio Adell | yo@gmail.com | 2025-10-10 |
    | Cristiano Ronaldo | serre7@gmail.com | 2026-01-05 |
## 11. Limitaciones y mejoras futuras
