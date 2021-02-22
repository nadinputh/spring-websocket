package net.kolabot.websocket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@SpringBootApplication
public class WebsocketApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebsocketApplication.class, args);
    }

    @GetMapping("/")
    public String welcome() {
        return "index";
    }

    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public String send(String message) {
        String time = new SimpleDateFormat("HH:mm").format(new Date());
        return time + " ==> " + message;
    }

}
