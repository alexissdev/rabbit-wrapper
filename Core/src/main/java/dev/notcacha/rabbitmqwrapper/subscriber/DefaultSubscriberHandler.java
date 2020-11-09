package dev.notcacha.rabbitmqwrapper.subscriber;

import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;

import java.io.IOException;

public class DefaultSubscriberHandler implements SubscriberHandler {

    @Override
    public void subscribe(Channel channel, String name, DeliverCallback deliverCallback, CancelCallback cancelCallback) throws IOException {
        channel.basicConsume(name, true, deliverCallback, cancelCallback);
    }
}
