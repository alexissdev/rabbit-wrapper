package dev.notcacha.rabbitmqwrapper.channel;

import com.rabbitmq.client.Channel;
import dev.notcacha.rabbitmqwrapper.buildable.Buildable;

public interface ChannelHandler {

    /**
     * @return name from channel
     */

    String getName();

    /**
     * @return RabbitMQ channel
     */

    Channel getRabbitMQChannel();

    interface Builder extends Buildable<ChannelHandler> {

        /**
         * Set name from channel
         *
         * @param name has been set
         */

        Builder name(String name);

        /**
         * Set RabbitMQ channel
         *
         * @param rabbitMqChannel has been set
         */

        Builder rabbitMQChannel(Channel rabbitMqChannel);

    }

    /**
     * @return {@link Builder} from create {@link ChannelHandler}
     */

    static Builder builder() {
        return new SimpleChannelHandler.Builder();
    }
}
