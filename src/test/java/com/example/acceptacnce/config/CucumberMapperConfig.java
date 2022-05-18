package com.example.acceptacnce.config;

import io.cucumber.java.DefaultDataTableCellTransformer;
import io.cucumber.java.DefaultDataTableEntryTransformer;
import io.cucumber.java.DefaultParameterTransformer;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;

import java.lang.reflect.Type;

public class CucumberMapperConfig {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    @DefaultDataTableCellTransformer
    @DefaultDataTableEntryTransformer
    @DefaultParameterTransformer
    public Object transform(Object object, Type to) {
        return MAPPER.convertValue(object, MAPPER.constructType(to));
    }


}
