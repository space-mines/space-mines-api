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
  "radiation" INTEGER DEFAULT -1,
  "flagged"   BOOLEAN DEFAULT FALSE,

  FOREIGN KEY ("game_id") REFERENCES "game" ("id")
);

INSERT INTO mine_field(id, size)
VALUES (1, 3);

INSERT INTO sector(id, mine_field_id, x, y, z, radiation, mine) VALUES (1, 1, 0, 0, 0, 2147483647, true);
INSERT INTO sector(id, mine_field_id, x, y, z, radiation, mine) VALUES (2, 1, 0, 0, 1, 1, false);
INSERT INTO sector(id, mine_field_id, x, y, z, radiation, mine) VALUES (3, 1, 0, 0, 2, 0, false);
INSERT INTO sector(id, mine_field_id, x, y, z, radiation, mine) VALUES (4, 1, 0, 1, 0, 1, false);
INSERT INTO sector(id, mine_field_id, x, y, z, radiation, mine) VALUES (5, 1, 0, 1, 1, 1, false);
INSERT INTO sector(id, mine_field_id, x, y, z, radiation, mine) VALUES (6, 1, 0, 1, 2, 0, false);
INSERT INTO sector(id, mine_field_id, x, y, z, radiation, mine) VALUES (7, 1, 0, 2, 0, 0, false);
INSERT INTO sector(id, mine_field_id, x, y, z, radiation, mine) VALUES (8, 1, 0, 2, 1, 0, false);
INSERT INTO sector(id, mine_field_id, x, y, z, radiation, mine) VALUES (9, 1, 0, 2, 2, 0, false);
INSERT INTO sector(id, mine_field_id, x, y, z, radiation, mine) VALUES (10, 1, 1, 0, 0, 1, false);
INSERT INTO sector(id, mine_field_id, x, y, z, radiation, mine) VALUES (11, 1, 1, 0, 1, 1, false);
INSERT INTO sector(id, mine_field_id, x, y, z, radiation, mine) VALUES (12, 1, 1, 0, 2, 0, false);
INSERT INTO sector(id, mine_field_id, x, y, z, radiation, mine) VALUES (13, 1, 1, 1, 0, 1, false);
INSERT INTO sector(id, mine_field_id, x, y, z, radiation, mine) VALUES (14, 1, 1, 1, 1, 1, false);
INSERT INTO sector(id, mine_field_id, x, y, z, radiation, mine) VALUES (15, 1, 1, 1, 2, 0, false);
INSERT INTO sector(id, mine_field_id, x, y, z, radiation, mine) VALUES (16, 1, 1, 2, 0, 0, false);
INSERT INTO sector(id, mine_field_id, x, y, z, radiation, mine) VALUES (17, 1, 1, 2, 1, 0, false);
INSERT INTO sector(id, mine_field_id, x, y, z, radiation, mine) VALUES (18, 1, 1, 2, 2, 0, false);
INSERT INTO sector(id, mine_field_id, x, y, z, radiation, mine) VALUES (19, 1, 2, 0, 0, 0, false);
INSERT INTO sector(id, mine_field_id, x, y, z, radiation, mine) VALUES (20, 1, 2, 0, 1, 0, false);
INSERT INTO sector(id, mine_field_id, x, y, z, radiation, mine) VALUES (21, 1, 2, 0, 2, 0, false);
INSERT INTO sector(id, mine_field_id, x, y, z, radiation, mine) VALUES (22, 1, 2, 1, 0, 0, false);
INSERT INTO sector(id, mine_field_id, x, y, z, radiation, mine) VALUES (23, 1, 2, 1, 1, 0, false);
INSERT INTO sector(id, mine_field_id, x, y, z, radiation, mine) VALUES (24, 1, 2, 1, 2, 0, false);
INSERT INTO sector(id, mine_field_id, x, y, z, radiation, mine) VALUES (25, 1, 2, 2, 0, 0, false);
INSERT INTO sector(id, mine_field_id, x, y, z, radiation, mine) VALUES (26, 1, 2, 2, 1, 0, false);
INSERT INTO sector(id, mine_field_id, x, y, z, radiation, mine) VALUES (27, 1, 2, 2, 2, 0, false);