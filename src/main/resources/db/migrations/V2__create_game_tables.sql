CREATE SEQUENCE hibernate_sequence START 1;

DROP table if exists "player";
DROP TABLE IF EXISTS "pod";
DROP TABLE IF EXISTS "game";

CREATE TABLE IF NOT EXISTS "game"
(
  "id"        BIGINT PRIMARY KEY,
  "level_id"      BIGINT NOT NULL,

  FOREIGN KEY ("level_id") REFERENCES "level" ("id")
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
