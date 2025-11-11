# Mi primera aplicación web con Spring
## Estructura del proyecto
**Si tuviéramos que subir el proyecto a un repositorio git, ¿qué carpetas y ficheros
crees que deberían ser excluidos?**
Deberíamos excluir la carpeta ***.idea***, que es la que contiene la configuración interna de IntellijIDEA y no es necesaria par la compilación.
También deberíamos excluir la carpeta ***target***, ya que almacena los archivos generados en la compilación. Esta carpeta puede ser bastante pesada y, además, los archivos se vuelven a generar automáticamente cada vez que se compila el proyecto. 

## Programando mi primer proyecto web
**Hemos dicho que Spring utiliza el patrón MVC, ¿qué ficheros corresponden al
modelo, cuáles a la vista y cuáles al controlador? ¿cómo se pasa la
información entre ellos?**
- Modelo: clase User, alojada en el paquete "model".
- Controlador: clase GreetingController, alojada en el paquete "controller".
- Vista: user-greeting.html, que se encuentra en la carpeta resources > templates.

El controlador consulta al modelo, pasa la información a la vista a través de model.addAttribute y devuelve la vista que ha de renderizarse en el navegador. Spring envía los datos al *template* correspondiente con Thymeleaf, donde se recogen y se muestran en la vista.

## Ampliando en proyecto web
**¿De dónde viene el nombre al que se saluda? ¿Qué es username? ¿Forma
parte de la vista, del controlador o del modelo?**
El noombre viene del parámetro username, que se envía a la URL cuando el usuario entra en la web.
Este parámetro forma parte del controlador, que es el que se encarga de recibirlo desde la URL gracias a la anotación @RequestParam(required = false) String username.

## Añadiendo estilos
**¿Dónde está el HTML de las webs? ¿Crees que podrías mejorar el diseño con
CSS, imágenes…? ¿Dónde está el límite?**
Los ficheros HTML se encuentra en la carpeta templates, dentro de resources. 
Sí que es posible mejorar el diseño añadiendo CSS, imágenes y otros recursos estáticos, que han de colocarse en la resources/static.
Aunque es posible mejorar el diseño, Spring Boot está pensado para la lógica del servidor, por lo que si necesitásemos realizar un frontend muy personalizado o avanzado, deberíamos hacerlo con un proyecto independiente, que se comunique con el backend de Spring Boot mediante una API REST.