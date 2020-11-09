package dev.notcacha.rabbitmqwrapper.message;

import dev.notcacha.rabbitmqwrapper.channel.ChannelHandler;
import dev.notcacha.rabbitmqwrapper.utils.Validate;

public class SimpleMessage implements Message {

    private final String message;
    private final ChannelHandler channelHandler;

    public SimpleMessage(String message, ChannelHandler channelHandler) {
        this.message = message;
        this.channelHandler = channelHandler;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public ChannelHandler getChannel() {
        return this.channelHandler;
    }


    public static class Builder implements Message.Builder {

        private String message;
        private ChannelHandler channelHandler;

        public Builder () {
            this.message = null;
            this.channelHandler = null;
        }

        @Override
        public Message.Builder message(String message) {
            this.message = Validate.nonNull(message, "Message from Message object is null!");

            return this;
        }

        @Override
        public Message.Builder channel(ChannelHandler channelHandler) {
            this.channelHandler = Validate.nonNull(channelHandler, "Channel from Message object is null!");

            return this;
        }

        @Override
        public Message build() {
            return new SimpleMessage(message, channelHandler);
        }
    }
}
