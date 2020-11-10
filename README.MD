# Simple RabbitMQ Wrapper from AstroCube DevCamp [click me](https://devcamp.astrocube.net/)

## Create instances

### Create [ConnectionHandler](https://github.com/cassha/rabbit-wrapper/blob/master/Core/src/main/java/dev/notcacha/rabbitmqwrapper/ConnectionHandler.java)

#### Using [Credentials](https://github.com/cassha/rabbit-wrapper/blob/master/Core/src/main/java/dev/notcacha/rabbitmqwrapper/Credentials.java)

````java
Credentials credentials = ...;
ConnectionHandler connection = new DefaultConnectionHandler(credentials);
````

````java
ConnectionHandler connectionHandler = ConnectionHandler
                .builder()
                .host(....) //your host
                .port(....) //your port...
                .username(....) //your username
                .password(....) //your password
                .build();
````

#### Create [MessageHandler](https://github.com/cassha/rabbit-wrapper/blob/master/Core/src/main/java/dev/notcacha/rabbitmqwrapper/message/handler/MessageHandler.java)
````java
MessageHandler messageHandler = new DefaultMessageHandler();
````

#### Create [ChannelCreator](https://github.com/cassha/rabbit-wrapper/blob/master/Core/src/main/java/dev/notcacha/rabbitmqwrapper/channel/creator/ChannelCreator.java)
````java
ConnectionHandler connectionHandler = ...;

ChannelCreator channelCreator = new DefaultChannelCreator(connectionHandler);
````

#### Create [QueueHandler](https://github.com/cassha/rabbit-wrapper/blob/master/Core/src/main/java/dev/notcacha/rabbitmqwrapper/queue/QueueHandler.java)
````java
QueueHandler queueHandler = new DefaultQueueHandler();
````

#### Create [SubscriberHandler](https://github.com/cassha/rabbit-wrapper/blob/master/Core/src/main/java/dev/notcacha/rabbitmqwrapper/subscriber/SubscriberHandler.java)
````java
SubscriberHandler subscriberHandler = new DefaultSubscriberHandler();
````

#### Create RabbitMQ Channel
````java
ChannelCreator channelCreator = ...;
Channel channel = channelCreator.createRabbitMQChannel();
````

#### Create [Message](https://github.com/cassha/rabbit-wrapper/blob/master/Core/src/main/java/dev/notcacha/rabbitmqwrapper/message/Message.java)
````java
Message.
    builder()
    .message("test")
    .channel(channel)
    .build();
````

## Usage instances

#### Register Queue
````java
QueueHandler queueHandler = ...;

queueHandler.register(rabbitChannel, queueName);
````

#### Register Durable Queue
````java
QueueHandler queueHandler = ...;

queueHandler.registerDurable(rabbitChannel, queueName);
````

#### Subscribe
````java
SubscriberHandler subscriberHandler = ...;

subscriberHandler.subscribe(rabbitChannel, queueName, (a, b) -> {
    ...;
});
````

#### MessageHandler
````java
MessageHandler messageHandler = ...;

messageHandler.send(messageObject, queueName);
````

### Finally

[Final example of how the library is used](https://github.com/cassha/rabbit-wrapper/blob/master/Example/src/main/java/dev/notcacha/rabbitmqwrapper/example/Main.java)

I want to make it clear that this library was simply for an [AstroCube](https://github.com/AstroCube) job, but as I liked the result I leave it in public
