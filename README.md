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

### Agregar eventos de prueba

Para no tener que empezar de cero y meter los registros manualmente se puede usar este script para rellenarla con varios eventos.

```sql
INSERT INTO eventos (activo, aforo_max, ciudad, descripcion_e, destacado, direccion, duracion, fecha_inicio, minimo_asistencia, nombre_e, precio_decimal, ruta_portada, tipo, youtube_trailer_id)
VALUES 
  (1, 100, 'Madrid', 'Concierto de rock en el estadio principal de la ciudad. Disfruta de las mejores bandas de rock en vivo. ¡No te lo pierdas!', 'S', 'Calle Principal 123', 120, '2023-06-15', 50, 'Concierto de Rock', 29.99, 'concierto1.jpg', 'Concierto', 'qM0hMs1oMfI'),
  (1, 200, 'Barcelona', 'Concierto de música electrónica en el centro de la ciudad. Baila al ritmo de los mejores DJs internacionales. ¡Una noche llena de energía y diversión!', 'S', 'Avenida Central 456', 180, '2023-07-20', 100, 'Concierto de Música Electrónica', 39.99, 'concierto2.jpg', 'Concierto', 'qM0hMs1oMfI'),
  (1, 50, 'Valencia', 'Concierto acústico en un íntimo café de la ciudad. Disfruta de la música en vivo en un ambiente relajado y acogedor. ¡Una experiencia única para los amantes de la música!', 'S', 'Plaza Principal 789', 90, '2023-08-10', 20, 'Concierto Acústico', 19.99, 'concierto3.jpg', 'Concierto', 'qM0hMs1oMfI'),
  (1, 300, 'Sevilla', 'Concierto de música clásica en el teatro local. Disfruta de la majestuosidad de la música clásica interpretada por renombradas orquestas y solistas. ¡Una experiencia cultural inigualable!', 'S', 'Calle Secundaria 321', 120, '2023-09-05', 150, 'Concierto Música Clásica', 49.99, 'concierto4.jpg', 'Concierto', 'qM0hMs1oMfI'),
  (1, 80, 'Bilbao', 'Concierto de jazz en el emblemático club de jazz de la ciudad. Sumérgete en el mundo del jazz con las improvisaciones y melodías envolventes de reconocidos músicos. ¡Una noche llena de magia y talento!', 'S', 'Avenida Principal 987', 150, '2023-10-15', 40, 'Concierto de Jazz', 24.99, 'concierto5.jpg', 'Concierto', 'qM0hMs1oMfI'),
  (1, 150, 'Madrid', 'Concierto de música pop en el estadio principal de la ciudad. Disfruta de los éxitos más recientes de tus artistas favoritos en vivo. ¡Una fiesta asegurada!', 'S', 'Calle Principal 789', 120, '2023-11-20', 75, 'Concierto de Música Pop', 34.99, 'concierto6.jpg', 'Concierto', 'qM0hMs1oMfI'),
  (1, 120, 'Barcelona', 'Concierto de música latina en el centro de la ciudad. Baila al ritmo de los ritmos latinos más populares interpretados por artistas reconocidos. ¡Una noche llena de sabor y alegría!', 'S', 'Avenida Central 012', 150, '2023-12-10', 60, 'Concierto de Música Latina', 29.99, 'concierto7.jpg', 'Concierto', 'qM0hMs1oMfI'),
  (1, 200, 'Valencia', 'Concierto de hip-hop en un gran recinto de la ciudad. Disfruta de las rimas y los beats de los mejores artistas del género. ¡Una explosión de energía y talento!', 'S', 'Plaza Principal 345', 180, '2024-01-15', 100, 'Concierto de Hip-Hop', 39.99, 'concierto8.jpg', 'Concierto', 'qM0hMs1oMfI'),
  (1, 80, 'Sevilla', 'Concierto de música indie en un local alternativo de la ciudad. Descubre nuevas bandas y sonidos en un ambiente underground. ¡Una experiencia para los amantes de la música independiente!', 'S', 'Calle Secundaria 567', 90, '2024-02-20', 40, 'Concierto de Música Indie', 19.99, 'concierto9.jpg', 'Concierto', 'qM0hMs1oMfI'),
  (1, 150, 'Bilbao', 'Concierto de música country en un salón de eventos rural. Sumérgete en el ambiente del country y disfruta de melodías nostálgicas y ritmos pegajosos. ¡Una noche de música y diversión al estilo del oeste!', 'S', 'Avenida Principal 890', 120, '2024-03-10', 50, 'Concierto de Música Country', 29.99, 'concierto10.jpg', 'Concierto', 'qM0hMs1oMfI');
```
