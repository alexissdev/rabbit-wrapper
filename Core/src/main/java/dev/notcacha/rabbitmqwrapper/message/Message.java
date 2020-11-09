package dev.notcacha.rabbitmqwrapper.message;

import dev.notcacha.rabbitmqwrapper.buildable.Buildable;
import dev.notcacha.rabbitmqwrapper.channel.ChannelHandler;

public interface Message {

    /**
     * @return message has been send
     */

    String getMessage();

    /**
     * @return channel instance from get rabbitmq channel and name
     */

    ChannelHandler getChannel();

    interface Builder extends Buildable<Message> {

        /**
         * Set message has been send
         *
         * @param message has been set
         */

        Builder message(String message);

        /**
         * Set channel
         *
         * @param channelHandler has been set
         */

        Builder channel(ChannelHandler channelHandler);

    }

    /**
     * @return {@link Builder} from create {@link Message}
     */

    static Builder builder() {
        return new SimpleMessage.Builder();
    }
}
