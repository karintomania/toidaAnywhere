package com.example.line_bot_test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.linecorp.bot.model.event.Event;
import com.linecorp.bot.model.event.MessageEvent;
import com.linecorp.bot.model.event.message.TextMessageContent;
import com.linecorp.bot.model.message.Message;
import com.linecorp.bot.model.message.TextMessage;
import com.linecorp.bot.spring.boot.annotation.EventMapping;
import com.linecorp.bot.spring.boot.annotation.LineMessageHandler;

@SpringBootApplication
@LineMessageHandler
public class ToidaAnywhere {
	private final Logger log = LoggerFactory.getLogger(ToidaAnywhere.class);

    public static void main(String[] args) {
		SpringApplication.run(ToidaAnywhere.class, args);
    }

    @EventMapping
    public Message handleTextMessageEvent(MessageEvent<TextMessageContent> event) {
        log.info("event: " + event);
		final String originalMessageText = event.getMessage().getText();
        return new TextMessage(Toida.toidafy(originalMessageText));
    }

    @EventMapping
    public void handleDefaultMessageEvent(Event event) {
        System.out.println("Default event: " + event);
    }
}
