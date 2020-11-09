package dev.notcacha.rabbitmqwrapper.channel.creator;

import com.rabbitmq.client.Channel;

import java.io.IOException;

public interface ChannelCreator {

    /**
     * Create RabbitMQ channel
     *
     * @return new {@link Channel} instance
     */

    Channel createRabbitMQChannel() throws IOException;
}
