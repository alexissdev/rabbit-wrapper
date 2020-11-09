package dev.notcacha.rabbitmqwrapper;

public class Credentials {

    private final String host;
    private final int port;
    private final String username;
    private final String password;

    private final String connectionName;

    public Credentials(String host, int port, String username, String password, String connectionName) {
        this.host = host;
        this.port = port;
        this.username = username;
        this.password = password;
        this.connectionName = connectionName;
    }

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getConnectionName() {
        return connectionName;
    }
}
