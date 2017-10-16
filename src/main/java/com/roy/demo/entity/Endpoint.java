package com.roy.demo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.Table;

@Table
public class Endpoint
{
    @Id
    private String id;
    @Column
    private String name;
    @Column
    private String version;

    public Endpoint(String id, String name, String version)
    {
        this.id = id;
        this.name = name;
        this.version = version;
    }

    public Endpoint()
    {}

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getVersion()
    {
        return version;
    }

    public void setVersion(String version)
    {
        this.version = version;
    }

    public String toString()
    {
        return this.id + " " + this.name + " " + this.version;
    }
}
