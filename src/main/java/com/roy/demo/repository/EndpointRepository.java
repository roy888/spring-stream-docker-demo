package com.roy.demo.repository;

import com.roy.demo.entity.Endpoint;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface EndpointRepository extends CassandraRepository<Endpoint, String>
{
    Endpoint findByName(String name);
}
