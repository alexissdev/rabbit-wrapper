package dev.notcacha.rabbitmqwrapper.message.handler;

import dev.notcacha.rabbitmqwrapper.message.Message;

import java.io.IOException;

public class DefaultMessageHandler implements MessageHandler {

    @Override
    public void send(Message message, String queue) throws IOException {
        com.rabbitmq.client.Channel channel = message.getChannel().getRabbitMQChannel();

        channel.basicPublish(message.getMessage(), queue, null, message.getMessage().getBytes());
    }


}
