package com.moais.todo.conf.web;

import com.moais.todo.api.todo.domain.Status;
import org.springframework.core.convert.converter.Converter;

public class TodoStatusConverter implements Converter<String, Status> {

    @Override
    public Status convert(String source) {
        return Status.of(source);
    }

}
