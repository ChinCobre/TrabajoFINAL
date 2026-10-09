# Base de datos de Páginas de Villa Serena

## 1. Resumen del caso
Páginas de Villa Serena abrió hace veinte años como una pequeña tienda de barrio. Hoy tiene tres tiendas: Centro, Ribera y Universidad. Cada una tiene su nombre, su dirección, su teléfono y su ciudad (Ribera está en el pueblo vecino de Aldeaverde).

## 2. Análisis del caso

### 2.1 Entidades y atributos

| Entidad | Atributos encontrados | Fragmento del texto |
|:---|:---|:---|
| Tienda | id_tienda, nombre, direccion, telefono, ciudad | La librería cuenta con tres tiendas: Centro, Ribera y Universidad. De cada tienda se guarda su nombre, dirección, teléfono y ciudad. |
| Empleado | dni, nombre, apellidos, cargo, fecha_contratacion, correo, __id_tienda FK__ | De cada empleado se registra el DNI, nombre, apellidos, puesto, fecha de contratación y correo electrónico. Cada empleado trabaja en una tienda. |
| Cliente | id_cliente, nombre_completo, email, telefono, es_socio, fecha_alta | Se registran los clientes, tanto socios como no socios, con su nombre y correo electrónico. |
| Editorial | id_editorial, nombre, pais, telefono | De cada editorial se guarda el nombre, país y teléfono de contacto. |
| Libro | isbn, titulo, año_publicacion, num_paginas, precio_catalogo, __id_editorial FK__ | Cada libro se identifica por su ISBN de 13 dígitos y se guarda su título, año de publicación, número de páginas y precio de catálogo. Cada libro pertenece a una editorial. |
| Autor | id_autor, nombre, nacionalidad, año_nacimiento | De cada autor se registra el nombre, nacionalidad y año de nacimiento. |
| Libro_Autor | __isbn FK__, __id_autor FK__, rol | Un libro puede tener varios autores y cada autor puede escribir varios libros. Se indica si el autor es principal o colaborador. |
| Inventario | __id_tienda FK__, __isbn FK__, stock, fecha_conteo | Para cada combinación de libro y tienda se registra el stock y la fecha del último recuento. |
| Pedido | id_pedido, fecha, forma_pago, estado, __id_tienda FK__, __dni_empleado FK__, __id_cliente FK__ | Cada pedido se realiza en una tienda, lo gestiona un empleado y corresponde a un cliente. Se registra la fecha, forma de pago y estado. |
| Detalle_Pedido | __id_pedido FK__, __isbn FK__, cantidad, precio_cobrado | Los pedidos pueden contener varios libros y se registra la cantidad de cada uno y el precio realmente cobrado. |



### 2.2 Relaciones y cardinalidades

| Relación | Cardinalidad | Justificación |
|:---|:---:|:---|
| Tienda – Empleado | 1:N | Una tienda puede tener varios empleados y cada empleado trabaja en una sola tienda. |
| Editorial – Libro | 1:N | Una editorial puede publicar muchos libros, pero cada libro pertenece a una única editorial. |
| Libro – Autor | N:M | Un libro puede tener varios autores y un autor puede escribir varios libros. Se resuelve con la tabla Libro_Autor. |
| Tienda – Libro | N:M | Una tienda puede tener muchos libros y un libro puede estar disponible en varias tiendas. Se resuelve con la tabla Inventario. |
| Tienda – Pedido | 1:N | Una tienda puede registrar muchos pedidos, pero cada pedido se realiza en una sola tienda. |
| Empleado – Pedido | 1:N | Un empleado puede gestionar muchos pedidos, pero cada pedido lo gestiona un único empleado. |
| Cliente – Pedido | 1:N | Un cliente puede realizar muchos pedidos, pero cada pedido corresponde a un único cliente. |
| Pedido – Libro | N:M | Un pedido puede incluir varios libros y un libro puede aparecer en muchos pedidos. Se resuelve con la tabla Detalle_Pedido. |



### 2.3 Datos descartados

| Dato | Decisión | Motivo |
|:---|:---|:---|
| Total del pedido | No se almacena. | Se calcula sumando __cantidad * precio_cobrado__. |
| Precio pagado en ventas anteriores | Se guarda en __Detalle_Pedido__ | El precio de catálogo puede cambiar; así se conserva el precio realmente cobrado en cada venta. |
| Lista de autores en un único campo | No se almacena en __Libro__. | Se utiliza __Libro_Autor__ para representar la relación entre libros y autores. |
| Datos de la editorial repetidos en cada libro | Se almacenan en __Editorial__. | Se evita duplicar el nombre, país y teléfono de una misma editorial. |
| Stock de cada libro por tienda | Se almacena en __Inventario__. | La cantidad disponible depende de la combinación de libro y tienda. |
| Historial de traslados de empleados | No se almacena. | El caso indica que no es necesario registrar los cambios de tienda de los empleados. |
| Total de ventas por tienda | No se almacena. | Se calcula a partir de los pedidos y sus detalles para el periodo solicitado. |
| Tabla independiente para socios | No se crea. | Se utiliza __Cliente__ con el atributo __es_socio__ para distinguir a los socios de los no socios. |

## 3. Reglas de negocio
## 4. Diagrama entidad-relación



## 5. Modelo lógico
## 6. Script SQL (schema.sql)
## 7. Diccionario de datos
## 8. Decisiones de diseño
## 9. Datos de prueba
## 10. Consultas de prueba
## 11. Limitaciones y mejoras futuras