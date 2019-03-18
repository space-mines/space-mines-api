CREATE TABLE player
(
  id         BIGINT PRIMARY KEY,
  username   VARCHAR(50) UNIQUE  NOT NULL,
  password   VARCHAR(50)         NOT NULL,
  email      VARCHAR(355) UNIQUE NOT NULL,
  game_id    BIGINT,

  FOREIGN KEY ("game_id") REFERENCES  "game" ("id")
);

INSERT INTO player(id, username, password, email)
VALUES (1, 'twcrone', '', 'twcrone@gmail.com');
