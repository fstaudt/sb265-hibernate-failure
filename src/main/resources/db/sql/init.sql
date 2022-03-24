CREATE TABLE users (
  id bigint NOT NULL,
  name VARCHAR(256) NOT NULL
);

CREATE UNIQUE INDEX users_1 on users (id);

INSERT INTO users (id, name) values (1, 'fstaudt');
