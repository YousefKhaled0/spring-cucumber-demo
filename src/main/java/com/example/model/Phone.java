package com.example.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@ToString
public class Phone {

    @Id
    private String id = UUID.randomUUID().toString();

    @Field(name = "brand")
    private String brand;

    @Field(name = "model")
    private String model;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS+00:00", shape = JsonFormat.Shape.STRING)
    private LocalDateTime cratedAt = LocalDateTime.now();

}
