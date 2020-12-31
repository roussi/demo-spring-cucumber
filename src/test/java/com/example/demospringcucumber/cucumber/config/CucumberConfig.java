package com.example.demospringcucumber.cucumber.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.DefaultDataTableCellTransformer;
import io.cucumber.java.DefaultDataTableEntryTransformer;
import io.cucumber.java.DefaultParameterTransformer;

import java.lang.reflect.Type;

/**
 * @author aroussi
 * @version %I% %G%
 */
public class CucumberConfig {

    private final ObjectMapper objectMapper;

    public CucumberConfig() {
        this.objectMapper = new ObjectMapper();
    }

    @DefaultDataTableCellTransformer
    @DefaultDataTableEntryTransformer
    @DefaultParameterTransformer
    public Object transform(Object source, Type destination) {
        return objectMapper.convertValue(source, objectMapper.constructType(destination));
    }
}
