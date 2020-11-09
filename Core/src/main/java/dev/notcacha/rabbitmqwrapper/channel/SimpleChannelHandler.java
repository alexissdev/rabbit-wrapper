package dev.notcacha.rabbitmqwrapper.channel;

import com.rabbitmq.client.Channel;
import dev.notcacha.rabbitmqwrapper.utils.Validate;

public class SimpleChannelHandler implements ChannelHandler {

    private final String name;
    private final Channel rabbiMqChannel;

    public SimpleChannelHandler(String name, Channel rabbiMqChannel) {
        this.name = name;
        this.rabbiMqChannel = rabbiMqChannel;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public com.rabbitmq.client.Channel getRabbitMQChannel() {
        return rabbiMqChannel;
    }

    public static class Builder implements ChannelHandler.Builder {

        private String name;
        private Channel channel;

        public Builder() {
            this.name = null;
            this.channel = null;
        }

        @Override
        public ChannelHandler.Builder name(String name) {
            this.name = Validate.nonNull(name, "Name from Channel object is null!");

            return this;
        }

        @Override
        public ChannelHandler.Builder rabbitMQChannel(Channel rabbitMqChannel) {
            this.channel = Validate.nonNull(rabbitMqChannel, "RabbitMQ Channel from Channel object is null!");

            return this;
        }

        @Override
        public ChannelHandler build() {
            return new SimpleChannelHandler(name, channel);
        }
    }
}
