package dev.notcacha.rabbitmqwrapper.utils;

public interface Validate {

    static <T> T nonNull(T object) {
        return nonNull(object, "The object passed through the parameter is null!");
    }

    static <T> T nonNull(T object, String message) {
        if (object == null) {
            throw new NullPointerException(message);
        }

        return object;
    }
}
