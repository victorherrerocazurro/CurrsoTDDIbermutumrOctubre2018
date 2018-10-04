
# Requisito (Metainformacion)

Se desea tener un formulario HTML que permita ejecutar el algortimo de particion de nombres completos en nombre y apellido, obteniendo como resultado una tabla HTML con esos datos.

## Ejemplos

### Given (Dado)

Dado el nombre [Victor Herrero](- "#nombreCompleto")

### When (Cuando)

la ejecucion del algoritmo de [particion](- "#resultadoDeLaParticion = partir(#nombreCompleto)"), 

### Then (Entonces tenemos)

deberia retornar [Victor](- "?=#resultadoDeLaParticion.nombre") como nombre y  [Herrero](- "?=#resultadoDeLaParticion.apellido") como apellido.

### Otro Ejemplo (para forzar a que la implementacion del servicio sea correcta y no retorne ctes)

Dado el nombre [Laura Garcia](- "#nombreCompleto") la ejecucion del algoritmo de [particion](- "#resultadoDeLaParticion = partir(#nombreCompleto)"),  deberia retornar [Laura](- "?=#resultadoDeLaParticion.nombre") como nombre y  [Garcia](- "?=#resultadoDeLaParticion.apellido") como apellido.

### Con Tablas

| Nombre completo          | Nombre						| Apellido 						|
| ---------------          | --------------- 			| --------------- 				|
| [John Smith][accion]     | [John][nombreEsperado]   	| [Smith][apellidoEsperado] 	|
| [David Peterson][accion] | [David][nombreEsperado]  	| [Peterson][apellidoEsperado] 	|

[accion]: - "#resultadoDeLaParticion = partir(#TEXT)"
[nombreEsperado]: - "?=#resultadoDeLaParticion.nombre"
[apellidoEsperado]:  - "?=#resultadoDeLaParticion.apellido"





