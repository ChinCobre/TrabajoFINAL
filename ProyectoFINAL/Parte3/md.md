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

## 6. Script SQL (schema.sql)

## 7. Diccionario de datos

## 8. Decisiones de diseño

## 9. Datos de prueba

## 10. Consultas de prueba

## 11. Limitaciones y mejoras futuras
