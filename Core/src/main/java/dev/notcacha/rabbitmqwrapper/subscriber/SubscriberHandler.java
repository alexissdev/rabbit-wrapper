package dev.notcacha.rabbitmqwrapper.subscriber;

import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;

import java.io.IOException;

public interface SubscriberHandler {

    /**
     * @see SubscriberHandler#subscribe(Channel, String, DeliverCallback, CancelCallback)
     */

    default void subscribe(Channel channel, String name, DeliverCallback deliverCallback) throws IOException {
        subscribe(channel, name, deliverCallback, cancelCallback -> {
        });
    }

    /**
     * Subscribe from RabbitMQ Channel
     *
     * @param channel         has been subscribed
     * @param name            from queue
     * @param deliverCallback action from callback
     * @param cancelCallback  action from cancel callback
     * @throws IOException if there is an error when trying to subscribe to the rabbitmq channel it will throw this exception
     */

    void subscribe(Channel channel, String name, DeliverCallback deliverCallback, CancelCallback cancelCallback) throws IOException;
}
