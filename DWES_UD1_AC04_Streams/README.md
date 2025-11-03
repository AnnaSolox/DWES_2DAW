# STREAMS EN JAVA

## Ejercicio 1
Sobre el código fuente que se te proporciona (Ejercicio1.java), aplica los siguientes cambios en el programa principal "main", utilizando streams en todos los casos:

1. Obtener un sublistado con las películas estrenadas en el siglo XXI (a partir del año 2000, inclusive).
2. Mostrar por pantalla, separados por comas, los títulos de las películas de Steven Spielberg.
3. Obtener un sublistado con los nombres de las películas, ordenados alfabéticamente.
4. Mostrar por pantalla el año de estreno más reciente.

## Ejercicio 2
Vas a crear una mini-app que lea un fichero canciones.txt con este formato:
```
Título:Artista:DuraciónSegundos:Reproducciones
As It Was:Harry Styles:168:950000000
Flowers:Miley Cyrus:200:1200000000
Eyes Closed:Ed Sheeran:210:870000000
Dance The Night:Dua Lipa:197:730000000
Anti-Hero:Taylor Swift:200:1600000000
```

Tu programa debe:
1. Leer el fichero y convertir cada línea en objetos Cancion.
2. Filtrar canciones cuyo tiempo total escuchado (duración × reproducciones) supere 10 minutos (600 s).
3. Calcular la duración media de todas las canciones.
4. Encontrar la más reproducida y la menos reproducida.
5. Ordenar por reproducciones (desc) y generar un ranking Top 3 como una cadena con Collectors.joining("\n").
6. Guardar el ranking y estadísticas en ranking.txt.
7. (Opt.) Añadir una canción nueva desde consola y re-generar el ranking.

Debes usar Streams: filter, map, sorted, limit, collect, joining, mapToInt/mapToLong, average, min/max.