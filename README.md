# Sistema de Gestión de Biblioteca
Base de datos de una librería con los datos de sus libros,empleados,clientes,pedidos e inventario. Poder gestionarla y poder acceder a ella fácilmente.
## Requisitos
| Software | Versión |Link de descarga|
| :--- | :--- | :--- |
|Eclipse IDE for Java Developers|2026-06 (4.40.0)|https://www.eclipse.org/downloads/packages/|
|JDK(java) 21 |21|https://www.oracle.com/java/technologies/javase/jdk21-archive-downloads.html|
|SQL WorkBench|8.0.46(500> mb)|https://dev.mysql.com/downloads/installer/|
|dotenv-java-3.2.0.jar |dotenv-java-3.2.0.jar ---|https://repo1.maven.org/maven2/io/github/cdimascio/dotenv-java/3.2.0/|
|My sql connector|(mysql-connector-j-26.7.0.zip)|https://dev.mysql.com/downloads/connector/j/?os=26|

## Instalación rápida
Instalar los softwares necesarios
Instalar eclipse
Instalar JDK 21
instalar sql workbench
Instalar las librerías Dotenv y My sql Connector

1. Clonar e Importar Proyecto

    En Eclipse: File ➔ Import... ➔ Git ➔ Projects from Git ➔ Clone URI

    URI: [https://github.com/ChinCobre/TrabajoFINAL.git](https://github.com/ChinCobre/TrabajoFINAL.git)

2. Inicializar Base de Datos

    Abrir MySQL Workbench y ejecutar el script localizado en sql/init.sql para crear la base de datos biblioteca y cargar los datos iniciales.

3. Configurar Entorno (.env)

    Renombrar .env.example a .env en la raíz del proyecto.

    Configurar credenciales de MySQL:
    

    DB_HOST=localhost
    DB_PORT=3306
    DB_DATABASE=biblioteca
    DB_USERNAME=tu_usuario
    DB_PASSWORD=tu_contraseña

4. Build Path & Ejecución

    En Eclipse: Clic derecho en proyecto ➔ Build Path ➔ Configure Build Path... ➔ Libraries ➔ Classpath ➔ Add External JARs...

    Añadir dotenv-java-3.2.0.jar y mysql-connector-j.jar.

    Ejecutar la clase principal en src/ ➔ Run As ➔ Java Application.


## Configuración (.env)
Click derecho en el proyecto de eclipse, Resource y click en el icono que es una flecha y carpeta
Os abrira la carpeta del proyecto, doble click en ProyectoFINAL 
Una vez dentro el archivo env.example quitamos el .example y modificamos los datos con los nuestros.


## Documentación
- [Manual de despliegue completo (PDF)](ProyectoFINAL/doc/manual_despliegue.pdf)
- [JavaDoc](ProyectoFINAL/doc/javadoc/index.html)
## Autores
Sergio Adell

Octavian Catalin Palu

