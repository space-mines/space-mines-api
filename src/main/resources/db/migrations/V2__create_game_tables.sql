CREATE SEQUENCE hibernate_sequence START 1;

DROP TABLE IF EXISTS "pod";
DROP TABLE IF EXISTS "sector";
DROP TABLE IF EXISTS "game";
DROP TABLE IF EXISTS "mine_field";

CREATE TABLE IF NOT EXISTS "mine_field"
(
  "id"   BIGINT PRIMARY KEY,
  "size" INTEGER NOT NULL
);

CREATE TABLE IF NOT EXISTS "sector"
(
  "id"            BIGINT PRIMARY KEY,
  "mine_field_id" BIGINT  NOT NULL,
  "x"             INTEGER NOT NULL,
  "y"             INTEGER NOT NULL,
  "z"             INTEGER NOT NULL,
  "radiation"     INTEGER DEFAULT 0,
  "mine"          BOOLEAN DEFAULT FALSE,

  FOREIGN KEY ("mine_field_id") REFERENCES "mine_field" ("id")
);

CREATE TABLE IF NOT EXISTS "game"
(
  "id"            BIGINT PRIMARY KEY,
  "mine_field_id" BIGINT NOT NULL,

  FOREIGN KEY ("mine_field_id") REFERENCES "mine_field" ("id")
);

CREATE TABLE IF NOT EXISTS "pod"
(
  "id"        BIGINT PRIMARY KEY,
  "game_id"   INTEGER NOT NULL,
  "x"         INTEGER NOT NULL,
  "y"         INTEGER NOT NULL,
  "z"         INTEGER NOT NULL,
  "radiation" INTEGER NOT NULL,
  "flagged"   BOOLEAN DEFAULT FALSE,

  FOREIGN KEY ("game_id") REFERENCES "game" ("id")
);

INSERT INTO mine_field(id, size)
VALUES (1, 3);

INSERT INTO sector(id, mine_field_id, x, y, z, mine)
VALUES (1, 1, 1, 1, 1, true);

INSERT INTO sector(id, mine_field_id, x, y, z, radiation) VALUES (2, 1, 0, 0, 0, 1);
INSERT INTO sector(id, mine_field_id, x, y, z, radiation) VALUES (3, 1, 0, 0, 1, 1);
INSERT INTO sector(id, mine_field_id, x, y, z, radiation) VALUES (4, 1, 0, 0, 2, 1);
INSERT INTO sector(id, mine_field_id, x, y, z, radiation) VALUES (5, 1, 0, 1, 0, 1);
INSERT INTO sector(id, mine_field_id, x, y, z, radiation) VALUES (6, 1, 0, 1, 1, 1);
INSERT INTO sector(id, mine_field_id, x, y, z, radiation) VALUES (7, 1, 0, 1, 2, 1);
INSERT INTO sector(id, mine_field_id, x, y, z, radiation) VALUES (8, 1, 0, 2, 0, 1);
INSERT INTO sector(id, mine_field_id, x, y, z, radiation) VALUES (9, 1, 0, 2, 1, 1);
INSERT INTO sector(id, mine_field_id, x, y, z, radiation) VALUES (10, 1, 0, 2, 2, 1);
INSERT INTO sector(id, mine_field_id, x, y, z, radiation) VALUES (11, 1, 1, 0, 0, 1);
INSERT INTO sector(id, mine_field_id, x, y, z, radiation) VALUES (12, 1, 1, 0, 1, 1);
INSERT INTO sector(id, mine_field_id, x, y, z, radiation) VALUES (13, 1, 1, 0, 2, 1);
INSERT INTO sector(id, mine_field_id, x, y, z, radiation) VALUES (14, 1, 1, 1, 0, 1);
INSERT INTO sector(id, mine_field_id, x, y, z, radiation) VALUES (16, 1, 1, 1, 2, 1);
INSERT INTO sector(id, mine_field_id, x, y, z, radiation) VALUES (17, 1, 1, 2, 0, 1);
INSERT INTO sector(id, mine_field_id, x, y, z, radiation) VALUES (18, 1, 1, 2, 1, 1);
INSERT INTO sector(id, mine_field_id, x, y, z, radiation) VALUES (19, 1, 1, 2, 2, 1);
INSERT INTO sector(id, mine_field_id, x, y, z, radiation) VALUES (20, 1, 2, 0, 0, 1);
INSERT INTO sector(id, mine_field_id, x, y, z, radiation) VALUES (21, 1, 2, 0, 1, 1);
INSERT INTO sector(id, mine_field_id, x, y, z, radiation) VALUES (22, 1, 2, 0, 2, 1);
INSERT INTO sector(id, mine_field_id, x, y, z, radiation) VALUES (23, 1, 2, 1, 0, 1);
INSERT INTO sector(id, mine_field_id, x, y, z, radiation) VALUES (24, 1, 2, 1, 1, 1);
INSERT INTO sector(id, mine_field_id, x, y, z, radiation) VALUES (25, 1, 2, 1, 2, 1);
INSERT INTO sector(id, mine_field_id, x, y, z, radiation) VALUES (26, 1, 2, 2, 0, 1);
INSERT INTO sector(id, mine_field_id, x, y, z, radiation) VALUES (27, 1, 2, 2, 1, 1);
INSERT INTO sector(id, mine_field_id, x, y, z, radiation) VALUES (28, 1, 2, 2, 2, 1);
