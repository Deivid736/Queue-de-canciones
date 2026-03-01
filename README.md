Queue de Canciones

Este proyecto implementa una estructura de datos Queue (Cola) personalizada utilizando una lista enlazada genérica (QueueLinked<T>).
La aplicación está dividida en dos módulos:
•	Queue: Librería que contiene la implementación de la estructura de datos.
•	queueHandler:  Aplicación que utiliza la librería para simular una playlist de canciones con prioridad.
El sistema permite reproducir canciones respetando el orden FIFO y manejando prioridad mediante colas separadas.

¿Cómo compilar la librería?
1.	Entro a la consola.
2.	Me ubico en la carpeta del módulo queue (la librería).
3.	Escribo el comando mvn clean install y presiono Enter.
Este comando compila la librería y la instala en el repositorio local de Maven (.m2), permitiendo que otros proyectos la utilicen como dependencia.

¿Cómo instalar en local?
No se necesita un paso adicional, ya que al ejecutar mvn clean install la librería queda automáticamente instalada en el repositorio local.
Esto permite que el módulo queueHandler pueda utilizarla como dependencia.

¿Cómo compilar el handler?
1.	Entro a la consola.
2.	Me ubico en la carpeta del módulo queueHandler.
3.	Escribo el comando mvn clean install y presiono Enter.
Con esto se compila la aplicación utilizando la librería previamente instalada.

¿Cómo ejecutar desde consola?
Para ejecutar el programa utilizando Maven:
1.	Entro a la consola.
2.	Me ubico dentro de la carpeta queueHandler.
3.	Escribo el siguiente comando y presiono Enter:
mvn exec:java -Dexec.mainClass="queueHandler.handler.App"
También se puede ejecutar el archivo JAR generado:
1.	Entro a la carpeta target dentro de queueHandler.
2.	Escribo el siguiente comando y presiono Enter:
java -cp queueHandler-1.0-SNAPSHOT.jar queueHandler.handler.App

Explicación del diseño.
El proyecto sigue el principio de separación de responsabilidades.
Estructura principal:
•	QueueLinked<T>: Implementación de la cola utilizando lista enlazada.
•	Node<T> : Nodo interno que almacena el valor y la referencia al siguiente nodo.
•	Song : Representa una canción con título, duración y prioridad.
•	QueueDemo: Contiene la lógica de reproducción.
•	App: Punto de entrada del programa.
Cada clase cumple una función específica, lo que facilita el mantenimiento y mejora la organización del código.

Decisiones técnicas.
Uso de genéricos
La clase QueueLinked<T> fue implementada utilizando genéricos para permitir que la estructura pueda trabajar con cualquier tipo de dato, no solamente canciones.
Uso de lista enlazada
Se eligió una lista enlazada porque:
•	Permite insertar elementos en tiempo constante O(1).
•	Permite eliminar elementos en tiempo constante O(1).
•	No requiere redimensionamiento dinámico como ocurre con los arreglos.

Separación en módulos.
Se separó la estructura de datos de la aplicación que la utiliza para:
•	Reutilizar la cola en otros proyectos.
•	Mantener una arquitectura más organizada.
•	Facilitar mantenimiento y pruebas.

¿Cómo implementé la prioridad?
La prioridad se implementó utilizando dos colas independientes:
•	Una cola para canciones de alta prioridad.
•	Una cola para canciones de prioridad normal.
Cuando se agrega una canción:
•	Si tiene prioridad alta, se agrega a la cola de alta prioridad.
•	Si tiene prioridad normal, se agrega a la cola normal.

Al momento de reproducir.
1.	Primero se vacía completamente la cola de alta prioridad.
2.	Luego se reproducen las canciones de la cola normal.
Dentro de cada cola se mantiene el orden FIFO.

¿Cómo manejé la simulación de duración?
La duración de cada canción se simuló utilizando Thread.sleep(1000) dentro de un ciclo.
Cada iteración del ciclo representa un segundo de reproducción.
También se implementó un método que genera una barra de progreso en consola, mostrando visualmente el avance de la canción en proporción a su duración.
Ejemplo de salida:
[=====-----] 5s / 10s
Esto permite simular el comportamiento real de una playlist en ejecución.

Complejidad
Las operaciones principales de la cola tienen las siguientes complejidades:
•	enqueue → O(1)
•	dequeue → O(1)
•	peek → O(1)
•	size → O(1)
