# Practica Final - Ignacio Núñez y Alejandro Valbuena

Para la practica final de la asignatura de programación de aplicaciones telemáticas, hemos llevado a cabo una aplicación de gestión de parking en la ciudad de Madrid con la voluntad de solucionar un problema existente en dicha ciudad como es la dificultad que existe para encontrar un sitio libre y su posterior cobro del estacionamiento regulado.

## Flujo habitual de Madpark
- Inicio


Cuando un usuario entra en nuestra aplicación, la primera página que ve le ofrecerá tres opciones: Iniciar sesión, Registrarse y un apartado About us. 
Las dos primeras opciones, dirigen la página a menús, cada uno lleva a cabo su función respectiva: o bien introducri usuario y contraseña o bien crear un nuevo usuraio e introducir los datos personales y bancarios básicos. Por otra parte, la pestaña About us muestra un breve resumen de la educación de los dos estudiantes que han creado este proyecto, así como sus LinkedIn y el GitHub del mismo.

- Mapa

Si los datos introducidos por el usuario pasan la comprobación, se le dirige a una página en la que puede visualizar una API del Ayuntamiento de Madrid que permite visualizar la disponibilidad en tiempo real de plazas de aparcamiento, así como un conjunto de webcams de la zona.
Haciendo click en el botón estacionar, se dirige a la gestión del parking.

- Estacionar

En esta ventana, el usuario, conocedor de la disponibilidad real de aparcamientos, introducirá la zona donde finalemnte ha decidido aparcar. Tras pulsar Iniciar estacionamiento, se inicia un contador que calcula el tiempo total del estacionameinto. Una vez finalizado, se dirige un menú que visualiza el historial de parkings del usuario a la espera de que se confirme el cobro. Una vez confirmado, se puede volver al mapa y repetir el proceso, o por el contraio cerrar sesión.

## Anotaciones técnicas
Se ha realizado un testing de la aplicación con test E2E para los endpoints empleados. Las dependencias utilizadas son: Spring Web, JDBC, Lombok, H2 Databases, Spring Security.

## Créditos
Ayuntamiento de Madrid

Bootstrap

SpringBoot



