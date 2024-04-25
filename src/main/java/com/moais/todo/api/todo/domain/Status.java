package com.moais.todo.api.todo.domain;

public enum Status {
    TODO, ING, END, WAIT;

    public static Status of(String status) {
        for (Status s : Status.values()) {
            if (s.name().equals(status)) {
                return s;
            } else {
                throw new RuntimeException();
            }
        }
        throw new RuntimeException();
    }

}
