package queueHandler.handler;


import umg.edu.gt.data_structure.queue.manual.QueueLinked;

public class App {

    public static void main(String[] args) {

        QueueLinked<Song> highPriority = new QueueLinked<>();
        QueueLinked<Song> normalPriority = new QueueLinked<>();

        // Crear canciones
        highPriority.enqueue(new Song("Stairway to Heaven", "Led Zeppelin", 8, 1));
        highPriority.enqueue(new Song("Billie Jean", "Michael Jackson", 6, 1));
        normalPriority.enqueue(new Song("Wonderwall", "Oasis", 10, 2));

        // Ejecutar demo de reproducción
        QueueDemo demo = new QueueDemo();
        demo.playPlaylist(highPriority, normalPriority);
    }
}