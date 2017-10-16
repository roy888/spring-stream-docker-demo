package com.roy.demo.controller;

import com.roy.demo.entity.Endpoint;
import com.roy.demo.repository.EndpointReactiveRepository;
import com.roy.demo.repository.EndpointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class EndpointController
{
    @Autowired
    private EndpointReactiveRepository reactiveRepository;

    @Autowired
    private EndpointRepository repository;

    //******************* spring data *******************
    @GetMapping("/endpoint/{id}")
    Endpoint findById(@PathVariable String id)
    {
        return repository.findById(id).get();
    }

    @GetMapping("/endpoint/name/{name}")
    Endpoint findByName(@PathVariable String name)
    {
        return repository.findByName(name);
    }

    //******************* reactive spring *******************
    @GetMapping("/x/endpoint/{id}")
    Mono<Endpoint> findByIdReact(@PathVariable String id)
    {
        return this.reactiveRepository.findById(id);
    }

    @GetMapping("/x/endpoints")
    Flux<Endpoint> findAll()
    {
        return this.reactiveRepository.findAll()
                .doOnNext(System.out::println);
    }
}
