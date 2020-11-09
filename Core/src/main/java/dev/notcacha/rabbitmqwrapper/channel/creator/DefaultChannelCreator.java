package dev.notcacha.rabbitmqwrapper.channel.creator;

import com.rabbitmq.client.Channel;
import dev.notcacha.rabbitmqwrapper.ConnectionHandler;
import dev.notcacha.rabbitmqwrapper.utils.Validate;

import java.io.IOException;

public class DefaultChannelCreator implements ChannelCreator {

    private final ConnectionHandler connectionHandler;

    public DefaultChannelCreator(ConnectionHandler connectionHandler) {
        this.connectionHandler = Validate.nonNull(connectionHandler, "RabbitMQ Connection is null, error from create Channel Creator!");
    }

    @Override
    public Channel createRabbitMQChannel() throws IOException {
        return connectionHandler.getRabbitMqConnection().createChannel();
    }
}
