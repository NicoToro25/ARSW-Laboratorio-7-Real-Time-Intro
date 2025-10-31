package edu.eci.arsw.introWebsockets.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/*
Es sumamente necesaria esta clase porque Spring Boot no detecta automáticamente clases con @ServeEndpoint, por lo que este Bean rellena esa brecha
permitiendo que Spring registre correctamente los endpoints WebSocket.

Sin este bean, el endpoint no se activaría, y los clientes no podrían conectarse.
 */

@Component // Indica que la clase contiene definiciones de beans
@EnableScheduling // Activa el soporte de tareas programadas con las que se usa @Scheduled
public class WSConfigurator {

    /*
    @Bean: Registra este método com un Bean que se ejecuta al iniciar la aplicación.

    ServerEndpointExporter: Es un componente que escanea y registra automáticamente todos los endpoints de WebSocket anotados con @ServerEndpoint.
     */
    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }
}
