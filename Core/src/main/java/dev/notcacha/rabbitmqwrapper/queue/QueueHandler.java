package dev.notcacha.rabbitmqwrapper.queue;

import com.rabbitmq.client.Channel;

import java.io.IOException;

public interface QueueHandler {

    String DEFAULT_QUEUE = "default";

    /**
     * @see QueueHandler#register(Channel, String)
     */

    default void register(Channel channel) throws IOException {
        register(channel, DEFAULT_QUEUE);
    }

    /**
     * Register a non-durable RabbitMQ cake
     *
     * @param channel where the queue will be declared
     * @param name    from queue
     * @throws IOException RabbitMQ throws this exception in case there is an error when declaring the queue
     */

    void register(Channel channel, String name) throws IOException;

    /**
     * @see QueueHandler#registerDurable(Channel, String)
     */

    default void registerDurable(Channel channel) throws IOException {
        registerDurable(channel, DEFAULT_QUEUE);
    }

    /**
     * Register a durable queue
     *
     * @see QueueHandler#register(Channel, String)
     */

    void registerDurable(Channel channel, String name) throws IOException;
}
