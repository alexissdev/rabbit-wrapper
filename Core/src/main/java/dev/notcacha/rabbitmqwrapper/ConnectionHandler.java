package dev.notcacha.rabbitmqwrapper;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import dev.notcacha.rabbitmqwrapper.buildable.Buildable;
import dev.notcacha.rabbitmqwrapper.utils.Validate;

import java.io.Closeable;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

public interface ConnectionHandler extends Closeable {

    /**
     * Create connection from rabbitMQ
     */

    void connect() throws IOException, TimeoutException;

    /**
     * @return connection from rabbitMQ
     */

    Connection getRabbitMqConnection();

    /**
     * @return new {@link ConnectionFactory} using {@link Credentials} from create
     */

    static ConnectionFactory buildConnectionFactoryByCredentials(Credentials credentials) {
        Validate.nonNull(credentials, "The Credentials is null!");

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(credentials.getHost());
        factory.setPort(credentials.getPort());
        factory.setUsername(credentials.getUsername());
        factory.setPassword(credentials.getPassword());

        return factory;
    }

    interface Builder extends Buildable<ConnectionHandler> {

        /**
         * Set host from connection
         *
         * @param host has been set
         */

        Builder host(String host);

        /**
         * Set port from connection
         *
         * @param port has been set
         */

        Builder port(int port);

        /**
         * Set username from connection
         *
         * @param username has been set
         */

        Builder username(String username);

        /**
         * Set password from connection
         *
         * @param password has been set
         */

        Builder password(String password);

        /**
         * Set connection name from connection
         *
         * @param connectionName has been set
         */

        Builder connectionName(String connectionName);

    }

    /**
     * @return {@link Builder} from create {@link ConnectionHandler}
     */

    static Builder builder() {
        return new DefaultConnectionHandler.Builder();
    }
}
