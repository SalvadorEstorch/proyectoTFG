# README

Esta proyecto se ha creado cómo TFG para el grado de DAW. 

A continuación se explican los pasos para montar la aplicación:

### Descargar la App

Para comenzar se descarga el proyecto en formato zip o clonándolo a nuestro workspace.

```bash
git clone https://github.com/SalvadorEstorch/proyectoTFG.git
```

### Configurar MySQL

Ahora debemos abrir **MySQL** y hacer lo siguiente:

1. Crear la bbdd. 
    
    ```sql
    CREATE DATABASE proyecto_eventos;
    ```
    
2. Usar la bbdd recién creada. 
    
    ```sql
    USE proyecto_eventos;
    ```
    

### Importar a Eclipse

A continuación debemos importarlo en eclipse.

Una vez importado debemos revisar el archivo de **application.properties** ya que es probable que se tengamos que modificar alguna de ellas.

```html
spring.datasource.url=jdbc:mysql://localhost:3306/proyecto_eventos
spring.datasource.username = root
spring.datasource.password = root

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL5InnoDBDialect

spring.thymeleaf.cache=false
spring.servlet.multipart.max-file-size=100MB

storage.location=assets
```

Tanto el puerto del **localhost** cómo el **usuario** y **password** de la BBDD pueden cambiar en función de la configuración que tengamos.

Hecho esto podemos arrancar el proyecto. Al hacerlo veremos que se nos crean en **MySQL** todas las tablas de proyecto.
Ahora si vamos a **[localhost:8080](http://localhost:8080)** veremos la aplicación en modo invitado. Y si nos registramos se nos asignará automáticamente un rol de usuario con el que podremos hacer reservas. 

### Entrar cómo administrador

Para entrar a la parte de administración necesitamos un usuario cuyo rol sea de administrador. 
Para ello vamos a usar uno de los usuarios que tenemos ya creados, si aún no hemos registrado ninguno es el momento de hacerlo.

A continuación iremos a **MySQL** y crearemos un rol de administrador usando el siguiente comando:

```sql
INSERT INTO rol (nombre) 
VALUES ('ROLE_ADMIN');
```

Ahora miraremos en la tabla de roles el **id** de este nuevo rol, y en la tabla de usuarios el **id** del usuario al que queramos dar permisos de administrador.
Con estos dos **ids** haremos el siguiente comando:

```sql
UPDATE usuarios_roles
SET rol_id = 2 //id del rol que acabamos de crear
WHERE usuario_id = 4; //id del usuario que queremos hacer admin
```

Y ya podemos entrar a la app cómo administradores usando este usuario.
