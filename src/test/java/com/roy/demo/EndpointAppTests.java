package com.roy.demo;

import com.roy.demo.entity.Endpoint;
import com.roy.demo.repository.EndpointRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.stream.IntStream;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EndpointAppTests
{
    @Autowired
    private EndpointRepository repository;

    @Test
    public void createManyEndpoints()
    {
        IntStream.range(1, 100)
                .parallel()
                .mapToObj(i -> new Endpoint(String.valueOf(i), "some name" + i, "1.0"))
                .peek(System.out::println)
                .forEach(e -> repository.insert(e));
    }
}
