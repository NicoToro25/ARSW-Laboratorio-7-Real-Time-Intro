package edu.eci.arsw.introWebsockets.endpoints;

import java.io.IOException;
import java.util.logging.Level;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.logging.Logger;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import org.springframework.stereotype.Component;

// Esta clase define un endpoint WebSocket usando javax.websocket, permite a múltiples clientes conectarse al servidor y recibir mensajes en tiempo real.

@Component // Permite que Spring detecte esta clase como un bean gestionado.
@ServerEndpoint("/timer") // Expone este endpoint WebSocket en la URL "/timer"
public class TimerEndpoint {

    private static final Logger logger = Logger.getLogger("ETFEndpoint"); // Imprime mensajes en consola

    static Queue<Session> queue = new ConcurrentLinkedQueue<>(); // Una cola concurrente que guarda todas las sesiones de WebSocket activas (clientes conectados)

    // Es un método que envía mensaje de texto a todos los clientes conectados.
    public static void send(String msg) {
        try {
            // Recorre la queue de sesiones y envía el mensaje
            for (Session session : queue) {
                session.getBasicRemote().sendText(msg);
                logger.log(Level.INFO, "Sent: {0}", msg);
            }
        } catch (IOException e) {
            logger.log(Level.INFO, e.toString()); // Registra el error
        }
    }

    // Se ejecuta automáticamente cuando un cliente se conecta al WebSocket
    @OnOpen
    public void openConnection(Session session) {
        queue.add(session); // Agrega la sesión del cliente a la queue
        logger.log(Level.INFO, "Connection opened."); // Envía mensaje de bienvenida
        try {
            session.getBasicRemote().sendText("Connection established.");
        } catch (IOException ex) {
            Logger.getLogger(TimerEndpoint.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
    }

    // Se ejecuta cuando un cliente cierra la conexión
    @OnClose
    public void closedConnection(Session session) {
        queue.remove(session); // Elimina la sesión de la queue
        logger.log(Level.INFO, "Connection closed.");
    }

    // Se ejecuta si ocurre un error en la conexión WebSocket
    @OnError
    public void error(Session session, Throwable t) {
        queue.remove(session); // Elimina la sesión afectada de la queue
        logger.log(Level.INFO, t.toString());
        logger.log(Level.INFO, "Connection error."); // Muestra que hubo un error
    }
}
