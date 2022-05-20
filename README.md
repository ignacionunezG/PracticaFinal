# Practica Final - Ignacio Núñez y Alejandro Valbuena

Para la practica final de la asignatura de programación de aplicaciones telemáticas, hemos llevado a cabo una aplicación de gestión de parking en la ciudad de Madrid con la voluntad de solucionar un problema existente en dicha ciudad como es la dificultad que existe para encontrar un sitio libre y su posterior cobro del estacionamiento regulado.

Link a Github pages:
-https://ignacionunezg.github.io/PracticaFinal/

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
Se ha realizado un testing de la aplicación con test E2E para los endpoints empleados. Las dependencias utilizadas son: 
Spring Web, JDBC, Lombok, H2 Databases, Spring Security.

Hemos tenido muchos problemas en la realización de los FETCH . No hemos conseguido que se realizasen correctamente, y no sabemos la razón todavía. Lo hemos intentado pero somos conscientes de que esa parte está por mejorar. No se pueden realizar POSTs ni GETs correctamente, de ahí que no hayamos podido verificar que el funcionamiento de los Javascript sea correcto. Esperamos conseguir solucionarlo cuanto antes, pero por el momento no lo hemos conseguido. Como no se realizan correctamente, no se puede hacer un Log In directamente y no se puede acceder a las páginas de la aplicación desde el Log In, por lo que este es el link para poder acceder al mapa.html:

https://github.com/ignacionunezG/PracticaFinal/blob/main/madPark/src/main/resources/static/html/mapa.html

Ya a partir de mapa.html se puede acceder a todas las vistas.

## Créditos
Ayuntamiento de Madrid

Bootstrap

SpringBoot



