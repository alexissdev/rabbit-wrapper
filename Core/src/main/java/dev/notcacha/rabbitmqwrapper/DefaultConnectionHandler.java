package dev.notcacha.rabbitmqwrapper;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import dev.notcacha.rabbitmqwrapper.utils.Validate;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class DefaultConnectionHandler implements ConnectionHandler {

    private final Credentials credentials;

    private Connection rabbitConnection;

    public DefaultConnectionHandler(Credentials credentials) {
        this.credentials = credentials;
    }

    @Override
    public void connect() throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = ConnectionHandler.buildConnectionFactoryByCredentials(credentials);

        rabbitConnection = connectionFactory.newConnection(credentials.getConnectionName());
    }

    @Override
    public Connection getRabbitMqConnection() {
        return Validate.nonNull(rabbitConnection, "The Connection from RabbitMQ is not started!");
    }

    @Override
    public void close() throws IOException {
        if (!rabbitConnection.isOpen()) {
            return;
        }

        rabbitConnection.close();
    }

    public static class Builder implements ConnectionHandler.Builder {

        private String host;
        private int port;
        private String username;
        private String password;
        private String connectionName;

        public Builder() {
            host = "localhost";
            port = 5672;
            username = "root";
            password = "";
            connectionName = null;
        }

        @Override
        public ConnectionHandler.Builder host(String host) {
            this.host = Validate.nonNull(host, "Host credential from rabbitmq connection is null");

            return this;
        }

        @Override
        public ConnectionHandler.Builder port(int port) {
            this.port = port;

            return this;
        }

        @Override
        public ConnectionHandler.Builder username(String username) {
            this.username = Validate.nonNull(username, "Username credential from rabbitmq connection is null");

            return this;
        }

        @Override
        public ConnectionHandler.Builder password(String password) {
            this.password = Validate.nonNull(host, "Password credential from rabbitmq connection is null");

            return this;
        }

        @Override
        public ConnectionHandler.Builder connectionName(String connectionName) {
            this.connectionName = connectionName;

            return this;
        }

        @Override
        public ConnectionHandler build() {
            return new DefaultConnectionHandler(
                    new Credentials(
                            host,
                            port,
                            username,
                            password,
                            connectionName
                    )
            );
        }
    }

}
