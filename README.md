# Proyecto ficohsa-practica

## Contenido

- [Tecnologias](#Tecnologias)
- [Arquitectura](#Arquitectura)
- [Instalacion](#Instalacion)
- [Api](#Api)
- [Datos de prueba](#Datos)
- [Licencia](#Licencia)

# Tecnologias

* [Java 11] - Lenguaje de programacion
* [SpringBoot 2.7.0] - Plataforma de desarrollo
* [apache-maven-3.8.2] - Manejo dependencias 
* [IntelliJ IDEA 2021.2.1 (Community Edition)] - Ide de Desarrollo
* [Docker] - Virtualizacion BD (Opcional)
* [PostgreSQL] - Base de datos
* [Git] - Versionado
* [GitHub] - Repositorio
* [Swagger] - Documentacion


# Arquitectura

- Desarrollo SpringBoot, modelo MVC, Tomcat Embebido

# Instalacion

- Se necesita tener lo siguiente

| Requiere |  |
| ------ | ------ |
| Java 11 | https://www.oracle.com/java/technologies/javase/jdk11-archive-downloads.html |
| Git | https://git-scm.com/downloads |
| Maven | https://maven.apache.org/download.cgi |
| Postgresql | https://www.postgresql.org/download/ |
| Docker | https://www.docker.com/products/docker-desktop/ |

Con los paquetes listos, proceder a clonar el repositorio
```sh
git clone https://github.com/e972136/ficohsa-practica.git
```

Desde la terminal de IntelliJ (o directorio raiz)
```sh
mvn clean install
```

# Api

- El puerto por defecto es 8081 (por si el nativo 8080 esta ocupado)
- Hay una instancia en Heroku

| DESCRIPCION | URL | Peticion | Respuesta
| ------ | ------ | ------ | ------ |
| Servicio Validar Mutante | localhost:8081/mutant |  Post  | 200 Valida / 403 Humano
| Servicio Estadisticas | localhost:8081/stats |  Get  | JSON

# Datos

- /mutant

- Para Mutante

Request:
{
  "dna": ["ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"]
}

Response: 200 - ok

- Para Humano

Request:
{
  "dna": ["ATGCGA","CXGTXC","TTATGT","AGAAGG","XCXCAA","TCACTA"]
}

Response: 403 - Forbiden

- /stats

Response:

{
  "count_mutant_dna": 0,
  "count_human_dna": 0,
  "ratio": 0
}

# Licencia

Libre distribucion
