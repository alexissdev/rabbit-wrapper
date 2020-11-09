package dev.notcacha.rabbitmqwrapper.queue;

import com.rabbitmq.client.Channel;

import java.io.IOException;

public class DefaultQueueHandler implements QueueHandler {

    @Override
    public void register(Channel channel, String name) throws IOException {
        channel.queueDeclare(name, false, false, false, null);
    }

    @Override
    public void registerDurable(Channel channel, String name) throws IOException {
        channel.queueDeclare(name, true, false, false, null);
    }
}
