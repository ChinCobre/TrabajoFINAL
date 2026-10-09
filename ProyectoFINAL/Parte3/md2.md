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


### 2.2 Relaciones



### 2.3 Datos descartados
## 3. Reglas de negocio
## 4. Diagrama entidad-relación
## 5. Modelo lógico
## 6. Script SQL (schema.sql)
## 7. Diccionario de datos
## 8. Decisiones de diseño
## 9. Datos de prueba
## 10. Consultas de prueba
## 11. Limitaciones y mejoras futuras