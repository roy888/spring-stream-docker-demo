CREATE KEYSPACE demo WITH replication = {'class':'SimpleStrategy', 'replication_factor':1};
USE demo;
CREATE TABLE endpoint (
  id text,
  name text,
  version text,
  PRIMARY KEY (id)
);
CREATE INDEX name_index ON endpoint (name);