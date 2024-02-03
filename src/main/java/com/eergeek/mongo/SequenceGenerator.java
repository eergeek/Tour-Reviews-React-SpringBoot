package com.eergeek.mongo;

public class SequenceGenerator {
    private static long nextId = 0;

    public static long getNextId() {
        return ++nextId;
    }
}
