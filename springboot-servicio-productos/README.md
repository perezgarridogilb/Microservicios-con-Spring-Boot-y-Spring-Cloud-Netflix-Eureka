# Microservicios-con-Spring-Boot-y-Spring-Cloud-Netflix-Eureka
Curso de Java

## Añadiendo la clase Entity Producto
```
spring.application.name=servicio-productos
server.port=8001
```
![FireShot Capture 040 - Microservicios con Spring Boot y Spring Cloud Netflix Eureka - Udemy_ - www udemy com](https://github.com/perezgarridogilb/Microservicios-con-Spring-Boot-y-Spring-Cloud-Netflix-Eureka/assets/56992179/4d7f1f16-e63f-451b-99ec-336ea6228df9)

## Creating Eureka registry server
Estamos configurando a item y productos como clientes de eureka

### Eureka tiene un dashboard
<img width="1392" alt="Captura de Pantalla 2023-08-06 a la(s) 6 15 41 p m" src="https://github.com/perezgarridogilb/Sistema-Contable-con-Laravel/assets/56992179/db436dff-75ea-4b4f-98a2-2cd8705dcb91">

### Sirviendo con Eureka
Ereka maneja Ribbon de manera ímplicita y no es necesario importarlo ahora
<img width="1392" alt="Captura de Pantalla 2023-08-06 a la(s) 6 18 20 p m" src="https://github.com/perezgarridogilb/Sistema-Contable-con-Laravel/assets/56992179/754c5eaa-6ff7-4e4a-9f5a-28e134fcb8c0">

## Scale microservices with dynamic port
El servidor de eureka se encarga de manipular los parámetros del balanceo de carga en automático

### Se lanzaron 3 instancias de productos
<img width="1392" alt="Captura de Pantalla 2023-08-06 a la(s) 10 12 03 p m" src="https://github.com/perezgarridogilb/Sistema-Contable-con-Laravel/assets/56992179/2564e906-a3ae-40a3-be8c-53de8b071644">

### En automático nos podemos conectar a una de ellas
- El puerto es un random de estas instancias
<img width="1392" alt="Captura de Pantalla 2023-08-06 a la(s) 10 11 09 p m" src="https://github.com/perezgarridogilb/Sistema-Contable-con-Laravel/assets/56992179/f6d16cb0-7749-4940-8c3d-81a54d147235">
- Se puede observar que va cambiando el puerto
<img width="1392" alt="Captura de Pantalla 2023-08-06 a la(s) 10 11 23 p m" src="https://github.com/perezgarridogilb/Sistema-Contable-con-Laravel/assets/56992179/2e6e40a6-c2b2-41db-bf24-551de4df27f3">

- Estos parámetros nos ayudaron
```
server.port=${PORT:0}

eureka.instance.instance-id=${spring.
```

## Hystrix
Hystrix es una biblioteca de Netflix que proporciona tolerancia a fallos

En vez de lanzar el error lo maneja con torelancia a fallos, una especie de item por defecto

###

Basado en `http://localhost:8002/ver/2/cantidad/5`

- Con producto prendido:
```
    "producto": {
        "id": 2,
        "nombre": "Sony",
        "precio": 700.0,
        "createAt": "2023-08-08T00:00:00.000+00:00",
        "port": 8001
    }
```

- Con producto apagado:
```
    "producto": {
        "id": 2,
        "nombre": "Camara Sony",
        "precio": 500.0,
        "createAt": null,
        
```

- **Link**: https://cloud.spring.io/spring-cloud-static/spring-cloud-netflix/2.0.1.RELEASE/single/spring-cloud-netflix.html#_hystrix_timeouts_and_ribbon_clients

When using Hystrix commands that wrap Ribbon clients you want to make sure your Hystrix timeout is configured to be longer than the configured Ribbon timeout, including any potential retries that might be made. For example, if your Ribbon connection timeout is one second and the Ribbon client might retry the request three times, than your Hystrix timeout should be slightly more than three seconds.

## 
Mediante zuul y con balanceo de carga
*Un API Gateway (Puerta de Enlace de API) es un componente en la arquitectura de microservicios que actúa como un punto de entrada para todas las solicitudes de API provenientes de clientes externos. Su principal función es gestionar y dirigir las solicitudes entrantes a los diferentes microservicios y recursos internos de una aplicación, proporcionando una capa de abstracción entre los clientes y los servicios subyacentes*

- Se configuró en: `http://localhost:8761/`
<img width="1280" alt="Captura de Pantalla 2023-08-08 a la(s) 4 53 13 p m" src="https://github.com/perezgarridogilb/Sistema-Contable-con-Laravel/assets/56992179/c354fb34-fcf3-4ea1-8fd1-19a9e7501135">
- Cambia la puerta de enlace de cómo de venía trabajando en items y en productos
<img width="1392" alt="Captura de Pantalla 2023-08-08 a la(s) 4 57 39 p m" src="https://github.com/perezgarridogilb/Sistema-Contable-con-Laravel/assets/56992179/7489d712-ecb1-4326-ba05-154550438164">
- Cambia la puerta de enlace de cómo de venía trabajando
<img width="1392" alt="Captura de Pantalla 2023-08-08 a la(s) 4 55 13 p m" src="https://github.com/perezgarridogilb/Sistema-Contable-con-Laravel/assets/56992179/32730584-6d1d-44f4-9763-7f396c798438">
