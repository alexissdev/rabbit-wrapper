package dev.notcacha.rabbitmqwrapper.example;

import com.rabbitmq.client.Channel;
import dev.notcacha.rabbitmqwrapper.ConnectionHandler;
import dev.notcacha.rabbitmqwrapper.channel.ChannelHandler;
import dev.notcacha.rabbitmqwrapper.channel.creator.ChannelCreator;
import dev.notcacha.rabbitmqwrapper.channel.creator.DefaultChannelCreator;
import dev.notcacha.rabbitmqwrapper.message.Message;
import dev.notcacha.rabbitmqwrapper.message.handler.DefaultMessageHandler;
import dev.notcacha.rabbitmqwrapper.message.handler.MessageHandler;
import dev.notcacha.rabbitmqwrapper.queue.DefaultQueueHandler;
import dev.notcacha.rabbitmqwrapper.queue.QueueHandler;
import dev.notcacha.rabbitmqwrapper.subscriber.DefaultSubscriberHandler;
import dev.notcacha.rabbitmqwrapper.subscriber.SubscriberHandler;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        ConnectionHandler connectionHandler = ConnectionHandler
                .builder()
                .host(
                        "your host..."
                )
                .port(
                        Integer.parseInt("your port...")
                )
                .username(
                        "your username..."
                )
                .password(
                        "your password..."
                )
                .build();

        MessageHandler messageHandler = new DefaultMessageHandler();
        ChannelCreator channelCreator = new DefaultChannelCreator(connectionHandler);
        QueueHandler queueHandler = new DefaultQueueHandler();
        SubscriberHandler subscriberHandler = new DefaultSubscriberHandler();

        Channel rabbitChannel = channelCreator.createRabbitMQChannel();
        queueHandler.register(rabbitChannel);
        subscriberHandler.subscribe(rabbitChannel, QueueHandler.DEFAULT_QUEUE, (a, b) -> {
            System.out.println(a);
            System.out.println(b);
        });

        messageHandler.send(
                Message.
                        builder()
                        .message(
                                "test"
                        )
                        .channel(
                                ChannelHandler
                                        .builder()
                                        .name(
                                                "test"
                                        )
                                        .rabbitMQChannel(
                                                rabbitChannel
                                        )
                                        .build()
                        )
                        .build()
        );
    }
}
