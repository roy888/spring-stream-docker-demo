package com.roy.demo.repository;

import com.roy.demo.entity.Endpoint;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface EndpointReactiveRepository extends ReactiveCrudRepository<Endpoint, String> { }
