package edu.eci.arsw.introWebsockets.components;

import edu.eci.arsw.introWebsockets.endpoints.TimerEndpoint;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/*
Esta clase define un componente que envía mensajes automáticamente a todos los clientes WebSocket cada 5 segundos usando
le endpoint ya creado (TimerEndpoint)

Broker (Intermediario o gestor): Encargado de recibir, dirigir o distribuir mensajes entre productores y consumidores.
*/

@Component // Detecta esta clase como un Bean y la gestiona
@Scope("singleton") // Solo se crea una instancia de esta clase en toda la aplicación
public class TimedMessageBroker {

    private static final SimpleDateFormat dateFormat = new
            SimpleDateFormat("HH:mm:ss"); //Define el formato de hora que usarán los mensajes enviados
    private static final Logger logger =
            Logger.getLogger(TimedMessageBroker.class.getName()); //Registra eventos en consola

    // Broadcast: Enviar mensajes a todos los clientes conectados
    @Scheduled(fixedRate = 5000) // Se ejecuta cada 5 segundos
    public void broadcast() {
        logger.log(Level.INFO, "broadcastingMessages"); // Se registra en log
        TimerEndpoint.send("The time is now " + dateFormat.format(new Date())); // Se llama al endpoint para que envíe el mensaje a todos los clientes conectados.
    }
}
