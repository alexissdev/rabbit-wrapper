package dev.notcacha.rabbitmqwrapper.message.handler;

import dev.notcacha.rabbitmqwrapper.message.Message;
import dev.notcacha.rabbitmqwrapper.queue.QueueHandler;

import java.io.IOException;

public interface MessageHandler {

    default void send(Message message) throws IOException {
        send(message, QueueHandler.DEFAULT_QUEUE);
    }

    void send(Message message, String queue) throws IOException;

}
